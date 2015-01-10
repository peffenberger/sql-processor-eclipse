/**
 */
package org.sqlproc.dsl.processorDsl;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.sqlproc.dsl.processorDsl.ProcessorDslPackage
 * @generated
 */
public interface ProcessorDslFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  ProcessorDslFactory eINSTANCE = org.sqlproc.dsl.processorDsl.impl.ProcessorDslFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Artifacts</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Artifacts</em>'.
   * @generated
   */
  Artifacts createArtifacts();

  /**
   * Returns a new object of class '<em>Database Catalog Assignement</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Database Catalog Assignement</em>'.
   * @generated
   */
  DatabaseCatalogAssignement createDatabaseCatalogAssignement();

  /**
   * Returns a new object of class '<em>Database Schema Assignement</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Database Schema Assignement</em>'.
   * @generated
   */
  DatabaseSchemaAssignement createDatabaseSchemaAssignement();

  /**
   * Returns a new object of class '<em>Database Type Assignement</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Database Type Assignement</em>'.
   * @generated
   */
  DatabaseTypeAssignement createDatabaseTypeAssignement();

  /**
   * Returns a new object of class '<em>Database Meta Info Assignement</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Database Meta Info Assignement</em>'.
   * @generated
   */
  DatabaseMetaInfoAssignement createDatabaseMetaInfoAssignement();

  /**
   * Returns a new object of class '<em>Driver Meta Info Assignement</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Driver Meta Info Assignement</em>'.
   * @generated
   */
  DriverMetaInfoAssignement createDriverMetaInfoAssignement();

  /**
   * Returns a new object of class '<em>Driver Method Output Assignement</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Driver Method Output Assignement</em>'.
   * @generated
   */
  DriverMethodOutputAssignement createDriverMethodOutputAssignement();

  /**
   * Returns a new object of class '<em>Sql Type Assignement</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Sql Type Assignement</em>'.
   * @generated
   */
  SqlTypeAssignement createSqlTypeAssignement();

  /**
   * Returns a new object of class '<em>Column Type Assignement</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Column Type Assignement</em>'.
   * @generated
   */
  ColumnTypeAssignement createColumnTypeAssignement();

  /**
   * Returns a new object of class '<em>Show Column Type Assignement</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Show Column Type Assignement</em>'.
   * @generated
   */
  ShowColumnTypeAssignement createShowColumnTypeAssignement();

  /**
   * Returns a new object of class '<em>Table Assignement</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Table Assignement</em>'.
   * @generated
   */
  TableAssignement createTableAssignement();

  /**
   * Returns a new object of class '<em>Join Table Assignement</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Join Table Assignement</em>'.
   * @generated
   */
  JoinTableAssignement createJoinTableAssignement();

  /**
   * Returns a new object of class '<em>Column Assignement</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Column Assignement</em>'.
   * @generated
   */
  ColumnAssignement createColumnAssignement();

  /**
   * Returns a new object of class '<em>Import Assignement</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Import Assignement</em>'.
   * @generated
   */
  ImportAssignement createImportAssignement();

  /**
   * Returns a new object of class '<em>Export Assignement</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Export Assignement</em>'.
   * @generated
   */
  ExportAssignement createExportAssignement();

  /**
   * Returns a new object of class '<em>Inheritance Assignement</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Inheritance Assignement</em>'.
   * @generated
   */
  InheritanceAssignement createInheritanceAssignement();

  /**
   * Returns a new object of class '<em>Many To Many Assignement</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Many To Many Assignement</em>'.
   * @generated
   */
  ManyToManyAssignement createManyToManyAssignement();

  /**
   * Returns a new object of class '<em>Debug Level Assignement</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Debug Level Assignement</em>'.
   * @generated
   */
  DebugLevelAssignement createDebugLevelAssignement();

  /**
   * Returns a new object of class '<em>Procedure Pojo Assignement</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Procedure Pojo Assignement</em>'.
   * @generated
   */
  ProcedurePojoAssignement createProcedurePojoAssignement();

  /**
   * Returns a new object of class '<em>Function Pojo Assignement</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Function Pojo Assignement</em>'.
   * @generated
   */
  FunctionPojoAssignement createFunctionPojoAssignement();

  /**
   * Returns a new object of class '<em>Implements Assignement</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Implements Assignement</em>'.
   * @generated
   */
  ImplementsAssignement createImplementsAssignement();

  /**
   * Returns a new object of class '<em>Extends Assignement</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Extends Assignement</em>'.
   * @generated
   */
  ExtendsAssignement createExtendsAssignement();

  /**
   * Returns a new object of class '<em>Implements Assignement Generics</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Implements Assignement Generics</em>'.
   * @generated
   */
  ImplementsAssignementGenerics createImplementsAssignementGenerics();

  /**
   * Returns a new object of class '<em>Extends Assignement Generics</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Extends Assignement Generics</em>'.
   * @generated
   */
  ExtendsAssignementGenerics createExtendsAssignementGenerics();

  /**
   * Returns a new object of class '<em>Property</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Property</em>'.
   * @generated
   */
  Property createProperty();

  /**
   * Returns a new object of class '<em>Database Property</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Database Property</em>'.
   * @generated
   */
  DatabaseProperty createDatabaseProperty();

  /**
   * Returns a new object of class '<em>Pojogen Property</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Pojogen Property</em>'.
   * @generated
   */
  PojogenProperty createPojogenProperty();

  /**
   * Returns a new object of class '<em>Meta Type Assignement</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Meta Type Assignement</em>'.
   * @generated
   */
  MetaTypeAssignement createMetaTypeAssignement();

  /**
   * Returns a new object of class '<em>Metagen Property</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Metagen Property</em>'.
   * @generated
   */
  MetagenProperty createMetagenProperty();

  /**
   * Returns a new object of class '<em>Daogen Property</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Daogen Property</em>'.
   * @generated
   */
  DaogenProperty createDaogenProperty();

  /**
   * Returns a new object of class '<em>Pojo Definition</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Pojo Definition</em>'.
   * @generated
   */
  PojoDefinition createPojoDefinition();

  /**
   * Returns a new object of class '<em>Table Definition</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Table Definition</em>'.
   * @generated
   */
  TableDefinition createTableDefinition();

  /**
   * Returns a new object of class '<em>Procedure Definition</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Procedure Definition</em>'.
   * @generated
   */
  ProcedureDefinition createProcedureDefinition();

  /**
   * Returns a new object of class '<em>Function Definition</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Function Definition</em>'.
   * @generated
   */
  FunctionDefinition createFunctionDefinition();

  /**
   * Returns a new object of class '<em>Meta Statement</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Meta Statement</em>'.
   * @generated
   */
  MetaStatement createMetaStatement();

  /**
   * Returns a new object of class '<em>Sql</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Sql</em>'.
   * @generated
   */
  Sql createSql();

  /**
   * Returns a new object of class '<em>Sql Fragment</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Sql Fragment</em>'.
   * @generated
   */
  SqlFragment createSqlFragment();

  /**
   * Returns a new object of class '<em>Meta Sql</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Meta Sql</em>'.
   * @generated
   */
  MetaSql createMetaSql();

  /**
   * Returns a new object of class '<em>If Sql</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>If Sql</em>'.
   * @generated
   */
  IfSql createIfSql();

  /**
   * Returns a new object of class '<em>If Sql Fragment</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>If Sql Fragment</em>'.
   * @generated
   */
  IfSqlFragment createIfSqlFragment();

  /**
   * Returns a new object of class '<em>If Meta Sql</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>If Meta Sql</em>'.
   * @generated
   */
  IfMetaSql createIfMetaSql();

  /**
   * Returns a new object of class '<em>If Sql Cond</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>If Sql Cond</em>'.
   * @generated
   */
  IfSqlCond createIfSqlCond();

  /**
   * Returns a new object of class '<em>If Sql Bool</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>If Sql Bool</em>'.
   * @generated
   */
  IfSqlBool createIfSqlBool();

  /**
   * Returns a new object of class '<em>Ord Sql</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Ord Sql</em>'.
   * @generated
   */
  OrdSql createOrdSql();

  /**
   * Returns a new object of class '<em>Ord Sql2</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Ord Sql2</em>'.
   * @generated
   */
  OrdSql2 createOrdSql2();

  /**
   * Returns a new object of class '<em>Column</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Column</em>'.
   * @generated
   */
  Column createColumn();

  /**
   * Returns a new object of class '<em>Extended Column</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Extended Column</em>'.
   * @generated
   */
  ExtendedColumn createExtendedColumn();

  /**
   * Returns a new object of class '<em>Extended Column Name</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Extended Column Name</em>'.
   * @generated
   */
  ExtendedColumnName createExtendedColumnName();

  /**
   * Returns a new object of class '<em>Constant</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Constant</em>'.
   * @generated
   */
  Constant createConstant();

  /**
   * Returns a new object of class '<em>Identifier</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Identifier</em>'.
   * @generated
   */
  Identifier createIdentifier();

  /**
   * Returns a new object of class '<em>Constant Operator</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Constant Operator</em>'.
   * @generated
   */
  ConstantOperator createConstantOperator();

  /**
   * Returns a new object of class '<em>Identifier Operator</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Identifier Operator</em>'.
   * @generated
   */
  IdentifierOperator createIdentifierOperator();

  /**
   * Returns a new object of class '<em>Database Column</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Database Column</em>'.
   * @generated
   */
  DatabaseColumn createDatabaseColumn();

  /**
   * Returns a new object of class '<em>Database Table</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Database Table</em>'.
   * @generated
   */
  DatabaseTable createDatabaseTable();

  /**
   * Returns a new object of class '<em>Mapping Rule</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Mapping Rule</em>'.
   * @generated
   */
  MappingRule createMappingRule();

  /**
   * Returns a new object of class '<em>Mapping</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Mapping</em>'.
   * @generated
   */
  Mapping createMapping();

  /**
   * Returns a new object of class '<em>Mapping Item</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Mapping Item</em>'.
   * @generated
   */
  MappingItem createMappingItem();

  /**
   * Returns a new object of class '<em>Mapping Column</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Mapping Column</em>'.
   * @generated
   */
  MappingColumn createMappingColumn();

  /**
   * Returns a new object of class '<em>Extended Mapping Item</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Extended Mapping Item</em>'.
   * @generated
   */
  ExtendedMappingItem createExtendedMappingItem();

  /**
   * Returns a new object of class '<em>Mapping Column Name</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Mapping Column Name</em>'.
   * @generated
   */
  MappingColumnName createMappingColumnName();

  /**
   * Returns a new object of class '<em>Optional Feature</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Optional Feature</em>'.
   * @generated
   */
  OptionalFeature createOptionalFeature();

  /**
   * Returns a new object of class '<em>Pojo Type</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Pojo Type</em>'.
   * @generated
   */
  PojoType createPojoType();

  /**
   * Returns a new object of class '<em>Package Declaration</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Package Declaration</em>'.
   * @generated
   */
  PackageDeclaration createPackageDeclaration();

  /**
   * Returns a new object of class '<em>Annotation</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Annotation</em>'.
   * @generated
   */
  Annotation createAnnotation();

  /**
   * Returns a new object of class '<em>Annotation Property</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Annotation Property</em>'.
   * @generated
   */
  AnnotationProperty createAnnotationProperty();

  /**
   * Returns a new object of class '<em>Entity</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Entity</em>'.
   * @generated
   */
  Entity createEntity();

  /**
   * Returns a new object of class '<em>Annotated Entity</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Annotated Entity</em>'.
   * @generated
   */
  AnnotatedEntity createAnnotatedEntity();

  /**
   * Returns a new object of class '<em>Abstract Pojo Entity</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Abstract Pojo Entity</em>'.
   * @generated
   */
  AbstractPojoEntity createAbstractPojoEntity();

  /**
   * Returns a new object of class '<em>Import</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Import</em>'.
   * @generated
   */
  Import createImport();

  /**
   * Returns a new object of class '<em>Implements</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Implements</em>'.
   * @generated
   */
  Implements createImplements();

  /**
   * Returns a new object of class '<em>Extends</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Extends</em>'.
   * @generated
   */
  Extends createExtends();

  /**
   * Returns a new object of class '<em>Impl Package</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Impl Package</em>'.
   * @generated
   */
  ImplPackage createImplPackage();

  /**
   * Returns a new object of class '<em>Pojo Entity Modifier1</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Pojo Entity Modifier1</em>'.
   * @generated
   */
  PojoEntityModifier1 createPojoEntityModifier1();

  /**
   * Returns a new object of class '<em>Directive Properties</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Directive Properties</em>'.
   * @generated
   */
  DirectiveProperties createDirectiveProperties();

  /**
   * Returns a new object of class '<em>Pojo Directive</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Pojo Directive</em>'.
   * @generated
   */
  PojoDirective createPojoDirective();

  /**
   * Returns a new object of class '<em>Pojo Entity Modifier2</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Pojo Entity Modifier2</em>'.
   * @generated
   */
  PojoEntityModifier2 createPojoEntityModifier2();

  /**
   * Returns a new object of class '<em>Pojo Entity</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Pojo Entity</em>'.
   * @generated
   */
  PojoEntity createPojoEntity();

  /**
   * Returns a new object of class '<em>Pojo Annotated Property</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Pojo Annotated Property</em>'.
   * @generated
   */
  PojoAnnotatedProperty createPojoAnnotatedProperty();

  /**
   * Returns a new object of class '<em>Pojo Property Directive</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Pojo Property Directive</em>'.
   * @generated
   */
  PojoPropertyDirective createPojoPropertyDirective();

  /**
   * Returns a new object of class '<em>Pojo Property</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Pojo Property</em>'.
   * @generated
   */
  PojoProperty createPojoProperty();

  /**
   * Returns a new object of class '<em>Enum Entity Modifier1</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Enum Entity Modifier1</em>'.
   * @generated
   */
  EnumEntityModifier1 createEnumEntityModifier1();

  /**
   * Returns a new object of class '<em>Enum Entity Modifier2</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Enum Entity Modifier2</em>'.
   * @generated
   */
  EnumEntityModifier2 createEnumEntityModifier2();

  /**
   * Returns a new object of class '<em>Enum Entity</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Enum Entity</em>'.
   * @generated
   */
  EnumEntity createEnumEntity();

  /**
   * Returns a new object of class '<em>Enum Property</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Enum Property</em>'.
   * @generated
   */
  EnumProperty createEnumProperty();

  /**
   * Returns a new object of class '<em>Pojo Dao Modifier</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Pojo Dao Modifier</em>'.
   * @generated
   */
  PojoDaoModifier createPojoDaoModifier();

  /**
   * Returns a new object of class '<em>Pojo Dao</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Pojo Dao</em>'.
   * @generated
   */
  PojoDao createPojoDao();

  /**
   * Returns a new object of class '<em>Pojo Method Modifier</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Pojo Method Modifier</em>'.
   * @generated
   */
  PojoMethodModifier createPojoMethodModifier();

  /**
   * Returns a new object of class '<em>Pojo Method</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Pojo Method</em>'.
   * @generated
   */
  PojoMethod createPojoMethod();

  /**
   * Returns a new object of class '<em>To Init Method</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>To Init Method</em>'.
   * @generated
   */
  ToInitMethod createToInitMethod();

  /**
   * Returns a new object of class '<em>Pojo Method Arg</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Pojo Method Arg</em>'.
   * @generated
   */
  PojoMethodArg createPojoMethodArg();

  /**
   * Returns a new object of class '<em>Pojo Directive Discriminator</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Pojo Directive Discriminator</em>'.
   * @generated
   */
  PojoDirectiveDiscriminator createPojoDirectiveDiscriminator();

  /**
   * Returns a new object of class '<em>Pojo Directive Operators</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Pojo Directive Operators</em>'.
   * @generated
   */
  PojoDirectiveOperators createPojoDirectiveOperators();

  /**
   * Returns a new object of class '<em>Pojo Directive Serializable</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Pojo Directive Serializable</em>'.
   * @generated
   */
  PojoDirectiveSerializable createPojoDirectiveSerializable();

  /**
   * Returns a new object of class '<em>Pojo Directive Index</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Pojo Directive Index</em>'.
   * @generated
   */
  PojoDirectiveIndex createPojoDirectiveIndex();

  /**
   * Returns a new object of class '<em>Pojo Property Directive Required</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Pojo Property Directive Required</em>'.
   * @generated
   */
  PojoPropertyDirectiveRequired createPojoPropertyDirectiveRequired();

  /**
   * Returns a new object of class '<em>Pojo Property Directive Primary Key</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Pojo Property Directive Primary Key</em>'.
   * @generated
   */
  PojoPropertyDirectivePrimaryKey createPojoPropertyDirectivePrimaryKey();

  /**
   * Returns a new object of class '<em>Pojo Property Directive Discriminator</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Pojo Property Directive Discriminator</em>'.
   * @generated
   */
  PojoPropertyDirectiveDiscriminator createPojoPropertyDirectiveDiscriminator();

  /**
   * Returns a new object of class '<em>Pojo Property Directive Index</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Pojo Property Directive Index</em>'.
   * @generated
   */
  PojoPropertyDirectiveIndex createPojoPropertyDirectiveIndex();

  /**
   * Returns a new object of class '<em>Pojo Property Directive Version</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Pojo Property Directive Version</em>'.
   * @generated
   */
  PojoPropertyDirectiveVersion createPojoPropertyDirectiveVersion();

  /**
   * Returns a new object of class '<em>Pojo Property Directive Update Col</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Pojo Property Directive Update Col</em>'.
   * @generated
   */
  PojoPropertyDirectiveUpdateCol createPojoPropertyDirectiveUpdateCol();

  /**
   * Returns a new object of class '<em>Pojo Property Directive Create Col</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Pojo Property Directive Create Col</em>'.
   * @generated
   */
  PojoPropertyDirectiveCreateCol createPojoPropertyDirectiveCreateCol();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  ProcessorDslPackage getProcessorDslPackage();

} //ProcessorDslFactory
