package org.sqlproc.dsl.resolver;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.BatchUpdateException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.Driver;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EObject;
import org.sqlproc.dsl.property.ModelProperty;
import org.sqlproc.dsl.property.ModelPropertyBean;

import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
public class DbResolverBean implements DbResolver {

    private boolean debug = false;
    private boolean trace = false;

    public static class DatabaseDirectives {
        public String dbDriver;
        public String dbUrl;
        public String dbUsername;
        public String dbPassword;
        public String dbCatalog;
        public String dbSchema;
        public String dbSqlsBefore;
        public String dbSqlsAfter;
        public String dbIndexTypes;
        public boolean dbSkipIndexes;
        public boolean dbSkipProcedures;
        public boolean dbSkipCheckConstraints;
        public boolean dbTakeComments;
        public boolean dbLowercaseNames;
        public boolean dbUppercaseNames;
        public DbType dbType;
        public String dir;
        public Connection connection;
        boolean doReconnect;
        public List<String> ddlsBefore0;
        public List<String> ddlsBefore1;
        public List<String> ddlsAfter;
        public Set<Short> indexTypes;

        @Override
        public String toString() {
            return "DatabaseValues [dbDriver=" + dbDriver + ", dbUrl=" + dbUrl + ", dbUsername=" + dbUsername
                    + ", dbPassword=" + dbPassword + ", dbCatalog=" + dbCatalog + ", dbSchema=" + dbSchema
                    + ", dbSqlsBefore=" + dbSqlsBefore + ", dbSqlsAfter=" + dbSqlsAfter + ", connection=" + connection
                    + ", dbIndexTypes=" + dbIndexTypes + ", dbSkipIndexes=" + dbSkipIndexes + ", dbSkipProcedures="
                    + dbSkipProcedures + ", dbSkipCheckConstraints=" + dbSkipCheckConstraints + ", dbTakeComments="
                    + dbTakeComments + ", dbLowercaseNames=" + dbLowercaseNames + ", dbUppercaseNames="
                    + dbUppercaseNames + ", dbType=" + dbType + ", dir=" + dir + "]";
        }

    }

    @Inject
    ModelProperty modelProperty;

    @Inject
    PojoResolverFactory pojoResolverFactory;

    protected Logger LOGGER = Logger.getLogger(DbResolverBean.class);

    private final Object sync = new Object();

    private final Map<String, DatabaseDirectives> connections = Collections
            .synchronizedMap(new HashMap<String, DatabaseDirectives>());

    private final Map<String, List<String>> catalogs = Collections.synchronizedMap(new HashMap<String, List<String>>());
    private final Map<String, List<String>> schemas = Collections.synchronizedMap(new HashMap<String, List<String>>());
    private final Map<String, List<String>> tables = Collections.synchronizedMap(new HashMap<String, List<String>>());
    private final Map<String, List<String>> procedures = Collections
            .synchronizedMap(new HashMap<String, List<String>>());
    private final Map<String, List<String>> functions = Collections
            .synchronizedMap(new HashMap<String, List<String>>());
    private final Map<String, List<String>> checkConstraints = Collections
            .synchronizedMap(new HashMap<String, List<String>>());
    private final Map<String, Map<String, List<String>>> columns = Collections
            .synchronizedMap(new HashMap<String, Map<String, List<String>>>());
    private final Map<String, Map<String, List<String>>> checkColumns = Collections
            .synchronizedMap(new HashMap<String, Map<String, List<String>>>());
    private final Map<String, Map<String, List<String>>> procColumns = Collections
            .synchronizedMap(new HashMap<String, Map<String, List<String>>>());
    private final Map<String, Map<String, List<String>>> funColumns = Collections
            .synchronizedMap(new HashMap<String, Map<String, List<String>>>());
    private final Map<String, Map<String, List<DbTable>>> dbTables = Collections
            .synchronizedMap(new HashMap<String, Map<String, List<DbTable>>>());
    private final Map<String, Map<String, List<DbColumn>>> dbColumns = Collections
            .synchronizedMap(new HashMap<String, Map<String, List<DbColumn>>>());
    private final Map<String, Map<String, List<DbTable>>> dbProcedures = Collections
            .synchronizedMap(new HashMap<String, Map<String, List<DbTable>>>());
    private final Map<String, Map<String, List<DbColumn>>> dbProcColumns = Collections
            .synchronizedMap(new HashMap<String, Map<String, List<DbColumn>>>());
    private final Map<String, Map<String, List<DbTable>>> dbFunctions = Collections
            .synchronizedMap(new HashMap<String, Map<String, List<DbTable>>>());
    private final Map<String, Map<String, List<DbColumn>>> dbFunColumns = Collections
            .synchronizedMap(new HashMap<String, Map<String, List<DbColumn>>>());
    private final Map<String, Map<String, List<String>>> dbPrimaryKeys = Collections
            .synchronizedMap(new HashMap<String, Map<String, List<String>>>());
    private final Map<String, Map<String, List<DbExport>>> dbExports = Collections
            .synchronizedMap(new HashMap<String, Map<String, List<DbExport>>>());
    private final Map<String, Map<String, List<DbImport>>> dbImports = Collections
            .synchronizedMap(new HashMap<String, Map<String, List<DbImport>>>());
    private final Map<String, Map<String, List<DbIndex>>> dbIndexes = Collections
            .synchronizedMap(new HashMap<String, Map<String, List<DbIndex>>>());
    private final Map<String, List<String>> dbSequences = Collections
            .synchronizedMap(new HashMap<String, List<String>>());
    private final Map<String, SortedSet<String>> driverMethods = Collections
            .synchronizedMap(new HashMap<String, SortedSet<String>>());
    private final Map<String, Map<String, List<DbCheckConstraint>>> dbChecksConstraints = Collections
            .synchronizedMap(new HashMap<String, Map<String, List<DbCheckConstraint>>>());
    private final Map<String, Map<String, String>> dbOriginalNames = Collections
            .synchronizedMap(new HashMap<String, Map<String, String>>());

    private DatabaseDirectives checkReconnect(EObject model) {
        trace(">>>checkReconnect");
        if (model == null)
            return null;
        ModelPropertyBean.ModelValues modelModelValues = modelProperty.getModelValues(model);
        DatabaseDirectives modelDatabaseValues = connections.get(modelModelValues.dir);
        if (modelDatabaseValues == null) {
            modelDatabaseValues = new DatabaseDirectives();
            modelDatabaseValues.dir = modelModelValues.dir;
            connections.put(modelModelValues.dir, modelDatabaseValues);
        }

        if (!modelModelValues.doResolveDb) {
            trace("DB CLOSE");
            closeConnection(modelDatabaseValues);
            return null;
        }

        modelDatabaseValues.doReconnect = (modelDatabaseValues.connection != null) ? false : true;

        if (modelModelValues.dbDebugLevel != null && Level.DEBUG.isGreaterOrEqual(modelModelValues.dbDebugLevel)) {
            debug = true;
        } else {
            debug = false;
        }
        if (modelModelValues.dbDebugLevel != null && Level.TRACE.isGreaterOrEqual(modelModelValues.dbDebugLevel)) {
            trace = true;
        } else {
            trace = false;
        }

        if (modelModelValues.dbDriver != null) {
            if (!modelModelValues.dbDriver.equals(modelDatabaseValues.dbDriver)) {
                modelDatabaseValues.dbDriver = modelModelValues.dbDriver;
                modelDatabaseValues.doReconnect = true;
            }
        } else {
            modelDatabaseValues.dbDriver = null;
            closeConnection(modelDatabaseValues);
            return null;
        }
        if (modelModelValues.dbUrl != null) {
            if (!modelModelValues.dbUrl.equals(modelDatabaseValues.dbUrl)) {
                modelDatabaseValues.dbUrl = modelModelValues.dbUrl;
                modelDatabaseValues.doReconnect = true;
            }
        } else {
            modelDatabaseValues.dbUrl = null;
            closeConnection(modelDatabaseValues);
            return null;
        }

        if (modelModelValues.dbUsername != null) {
            if (!modelModelValues.dbUsername.equals(modelDatabaseValues.dbUsername)) {
                modelDatabaseValues.dbUsername = modelModelValues.dbUsername;
                modelDatabaseValues.doReconnect = true;
            }
        } else {
            modelDatabaseValues.dbUsername = null;
            closeConnection(modelDatabaseValues);
            return null;
        }
        if (modelModelValues.dbPassword != null) {
            if (!modelModelValues.dbPassword.equals(modelDatabaseValues.dbPassword)) {
                modelDatabaseValues.dbPassword = modelModelValues.dbPassword;
                modelDatabaseValues.doReconnect = true;
            }
        } else {
            modelDatabaseValues.dbPassword = null;
            closeConnection(modelDatabaseValues);
            return null;
        }
        if (modelModelValues.dbCatalog != null) {
            if (!modelModelValues.dbCatalog.equals(modelDatabaseValues.dbCatalog)) {
                modelDatabaseValues.dbCatalog = modelModelValues.dbCatalog;
                modelDatabaseValues.doReconnect = true;
            }
        } else
            modelDatabaseValues.dbCatalog = null;
        if (modelModelValues.dbSchema != null) {
            if (!modelModelValues.dbSchema.equals(modelDatabaseValues.dbSchema)) {
                modelDatabaseValues.dbSchema = modelModelValues.dbSchema;
                modelDatabaseValues.doReconnect = true;
            }
        } else
            modelDatabaseValues.dbSchema = null;
        if (modelModelValues.dbSqlsBefore != null) {
            if (!modelModelValues.dbSqlsBefore.equals(modelDatabaseValues.dbSqlsBefore)) {
                modelDatabaseValues.dbSqlsBefore = modelModelValues.dbSqlsBefore;
            }
        } else
            modelDatabaseValues.dbSqlsBefore = null;
        if (modelModelValues.dbSqlsAfter != null) {
            if (!modelModelValues.dbSqlsAfter.equals(modelDatabaseValues.dbSqlsAfter)) {
                modelDatabaseValues.dbSqlsAfter = modelModelValues.dbSqlsAfter;
            }
        } else
            modelDatabaseValues.dbSqlsAfter = null;
        if (modelModelValues.dbIndexTypes != null) {
            if (!modelModelValues.dbIndexTypes.equals(modelDatabaseValues.dbIndexTypes)) {
                modelDatabaseValues.dbIndexTypes = modelModelValues.dbIndexTypes;
                String[] ss = modelModelValues.dbIndexTypes.split(",");
                modelDatabaseValues.indexTypes = new HashSet<Short>();
                for (String s : ss) {
                    if (s.trim().length() > 0) {
                        try {
                            Short type = Short.parseShort(s.trim());
                            modelDatabaseValues.indexTypes.add(type);
                        } catch (NumberFormatException ignore) {
                        }
                    }
                }
            }
        } else {
            modelDatabaseValues.dbIndexTypes = null;
            modelDatabaseValues.indexTypes = new HashSet<Short>();
            modelDatabaseValues.indexTypes.add((short) 1);
            modelDatabaseValues.indexTypes.add((short) 3);
        }
        if (modelModelValues.dbSkipIndexes != modelDatabaseValues.dbSkipIndexes) {
            modelDatabaseValues.dbSkipIndexes = modelModelValues.dbSkipIndexes;
        }
        if (modelModelValues.dbSkipCheckConstraints != modelDatabaseValues.dbSkipCheckConstraints) {
            modelDatabaseValues.dbSkipCheckConstraints = modelModelValues.dbSkipCheckConstraints;
        }
        if (modelModelValues.dbSkipProcedures != modelDatabaseValues.dbSkipProcedures) {
            modelDatabaseValues.dbSkipProcedures = modelModelValues.dbSkipProcedures;
        }
        if (modelModelValues.dbTakeComments != modelDatabaseValues.dbTakeComments) {
            modelDatabaseValues.dbTakeComments = modelModelValues.dbTakeComments;
        }
        if (modelModelValues.dbLowercaseNames != modelDatabaseValues.dbLowercaseNames) {
            modelDatabaseValues.dbLowercaseNames = modelModelValues.dbLowercaseNames;
        }
        if (modelModelValues.dbUppercaseNames != modelDatabaseValues.dbUppercaseNames) {
            modelDatabaseValues.dbUppercaseNames = modelModelValues.dbUppercaseNames;
        }
        if (modelModelValues.dbType != null) {
            if (modelDatabaseValues.dbType == null
                    || !modelModelValues.dbType.equals(modelDatabaseValues.dbType.getValue())) {
                modelDatabaseValues.dbType = DbType.fromValue(modelModelValues.dbType);
            }
        } else {
            modelDatabaseValues.dbType = null;
        }
        trace("DB RECONNECT " + modelDatabaseValues.doReconnect);
        return modelDatabaseValues;
    }

