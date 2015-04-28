package org.sqlproc.plugin.lib.property;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.ecore.EObject;

public interface ModelProperty extends Adapter {

    public static final String RESOLVE_POJO_ON = "resolve-pojo-on";
    public static final String RESOLVE_POJO_OFF = "resolve-pojo-off";
    public static final String REPLACE_ALL_REGEX = "replace-all-regex";
    public static final String REPLACE_ALL_REPLACEMENT = "replace-all-replacement";
    public static final String COMPRESS_META_DIRECTIVES = "compress-meta-directives";

    public static final String DATABASE = "database";
    public static final String DATABASE_IS_ONLINE = "is-online";
    public static final String DATABASE_IS_OFFLINE = "is-offline";
    public static final String DATABASE_HAS_URL = "has-url";
    public static final String DATABASE_EXECUTE_BEFORE = "ddl-create";
    public static final String DATABASE_EXECUTE_AFTER = "ddl-drop";
    public static final String DATABASE_LOGIN_USERNAME = "login-username";
    public static final String DATABASE_LOGIN_PASSWORD = "login-password";
    public static final String DATABASE_IN_CATALOG = "in-catalog";
    public static final String DATABASE_ACTIVE_SCHEMA = "active-schema";
    public static final String DATABASE_JDBC_DRIVER = "jdbc-driver";
    public static final String DATABASE_INDEX_TYPES = "index-types";
    public static final String DATABASE_SKIP_INDEXES = "skip-indexes";
    public static final String DATABASE_SKIP_CHECK_CONSTRAINTS = "skip-check-constraints";
    public static final String DATABASE_SKIP_PROCEDURES = "skip-functions-procedures";
    public static final String DATABASE_OF_TYPE = "is-of-type";
    public static final String DATABASE_DEBUG_LEVEL = "debug-level";
    public static final String DATABASE_TAKE_COMMENTS = "take-comments";
    public static final String DATABASE_LOWERCASE_NAMES = "lowercase-names";
    public static final String DATABASE_UPPERCASE_NAMES = "uppercase-names";

    public static final String POJOGEN = "pojogen";
    public static final String POJOGEN_TYPE_SQLTYPES = "types-sqltypes";
    public static final String POJOGEN_TYPE_IN_TABLE = "types-in-table";
    public static final String POJOGEN_TYPE_FOR_COLUMNS = "types-for-columns";
    public static final String POJOGEN_TYPE_FOR_PROCEDURE = "types-for-procedure";
    public static final String POJOGEN_TYPE_FOR_FUNCTION = "types-for-function";
    public static final String POJOGEN_IGNORE_TABLES = "ignore-tables";
    public static final String POJOGEN_ONLY_TABLES = "only-tables";
    public static final String POJOGEN_IGNORE_COLUMNS = "ignore-columns";
    public static final String POJOGEN_REQUIRED_COLUMNS = "required-columns";
    public static final String POJOGEN_NOT_REQUIRED_COLUMNS = "not-required-columns";
    public static final String POJOGEN_CREATE_COLUMNS = "create-columns";
    public static final String POJOGEN_RENAME_TABLES = "rename-tables";
    public static final String POJOGEN_RENAME_COLUMNS = "rename-columns";
    public static final String POJOGEN_IGNORE_EXPORTS = "ignore-one-to-many";
    public static final String POJOGEN_IGNORE_IMPORTS = "ignore-many-to-one";
    public static final String POJOGEN_CREATE_EXPORTS = "create-one-to-many";
    public static final String POJOGEN_CREATE_IMPORTS = "create-many-to-one";
    public static final String POJOGEN_INHERIT_IMPORTS = "inherit-many-to-one";
    public static final String POJOGEN_MANY_TO_MANY_IMPORTS = "table-many-to-many";
    public static final String POJOGEN_INHERITANCE = "inherit-discriminator";
    public static final String POJOGEN_GENERATE_METHODS = "generate-methods";
    public static final String POJOGEN_GENERATE_OPERATORS = "generate-operators";
    public static final String POJOGEN_IMPLEMENTS_INTERFACES = "implements-interfaces";
    public static final String POJOGEN_EXTENDS_CLASS = "extends-class";
    public static final String POJOGEN_IMPLEMENTS_INTERFACES_GENERICS = "implements-interfaces-generics";
    public static final String POJOGEN_EXTENDS_CLASS_GENERICS = "extends-class-generics";
    public static final String POJOGEN_JOIN_TABLES = "join-tables";
    public static final String POJOGEN_GENERATE_WRAPPERS = "generate-wrappers";
    public static final String POJOGEN_GENERATE_VALIDATION_ANNOTATIONS = "generate-validation-annotations";
    public static final String POJOGEN_NOT_ABSTRACT_TABLES_TABLES = "not-abstract-tables";
    public static final String POJOGEN_MAKE_IT_FINAL = "make-it-final";
    public static final String POJOGEN_VERSION_COLUMN = "version-column";
    public static final String POJOGEN_DEBUG_LEVEL = "debug-level";
    public static final String POJOGEN_PRESERVE_FOREIGN_KEYS = "preserve-foreign-keys";
    public static final String POJOGEN_POJOS_FOR_PROCEDURES = "pojos-for-procedures";
    public static final String POJOGEN_POJOS_FOR_FUNCTIONS = "pojos-for-functions";
    public static final String POJOGEN_ACTIVE_FILTER = "active-filter";
    public static final String POJOGEN_PACKAGE = "package";
    public static final String POJOGEN_ENUM_FOR_CHECK_CONSTRAINTS = "enum-for-check-constraints";

