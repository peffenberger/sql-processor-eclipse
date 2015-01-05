/**
 */
package org.sqlproc.dsl.processorDsl.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.sqlproc.dsl.processorDsl.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ProcessorDslFactoryImpl extends EFactoryImpl implements ProcessorDslFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static ProcessorDslFactory init()
  {
    try
    {
      ProcessorDslFactory theProcessorDslFactory = (ProcessorDslFactory)EPackage.Registry.INSTANCE.getEFactory(ProcessorDslPackage.eNS_URI);
      if (theProcessorDslFactory != null)
      {
        return theProcessorDslFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new ProcessorDslFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ProcessorDslFactoryImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EObject create(EClass eClass)
  {
    switch (eClass.getClassifierID())
    {
      case ProcessorDslPackage.ARTIFACTS: return createArtifacts();
      case ProcessorDslPackage.DATABASE_CATALOG_ASSIGNEMENT: return createDatabaseCatalogAssignement();
      case ProcessorDslPackage.DATABASE_SCHEMA_ASSIGNEMENT: return createDatabaseSchemaAssignement();
      case ProcessorDslPackage.DATABASE_TYPE_ASSIGNEMENT: return createDatabaseTypeAssignement();
      case ProcessorDslPackage.DATABASE_META_INFO_ASSIGNEMENT: return createDatabaseMetaInfoAssignement();
      case ProcessorDslPackage.DRIVER_META_INFO_ASSIGNEMENT: return createDriverMetaInfoAssignement();
      case ProcessorDslPackage.DRIVER_METHOD_OUTPUT_ASSIGNEMENT: return createDriverMethodOutputAssignement();
      case ProcessorDslPackage.SQL_TYPE_ASSIGNEMENT: return createSqlTypeAssignement();
      case ProcessorDslPackage.COLUMN_TYPE_ASSIGNEMENT: return createColumnTypeAssignement();
      case ProcessorDslPackage.SHOW_COLUMN_TYPE_ASSIGNEMENT: return createShowColumnTypeAssignement();
      case ProcessorDslPackage.TABLE_ASSIGNEMENT: return createTableAssignement();
      case ProcessorDslPackage.JOIN_TABLE_ASSIGNEMENT: return createJoinTableAssignement();
      case ProcessorDslPackage.COLUMN_ASSIGNEMENT: return createColumnAssignement();
      case ProcessorDslPackage.IMPORT_ASSIGNEMENT: return createImportAssignement();
      case ProcessorDslPackage.EXPORT_ASSIGNEMENT: return createExportAssignement();
      case ProcessorDslPackage.INHERITANCE_ASSIGNEMENT: return createInheritanceAssignement();
      case ProcessorDslPackage.MANY_TO_MANY_ASSIGNEMENT: return createManyToManyAssignement();
      case ProcessorDslPackage.DEBUG_LEVEL_ASSIGNEMENT: return createDebugLevelAssignement();
      case ProcessorDslPackage.PROCEDURE_POJO_ASSIGNEMENT: return createProcedurePojoAssignement();
      case ProcessorDslPackage.FUNCTION_POJO_ASSIGNEMENT: return createFunctionPojoAssignement();
      case ProcessorDslPackage.IMPLEMENTS_ASSIGNEMENT: return createImplementsAssignement();
      case ProcessorDslPackage.EXTENDS_ASSIGNEMENT: return createExtendsAssignement();
      case ProcessorDslPackage.IMPLEMENTS_ASSIGNEMENT_GENERICS: return createImplementsAssignementGenerics();
      case ProcessorDslPackage.EXTENDS_ASSIGNEMENT_GENERICS: return createExtendsAssignementGenerics();
      case ProcessorDslPackage.PROPERTY: return createProperty();
      case ProcessorDslPackage.DATABASE_PROPERTY: return createDatabaseProperty();
      case ProcessorDslPackage.POJOGEN_PROPERTY: return createPojogenProperty();
      case ProcessorDslPackage.META_TYPE_ASSIGNEMENT: return createMetaTypeAssignement();
      case ProcessorDslPackage.METAGEN_PROPERTY: return createMetagenProperty();
      case ProcessorDslPackage.DAOGEN_PROPERTY: return createDaogenProperty();
      case ProcessorDslPackage.POJO_DEFINITION: return createPojoDefinition();
      case ProcessorDslPackage.TABLE_DEFINITION: return createTableDefinition();
      case ProcessorDslPackage.PROCEDURE_DEFINITION: return createProcedureDefinition();
      case ProcessorDslPackage.FUNCTION_DEFINITION: return createFunctionDefinition();
      case ProcessorDslPackage.META_STATEMENT: return createMetaStatement();
      case ProcessorDslPackage.SQL: return createSql();
      case ProcessorDslPackage.SQL_FRAGMENT: return createSqlFragment();
      case ProcessorDslPackage.META_SQL: return createMetaSql();
      case ProcessorDslPackage.IF_SQL: return createIfSql();
      case ProcessorDslPackage.IF_SQL_FRAGMENT: return createIfSqlFragment();
      case ProcessorDslPackage.IF_META_SQL: return createIfMetaSql();
      case ProcessorDslPackage.IF_SQL_COND: return createIfSqlCond();
      case ProcessorDslPackage.IF_SQL_BOOL: return createIfSqlBool();
      case ProcessorDslPackage.ORD_SQL: return createOrdSql();
      case ProcessorDslPackage.ORD_SQL2: return createOrdSql2();
      case ProcessorDslPackage.COLUMN: return createColumn();
      case ProcessorDslPackage.EXTENDED_COLUMN: return createExtendedColumn();
      case ProcessorDslPackage.EXTENDED_COLUMN_NAME: return createExtendedColumnName();
      case ProcessorDslPackage.CONSTANT: return createConstant();
      case ProcessorDslPackage.IDENTIFIER: return createIdentifier();
      case ProcessorDslPackage.CONSTANT_OPERATOR: return createConstantOperator();
      case ProcessorDslPackage.IDENTIFIER_OPERATOR: return createIdentifierOperator();
      case ProcessorDslPackage.DATABASE_COLUMN: return createDatabaseColumn();
      case ProcessorDslPackage.DATABASE_TABLE: return createDatabaseTable();
      case ProcessorDslPackage.MAPPING_RULE: return createMappingRule();
      case ProcessorDslPackage.MAPPING: return createMapping();
      case ProcessorDslPackage.MAPPING_ITEM: return createMappingItem();
      case ProcessorDslPackage.MAPPING_COLUMN: return createMappingColumn();
      case ProcessorDslPackage.EXTENDED_MAPPING_ITEM: return createExtendedMappingItem();
      case ProcessorDslPackage.MAPPING_COLUMN_NAME: return createMappingColumnName();
      case ProcessorDslPackage.OPTIONAL_FEATURE: return createOptionalFeature();
      case ProcessorDslPackage.PACKAGE_DIRECTIVE: return createPackageDirective();
      case ProcessorDslPackage.PACKAGE_DECLARATION: return createPackageDeclaration();
      case ProcessorDslPackage.ENTITY: return createEntity();
      case ProcessorDslPackage.ABSTRACT_ENTITY: return createAbstractEntity();
      case ProcessorDslPackage.POJO_TYPE: return createPojoType();
      case ProcessorDslPackage.DAO_TYPE: return createDaoType();
      case ProcessorDslPackage.IMPORT: return createImport();
      case ProcessorDslPackage.IMPLEMENTS: return createImplements();
      case ProcessorDslPackage.EXTENDS: return createExtends();
      case ProcessorDslPackage.IMPL_PACKAGE: return createImplPackage();
      case ProcessorDslPackage.ANNOTATION_PROPERTY: return createAnnotationProperty();
      case ProcessorDslPackage.ANNOTATION: return createAnnotation();
      case ProcessorDslPackage.ENTITY_ANNOTATION: return createEntityAnnotation();
      case ProcessorDslPackage.DIRECTIVE_PROPERTIES: return createDirectiveProperties();
      case ProcessorDslPackage.POJO_DIRECTIVE: return createPojoDirective();
      case ProcessorDslPackage.POJO_ENTITY: return createPojoEntity();
      case ProcessorDslPackage.POJO_PROPERTY_ANNOTATION: return createPojoPropertyAnnotation();
      case ProcessorDslPackage.POJO_PROPERTY_DIRECTIVE: return createPojoPropertyDirective();
      case ProcessorDslPackage.POJO_PROPERTY: return createPojoProperty();
      case ProcessorDslPackage.ENUM_DIRECTIVE: return createEnumDirective();
      case ProcessorDslPackage.ENUM_ENTITY: return createEnumEntity();
      case ProcessorDslPackage.ENUM_PROPERTY_VALUE: return createEnumPropertyValue();
      case ProcessorDslPackage.ENUM_PROPERTY_DIRECTIVE: return createEnumPropertyDirective();
      case ProcessorDslPackage.ENUM_PROPERTY: return createEnumProperty();
      case ProcessorDslPackage.DIRECTIVE_PARAMETERS: return createDirectiveParameters();
      case ProcessorDslPackage.DAO_DIRECTIVE: return createDaoDirective();
      case ProcessorDslPackage.POJO_DAO: return createPojoDao();
      case ProcessorDslPackage.PACKAGE_DIRECTIVE_SUFFIX: return createPackageDirectiveSuffix();
      case ProcessorDslPackage.CONFLICT_ANNOTATION: return createConflictAnnotation();
      case ProcessorDslPackage.STATIC_ANNOTATION: return createStaticAnnotation();
      case ProcessorDslPackage.CONSTRUCTOR_ANNOTATION: return createConstructorAnnotation();
      case ProcessorDslPackage.STANDARD_ANNOTATION: return createStandardAnnotation();
      case ProcessorDslPackage.POJO_DIRECTIVE_FINAL: return createPojoDirectiveFinal();
      case ProcessorDslPackage.POJO_DIRECTIVE_ABSTRACT: return createPojoDirectiveAbstract();
      case ProcessorDslPackage.POJO_DIRECTIVE_EXTENDS: return createPojoDirectiveExtends();
      case ProcessorDslPackage.POJO_DIRECTIVE_DISCRIMINATOR: return createPojoDirectiveDiscriminator();
      case ProcessorDslPackage.POJO_DIRECTIVE_OPERATORS: return createPojoDirectiveOperators();
      case ProcessorDslPackage.POJO_DIRECTIVE_SERIALIZABLE: return createPojoDirectiveSerializable();
      case ProcessorDslPackage.POJO_DIRECTIVE_EQUALS: return createPojoDirectiveEquals();
      case ProcessorDslPackage.POJO_DIRECTIVE_HASH_CODE: return createPojoDirectiveHashCode();
      case ProcessorDslPackage.POJO_DIRECTIVE_TO_INIT: return createPojoDirectiveToInit();
      case ProcessorDslPackage.POJO_DIRECTIVE_ENUM_INIT: return createPojoDirectiveEnumInit();
      case ProcessorDslPackage.POJO_DIRECTIVE_IS_DEF: return createPojoDirectiveIsDef();
      case ProcessorDslPackage.POJO_DIRECTIVE_ENUM_DEF: return createPojoDirectiveEnumDef();
      case ProcessorDslPackage.POJO_DIRECTIVE_TO_STRING: return createPojoDirectiveToString();
      case ProcessorDslPackage.POJO_DIRECTIVE_INDEX: return createPojoDirectiveIndex();
      case ProcessorDslPackage.SETTER_ANNOTATION: return createSetterAnnotation();
      case ProcessorDslPackage.GETTER_ANNOTATION: return createGetterAnnotation();
      case ProcessorDslPackage.ATTRIBUTE_ANNOTATION: return createAttributeAnnotation();
      case ProcessorDslPackage.POJO_PROPERTY_DIRECTIVE_REQUIRED: return createPojoPropertyDirectiveRequired();
      case ProcessorDslPackage.POJO_PROPERTY_DIRECTIVE_PRIMARY_KEY: return createPojoPropertyDirectivePrimaryKey();
      case ProcessorDslPackage.POJO_PROPERTY_DIRECTIVE_DISCRIMINATOR: return createPojoPropertyDirectiveDiscriminator();
      case ProcessorDslPackage.POJO_PROPERTY_DIRECTIVE_INDEX: return createPojoPropertyDirectiveIndex();
      case ProcessorDslPackage.POJO_PROPERTY_DIRECTIVE_VERSION: return createPojoPropertyDirectiveVersion();
      case ProcessorDslPackage.POJO_PROPERTY_DIRECTIVE_UPDATE_COL: return createPojoPropertyDirectiveUpdateCol();
      case ProcessorDslPackage.POJO_PROPERTY_DIRECTIVE_CREATE_COL: return createPojoPropertyDirectiveCreateCol();
      case ProcessorDslPackage.ENUM_DIRECTIVE_FINAL: return createEnumDirectiveFinal();
      case ProcessorDslPackage.ENUM_DIRECTIVE_EXTENDS: return createEnumDirectiveExtends();
      case ProcessorDslPackage.ENUM_DIRECTIVE_SERIALIZABLE: return createEnumDirectiveSerializable();
      case ProcessorDslPackage.ENUM_PROPERTY_DIRECTIVE_VALUES: return createEnumPropertyDirectiveValues();
      case ProcessorDslPackage.DAO_DIRECTIVE_FINAL: return createDaoDirectiveFinal();
      case ProcessorDslPackage.DAO_DIRECTIVE_ABSTRACT: return createDaoDirectiveAbstract();
      case ProcessorDslPackage.DAO_DIRECTIVE_EXTENDS: return createDaoDirectiveExtends();
      case ProcessorDslPackage.DAO_DIRECTIVE_DISCRIMINATOR: return createDaoDirectiveDiscriminator();
      case ProcessorDslPackage.DAO_DIRECTIVE_SERIALIZABLE: return createDaoDirectiveSerializable();
      case ProcessorDslPackage.DAO_DIRECTIVE_POJO: return createDaoDirectivePojo();
      case ProcessorDslPackage.DAO_DIRECTIVE_GENERICS: return createDaoDirectiveGenerics();
      case ProcessorDslPackage.DAO_DIRECTIVE_PROCEDURE: return createDaoDirectiveProcedure();
      case ProcessorDslPackage.DAO_DIRECTIVE_FUNCTION: return createDaoDirectiveFunction();
      case ProcessorDslPackage.DAO_DIRECTIVE_UPDATE: return createDaoDirectiveUpdate();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Artifacts createArtifacts()
  {
    ArtifactsImpl artifacts = new ArtifactsImpl();
    return artifacts;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DatabaseCatalogAssignement createDatabaseCatalogAssignement()
  {
    DatabaseCatalogAssignementImpl databaseCatalogAssignement = new DatabaseCatalogAssignementImpl();
    return databaseCatalogAssignement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DatabaseSchemaAssignement createDatabaseSchemaAssignement()
  {
    DatabaseSchemaAssignementImpl databaseSchemaAssignement = new DatabaseSchemaAssignementImpl();
    return databaseSchemaAssignement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DatabaseTypeAssignement createDatabaseTypeAssignement()
  {
    DatabaseTypeAssignementImpl databaseTypeAssignement = new DatabaseTypeAssignementImpl();
    return databaseTypeAssignement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DatabaseMetaInfoAssignement createDatabaseMetaInfoAssignement()
  {
    DatabaseMetaInfoAssignementImpl databaseMetaInfoAssignement = new DatabaseMetaInfoAssignementImpl();
    return databaseMetaInfoAssignement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DriverMetaInfoAssignement createDriverMetaInfoAssignement()
  {
    DriverMetaInfoAssignementImpl driverMetaInfoAssignement = new DriverMetaInfoAssignementImpl();
    return driverMetaInfoAssignement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DriverMethodOutputAssignement createDriverMethodOutputAssignement()
  {
    DriverMethodOutputAssignementImpl driverMethodOutputAssignement = new DriverMethodOutputAssignementImpl();
    return driverMethodOutputAssignement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SqlTypeAssignement createSqlTypeAssignement()
  {
    SqlTypeAssignementImpl sqlTypeAssignement = new SqlTypeAssignementImpl();
    return sqlTypeAssignement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ColumnTypeAssignement createColumnTypeAssignement()
  {
    ColumnTypeAssignementImpl columnTypeAssignement = new ColumnTypeAssignementImpl();
    return columnTypeAssignement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ShowColumnTypeAssignement createShowColumnTypeAssignement()
  {
    ShowColumnTypeAssignementImpl showColumnTypeAssignement = new ShowColumnTypeAssignementImpl();
    return showColumnTypeAssignement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TableAssignement createTableAssignement()
  {
    TableAssignementImpl tableAssignement = new TableAssignementImpl();
    return tableAssignement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public JoinTableAssignement createJoinTableAssignement()
  {
    JoinTableAssignementImpl joinTableAssignement = new JoinTableAssignementImpl();
    return joinTableAssignement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ColumnAssignement createColumnAssignement()
  {
    ColumnAssignementImpl columnAssignement = new ColumnAssignementImpl();
    return columnAssignement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ImportAssignement createImportAssignement()
  {
    ImportAssignementImpl importAssignement = new ImportAssignementImpl();
    return importAssignement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ExportAssignement createExportAssignement()
  {
    ExportAssignementImpl exportAssignement = new ExportAssignementImpl();
    return exportAssignement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public InheritanceAssignement createInheritanceAssignement()
  {
    InheritanceAssignementImpl inheritanceAssignement = new InheritanceAssignementImpl();
    return inheritanceAssignement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ManyToManyAssignement createManyToManyAssignement()
  {
    ManyToManyAssignementImpl manyToManyAssignement = new ManyToManyAssignementImpl();
    return manyToManyAssignement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DebugLevelAssignement createDebugLevelAssignement()
  {
    DebugLevelAssignementImpl debugLevelAssignement = new DebugLevelAssignementImpl();
    return debugLevelAssignement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ProcedurePojoAssignement createProcedurePojoAssignement()
  {
    ProcedurePojoAssignementImpl procedurePojoAssignement = new ProcedurePojoAssignementImpl();
    return procedurePojoAssignement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FunctionPojoAssignement createFunctionPojoAssignement()
  {
    FunctionPojoAssignementImpl functionPojoAssignement = new FunctionPojoAssignementImpl();
    return functionPojoAssignement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ImplementsAssignement createImplementsAssignement()
  {
    ImplementsAssignementImpl implementsAssignement = new ImplementsAssignementImpl();
    return implementsAssignement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ExtendsAssignement createExtendsAssignement()
  {
    ExtendsAssignementImpl extendsAssignement = new ExtendsAssignementImpl();
    return extendsAssignement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ImplementsAssignementGenerics createImplementsAssignementGenerics()
  {
    ImplementsAssignementGenericsImpl implementsAssignementGenerics = new ImplementsAssignementGenericsImpl();
    return implementsAssignementGenerics;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ExtendsAssignementGenerics createExtendsAssignementGenerics()
  {
    ExtendsAssignementGenericsImpl extendsAssignementGenerics = new ExtendsAssignementGenericsImpl();
    return extendsAssignementGenerics;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Property createProperty()
  {
    PropertyImpl property = new PropertyImpl();
    return property;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DatabaseProperty createDatabaseProperty()
  {
    DatabasePropertyImpl databaseProperty = new DatabasePropertyImpl();
    return databaseProperty;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PojogenProperty createPojogenProperty()
  {
    PojogenPropertyImpl pojogenProperty = new PojogenPropertyImpl();
    return pojogenProperty;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MetaTypeAssignement createMetaTypeAssignement()
  {
    MetaTypeAssignementImpl metaTypeAssignement = new MetaTypeAssignementImpl();
    return metaTypeAssignement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MetagenProperty createMetagenProperty()
  {
    MetagenPropertyImpl metagenProperty = new MetagenPropertyImpl();
    return metagenProperty;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DaogenProperty createDaogenProperty()
  {
    DaogenPropertyImpl daogenProperty = new DaogenPropertyImpl();
    return daogenProperty;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PojoDefinition createPojoDefinition()
  {
    PojoDefinitionImpl pojoDefinition = new PojoDefinitionImpl();
    return pojoDefinition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TableDefinition createTableDefinition()
  {
    TableDefinitionImpl tableDefinition = new TableDefinitionImpl();
    return tableDefinition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ProcedureDefinition createProcedureDefinition()
  {
    ProcedureDefinitionImpl procedureDefinition = new ProcedureDefinitionImpl();
    return procedureDefinition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FunctionDefinition createFunctionDefinition()
  {
    FunctionDefinitionImpl functionDefinition = new FunctionDefinitionImpl();
    return functionDefinition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MetaStatement createMetaStatement()
  {
    MetaStatementImpl metaStatement = new MetaStatementImpl();
    return metaStatement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Sql createSql()
  {
    SqlImpl sql = new SqlImpl();
    return sql;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SqlFragment createSqlFragment()
  {
    SqlFragmentImpl sqlFragment = new SqlFragmentImpl();
    return sqlFragment;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MetaSql createMetaSql()
  {
    MetaSqlImpl metaSql = new MetaSqlImpl();
    return metaSql;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public IfSql createIfSql()
  {
    IfSqlImpl ifSql = new IfSqlImpl();
    return ifSql;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public IfSqlFragment createIfSqlFragment()
  {
    IfSqlFragmentImpl ifSqlFragment = new IfSqlFragmentImpl();
    return ifSqlFragment;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public IfMetaSql createIfMetaSql()
  {
    IfMetaSqlImpl ifMetaSql = new IfMetaSqlImpl();
    return ifMetaSql;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public IfSqlCond createIfSqlCond()
  {
    IfSqlCondImpl ifSqlCond = new IfSqlCondImpl();
    return ifSqlCond;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public IfSqlBool createIfSqlBool()
  {
    IfSqlBoolImpl ifSqlBool = new IfSqlBoolImpl();
    return ifSqlBool;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public OrdSql createOrdSql()
  {
    OrdSqlImpl ordSql = new OrdSqlImpl();
    return ordSql;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public OrdSql2 createOrdSql2()
  {
    OrdSql2Impl ordSql2 = new OrdSql2Impl();
    return ordSql2;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Column createColumn()
  {
    ColumnImpl column = new ColumnImpl();
    return column;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ExtendedColumn createExtendedColumn()
  {
    ExtendedColumnImpl extendedColumn = new ExtendedColumnImpl();
    return extendedColumn;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ExtendedColumnName createExtendedColumnName()
  {
    ExtendedColumnNameImpl extendedColumnName = new ExtendedColumnNameImpl();
    return extendedColumnName;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Constant createConstant()
  {
    ConstantImpl constant = new ConstantImpl();
    return constant;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Identifier createIdentifier()
  {
    IdentifierImpl identifier = new IdentifierImpl();
    return identifier;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ConstantOperator createConstantOperator()
  {
    ConstantOperatorImpl constantOperator = new ConstantOperatorImpl();
    return constantOperator;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public IdentifierOperator createIdentifierOperator()
  {
    IdentifierOperatorImpl identifierOperator = new IdentifierOperatorImpl();
    return identifierOperator;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DatabaseColumn createDatabaseColumn()
  {
    DatabaseColumnImpl databaseColumn = new DatabaseColumnImpl();
    return databaseColumn;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DatabaseTable createDatabaseTable()
  {
    DatabaseTableImpl databaseTable = new DatabaseTableImpl();
    return databaseTable;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MappingRule createMappingRule()
  {
    MappingRuleImpl mappingRule = new MappingRuleImpl();
    return mappingRule;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Mapping createMapping()
  {
    MappingImpl mapping = new MappingImpl();
    return mapping;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MappingItem createMappingItem()
  {
    MappingItemImpl mappingItem = new MappingItemImpl();
    return mappingItem;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MappingColumn createMappingColumn()
  {
    MappingColumnImpl mappingColumn = new MappingColumnImpl();
    return mappingColumn;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ExtendedMappingItem createExtendedMappingItem()
  {
    ExtendedMappingItemImpl extendedMappingItem = new ExtendedMappingItemImpl();
    return extendedMappingItem;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MappingColumnName createMappingColumnName()
  {
    MappingColumnNameImpl mappingColumnName = new MappingColumnNameImpl();
    return mappingColumnName;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public OptionalFeature createOptionalFeature()
  {
    OptionalFeatureImpl optionalFeature = new OptionalFeatureImpl();
    return optionalFeature;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PackageDirective createPackageDirective()
  {
    PackageDirectiveImpl packageDirective = new PackageDirectiveImpl();
    return packageDirective;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PackageDeclaration createPackageDeclaration()
  {
    PackageDeclarationImpl packageDeclaration = new PackageDeclarationImpl();
    return packageDeclaration;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Entity createEntity()
  {
    EntityImpl entity = new EntityImpl();
    return entity;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AbstractEntity createAbstractEntity()
  {
    AbstractEntityImpl abstractEntity = new AbstractEntityImpl();
    return abstractEntity;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PojoType createPojoType()
  {
    PojoTypeImpl pojoType = new PojoTypeImpl();
    return pojoType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DaoType createDaoType()
  {
    DaoTypeImpl daoType = new DaoTypeImpl();
    return daoType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Import createImport()
  {
    ImportImpl import_ = new ImportImpl();
    return import_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Implements createImplements()
  {
    ImplementsImpl implements_ = new ImplementsImpl();
    return implements_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Extends createExtends()
  {
    ExtendsImpl extends_ = new ExtendsImpl();
    return extends_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ImplPackage createImplPackage()
  {
    ImplPackageImpl implPackage = new ImplPackageImpl();
    return implPackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AnnotationProperty createAnnotationProperty()
  {
    AnnotationPropertyImpl annotationProperty = new AnnotationPropertyImpl();
    return annotationProperty;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Annotation createAnnotation()
  {
    AnnotationImpl annotation = new AnnotationImpl();
    return annotation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EntityAnnotation createEntityAnnotation()
  {
    EntityAnnotationImpl entityAnnotation = new EntityAnnotationImpl();
    return entityAnnotation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DirectiveProperties createDirectiveProperties()
  {
    DirectivePropertiesImpl directiveProperties = new DirectivePropertiesImpl();
    return directiveProperties;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PojoDirective createPojoDirective()
  {
    PojoDirectiveImpl pojoDirective = new PojoDirectiveImpl();
    return pojoDirective;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PojoEntity createPojoEntity()
  {
    PojoEntityImpl pojoEntity = new PojoEntityImpl();
    return pojoEntity;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PojoPropertyAnnotation createPojoPropertyAnnotation()
  {
    PojoPropertyAnnotationImpl pojoPropertyAnnotation = new PojoPropertyAnnotationImpl();
    return pojoPropertyAnnotation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PojoPropertyDirective createPojoPropertyDirective()
  {
    PojoPropertyDirectiveImpl pojoPropertyDirective = new PojoPropertyDirectiveImpl();
    return pojoPropertyDirective;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PojoProperty createPojoProperty()
  {
    PojoPropertyImpl pojoProperty = new PojoPropertyImpl();
    return pojoProperty;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EnumDirective createEnumDirective()
  {
    EnumDirectiveImpl enumDirective = new EnumDirectiveImpl();
    return enumDirective;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EnumEntity createEnumEntity()
  {
    EnumEntityImpl enumEntity = new EnumEntityImpl();
    return enumEntity;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EnumPropertyValue createEnumPropertyValue()
  {
    EnumPropertyValueImpl enumPropertyValue = new EnumPropertyValueImpl();
    return enumPropertyValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EnumPropertyDirective createEnumPropertyDirective()
  {
    EnumPropertyDirectiveImpl enumPropertyDirective = new EnumPropertyDirectiveImpl();
    return enumPropertyDirective;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EnumProperty createEnumProperty()
  {
    EnumPropertyImpl enumProperty = new EnumPropertyImpl();
    return enumProperty;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DirectiveParameters createDirectiveParameters()
  {
    DirectiveParametersImpl directiveParameters = new DirectiveParametersImpl();
    return directiveParameters;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DaoDirective createDaoDirective()
  {
    DaoDirectiveImpl daoDirective = new DaoDirectiveImpl();
    return daoDirective;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PojoDao createPojoDao()
  {
    PojoDaoImpl pojoDao = new PojoDaoImpl();
    return pojoDao;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PackageDirectiveSuffix createPackageDirectiveSuffix()
  {
    PackageDirectiveSuffixImpl packageDirectiveSuffix = new PackageDirectiveSuffixImpl();
    return packageDirectiveSuffix;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ConflictAnnotation createConflictAnnotation()
  {
    ConflictAnnotationImpl conflictAnnotation = new ConflictAnnotationImpl();
    return conflictAnnotation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public StaticAnnotation createStaticAnnotation()
  {
    StaticAnnotationImpl staticAnnotation = new StaticAnnotationImpl();
    return staticAnnotation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ConstructorAnnotation createConstructorAnnotation()
  {
    ConstructorAnnotationImpl constructorAnnotation = new ConstructorAnnotationImpl();
    return constructorAnnotation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public StandardAnnotation createStandardAnnotation()
  {
    StandardAnnotationImpl standardAnnotation = new StandardAnnotationImpl();
    return standardAnnotation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PojoDirectiveFinal createPojoDirectiveFinal()
  {
    PojoDirectiveFinalImpl pojoDirectiveFinal = new PojoDirectiveFinalImpl();
    return pojoDirectiveFinal;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PojoDirectiveAbstract createPojoDirectiveAbstract()
  {
    PojoDirectiveAbstractImpl pojoDirectiveAbstract = new PojoDirectiveAbstractImpl();
    return pojoDirectiveAbstract;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PojoDirectiveExtends createPojoDirectiveExtends()
  {
    PojoDirectiveExtendsImpl pojoDirectiveExtends = new PojoDirectiveExtendsImpl();
    return pojoDirectiveExtends;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PojoDirectiveDiscriminator createPojoDirectiveDiscriminator()
  {
    PojoDirectiveDiscriminatorImpl pojoDirectiveDiscriminator = new PojoDirectiveDiscriminatorImpl();
    return pojoDirectiveDiscriminator;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PojoDirectiveOperators createPojoDirectiveOperators()
  {
    PojoDirectiveOperatorsImpl pojoDirectiveOperators = new PojoDirectiveOperatorsImpl();
    return pojoDirectiveOperators;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PojoDirectiveSerializable createPojoDirectiveSerializable()
  {
    PojoDirectiveSerializableImpl pojoDirectiveSerializable = new PojoDirectiveSerializableImpl();
    return pojoDirectiveSerializable;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PojoDirectiveEquals createPojoDirectiveEquals()
  {
    PojoDirectiveEqualsImpl pojoDirectiveEquals = new PojoDirectiveEqualsImpl();
    return pojoDirectiveEquals;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PojoDirectiveHashCode createPojoDirectiveHashCode()
  {
    PojoDirectiveHashCodeImpl pojoDirectiveHashCode = new PojoDirectiveHashCodeImpl();
    return pojoDirectiveHashCode;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PojoDirectiveToInit createPojoDirectiveToInit()
  {
    PojoDirectiveToInitImpl pojoDirectiveToInit = new PojoDirectiveToInitImpl();
    return pojoDirectiveToInit;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PojoDirectiveEnumInit createPojoDirectiveEnumInit()
  {
    PojoDirectiveEnumInitImpl pojoDirectiveEnumInit = new PojoDirectiveEnumInitImpl();
    return pojoDirectiveEnumInit;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PojoDirectiveIsDef createPojoDirectiveIsDef()
  {
    PojoDirectiveIsDefImpl pojoDirectiveIsDef = new PojoDirectiveIsDefImpl();
    return pojoDirectiveIsDef;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PojoDirectiveEnumDef createPojoDirectiveEnumDef()
  {
    PojoDirectiveEnumDefImpl pojoDirectiveEnumDef = new PojoDirectiveEnumDefImpl();
    return pojoDirectiveEnumDef;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PojoDirectiveToString createPojoDirectiveToString()
  {
    PojoDirectiveToStringImpl pojoDirectiveToString = new PojoDirectiveToStringImpl();
    return pojoDirectiveToString;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PojoDirectiveIndex createPojoDirectiveIndex()
  {
    PojoDirectiveIndexImpl pojoDirectiveIndex = new PojoDirectiveIndexImpl();
    return pojoDirectiveIndex;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SetterAnnotation createSetterAnnotation()
  {
    SetterAnnotationImpl setterAnnotation = new SetterAnnotationImpl();
    return setterAnnotation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public GetterAnnotation createGetterAnnotation()
  {
    GetterAnnotationImpl getterAnnotation = new GetterAnnotationImpl();
    return getterAnnotation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AttributeAnnotation createAttributeAnnotation()
  {
    AttributeAnnotationImpl attributeAnnotation = new AttributeAnnotationImpl();
    return attributeAnnotation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PojoPropertyDirectiveRequired createPojoPropertyDirectiveRequired()
  {
    PojoPropertyDirectiveRequiredImpl pojoPropertyDirectiveRequired = new PojoPropertyDirectiveRequiredImpl();
    return pojoPropertyDirectiveRequired;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PojoPropertyDirectivePrimaryKey createPojoPropertyDirectivePrimaryKey()
  {
    PojoPropertyDirectivePrimaryKeyImpl pojoPropertyDirectivePrimaryKey = new PojoPropertyDirectivePrimaryKeyImpl();
    return pojoPropertyDirectivePrimaryKey;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PojoPropertyDirectiveDiscriminator createPojoPropertyDirectiveDiscriminator()
  {
    PojoPropertyDirectiveDiscriminatorImpl pojoPropertyDirectiveDiscriminator = new PojoPropertyDirectiveDiscriminatorImpl();
    return pojoPropertyDirectiveDiscriminator;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PojoPropertyDirectiveIndex createPojoPropertyDirectiveIndex()
  {
    PojoPropertyDirectiveIndexImpl pojoPropertyDirectiveIndex = new PojoPropertyDirectiveIndexImpl();
    return pojoPropertyDirectiveIndex;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PojoPropertyDirectiveVersion createPojoPropertyDirectiveVersion()
  {
    PojoPropertyDirectiveVersionImpl pojoPropertyDirectiveVersion = new PojoPropertyDirectiveVersionImpl();
    return pojoPropertyDirectiveVersion;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PojoPropertyDirectiveUpdateCol createPojoPropertyDirectiveUpdateCol()
  {
    PojoPropertyDirectiveUpdateColImpl pojoPropertyDirectiveUpdateCol = new PojoPropertyDirectiveUpdateColImpl();
    return pojoPropertyDirectiveUpdateCol;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PojoPropertyDirectiveCreateCol createPojoPropertyDirectiveCreateCol()
  {
    PojoPropertyDirectiveCreateColImpl pojoPropertyDirectiveCreateCol = new PojoPropertyDirectiveCreateColImpl();
    return pojoPropertyDirectiveCreateCol;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EnumDirectiveFinal createEnumDirectiveFinal()
  {
    EnumDirectiveFinalImpl enumDirectiveFinal = new EnumDirectiveFinalImpl();
    return enumDirectiveFinal;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EnumDirectiveExtends createEnumDirectiveExtends()
  {
    EnumDirectiveExtendsImpl enumDirectiveExtends = new EnumDirectiveExtendsImpl();
    return enumDirectiveExtends;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EnumDirectiveSerializable createEnumDirectiveSerializable()
  {
    EnumDirectiveSerializableImpl enumDirectiveSerializable = new EnumDirectiveSerializableImpl();
    return enumDirectiveSerializable;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EnumPropertyDirectiveValues createEnumPropertyDirectiveValues()
  {
    EnumPropertyDirectiveValuesImpl enumPropertyDirectiveValues = new EnumPropertyDirectiveValuesImpl();
    return enumPropertyDirectiveValues;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DaoDirectiveFinal createDaoDirectiveFinal()
  {
    DaoDirectiveFinalImpl daoDirectiveFinal = new DaoDirectiveFinalImpl();
    return daoDirectiveFinal;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DaoDirectiveAbstract createDaoDirectiveAbstract()
  {
    DaoDirectiveAbstractImpl daoDirectiveAbstract = new DaoDirectiveAbstractImpl();
    return daoDirectiveAbstract;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DaoDirectiveExtends createDaoDirectiveExtends()
  {
    DaoDirectiveExtendsImpl daoDirectiveExtends = new DaoDirectiveExtendsImpl();
    return daoDirectiveExtends;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DaoDirectiveDiscriminator createDaoDirectiveDiscriminator()
  {
    DaoDirectiveDiscriminatorImpl daoDirectiveDiscriminator = new DaoDirectiveDiscriminatorImpl();
    return daoDirectiveDiscriminator;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DaoDirectiveSerializable createDaoDirectiveSerializable()
  {
    DaoDirectiveSerializableImpl daoDirectiveSerializable = new DaoDirectiveSerializableImpl();
    return daoDirectiveSerializable;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DaoDirectivePojo createDaoDirectivePojo()
  {
    DaoDirectivePojoImpl daoDirectivePojo = new DaoDirectivePojoImpl();
    return daoDirectivePojo;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DaoDirectiveGenerics createDaoDirectiveGenerics()
  {
    DaoDirectiveGenericsImpl daoDirectiveGenerics = new DaoDirectiveGenericsImpl();
    return daoDirectiveGenerics;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DaoDirectiveProcedure createDaoDirectiveProcedure()
  {
    DaoDirectiveProcedureImpl daoDirectiveProcedure = new DaoDirectiveProcedureImpl();
    return daoDirectiveProcedure;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DaoDirectiveFunction createDaoDirectiveFunction()
  {
    DaoDirectiveFunctionImpl daoDirectiveFunction = new DaoDirectiveFunctionImpl();
    return daoDirectiveFunction;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DaoDirectiveUpdate createDaoDirectiveUpdate()
  {
    DaoDirectiveUpdateImpl daoDirectiveUpdate = new DaoDirectiveUpdateImpl();
    return daoDirectiveUpdate;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ProcessorDslPackage getProcessorDslPackage()
  {
    return (ProcessorDslPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static ProcessorDslPackage getPackage()
  {
    return ProcessorDslPackage.eINSTANCE;
  }

} //ProcessorDslFactoryImpl