    private DatabaseDirectives getConnection(EObject model) {
        trace(">>>getConnection");
        DatabaseDirectives modelDatabaseValues = checkReconnect(model);
        if (modelDatabaseValues == null)
            return null;
        if (!modelDatabaseValues.doReconnect)
            return modelDatabaseValues;
        closeConnection(modelDatabaseValues);
        trace("DB OPEN");
        synchronized (sync) {
            trace("DATA START FOR " + modelDatabaseValues.dir);
            Class<?> driverClass = pojoResolverFactory.getPojoResolver().loadClass(modelDatabaseValues.dbDriver);
            trace("DATA DRIVER " + driverClass);
            if (driverClass != null && Driver.class.isAssignableFrom(driverClass)) {
                try {
                    Driver driver = (Driver) driverClass.newInstance();
                    Properties props = new Properties();
                    props.setProperty("user", modelDatabaseValues.dbUsername);
                    props.setProperty("password", modelDatabaseValues.dbPassword);
                    String dbUrl = modelDatabaseValues.dbUrl.replaceAll("\\\\/", "/").replaceAll("\\\\/", "/")
                            .replaceAll("\\\\;", ";").replaceAll("\\\\.", ".");
                    modelDatabaseValues.connection = driver.connect(dbUrl, props);
                    trace("DB URL " + dbUrl);
                    trace("DATA CONNECTION " + modelDatabaseValues.connection);

                    if (modelDatabaseValues.dbSqlsBefore != null
                            && modelDatabaseValues.dbSqlsBefore.trim().length() > 0) {
                        InputStream is = pojoResolverFactory.getPojoResolver().getFile(model,
                                modelDatabaseValues.dbSqlsBefore.trim());
                        List<String> ddls = loadDDL(is);
                        modelDatabaseValues.ddlsBefore0 = new ArrayList<String>();
                        modelDatabaseValues.ddlsBefore1 = new ArrayList<String>();
                        boolean inDrop = true;
                        for (String ddl : ddls) {
                            if (inDrop && !ddl.toUpperCase().trim().startsWith("DROP"))
                                inDrop = false;
                            if (inDrop)
                                modelDatabaseValues.ddlsBefore0.add(ddl);
                            else
                                modelDatabaseValues.ddlsBefore1.add(ddl);
                        }

                        try {
                            runDDLs(modelDatabaseValues.connection, modelDatabaseValues.ddlsBefore0, "BEFORE");
                        } catch (SQLException e) {
                            error("getConnection error " + e, e);
                        }
                        runDDLs(modelDatabaseValues.connection, modelDatabaseValues.ddlsBefore1, "BEFORE");
                    }
                    if (modelDatabaseValues.dbSqlsAfter != null && modelDatabaseValues.dbSqlsAfter.trim().length() > 0) {
                        InputStream is = pojoResolverFactory.getPojoResolver().getFile(model,
                                modelDatabaseValues.dbSqlsAfter.trim());
                        modelDatabaseValues.ddlsAfter = loadDDL(is);
                    }
                } catch (InstantiationException e) {
                    error("getConnection error " + e, e);
                } catch (IllegalAccessException e) {
                    error("getConnection error " + e, e);
                } catch (SQLException e) {
                    error("getConnection error " + e, e);
                } catch (RuntimeException e) {
                    e.printStackTrace();
                    throw e;
                }
            }
            return modelDatabaseValues;
        }
    }

    private void closeConnection(DatabaseDirectives modelDatabaseValues) {
        trace(">>>closeConnection");
        synchronized (sync) {
            try {
                if (modelDatabaseValues.connection != null) {
                    if (modelDatabaseValues.ddlsAfter != null)
                        runDDLs(modelDatabaseValues.connection, modelDatabaseValues.ddlsAfter, "AFTER");

                    trace("DATA STOP FOR " + modelDatabaseValues.dir);
                    modelDatabaseValues.connection.close();
                }
            } catch (SQLException e) {
                error("closeConnection error " + e, e);
            }
            modelDatabaseValues.connection = null;
            modelDatabaseValues.ddlsBefore0 = null;
            modelDatabaseValues.ddlsBefore1 = null;
            modelDatabaseValues.ddlsAfter = null;
            catalogs.remove(modelDatabaseValues.dir);
            schemas.remove(modelDatabaseValues.dir);
            tables.remove(modelDatabaseValues.dir);
            columns.remove(modelDatabaseValues.dir);
            procColumns.remove(modelDatabaseValues.dir);
            funColumns.remove(modelDatabaseValues.dir);
            dbTables.remove(modelDatabaseValues.dir);
            dbColumns.remove(modelDatabaseValues.dir);
            dbProcedures.remove(modelDatabaseValues.dir);
            dbProcColumns.remove(modelDatabaseValues.dir);
            dbFunctions.remove(modelDatabaseValues.dir);
            dbFunColumns.remove(modelDatabaseValues.dir);
            dbPrimaryKeys.remove(modelDatabaseValues.dir);
            dbExports.remove(modelDatabaseValues.dir);
            dbImports.remove(modelDatabaseValues.dir);
            dbIndexes.remove(modelDatabaseValues.dir);
            dbSequences.remove(modelDatabaseValues.dir);
            driverMethods.remove(modelDatabaseValues.dir);
            procedures.remove(modelDatabaseValues.dir);
            functions.remove(modelDatabaseValues.dir);
            dbChecksConstraints.remove(modelDatabaseValues.dir);
        }
    }

    private void runDDLs(Connection connection, List<String> ddls, String msg) throws SQLException {
        trace(">>>runDDLs");

        if (ddls == null || ddls.isEmpty())
            return;

        trace("Run DDLs " + msg + ", number of statements is " + ddls.size());

        Statement stmt = null;
        int[] result = null;

        try {
            stmt = connection.createStatement();
            for (int i = 0, n = ddls.size(); i < n; i++) {
                String ddl = ddls.get(i);
                if (ddl == null)
                    continue;
                trace("DB DDL " + ddl);
                stmt.addBatch(ddl);
            }
            result = stmt.executeBatch();

        } catch (BatchUpdateException e) {
            error("Run DDLs chyba " + e, e);

        } finally {
            if (stmt != null)
                stmt.close();
        }

        trace("Run DDLs OK for " + ((result != null) ? result.length : -1));
    }

    private List<String> loadDDL(InputStream is) {
        trace(">>>loadDDL");
        BufferedReader bfr = null;
        List<String> ddls = new ArrayList<String>();

        if (is == null)
            return ddls;

        try {
            bfr = new BufferedReader(new InputStreamReader(is));
            StringBuilder completeLine = new StringBuilder("");
            String line;
            boolean inFuncOrProc = false;
            while ((line = bfr.readLine()) != null) {
                if (line.startsWith("--"))
                    continue;
                if (line.trim().length() > 0)
                    completeLine.append(" ").append(line);
                if (!inFuncOrProc && line.trim().toUpperCase().startsWith("CREATE")
                        && (line.indexOf("FUNCTION") >= 0 || line.indexOf("PROCEDURE") >= 0))
                    inFuncOrProc = true;
                boolean finishedDdl = false;
                if (!inFuncOrProc && line.trim().endsWith(";")) {
                    finishedDdl = true;
                } else if (line.trim().length() == 0) {
                    finishedDdl = true;
                }
                if (finishedDdl) {
                    if (completeLine.length() > 0)
                        ddls.add(completeLine.toString());
                    completeLine = new StringBuilder("");
                    inFuncOrProc = false;
                }
            }
            if (completeLine.length() > 0)
                ddls.add(completeLine.toString());
            return ddls;

        } catch (Exception ex) {
            error("loadDDL error", ex);
            return ddls;
        } finally {
            if (bfr != null) {
                try {
                    bfr.close();
                } catch (Exception ignore) {
                }
            }
        }
    }

    @Override
    public boolean isResolveDb(EObject model) {
        trace(">>>isResolveDb");
        return getConnection(model) != null;
    }

    @Override
    public DatabaseDirectives getDatabaseDirectives(EObject model) {
        trace(">>>getDatabaseDirectives");
        return getConnection(model);
    }

    @Override
    public List<String> getCatalogs(EObject model) {
        debug(">>>getCatalogs");
        DatabaseDirectives modelDatabaseValues = getConnection(model);
        if (modelDatabaseValues == null)
            return Collections.emptyList();
        List<String> catalogsForModel = catalogs.get(modelDatabaseValues.dir);
        if (catalogsForModel != null)
            return catalogsForModel;
        catalogsForModel = Collections.synchronizedList(new ArrayList<String>());
        catalogs.put(modelDatabaseValues.dir, catalogsForModel);
        if (modelDatabaseValues.connection != null) {
            ResultSet result = null;
            try {
                DatabaseMetaData meta = modelDatabaseValues.connection.getMetaData();
                result = meta.getCatalogs();
                while (result.next()) {
                    catalogsForModel.add(name(modelDatabaseValues, result.getString("TABLE_CAT")));
                }
            } catch (SQLException e) {
                error("getCatalogs error " + e, e);
            } finally {
                try {
                    if (result != null)
                        result.close();
                } catch (SQLException e) {
                    error("getCatalogs error " + e, e);
                }
            }
        }
        debug("<<<getCatalogs", catalogsForModel);
        return catalogsForModel;
    }

    @Override
    public List<String> getSchemas(EObject model) {
        debug(">>>getSchemas");
        DatabaseDirectives modelDatabaseValues = getConnection(model);
        if (modelDatabaseValues == null)
            return Collections.emptyList();
        List<String> schemasForModel = schemas.get(modelDatabaseValues.dir);
        if (schemasForModel != null)
            return schemasForModel;
        schemasForModel = Collections.synchronizedList(new ArrayList<String>());
        schemas.put(modelDatabaseValues.dir, schemasForModel);
        if (modelDatabaseValues.connection != null) {
            ResultSet result = null;
            try {
                DatabaseMetaData meta = modelDatabaseValues.connection.getMetaData();
                result = meta.getSchemas(modelDatabaseValues.dbCatalog, null);
                while (result.next()) {
                    schemasForModel.add(name(modelDatabaseValues, result.getString("TABLE_SCHEM")));
                }
            } catch (SQLException e) {
                error("getCatalogs error " + e, e);
            } finally {
                try {
                    if (result != null)
                        result.close();
                } catch (SQLException e) {
                    error("getCatalogs error " + e, e);
                }
            }
        }
        debug("<<<getSchemas", schemasForModel);
        return schemasForModel;
    }

