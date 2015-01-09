/**
 */
package org.sqlproc.dsl.processorDsl.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.sqlproc.dsl.processorDsl.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.sqlproc.dsl.processorDsl.ProcessorDslPackage
 * @generated
 */
public class ProcessorDslSwitch<T> extends Switch<T>
{
  /**
   * The cached model package
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static ProcessorDslPackage modelPackage;

  /**
   * Creates an instance of the switch.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ProcessorDslSwitch()
  {
    if (modelPackage == null)
    {
      modelPackage = ProcessorDslPackage.eINSTANCE;
    }
  }

  /**
   * Checks whether this is a switch for the given package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @parameter ePackage the package in question.
   * @return whether this is a switch for the given package.
   * @generated
   */
  @Override
  protected boolean isSwitchFor(EPackage ePackage)
  {
    return ePackage == modelPackage;
  }

  /**
   * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the first non-null result returned by a <code>caseXXX</code> call.
   * @generated
   */
  @Override
  protected T doSwitch(int classifierID, EObject theEObject)
  {
    switch (classifierID)
    {
      case ProcessorDslPackage.ARTIFACTS:
      {
        Artifacts artifacts = (Artifacts)theEObject;
        T result = caseArtifacts(artifacts);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ProcessorDslPackage.DATABASE_CATALOG_ASSIGNEMENT:
      {
        DatabaseCatalogAssignement databaseCatalogAssignement = (DatabaseCatalogAssignement)theEObject;
        T result = caseDatabaseCatalogAssignement(databaseCatalogAssignement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ProcessorDslPackage.DATABASE_SCHEMA_ASSIGNEMENT:
      {
        DatabaseSchemaAssignement databaseSchemaAssignement = (DatabaseSchemaAssignement)theEObject;
        T result = caseDatabaseSchemaAssignement(databaseSchemaAssignement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ProcessorDslPackage.DATABASE_TYPE_ASSIGNEMENT:
      {
        DatabaseTypeAssignement databaseTypeAssignement = (DatabaseTypeAssignement)theEObject;
        T result = caseDatabaseTypeAssignement(databaseTypeAssignement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ProcessorDslPackage.DATABASE_META_INFO_ASSIGNEMENT:
      {
        DatabaseMetaInfoAssignement databaseMetaInfoAssignement = (DatabaseMetaInfoAssignement)theEObject;
        T result = caseDatabaseMetaInfoAssignement(databaseMetaInfoAssignement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ProcessorDslPackage.DRIVER_META_INFO_ASSIGNEMENT:
      {
        DriverMetaInfoAssignement driverMetaInfoAssignement = (DriverMetaInfoAssignement)theEObject;
        T result = caseDriverMetaInfoAssignement(driverMetaInfoAssignement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ProcessorDslPackage.DRIVER_METHOD_OUTPUT_ASSIGNEMENT:
      {
        DriverMethodOutputAssignement driverMethodOutputAssignement = (DriverMethodOutputAssignement)theEObject;
        T result = caseDriverMethodOutputAssignement(driverMethodOutputAssignement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ProcessorDslPackage.SQL_TYPE_ASSIGNEMENT:
      {
        SqlTypeAssignement sqlTypeAssignement = (SqlTypeAssignement)theEObject;
        T result = caseSqlTypeAssignement(sqlTypeAssignement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ProcessorDslPackage.COLUMN_TYPE_ASSIGNEMENT:
      {
        ColumnTypeAssignement columnTypeAssignement = (ColumnTypeAssignement)theEObject;
        T result = caseColumnTypeAssignement(columnTypeAssignement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ProcessorDslPackage.SHOW_COLUMN_TYPE_ASSIGNEMENT:
      {
        ShowColumnTypeAssignement showColumnTypeAssignement = (ShowColumnTypeAssignement)theEObject;
        T result = caseShowColumnTypeAssignement(showColumnTypeAssignement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ProcessorDslPackage.TABLE_ASSIGNEMENT:
      {
        TableAssignement tableAssignement = (TableAssignement)theEObject;
        T result = caseTableAssignement(tableAssignement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ProcessorDslPackage.JOIN_TABLE_ASSIGNEMENT:
      {
        JoinTableAssignement joinTableAssignement = (JoinTableAssignement)theEObject;
        T result = caseJoinTableAssignement(joinTableAssignement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ProcessorDslPackage.COLUMN_ASSIGNEMENT:
      {
        ColumnAssignement columnAssignement = (ColumnAssignement)theEObject;
        T result = caseColumnAssignement(columnAssignement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ProcessorDslPackage.IMPORT_ASSIGNEMENT:
      {
        ImportAssignement importAssignement = (ImportAssignement)theEObject;
        T result = caseImportAssignement(importAssignement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ProcessorDslPackage.EXPORT_ASSIGNEMENT:
      {
        ExportAssignement exportAssignement = (ExportAssignement)theEObject;
        T result = caseExportAssignement(exportAssignement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ProcessorDslPackage.INHERITANCE_ASSIGNEMENT:
      {
        InheritanceAssignement inheritanceAssignement = (InheritanceAssignement)theEObject;
        T result = caseInheritanceAssignement(inheritanceAssignement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ProcessorDslPackage.MANY_TO_MANY_ASSIGNEMENT:
      {
        ManyToManyAssignement manyToManyAssignement = (ManyToManyAssignement)theEObject;
        T result = caseManyToManyAssignement(manyToManyAssignement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ProcessorDslPackage.DEBUG_LEVEL_ASSIGNEMENT:
      {
        DebugLevelAssignement debugLevelAssignement = (DebugLevelAssignement)theEObject;
        T result = caseDebugLevelAssignement(debugLevelAssignement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ProcessorDslPackage.PROCEDURE_POJO_ASSIGNEMENT:
      {
        ProcedurePojoAssignement procedurePojoAssignement = (ProcedurePojoAssignement)theEObject;
        T result = caseProcedurePojoAssignement(procedurePojoAssignement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ProcessorDslPackage.FUNCTION_POJO_ASSIGNEMENT:
      {
        FunctionPojoAssignement functionPojoAssignement = (FunctionPojoAssignement)theEObject;
        T result = caseFunctionPojoAssignement(functionPojoAssignement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ProcessorDslPackage.IMPLEMENTS_ASSIGNEMENT:
      {
        ImplementsAssignement implementsAssignement = (ImplementsAssignement)theEObject;
        T result = caseImplementsAssignement(implementsAssignement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ProcessorDslPackage.EXTENDS_ASSIGNEMENT:
      {
        ExtendsAssignement extendsAssignement = (ExtendsAssignement)theEObject;
        T result = caseExtendsAssignement(extendsAssignement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ProcessorDslPackage.IMPLEMENTS_ASSIGNEMENT_GENERICS:
      {
        ImplementsAssignementGenerics implementsAssignementGenerics = (ImplementsAssignementGenerics)theEObject;
        T result = caseImplementsAssignementGenerics(implementsAssignementGenerics);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ProcessorDslPackage.EXTENDS_ASSIGNEMENT_GENERICS:
      {
        ExtendsAssignementGenerics extendsAssignementGenerics = (ExtendsAssignementGenerics)theEObject;
        T result = caseExtendsAssignementGenerics(extendsAssignementGenerics);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ProcessorDslPackage.PROPERTY:
      {
        Property property = (Property)theEObject;
        T result = caseProperty(property);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ProcessorDslPackage.DATABASE_PROPERTY:
      {
        DatabaseProperty databaseProperty = (DatabaseProperty)theEObject;
        T result = caseDatabaseProperty(databaseProperty);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ProcessorDslPackage.POJOGEN_PROPERTY:
      {
        PojogenProperty pojogenProperty = (PojogenProperty)theEObject;
        T result = casePojogenProperty(pojogenProperty);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ProcessorDslPackage.META_TYPE_ASSIGNEMENT:
      {
        MetaTypeAssignement metaTypeAssignement = (MetaTypeAssignement)theEObject;
        T result = caseMetaTypeAssignement(metaTypeAssignement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ProcessorDslPackage.METAGEN_PROPERTY:
      {
        MetagenProperty metagenProperty = (MetagenProperty)theEObject;
        T result = caseMetagenProperty(metagenProperty);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ProcessorDslPackage.DAOGEN_PROPERTY:
      {
        DaogenProperty daogenProperty = (DaogenProperty)theEObject;
        T result = caseDaogenProperty(daogenProperty);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ProcessorDslPackage.POJO_DEFINITION:
      {
        PojoDefinition pojoDefinition = (PojoDefinition)theEObject;
        T result = casePojoDefinition(pojoDefinition);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ProcessorDslPackage.TABLE_DEFINITION:
      {
        TableDefinition tableDefinition = (TableDefinition)theEObject;
        T result = caseTableDefinition(tableDefinition);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ProcessorDslPackage.PROCEDURE_DEFINITION:
      {
        ProcedureDefinition procedureDefinition = (ProcedureDefinition)theEObject;
        T result = caseProcedureDefinition(procedureDefinition);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ProcessorDslPackage.FUNCTION_DEFINITION:
      {
        FunctionDefinition functionDefinition = (FunctionDefinition)theEObject;
        T result = caseFunctionDefinition(functionDefinition);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ProcessorDslPackage.META_STATEMENT:
      {
        MetaStatement metaStatement = (MetaStatement)theEObject;
        T result = caseMetaStatement(metaStatement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ProcessorDslPackage.SQL:
      {
        Sql sql = (Sql)theEObject;
        T result = caseSql(sql);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ProcessorDslPackage.SQL_FRAGMENT:
      {
        SqlFragment sqlFragment = (SqlFragment)theEObject;
        T result = caseSqlFragment(sqlFragment);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ProcessorDslPackage.META_SQL:
      {
        MetaSql metaSql = (MetaSql)theEObject;
        T result = caseMetaSql(metaSql);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ProcessorDslPackage.IF_SQL:
      {
        IfSql ifSql = (IfSql)theEObject;
        T result = caseIfSql(ifSql);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ProcessorDslPackage.IF_SQL_FRAGMENT:
      {
        IfSqlFragment ifSqlFragment = (IfSqlFragment)theEObject;
        T result = caseIfSqlFragment(ifSqlFragment);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ProcessorDslPackage.IF_META_SQL:
      {
        IfMetaSql ifMetaSql = (IfMetaSql)theEObject;
        T result = caseIfMetaSql(ifMetaSql);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ProcessorDslPackage.IF_SQL_COND:
      {
        IfSqlCond ifSqlCond = (IfSqlCond)theEObject;
        T result = caseIfSqlCond(ifSqlCond);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ProcessorDslPackage.IF_SQL_BOOL:
      {
        IfSqlBool ifSqlBool = (IfSqlBool)theEObject;
        T result = caseIfSqlBool(ifSqlBool);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ProcessorDslPackage.ORD_SQL:
      {
        OrdSql ordSql = (OrdSql)theEObject;
        T result = caseOrdSql(ordSql);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ProcessorDslPackage.ORD_SQL2:
      {
        OrdSql2 ordSql2 = (OrdSql2)theEObject;
        T result = caseOrdSql2(ordSql2);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ProcessorDslPackage.COLUMN:
      {
        Column column = (Column)theEObject;
        T result = caseColumn(column);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ProcessorDslPackage.EXTENDED_COLUMN:
      {
        ExtendedColumn extendedColumn = (ExtendedColumn)theEObject;
        T result = caseExtendedColumn(extendedColumn);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ProcessorDslPackage.EXTENDED_COLUMN_NAME:
      {
        ExtendedColumnName extendedColumnName = (ExtendedColumnName)theEObject;
        T result = caseExtendedColumnName(extendedColumnName);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ProcessorDslPackage.CONSTANT:
      {
        Constant constant = (Constant)theEObject;
        T result = caseConstant(constant);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ProcessorDslPackage.IDENTIFIER:
      {
        Identifier identifier = (Identifier)theEObject;
        T result = caseIdentifier(identifier);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ProcessorDslPackage.CONSTANT_OPERATOR:
      {
        ConstantOperator constantOperator = (ConstantOperator)theEObject;
        T result = caseConstantOperator(constantOperator);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ProcessorDslPackage.IDENTIFIER_OPERATOR:
      {
        IdentifierOperator identifierOperator = (IdentifierOperator)theEObject;
        T result = caseIdentifierOperator(identifierOperator);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ProcessorDslPackage.DATABASE_COLUMN:
      {
        DatabaseColumn databaseColumn = (DatabaseColumn)theEObject;
        T result = caseDatabaseColumn(databaseColumn);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ProcessorDslPackage.DATABASE_TABLE:
      {
        DatabaseTable databaseTable = (DatabaseTable)theEObject;
        T result = caseDatabaseTable(databaseTable);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ProcessorDslPackage.MAPPING_RULE:
      {
        MappingRule mappingRule = (MappingRule)theEObject;
        T result = caseMappingRule(mappingRule);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ProcessorDslPackage.MAPPING:
      {
        Mapping mapping = (Mapping)theEObject;
        T result = caseMapping(mapping);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ProcessorDslPackage.MAPPING_ITEM:
      {
        MappingItem mappingItem = (MappingItem)theEObject;
        T result = caseMappingItem(mappingItem);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ProcessorDslPackage.MAPPING_COLUMN:
      {
        MappingColumn mappingColumn = (MappingColumn)theEObject;
        T result = caseMappingColumn(mappingColumn);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ProcessorDslPackage.EXTENDED_MAPPING_ITEM:
      {
        ExtendedMappingItem extendedMappingItem = (ExtendedMappingItem)theEObject;
        T result = caseExtendedMappingItem(extendedMappingItem);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ProcessorDslPackage.MAPPING_COLUMN_NAME:
      {
        MappingColumnName mappingColumnName = (MappingColumnName)theEObject;
        T result = caseMappingColumnName(mappingColumnName);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ProcessorDslPackage.OPTIONAL_FEATURE:
      {
        OptionalFeature optionalFeature = (OptionalFeature)theEObject;
        T result = caseOptionalFeature(optionalFeature);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ProcessorDslPackage.POJO_TYPE:
      {
        PojoType pojoType = (PojoType)theEObject;
        T result = casePojoType(pojoType);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ProcessorDslPackage.PACKAGE_DECLARATION:
      {
        PackageDeclaration packageDeclaration = (PackageDeclaration)theEObject;
        T result = casePackageDeclaration(packageDeclaration);
        if (result == null) result = caseAbstractPojoEntity(packageDeclaration);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ProcessorDslPackage.ANNOTATION:
      {
        Annotation annotation = (Annotation)theEObject;
        T result = caseAnnotation(annotation);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ProcessorDslPackage.ANNOTATION_PROPERTY:
      {
        AnnotationProperty annotationProperty = (AnnotationProperty)theEObject;
        T result = caseAnnotationProperty(annotationProperty);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ProcessorDslPackage.ENTITY:
      {
        Entity entity = (Entity)theEObject;
        T result = caseEntity(entity);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ProcessorDslPackage.ANNOTATED_ENTITY:
      {
        AnnotatedEntity annotatedEntity = (AnnotatedEntity)theEObject;
        T result = caseAnnotatedEntity(annotatedEntity);
        if (result == null) result = caseAbstractPojoEntity(annotatedEntity);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ProcessorDslPackage.ABSTRACT_POJO_ENTITY:
      {
        AbstractPojoEntity abstractPojoEntity = (AbstractPojoEntity)theEObject;
        T result = caseAbstractPojoEntity(abstractPojoEntity);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ProcessorDslPackage.IMPORT:
      {
        Import import_ = (Import)theEObject;
        T result = caseImport(import_);
        if (result == null) result = caseAbstractPojoEntity(import_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ProcessorDslPackage.IMPLEMENTS:
      {
        Implements implements_ = (Implements)theEObject;
        T result = caseImplements(implements_);
        if (result == null) result = caseAbstractPojoEntity(implements_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ProcessorDslPackage.EXTENDS:
      {
        Extends extends_ = (Extends)theEObject;
        T result = caseExtends(extends_);
        if (result == null) result = caseAbstractPojoEntity(extends_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ProcessorDslPackage.IMPL_PACKAGE:
      {
        ImplPackage implPackage = (ImplPackage)theEObject;
        T result = caseImplPackage(implPackage);
        if (result == null) result = caseAbstractPojoEntity(implPackage);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ProcessorDslPackage.POJO_ENTITY_MODIFIER1:
      {
        PojoEntityModifier1 pojoEntityModifier1 = (PojoEntityModifier1)theEObject;
        T result = casePojoEntityModifier1(pojoEntityModifier1);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ProcessorDslPackage.DIRECTIVE_PROPERTIES:
      {
        DirectiveProperties directiveProperties = (DirectiveProperties)theEObject;
        T result = caseDirectiveProperties(directiveProperties);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ProcessorDslPackage.POJO_DIRECTIVE:
      {
        PojoDirective pojoDirective = (PojoDirective)theEObject;
        T result = casePojoDirective(pojoDirective);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ProcessorDslPackage.POJO_ENTITY_MODIFIER2:
      {
        PojoEntityModifier2 pojoEntityModifier2 = (PojoEntityModifier2)theEObject;
        T result = casePojoEntityModifier2(pojoEntityModifier2);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ProcessorDslPackage.POJO_ENTITY:
      {
        PojoEntity pojoEntity = (PojoEntity)theEObject;
        T result = casePojoEntity(pojoEntity);
        if (result == null) result = caseEntity(pojoEntity);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ProcessorDslPackage.POJO_ANNOTATED_PROPERTY:
      {
        PojoAnnotatedProperty pojoAnnotatedProperty = (PojoAnnotatedProperty)theEObject;
        T result = casePojoAnnotatedProperty(pojoAnnotatedProperty);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ProcessorDslPackage.POJO_PROPERTY_MODIFIER:
      {
        PojoPropertyModifier pojoPropertyModifier = (PojoPropertyModifier)theEObject;
        T result = casePojoPropertyModifier(pojoPropertyModifier);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ProcessorDslPackage.POJO_PROPERTY:
      {
        PojoProperty pojoProperty = (PojoProperty)theEObject;
        T result = casePojoProperty(pojoProperty);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ProcessorDslPackage.ENUM_ENTITY_MODIFIER1:
      {
        EnumEntityModifier1 enumEntityModifier1 = (EnumEntityModifier1)theEObject;
        T result = caseEnumEntityModifier1(enumEntityModifier1);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ProcessorDslPackage.ENUM_ENTITY_MODIFIER2:
      {
        EnumEntityModifier2 enumEntityModifier2 = (EnumEntityModifier2)theEObject;
        T result = caseEnumEntityModifier2(enumEntityModifier2);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ProcessorDslPackage.ENUM_ENTITY:
      {
        EnumEntity enumEntity = (EnumEntity)theEObject;
        T result = caseEnumEntity(enumEntity);
        if (result == null) result = caseEntity(enumEntity);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ProcessorDslPackage.ENUM_PROPERTY:
      {
        EnumProperty enumProperty = (EnumProperty)theEObject;
        T result = caseEnumProperty(enumProperty);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ProcessorDslPackage.POJO_DAO_MODIFIER:
      {
        PojoDaoModifier pojoDaoModifier = (PojoDaoModifier)theEObject;
        T result = casePojoDaoModifier(pojoDaoModifier);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ProcessorDslPackage.POJO_DAO:
      {
        PojoDao pojoDao = (PojoDao)theEObject;
        T result = casePojoDao(pojoDao);
        if (result == null) result = caseAbstractPojoEntity(pojoDao);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ProcessorDslPackage.POJO_METHOD_MODIFIER:
      {
        PojoMethodModifier pojoMethodModifier = (PojoMethodModifier)theEObject;
        T result = casePojoMethodModifier(pojoMethodModifier);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ProcessorDslPackage.POJO_METHOD:
      {
        PojoMethod pojoMethod = (PojoMethod)theEObject;
        T result = casePojoMethod(pojoMethod);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ProcessorDslPackage.TO_INIT_METHOD:
      {
        ToInitMethod toInitMethod = (ToInitMethod)theEObject;
        T result = caseToInitMethod(toInitMethod);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ProcessorDslPackage.POJO_METHOD_ARG:
      {
        PojoMethodArg pojoMethodArg = (PojoMethodArg)theEObject;
        T result = casePojoMethodArg(pojoMethodArg);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ProcessorDslPackage.POJO_DIRECTIVE_DISCRIMINATOR:
      {
        PojoDirectiveDiscriminator pojoDirectiveDiscriminator = (PojoDirectiveDiscriminator)theEObject;
        T result = casePojoDirectiveDiscriminator(pojoDirectiveDiscriminator);
        if (result == null) result = casePojoDirective(pojoDirectiveDiscriminator);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ProcessorDslPackage.POJO_DIRECTIVE_OPERATORS:
      {
        PojoDirectiveOperators pojoDirectiveOperators = (PojoDirectiveOperators)theEObject;
        T result = casePojoDirectiveOperators(pojoDirectiveOperators);
        if (result == null) result = casePojoDirective(pojoDirectiveOperators);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ProcessorDslPackage.POJO_DIRECTIVE_SERIALIZABLE:
      {
        PojoDirectiveSerializable pojoDirectiveSerializable = (PojoDirectiveSerializable)theEObject;
        T result = casePojoDirectiveSerializable(pojoDirectiveSerializable);
        if (result == null) result = casePojoDirective(pojoDirectiveSerializable);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ProcessorDslPackage.POJO_DIRECTIVE_INDEX:
      {
        PojoDirectiveIndex pojoDirectiveIndex = (PojoDirectiveIndex)theEObject;
        T result = casePojoDirectiveIndex(pojoDirectiveIndex);
        if (result == null) result = casePojoDirective(pojoDirectiveIndex);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      default: return defaultCase(theEObject);
    }
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Artifacts</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Artifacts</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseArtifacts(Artifacts object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Database Catalog Assignement</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Database Catalog Assignement</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseDatabaseCatalogAssignement(DatabaseCatalogAssignement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Database Schema Assignement</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Database Schema Assignement</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseDatabaseSchemaAssignement(DatabaseSchemaAssignement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Database Type Assignement</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Database Type Assignement</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseDatabaseTypeAssignement(DatabaseTypeAssignement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Database Meta Info Assignement</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Database Meta Info Assignement</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseDatabaseMetaInfoAssignement(DatabaseMetaInfoAssignement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Driver Meta Info Assignement</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Driver Meta Info Assignement</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseDriverMetaInfoAssignement(DriverMetaInfoAssignement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Driver Method Output Assignement</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Driver Method Output Assignement</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseDriverMethodOutputAssignement(DriverMethodOutputAssignement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Sql Type Assignement</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Sql Type Assignement</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSqlTypeAssignement(SqlTypeAssignement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Column Type Assignement</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Column Type Assignement</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseColumnTypeAssignement(ColumnTypeAssignement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Show Column Type Assignement</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Show Column Type Assignement</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseShowColumnTypeAssignement(ShowColumnTypeAssignement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Table Assignement</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Table Assignement</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTableAssignement(TableAssignement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Join Table Assignement</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Join Table Assignement</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseJoinTableAssignement(JoinTableAssignement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Column Assignement</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Column Assignement</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseColumnAssignement(ColumnAssignement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Import Assignement</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Import Assignement</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseImportAssignement(ImportAssignement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Export Assignement</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Export Assignement</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseExportAssignement(ExportAssignement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Inheritance Assignement</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Inheritance Assignement</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseInheritanceAssignement(InheritanceAssignement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Many To Many Assignement</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Many To Many Assignement</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseManyToManyAssignement(ManyToManyAssignement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Debug Level Assignement</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Debug Level Assignement</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseDebugLevelAssignement(DebugLevelAssignement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Procedure Pojo Assignement</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Procedure Pojo Assignement</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseProcedurePojoAssignement(ProcedurePojoAssignement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Function Pojo Assignement</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Function Pojo Assignement</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseFunctionPojoAssignement(FunctionPojoAssignement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Implements Assignement</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Implements Assignement</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseImplementsAssignement(ImplementsAssignement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Extends Assignement</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Extends Assignement</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseExtendsAssignement(ExtendsAssignement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Implements Assignement Generics</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Implements Assignement Generics</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseImplementsAssignementGenerics(ImplementsAssignementGenerics object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Extends Assignement Generics</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Extends Assignement Generics</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseExtendsAssignementGenerics(ExtendsAssignementGenerics object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Property</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Property</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseProperty(Property object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Database Property</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Database Property</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseDatabaseProperty(DatabaseProperty object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Pojogen Property</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Pojogen Property</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePojogenProperty(PojogenProperty object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Meta Type Assignement</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Meta Type Assignement</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseMetaTypeAssignement(MetaTypeAssignement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Metagen Property</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Metagen Property</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseMetagenProperty(MetagenProperty object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Daogen Property</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Daogen Property</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseDaogenProperty(DaogenProperty object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Pojo Definition</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Pojo Definition</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePojoDefinition(PojoDefinition object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Table Definition</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Table Definition</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTableDefinition(TableDefinition object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Procedure Definition</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Procedure Definition</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseProcedureDefinition(ProcedureDefinition object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Function Definition</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Function Definition</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseFunctionDefinition(FunctionDefinition object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Meta Statement</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Meta Statement</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseMetaStatement(MetaStatement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Sql</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Sql</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSql(Sql object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Sql Fragment</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Sql Fragment</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSqlFragment(SqlFragment object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Meta Sql</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Meta Sql</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseMetaSql(MetaSql object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>If Sql</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>If Sql</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseIfSql(IfSql object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>If Sql Fragment</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>If Sql Fragment</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseIfSqlFragment(IfSqlFragment object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>If Meta Sql</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>If Meta Sql</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseIfMetaSql(IfMetaSql object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>If Sql Cond</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>If Sql Cond</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseIfSqlCond(IfSqlCond object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>If Sql Bool</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>If Sql Bool</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseIfSqlBool(IfSqlBool object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Ord Sql</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Ord Sql</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseOrdSql(OrdSql object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Ord Sql2</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Ord Sql2</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseOrdSql2(OrdSql2 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Column</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Column</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseColumn(Column object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Extended Column</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Extended Column</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseExtendedColumn(ExtendedColumn object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Extended Column Name</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Extended Column Name</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseExtendedColumnName(ExtendedColumnName object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Constant</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Constant</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseConstant(Constant object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Identifier</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Identifier</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseIdentifier(Identifier object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Constant Operator</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Constant Operator</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseConstantOperator(ConstantOperator object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Identifier Operator</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Identifier Operator</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseIdentifierOperator(IdentifierOperator object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Database Column</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Database Column</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseDatabaseColumn(DatabaseColumn object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Database Table</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Database Table</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseDatabaseTable(DatabaseTable object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Mapping Rule</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Mapping Rule</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseMappingRule(MappingRule object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Mapping</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Mapping</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseMapping(Mapping object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Mapping Item</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Mapping Item</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseMappingItem(MappingItem object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Mapping Column</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Mapping Column</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseMappingColumn(MappingColumn object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Extended Mapping Item</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Extended Mapping Item</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseExtendedMappingItem(ExtendedMappingItem object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Mapping Column Name</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Mapping Column Name</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseMappingColumnName(MappingColumnName object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Optional Feature</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Optional Feature</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseOptionalFeature(OptionalFeature object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Pojo Type</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Pojo Type</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePojoType(PojoType object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Package Declaration</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Package Declaration</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePackageDeclaration(PackageDeclaration object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Annotation</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Annotation</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAnnotation(Annotation object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Annotation Property</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Annotation Property</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAnnotationProperty(AnnotationProperty object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Entity</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Entity</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseEntity(Entity object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Annotated Entity</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Annotated Entity</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAnnotatedEntity(AnnotatedEntity object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Abstract Pojo Entity</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Abstract Pojo Entity</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAbstractPojoEntity(AbstractPojoEntity object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Import</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Import</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseImport(Import object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Implements</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Implements</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseImplements(Implements object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Extends</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Extends</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseExtends(Extends object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Impl Package</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Impl Package</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseImplPackage(ImplPackage object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Pojo Entity Modifier1</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Pojo Entity Modifier1</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePojoEntityModifier1(PojoEntityModifier1 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Directive Properties</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Directive Properties</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseDirectiveProperties(DirectiveProperties object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Pojo Directive</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Pojo Directive</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePojoDirective(PojoDirective object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Pojo Entity Modifier2</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Pojo Entity Modifier2</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePojoEntityModifier2(PojoEntityModifier2 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Pojo Entity</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Pojo Entity</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePojoEntity(PojoEntity object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Pojo Annotated Property</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Pojo Annotated Property</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePojoAnnotatedProperty(PojoAnnotatedProperty object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Pojo Property Modifier</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Pojo Property Modifier</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePojoPropertyModifier(PojoPropertyModifier object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Pojo Property</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Pojo Property</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePojoProperty(PojoProperty object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Enum Entity Modifier1</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Enum Entity Modifier1</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseEnumEntityModifier1(EnumEntityModifier1 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Enum Entity Modifier2</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Enum Entity Modifier2</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseEnumEntityModifier2(EnumEntityModifier2 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Enum Entity</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Enum Entity</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseEnumEntity(EnumEntity object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Enum Property</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Enum Property</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseEnumProperty(EnumProperty object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Pojo Dao Modifier</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Pojo Dao Modifier</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePojoDaoModifier(PojoDaoModifier object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Pojo Dao</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Pojo Dao</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePojoDao(PojoDao object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Pojo Method Modifier</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Pojo Method Modifier</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePojoMethodModifier(PojoMethodModifier object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Pojo Method</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Pojo Method</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePojoMethod(PojoMethod object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>To Init Method</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>To Init Method</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseToInitMethod(ToInitMethod object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Pojo Method Arg</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Pojo Method Arg</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePojoMethodArg(PojoMethodArg object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Pojo Directive Discriminator</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Pojo Directive Discriminator</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePojoDirectiveDiscriminator(PojoDirectiveDiscriminator object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Pojo Directive Operators</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Pojo Directive Operators</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePojoDirectiveOperators(PojoDirectiveOperators object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Pojo Directive Serializable</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Pojo Directive Serializable</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePojoDirectiveSerializable(PojoDirectiveSerializable object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Pojo Directive Index</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Pojo Directive Index</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePojoDirectiveIndex(PojoDirectiveIndex object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch, but this is the last case anyway.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject)
   * @generated
   */
  @Override
  public T defaultCase(EObject object)
  {
    return null;
  }

} //ProcessorDslSwitch