    public static final String METAGEN = "metagen";
    public static final String METAGEN_GLOBAL_SEQUENCE = "global-sequence";
    public static final String METAGEN_TABLE_SEQUENCE = "table-sequence";
    public static final String METAGEN_GLOBAL_IDENTITY = "global-identity";
    public static final String METAGEN_TABLE_IDENTITY = "table-identity";
    public static final String METAGEN_SQLTYPE_META_TYPE = "sqltype-meta-type";
    public static final String METAGEN_COLUMN_META_TYPE = "column-meta-type";
    public static final String METAGEN_STATEMENT_META_TYPE = "statement-meta-type";
    public static final String METAGEN_MAKE_IT_FINAL = "make-it-final";
    public static final String METAGEN_LIKE_COLUMNS = "like-columns";
    public static final String METAGEN_NOT_LIKE_COLUMNS = "not-like-columns";
    public static final String METAGEN_GENERATE_SEQUENCES = "generate-sequences";
    public static final String METAGEN_GENERATE_IDENTITIES = "generate-identities";
    public static final String METAGEN_GENERATE_IDGENERATORS = "generate-idgenerators";
    public static final String METAGEN_GENERATE_INDIRECT_IDGENERATORS = "generate-default-idgenerators";
    public static final String METAGEN_FUNCTION_RESULT = "function-result";
    public static final String METAGEN_FUNCTION_RESULT_SET = "function-result-set";
    public static final String METAGEN_PROCEDURE_RESULT_SET = "procedure-result-set";
    public static final String METAGEN_DEBUG_LEVEL = "debug-level";
    public static final String METAGEN_GENERATE_OPERATORS = "generate-operators";
    public static final String METAGEN_OPTIMIZE_INSERT = "optimize-insert";
    public static final String METAGEN_OPTIONAL_FEATURES = "optional-features";
    public static final String METAGEN_ACTIVE_FILTER = "active-filter";

    public static final String DAOGEN = "daogen";
    public static final String DAOGEN_IGNORE_TABLES = "ignore-tables";
    public static final String DAOGEN_ONLY_TABLES = "only-tables";
    public static final String DAOGEN_IMPLEMENTS_INTERFACES = "implements-interfaces";
    public static final String DAOGEN_EXTENDS_CLASS = "extends-class";
    public static final String DAOGEN_IMPLEMENTS_INTERFACES_GENERICS = "implements-interfaces-generics";
    public static final String DAOGEN_EXTENDS_CLASS_GENERICS = "extends-class-generics";
    public static final String DAOGEN_MAKE_IT_FINAL = "make-it-final";
    public static final String DAOGEN_FUNCTION_RESULT = "function-result";
    public static final String DAOGEN_DEBUG_LEVEL = "debug-level";
    public static final String DAOGEN_ACTIVE_FILTER = "active-filter";
    public static final String DAOGEN_PACKAGE = "package";
    public static final String DAOGEN_IMPLEMENTATION_PACKAGE = "implementation-package";

    public static final String STANDARD = "___GLOBAL";

    boolean isDoResolvePojo(EObject model);

    boolean isDoResolveDb(EObject model);

    Map<String, PojoAttrType> getSqlTypes(EObject model);

    Map<String, Map<String, PojoAttrType>> getTableTypes(EObject model);

    Map<String, Map<String, PojoAttrType>> getColumnTypes(EObject model);

    Map<String, Map<String, String>> getColumnNames(EObject model);

    Map<String, String> getTableNames(EObject model);

    Set<String> getIgnoreTables(EObject model);

    Map<String, Set<String>> getIgnoreColumns(EObject model);

    Map<String, Map<String, Map<String, String>>> getIgnoreExports(EObject model);

    Map<String, Map<String, Map<String, String>>> getIgnoreImports(EObject model);

    Map<String, Map<String, Map<String, String>>> getCreateExports(EObject model);

    Map<String, Map<String, Map<String, String>>> getCreateImports(EObject model);

    Map<String, Map<String, PojoAttrType>> getCreateColumns(EObject model);

    Map<String, Map<String, Map<String, String>>> getInheritImports(EObject model);

    Map<String, Map<String, Map<String, String>>> getManyToManyImports(EObject model);

    Map<String, Map<String, Map<String, List<String>>>> getInheritance(EObject model);