    @Override
    public List<String> getTables(EObject model) {
        debug(">>>getTables");
        DatabaseDirectives modelDatabaseValues = getConnection(model);
        if (modelDatabaseValues == null)
            return Collections.emptyList();
        List<String> tablesForModel = tables.get(modelDatabaseValues.dir);
        if (tablesForModel != null)
            return tablesForModel;
        tablesForModel = Collections.synchronizedList(new ArrayList<String>());
        tables.put(modelDatabaseValues.dir, tablesForModel);
        if (modelDatabaseValues.connection != null) {
            ResultSet result = null;
            try {
                DatabaseMetaData meta = modelDatabaseValues.connection.getMetaData();
                result = meta.getTables(modelDatabaseValues.dbCatalog, modelDatabaseValues.dbSchema, null,
                        new String[] { "TABLE", "VIEW" });
                while (result.next()) {
                    tablesForModel.add(name(modelDatabaseValues, result.getString("TABLE_NAME")));
                }
            } catch (SQLException e) {
                error("getTables error " + e, e);
            } finally {
                try {
                    if (result != null)
                        result.close();
                } catch (SQLException e) {
                    error("getTables error " + e, e);
                }
            }
        }
        debug("<<<getTables", tablesForModel);
        return tablesForModel;
    }

    @Override
    public List<String> getProcedures(EObject model) {
        debug(">>>getProcedures");
        DatabaseDirectives modelDatabaseValues = getConnection(model);
        if (modelDatabaseValues == null || modelDatabaseValues.dbSkipProcedures)
            return Collections.emptyList();
        List<String> proceduresForModel = procedures.get(modelDatabaseValues.dir);
        if (proceduresForModel != null)
            return proceduresForModel;
        proceduresForModel = Collections.synchronizedList(new ArrayList<String>());
        procedures.put(modelDatabaseValues.dir, proceduresForModel);
        if (modelDatabaseValues.connection != null) {
            DbType dbType = getDbType(model);
            ResultSet result = null;
            try {
                DatabaseMetaData meta = modelDatabaseValues.connection.getMetaData();
                result = meta.getProcedures(modelDatabaseValues.dbCatalog, modelDatabaseValues.dbSchema, null);
                while (result.next()) {
                    String name = result.getString("PROCEDURE_NAME");
                    if (dbType == DbType.MS_SQL) {
                        int ix = name.lastIndexOf(";");
                        if (ix >= 0)
                            name = name.substring(0, ix);
                    }
                    proceduresForModel.add(name(modelDatabaseValues, name));
                }
            } catch (SQLException e) {
                error("getProcedures error " + e, e);
            } finally {
                try {
                    if (result != null)
                        result.close();
                } catch (SQLException e) {
                    error("getProcedures error " + e, e);
                }
            }
        }
        debug("<<<getProcedures", proceduresForModel);
        return proceduresForModel;
    }

    @Override
    public List<String> getFunctions(EObject model) {
        debug(">>>getFunctions");
        DatabaseDirectives modelDatabaseValues = getConnection(model);
        if (modelDatabaseValues == null || modelDatabaseValues.dbSkipProcedures)
            return Collections.emptyList();
        List<String> functionsForModel = functions.get(modelDatabaseValues.dir);
        if (functionsForModel != null)
            return functionsForModel;
        functionsForModel = Collections.synchronizedList(new ArrayList<String>());
        functions.put(modelDatabaseValues.dir, functionsForModel);
        if (modelDatabaseValues.connection != null) {
            DbType dbType = getDbType(model);
            if (dbType == DbType.POSTGRESQL || dbType == DbType.INFORMIX)
                return functionsForModel;
            ResultSet result = null;
            try {
                DatabaseMetaData meta = modelDatabaseValues.connection.getMetaData();
                result = meta.getFunctions(modelDatabaseValues.dbCatalog, modelDatabaseValues.dbSchema, null);
                while (result.next()) {
                    String name = result.getString("FUNCTION_NAME");
                    if (dbType == DbType.MS_SQL) {
                        int ix = name.lastIndexOf(";");
                        if (ix >= 0)
                            name = name.substring(0, ix);
                    }
                    functionsForModel.add(name(modelDatabaseValues, name));
                }
            } catch (SQLException e) {
                error("getFunctions error " + e, e);
            } finally {
                try {
                    if (result != null)
                        result.close();
                } catch (SQLException e) {
                    error("getFunctions error " + e, e);
                }
            }
        }
        debug("<<<getFunctions", functionsForModel);
        return functionsForModel;
    }

    @Override
    public boolean checkTable(EObject model, String table) {
        if (table == null)
            return false;
        return getTables(model).contains(table);
    }

    @Override
    public boolean checkTableName(EObject model, String table) {
        if (table == null)
            return false;
        DatabaseDirectives modelDatabaseValues = getConnection(model);
        String origName = origName(model, modelDatabaseValues, table);
        System.out.println(table + " -> " + origName);
        if (origName == null)
            return false;
        return true;
    }

    @Override
    public boolean checkProcedure(EObject model, String procedure) {
        if (procedure == null)
            return false;
        return getProcedures(model).contains(procedure);
    }

    @Override
    public boolean checkFunction(EObject model, String function) {
        if (function == null)
            return false;
        return getFunctions(model).contains(function);
    }

    @Override
    public List<String> getColumns(EObject model, String table) {
        debug(">>>getColumns " + table);
        if (table == null)
            return Collections.emptyList();
        DatabaseDirectives modelDatabaseValues = getConnection(model);
        if (modelDatabaseValues == null)
            return Collections.emptyList();
        boolean doInit = false;
        Map<String, List<String>> allColumnsForModel = columns.get(modelDatabaseValues.dir);
        if (allColumnsForModel == null) {
            allColumnsForModel = Collections.synchronizedMap(new HashMap<String, List<String>>());
            columns.put(modelDatabaseValues.dir, allColumnsForModel);
            doInit = true;
        }
        List<String> columnsForModel = allColumnsForModel.get(table);
        if (columnsForModel == null) {
            columnsForModel = Collections.synchronizedList(new ArrayList<String>());
            allColumnsForModel.put(table, columnsForModel);
            doInit = true;
        }
        if (!doInit)
            return columnsForModel;
        if (modelDatabaseValues.connection != null) {
            ResultSet result = null;
            try {
                DatabaseMetaData meta = modelDatabaseValues.connection.getMetaData();
                result = meta.getColumns(modelDatabaseValues.dbCatalog, modelDatabaseValues.dbSchema,
                        origName(model, modelDatabaseValues, table), null);
                while (result.next()) {
                    columnsForModel.add(name(modelDatabaseValues, result.getString("COLUMN_NAME")));
                }
            } catch (SQLException e) {
                error("getColumns error " + e, e);
            } finally {
                try {
                    if (result != null)
                        result.close();
                } catch (SQLException e) {
                    error("getColumns error " + e, e);
                }
            }
        }
        debug("<<<getColumns", columnsForModel);
        return columnsForModel;
    }

    @Override
    public boolean checkColumn(EObject model, String table, String column) {
        if (table == null || column == null)
            return false;
        return getColumns(model, table).contains(column);
    }

    @Override
    public List<String> getProcColumns(EObject model, String table) {
        debug(">>>getProcColumns " + table);
        if (table == null)
            return Collections.emptyList();
        DatabaseDirectives modelDatabaseValues = getConnection(model);
        if (modelDatabaseValues == null || modelDatabaseValues.dbSkipProcedures)
            return Collections.emptyList();
        boolean doInit = false;
        Map<String, List<String>> allColumnsForModel = procColumns.get(modelDatabaseValues.dir);
        if (allColumnsForModel == null) {
            allColumnsForModel = Collections.synchronizedMap(new HashMap<String, List<String>>());
            procColumns.put(modelDatabaseValues.dir, allColumnsForModel);
            doInit = true;
        }
        List<String> columnsForModel = allColumnsForModel.get(table);
        if (columnsForModel == null) {
            columnsForModel = Collections.synchronizedList(new ArrayList<String>());
            allColumnsForModel.put(table, columnsForModel);
            doInit = true;
        }
        if (!doInit)
            return columnsForModel;
        if (modelDatabaseValues.connection != null) {
            DbType dbType = getDbType(model);
            ResultSet result = null;
            try {
                DatabaseMetaData meta = modelDatabaseValues.connection.getMetaData();
                result = meta.getProcedureColumns(modelDatabaseValues.dbCatalog, modelDatabaseValues.dbSchema,
                        origName(model, modelDatabaseValues, table), null);
                while (result.next()) {
                    String name = result.getString("COLUMN_NAME");
                    if (dbType == DbType.MS_SQL) {
                        if (name.startsWith("@"))
                            name = name.substring(1);
                    }
                    columnsForModel.add(name(modelDatabaseValues, name));
                }
            } catch (SQLException e) {
                error("getProcColumns error " + e, e);
            } finally {
                try {
                    if (result != null)
                        result.close();
                } catch (SQLException e) {
                    error("getProcColumns error " + e, e);
                }
            }
        }
        debug("<<<getProcColumns", columnsForModel);
        return columnsForModel;
    }

    @Override
    public boolean checkProcColumn(EObject model, String table, String column) {
        if (doSkipProcedures(model))
            return true;
        if (table == null || column == null)
            return false;
        return getProcColumns(model, table).contains(column);
    }

    @Override
    public List<String> getFunColumns(EObject model, String table) {
        debug(">>>getFunColumns " + table);
        if (table == null)
            return Collections.emptyList();
        DatabaseDirectives modelDatabaseValues = getConnection(model);
        if (modelDatabaseValues == null || modelDatabaseValues.dbSkipProcedures)
            return Collections.emptyList();
        boolean doInit = false;
        Map<String, List<String>> allColumnsForModel = funColumns.get(modelDatabaseValues.dir);
        if (allColumnsForModel == null) {
            allColumnsForModel = Collections.synchronizedMap(new HashMap<String, List<String>>());
            funColumns.put(modelDatabaseValues.dir, allColumnsForModel);
            doInit = true;
        }
        List<String> columnsForModel = allColumnsForModel.get(table);
        if (columnsForModel == null) {
            columnsForModel = Collections.synchronizedList(new ArrayList<String>());
            allColumnsForModel.put(table, columnsForModel);
            doInit = true;
        }
        if (!doInit)
            return columnsForModel;
        if (modelDatabaseValues.connection != null) {
            DbType dbType = getDbType(model);
            ResultSet result = null;
            try {
                DatabaseMetaData meta = modelDatabaseValues.connection.getMetaData();
                result = meta.getFunctionColumns(modelDatabaseValues.dbCatalog, modelDatabaseValues.dbSchema,
                        origName(model, modelDatabaseValues, table), null);
                while (result.next()) {
                    String name = result.getString("COLUMN_NAME");
                    if (dbType == DbType.MS_SQL) {
                        if (name.startsWith("@"))
                            name = name.substring(1);
                    }
                    columnsForModel.add(name(modelDatabaseValues, name));
                }
            } catch (SQLException e) {
                error("getFunColumns error " + e, e);
            } finally {
                try {
                    if (result != null)
                        result.close();
                } catch (SQLException e) {
                    error("getFunColumns error " + e, e);
                }
            }
        }
        debug("<<<getFunColumns", columnsForModel);
        return columnsForModel;
    }

