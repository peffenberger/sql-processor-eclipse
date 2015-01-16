package org.sqlproc.dsl.generator;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.log4j.Logger;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.scoping.IScopeProvider;
import org.sqlproc.dsl.processorDsl.Artifacts;
import org.sqlproc.dsl.processorDsl.PojoType;
import org.sqlproc.dsl.property.ImplementsExtends;
import org.sqlproc.dsl.property.ModelProperty;
import org.sqlproc.dsl.property.PojoAttribute;
import org.sqlproc.dsl.resolver.DbResolver.DbType;
import org.sqlproc.dsl.util.Debug;

public class TableDaoGenerator extends TableMetaGenerator {

    protected Logger LOGGER = Logger.getLogger(TableDaoGenerator.class);
    private Debug debug = new Debug(LOGGER);

    protected Map<String, String> finalDaos;
    protected Set<String> daoIgnoreTables = new HashSet<String>();
    protected Set<String> daoOnlyTables = new HashSet<String>();
    protected String daoImplementationPackage;
    protected Map<String, ImplementsExtends> daoToImplements = new HashMap<String, ImplementsExtends>();
    protected ImplementsExtends daoToExtends = null;
    protected boolean daoMakeItFinal;
    protected Map<String, PojoType> daoFunctionsResult = new HashMap<String, PojoType>();
    protected Set<String> notGenerics;
    protected Set<String> generics;
    protected Filter daoActiveFilter = null;

    public TableDaoGenerator() {
        super();
    }

    public TableDaoGenerator(ModelProperty modelProperty, Artifacts artifacts, String suffix,
            IScopeProvider scopeProvider, Map<String, String> finalDaos, List<String> dbSequences, DbType dbType) {
        super(modelProperty, artifacts, null, Collections.<String, String> emptyMap(), dbSequences, dbType);

        debug = new Debug(modelProperty.getDaoDebugLevel(artifacts), modelProperty.getDaoDebugScope(artifacts), LOGGER);

        this.suffix = (suffix != null) ? suffix : "";
        this.finalDaos = finalDaos;

        Set<String> daoIgnoreTables = modelProperty.getDaoIgnoreTables(artifacts);
        if (daoIgnoreTables != null) {
            this.daoIgnoreTables.addAll(daoIgnoreTables);
        }
        Set<String> daoOnlyTables = modelProperty.getDaoOnlyTables(artifacts);
        if (daoOnlyTables != null) {
            this.daoOnlyTables.addAll(daoOnlyTables);
        }
        this.daoImplementationPackage = modelProperty.getDaoImplementationPackage(artifacts);
        Map<String, ImplementsExtends> daoToImplements = modelProperty.getDaoToImplements(artifacts);
        if (daoToImplements != null) {
            this.daoToImplements.putAll(daoToImplements);
        }
        this.daoToExtends = modelProperty.getDaoToExtends(artifacts);
        this.daoMakeItFinal = modelProperty.isDaoMakeItFinal(artifacts);
        Map<String, PojoType> daoFunctionsResult = modelProperty.getDaoFunctionsResult(artifacts);
        if (daoFunctionsResult != null) {
            this.daoFunctionsResult.putAll(daoFunctionsResult);
        }
        this.daoActiveFilter = Filter.parse(modelProperty.getDaoActiveFilter(artifacts));

        if (debug.debug) {
            System.out.println("finalDaos " + this.finalDaos);
            System.out.println("daoIgnoreTables " + this.daoIgnoreTables);
            System.out.println("daoOnlyTables " + this.daoOnlyTables);
            System.out.println("daoImplementationPackage " + this.daoImplementationPackage);
            System.out.println("daoToImplements " + this.daoToImplements);
            System.out.println("daoToExtends " + this.daoToExtends);
            System.out.println("daoFunctionsResult " + this.daoFunctionsResult);
            System.out.println("daoActiveFilter " + this.daoActiveFilter);
        }
    }