    Map<String, Set<String>> getRequiredColumns(EObject model);

    Map<String, Set<String>> getNotRequiredColumns(EObject model);

    Map<String, String> getInheritanceColumns(EObject model);

    Set<String> getGenerateMethods(EObject model);

    Map<String, ImplementsExtends> getToImplements(EObject model);

    ImplementsExtends getToExtends(EObject model);

    Set<String> getOnlyTables(EObject model);

    Map<String, List<String>> getJoinTables(EObject model);

    boolean isDoGenerateWrappers(EObject model);

    PairValues getMetaGlobalIdentity(EObject model);

    PairValues getMetaGlobalSequence(EObject model);

    Map<String, PairValues> getMetaTablesIdentity(EObject model);

    Map<String, PairValues> getMetaTablesSequence(EObject model);

    Map<String, Map<String, PairValues>> getMetaColumnsMetaTypes(EObject model);

    Map<String, Map<String, PairValues>> getMetaStatementsMetaTypes(EObject model);

    Set<String> getNotAbstractTables(EObject model);

    Set<String> getDaoIgnoreTables(EObject model);

    Set<String> getDaoOnlyTables(EObject model);

    ImplementsExtends getDaoToExtends(EObject model);

    Map<String, ImplementsExtends> getDaoToImplements(EObject model);

    boolean isMakeItFinal(EObject model);

    boolean isDaoMakeItFinal(EObject model);

    boolean isMetaMakeItFinal(EObject model);

    Map<String, Set<String>> getVersionColumns(EObject model);

    String getVersionColumn(EObject model);

    Map<String, Set<String>> getMetaLikeColumns(EObject model);

    Map<String, Set<String>> getMetaNotLikeColumns(EObject model);

    boolean isMetaGenerateIdentities(EObject model);

    boolean isMetaGenerateSequences(EObject model);

    Map<String, String> getMetaFunctionsResult(EObject model);

    Map<String, String> getMetaFunctionsResultSet(EObject model);

    Map<String, String> getMetaProceduresResultSet(EObject model);

    Map<String, PojoEntityType> getDaoFunctionsResult(EObject model);

    String getDebugLevel(EObject model);

    String getMetaDebugLevel(EObject model);

    String getDaoDebugLevel(EObject model);

    String getGenerateOperators(EObject model);

    boolean isMetaGenerateOperators(EObject model);

    Set<String> getPreserveForeignKeys(EObject model);

    Set<String> getMetaOptimizeInsert(EObject model);

    Map<String, Set<String>> getMetaOptionalFeatures(EObject model);

    Map<String, Map<String, PojoAttrType>> getProcedureTypes(EObject model);

    Map<String, Map<String, PojoAttrType>> getFunctionTypes(EObject model);

    Map<String, PojoEntityType> getPojosForFunctions(EObject model);

    Map<String, PojoEntityType> getPojosForProcedures(EObject model);

    Map<String, String> getReplaceAll(EObject model);

    boolean isDoGenerateValidationAnnotations(EObject model);

    Map<String, Set<String>> getNotVersionColumns(EObject model);

    Set<String> getMetaGlobalSequenceForTables(EObject model);

    Set<String> getMetaGlobalSequenceNotForTables(EObject model);

    Set<String> getMetaGlobalIdentityForTables(EObject model);

    Set<String> getMetaGlobalIdentityNotForTables(EObject model);

    String getActiveFilter(EObject model);

    String getMetaActiveFilter(EObject model);

    String getDaoActiveFilter(EObject model);

    boolean isMetaGenerateIdGenerators(EObject model);

    boolean isMetaGenerateIndirectIdGenerators(EObject model);

    String getMetaDebugScope(EObject model);

    String getDaoDebugScope(EObject model);

    String getDebugScope(EObject model);

    String getPackage(EObject model);

    String getDaoPackage(EObject model);

    Map<String, String> getEnumForCheckConstraints(EObject model);

    boolean isCompressMetaDirectives(EObject model);

    String getDbPassword(EObject model);

    String getDbCatalog(EObject model);

    String getDbSchema(EObject model);

    String getDbSqlsBefore(EObject model);

    String getDbSqlsAfter(EObject model);

    String getDbIndexTypes(EObject model);

    boolean getDbSkipIndexes(EObject model);

    boolean getDbSkipProcedures(EObject model);

    boolean getDbSkipCheckConstraints(EObject model);

    String getDbType(EObject model);

    String getDbDebugLevel(EObject model);

    String getDbDebugScope(EObject model);

    boolean getDbTakeComments(EObject model);

    boolean getDbLowercaseNames(EObject model);

    boolean getDbUppercaseNames(EObject model);

    String getDbDriver(EObject model);

    String getDbUrl(EObject model);

    String getDbUsername(EObject model);

    String getModelDir(EObject model);

    String getDaoImplPackage(EObject model);

    void init(Object modelValues);

    Map<String, PojoAttrType> getMetaSqlTypes(EObject model);
}