    @Override
    public boolean checkFunColumn(EObject model, String table, String column) {
        if (doSkipProcedures(model))
            return true;
        if (table == null || column == null)
            return false;
        return getFunColumns(model, table).contains(column);
    }

    protected boolean doSkipProcedures(EObject model) {
        DatabaseDirectives modelDatabaseValues = getConnection(model);
        if (modelDatabaseValues == null || modelDatabaseValues.dbSkipProcedures)
            return true;
        return false;
    }

    @Override
    public List<DbTable> getDbTables(EObject model, String table) {
        debug(">>>getDbTables " + table);
        if (table == null)
            return Collections.emptyList();
        DatabaseDirectives modelDatabaseValues = getConnection(model);
        if (modelDatabaseValues == null)
            return Collections.emptyList();
        boolean doInit = false;
        Map<String, List<DbTable>> allTablesForModel = dbTables.get(modelDatabaseValues.dir);
        if (allTablesForModel == null) {
            allTablesForModel = Collections.synchronizedMap(new HashMap<String, List<DbTable>>());
            dbTables.put(modelDatabaseValues.dir, allTablesForModel);
            doInit = true;
        }
        List<DbTable> tablesForModel = allTablesForModel.get(table);
        if (tablesForModel == null) {
            tablesForModel = Collections.synchronizedList(new ArrayList<DbTable>());
            allTablesForModel.put(table, tablesForModel);
            doInit = true;
        }
        if (!doInit)
            return tablesForModel;
        if (modelDatabaseValues.connection != null) {
            ResultSet result = null;
            try {
                DatabaseMetaData meta = modelDatabaseValues.connection.getMetaData();
                result = meta.getTables(modelDatabaseValues.dbCatalog, modelDatabaseValues.dbSchema,
                        origName(model, modelDatabaseValues, table), null);
                while (result.next()) {
                    DbTable dbTable = new DbTable();
                    dbTable.setName(name(modelDatabaseValues, result.getString("TABLE_NAME")));
                    dbTable.setType(result.getString("TABLE_TYPE"));
                    if (modelDatabaseValues.dbTakeComments)
                        dbTable.setComment(result.getString("REMARKS"));
                    tablesForModel.add(dbTable);
                    // debug(table + ": " + dbTable.toString());
                }
            } catch (SQLException e) {
                error("getDbTables error " + e, e);
            } finally {
                try {
                    if (result != null)
                        result.close();
                } catch (SQLException e) {
                    error("getDbTables error " + e, e);
                }
            }
        }
        debug("<<<getDbTables", tablesForModel);
        return tablesForModel;
    }

    @Override
    public List<DbColumn> getDbColumns(EObject model, String table) {
        debug(">>>getDbColumns " + table);
        if (table == null)
            return Collections.emptyList();
        DatabaseDirectives modelDatabaseValues = getConnection(model);
        if (modelDatabaseValues == null)
            return Collections.emptyList();
        boolean doInit = false;
        Map<String, List<DbColumn>> allColumnsForModel = dbColumns.get(modelDatabaseValues.dir);
        if (allColumnsForModel == null) {
            allColumnsForModel = Collections.synchronizedMap(new HashMap<String, List<DbColumn>>());
            dbColumns.put(modelDatabaseValues.dir, allColumnsForModel);
            doInit = true;
        }
        List<DbColumn> columnsForModel = allColumnsForModel.get(table);
        if (columnsForModel == null) {
            columnsForModel = Collections.synchronizedList(new ArrayList<DbColumn>());
            allColumnsForModel.put(table, columnsForModel);
            doInit = true;
        }
        if (!doInit)
            return columnsForModel;
        if (modelDatabaseValues.connection != null) {
            ResultSet result = null;
            try {
                DatabaseMetaData meta = modelDatabaseValues.connection.getMetaData();
                result = meta.getColumns(modelDatabaseValues.dbCatalog, modelDatabaseValues.dbSchema,
                        origName(model, modelDatabaseValues, table), null);
                while (result.next()) {
                    DbColumn dbColumn = new DbColumn();
                    dbColumn.setName(name(modelDatabaseValues, result.getString("COLUMN_NAME")));
                    dbColumn.setType(result.getString("TYPE_NAME"));
                    int ix = dbColumn.getType().indexOf('(');
                    if (ix > 0) {
                        String size = dbColumn.getType().substring(ix + 1);
                        dbColumn.setType(dbColumn.getType().substring(0, ix));
                        ix = size.indexOf(')');
                        if (ix > 0) {
                            size = size.substring(0, ix);
                        }
                        try {
                            dbColumn.setSize(Integer.parseInt(size));
                        } catch (Exception ignore) {
                        }
                    } else {
                        dbColumn.setSize(result.getInt("COLUMN_SIZE"));
                    }
                    dbColumn.setSqlType(result.getInt("DATA_TYPE"));
                    dbColumn.setNullable(result.getInt("NULLABLE") != DatabaseMetaData.columnNoNulls);
                    if (modelDatabaseValues.dbTakeComments)
                        dbColumn.setComment(result.getString("REMARKS"));
                    // dbColumn.setPosition(result.getInt("ORDINAL_POSITION"));
                    columnsForModel.add(dbColumn);
                    // debug(table + ": " + dbColumn.toString());
                }
            } catch (SQLException e) {
                error("getDbColumns error " + e, e);
            } finally {
                try {
                    if (result != null)
                        result.close();
                } catch (SQLException e) {
                    error("getDbColumns error " + e, e);
                }
            }
        }
        // Collections.sort(columnsForModel);
        debug("<<<getDbColumns", columnsForModel);
        return columnsForModel;
    }

    @Override
    public List<DbTable> getDbProcedures(EObject model, String table) {
        debug(">>>getDbProcedures " + table);
        if (table == null)
            return Collections.emptyList();
        DatabaseDirectives modelDatabaseValues = getConnection(model);
        if (modelDatabaseValues == null || modelDatabaseValues.dbSkipProcedures)
            return Collections.emptyList();
        boolean doInit = false;
        Map<String, List<DbTable>> allTablesForModel = dbProcedures.get(modelDatabaseValues.dir);
        if (allTablesForModel == null) {
            allTablesForModel = Collections.synchronizedMap(new HashMap<String, List<DbTable>>());
            dbProcedures.put(modelDatabaseValues.dir, allTablesForModel);
            doInit = true;
        }
        List<DbTable> tablesForModel = allTablesForModel.get(table);
        if (tablesForModel == null) {
            tablesForModel = Collections.synchronizedList(new ArrayList<DbTable>());
            allTablesForModel.put(table, tablesForModel);
            doInit = true;
        }
        if (!doInit)
            return tablesForModel;
        if (modelDatabaseValues.connection != null) {
            DbType dbType = getDbType(model);
            ResultSet result = null;
            try {
                DatabaseMetaData meta = modelDatabaseValues.connection.getMetaData();
                result = meta.getProcedures(modelDatabaseValues.dbCatalog, modelDatabaseValues.dbSchema,
                        origName(model, modelDatabaseValues, table));
                while (result.next()) {
                    String name = result.getString("PROCEDURE_NAME");
                    if (dbType == DbType.MS_SQL) {
                        int ix = name.lastIndexOf(";");
                        if (ix >= 0)
                            name = name.substring(0, ix);
                    }
                    DbTable dbTable = new DbTable();
                    dbTable.setName(name(modelDatabaseValues, name));
                    dbTable.setPtype(result.getShort("PROCEDURE_TYPE"));
                    if (modelDatabaseValues.dbTakeComments)
                        dbTable.setComment(result.getString("REMARKS"));
                    tablesForModel.add(dbTable);
                    // debug(table + ": " + dbTable.toString());
                }
            } catch (SQLException e) {
                error("getDbProcedures error " + e, e);
            } finally {
                try {
                    if (result != null)
                        result.close();
                } catch (SQLException e) {
                    error("getDbProcedures error " + e, e);
                }
            }
        }
        debug("<<<getDbProcedures", tablesForModel);
        return tablesForModel;
    }

    @Override
    public List<DbColumn> getDbProcColumns(EObject model, String procedure) {
        debug(">>>getDbProcColumns " + procedure);
        if (procedure == null)
            return Collections.emptyList();
        DatabaseDirectives modelDatabaseValues = getConnection(model);
        if (modelDatabaseValues == null || modelDatabaseValues.dbSkipProcedures)
            return Collections.emptyList();
        boolean doInit = false;
        Map<String, List<DbColumn>> allColumnsForModel = dbProcColumns.get(modelDatabaseValues.dir);
        if (allColumnsForModel == null) {
            allColumnsForModel = Collections.synchronizedMap(new HashMap<String, List<DbColumn>>());
            dbProcColumns.put(modelDatabaseValues.dir, allColumnsForModel);
            doInit = true;
        }
        List<DbColumn> columnsForModel = allColumnsForModel.get(procedure);
        if (columnsForModel == null) {
            columnsForModel = Collections.synchronizedList(new ArrayList<DbColumn>());
            allColumnsForModel.put(procedure, columnsForModel);
            doInit = true;
        }
        if (!doInit)
            return columnsForModel;
        if (modelDatabaseValues.connection != null) {
            DbType dbType = getDbType(model);
            ResultSet result = null;
            try {
                DatabaseMetaData meta = modelDatabaseValues.connection.getMetaData();
                result = meta.getProcedureColumns(modelDatabaseValues.dbCatalog, modelDatabaseValues.dbSchema,
                        origName(model, modelDatabaseValues, procedure), null);
                while (result.next()) {
                    DbColumn dbColumn = new DbColumn();
                    String name = result.getString("COLUMN_NAME");
                    if (dbType == DbType.MS_SQL) {
                        if (name.startsWith("@"))
                            name = name.substring(1);
                    }
                    dbColumn.setName(name(modelDatabaseValues, name));
                    dbColumn.setType(result.getString("TYPE_NAME"));
                    dbColumn.setColumnType(result.getShort("COLUMN_TYPE"));
                    int ix = dbColumn.getType().indexOf('(');
                    if (ix > 0) {
                        String size = dbColumn.getType().substring(ix + 1);
                        dbColumn.setType(dbColumn.getType().substring(0, ix));
                        ix = size.indexOf(')');
                        if (ix > 0) {
                            size = size.substring(0, ix);
                        }
                        try {
                            dbColumn.setSize(Integer.parseInt(size));
                        } catch (Exception ignore) {
                        }
                    } else {
                        dbColumn.setSize(result.getInt("LENGTH"));
                    }
                    dbColumn.setSqlType(result.getInt("DATA_TYPE"));
                    dbColumn.setNullable(result.getInt("NULLABLE") != DatabaseMetaData.columnNoNulls);
                    if (modelDatabaseValues.dbTakeComments)
                        dbColumn.setComment(result.getString("REMARKS"));
                    // if (DbType.MY_SQL != dbType && DbType.INFORMIX != dbType)
                    // dbColumn.setPosition(result.getInt("ORDINAL_POSITION"));
                    columnsForModel.add(dbColumn);
                    debug(procedure + ": " + dbColumn.toString());
                }
            } catch (SQLException e) {
                error("getDbProcColumns error " + e, e);
            } finally {
                try {
                    if (result != null)
                        result.close();
                } catch (SQLException e) {
                    error("getDbProcColumns error " + e, e);
                }
            }
        }
        // Collections.sort(columnsForModel);
        debug("<<<getDbProcColumns", columnsForModel);
        return columnsForModel;
    }

