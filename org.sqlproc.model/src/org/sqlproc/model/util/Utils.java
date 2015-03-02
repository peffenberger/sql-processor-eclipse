package org.sqlproc.model.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.IScopeProvider;
import org.eclipse.xtext.serializer.ISerializer;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.xtype.XImportDeclaration;
import org.sqlproc.model.generator.TableDaoGenerator;
import org.sqlproc.model.generator.TablePojoGenerator;
import org.sqlproc.model.processorModel.AbstractEntity;
import org.sqlproc.model.processorModel.AnnotatedEntity;
import org.sqlproc.model.processorModel.Artifacts;
import org.sqlproc.model.processorModel.DaoEntity;
import org.sqlproc.model.processorModel.EnumEntity;
import org.sqlproc.model.processorModel.FunctionDefinition;
import org.sqlproc.model.processorModel.Package;
import org.sqlproc.model.processorModel.PojoAttribute;
import org.sqlproc.model.processorModel.PojoEntity;
import org.sqlproc.model.processorModel.PojoProcedure;
import org.sqlproc.model.processorModel.ProcedureDefinition;
import org.sqlproc.model.processorModel.TableDefinition;
import org.sqlproc.model.property.ModelProperty;
import org.sqlproc.model.resolver.DbResolver;
import org.sqlproc.model.resolver.DbResolver.DbType;

public class Utils {

    @SuppressWarnings("unchecked")
    public static <T extends EObject> List<T> getContentsOfType(EObject ele, Class<T> type) {
        List<T> result = new ArrayList<T>();
        if (ele == null)
            return result;
        for (EObject object : ele.eContents()) {
            if (type.isAssignableFrom(object.getClass())) {
                result.add((T) object);
            }
        }
        return result;
    }

    public static String resourceDir(Resource resource) {
        String uri = (resource.getURI() != null) ? resource.getURI().toString() : null;
        String dir = null;
        if (uri != null) {
            dir = uri;
            int ix = uri.lastIndexOf("/");
            if (ix > 0)
                dir = uri.substring(0, ix);
        }
        return dir;
    }

    public static List<String> findTables(IQualifiedNameConverter qualifiedNameConverter, Artifacts artifacts,
            IScope scope) {
        List<String> names = new ArrayList<String>();
        Iterable<IEObjectDescription> iterable = scope.getAllElements();
        for (Iterator<IEObjectDescription> iter = iterable.iterator(); iter.hasNext();) {
            IEObjectDescription description = iter.next();
            EObject obj = artifacts.eResource().getResourceSet().getEObject(description.getEObjectURI(), true);
            if (obj instanceof TableDefinition)
                names.add(((TableDefinition) obj).getTable());
        }
        return names;
    }

    public static List<String> findFunctions(IQualifiedNameConverter qualifiedNameConverter, Artifacts artifacts,
            IScope scope) {
        List<String> names = new ArrayList<String>();
        Iterable<IEObjectDescription> iterable = scope.getAllElements();
        for (Iterator<IEObjectDescription> iter = iterable.iterator(); iter.hasNext();) {
            IEObjectDescription description = iter.next();
            EObject obj = artifacts.eResource().getResourceSet().getEObject(description.getEObjectURI(), true);
            if (obj instanceof FunctionDefinition)
                names.add(((FunctionDefinition) obj).getTable());
        }
        return names;
    }

    public static List<String> findProcedures(IQualifiedNameConverter qualifiedNameConverter, Artifacts artifacts,
            IScope scope) {
        List<String> names = new ArrayList<String>();
        Iterable<IEObjectDescription> iterable = scope.getAllElements();
        for (Iterator<IEObjectDescription> iter = iterable.iterator(); iter.hasNext();) {
            IEObjectDescription description = iter.next();
            EObject obj = artifacts.eResource().getResourceSet().getEObject(description.getEObjectURI(), true);
            if (obj instanceof ProcedureDefinition)
                names.add(((ProcedureDefinition) obj).getTable());
        }
        return names;
    }

    public static DbType getDbType(DbResolver dbResolver, Artifacts artifacts) {
        DbType dbType = dbResolver.getDatabaseDirectives(artifacts).dbType;
        if (dbType == null) {
            DbType[] dbTypes = DbType.fromDbMetaInfo(dbResolver.getDbMetaInfo(artifacts));
            if (dbTypes != null && dbTypes.length > 0)
                dbType = dbTypes[0];
        }
        return dbType;
    }

