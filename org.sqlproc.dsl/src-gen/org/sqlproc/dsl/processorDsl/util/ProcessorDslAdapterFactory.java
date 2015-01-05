/**
 */
package org.sqlproc.dsl.processorDsl.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.sqlproc.dsl.processorDsl.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.sqlproc.dsl.processorDsl.ProcessorDslPackage
 * @generated
 */
public class ProcessorDslAdapterFactory extends AdapterFactoryImpl
{
  /**
   * The cached model package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static ProcessorDslPackage modelPackage;

  /**
   * Creates an instance of the adapter factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ProcessorDslAdapterFactory()
  {
    if (modelPackage == null)
    {
      modelPackage = ProcessorDslPackage.eINSTANCE;
    }
  }

  /**
   * Returns whether this factory is applicable for the type of the object.
   * <!-- begin-user-doc -->
   * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
   * <!-- end-user-doc -->
   * @return whether this factory is applicable for the type of the object.
   * @generated
   */
  @Override
  public boolean isFactoryForType(Object object)
  {
    if (object == modelPackage)
    {
      return true;
    }
    if (object instanceof EObject)
    {
      return ((EObject)object).eClass().getEPackage() == modelPackage;
    }
    return false;
  }

  /**
   * The switch that delegates to the <code>createXXX</code> methods.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ProcessorDslSwitch<Adapter> modelSwitch =
    new ProcessorDslSwitch<Adapter>()
    {
      @Override
      public Adapter caseArtifacts(Artifacts object)
      {
        return createArtifactsAdapter();
      }
      @Override
      public Adapter caseDatabaseCatalogAssignement(DatabaseCatalogAssignement object)
      {
        return createDatabaseCatalogAssignementAdapter();
      }
      @Override
      public Adapter caseDatabaseSchemaAssignement(DatabaseSchemaAssignement object)
      {
        return createDatabaseSchemaAssignementAdapter();
      }
      @Override
      public Adapter caseDatabaseTypeAssignement(DatabaseTypeAssignement object)
      {
        return createDatabaseTypeAssignementAdapter();
      }
      @Override
      public Adapter caseDatabaseMetaInfoAssignement(DatabaseMetaInfoAssignement object)
      {
        return createDatabaseMetaInfoAssignementAdapter();
      }
      @Override
      public Adapter caseDriverMetaInfoAssignement(DriverMetaInfoAssignement object)
      {
        return createDriverMetaInfoAssignementAdapter();
      }
      @Override
      public Adapter caseDriverMethodOutputAssignement(DriverMethodOutputAssignement object)
      {
        return createDriverMethodOutputAssignementAdapter();
      }
      @Override
      public Adapter caseSqlTypeAssignement(SqlTypeAssignement object)
      {
        return createSqlTypeAssignementAdapter();
      }
      @Override
      public Adapter caseColumnTypeAssignement(ColumnTypeAssignement object)
      {
        return createColumnTypeAssignementAdapter();
      }
      @Override
      public Adapter caseShowColumnTypeAssignement(ShowColumnTypeAssignement object)
      {
        return createShowColumnTypeAssignementAdapter();
      }
      @Override
      public Adapter caseTableAssignement(TableAssignement object)
      {
        return createTableAssignementAdapter();
      }
      @Override
      public Adapter caseJoinTableAssignement(JoinTableAssignement object)
      {
        return createJoinTableAssignementAdapter();
      }
      @Override
      public Adapter caseColumnAssignement(ColumnAssignement object)
      {
        return createColumnAssignementAdapter();
      }
      @Override
      public Adapter caseImportAssignement(ImportAssignement object)
      {
        return createImportAssignementAdapter();
      }
      @Override
      public Adapter caseExportAssignement(ExportAssignement object)
      {
        return createExportAssignementAdapter();
      }
      @Override
      public Adapter caseInheritanceAssignement(InheritanceAssignement object)
      {
        return createInheritanceAssignementAdapter();
      }
      @Override
      public Adapter caseManyToManyAssignement(ManyToManyAssignement object)
      {
        return createManyToManyAssignementAdapter();
      }
      @Override
      public Adapter caseDebugLevelAssignement(DebugLevelAssignement object)
      {
        return createDebugLevelAssignementAdapter();
      }
      @Override
      public Adapter caseProcedurePojoAssignement(ProcedurePojoAssignement object)
      {
        return createProcedurePojoAssignementAdapter();
      }
      @Override
      public Adapter caseFunctionPojoAssignement(FunctionPojoAssignement object)
      {
        return createFunctionPojoAssignementAdapter();
      }
      @Override
      public Adapter caseImplementsAssignement(ImplementsAssignement object)
      {
        return createImplementsAssignementAdapter();
      }
      @Override
      public Adapter caseExtendsAssignement(ExtendsAssignement object)
      {
        return createExtendsAssignementAdapter();
      }
      @Override
      public Adapter caseImplementsAssignementGenerics(ImplementsAssignementGenerics object)
      {
        return createImplementsAssignementGenericsAdapter();
      }
      @Override
      public Adapter caseExtendsAssignementGenerics(ExtendsAssignementGenerics object)
      {
        return createExtendsAssignementGenericsAdapter();
      }
      @Override
      public Adapter caseProperty(Property object)
      {
        return createPropertyAdapter();
      }
      @Override
      public Adapter caseDatabaseProperty(DatabaseProperty object)
      {
        return createDatabasePropertyAdapter();
      }
      @Override
      public Adapter casePojogenProperty(PojogenProperty object)
      {
        return createPojogenPropertyAdapter();
      }
      @Override
      public Adapter caseMetaTypeAssignement(MetaTypeAssignement object)
      {
        return createMetaTypeAssignementAdapter();
      }
      @Override
      public Adapter caseMetagenProperty(MetagenProperty object)
      {
        return createMetagenPropertyAdapter();
      }
      @Override
      public Adapter caseDaogenProperty(DaogenProperty object)
      {
        return createDaogenPropertyAdapter();
      }
      @Override
      public Adapter casePojoDefinition(PojoDefinition object)
      {
        return createPojoDefinitionAdapter();
      }
      @Override
      public Adapter caseTableDefinition(TableDefinition object)
      {
        return createTableDefinitionAdapter();
      }
      @Override
      public Adapter caseProcedureDefinition(ProcedureDefinition object)
      {
        return createProcedureDefinitionAdapter();
      }
      @Override
      public Adapter caseFunctionDefinition(FunctionDefinition object)
      {
        return createFunctionDefinitionAdapter();
      }
      @Override
      public Adapter caseMetaStatement(MetaStatement object)
      {
        return createMetaStatementAdapter();
      }
      @Override
      public Adapter caseSql(Sql object)
      {
        return createSqlAdapter();
      }
      @Override
      public Adapter caseSqlFragment(SqlFragment object)
      {
        return createSqlFragmentAdapter();
      }
      @Override
      public Adapter caseMetaSql(MetaSql object)
      {
        return createMetaSqlAdapter();
      }
      @Override
      public Adapter caseIfSql(IfSql object)
      {
        return createIfSqlAdapter();
      }
      @Override
      public Adapter caseIfSqlFragment(IfSqlFragment object)
      {
        return createIfSqlFragmentAdapter();
      }
      @Override
      public Adapter caseIfMetaSql(IfMetaSql object)
      {
        return createIfMetaSqlAdapter();
      }
      @Override
      public Adapter caseIfSqlCond(IfSqlCond object)
      {
        return createIfSqlCondAdapter();
      }
      @Override
      public Adapter caseIfSqlBool(IfSqlBool object)
      {
        return createIfSqlBoolAdapter();
      }
      @Override
      public Adapter caseOrdSql(OrdSql object)
      {
        return createOrdSqlAdapter();
      }
      @Override
      public Adapter caseOrdSql2(OrdSql2 object)
      {
        return createOrdSql2Adapter();
      }
      @Override
      public Adapter caseColumn(Column object)
      {
        return createColumnAdapter();
      }
      @Override
      public Adapter caseExtendedColumn(ExtendedColumn object)
      {
        return createExtendedColumnAdapter();
      }
      @Override
      public Adapter caseExtendedColumnName(ExtendedColumnName object)
      {
        return createExtendedColumnNameAdapter();
      }
      @Override
      public Adapter caseConstant(Constant object)
      {
        return createConstantAdapter();
      }
      @Override
      public Adapter caseIdentifier(Identifier object)
      {
        return createIdentifierAdapter();
      }
      @Override
      public Adapter caseConstantOperator(ConstantOperator object)
      {
        return createConstantOperatorAdapter();
      }
      @Override
      public Adapter caseIdentifierOperator(IdentifierOperator object)
      {
        return createIdentifierOperatorAdapter();
      }
      @Override
      public Adapter caseDatabaseColumn(DatabaseColumn object)
      {
        return createDatabaseColumnAdapter();
      }
      @Override
      public Adapter caseDatabaseTable(DatabaseTable object)
      {
        return createDatabaseTableAdapter();
      }
      @Override
      public Adapter caseMappingRule(MappingRule object)
      {
        return createMappingRuleAdapter();
      }
      @Override
      public Adapter caseMapping(Mapping object)
      {
        return createMappingAdapter();
      }
      @Override
      public Adapter caseMappingItem(MappingItem object)
      {
        return createMappingItemAdapter();
      }
      @Override
      public Adapter caseMappingColumn(MappingColumn object)
      {
        return createMappingColumnAdapter();
      }
      @Override
      public Adapter caseExtendedMappingItem(ExtendedMappingItem object)
      {
        return createExtendedMappingItemAdapter();
      }
      @Override
      public Adapter caseMappingColumnName(MappingColumnName object)
      {
        return createMappingColumnNameAdapter();
      }
      @Override
      public Adapter caseOptionalFeature(OptionalFeature object)
      {
        return createOptionalFeatureAdapter();
      }
      @Override
      public Adapter casePackageDirective(PackageDirective object)
      {
        return createPackageDirectiveAdapter();
      }
      @Override
      public Adapter casePackageDeclaration(PackageDeclaration object)
      {
        return createPackageDeclarationAdapter();
      }
      @Override
      public Adapter caseEntity(Entity object)
      {
        return createEntityAdapter();
      }
      @Override
      public Adapter caseAbstractEntity(AbstractEntity object)
      {
        return createAbstractEntityAdapter();
      }
      @Override
      public Adapter casePojoType(PojoType object)
      {
        return createPojoTypeAdapter();
      }
      @Override
      public Adapter caseDaoType(DaoType object)
      {
        return createDaoTypeAdapter();
      }
      @Override
      public Adapter caseImport(Import object)
      {
        return createImportAdapter();
      }
      @Override
      public Adapter caseImplements(Implements object)
      {
        return createImplementsAdapter();
      }
      @Override
      public Adapter caseExtends(Extends object)
      {
        return createExtendsAdapter();
      }
      @Override
      public Adapter caseImplPackage(ImplPackage object)
      {
        return createImplPackageAdapter();
      }
      @Override
      public Adapter caseAnnotationProperty(AnnotationProperty object)
      {
        return createAnnotationPropertyAdapter();
      }
      @Override
      public Adapter caseAnnotation(Annotation object)
      {
        return createAnnotationAdapter();
      }
      @Override
      public Adapter caseEntityAnnotation(EntityAnnotation object)
      {
        return createEntityAnnotationAdapter();
      }
      @Override
      public Adapter caseDirectiveProperties(DirectiveProperties object)
      {
        return createDirectivePropertiesAdapter();
      }
      @Override
      public Adapter casePojoDirective(PojoDirective object)
      {
        return createPojoDirectiveAdapter();
      }
      @Override
      public Adapter casePojoEntity(PojoEntity object)
      {
        return createPojoEntityAdapter();
      }
      @Override
      public Adapter casePojoPropertyAnnotation(PojoPropertyAnnotation object)
      {
        return createPojoPropertyAnnotationAdapter();
      }
      @Override
      public Adapter casePojoPropertyDirective(PojoPropertyDirective object)
      {
        return createPojoPropertyDirectiveAdapter();
      }
      @Override
      public Adapter casePojoProperty(PojoProperty object)
      {
        return createPojoPropertyAdapter();
      }
      @Override
      public Adapter caseEnumDirective(EnumDirective object)
      {
        return createEnumDirectiveAdapter();
      }
      @Override
      public Adapter caseEnumEntity(EnumEntity object)
      {
        return createEnumEntityAdapter();
      }
      @Override
      public Adapter caseEnumPropertyValue(EnumPropertyValue object)
      {
        return createEnumPropertyValueAdapter();
      }
      @Override
      public Adapter caseEnumPropertyDirective(EnumPropertyDirective object)
      {
        return createEnumPropertyDirectiveAdapter();
      }
      @Override
      public Adapter caseEnumProperty(EnumProperty object)
      {
        return createEnumPropertyAdapter();
      }
      @Override
      public Adapter caseDirectiveParameters(DirectiveParameters object)
      {
        return createDirectiveParametersAdapter();
      }
      @Override
      public Adapter caseDaoDirective(DaoDirective object)
      {
        return createDaoDirectiveAdapter();
      }
      @Override
      public Adapter casePojoDao(PojoDao object)
      {
        return createPojoDaoAdapter();
      }
      @Override
      public Adapter casePackageDirectiveSuffix(PackageDirectiveSuffix object)
      {
        return createPackageDirectiveSuffixAdapter();
      }
      @Override
      public Adapter caseConflictAnnotation(ConflictAnnotation object)
      {
        return createConflictAnnotationAdapter();
      }
      @Override
      public Adapter caseStaticAnnotation(StaticAnnotation object)
      {
        return createStaticAnnotationAdapter();
      }
      @Override
      public Adapter caseConstructorAnnotation(ConstructorAnnotation object)
      {
        return createConstructorAnnotationAdapter();
      }
      @Override
      public Adapter caseStandardAnnotation(StandardAnnotation object)
      {
        return createStandardAnnotationAdapter();
      }
      @Override
      public Adapter casePojoDirectiveFinal(PojoDirectiveFinal object)
      {
        return createPojoDirectiveFinalAdapter();
      }
      @Override
      public Adapter casePojoDirectiveAbstract(PojoDirectiveAbstract object)
      {
        return createPojoDirectiveAbstractAdapter();
      }
      @Override
      public Adapter casePojoDirectiveExtends(PojoDirectiveExtends object)
      {
        return createPojoDirectiveExtendsAdapter();
      }
      @Override
      public Adapter casePojoDirectiveDiscriminator(PojoDirectiveDiscriminator object)
      {
        return createPojoDirectiveDiscriminatorAdapter();
      }
      @Override
      public Adapter casePojoDirectiveOperators(PojoDirectiveOperators object)
      {
        return createPojoDirectiveOperatorsAdapter();
      }
      @Override
      public Adapter casePojoDirectiveSerializable(PojoDirectiveSerializable object)
      {
        return createPojoDirectiveSerializableAdapter();
      }
      @Override
      public Adapter casePojoDirectiveEquals(PojoDirectiveEquals object)
      {
        return createPojoDirectiveEqualsAdapter();
      }
      @Override
      public Adapter casePojoDirectiveHashCode(PojoDirectiveHashCode object)
      {
        return createPojoDirectiveHashCodeAdapter();
      }
      @Override
      public Adapter casePojoDirectiveToInit(PojoDirectiveToInit object)
      {
        return createPojoDirectiveToInitAdapter();
      }
      @Override
      public Adapter casePojoDirectiveEnumInit(PojoDirectiveEnumInit object)
      {
        return createPojoDirectiveEnumInitAdapter();
      }
      @Override
      public Adapter casePojoDirectiveIsDef(PojoDirectiveIsDef object)
      {
        return createPojoDirectiveIsDefAdapter();
      }
      @Override
      public Adapter casePojoDirectiveEnumDef(PojoDirectiveEnumDef object)
      {
        return createPojoDirectiveEnumDefAdapter();
      }
      @Override
      public Adapter casePojoDirectiveToString(PojoDirectiveToString object)
      {
        return createPojoDirectiveToStringAdapter();
      }
      @Override
      public Adapter casePojoDirectiveIndex(PojoDirectiveIndex object)
      {
        return createPojoDirectiveIndexAdapter();
      }
      @Override
      public Adapter caseSetterAnnotation(SetterAnnotation object)
      {
        return createSetterAnnotationAdapter();
      }
      @Override
      public Adapter caseGetterAnnotation(GetterAnnotation object)
      {
        return createGetterAnnotationAdapter();
      }
      @Override
      public Adapter caseAttributeAnnotation(AttributeAnnotation object)
      {
        return createAttributeAnnotationAdapter();
      }
      @Override
      public Adapter casePojoPropertyDirectiveRequired(PojoPropertyDirectiveRequired object)
      {
        return createPojoPropertyDirectiveRequiredAdapter();
      }
      @Override
      public Adapter casePojoPropertyDirectivePrimaryKey(PojoPropertyDirectivePrimaryKey object)
      {
        return createPojoPropertyDirectivePrimaryKeyAdapter();
      }
      @Override
      public Adapter casePojoPropertyDirectiveDiscriminator(PojoPropertyDirectiveDiscriminator object)
      {
        return createPojoPropertyDirectiveDiscriminatorAdapter();
      }
      @Override
      public Adapter casePojoPropertyDirectiveIndex(PojoPropertyDirectiveIndex object)
      {
        return createPojoPropertyDirectiveIndexAdapter();
      }
      @Override
      public Adapter casePojoPropertyDirectiveVersion(PojoPropertyDirectiveVersion object)
      {
        return createPojoPropertyDirectiveVersionAdapter();
      }
      @Override
      public Adapter casePojoPropertyDirectiveUpdateCol(PojoPropertyDirectiveUpdateCol object)
      {
        return createPojoPropertyDirectiveUpdateColAdapter();
      }
      @Override
      public Adapter casePojoPropertyDirectiveCreateCol(PojoPropertyDirectiveCreateCol object)
      {
        return createPojoPropertyDirectiveCreateColAdapter();
      }
      @Override
      public Adapter caseEnumDirectiveFinal(EnumDirectiveFinal object)
      {
        return createEnumDirectiveFinalAdapter();
      }
      @Override
      public Adapter caseEnumDirectiveExtends(EnumDirectiveExtends object)
      {
        return createEnumDirectiveExtendsAdapter();
      }
      @Override
      public Adapter caseEnumDirectiveSerializable(EnumDirectiveSerializable object)
      {
        return createEnumDirectiveSerializableAdapter();
      }
      @Override
      public Adapter caseEnumPropertyDirectiveValues(EnumPropertyDirectiveValues object)
      {
        return createEnumPropertyDirectiveValuesAdapter();
      }
      @Override
      public Adapter caseDaoDirectiveFinal(DaoDirectiveFinal object)
      {
        return createDaoDirectiveFinalAdapter();
      }
      @Override
      public Adapter caseDaoDirectiveAbstract(DaoDirectiveAbstract object)
      {
        return createDaoDirectiveAbstractAdapter();
      }
      @Override
      public Adapter caseDaoDirectiveExtends(DaoDirectiveExtends object)
      {
        return createDaoDirectiveExtendsAdapter();
      }
      @Override
      public Adapter caseDaoDirectiveDiscriminator(DaoDirectiveDiscriminator object)
      {
        return createDaoDirectiveDiscriminatorAdapter();
      }
      @Override
      public Adapter caseDaoDirectiveSerializable(DaoDirectiveSerializable object)
      {
        return createDaoDirectiveSerializableAdapter();
      }
      @Override
      public Adapter caseDaoDirectivePojo(DaoDirectivePojo object)
      {
        return createDaoDirectivePojoAdapter();
      }
      @Override
      public Adapter caseDaoDirectiveGenerics(DaoDirectiveGenerics object)
      {
        return createDaoDirectiveGenericsAdapter();
      }
      @Override
      public Adapter caseDaoDirectiveProcedure(DaoDirectiveProcedure object)
      {
        return createDaoDirectiveProcedureAdapter();
      }
      @Override
      public Adapter caseDaoDirectiveFunction(DaoDirectiveFunction object)
      {
        return createDaoDirectiveFunctionAdapter();
      }
      @Override
      public Adapter caseDaoDirectiveUpdate(DaoDirectiveUpdate object)
      {
        return createDaoDirectiveUpdateAdapter();
      }
      @Override
      public Adapter defaultCase(EObject object)
      {
        return createEObjectAdapter();
      }
    };

  /**
   * Creates an adapter for the <code>target</code>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param target the object to adapt.
   * @return the adapter for the <code>target</code>.
   * @generated
   */
  @Override
  public Adapter createAdapter(Notifier target)
  {
    return modelSwitch.doSwitch((EObject)target);
  }