    @Override
    public List<DbTable> getDbFunctions(EObject model, String table) {
        debug(">>>getDbFunctions " + table);
        if (table == null)
            return Collections.emptyList();
        DatabaseDirectives modelDatabaseValues = getConnection(model);
        if (modelDatabaseValues == null || modelDatabaseValues.dbSkipProcedures)
            return Collections.emptyList();
        boolean doInit = false;
        Map<String, List<DbTable>> allTablesForModel = dbFunctions.get(modelDatabaseValues.dir);
        if (allTablesForModel == null) {
            allTablesForModel = Collections.synchronizedMap(new HashMap<String, List<DbTable>>());
            dbFunctions.put(modelDatabaseValues.dir, allTablesForModel);
            doInit = true;
        }
        List<DbTable> tablesForModel = allTablesForModel.get(table);
        if (tablesForModel == null) {
            tablesForModel = Collections.synchronizedList(new ArrayList<DbTable>());
            allTablesForModel.put(table, tablesForModel);
            doInit = true;
        }
        if (!doInit)
            return tablesForModel;
        if (modelDatabaseValues.connection != null) {
            DbType dbType = getDbType(model);
            if (dbType == DbType.POSTGRESQL || dbType == DbType.INFORMIX)
                return tablesForModel;
            ResultSet result = null;
            try {
                DatabaseMetaData meta = modelDatabaseValues.connection.getMetaData();
                result = meta.getFunctions(modelDatabaseValues.dbCatalog, modelDatabaseValues.dbSchema,
                        origName(model, modelDatabaseValues, table));
                // ResultSetMetaData rmeta = result.getMetaData();
                // for (int i = 1; i <= rmeta.getColumnCount(); i++) {
                // System.out.println("" + i + ": " + rmeta.getColumnLabel(i));
                // }
                while (result.next()) {
                    String name = result.getString("FUNCTION_NAME");
                    if (dbType == DbType.MS_SQL) {
                        int ix = name.lastIndexOf(";");
                        if (ix >= 0)
                            name = name.substring(0, ix);
                    }
                    DbTable dbTable = new DbTable();
                    dbTable.setName(name(modelDatabaseValues, name));
                    if (dbType != DbType.DB2 && dbType != DbType.ORACLE)
                        dbTable.setFtype(result.getShort("FUNCTION_TYPE"));
                    if (modelDatabaseValues.dbTakeComments)
                        dbTable.setComment(result.getString("REMARKS"));
                    tablesForModel.add(dbTable);
                    debug(table + ": " + dbTable.toString());
                }
            } catch (SQLException e) {
                error("getDbFunctions error " + e, e);
            } finally {
                try {
                    if (result != null)
                        result.close();
                } catch (SQLException e) {
                    error("getDbFunctions error " + e, e);
                }
            }
        }
        debug("<<<getDbFunctions", tablesForModel);
        return tablesForModel;
    }

    @Override
    public List<DbColumn> getDbFunColumns(EObject model, String function) {
        debug(">>>getDbFunColumns " + function);
        if (function == null)
            return Collections.emptyList();
        DatabaseDirectives modelDatabaseValues = getConnection(model);
        if (modelDatabaseValues == null || modelDatabaseValues.dbSkipProcedures)
            return Collections.emptyList();
        boolean doInit = false;
        Map<String, List<DbColumn>> allColumnsForModel = dbFunColumns.get(modelDatabaseValues.dir);
        if (allColumnsForModel == null) {
            allColumnsForModel = Collections.synchronizedMap(new HashMap<String, List<DbColumn>>());
            dbFunColumns.put(modelDatabaseValues.dir, allColumnsForModel);
            doInit = true;
        }
        List<DbColumn> columnsForModel = allColumnsForModel.get(function);
        if (columnsForModel == null) {
            columnsForModel = Collections.synchronizedList(new ArrayList<DbColumn>());
            allColumnsForModel.put(function, columnsForModel);
            doInit = true;
        }
        if (!doInit)
            return columnsForModel;
        if (modelDatabaseValues.connection != null) {
            DbType dbType = getDbType(model);
            ResultSet result = null;
            try {
                DatabaseMetaData meta = modelDatabaseValues.connection.getMetaData();
                result = meta.getFunctionColumns(modelDatabaseValues.dbCatalog, modelDatabaseValues.dbSchema,
                        origName(model, modelDatabaseValues, function), null);
                // ResultSetMetaData rmeta = result.getMetaData();
                // for (int i = 1; i <= rmeta.getColumnCount(); i++) {
                // System.out.println("" + i + ": " + rmeta.getColumnLabel(i));
                // }
                while (result.next()) {
                    String name = result.getString(dbType == DbType.DB2 ? "PARAMETER_NAME" : "COLUMN_NAME");
                    if (dbType == DbType.MS_SQL) {
                        if (name.startsWith("@"))
                            name = name.substring(1);
                    }
                    DbColumn dbColumn = new DbColumn();
                    dbColumn.setName(name(modelDatabaseValues, name));
                    dbColumn.setType(result.getString("TYPE_NAME"));
                    dbColumn.setColumnType(result.getShort(dbType == DbType.DB2 ? "PARAMETER_TYPE" : "COLUMN_TYPE"));
                    int ix = dbColumn.getType().indexOf('(');
                    if (ix > 0) {
                        String size = dbColumn.getType().substring(ix + 1);
                        dbColumn.setType(dbColumn.getType().substring(0, ix));
                        ix = size.indexOf(')');
                        if (ix > 0) {
                            size = size.substring(0, ix);
                        }
                        try {
                            dbColumn.setSize(Integer.parseInt(size));
                        } catch (Exception ignore) {
                        }
                    } else {
                        dbColumn.setSize(result.getInt("LENGTH"));
                    }
                    dbColumn.setSqlType(result.getInt("DATA_TYPE"));
                    dbColumn.setNullable(result.getInt("NULLABLE") != DatabaseMetaData.columnNoNulls);
                    if (modelDatabaseValues.dbTakeComments)
                        dbColumn.setComment(result.getString("REMARKS"));
                    // if (DbType.MY_SQL != dbType)
                    // dbColumn.setPosition(result.getInt("ORDINAL_POSITION"));
                    columnsForModel.add(dbColumn);
                    // debug(function + ": " + dbColumn.toString());
                }
            } catch (SQLException e) {
                error("getDbFunColumns error " + e, e);
            } finally {
                try {
                    if (result != null)
                        result.close();
                } catch (SQLException e) {
                    error("getDbFunColumns error " + e, e);
                }
            }
        }
        // Collections.sort(columnsForModel);
        debug("<<<getDbFunColumns", columnsForModel);
        return columnsForModel;
    }

    @Override
    public List<String> getDbPrimaryKeys(EObject model, String table) {
        debug(">>>getDbPrimaryKeys " + table);
        if (table == null)
            return Collections.emptyList();
        DatabaseDirectives modelDatabaseValues = getConnection(model);
        if (modelDatabaseValues == null)
            return Collections.emptyList();
        boolean doInit = false;
        Map<String, List<String>> allPrimaryKeysForModel = dbPrimaryKeys.get(modelDatabaseValues.dir);
        if (allPrimaryKeysForModel == null) {
            allPrimaryKeysForModel = Collections.synchronizedMap(new HashMap<String, List<String>>());
            dbPrimaryKeys.put(modelDatabaseValues.dir, allPrimaryKeysForModel);
            doInit = true;
        }
        List<String> primaryKeysForModel = allPrimaryKeysForModel.get(table);
        if (primaryKeysForModel == null) {
            primaryKeysForModel = Collections.synchronizedList(new ArrayList<String>());
            allPrimaryKeysForModel.put(table, primaryKeysForModel);
            doInit = true;
        }
        if (!doInit)
            return primaryKeysForModel;
        if (modelDatabaseValues.connection != null) {
            ResultSet result = null;
            try {
                DatabaseMetaData meta = modelDatabaseValues.connection.getMetaData();
                result = meta.getPrimaryKeys(modelDatabaseValues.dbCatalog, modelDatabaseValues.dbSchema,
                        origName(model, modelDatabaseValues, table));
                while (result.next()) {
                    primaryKeysForModel.add(name(modelDatabaseValues, result.getString("COLUMN_NAME")));
                }
            } catch (SQLException e) {
                error("getDbPrimaryKeys error " + e, e);
            } finally {
                try {
                    if (result != null)
                        result.close();
                } catch (SQLException e) {
                    error("getDbPrimaryKeys error " + e, e);
                }
            }
        }
        debug("<<<getDbPrimaryKeys", primaryKeysForModel);
        return primaryKeysForModel;
    }

    @Override
    public List<DbExport> getDbExports(EObject model, String table) {
        debug(">>>getDbExports " + table);
        if (table == null)
            return Collections.emptyList();
        DatabaseDirectives modelDatabaseValues = getConnection(model);
        if (modelDatabaseValues == null)
            return Collections.emptyList();
        boolean doInit = false;
        Map<String, List<DbExport>> allExportsForModel = dbExports.get(modelDatabaseValues.dir);
        if (allExportsForModel == null) {
            allExportsForModel = Collections.synchronizedMap(new HashMap<String, List<DbExport>>());
            dbExports.put(modelDatabaseValues.dir, allExportsForModel);
            doInit = true;
        }
        List<DbExport> exportsForModel = allExportsForModel.get(table);
        if (exportsForModel == null) {
            exportsForModel = Collections.synchronizedList(new ArrayList<DbExport>());
            allExportsForModel.put(table, exportsForModel);
            doInit = true;
        }
        if (!doInit)
            return exportsForModel;
        if (modelDatabaseValues.connection != null) {
            ResultSet result = null;
            try {
                DatabaseMetaData meta = modelDatabaseValues.connection.getMetaData();
                result = meta.getExportedKeys(modelDatabaseValues.dbCatalog, modelDatabaseValues.dbSchema,
                        origName(model, modelDatabaseValues, table));
                while (result.next()) {
                    DbExport dbExport = new DbExport();
                    dbExport.setPkTable(name(modelDatabaseValues, result.getString("PKTABLE_NAME")));
                    dbExport.setPkColumn(name(modelDatabaseValues, result.getString("PKCOLUMN_NAME")));
                    dbExport.setFkTable(name(modelDatabaseValues, result.getString("FKTABLE_NAME")));
                    dbExport.setFkColumn(name(modelDatabaseValues, result.getString("FKCOLUMN_NAME")));
                    dbExport.setFkName(name(modelDatabaseValues, result.getString("FK_NAME")));
                    dbExport.setPkName(name(modelDatabaseValues, result.getString("PK_NAME")));
                    // debug("BBB " + table + " " + dbExport.toString());
                    exportsForModel.add(dbExport);
                }
            } catch (SQLException e) {
                error("getDbExports error " + e, e);
            } finally {
                try {
                    if (result != null)
                        result.close();
                } catch (SQLException e) {
                    error("getDbExports error " + e, e);
                }
            }
        }
        debug("<<<getDbExports", exportsForModel);
        return exportsForModel;
    }