    public static String toCamelCase(String value) {
        if (value == null)
            return null;
        String[] parts = value.split("_");
        String camelCaseString = "";
        for (String part : parts) {
            if (camelCaseString.length() == 0)
                camelCaseString = camelCaseString + part.toLowerCase();
            else if (part.length() == 1)
                camelCaseString = camelCaseString + part.toUpperCase();
            else if (part.length() > 1)
                camelCaseString = camelCaseString + part.substring(0, 1).toUpperCase()
                        + part.substring(1).toLowerCase();
        }
        return camelCaseString;
    }

    public static String toCamelCase(Class<?> clazz) {
        if (clazz == null)
            return null;
        String camelCaseString = clazz.getSimpleName();
        if (camelCaseString.length() == 1)
            camelCaseString = camelCaseString.toLowerCase();
        else if (camelCaseString.length() > 1)
            camelCaseString = camelCaseString.substring(0, 1).toLowerCase() + camelCaseString.substring(1);
        return camelCaseString;
    }

    public static String getPojoColumns(List<String> columns) {
        if (columns == null)
            return null;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < columns.size(); i++) {
            builder.append(':').append(toCamelCase(columns.get(i)));
            if (i < columns.size() - 1)
                builder.append(", ");
        }
        return builder.toString();
    }

    public static String getSelectColumns(List<String> columns) {
        if (columns == null)
            return null;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < columns.size(); i++) {
            builder.append("%" + columns.get(i)).append(" @").append(toCamelCase(columns.get(i)));
            if (i < columns.size() - 1)
                builder.append(", ");
        }
        return builder.toString();
    }

    public static String getInsertColumns(List<String> columns) {
        if (columns == null)
            return null;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < columns.size(); i++) {
            builder.append("%" + columns.get(i));
            if (i < columns.size() - 1)
                builder.append(", ");
        }
        return builder.toString();
    }

    public static String getUpdateColumns(List<String> columns) {
        if (columns == null)
            return null;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < columns.size(); i++) {
            builder.append("%" + columns.get(i)).append(" = :").append(toCamelCase(columns.get(i)));
            if (i < columns.size() - 1)
                builder.append(", ");
        }
        return builder.toString();
    }

    public static String getCondColumns(List<String> columns) {
        if (columns == null)
            return null;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < columns.size(); i++) {
            builder.append("\n  {& ").append("%" + columns.get(i)).append(" = :").append(toCamelCase(columns.get(i)))
                    .append(" }");
        }
        return builder.toString();
    }

    public static String getVerUpdateColumns(List<String> columns) {
        if (columns == null)
            return null;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < columns.size(); i++) {
            if (columns.get(i).toUpperCase().indexOf("VER") == 0) {
                builder.append("%" + columns.get(i)).append(" = :").append(toCamelCase(columns.get(i)))
                        .append(" + 1, ");
                break;
            }
        }
        return builder.toString();
    }

    public static String getOptUpdateColumns(List<String> columns) {
        if (columns == null)
            return null;
        boolean idFind = false;
        boolean verFind = false;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < columns.size(); i++) {
            if (!idFind
                    && (columns.get(i).toUpperCase().equals("ID") || columns.get(i).toUpperCase().indexOf("ID_") == 0)) {
                idFind = true;
                continue;
            }
            if (!verFind && columns.get(i).toUpperCase().indexOf("VER") == 0) {
                verFind = true;
                continue;
            }
            builder.append("%" + columns.get(i)).append(" = :").append(toCamelCase(columns.get(i)));
            if (i < columns.size() - 1)
                builder.append(", ");
        }
        return builder.toString();
    }

    public static String getOptCondColumns(List<String> columns) {
        if (columns == null)
            return null;
        boolean idFind = false;
        boolean verFind = false;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < columns.size(); i++) {
            if (!idFind
                    && (columns.get(i).toUpperCase().equals("ID") || columns.get(i).toUpperCase().indexOf("ID_") == 0)) {
                idFind = true;
                builder.append("\n  {& ").append("%" + columns.get(i)).append(" = :")
                        .append(toCamelCase(columns.get(i))).append(" }");
                continue;
            }
            if (!verFind && columns.get(i).toUpperCase().indexOf("VER") == 0) {
                verFind = true;
                builder.append("\n  {& ").append("%" + columns.get(i)).append(" = :")
                        .append(toCamelCase(columns.get(i))).append(" }");
                continue;
            }
        }
        return builder.toString();
    }

    public static String getPojoDefinitions(List<Class<?>> pojoClasses) {
        if (pojoClasses == null)
            return null;
        TreeMap<String, String> map = new TreeMap<String, String>();
        for (Class<?> clazz : pojoClasses) {
            map.put(toCamelCase(clazz), clazz.getName());
        }

        StringBuilder builder = new StringBuilder();
        for (Entry<String, String> pojo : map.entrySet()) {
            builder.append("pojo ").append(Strings.toFirstUpper(pojo.getKey())).append(' ').append(pojo.getValue())
                    .append(";\n");
        }
        return builder.toString();
    }

    public static String getTablesDefinitions(List<String> tables, List<String> tablesPresented) {
        if (tables == null)
            return null;
        Set<String> set = (tablesPresented != null) ? new HashSet<String>(tablesPresented) : new HashSet<String>();
        TreeMap<String, String> map = new TreeMap<String, String>();
        for (String table : tables) {
            if (table.toUpperCase().startsWith("BIN$"))
                continue;
            if (set.contains(table))
                continue;
            map.put(toCamelCase(table), table);
        }

        StringBuilder builder = new StringBuilder();
        for (Entry<String, String> table : map.entrySet()) {
            builder.append("table ").append(table.getKey()).append(' ').append(table.getValue()).append(";\n");
        }
        return builder.toString();
    }

    public static String getProceduresDefinitions(List<String> procedures, List<String> proceduresPresented) {
        if (procedures == null)
            return null;
        Set<String> set = (proceduresPresented != null) ? new HashSet<String>(proceduresPresented)
                : new HashSet<String>();
        TreeMap<String, String> map = new TreeMap<String, String>();
        for (String procedure : procedures) {
            if (procedure.toUpperCase().startsWith("BIN$"))
                continue;
            if (set.contains(procedure))
                continue;
            map.put(toCamelCase(procedure), procedure);
        }

        StringBuilder builder = new StringBuilder();
        for (Entry<String, String> procedure : map.entrySet()) {
            builder.append("procedure ").append(procedure.getKey()).append(' ').append(procedure.getValue())
                    .append(";\n");
        }
        return builder.toString();
    }

    public static String getFunctionsDefinitions(List<String> functions, List<String> functionsPresented) {
        if (functions == null)
            return null;
        Set<String> set = (functionsPresented != null) ? new HashSet<String>(functionsPresented)
                : new HashSet<String>();
        TreeMap<String, String> map = new TreeMap<String, String>();
        for (String function : functions) {
            if (function.toUpperCase().startsWith("BIN$"))
                continue;
            if (set.contains(function))
                continue;
            map.put(toCamelCase(function), function);
        }

        StringBuilder builder = new StringBuilder();
        for (Entry<String, String> function : map.entrySet()) {
            builder.append("function ").append(function.getKey()).append(' ').append(function.getValue()).append(";\n");
        }
        return builder.toString();
    }

    public static StringBuilder removeBlankLines(StringBuilder sb) {
        int len = sb.length();
        while (len > 0) {
            for (int i = 0; i < len; i++) {
                char c = sb.charAt(i);
                if (c == ' ')
                    continue;
                if (c != '\n')
                    return sb;
                sb.delete(0, i + 1);
                break;
            }
            len = sb.length();
        }
        return sb;
    }

    public static String removeBlankLines(String s) {
        StringBuilder sb = new StringBuilder(s);
        int len = sb.length();
        while (len > 0) {
            for (int i = 0; i < len; i++) {
                char c = sb.charAt(i);
                if (c == ' ')
                    continue;
                if (c != '\n')
                    return sb.delete(0, i).toString();
                sb.delete(0, i + 1);
                break;
            }
            len = sb.length();
        }
        return sb.toString();
    }

    public static Set<String> getImports(Package packagex, ISerializer serializer) {
        Set<String> imports = new HashSet<String>();
        if (packagex.getImportSection() != null && packagex.getImportSection().getImportDeclarations() != null) {
            for (XImportDeclaration imp : packagex.getImportSection().getImportDeclarations()) {
                imports.add(removeBlankLines(serializer.serialize(imp)).substring(7));
            }
        }
        return imports;
    }

    public static String generatePojo(Artifacts artifacts, Package packagex, ISerializer serializer,
            DbResolver dbResolver, IScopeProvider scopeProvider, ModelProperty modelProperty) {
        if (artifacts == null || !dbResolver.isResolveDb(artifacts) || packagex == null)
            return null;
        if (serializer == null)
            serializer = ((XtextResource) packagex.eResource()).getSerializer();

        Set<String> imports = (packagex != null) ? getImports(packagex, serializer) : null;
        Map<String, String> finalEntities = new HashMap<String, String>();
        Map<String, Map<String, String>> finalFeatures = new HashMap<String, Map<String, String>>();
        Annotations annotations = new Annotations();
        if (packagex != null) {
            for (AbstractEntity ape : packagex.getElements()) {
                if (ape instanceof AnnotatedEntity && ((AnnotatedEntity) ape).getEntity() instanceof PojoEntity) {
                    PojoEntity pojo = (PojoEntity) ((AnnotatedEntity) ape).getEntity();
                    Annotations.grabAnnotations((AnnotatedEntity) ape, annotations);
                    if (pojo.isFinal()) {
                        // ISerializer serializer = ((XtextResource) pojo.eResource()).getSerializer();
                        finalEntities.put(pojo.getName(), serializer.serialize(pojo));
                    } else {
                        Map<String, String> map;
                        finalFeatures.put(pojo.getName(), map = new HashMap<String, String>());
                        for (PojoAttribute attr : pojo.getAttributes()) {
                            if (attr.isFinal())
                                map.put(attr.getName(), serializer.serialize(attr));
                        }
                        for (PojoProcedure proc : pojo.getProcedures()) {
                            if (proc.isFinal())
                                map.put(proc.getName(), serializer.serialize(proc));
                        }
                    }
                } else if (ape instanceof AnnotatedEntity && ((AnnotatedEntity) ape).getEntity() instanceof EnumEntity) {
                    EnumEntity pojo = (EnumEntity) ((AnnotatedEntity) ape).getEntity();
                    Annotations.grabAnnotations((AnnotatedEntity) ape, annotations);
                    if (pojo.isFinal()) {
                        // ISerializer serializer = ((XtextResource) pojo.eResource()).getSerializer();
                        finalEntities.put(pojo.getName(), serializer.serialize(pojo));
                    } else {
                        Map<String, String> map;
                        finalFeatures.put(pojo.getName(), map = new HashMap<String, String>());
                        for (PojoProcedure proc : pojo.getProcedures()) {
                            if (proc.isFinal())
                                map.put(proc.getName(), serializer.serialize(proc));
                        }
                    }
                }
            }
        }

        // List<String> tables = dbResolver.getTables(artifacts);
        List<String> dbSequences = dbResolver.getSequences(artifacts);
        DbType dbType = Utils.getDbType(dbResolver, artifacts);
        TablePojoGenerator generator = new TablePojoGenerator(modelProperty, artifacts, finalEntities, finalFeatures,
                annotations, imports, dbSequences, dbType);
        if (generator.addDefinitions(dbResolver, scopeProvider))
            return generator.getPojoDefinitions(modelProperty, artifacts, serializer);
        return null;
    }

    public static String generateDao(Artifacts artifacts, Package packagex, ISerializer serializer,
            DbResolver dbResolver, IScopeProvider scopeProvider, ModelProperty modelProperty) {
        if (artifacts == null || !dbResolver.isResolveDb(artifacts))
            return null;
        if (serializer == null)
            serializer = ((XtextResource) packagex.eResource()).getSerializer();

        Set<String> imports = (packagex != null) ? getImports(packagex, serializer) : null;
        Map<String, String> finalDaos = new HashMap<String, String>();
        Map<String, Map<String, String>> finalFeatures = new HashMap<String, Map<String, String>>();
        Annotations annotations = new Annotations();
        if (packagex != null) {
            for (AbstractEntity ape : packagex.getElements()) {
                if (ape instanceof AnnotatedEntity && ((AnnotatedEntity) ape).getEntity() instanceof DaoEntity) {
                    DaoEntity dao = (DaoEntity) ((AnnotatedEntity) ape).getEntity();
                    Annotations.grabAnnotations((AnnotatedEntity) ape, annotations);
                    if (dao.isFinal()) {
                        // ISerializer serializer = ((XtextResource) dao.eResource()).getSerializer();
                        finalDaos.put(dao.getName(), serializer.serialize(dao));
                    } else {
                        Map<String, String> map;
                        finalFeatures.put(dao.getName(), map = new HashMap<String, String>());
                        for (PojoAttribute attr : dao.getAttributes()) {
                            // if (attr.isFinal())
                            map.put(attr.getName(), serializer.serialize(attr));
                        }
                        for (PojoProcedure proc : dao.getProcedures()) {
                            // if (proc.isFinal())
                            map.put(proc.getName(), serializer.serialize(proc));
                        }
                    }
                }
            }
        }

        // List<String> tables = dbResolver.getTables(artifacts);
        List<String> dbSequences = dbResolver.getSequences(artifacts);
        DbType dbType = getDbType(dbResolver, artifacts);
        TableDaoGenerator generator = new TableDaoGenerator(modelProperty, artifacts, scopeProvider, finalDaos,
                finalFeatures, annotations, imports, dbSequences, dbType);
        if (generator.addDefinitions(dbResolver, scopeProvider))
            return generator.getDaoDefinitions(modelProperty, artifacts, serializer);
        return null;
    }
}