  /**
   * Creates a new adapter for an object of class '{@link org.sqlproc.dsl.processorDsl.Artifacts <em>Artifacts</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.sqlproc.dsl.processorDsl.Artifacts
   * @generated
   */
  public Adapter createArtifactsAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.sqlproc.dsl.processorDsl.DatabaseCatalogAssignement <em>Database Catalog Assignement</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.sqlproc.dsl.processorDsl.DatabaseCatalogAssignement
   * @generated
   */
  public Adapter createDatabaseCatalogAssignementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.sqlproc.dsl.processorDsl.DatabaseSchemaAssignement <em>Database Schema Assignement</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.sqlproc.dsl.processorDsl.DatabaseSchemaAssignement
   * @generated
   */
  public Adapter createDatabaseSchemaAssignementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.sqlproc.dsl.processorDsl.DatabaseTypeAssignement <em>Database Type Assignement</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.sqlproc.dsl.processorDsl.DatabaseTypeAssignement
   * @generated
   */
  public Adapter createDatabaseTypeAssignementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.sqlproc.dsl.processorDsl.DatabaseMetaInfoAssignement <em>Database Meta Info Assignement</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.sqlproc.dsl.processorDsl.DatabaseMetaInfoAssignement
   * @generated
   */
  public Adapter createDatabaseMetaInfoAssignementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.sqlproc.dsl.processorDsl.DriverMetaInfoAssignement <em>Driver Meta Info Assignement</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.sqlproc.dsl.processorDsl.DriverMetaInfoAssignement
   * @generated
   */
  public Adapter createDriverMetaInfoAssignementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.sqlproc.dsl.processorDsl.DriverMethodOutputAssignement <em>Driver Method Output Assignement</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.sqlproc.dsl.processorDsl.DriverMethodOutputAssignement
   * @generated
   */
  public Adapter createDriverMethodOutputAssignementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.sqlproc.dsl.processorDsl.SqlTypeAssignement <em>Sql Type Assignement</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.sqlproc.dsl.processorDsl.SqlTypeAssignement
   * @generated
   */
  public Adapter createSqlTypeAssignementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.sqlproc.dsl.processorDsl.ColumnTypeAssignement <em>Column Type Assignement</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.sqlproc.dsl.processorDsl.ColumnTypeAssignement
   * @generated
   */
  public Adapter createColumnTypeAssignementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.sqlproc.dsl.processorDsl.ShowColumnTypeAssignement <em>Show Column Type Assignement</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.sqlproc.dsl.processorDsl.ShowColumnTypeAssignement
   * @generated
   */
  public Adapter createShowColumnTypeAssignementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.sqlproc.dsl.processorDsl.TableAssignement <em>Table Assignement</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.sqlproc.dsl.processorDsl.TableAssignement
   * @generated
   */
  public Adapter createTableAssignementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.sqlproc.dsl.processorDsl.JoinTableAssignement <em>Join Table Assignement</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.sqlproc.dsl.processorDsl.JoinTableAssignement
   * @generated
   */
  public Adapter createJoinTableAssignementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.sqlproc.dsl.processorDsl.ColumnAssignement <em>Column Assignement</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.sqlproc.dsl.processorDsl.ColumnAssignement
   * @generated
   */
  public Adapter createColumnAssignementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.sqlproc.dsl.processorDsl.ImportAssignement <em>Import Assignement</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.sqlproc.dsl.processorDsl.ImportAssignement
   * @generated
   */
  public Adapter createImportAssignementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.sqlproc.dsl.processorDsl.ExportAssignement <em>Export Assignement</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.sqlproc.dsl.processorDsl.ExportAssignement
   * @generated
   */
  public Adapter createExportAssignementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.sqlproc.dsl.processorDsl.InheritanceAssignement <em>Inheritance Assignement</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.sqlproc.dsl.processorDsl.InheritanceAssignement
   * @generated
   */
  public Adapter createInheritanceAssignementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.sqlproc.dsl.processorDsl.ManyToManyAssignement <em>Many To Many Assignement</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.sqlproc.dsl.processorDsl.ManyToManyAssignement
   * @generated
   */
  public Adapter createManyToManyAssignementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.sqlproc.dsl.processorDsl.DebugLevelAssignement <em>Debug Level Assignement</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.sqlproc.dsl.processorDsl.DebugLevelAssignement
   * @generated
   */
  public Adapter createDebugLevelAssignementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.sqlproc.dsl.processorDsl.ProcedurePojoAssignement <em>Procedure Pojo Assignement</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.sqlproc.dsl.processorDsl.ProcedurePojoAssignement
   * @generated
   */
  public Adapter createProcedurePojoAssignementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.sqlproc.dsl.processorDsl.FunctionPojoAssignement <em>Function Pojo Assignement</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.sqlproc.dsl.processorDsl.FunctionPojoAssignement
   * @generated
   */
  public Adapter createFunctionPojoAssignementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.sqlproc.dsl.processorDsl.ImplementsAssignement <em>Implements Assignement</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.sqlproc.dsl.processorDsl.ImplementsAssignement
   * @generated
   */
  public Adapter createImplementsAssignementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.sqlproc.dsl.processorDsl.ExtendsAssignement <em>Extends Assignement</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.sqlproc.dsl.processorDsl.ExtendsAssignement
   * @generated
   */
  public Adapter createExtendsAssignementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.sqlproc.dsl.processorDsl.ImplementsAssignementGenerics <em>Implements Assignement Generics</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.sqlproc.dsl.processorDsl.ImplementsAssignementGenerics
   * @generated
   */
  public Adapter createImplementsAssignementGenericsAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.sqlproc.dsl.processorDsl.ExtendsAssignementGenerics <em>Extends Assignement Generics</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.sqlproc.dsl.processorDsl.ExtendsAssignementGenerics
   * @generated
   */
  public Adapter createExtendsAssignementGenericsAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.sqlproc.dsl.processorDsl.Property <em>Property</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.sqlproc.dsl.processorDsl.Property
   * @generated
   */
  public Adapter createPropertyAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.sqlproc.dsl.processorDsl.DatabaseProperty <em>Database Property</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.sqlproc.dsl.processorDsl.DatabaseProperty
   * @generated
   */
  public Adapter createDatabasePropertyAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.sqlproc.dsl.processorDsl.PojogenProperty <em>Pojogen Property</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.sqlproc.dsl.processorDsl.PojogenProperty
   * @generated
   */
  public Adapter createPojogenPropertyAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.sqlproc.dsl.processorDsl.MetaTypeAssignement <em>Meta Type Assignement</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.sqlproc.dsl.processorDsl.MetaTypeAssignement
   * @generated
   */
  public Adapter createMetaTypeAssignementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.sqlproc.dsl.processorDsl.MetagenProperty <em>Metagen Property</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.sqlproc.dsl.processorDsl.MetagenProperty
   * @generated
   */
  public Adapter createMetagenPropertyAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.sqlproc.dsl.processorDsl.DaogenProperty <em>Daogen Property</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.sqlproc.dsl.processorDsl.DaogenProperty
   * @generated
   */
  public Adapter createDaogenPropertyAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.sqlproc.dsl.processorDsl.PojoDefinition <em>Pojo Definition</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.sqlproc.dsl.processorDsl.PojoDefinition
   * @generated
   */
  public Adapter createPojoDefinitionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.sqlproc.dsl.processorDsl.TableDefinition <em>Table Definition</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.sqlproc.dsl.processorDsl.TableDefinition
   * @generated
   */
  public Adapter createTableDefinitionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.sqlproc.dsl.processorDsl.ProcedureDefinition <em>Procedure Definition</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.sqlproc.dsl.processorDsl.ProcedureDefinition
   * @generated
   */
  public Adapter createProcedureDefinitionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.sqlproc.dsl.processorDsl.FunctionDefinition <em>Function Definition</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.sqlproc.dsl.processorDsl.FunctionDefinition
   * @generated
   */
  public Adapter createFunctionDefinitionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.sqlproc.dsl.processorDsl.MetaStatement <em>Meta Statement</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.sqlproc.dsl.processorDsl.MetaStatement
   * @generated
   */
  public Adapter createMetaStatementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.sqlproc.dsl.processorDsl.Sql <em>Sql</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.sqlproc.dsl.processorDsl.Sql
   * @generated
   */
  public Adapter createSqlAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.sqlproc.dsl.processorDsl.SqlFragment <em>Sql Fragment</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.sqlproc.dsl.processorDsl.SqlFragment
   * @generated
   */
  public Adapter createSqlFragmentAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.sqlproc.dsl.processorDsl.MetaSql <em>Meta Sql</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.sqlproc.dsl.processorDsl.MetaSql
   * @generated
   */
  public Adapter createMetaSqlAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.sqlproc.dsl.processorDsl.IfSql <em>If Sql</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.sqlproc.dsl.processorDsl.IfSql
   * @generated
   */
  public Adapter createIfSqlAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.sqlproc.dsl.processorDsl.IfSqlFragment <em>If Sql Fragment</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.sqlproc.dsl.processorDsl.IfSqlFragment
   * @generated
   */
  public Adapter createIfSqlFragmentAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.sqlproc.dsl.processorDsl.IfMetaSql <em>If Meta Sql</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.sqlproc.dsl.processorDsl.IfMetaSql
   * @generated
   */
  public Adapter createIfMetaSqlAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.sqlproc.dsl.processorDsl.IfSqlCond <em>If Sql Cond</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.sqlproc.dsl.processorDsl.IfSqlCond
   * @generated
   */
  public Adapter createIfSqlCondAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.sqlproc.dsl.processorDsl.IfSqlBool <em>If Sql Bool</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.sqlproc.dsl.processorDsl.IfSqlBool
   * @generated
   */
  public Adapter createIfSqlBoolAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.sqlproc.dsl.processorDsl.OrdSql <em>Ord Sql</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.sqlproc.dsl.processorDsl.OrdSql
   * @generated
   */
  public Adapter createOrdSqlAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.sqlproc.dsl.processorDsl.OrdSql2 <em>Ord Sql2</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.sqlproc.dsl.processorDsl.OrdSql2
   * @generated
   */
  public Adapter createOrdSql2Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.sqlproc.dsl.processorDsl.Column <em>Column</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.sqlproc.dsl.processorDsl.Column
   * @generated
   */
  public Adapter createColumnAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.sqlproc.dsl.processorDsl.ExtendedColumn <em>Extended Column</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.sqlproc.dsl.processorDsl.ExtendedColumn
   * @generated
   */
  public Adapter createExtendedColumnAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.sqlproc.dsl.processorDsl.ExtendedColumnName <em>Extended Column Name</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.sqlproc.dsl.processorDsl.ExtendedColumnName
   * @generated
   */
  public Adapter createExtendedColumnNameAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.sqlproc.dsl.processorDsl.Constant <em>Constant</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.sqlproc.dsl.processorDsl.Constant
   * @generated
   */
  public Adapter createConstantAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.sqlproc.dsl.processorDsl.Identifier <em>Identifier</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.sqlproc.dsl.processorDsl.Identifier
   * @generated
   */
  public Adapter createIdentifierAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.sqlproc.dsl.processorDsl.ConstantOperator <em>Constant Operator</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.sqlproc.dsl.processorDsl.ConstantOperator
   * @generated
   */
  public Adapter createConstantOperatorAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.sqlproc.dsl.processorDsl.IdentifierOperator <em>Identifier Operator</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.sqlproc.dsl.processorDsl.IdentifierOperator
   * @generated
   */
  public Adapter createIdentifierOperatorAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.sqlproc.dsl.processorDsl.DatabaseColumn <em>Database Column</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.sqlproc.dsl.processorDsl.DatabaseColumn
   * @generated
   */
  public Adapter createDatabaseColumnAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.sqlproc.dsl.processorDsl.DatabaseTable <em>Database Table</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.sqlproc.dsl.processorDsl.DatabaseTable
   * @generated
   */
  public Adapter createDatabaseTableAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.sqlproc.dsl.processorDsl.MappingRule <em>Mapping Rule</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.sqlproc.dsl.processorDsl.MappingRule
   * @generated
   */
  public Adapter createMappingRuleAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.sqlproc.dsl.processorDsl.Mapping <em>Mapping</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.sqlproc.dsl.processorDsl.Mapping
   * @generated
   */
  public Adapter createMappingAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.sqlproc.dsl.processorDsl.MappingItem <em>Mapping Item</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.sqlproc.dsl.processorDsl.MappingItem
   * @generated
   */
  public Adapter createMappingItemAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.sqlproc.dsl.processorDsl.MappingColumn <em>Mapping Column</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.sqlproc.dsl.processorDsl.MappingColumn
   * @generated
   */
  public Adapter createMappingColumnAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.sqlproc.dsl.processorDsl.ExtendedMappingItem <em>Extended Mapping Item</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.sqlproc.dsl.processorDsl.ExtendedMappingItem
   * @generated
   */
  public Adapter createExtendedMappingItemAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.sqlproc.dsl.processorDsl.MappingColumnName <em>Mapping Column Name</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.sqlproc.dsl.processorDsl.MappingColumnName
   * @generated
   */
  public Adapter createMappingColumnNameAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.sqlproc.dsl.processorDsl.OptionalFeature <em>Optional Feature</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.sqlproc.dsl.processorDsl.OptionalFeature
   * @generated
   */
  public Adapter createOptionalFeatureAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.sqlproc.dsl.processorDsl.PackageDirective <em>Package Directive</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.sqlproc.dsl.processorDsl.PackageDirective
   * @generated
   */
  public Adapter createPackageDirectiveAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.sqlproc.dsl.processorDsl.PackageDeclaration <em>Package Declaration</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.sqlproc.dsl.processorDsl.PackageDeclaration
   * @generated
   */
  public Adapter createPackageDeclarationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.sqlproc.dsl.processorDsl.Entity <em>Entity</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.sqlproc.dsl.processorDsl.Entity
   * @generated
   */
  public Adapter createEntityAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.sqlproc.dsl.processorDsl.AbstractEntity <em>Abstract Entity</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.sqlproc.dsl.processorDsl.AbstractEntity
   * @generated
   */
  public Adapter createAbstractEntityAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.sqlproc.dsl.processorDsl.PojoType <em>Pojo Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.sqlproc.dsl.processorDsl.PojoType
   * @generated
   */
  public Adapter createPojoTypeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.sqlproc.dsl.processorDsl.DaoType <em>Dao Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.sqlproc.dsl.processorDsl.DaoType
   * @generated
   */
  public Adapter createDaoTypeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.sqlproc.dsl.processorDsl.Import <em>Import</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.sqlproc.dsl.processorDsl.Import
   * @generated
   */
  public Adapter createImportAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.sqlproc.dsl.processorDsl.Implements <em>Implements</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.sqlproc.dsl.processorDsl.Implements
   * @generated
   */
  public Adapter createImplementsAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.sqlproc.dsl.processorDsl.Extends <em>Extends</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.sqlproc.dsl.processorDsl.Extends
   * @generated
   */
  public Adapter createExtendsAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.sqlproc.dsl.processorDsl.ImplPackage <em>Impl Package</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.sqlproc.dsl.processorDsl.ImplPackage
   * @generated
   */
  public Adapter createImplPackageAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.sqlproc.dsl.processorDsl.AnnotationProperty <em>Annotation Property</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.sqlproc.dsl.processorDsl.AnnotationProperty
   * @generated
   */
  public Adapter createAnnotationPropertyAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.sqlproc.dsl.processorDsl.Annotation <em>Annotation</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.sqlproc.dsl.processorDsl.Annotation
   * @generated
   */
  public Adapter createAnnotationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.sqlproc.dsl.processorDsl.EntityAnnotation <em>Entity Annotation</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.sqlproc.dsl.processorDsl.EntityAnnotation
   * @generated
   */
  public Adapter createEntityAnnotationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.sqlproc.dsl.processorDsl.DirectiveProperties <em>Directive Properties</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.sqlproc.dsl.processorDsl.DirectiveProperties
   * @generated
   */
  public Adapter createDirectivePropertiesAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.sqlproc.dsl.processorDsl.PojoDirective <em>Pojo Directive</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.sqlproc.dsl.processorDsl.PojoDirective
   * @generated
   */
  public Adapter createPojoDirectiveAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.sqlproc.dsl.processorDsl.PojoEntity <em>Pojo Entity</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.sqlproc.dsl.processorDsl.PojoEntity
   * @generated
   */
  public Adapter createPojoEntityAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.sqlproc.dsl.processorDsl.PojoPropertyAnnotation <em>Pojo Property Annotation</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.sqlproc.dsl.processorDsl.PojoPropertyAnnotation
   * @generated
   */
  public Adapter createPojoPropertyAnnotationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.sqlproc.dsl.processorDsl.PojoPropertyDirective <em>Pojo Property Directive</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.sqlproc.dsl.processorDsl.PojoPropertyDirective
   * @generated
   */
  public Adapter createPojoPropertyDirectiveAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.sqlproc.dsl.processorDsl.PojoProperty <em>Pojo Property</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.sqlproc.dsl.processorDsl.PojoProperty
   * @generated
   */
  public Adapter createPojoPropertyAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.sqlproc.dsl.processorDsl.EnumDirective <em>Enum Directive</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.sqlproc.dsl.processorDsl.EnumDirective
   * @generated
   */
  public Adapter createEnumDirectiveAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.sqlproc.dsl.processorDsl.EnumEntity <em>Enum Entity</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.sqlproc.dsl.processorDsl.EnumEntity
   * @generated
   */
  public Adapter createEnumEntityAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.sqlproc.dsl.processorDsl.EnumPropertyValue <em>Enum Property Value</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.sqlproc.dsl.processorDsl.EnumPropertyValue
   * @generated
   */
  public Adapter createEnumPropertyValueAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.sqlproc.dsl.processorDsl.EnumPropertyDirective <em>Enum Property Directive</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.sqlproc.dsl.processorDsl.EnumPropertyDirective
   * @generated
   */
  public Adapter createEnumPropertyDirectiveAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.sqlproc.dsl.processorDsl.EnumProperty <em>Enum Property</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.sqlproc.dsl.processorDsl.EnumProperty
   * @generated
   */
  public Adapter createEnumPropertyAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.sqlproc.dsl.processorDsl.DirectiveParameters <em>Directive Parameters</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.sqlproc.dsl.processorDsl.DirectiveParameters
   * @generated
   */
  public Adapter createDirectiveParametersAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.sqlproc.dsl.processorDsl.DaoDirective <em>Dao Directive</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.sqlproc.dsl.processorDsl.DaoDirective
   * @generated
   */
  public Adapter createDaoDirectiveAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.sqlproc.dsl.processorDsl.PojoDao <em>Pojo Dao</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.sqlproc.dsl.processorDsl.PojoDao
   * @generated
   */
  public Adapter createPojoDaoAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.sqlproc.dsl.processorDsl.PackageDirectiveSuffix <em>Package Directive Suffix</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.sqlproc.dsl.processorDsl.PackageDirectiveSuffix
   * @generated
   */
  public Adapter createPackageDirectiveSuffixAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.sqlproc.dsl.processorDsl.ConflictAnnotation <em>Conflict Annotation</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.sqlproc.dsl.processorDsl.ConflictAnnotation
   * @generated
   */
  public Adapter createConflictAnnotationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.sqlproc.dsl.processorDsl.StaticAnnotation <em>Static Annotation</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.sqlproc.dsl.processorDsl.StaticAnnotation
   * @generated
   */
  public Adapter createStaticAnnotationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.sqlproc.dsl.processorDsl.ConstructorAnnotation <em>Constructor Annotation</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.sqlproc.dsl.processorDsl.ConstructorAnnotation
   * @generated
   */
  public Adapter createConstructorAnnotationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.sqlproc.dsl.processorDsl.StandardAnnotation <em>Standard Annotation</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.sqlproc.dsl.processorDsl.StandardAnnotation
   * @generated
   */
  public Adapter createStandardAnnotationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.sqlproc.dsl.processorDsl.PojoDirectiveFinal <em>Pojo Directive Final</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.sqlproc.dsl.processorDsl.PojoDirectiveFinal
   * @generated
   */
  public Adapter createPojoDirectiveFinalAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.sqlproc.dsl.processorDsl.PojoDirectiveAbstract <em>Pojo Directive Abstract</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.sqlproc.dsl.processorDsl.PojoDirectiveAbstract
   * @generated
   */
  public Adapter createPojoDirectiveAbstractAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.sqlproc.dsl.processorDsl.PojoDirectiveExtends <em>Pojo Directive Extends</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.sqlproc.dsl.processorDsl.PojoDirectiveExtends
   * @generated
   */
  public Adapter createPojoDirectiveExtendsAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.sqlproc.dsl.processorDsl.PojoDirectiveDiscriminator <em>Pojo Directive Discriminator</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.sqlproc.dsl.processorDsl.PojoDirectiveDiscriminator
   * @generated
   */
  public Adapter createPojoDirectiveDiscriminatorAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.sqlproc.dsl.processorDsl.PojoDirectiveOperators <em>Pojo Directive Operators</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.sqlproc.dsl.processorDsl.PojoDirectiveOperators
   * @generated
   */
  public Adapter createPojoDirectiveOperatorsAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.sqlproc.dsl.processorDsl.PojoDirectiveSerializable <em>Pojo Directive Serializable</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.sqlproc.dsl.processorDsl.PojoDirectiveSerializable
   * @generated
   */
  public Adapter createPojoDirectiveSerializableAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.sqlproc.dsl.processorDsl.PojoDirectiveEquals <em>Pojo Directive Equals</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.sqlproc.dsl.processorDsl.PojoDirectiveEquals
   * @generated
   */
  public Adapter createPojoDirectiveEqualsAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.sqlproc.dsl.processorDsl.PojoDirectiveHashCode <em>Pojo Directive Hash Code</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.sqlproc.dsl.processorDsl.PojoDirectiveHashCode
   * @generated
   */
  public Adapter createPojoDirectiveHashCodeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.sqlproc.dsl.processorDsl.PojoDirectiveToInit <em>Pojo Directive To Init</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.sqlproc.dsl.processorDsl.PojoDirectiveToInit
   * @generated
   */
  public Adapter createPojoDirectiveToInitAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.sqlproc.dsl.processorDsl.PojoDirectiveEnumInit <em>Pojo Directive Enum Init</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.sqlproc.dsl.processorDsl.PojoDirectiveEnumInit
   * @generated
   */
  public Adapter createPojoDirectiveEnumInitAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.sqlproc.dsl.processorDsl.PojoDirectiveIsDef <em>Pojo Directive Is Def</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.sqlproc.dsl.processorDsl.PojoDirectiveIsDef
   * @generated
   */
  public Adapter createPojoDirectiveIsDefAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.sqlproc.dsl.processorDsl.PojoDirectiveEnumDef <em>Pojo Directive Enum Def</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.sqlproc.dsl.processorDsl.PojoDirectiveEnumDef
   * @generated
   */
  public Adapter createPojoDirectiveEnumDefAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.sqlproc.dsl.processorDsl.PojoDirectiveToString <em>Pojo Directive To String</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.sqlproc.dsl.processorDsl.PojoDirectiveToString
   * @generated
   */
  public Adapter createPojoDirectiveToStringAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.sqlproc.dsl.processorDsl.PojoDirectiveIndex <em>Pojo Directive Index</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.sqlproc.dsl.processorDsl.PojoDirectiveIndex
   * @generated
   */
  public Adapter createPojoDirectiveIndexAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.sqlproc.dsl.processorDsl.SetterAnnotation <em>Setter Annotation</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.sqlproc.dsl.processorDsl.SetterAnnotation
   * @generated
   */
  public Adapter createSetterAnnotationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.sqlproc.dsl.processorDsl.GetterAnnotation <em>Getter Annotation</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.sqlproc.dsl.processorDsl.GetterAnnotation
   * @generated
   */
  public Adapter createGetterAnnotationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.sqlproc.dsl.processorDsl.AttributeAnnotation <em>Attribute Annotation</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.sqlproc.dsl.processorDsl.AttributeAnnotation
   * @generated
   */
  public Adapter createAttributeAnnotationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.sqlproc.dsl.processorDsl.PojoPropertyDirectiveRequired <em>Pojo Property Directive Required</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.sqlproc.dsl.processorDsl.PojoPropertyDirectiveRequired
   * @generated
   */
  public Adapter createPojoPropertyDirectiveRequiredAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.sqlproc.dsl.processorDsl.PojoPropertyDirectivePrimaryKey <em>Pojo Property Directive Primary Key</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.sqlproc.dsl.processorDsl.PojoPropertyDirectivePrimaryKey
   * @generated
   */
  public Adapter createPojoPropertyDirectivePrimaryKeyAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.sqlproc.dsl.processorDsl.PojoPropertyDirectiveDiscriminator <em>Pojo Property Directive Discriminator</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.sqlproc.dsl.processorDsl.PojoPropertyDirectiveDiscriminator
   * @generated
   */
  public Adapter createPojoPropertyDirectiveDiscriminatorAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.sqlproc.dsl.processorDsl.PojoPropertyDirectiveIndex <em>Pojo Property Directive Index</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.sqlproc.dsl.processorDsl.PojoPropertyDirectiveIndex
   * @generated
   */
  public Adapter createPojoPropertyDirectiveIndexAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.sqlproc.dsl.processorDsl.PojoPropertyDirectiveVersion <em>Pojo Property Directive Version</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.sqlproc.dsl.processorDsl.PojoPropertyDirectiveVersion
   * @generated
   */
  public Adapter createPojoPropertyDirectiveVersionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.sqlproc.dsl.processorDsl.PojoPropertyDirectiveUpdateCol <em>Pojo Property Directive Update Col</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.sqlproc.dsl.processorDsl.PojoPropertyDirectiveUpdateCol
   * @generated
   */
  public Adapter createPojoPropertyDirectiveUpdateColAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.sqlproc.dsl.processorDsl.PojoPropertyDirectiveCreateCol <em>Pojo Property Directive Create Col</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.sqlproc.dsl.processorDsl.PojoPropertyDirectiveCreateCol
   * @generated
   */
  public Adapter createPojoPropertyDirectiveCreateColAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.sqlproc.dsl.processorDsl.EnumDirectiveFinal <em>Enum Directive Final</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.sqlproc.dsl.processorDsl.EnumDirectiveFinal
   * @generated
   */
  public Adapter createEnumDirectiveFinalAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.sqlproc.dsl.processorDsl.EnumDirectiveExtends <em>Enum Directive Extends</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.sqlproc.dsl.processorDsl.EnumDirectiveExtends
   * @generated
   */
  public Adapter createEnumDirectiveExtendsAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.sqlproc.dsl.processorDsl.EnumDirectiveSerializable <em>Enum Directive Serializable</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.sqlproc.dsl.processorDsl.EnumDirectiveSerializable
   * @generated
   */
  public Adapter createEnumDirectiveSerializableAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.sqlproc.dsl.processorDsl.EnumPropertyDirectiveValues <em>Enum Property Directive Values</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.sqlproc.dsl.processorDsl.EnumPropertyDirectiveValues
   * @generated
   */
  public Adapter createEnumPropertyDirectiveValuesAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.sqlproc.dsl.processorDsl.DaoDirectiveFinal <em>Dao Directive Final</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.sqlproc.dsl.processorDsl.DaoDirectiveFinal
   * @generated
   */
  public Adapter createDaoDirectiveFinalAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.sqlproc.dsl.processorDsl.DaoDirectiveAbstract <em>Dao Directive Abstract</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.sqlproc.dsl.processorDsl.DaoDirectiveAbstract
   * @generated
   */
  public Adapter createDaoDirectiveAbstractAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.sqlproc.dsl.processorDsl.DaoDirectiveExtends <em>Dao Directive Extends</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.sqlproc.dsl.processorDsl.DaoDirectiveExtends
   * @generated
   */
  public Adapter createDaoDirectiveExtendsAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.sqlproc.dsl.processorDsl.DaoDirectiveDiscriminator <em>Dao Directive Discriminator</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.sqlproc.dsl.processorDsl.DaoDirectiveDiscriminator
   * @generated
   */
  public Adapter createDaoDirectiveDiscriminatorAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.sqlproc.dsl.processorDsl.DaoDirectiveSerializable <em>Dao Directive Serializable</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.sqlproc.dsl.processorDsl.DaoDirectiveSerializable
   * @generated
   */
  public Adapter createDaoDirectiveSerializableAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.sqlproc.dsl.processorDsl.DaoDirectivePojo <em>Dao Directive Pojo</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.sqlproc.dsl.processorDsl.DaoDirectivePojo
   * @generated
   */
  public Adapter createDaoDirectivePojoAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.sqlproc.dsl.processorDsl.DaoDirectiveGenerics <em>Dao Directive Generics</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.sqlproc.dsl.processorDsl.DaoDirectiveGenerics
   * @generated
   */
  public Adapter createDaoDirectiveGenericsAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.sqlproc.dsl.processorDsl.DaoDirectiveProcedure <em>Dao Directive Procedure</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.sqlproc.dsl.processorDsl.DaoDirectiveProcedure
   * @generated
   */
  public Adapter createDaoDirectiveProcedureAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.sqlproc.dsl.processorDsl.DaoDirectiveFunction <em>Dao Directive Function</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.sqlproc.dsl.processorDsl.DaoDirectiveFunction
   * @generated
   */
  public Adapter createDaoDirectiveFunctionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.sqlproc.dsl.processorDsl.DaoDirectiveUpdate <em>Dao Directive Update</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.sqlproc.dsl.processorDsl.DaoDirectiveUpdate
   * @generated
   */
  public Adapter createDaoDirectiveUpdateAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for the default case.
   * <!-- begin-user-doc -->
   * This default implementation returns null.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @generated
   */
  public Adapter createEObjectAdapter()
  {
    return null;
  }

} //ProcessorDslAdapterFactory