    @Override
    public List<DbImport> getDbImports(EObject model, String table) {
        debug(">>>getDbImports " + table);
        if (table == null)
            return Collections.emptyList();
        DatabaseDirectives modelDatabaseValues = getConnection(model);
        if (modelDatabaseValues == null)
            return Collections.emptyList();
        boolean doInit = false;
        Map<String, List<DbImport>> allImportsForModel = dbImports.get(modelDatabaseValues.dir);
        if (allImportsForModel == null) {
            allImportsForModel = Collections.synchronizedMap(new HashMap<String, List<DbImport>>());
            dbImports.put(modelDatabaseValues.dir, allImportsForModel);
            doInit = true;
        }
        List<DbImport> importsForModel = allImportsForModel.get(table);
        if (importsForModel == null) {
            importsForModel = Collections.synchronizedList(new ArrayList<DbImport>());
            allImportsForModel.put(table, importsForModel);
            doInit = true;
        }
        if (!doInit)
            return importsForModel;
        if (modelDatabaseValues.connection != null) {
            ResultSet result = null;
            try {
                DatabaseMetaData meta = modelDatabaseValues.connection.getMetaData();
                result = meta.getImportedKeys(modelDatabaseValues.dbCatalog, modelDatabaseValues.dbSchema,
                        origName(model, modelDatabaseValues, table));
                while (result.next()) {
                    DbImport dbImport = new DbImport();
                    dbImport.setPkTable(name(modelDatabaseValues, result.getString("PKTABLE_NAME")));
                    dbImport.setPkColumn(name(modelDatabaseValues, result.getString("PKCOLUMN_NAME")));
                    dbImport.setFkTable(name(modelDatabaseValues, result.getString("FKTABLE_NAME")));
                    dbImport.setFkColumn(name(modelDatabaseValues, result.getString("FKCOLUMN_NAME")));
                    dbImport.setFkName(name(modelDatabaseValues, result.getString("FK_NAME")));
                    dbImport.setPkName(name(modelDatabaseValues, result.getString("PK_NAME")));
                    // debug("CCC " + table + " " + dbImport.toString());
                    importsForModel.add(dbImport);
                }
            } catch (SQLException e) {
                error("getDbImports error " + e, e);
            } finally {
                try {
                    if (result != null)
                        result.close();
                } catch (SQLException e) {
                    error("getDbImports error " + e, e);
                }
            }
        }
        debug("<<<getDbImports", importsForModel);
        return importsForModel;
    }

    @Override
    public String getType(EObject model, String table, String column) {
        debug(">>>getType " + table + " " + column);
        if (table == null || column == null)
            return "";
        DatabaseDirectives modelDatabaseValues = getConnection(model);
        if (modelDatabaseValues == null)
            return "";
        ResultSet result = null;
        String type = null;
        int typeSize = 0;
        try {
            DatabaseMetaData meta = modelDatabaseValues.connection.getMetaData();
            result = meta.getColumns(modelDatabaseValues.dbCatalog, modelDatabaseValues.dbSchema,
                    origName(model, modelDatabaseValues, table), null);
            while (result.next()) {
                if (name(modelDatabaseValues, result.getString("COLUMN_NAME")).equals(column)) {
                    type = result.getString("TYPE_NAME");
                    int ix = type.indexOf('(');
                    if (ix > 0) {
                        String size = type.substring(ix + 1);
                        type = type.substring(0, ix);
                        ix = size.indexOf(')');
                        if (ix > 0) {
                            size = size.substring(0, ix);
                        }
                        try {
                            typeSize = Integer.parseInt(size);
                        } catch (Exception ignore) {
                        }
                    } else {
                        typeSize = result.getInt("COLUMN_SIZE");
                    }
                    break;
                }
            }
        } catch (SQLException e) {
            error("getType error " + e, e);
        } finally {
            try {
                if (result != null)
                    result.close();
            } catch (SQLException e) {
                error("getType error " + e, e);
            }
        }
        debug("<<<getType", type + "(" + typeSize + ")");
        return type + "(" + typeSize + ")";
    }

    @Override
    public String getProcType(EObject model, String procedure, String column) {
        debug(">>>getDbProcType " + procedure + " " + column);
        if (procedure == null || column == null)
            return "";
        DatabaseDirectives modelDatabaseValues = getConnection(model);
        if (modelDatabaseValues == null)
            return "";
        DbType dbType = getDbType(model);
        ResultSet result = null;
        String type = null;
        int typeSize = 0;
        try {
            DatabaseMetaData meta = modelDatabaseValues.connection.getMetaData();
            result = meta.getProcedureColumns(modelDatabaseValues.dbCatalog, modelDatabaseValues.dbSchema,
                    origName(model, modelDatabaseValues, procedure), null);
            while (result.next()) {
                if (column.equals(name(modelDatabaseValues, result.getString("COLUMN_NAME")))) {
                    type = result.getString("TYPE_NAME");
                    int ix = type.indexOf('(');
                    if (ix > 0) {
                        String size = type.substring(ix + 1);
                        type = type.substring(0, ix);
                        ix = size.indexOf(')');
                        if (ix > 0) {
                            size = size.substring(0, ix);
                        }
                        try {
                            typeSize = Integer.parseInt(size);
                        } catch (Exception ignore) {
                        }
                    } else {
                        typeSize = result.getInt("LENGTH");
                    }
                    break;
                }
            }
        } catch (SQLException e) {
            error("getDbProcType error " + e, e);
        } finally {
            try {
                if (result != null)
                    result.close();
            } catch (SQLException e) {
                error("getDbProcType error " + e, e);
            }
        }
        debug("<<<getDbProcType", type + "(" + typeSize + ")");
        return type + "(" + typeSize + ")";
    }

    @Override
    public String getFunType(EObject model, String function, String column) {
        debug(">>>getDbFunType " + function + " " + column);
        if (function == null || column == null)
            return "";
        DatabaseDirectives modelDatabaseValues = getConnection(model);
        if (modelDatabaseValues == null)
            return "";
        DbType dbType = getDbType(model);
        ResultSet result = null;
        String type = null;
        int typeSize = 0;
        try {
            DatabaseMetaData meta = modelDatabaseValues.connection.getMetaData();
            result = meta.getFunctionColumns(modelDatabaseValues.dbCatalog, modelDatabaseValues.dbSchema,
                    origName(model, modelDatabaseValues, function), null);
            while (result.next()) {
                if (column.equals(name(modelDatabaseValues,
                        result.getString(dbType == DbType.DB2 ? "PARAMETER_NAME" : "COLUMN_NAME")))) {
                    type = result.getString("TYPE_NAME");
                    int ix = type.indexOf('(');
                    if (ix > 0) {
                        String size = type.substring(ix + 1);
                        type = type.substring(0, ix);
                        ix = size.indexOf(')');
                        if (ix > 0) {
                            size = size.substring(0, ix);
                        }
                        try {
                            typeSize = Integer.parseInt(size);
                        } catch (Exception ignore) {
                        }
                    } else {
                        typeSize = result.getInt("LENGTH");
                    }
                    break;
                }
            }
        } catch (SQLException e) {
            error("getDbFunType error " + e, e);
        } finally {
            try {
                if (result != null)
                    result.close();
            } catch (SQLException e) {
                error("getDbFunType error " + e, e);
            }
        }
        debug("<<<getDbFunType", type + "(" + typeSize + ")");
        return type + "(" + typeSize + ")";
    }

    @Override
    public List<DbIndex> getDbIndexes(EObject model, String table) {
        debug(">>>getDbIndexes " + table);
        if (table == null)
            return Collections.emptyList();
        DatabaseDirectives modelDatabaseValues = getConnection(model);
        if (modelDatabaseValues == null || modelDatabaseValues.indexTypes == null
                || modelDatabaseValues.indexTypes.isEmpty() || modelDatabaseValues.dbSkipIndexes)
            return Collections.emptyList();
        boolean doInit = false;
        Map<String, List<DbIndex>> allIndexesForModel = dbIndexes.get(modelDatabaseValues.dir);
        if (allIndexesForModel == null) {
            allIndexesForModel = Collections.synchronizedMap(new HashMap<String, List<DbIndex>>());
            dbIndexes.put(modelDatabaseValues.dir, allIndexesForModel);
            doInit = true;
        }
        List<DbIndex> indexesForModel = allIndexesForModel.get(table);
        if (indexesForModel == null) {
            indexesForModel = Collections.synchronizedList(new ArrayList<DbIndex>());
            allIndexesForModel.put(table, indexesForModel);
            doInit = true;
        }
        if (!doInit)
            return indexesForModel;
        if (modelDatabaseValues.connection != null) {
            ResultSet result = null;
            try {
                Map<String, DbIndex> mapOfIndexes = new LinkedHashMap<String, DbIndex>();
                DatabaseMetaData meta = modelDatabaseValues.connection.getMetaData();
                result = meta.getIndexInfo(modelDatabaseValues.dbCatalog, modelDatabaseValues.dbSchema,
                        origName(model, modelDatabaseValues, table), false, true);
                short addToPosition = 0;
                while (result.next()) {
                    String name = name(modelDatabaseValues, result.getString("INDEX_NAME"));
                    if (!modelDatabaseValues.indexTypes.contains(result.getShort("TYPE"))) {
                        // debug("INDEX TYPE " + result.getShort("TYPE") + " for " + name);
                        LOGGER.warn("INDEX TYPE " + result.getShort("TYPE") + " for " + name);
                        continue;
                    }
                    DbIndex dbIndex = mapOfIndexes.get(name);
                    if (dbIndex == null) {
                        dbIndex = new DbIndex();
                        dbIndex.setName(name);
                        mapOfIndexes.put(name, dbIndex);
                    }
                    DbIndex.DbIndexDetail detail = new DbIndex.DbIndexDetail();
                    short position = result.getShort("ORDINAL_POSITION");
                    detail.setColname(name(modelDatabaseValues, result.getString("COLUMN_NAME")));
                    detail.setDesc("D".equalsIgnoreCase(result.getString("ASC_OR_DESC")));
                    if (position == 0)
                        addToPosition = 1;
                    dbIndex.getColumns().add(position - 1 + addToPosition, detail);
                }
                // debug("EEE " + table + " " + mapOfIndexes);
                indexesForModel.addAll(mapOfIndexes.values());
            } catch (SQLException e) {
                error("getDbIndexes error " + e, e);
            } finally {
                try {
                    if (result != null)
                        result.close();
                } catch (SQLException e) {
                    error("getDbIndexes error " + e, e);
                }
            }
        }
        debug("<<<getDbIndexes", indexesForModel);
        return indexesForModel;
    }

