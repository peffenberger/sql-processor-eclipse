package org.sqlproc.model.property;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.sqlproc.model.property.ModelPropertyBean.ModelValues;
import org.sqlproc.model.property.ModelPropertyBean.PairValues;

public interface ModelProperty extends Adapter {

    boolean isDoResolvePojo(EObject model);

    boolean isDoResolveDb(EObject model);

    Map<String, PojoAttrType> getSqlTypes(EObject model);

    Map<String, Map<String, PojoAttrType>> getTableTypes(EObject model);

    Map<String, Map<String, PojoAttrType>> getColumnTypes(EObject model);

    Map<String, Map<String, String>> getColumnNames(EObject model);

    ModelValues getModelValues(EObject model);

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

    Map<String, JvmParameterizedTypeReference> getDaoFunctionsResult(EObject model);

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

    Map<String, JvmParameterizedTypeReference> getPojosForFunctions(EObject model);

    Map<String, JvmParameterizedTypeReference> getPojosForProcedures(EObject model);

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
}