    public String getDaoDefinitions(ModelProperty modelProperty, Artifacts artifacts) {
        String result = getDaoDefinitions();
        return replaceAll(modelProperty, result, artifacts);
    }

    public String getDaoDefinitions() {
        try {
            if (debug.debug) {
                System.out.println("pojos " + this.pojos);
                System.out.println("pojoExtends " + this.pojoExtends);
                System.out.println("pojoInheritanceDiscriminator " + this.pojoInheritanceDiscriminator);
                System.out.println("pojoInheritanceSimple " + this.pojoInheritanceSimple);
                System.out.println("pojoDiscriminators " + this.pojoDiscriminators);
                System.out.println("indexes " + this.indexes);
                System.out.println("procedures " + this.procedures);
                System.out.println("functions " + this.functions);
            }

            StringBuilder buffer = new StringBuilder();
            boolean isSerializable = false;
            Set<String> serializables = new HashSet<String>();
            boolean oneMoreLine = false;
            if (!daoToImplements.isEmpty()) {
                for (ImplementsExtends ie : daoToImplements.values()) {
                    JvmType type = ie.getToImplement();
                    if (type.getIdentifier().endsWith("Serializable")) {
                        if (!ie.getDbTables().isEmpty()) {
                            for (String dbTable : ie.getDbTables()) {
                                if (dbTable.equalsIgnoreCase("Procedures"))
                                    serializables.add("Procedures");
                                else if (dbTable.equalsIgnoreCase("Functions"))
                                    serializables.add("Functions");
                                else
                                    serializables.add(dbTable);
                            }
                            continue;
                        }
                        if (!ie.getDbNotTables().isEmpty()) {
                            for (String pojo : pojos.keySet()) {
                                serializables.add(pojo);
                            }
                            for (String pojo : enums.keySet()) {
                                serializables.add(pojo);
                            }
                            serializables.add("Procedures");
                            serializables.add("Functions");
                            for (String dbTable : ie.getDbNotTables()) {
                                serializables.remove(dbTable);
                            }
                            continue;
                        }
                        isSerializable = true;
                        continue;
                    }
                    buffer.append("\n  implements ").append(type.getIdentifier());
                    if (ie.isGenerics()) {
                        buffer.append(" <<>>");
                        if (notGenerics == null)
                            notGenerics = new HashSet<String>();
                        if (generics == null)
                            generics = new HashSet<String>();
                    }
                    if (!ie.getDbTables().isEmpty()) {
                        buffer.append(" onlyDaos");
                        for (String dbColumn : ie.getDbTables()) {
                            String pojoName = tableNames.get(dbColumn);
                            if (pojoName == null)
                                pojoName = dbColumn;
                            String daoName = tableToCamelCase(pojoName) + "Dao";
                            if (generics != null)
                                generics.add(daoName);
                            buffer.append(" ").append(daoName);
                        }
                    }
                    if (!ie.getDbNotTables().isEmpty()) {
                        buffer.append(" exceptDaos");
                        for (String dbColumn : ie.getDbNotTables()) {
                            String pojoName = tableNames.get(dbColumn);
                            if (pojoName == null)
                                pojoName = dbColumn;
                            String daoName = tableToCamelCase(pojoName) + "Dao";
                            if (notGenerics != null)
                                notGenerics.add(daoName);
                            buffer.append(" ").append(daoName);
                        }
                    }
                }
                oneMoreLine = true;
            }
            if (generics != null && notGenerics != null) {
                notGenerics.removeAll(generics);
            }
            if (daoToExtends != null) {
                JvmType type = daoToExtends.getToImplement();
                buffer.append("\n  extends ").append(type.getIdentifier());
                if (daoToExtends.isGenerics())
                    buffer.append(" <<>>");
                if (!daoToExtends.getDbTables().isEmpty()) {
                    buffer.append(" onlyDaos");
                    for (String dbColumn : daoToExtends.getDbTables()) {
                        String pojoName = tableNames.get(dbColumn);
                        if (pojoName == null)
                            pojoName = dbColumn;
                        String daoName = tableToCamelCase(pojoName) + "Dao";
                        buffer.append(" ").append(daoName);
                    }
                }
                if (!daoToExtends.getDbNotTables().isEmpty()) {
                    buffer.append(" exceptDaos");
                    for (String dbColumn : daoToExtends.getDbNotTables()) {
                        String pojoName = tableNames.get(dbColumn);
                        if (pojoName == null)
                            pojoName = dbColumn;
                        String daoName = tableToCamelCase(pojoName) + "Dao";
                        buffer.append(" ").append(daoName);
                    }
                }
                oneMoreLine = true;
            }
            if (daoImplementationPackage != null) {
                buffer.append("\n  implementation-package ").append(daoImplementationPackage);
                oneMoreLine = true;
            }
            if (oneMoreLine) {
                buffer.append("\n");
            }
            for (String pojo : pojos.keySet()) {
                // System.out.println("QQQQQ " + pojo);
                if (!daoOnlyTables.isEmpty() && !daoOnlyTables.contains(pojo))
                    continue;
                if (daoIgnoreTables.contains(pojo))
                    continue;
                if (!Filter.isTable(daoActiveFilter, pojo))
                    continue;
                String pojoName = tableNames.get(pojo);
                if (pojoName == null)
                    pojoName = pojo;
                String daoName = tableToCamelCase(pojoName) + "Dao";
                if (finalDaos.containsKey(daoName)) {
                    buffer.append(getFinalContent(finalDaos.get(daoName)));
                    continue;
                }
                if (pojoInheritanceDiscriminator.containsKey(pojo) || pojoInheritanceSimple.containsKey(pojo)) {
                    if (!notAbstractTables.contains(pojo))
                        continue;
                }
                if (isSerializable || serializables.contains(pojo))
                    buffer.append(NLINDENT).append("#Serializable(1)");
                Map<String, String> toInit = new LinkedHashMap<String, String>();
                toInits(pojo, toInit);
                for (Entry<String, String> entry : toInit.entrySet()) {
                    buffer.append(NLINDENT).append("#Discriminator(").append(entry.getKey());
                    // pojoExtends {BANK_ACCOUNT=BILLING_DETAILS, MOVIE=MEDIA, CREDIT_CARD=BILLING_DETAILS,
                    // BOOK=MEDIA}
                    // pojoInheritanceDiscriminator {BILLING_DETAILS=[BANK_ACCOUNT, CREDIT_CARD]}
                    // pojoInheritanceSimple {MEDIA=[MOVIE, BOOK]}
                    // pojoDiscriminators {BANK_ACCOUNT=BA, CREDIT_CARD=CC}
                    if (pojoInheritanceSimple.containsKey(entry.getValue())) {
                        for (String pojo2 : pojoInheritanceSimple.get(entry.getValue())) {
                            buffer.append(",\"").append(columnToCamelCase(pojo2)).append("\"");
                            String pojoName2 = tableNames.get(pojo2);
                            if (pojoName2 == null)
                                pojoName2 = pojo2;
                            buffer.append("=").append("::").append(tableToCamelCase(pojoName2));
                        }
                    } else {
                        for (String pojo2 : pojoInheritanceDiscriminator.get(entry.getValue())) {
                            buffer.append(",\"").append(pojoDiscriminators.get(pojo2)).append("\"");
                            String pojoName2 = tableNames.get(pojo2);
                            if (pojoName2 == null)
                                pojoName2 = pojo2;
                            buffer.append("=").append("::").append(tableToCamelCase(pojoName2));
                        }
                    }
                    buffer.append(")");
                }
                buffer.append(NLINDENT);
                if (daoMakeItFinal)
                    buffer.append("final ");
                buffer.append("dao ");
                buffer.append(daoName);
                if (generics == null && notGenerics == null) {
                    buffer.append(" :: ");
                } else if (generics != null && !generics.isEmpty() && generics.contains(daoName)) {
                    buffer.append(" ::: ");
                } else if (notGenerics != null && !notGenerics.isEmpty() && notGenerics.contains(daoName)) {
                    buffer.append(" :: ");
                } else {
                    buffer.append(" ::: ");
                }
                buffer.append(tableToCamelCase(pojoName));
                if (isSerializable || serializables.contains(pojo))
                    buffer.append(" serializable 1 ");
                buffer.append(" {");
                buffer.append("\n    scaffold");
                buffer.append("\n  }\n");
            }
            boolean hasProcedures = false;
            for (String pojo : procedures.keySet()) {
                // System.out.println("QQQQQ " + pojo);
                if (!daoOnlyTables.isEmpty() && !daoOnlyTables.contains(pojo))
                    continue;
                if (daoIgnoreTables.contains(pojo))
                    continue;
                if (!Filter.isTable(daoActiveFilter, pojo))
                    continue;
                boolean isFunction = functions.containsKey(pojo);
                if (!isFunction) {
                    hasProcedures = true;
                    break;
                }
            }
            if (hasProcedures && !finalDaos.containsKey("ProceduresDao")) {
                buffer.append(NLINDENT);
                if (daoMakeItFinal)
                    buffer.append("final ");
                buffer.append("dao ProceduresDao");
                if (isSerializable || serializables.contains("Procedures"))
                    buffer.append(" serializable 1 ");
                buffer.append(" {");
                for (String procedure : procedures.keySet()) {
                    // System.out.println("QQQQQ " + pojo);
                    if (!daoOnlyTables.isEmpty() && !daoOnlyTables.contains(procedure))
                        continue;
                    if (daoIgnoreTables.contains(procedure))
                        continue;
                    boolean isFunction = functions.containsKey(procedure);
                    if (isFunction)
                        continue;
                    buffer.append(NLINDENT).append(INDENT);
                    String pojoName = tableNames.get(procedure);
                    if (pojoName == null)
                        pojoName = procedure;
                    pojoName = tableToCamelCase(pojoName);
                    String procedureName = lowerFirstChar(pojoName);
                    Map<String, PojoAttribute> attributes = procedures.get(procedure);
                    if (metaProceduresResultSet.containsKey(procedure)) {
                        String name = metaProceduresResultSet.get(procedure);
                        if (tableNames.containsKey(name))
                            name = tableNames.get(name);
                        buffer.append("callQuery ").append(procedureName).append(" :java.util.List<:")
                                .append(tableToCamelCase(name)).append(">");
                    } else {
                        PojoAttribute returnAttribute = (attributes.containsKey(FAKE_FUN_PROC_COLUMN_NAME)) ? attributes
                                .get(FAKE_FUN_PROC_COLUMN_NAME) : null;
                        if (returnAttribute != null && dbType != DbType.POSTGRESQL && dbType != DbType.MS_SQL) {
                            buffer.append("callQuery ").append(procedureName).append(" :")
                                    .append(returnAttribute.getClassName());
                        } else {
                            buffer.append("callUpdate ").append(procedureName).append(" _void");
                        }
                    }
                    String dispName = null;
                    PojoType ptype = pojosForProcedures.get(procedure);
                    if (ptype != null)
                        dispName = (ptype.getRef() != null) ? ptype.getRef().getName() : ptype.getType()
                                .getSimpleName();
                    buffer.append(" ::: ").append(lowerFirstChar(pojoName)).append(" ::")
                            .append((dispName != null) ? dispName : pojoName);
                }
                buffer.append("\n  }\n");
            } else if (hasProcedures) {
                buffer.append(getFinalContent(finalDaos.get("ProceduresDao")));
            }
            boolean hasFunctions = false;
            for (String pojo : procedures.keySet()) {
                // System.out.println("QQQQQ " + pojo);
                if (!daoOnlyTables.isEmpty() && !daoOnlyTables.contains(pojo))
                    continue;
                if (daoIgnoreTables.contains(pojo))
                    continue;
                if (!Filter.isTable(daoActiveFilter, pojo))
                    continue;
                boolean isFunction = functions.containsKey(pojo);
                if (isFunction) {
                    hasFunctions = true;
                    break;
                }
            }
            if (hasFunctions && !finalDaos.containsKey("FunctionsDao")) {
                buffer.append(NLINDENT);
                if (daoMakeItFinal)
                    buffer.append("final ");
                buffer.append("dao FunctionsDao");
                if (isSerializable || serializables.contains("Functions"))
                    buffer.append(" serializable 1 ");
                buffer.append(" {");
                for (String procedure : procedures.keySet()) {
                    // System.out.println("QQQQQ " + pojo);
                    if (!daoOnlyTables.isEmpty() && !daoOnlyTables.contains(procedure))
                        continue;
                    if (daoIgnoreTables.contains(procedure))
                        continue;
                    boolean isFunction = functions.containsKey(procedure);
                    if (!isFunction)
                        continue;
                    buffer.append(NLINDENT).append(INDENT);
                    String pojoName = tableNames.get(procedure);
                    if (pojoName == null)
                        pojoName = procedure;
                    pojoName = tableToCamelCase(pojoName);
                    String procedureName = lowerFirstChar(pojoName);
                    Map<String, PojoAttribute> attributes = procedures.get(procedure);
                    if (metaFunctionsResultSet.containsKey(procedure)) {
                        String name = metaFunctionsResultSet.get(procedure);
                        if (tableNames.containsKey(name))
                            name = tableNames.get(name);
                        buffer.append("callQueryFunction ").append(procedureName).append(" :java.util.List<:")
                                .append(tableToCamelCase(name)).append(">");
                    } else if (metaFunctionsResult.containsKey(procedure)) {
                        buffer.append("callFunction ").append(procedureName).append(" :")
                                .append(metaType2className(metaFunctionsResult.get(procedure)));
                    } else {
                        PojoAttribute returnAttribute = (attributes.containsKey(FAKE_FUN_PROC_COLUMN_NAME)) ? attributes
                                .get(FAKE_FUN_PROC_COLUMN_NAME) : null;
                        if (returnAttribute != null) {
                            buffer.append("callQueryFunction ").append(procedureName).append(" :")
                                    .append(returnAttribute.getClassName());
                        } else {
                            buffer.append("callUpdateFunction ").append(procedureName).append(" _void");
                        }
                    }
                    String dispName = null;
                    PojoType ptype = pojosForProcedures.get(procedure);
                    if (ptype != null)
                        dispName = (ptype.getRef() != null) ? ptype.getRef().getName() : ptype.getType()
                                .getSimpleName();
                    buffer.append(" ::: ").append(lowerFirstChar(pojoName)).append(" ::")
                            .append((dispName != null) ? dispName : pojoName);
                }
                buffer.append("\n  }\n");
            } else if (hasFunctions) {
                buffer.append(getFinalContent(finalDaos.get("FunctionsDao")));
            }
            hasFunctions = false;
            for (String pojo : functions.keySet()) {
                // System.out.println("QQQQQ " + pojo);
                if (!daoOnlyTables.isEmpty() && !daoOnlyTables.contains(pojo))
                    continue;
                if (daoIgnoreTables.contains(pojo))
                    continue;
                boolean isProcedure = procedures.containsKey(pojo);
                if (!isProcedure) {
                    hasFunctions = true;
                    break;
                }
            }
            if (hasFunctions && !finalDaos.containsKey("FunctionsDao")) {
                buffer.append(NLINDENT);
                if (daoMakeItFinal)
                    buffer.append("final ");
                buffer.append("dao FunctionsDao");
                if (isSerializable || serializables.contains("Functions"))
                    buffer.append(" serializable 1 ");
                buffer.append(" {");
                for (String function : functions.keySet()) {
                    // System.out.println("QQQQQ " + pojo);
                    if (!daoOnlyTables.isEmpty() && !daoOnlyTables.contains(function))
                        continue;
                    if (daoIgnoreTables.contains(function))
                        continue;
                    boolean isProcedure = procedures.containsKey(function);
                    if (isProcedure)
                        continue;
                    buffer.append(NLINDENT).append(INDENT);
                    String pojoName = tableNames.get(function);
                    if (pojoName == null)
                        pojoName = function;
                    pojoName = tableToCamelCase(pojoName);
                    String functionName = lowerFirstChar(pojoName);
                    Map<String, PojoAttribute> attributes = functions.get(function);
                    if (metaFunctionsResultSet.containsKey(function)) {
                        String name = metaFunctionsResultSet.get(function);
                        if (tableNames.containsKey(name))
                            name = tableNames.get(name);
                        buffer.append("callQueryFunction ").append(functionName).append(" :java.util.List<:")
                                .append(tableToCamelCase(name)).append(">");
                    } else if (metaFunctionsResult.containsKey(function) && dbType == DbType.DB2) {
                        buffer.append("callSelectFunction ").append(functionName).append(" :")
                                .append(metaType2className(metaFunctionsResult.get(function)));
                    } else if (metaFunctionsResult.containsKey(function)) {
                        buffer.append("callFunction ").append(functionName).append(" :")
                                .append(metaType2className(metaFunctionsResult.get(function)));
                    } else {
                        PojoAttribute returnAttribute = (attributes.containsKey(FAKE_FUN_PROC_COLUMN_NAME)) ? attributes
                                .get(FAKE_FUN_PROC_COLUMN_NAME) : null;
                        if (returnAttribute != null) {
                            buffer.append("callQueryFunction ").append(functionName).append(" :")
                                    .append(returnAttribute.getClassName());
                        } else {
                            buffer.append("callUpdateFunction ").append(functionName).append(" _void");
                        }
                    }
                    String dispName = null;
                    PojoType ptype = pojosForFunctions.get(function);
                    if (ptype != null)
                        dispName = (ptype.getRef() != null) ? ptype.getRef().getName() : ptype.getType()
                                .getSimpleName();
                    buffer.append(" ::: ").append(lowerFirstChar(pojoName)).append(" ::")
                            .append((dispName != null) ? dispName : pojoName);
                }
                buffer.append("\n  }\n");
            } else if (hasFunctions) {
                buffer.append(getFinalContent(finalDaos.get("FunctionsDao")));
            }
            return buffer.toString();
        } catch (RuntimeException ex) {
            Writer writer = new StringWriter();
            PrintWriter printWriter = new PrintWriter(writer);
            ex.printStackTrace(printWriter);
            String s = writer.toString();
            return s;
        }
    }

    protected void toInits(String pojo, Map<String, String> toInit) {
        for (Map.Entry<String, PojoAttribute> pentry : pojos.get(pojo).entrySet()) {
            if (ignoreColumns.containsKey(pojo) && ignoreColumns.get(pojo).contains(pentry.getKey()))
                continue;
            PojoAttribute attribute = pentry.getValue();
            String name = (columnNames.containsKey(pojo)) ? columnNames.get(pojo).get(pentry.getKey()) : null;
            if (name == null)
                name = attribute.getName();
            else
                name = columnToCamelCase(name);
            if (attribute.toInit()) {
                if (attribute.getRef() != null) {
                    if (pojoInheritanceDiscriminator.containsKey(attribute.getRef())
                            || pojoInheritanceSimple.containsKey(attribute.getRef())) {
                        toInit.put(name, attribute.getRef());
                        // System.out.println("AAAAAAAAA " + " " + pojo + " " + attribute.getRef() + " " + name);
                    }
                }
            }
        }
        if (pojoExtends.containsKey(pojo)) {
            toInits(pojoExtends.get(pojo), toInit);
        }
    }
}