    @Override
    public List<String> getSequences(EObject model) {
        debug(">>>getSequences");
        DatabaseDirectives modelDatabaseValues = getConnection(model);
        if (modelDatabaseValues == null)
            return Collections.emptyList();
        List<String> sequencesForModel = dbSequences.get(modelDatabaseValues.dir);
        if (sequencesForModel != null)
            return sequencesForModel;
        sequencesForModel = Collections.synchronizedList(new ArrayList<String>());
        dbSequences.put(modelDatabaseValues.dir, sequencesForModel);
        if (modelDatabaseValues.connection != null) {
            ResultSet result = null;
            try {
                DatabaseMetaData meta = modelDatabaseValues.connection.getMetaData();
                result = meta.getTables(modelDatabaseValues.dbCatalog, modelDatabaseValues.dbSchema, null,
                        new String[] { "SEQUENCE" });
                while (result.next()) {
                    sequencesForModel.add(name(modelDatabaseValues, result.getString("TABLE_NAME")));
                }
            } catch (SQLException e) {
                error("getSequences error " + e, e);
            } finally {
                try {
                    if (result != null)
                        result.close();
                } catch (SQLException e) {
                    error("getSequences error " + e, e);
                }
            }
        }
        debug("<<<getSequences", sequencesForModel);
        return sequencesForModel;
    }

    @Override
    public String getDbMetaInfo(EObject model) {
        trace(">>>getDbMetaInfo");
        DatabaseDirectives modelDatabaseValues = getConnection(model);
        if (modelDatabaseValues == null)
            return "";
        StringBuilder sb = new StringBuilder();
        try {
            DatabaseMetaData meta = modelDatabaseValues.connection.getMetaData();
            sb.append(meta.getDatabaseProductName());
            sb.append(",").append(meta.getDatabaseProductVersion());
            sb.append(",").append(meta.getDatabaseMajorVersion());
            sb.append(",").append(meta.getDatabaseMinorVersion());
        } catch (SQLException e) {
            error("getDbMetaInfo error " + e, e);
        }
        trace("<<<getDbMetaInfo", sb);
        return sb.toString();
    }

    @Override
    public String getDbDriverInfo(EObject model) {
        debug(">>>getDbDriverInfo");
        DatabaseDirectives modelDatabaseValues = getConnection(model);
        if (modelDatabaseValues == null)
            return "";
        StringBuilder sb = new StringBuilder();
        try {
            DatabaseMetaData meta = modelDatabaseValues.connection.getMetaData();
            sb.append(meta.getDriverName());
            sb.append(",").append(meta.getDriverVersion());
            sb.append(",").append(meta.getDriverMajorVersion());
            sb.append(",").append(meta.getDriverMinorVersion());
        } catch (SQLException e) {
            error("getDbDriverInfo error " + e, e);
        }
        debug("<<<getDbDriverInfo", sb);
        return sb.toString();
    }

    @Override
    public String getDbJdbcInfo(EObject model) {
        debug(">>>getDbJdbcInfo");
        DatabaseDirectives modelDatabaseValues = getConnection(model);
        if (modelDatabaseValues == null)
            return "";
        StringBuilder sb = new StringBuilder();
        try {
            DatabaseMetaData meta = modelDatabaseValues.connection.getMetaData();
            sb.append(meta.getJDBCMajorVersion());
            sb.append(",").append(meta.getJDBCMinorVersion());
        } catch (SQLException e) {
            error("getDbJdbcInfo error " + e, e);
        }
        debug("<<<getDbJdbcInfo", sb);
        return sb.toString();
    }

    @Override
    public Set<String> getDriverMethods(EObject model) {
        debug(">>>getDriverMethods");
        DatabaseDirectives modelDatabaseValues = getConnection(model);
        if (modelDatabaseValues == null)
            return Collections.emptySet();
        SortedSet<String> driverMethodsForModel = driverMethods.get(modelDatabaseValues.dir);
        if (driverMethodsForModel != null)
            return driverMethodsForModel;
        driverMethodsForModel = Collections.synchronizedSortedSet(new TreeSet<String>());
        driverMethods.put(modelDatabaseValues.dir, driverMethodsForModel);
        if (modelDatabaseValues.connection != null) {
            try {
                DatabaseMetaData meta = modelDatabaseValues.connection.getMetaData();
                for (Method m : meta.getClass().getMethods()) {
                    if (m.getParameterTypes().length > 0)
                        continue;
                    if (m.getReturnType() != null && m.getReturnType().equals(ResultSet.class))
                        continue;
                    if (m.getReturnType() != null && m.getReturnType().equals(Connection.class))
                        continue;
                    driverMethodsForModel.add(m.getName());
                }
            } catch (SQLException e) {
                error("getDriverMethods error " + e, e);
            } catch (SecurityException e) {
                error("getDriverMethods error " + e, e);
            }
        }
        debug("<<<getDriverMethods", driverMethodsForModel);
        return driverMethodsForModel;
    }

    @Override
    public Object getDriverMethodOutput(EObject model, String methodName) {
        debug(">>>getDriverMethodOutput " + methodName);
        DatabaseDirectives modelDatabaseValues = getConnection(model);
        if (modelDatabaseValues == null)
            return null;
        Object methodCallOutput = null;
        try {
            DatabaseMetaData meta = modelDatabaseValues.connection.getMetaData();
            Method m = meta.getClass().getMethod(methodName, new Class[] {});
            methodCallOutput = m.invoke(meta, new Object[] {});
        } catch (SQLException e) {
            error("getDriverMethodOutput error " + e, e);
        } catch (NoSuchMethodException e) {
            error("getDriverMethodOutput error " + e, e);
        } catch (SecurityException e) {
            error("getDriverMethodOutput error " + e, e);
        } catch (IllegalAccessException e) {
            error("getDriverMethodOutput error " + e, e);
        } catch (IllegalArgumentException e) {
            error("getDriverMethodOutput error " + e, e);
        } catch (InvocationTargetException e) {
            error("getDriverMethodOutput error " + e, e);
        }
        debug("<<<getDriverMethodOutput", methodCallOutput);
        return methodCallOutput;
    }

    @Override
    public List<String> getCheckConstraints(EObject model) {
        debug(">>>getCheckConstraints");
        DatabaseDirectives modelDatabaseValues = getConnection(model);
        if (modelDatabaseValues == null)
            return Collections.emptyList();
        List<String> checkConstraintsForModel = checkConstraints.get(modelDatabaseValues.dir);
        if (checkConstraintsForModel != null)
            return checkConstraintsForModel;
        checkConstraintsForModel = Collections.synchronizedList(new ArrayList<String>());
        checkConstraints.put(modelDatabaseValues.dir, checkConstraintsForModel);
        if (modelDatabaseValues.connection != null) {
            try {
                DbType dbType = getDbType(model);
                Map<String, DbCheckConstraint> mapOfCheckConstraints = getCheckConstraints(modelDatabaseValues, null,
                        dbType);
                for (DbCheckConstraint check : mapOfCheckConstraints.values())
                    checkConstraintsForModel.add(check.getEnumName());
            } catch (SQLException e) {
                error("getCheckConstraints error " + e, e);
            }
        }
        debug("<<<getCheckConstraints", checkConstraintsForModel);
        return checkConstraintsForModel;
    }

    @Override
    public List<String> getCheckColumns(EObject model, String table) {
        debug(">>>getCheckColumns " + table);
        if (table == null)
            return Collections.emptyList();
        DatabaseDirectives modelDatabaseValues = getConnection(model);
        if (modelDatabaseValues == null)
            return Collections.emptyList();
        boolean doInit = false;
        Map<String, List<String>> allCheckColumnsForModel = checkColumns.get(modelDatabaseValues.dir);
        if (allCheckColumnsForModel == null) {
            allCheckColumnsForModel = Collections.synchronizedMap(new HashMap<String, List<String>>());
            checkColumns.put(modelDatabaseValues.dir, allCheckColumnsForModel);
            doInit = true;
        }
        List<String> checkColumnsForModel = allCheckColumnsForModel.get(table);
        if (checkColumnsForModel == null) {
            checkColumnsForModel = Collections.synchronizedList(new ArrayList<String>());
            allCheckColumnsForModel.put(table, checkColumnsForModel);
            doInit = true;
        }
        if (!doInit)
            return checkColumnsForModel;
        if (modelDatabaseValues.connection != null) {
            try {
                DbType dbType = getDbType(model);
                Map<String, DbCheckConstraint> mapOfCheckConstraints = getCheckConstraints(modelDatabaseValues, null,
                        dbType);
                for (DbCheckConstraint check : mapOfCheckConstraints.values()) {
                    if (table.equals(check.getEnumName())) {
                        for (String val : check.getValues()) {
                            if (!val.isEmpty()) {
                                if (Character.isDigit(val.charAt(0)))
                                    checkColumnsForModel.add("I" + val);
                                else
                                    checkColumnsForModel.add(val);
                            }
                        }
                        break;
                    }
                }
            } catch (SQLException e) {
                error("getCheckColumns error " + e, e);
            }
        }
        debug("<<<getCheckColumns", checkColumnsForModel);
        return checkColumnsForModel;
    }

    @Override
    public List<DbCheckConstraint> getDbCheckConstraints(EObject model, String table) {
        debug(">>>getDbCheckConstraints " + table);
        if (table == null)
            return Collections.emptyList();
        DatabaseDirectives modelDatabaseValues = getConnection(model);
        if (modelDatabaseValues == null || modelDatabaseValues.dbSkipCheckConstraints)
            return Collections.emptyList();
        boolean doInit = false;
        Map<String, List<DbCheckConstraint>> allCheckConstraintsForModel = dbChecksConstraints
                .get(modelDatabaseValues.dir);
        if (allCheckConstraintsForModel == null) {
            allCheckConstraintsForModel = Collections.synchronizedMap(new HashMap<String, List<DbCheckConstraint>>());
            dbChecksConstraints.put(modelDatabaseValues.dir, allCheckConstraintsForModel);
            doInit = true;
        }
        List<DbCheckConstraint> checkConstraintsForModel = allCheckConstraintsForModel.get(table);
        if (checkConstraintsForModel == null) {
            checkConstraintsForModel = Collections.synchronizedList(new ArrayList<DbCheckConstraint>());
            allCheckConstraintsForModel.put(table, checkConstraintsForModel);
            doInit = true;
        }
        if (!doInit)
            return checkConstraintsForModel;
        if (modelDatabaseValues.connection != null) {
            try {
                DbType dbType = getDbType(model);
                Map<String, DbCheckConstraint> mapOfCheckConstraints = getCheckConstraints(modelDatabaseValues,
                        origName(model, modelDatabaseValues, table), dbType);
                for (DbCheckConstraint check : mapOfCheckConstraints.values()) {
                    check.setTable(name(modelDatabaseValues, check.getTable()));
                    check.setColumn(name(modelDatabaseValues, check.getColumn()));
                }
                checkConstraintsForModel.addAll(mapOfCheckConstraints.values());
            } catch (SQLException e) {
                error("getDbCheckConstraints error " + e, e);
            }
        }
        debug("<<<getDbCheckConstraints", checkConstraintsForModel);
        return checkConstraintsForModel;
    }

    private Map<String, DbCheckConstraint> getCheckConstraints(DatabaseDirectives modelDatabaseValues, String table,
            DbType dbType) throws SQLException {
        Map<String, DbCheckConstraint> mapOfCheckConstraints = new LinkedHashMap<String, DbCheckConstraint>();
        // TODO - might be also schema and catalog should be taken into account
        if (dbType == DbType.HSQLDB) {
            String query = "select tc.TABLE_NAME, tc.CONSTRAINT_NAME, cc.CHECK_CLAUSE from INFORMATION_SCHEMA.TABLE_CONSTRAINTS tc, INFORMATION_SCHEMA.CHECK_CONSTRAINTS cc where tc.CONSTRAINT_NAME = cc.CONSTRAINT_NAME and tc.CONSTRAINT_TYPE = 'CHECK' and tc.TABLE_NAME = ?";
            String query2 = "select tc.TABLE_NAME, tc.CONSTRAINT_NAME, cc.CHECK_CLAUSE from INFORMATION_SCHEMA.TABLE_CONSTRAINTS tc, INFORMATION_SCHEMA.CHECK_CONSTRAINTS cc where tc.CONSTRAINT_NAME = cc.CONSTRAINT_NAME and tc.CONSTRAINT_TYPE = 'CHECK'";
            Map<String, List<String>> map = getCheckConstraints(modelDatabaseValues, table, query, query2, false);
            for (String constraintName : map.keySet()) {
                DbCheckConstraint check = DbCheckConstraint.parseHsqldb(constraintName, map.get(constraintName).get(0));
                if (check != null)
                    mapOfCheckConstraints.put(constraintName, check);
            }
        } else if (dbType == DbType.ORACLE) {
            String query = "select TABLE_NAME, CONSTRAINT_NAME, SEARCH_CONDITION from USER_CONSTRAINTS where TABLE_NAME not like 'BIN%' and CONSTRAINT_TYPE = 'C' and TABLE_NAME = ?";
            String query2 = "select TABLE_NAME, CONSTRAINT_NAME, SEARCH_CONDITION from USER_CONSTRAINTS where TABLE_NAME not like 'BIN%' and CONSTRAINT_TYPE = 'C'";
            Map<String, List<String>> map = getCheckConstraints(modelDatabaseValues, table, query, query2, false);
            for (String constraintName : map.keySet()) {
                DbCheckConstraint check = DbCheckConstraint.parseOracle(constraintName, map.get(constraintName).get(0),
                        map.get(constraintName).get(1));
                if (check != null)
                    mapOfCheckConstraints.put(constraintName, check);
            }
        } else if (dbType == DbType.INFORMIX) {
            String query = "select st.tabname, ss.constrname, sc.checktext from systables st, sysconstraints ss, syschecks sc where st.tabid = ss.tabid and ss.constrid = sc.constrid and ss.constrtype = 'C' and sc.type = 'T' and st.tabname = ?";
            String query2 = "select st.tabname, ss.constrname, sc.checktext from systables st, sysconstraints ss, syschecks sc where st.tabid = ss.tabid and ss.constrid = sc.constrid and ss.constrtype = 'C' and sc.type = 'T'";
            Map<String, List<String>> map = getCheckConstraints(modelDatabaseValues, table, query, query2, false);
            for (String constraintName : map.keySet()) {
                DbCheckConstraint check = DbCheckConstraint.parseInformix(constraintName, map.get(constraintName)
                        .get(0), map.get(constraintName).get(1));
                if (check != null)
                    mapOfCheckConstraints.put(constraintName, check);
            }
        } else if (dbType == DbType.MY_SQL) {
            String query = "select TABLE_NAME,COLUMN_NAME,COLUMN_TYPE from information_schema.COLUMNS where DATA_TYPE = \"enum\" and TABLE_NAME = ?";
            String query2 = "select TABLE_NAME,COLUMN_NAME,COLUMN_TYPE from information_schema.COLUMNS where DATA_TYPE = \"enum\"";
            Map<String, List<String>> map = getCheckConstraints(modelDatabaseValues, table, query, query2, true);
            for (String constraintName : map.keySet()) {
                DbCheckConstraint check = DbCheckConstraint.parseMysql(map.get(constraintName).get(2),
                        map.get(constraintName).get(0), map.get(constraintName).get(1));
                if (check != null)
                    mapOfCheckConstraints.put(constraintName, check);
            }
        } else if (dbType == DbType.POSTGRESQL) {
            String query = "select ccu.table_name, ccu.column_name, cc.check_clause from information_schema.constraint_column_usage ccu, information_schema.check_constraints cc where ccu.constraint_name = cc.constraint_name and ccu.table_name = ?";
            String query2 = "select ccu.table_name, ccu.column_name, cc.check_clause from information_schema.constraint_column_usage ccu, information_schema.check_constraints cc where ccu.constraint_name = cc.constraint_name";
            Map<String, List<String>> map = getCheckConstraints(modelDatabaseValues, table, query, query2, true);
            for (String constraintName : map.keySet()) {
                DbCheckConstraint check = DbCheckConstraint.parsePostgresql(map.get(constraintName).get(2),
                        map.get(constraintName).get(0), map.get(constraintName).get(1));
                if (check != null)
                    mapOfCheckConstraints.put(constraintName, check);
            }
        } else if (dbType == DbType.DB2) {
            String query = "select cc.TABNAME, cc.COLNAME, ch.TEXT from SYSCAT.COLCHECKS cc, SYSCAT.CHECKS ch where cc.TABNAME = ch.TABNAME and cc.CONSTNAME = ch.CONSTNAME and ch.TYPE = 'C' and cc.TABNAME = ?";
            String query2 = "select cc.TABNAME, cc.COLNAME, ch.TEXT from SYSCAT.COLCHECKS cc, SYSCAT.CHECKS ch where cc.TABNAME = ch.TABNAME and cc.CONSTNAME = ch.CONSTNAME and ch.TYPE = 'C'";
            Map<String, List<String>> map = getCheckConstraints(modelDatabaseValues, table, query, query2, true);
            for (String constraintName : map.keySet()) {
                DbCheckConstraint check = DbCheckConstraint.parseDb2(map.get(constraintName).get(2),
                        map.get(constraintName).get(0), map.get(constraintName).get(1));
                if (check != null)
                    mapOfCheckConstraints.put(constraintName, check);
            }
        } else {
            mapOfCheckConstraints = new LinkedHashMap<String, DbCheckConstraint>();
        }
        return mapOfCheckConstraints;
    }

    private Map<String, List<String>> getCheckConstraints(DatabaseDirectives modelDatabaseValues, String table,
            String query, String query2, boolean combine) throws SQLException {
        Map<String, List<String>> mapOfCheckConstraints = new LinkedHashMap<String, List<String>>();
        ResultSet result = null;
        try {
            if (table != null) {
                PreparedStatement stmt = modelDatabaseValues.connection.prepareStatement(query);
                stmt.setString(1, table);
                result = stmt.executeQuery();
            } else {
                Statement stmt = modelDatabaseValues.connection.createStatement();
                result = stmt.executeQuery(query2);
            }
            String lastTableName = null;
            String lastConstraintName = null;
            String lastCheckClause = null;
            while (result.next()) {
                String tableName = name(modelDatabaseValues, result.getString(1));
                String constraintName = result.getString(2);
                String checkClause = result.getString(3);
                if (lastConstraintName == null) {
                    lastTableName = tableName;
                    lastConstraintName = constraintName;
                    lastCheckClause = checkClause;
                } else if (lastConstraintName.equals(constraintName)) {
                    lastCheckClause = lastCheckClause + checkClause;
                } else {
                    addCheckConstraints(mapOfCheckConstraints, lastTableName, lastConstraintName, lastCheckClause,
                            combine);
                    lastTableName = tableName;
                    lastConstraintName = constraintName;
                    lastCheckClause = checkClause;
                }
            }
            if (lastConstraintName != null) {
                addCheckConstraints(mapOfCheckConstraints, lastTableName, lastConstraintName, lastCheckClause, combine);
            }
        } finally {
            try {
                if (result != null)
                    result.close();
            } catch (SQLException e) {
                error("getHsqldbCheckConstraints error " + e, e);
            }
        }
        return mapOfCheckConstraints;
    }

    private void addCheckConstraints(Map<String, List<String>> mapOfCheckConstraints, String tableName,
            String constraintName, String checkClause, boolean combine) {
        System.out.println(tableName + " constraintName " + constraintName + ", " + " checkClause " + checkClause);
        List<String> list = new ArrayList<String>();
        list.add(checkClause);
        list.add(tableName);
        list.add(constraintName);
        if (combine)
            mapOfCheckConstraints.put(tableName + constraintName, list);
        else
            mapOfCheckConstraints.put(constraintName, list);
    }

    private void dump(ResultSetMetaData meta) throws SQLException {
        for (int i = 1; i <= meta.getColumnCount(); i++) {
            System.out.println("" + i + " " + meta.getColumnName(i) + " " + meta.getColumnType(i) + " "
                    + meta.getColumnTypeName(i));
        }
    }

    private DbType getDbType(EObject model) {
        DbType dbType = getDatabaseDirectives(model).dbType;
        if (dbType == null) {
            DbType[] dbTypes = DbType.fromDbMetaInfo(getDbMetaInfo(model));
            if (dbTypes != null && dbTypes.length > 0)
                dbType = dbTypes[0];
        }
        return dbType;
    }

    private void trace(String msg) {
        if (trace)
            System.out.println(msg);
        else if (LOGGER.isTraceEnabled())
            LOGGER.trace(msg);
    }

    private void trace(String msg, Object object) {
        if (trace)
            System.out.println(msg + " " + object);
        else if (LOGGER.isTraceEnabled())
            LOGGER.trace(msg);
    }

    private void debug(String msg) {
        if (debug)
            System.out.println(msg);
        else if (LOGGER.isDebugEnabled())
            LOGGER.debug(msg);
    }

    private void debug(String msg, Object object) {
        if (debug)
            System.out.println(msg + " " + object);
        else if (LOGGER.isDebugEnabled())
            LOGGER.debug(msg);
    }

    private void info(String msg) {
        if (debug)
            System.out.println(msg);
        else if (LOGGER.isInfoEnabled())
            LOGGER.info(msg);
    }

    private void error(String msg, Exception e) {
        if (debug) {
            System.out.println(msg);
            e.printStackTrace();
        } else
            LOGGER.error(msg, e);
    }

    private String name(DatabaseDirectives modelDatabaseValues, String s) {
        if (s == null)
            return null;
        String ss = s;
        if (dbOriginalNames.get(modelDatabaseValues.dir) == null)
            dbOriginalNames.put(modelDatabaseValues.dir, Collections.synchronizedMap(new HashMap<String, String>()));
        if (modelDatabaseValues.dbUppercaseNames)
            ss = s.toUpperCase();
        else if (modelDatabaseValues.dbLowercaseNames)
            ss = s.toLowerCase();
        dbOriginalNames.get(modelDatabaseValues.dir).put(ss, s);
        // System.out.println(">>>name " + s + " -> " + ss);
        return ss;
    }

    private String origName(EObject model, DatabaseDirectives modelDatabaseValues, String s) {
        String ss = s;
        if (s != null) {
            if (dbOriginalNames.get(modelDatabaseValues.dir) == null) {
                getTables(model);
                getProcedures(model);
                getFunctions(model);
            }
            ss = dbOriginalNames.get(modelDatabaseValues.dir).get(s);
        }
        // System.out.println(">>>origName " + s + " -> " + ss);
        return ss;
    }

    @Override
    protected void finalize() throws Throwable {
        // TODO - how to close connection in the process of the IDE shutdown?
        // for (Entry<String, DatabaseValues> modelDatabaseValues : connections.entrySet()) {
        // closeConnection(modelDatabaseValues.getValue());
        // }
        super.finalize();
    }
}
