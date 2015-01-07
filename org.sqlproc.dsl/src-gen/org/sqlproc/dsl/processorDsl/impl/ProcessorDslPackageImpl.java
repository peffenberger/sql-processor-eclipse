/**
 */
package org.sqlproc.dsl.processorDsl.impl;

import java.io.IOException;

import java.net.URL;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.emf.ecore.resource.Resource;

import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;

import org.eclipse.xtext.common.types.TypesPackage;

import org.sqlproc.dsl.processorDsl.ProcessorDslFactory;
import org.sqlproc.dsl.processorDsl.ProcessorDslPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ProcessorDslPackageImpl extends EPackageImpl implements ProcessorDslPackage
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected String packageFilename = "processorDsl.ecore";

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass artifactsEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass databaseCatalogAssignementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass databaseSchemaAssignementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass databaseTypeAssignementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass databaseMetaInfoAssignementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass driverMetaInfoAssignementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass driverMethodOutputAssignementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass sqlTypeAssignementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass columnTypeAssignementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass showColumnTypeAssignementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass tableAssignementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass joinTableAssignementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass columnAssignementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass importAssignementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass exportAssignementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass inheritanceAssignementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass manyToManyAssignementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass debugLevelAssignementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass procedurePojoAssignementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass functionPojoAssignementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass implementsAssignementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass extendsAssignementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass implementsAssignementGenericsEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass extendsAssignementGenericsEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass propertyEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass databasePropertyEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass pojogenPropertyEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass metaTypeAssignementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass metagenPropertyEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass daogenPropertyEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass pojoDefinitionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass tableDefinitionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass procedureDefinitionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass functionDefinitionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass metaStatementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass sqlEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass sqlFragmentEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass metaSqlEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass ifSqlEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass ifSqlFragmentEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass ifMetaSqlEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass ifSqlCondEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass ifSqlBoolEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass ordSqlEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass ordSql2EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass columnEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass extendedColumnEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass extendedColumnNameEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass constantEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass identifierEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass constantOperatorEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass identifierOperatorEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass databaseColumnEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass databaseTableEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass mappingRuleEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass mappingEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass mappingItemEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass mappingColumnEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass extendedMappingItemEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass mappingColumnNameEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass optionalFeatureEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass packageDirectiveEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass packageDeclarationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass entityEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass abstractEntityEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass pojoTypeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass daoTypeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass importEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass implementsEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass extendsEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass implPackageEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass annotationPropertyEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass annotationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass entityAnnotationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass directivePropertiesEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass pojoDirectiveEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass pojoEntityEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass pojoPropertyAnnotationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass pojoPropertyDirectiveEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass pojoPropertyEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass enumDirectiveEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass enumEntityEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass enumPropertyValueEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass enumPropertyDirectiveEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass enumPropertyEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass daoDirectiveParametersEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass descendantAssignmentEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass daoDirectiveEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass pojoDaoEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass packageDirectiveSuffixEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass conflictAnnotationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass staticAnnotationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass constructorAnnotationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass standardAnnotationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass pojoDirectiveFinalEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass pojoDirectiveAbstractEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass pojoDirectiveExtendsEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass pojoDirectiveDiscriminatorEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass pojoDirectiveOperatorsEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass pojoDirectiveSerializableEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass pojoDirectiveEqualsEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass pojoDirectiveHashCodeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass pojoDirectiveToInitEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass pojoDirectiveEnumInitEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass pojoDirectiveIsDefEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass pojoDirectiveEnumDefEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass pojoDirectiveToStringEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass pojoDirectiveIndexEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass setterAnnotationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass getterAnnotationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass attributeAnnotationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass pojoPropertyDirectiveRequiredEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass pojoPropertyDirectivePrimaryKeyEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass pojoPropertyDirectiveDiscriminatorEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass pojoPropertyDirectiveIndexEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass pojoPropertyDirectiveVersionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass pojoPropertyDirectiveUpdateColEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass pojoPropertyDirectiveCreateColEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass enumDirectiveFinalEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass enumDirectiveExtendsEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass enumDirectiveSerializableEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass enumPropertyDirectiveValuesEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass daoDirectiveFinalEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass daoDirectiveAbstractEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass daoDirectiveExtendsEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass daoDirectiveSerializableEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass daoDirectiveDiscriminatorEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass daoDirectivePojoEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass daoDirectiveGenericsEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass daoDirectiveProcedureEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass daoDirectiveFunctionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass daoDirectiveUpdateEClass = null;

  /**
   * Creates an instance of the model <b>Package</b>, registered with
   * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
   * package URI value.
   * <p>Note: the correct way to create the package is via the static
   * factory method {@link #init init()}, which also performs
   * initialization of the package, or returns the registered package,
   * if one already exists.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.emf.ecore.EPackage.Registry
   * @see org.sqlproc.dsl.processorDsl.ProcessorDslPackage#eNS_URI
   * @see #init()
   * @generated
   */
  private ProcessorDslPackageImpl()
  {
    super(eNS_URI, ProcessorDslFactory.eINSTANCE);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static boolean isInited = false;

  /**
   * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
   * 
   * <p>This method is used to initialize {@link ProcessorDslPackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @generated
   */
  public static ProcessorDslPackage init()
  {
    if (isInited) return (ProcessorDslPackage)EPackage.Registry.INSTANCE.getEPackage(ProcessorDslPackage.eNS_URI);

    // Obtain or create and register package
    ProcessorDslPackageImpl theProcessorDslPackage = (ProcessorDslPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof ProcessorDslPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new ProcessorDslPackageImpl());

    isInited = true;

    // Initialize simple dependencies
    TypesPackage.eINSTANCE.eClass();

    // Load packages
    theProcessorDslPackage.loadPackage();

    // Fix loaded packages
    theProcessorDslPackage.fixPackageContents();

    // Mark meta-data to indicate it can't be changed
    theProcessorDslPackage.freeze();

  
    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(ProcessorDslPackage.eNS_URI, theProcessorDslPackage);
    return theProcessorDslPackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getArtifacts()
  {
    if (artifactsEClass == null)
    {
      artifactsEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(ProcessorDslPackage.eNS_URI).getEClassifiers().get(0);
    }
    return artifactsEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getArtifacts_Properties()
  {
        return (EReference)getArtifacts().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getArtifacts_Pojos()
  {
        return (EReference)getArtifacts().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getArtifacts_Tables()
  {
        return (EReference)getArtifacts().getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getArtifacts_Procedures()
  {
        return (EReference)getArtifacts().getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getArtifacts_Functions()
  {
        return (EReference)getArtifacts().getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getArtifacts_Statements()
  {
        return (EReference)getArtifacts().getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getArtifacts_Mappings()
  {
        return (EReference)getArtifacts().getEStructuralFeatures().get(6);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getArtifacts_Features()
  {
        return (EReference)getArtifacts().getEStructuralFeatures().get(7);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getArtifacts_PojoPackages()
  {
        return (EReference)getArtifacts().getEStructuralFeatures().get(8);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getDatabaseCatalogAssignement()
  {
    if (databaseCatalogAssignementEClass == null)
    {
      databaseCatalogAssignementEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(ProcessorDslPackage.eNS_URI).getEClassifiers().get(1);
    }
    return databaseCatalogAssignementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getDatabaseCatalogAssignement_DbCatalog()
  {
        return (EAttribute)getDatabaseCatalogAssignement().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getDatabaseSchemaAssignement()
  {
    if (databaseSchemaAssignementEClass == null)
    {
      databaseSchemaAssignementEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(ProcessorDslPackage.eNS_URI).getEClassifiers().get(2);
    }
    return databaseSchemaAssignementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getDatabaseSchemaAssignement_DbSchema()
  {
        return (EAttribute)getDatabaseSchemaAssignement().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getDatabaseTypeAssignement()
  {
    if (databaseTypeAssignementEClass == null)
    {
      databaseTypeAssignementEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(ProcessorDslPackage.eNS_URI).getEClassifiers().get(3);
    }
    return databaseTypeAssignementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getDatabaseTypeAssignement_DbType()
  {
        return (EAttribute)getDatabaseTypeAssignement().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getDatabaseMetaInfoAssignement()
  {
    if (databaseMetaInfoAssignementEClass == null)
    {
      databaseMetaInfoAssignementEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(ProcessorDslPackage.eNS_URI).getEClassifiers().get(4);
    }
    return databaseMetaInfoAssignementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getDatabaseMetaInfoAssignement_DbMetaInfo()
  {
        return (EAttribute)getDatabaseMetaInfoAssignement().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getDriverMetaInfoAssignement()
  {
    if (driverMetaInfoAssignementEClass == null)
    {
      driverMetaInfoAssignementEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(ProcessorDslPackage.eNS_URI).getEClassifiers().get(5);
    }
    return driverMetaInfoAssignementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getDriverMetaInfoAssignement_DbDriverInfo()
  {
        return (EAttribute)getDriverMetaInfoAssignement().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getDriverMethodOutputAssignement()
  {
    if (driverMethodOutputAssignementEClass == null)
    {
      driverMethodOutputAssignementEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(ProcessorDslPackage.eNS_URI).getEClassifiers().get(6);
    }
    return driverMethodOutputAssignementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getDriverMethodOutputAssignement_DriverMethod()
  {
        return (EAttribute)getDriverMethodOutputAssignement().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getDriverMethodOutputAssignement_CallOutput()
  {
        return (EAttribute)getDriverMethodOutputAssignement().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSqlTypeAssignement()
  {
    if (sqlTypeAssignementEClass == null)
    {
      sqlTypeAssignementEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(ProcessorDslPackage.eNS_URI).getEClassifiers().get(7);
    }
    return sqlTypeAssignementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getSqlTypeAssignement_TypeName()
  {
        return (EAttribute)getSqlTypeAssignement().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getSqlTypeAssignement_Size()
  {
        return (EAttribute)getSqlTypeAssignement().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSqlTypeAssignement_Type()
  {
        return (EReference)getSqlTypeAssignement().getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getColumnTypeAssignement()
  {
    if (columnTypeAssignementEClass == null)
    {
      columnTypeAssignementEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(ProcessorDslPackage.eNS_URI).getEClassifiers().get(8);
    }
    return columnTypeAssignementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getColumnTypeAssignement_DbColumn()
  {
        return (EAttribute)getColumnTypeAssignement().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getColumnTypeAssignement_Type()
  {
        return (EReference)getColumnTypeAssignement().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getShowColumnTypeAssignement()
  {
    if (showColumnTypeAssignementEClass == null)
    {
      showColumnTypeAssignementEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(ProcessorDslPackage.eNS_URI).getEClassifiers().get(9);
    }
    return showColumnTypeAssignementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getShowColumnTypeAssignement_DbColumn()
  {
        return (EAttribute)getShowColumnTypeAssignement().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getShowColumnTypeAssignement_Type()
  {
        return (EAttribute)getShowColumnTypeAssignement().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTableAssignement()
  {
    if (tableAssignementEClass == null)
    {
      tableAssignementEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(ProcessorDslPackage.eNS_URI).getEClassifiers().get(10);
    }
    return tableAssignementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTableAssignement_DbTable()
  {
        return (EAttribute)getTableAssignement().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTableAssignement_NewName()
  {
        return (EAttribute)getTableAssignement().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getJoinTableAssignement()
  {
    if (joinTableAssignementEClass == null)
    {
      joinTableAssignementEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(ProcessorDslPackage.eNS_URI).getEClassifiers().get(11);
    }
    return joinTableAssignementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getJoinTableAssignement_DbTable()
  {
        return (EAttribute)getJoinTableAssignement().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getJoinTableAssignement_DbTables()
  {
        return (EAttribute)getJoinTableAssignement().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getColumnAssignement()
  {
    if (columnAssignementEClass == null)
    {
      columnAssignementEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(ProcessorDslPackage.eNS_URI).getEClassifiers().get(12);
    }
    return columnAssignementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getColumnAssignement_DbColumn()
  {
        return (EAttribute)getColumnAssignement().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getColumnAssignement_NewName()
  {
        return (EAttribute)getColumnAssignement().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getImportAssignement()
  {
    if (importAssignementEClass == null)
    {
      importAssignementEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(ProcessorDslPackage.eNS_URI).getEClassifiers().get(13);
    }
    return importAssignementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getImportAssignement_DbColumn()
  {
        return (EAttribute)getImportAssignement().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getImportAssignement_PkTable()
  {
        return (EAttribute)getImportAssignement().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getImportAssignement_PkColumn()
  {
        return (EAttribute)getImportAssignement().getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getExportAssignement()
  {
    if (exportAssignementEClass == null)
    {
      exportAssignementEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(ProcessorDslPackage.eNS_URI).getEClassifiers().get(14);
    }
    return exportAssignementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getExportAssignement_DbColumn()
  {
        return (EAttribute)getExportAssignement().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getExportAssignement_FkTable()
  {
        return (EAttribute)getExportAssignement().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getExportAssignement_FkColumn()
  {
        return (EAttribute)getExportAssignement().getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getInheritanceAssignement()
  {
    if (inheritanceAssignementEClass == null)
    {
      inheritanceAssignementEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(ProcessorDslPackage.eNS_URI).getEClassifiers().get(15);
    }
    return inheritanceAssignementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getInheritanceAssignement_Discriminator()
  {
        return (EAttribute)getInheritanceAssignement().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getInheritanceAssignement_DbTable()
  {
        return (EAttribute)getInheritanceAssignement().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getInheritanceAssignement_DbColumns()
  {
        return (EAttribute)getInheritanceAssignement().getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getManyToManyAssignement()
  {
    if (manyToManyAssignementEClass == null)
    {
      manyToManyAssignementEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(ProcessorDslPackage.eNS_URI).getEClassifiers().get(16);
    }
    return manyToManyAssignementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getManyToManyAssignement_PkColumn()
  {
        return (EAttribute)getManyToManyAssignement().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getManyToManyAssignement_PkTable()
  {
        return (EAttribute)getManyToManyAssignement().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getManyToManyAssignement_FkColumn()
  {
        return (EAttribute)getManyToManyAssignement().getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getDebugLevelAssignement()
  {
    if (debugLevelAssignementEClass == null)
    {
      debugLevelAssignementEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(ProcessorDslPackage.eNS_URI).getEClassifiers().get(17);
    }
    return debugLevelAssignementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getDebugLevelAssignement_Debug()
  {
        return (EAttribute)getDebugLevelAssignement().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getDebugLevelAssignement_Scope()
  {
        return (EAttribute)getDebugLevelAssignement().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getProcedurePojoAssignement()
  {
    if (procedurePojoAssignementEClass == null)
    {
      procedurePojoAssignementEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(ProcessorDslPackage.eNS_URI).getEClassifiers().get(18);
    }
    return procedurePojoAssignementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getProcedurePojoAssignement_DbProcedure()
  {
        return (EAttribute)getProcedurePojoAssignement().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getProcedurePojoAssignement_Pojo()
  {
        return (EReference)getProcedurePojoAssignement().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getFunctionPojoAssignement()
  {
    if (functionPojoAssignementEClass == null)
    {
      functionPojoAssignementEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(ProcessorDslPackage.eNS_URI).getEClassifiers().get(19);
    }
    return functionPojoAssignementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getFunctionPojoAssignement_DbFunction()
  {
        return (EAttribute)getFunctionPojoAssignement().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getFunctionPojoAssignement_Pojo()
  {
        return (EReference)getFunctionPojoAssignement().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getImplementsAssignement()
  {
    if (implementsAssignementEClass == null)
    {
      implementsAssignementEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(ProcessorDslPackage.eNS_URI).getEClassifiers().get(20);
    }
    return implementsAssignementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getImplementsAssignement_ToImplement()
  {
        return (EReference)getImplementsAssignement().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getImplementsAssignement_DbTables()
  {
        return (EAttribute)getImplementsAssignement().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getImplementsAssignement_DbNotTables()
  {
        return (EAttribute)getImplementsAssignement().getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getExtendsAssignement()
  {
    if (extendsAssignementEClass == null)
    {
      extendsAssignementEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(ProcessorDslPackage.eNS_URI).getEClassifiers().get(21);
    }
    return extendsAssignementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getExtendsAssignement_ToExtends()
  {
        return (EReference)getExtendsAssignement().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getExtendsAssignement_DbTables()
  {
        return (EAttribute)getExtendsAssignement().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getExtendsAssignement_DbNotTables()
  {
        return (EAttribute)getExtendsAssignement().getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getImplementsAssignementGenerics()
  {
    if (implementsAssignementGenericsEClass == null)
    {
      implementsAssignementGenericsEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(ProcessorDslPackage.eNS_URI).getEClassifiers().get(22);
    }
    return implementsAssignementGenericsEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getImplementsAssignementGenerics_ToImplement()
  {
        return (EReference)getImplementsAssignementGenerics().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getImplementsAssignementGenerics_DbTables()
  {
        return (EAttribute)getImplementsAssignementGenerics().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getImplementsAssignementGenerics_DbNotTables()
  {
        return (EAttribute)getImplementsAssignementGenerics().getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getExtendsAssignementGenerics()
  {
    if (extendsAssignementGenericsEClass == null)
    {
      extendsAssignementGenericsEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(ProcessorDslPackage.eNS_URI).getEClassifiers().get(23);
    }
    return extendsAssignementGenericsEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getExtendsAssignementGenerics_ToExtends()
  {
        return (EReference)getExtendsAssignementGenerics().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getExtendsAssignementGenerics_DbTables()
  {
        return (EAttribute)getExtendsAssignementGenerics().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getExtendsAssignementGenerics_DbNotTables()
  {
        return (EAttribute)getExtendsAssignementGenerics().getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getProperty()
  {
    if (propertyEClass == null)
    {
      propertyEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(ProcessorDslPackage.eNS_URI).getEClassifiers().get(24);
    }
    return propertyEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getProperty_Name()
  {
        return (EAttribute)getProperty().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getProperty_Database()
  {
        return (EReference)getProperty().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getProperty_Pojogen()
  {
        return (EReference)getProperty().getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getProperty_Metagen()
  {
        return (EReference)getProperty().getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getProperty_Daogen()
  {
        return (EReference)getProperty().getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getProperty_ReplaceId()
  {
        return (EAttribute)getProperty().getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getProperty_Regex()
  {
        return (EAttribute)getProperty().getEStructuralFeatures().get(6);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getProperty_Replacement()
  {
        return (EAttribute)getProperty().getEStructuralFeatures().get(7);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getDatabaseProperty()
  {
    if (databasePropertyEClass == null)
    {
      databasePropertyEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(ProcessorDslPackage.eNS_URI).getEClassifiers().get(25);
    }
    return databasePropertyEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getDatabaseProperty_Name()
  {
        return (EAttribute)getDatabaseProperty().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getDatabaseProperty_DbUrl()
  {
        return (EAttribute)getDatabaseProperty().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getDatabaseProperty_DbUsername()
  {
        return (EAttribute)getDatabaseProperty().getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getDatabaseProperty_DbPassword()
  {
        return (EAttribute)getDatabaseProperty().getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getDatabaseProperty_DbCatalog()
  {
        return (EReference)getDatabaseProperty().getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getDatabaseProperty_DbSchema()
  {
        return (EReference)getDatabaseProperty().getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getDatabaseProperty_DbDriverx()
  {
        return (EReference)getDatabaseProperty().getEStructuralFeatures().get(6);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getDatabaseProperty_DbDriver()
  {
        return (EAttribute)getDatabaseProperty().getEStructuralFeatures().get(7);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getDatabaseProperty_DbExecuteBefore()
  {
        return (EAttribute)getDatabaseProperty().getEStructuralFeatures().get(8);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getDatabaseProperty_DbExecuteAfter()
  {
        return (EAttribute)getDatabaseProperty().getEStructuralFeatures().get(9);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getDatabaseProperty_DbIndexTypes()
  {
        return (EAttribute)getDatabaseProperty().getEStructuralFeatures().get(10);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getDatabaseProperty_DbType()
  {
        return (EReference)getDatabaseProperty().getEStructuralFeatures().get(11);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getDatabaseProperty_DbMetaInfo()
  {
        return (EReference)getDatabaseProperty().getEStructuralFeatures().get(12);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getDatabaseProperty_DbDriverInfo()
  {
        return (EReference)getDatabaseProperty().getEStructuralFeatures().get(13);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getDatabaseProperty_DbMethodsCalls()
  {
        return (EReference)getDatabaseProperty().getEStructuralFeatures().get(14);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getDatabaseProperty_Debug()
  {
        return (EReference)getDatabaseProperty().getEStructuralFeatures().get(15);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPojogenProperty()
  {
    if (pojogenPropertyEClass == null)
    {
      pojogenPropertyEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(ProcessorDslPackage.eNS_URI).getEClassifiers().get(26);
    }
    return pojogenPropertyEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getPojogenProperty_Name()
  {
        return (EAttribute)getPojogenProperty().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPojogenProperty_SqlTypes()
  {
        return (EReference)getPojogenProperty().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getPojogenProperty_DbTable()
  {
        return (EAttribute)getPojogenProperty().getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPojogenProperty_ColumnTypes()
  {
        return (EReference)getPojogenProperty().getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getPojogenProperty_DbProcedure()
  {
        return (EAttribute)getPojogenProperty().getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getPojogenProperty_DbFunction()
  {
        return (EAttribute)getPojogenProperty().getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPojogenProperty_ColumnType()
  {
        return (EReference)getPojogenProperty().getEStructuralFeatures().get(6);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getPojogenProperty_DbTables()
  {
        return (EAttribute)getPojogenProperty().getEStructuralFeatures().get(7);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPojogenProperty_JoinTables()
  {
        return (EReference)getPojogenProperty().getEStructuralFeatures().get(8);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getPojogenProperty_DbColumns()
  {
        return (EAttribute)getPojogenProperty().getEStructuralFeatures().get(9);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPojogenProperty_Tables()
  {
        return (EReference)getPojogenProperty().getEStructuralFeatures().get(10);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPojogenProperty_Columns()
  {
        return (EReference)getPojogenProperty().getEStructuralFeatures().get(11);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPojogenProperty_Exports()
  {
        return (EReference)getPojogenProperty().getEStructuralFeatures().get(12);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPojogenProperty_Imports()
  {
        return (EReference)getPojogenProperty().getEStructuralFeatures().get(13);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPojogenProperty_Many2s()
  {
        return (EReference)getPojogenProperty().getEStructuralFeatures().get(14);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getPojogenProperty_DbColumn()
  {
        return (EAttribute)getPojogenProperty().getEStructuralFeatures().get(15);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPojogenProperty_Inheritance()
  {
        return (EReference)getPojogenProperty().getEStructuralFeatures().get(16);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getPojogenProperty_Methods()
  {
        return (EAttribute)getPojogenProperty().getEStructuralFeatures().get(17);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getPojogenProperty_OperatorsSuffix()
  {
        return (EAttribute)getPojogenProperty().getEStructuralFeatures().get(18);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPojogenProperty_ToImplements()
  {
        return (EReference)getPojogenProperty().getEStructuralFeatures().get(19);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPojogenProperty_ToExtends()
  {
        return (EReference)getPojogenProperty().getEStructuralFeatures().get(20);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPojogenProperty_ToImplementsGenerics()
  {
        return (EReference)getPojogenProperty().getEStructuralFeatures().get(21);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPojogenProperty_ToExtendsGenerics()
  {
        return (EReference)getPojogenProperty().getEStructuralFeatures().get(22);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getPojogenProperty_ImplPackage()
  {
        return (EAttribute)getPojogenProperty().getEStructuralFeatures().get(23);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getPojogenProperty_Version()
  {
        return (EAttribute)getPojogenProperty().getEStructuralFeatures().get(24);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getPojogenProperty_DbNotTables()
  {
        return (EAttribute)getPojogenProperty().getEStructuralFeatures().get(25);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPojogenProperty_Debug()
  {
        return (EReference)getPojogenProperty().getEStructuralFeatures().get(26);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPojogenProperty_ProcPojos()
  {
        return (EReference)getPojogenProperty().getEStructuralFeatures().get(27);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPojogenProperty_FunPojos()
  {
        return (EReference)getPojogenProperty().getEStructuralFeatures().get(28);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getPojogenProperty_ActiveFilter()
  {
        return (EAttribute)getPojogenProperty().getEStructuralFeatures().get(29);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getPojogenProperty_Pckg()
  {
        return (EAttribute)getPojogenProperty().getEStructuralFeatures().get(30);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getPojogenProperty_EnumName()
  {
        return (EAttribute)getPojogenProperty().getEStructuralFeatures().get(31);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getPojogenProperty_DbCheckConstraints()
  {
        return (EAttribute)getPojogenProperty().getEStructuralFeatures().get(32);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMetaTypeAssignement()
  {
    if (metaTypeAssignementEClass == null)
    {
      metaTypeAssignementEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(ProcessorDslPackage.eNS_URI).getEClassifiers().get(27);
    }
    return metaTypeAssignementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMetaTypeAssignement_DbColumn()
  {
        return (EAttribute)getMetaTypeAssignement().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMetaTypeAssignement_Type()
  {
        return (EAttribute)getMetaTypeAssignement().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMetaTypeAssignement_Extension()
  {
        return (EAttribute)getMetaTypeAssignement().getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMetagenProperty()
  {
    if (metagenPropertyEClass == null)
    {
      metagenPropertyEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(ProcessorDslPackage.eNS_URI).getEClassifiers().get(28);
    }
    return metagenPropertyEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMetagenProperty_Name()
  {
        return (EAttribute)getMetagenProperty().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMetagenProperty_Sequence()
  {
        return (EAttribute)getMetagenProperty().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMetagenProperty_Type()
  {
        return (EAttribute)getMetagenProperty().getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMetagenProperty_DbTables()
  {
        return (EAttribute)getMetagenProperty().getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMetagenProperty_DbNotTables()
  {
        return (EAttribute)getMetagenProperty().getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMetagenProperty_DbTable()
  {
        return (EAttribute)getMetagenProperty().getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMetagenProperty_Identity()
  {
        return (EAttribute)getMetagenProperty().getEStructuralFeatures().get(6);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMetagenProperty_MetaTypes()
  {
        return (EReference)getMetagenProperty().getEStructuralFeatures().get(7);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMetagenProperty_DbStatement()
  {
        return (EAttribute)getMetagenProperty().getEStructuralFeatures().get(8);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMetagenProperty_DbColumns()
  {
        return (EAttribute)getMetagenProperty().getEStructuralFeatures().get(9);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMetagenProperty_DbFunction()
  {
        return (EAttribute)getMetagenProperty().getEStructuralFeatures().get(10);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMetagenProperty_DbProcedure()
  {
        return (EAttribute)getMetagenProperty().getEStructuralFeatures().get(11);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMetagenProperty_Debug()
  {
        return (EReference)getMetagenProperty().getEStructuralFeatures().get(12);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMetagenProperty_OptionalFeatures()
  {
        return (EAttribute)getMetagenProperty().getEStructuralFeatures().get(13);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMetagenProperty_ActiveFilter()
  {
        return (EAttribute)getMetagenProperty().getEStructuralFeatures().get(14);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getDaogenProperty()
  {
    if (daogenPropertyEClass == null)
    {
      daogenPropertyEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(ProcessorDslPackage.eNS_URI).getEClassifiers().get(29);
    }
    return daogenPropertyEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getDaogenProperty_Name()
  {
        return (EAttribute)getDaogenProperty().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getDaogenProperty_DbTables()
  {
        return (EAttribute)getDaogenProperty().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getDaogenProperty_ImplPackage()
  {
        return (EAttribute)getDaogenProperty().getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getDaogenProperty_ToImplements()
  {
        return (EReference)getDaogenProperty().getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getDaogenProperty_ToExtends()
  {
        return (EReference)getDaogenProperty().getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getDaogenProperty_ToImplementsGenerics()
  {
        return (EReference)getDaogenProperty().getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getDaogenProperty_ToExtendsGenerics()
  {
        return (EReference)getDaogenProperty().getEStructuralFeatures().get(6);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getDaogenProperty_DbFunction()
  {
        return (EAttribute)getDaogenProperty().getEStructuralFeatures().get(7);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getDaogenProperty_ResultType()
  {
        return (EReference)getDaogenProperty().getEStructuralFeatures().get(8);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getDaogenProperty_Debug()
  {
        return (EReference)getDaogenProperty().getEStructuralFeatures().get(9);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getDaogenProperty_ActiveFilter()
  {
        return (EAttribute)getDaogenProperty().getEStructuralFeatures().get(10);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getDaogenProperty_Pckg()
  {
        return (EAttribute)getDaogenProperty().getEStructuralFeatures().get(11);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPojoDefinition()
  {
    if (pojoDefinitionEClass == null)
    {
      pojoDefinitionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(ProcessorDslPackage.eNS_URI).getEClassifiers().get(30);
    }
    return pojoDefinitionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getPojoDefinition_Name()
  {
        return (EAttribute)getPojoDefinition().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getPojoDefinition_Class()
  {
        return (EAttribute)getPojoDefinition().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPojoDefinition_Classx()
  {
        return (EReference)getPojoDefinition().getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTableDefinition()
  {
    if (tableDefinitionEClass == null)
    {
      tableDefinitionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(ProcessorDslPackage.eNS_URI).getEClassifiers().get(31);
    }
    return tableDefinitionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTableDefinition_Name()
  {
        return (EAttribute)getTableDefinition().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTableDefinition_Table()
  {
        return (EAttribute)getTableDefinition().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getProcedureDefinition()
  {
    if (procedureDefinitionEClass == null)
    {
      procedureDefinitionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(ProcessorDslPackage.eNS_URI).getEClassifiers().get(32);
    }
    return procedureDefinitionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getProcedureDefinition_Name()
  {
        return (EAttribute)getProcedureDefinition().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getProcedureDefinition_Table()
  {
        return (EAttribute)getProcedureDefinition().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getFunctionDefinition()
  {
    if (functionDefinitionEClass == null)
    {
      functionDefinitionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(ProcessorDslPackage.eNS_URI).getEClassifiers().get(33);
    }
    return functionDefinitionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getFunctionDefinition_Name()
  {
        return (EAttribute)getFunctionDefinition().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getFunctionDefinition_Table()
  {
        return (EAttribute)getFunctionDefinition().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMetaStatement()
  {
    if (metaStatementEClass == null)
    {
      metaStatementEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(ProcessorDslPackage.eNS_URI).getEClassifiers().get(34);
    }
    return metaStatementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMetaStatement_Name()
  {
        return (EAttribute)getMetaStatement().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMetaStatement_Type()
  {
        return (EAttribute)getMetaStatement().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMetaStatement_Modifiers()
  {
        return (EAttribute)getMetaStatement().getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMetaStatement_Statement()
  {
        return (EReference)getMetaStatement().getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSql()
  {
    if (sqlEClass == null)
    {
      sqlEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(ProcessorDslPackage.eNS_URI).getEClassifiers().get(35);
    }
    return sqlEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSql_Sqls()
  {
        return (EReference)getSql().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSqlFragment()
  {
    if (sqlFragmentEClass == null)
    {
      sqlFragmentEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(ProcessorDslPackage.eNS_URI).getEClassifiers().get(36);
    }
    return sqlFragmentEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getSqlFragment_Value()
  {
        return (EAttribute)getSqlFragment().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSqlFragment_Col()
  {
        return (EReference)getSqlFragment().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSqlFragment_Cnst()
  {
        return (EReference)getSqlFragment().getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSqlFragment_Ident()
  {
        return (EReference)getSqlFragment().getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSqlFragment_CnstOper()
  {
        return (EReference)getSqlFragment().getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSqlFragment_IdentOper()
  {
        return (EReference)getSqlFragment().getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSqlFragment_Meta()
  {
        return (EReference)getSqlFragment().getEStructuralFeatures().get(6);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSqlFragment_Dbtab()
  {
        return (EReference)getSqlFragment().getEStructuralFeatures().get(7);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSqlFragment_Dbcol()
  {
        return (EReference)getSqlFragment().getEStructuralFeatures().get(8);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMetaSql()
  {
    if (metaSqlEClass == null)
    {
      metaSqlEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(ProcessorDslPackage.eNS_URI).getEClassifiers().get(37);
    }
    return metaSqlEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMetaSql_Ifs()
  {
        return (EReference)getMetaSql().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMetaSql_Type()
  {
        return (EAttribute)getMetaSql().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMetaSql_Cond()
  {
        return (EReference)getMetaSql().getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMetaSql_Ftype()
  {
        return (EAttribute)getMetaSql().getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMetaSql_Ord()
  {
        return (EReference)getMetaSql().getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getIfSql()
  {
    if (ifSqlEClass == null)
    {
      ifSqlEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(ProcessorDslPackage.eNS_URI).getEClassifiers().get(38);
    }
    return ifSqlEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getIfSql_Sqls()
  {
        return (EReference)getIfSql().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getIfSqlFragment()
  {
    if (ifSqlFragmentEClass == null)
    {
      ifSqlFragmentEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(ProcessorDslPackage.eNS_URI).getEClassifiers().get(39);
    }
    return ifSqlFragmentEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getIfSqlFragment_Value()
  {
        return (EAttribute)getIfSqlFragment().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getIfSqlFragment_Col()
  {
        return (EReference)getIfSqlFragment().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getIfSqlFragment_Cnst()
  {
        return (EReference)getIfSqlFragment().getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getIfSqlFragment_Ident()
  {
        return (EReference)getIfSqlFragment().getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getIfSqlFragment_CnstOper()
  {
        return (EReference)getIfSqlFragment().getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getIfSqlFragment_IdentOper()
  {
        return (EReference)getIfSqlFragment().getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getIfSqlFragment_Dbtab()
  {
        return (EReference)getIfSqlFragment().getEStructuralFeatures().get(6);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getIfSqlFragment_Dbcol()
  {
        return (EReference)getIfSqlFragment().getEStructuralFeatures().get(7);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getIfSqlFragment_Meta()
  {
        return (EReference)getIfSqlFragment().getEStructuralFeatures().get(8);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getIfMetaSql()
  {
    if (ifMetaSqlEClass == null)
    {
      ifMetaSqlEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(ProcessorDslPackage.eNS_URI).getEClassifiers().get(40);
    }
    return ifMetaSqlEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getIfMetaSql_Ifs()
  {
        return (EReference)getIfMetaSql().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getIfMetaSql_Type()
  {
        return (EAttribute)getIfMetaSql().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getIfMetaSql_Cond()
  {
        return (EReference)getIfMetaSql().getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getIfSqlCond()
  {
    if (ifSqlCondEClass == null)
    {
      ifSqlCondEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(ProcessorDslPackage.eNS_URI).getEClassifiers().get(41);
    }
    return ifSqlCondEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getIfSqlCond_Bool1()
  {
        return (EReference)getIfSqlCond().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getIfSqlCond_Oper()
  {
        return (EAttribute)getIfSqlCond().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getIfSqlCond_Bool2()
  {
        return (EReference)getIfSqlCond().getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getIfSqlBool()
  {
    if (ifSqlBoolEClass == null)
    {
      ifSqlBoolEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(ProcessorDslPackage.eNS_URI).getEClassifiers().get(42);
    }
    return ifSqlBoolEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getIfSqlBool_Not()
  {
        return (EAttribute)getIfSqlBool().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getIfSqlBool_Cnst()
  {
        return (EReference)getIfSqlBool().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getIfSqlBool_Ident()
  {
        return (EReference)getIfSqlBool().getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getIfSqlBool_Cond()
  {
        return (EReference)getIfSqlBool().getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getOrdSql()
  {
    if (ordSqlEClass == null)
    {
      ordSqlEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(ProcessorDslPackage.eNS_URI).getEClassifiers().get(43);
    }
    return ordSqlEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getOrdSql_Sqls()
  {
        return (EReference)getOrdSql().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getOrdSql2()
  {
    if (ordSql2EClass == null)
    {
      ordSql2EClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(ProcessorDslPackage.eNS_URI).getEClassifiers().get(44);
    }
    return ordSql2EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getOrdSql2_Value()
  {
        return (EAttribute)getOrdSql2().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getOrdSql2_Cnst()
  {
        return (EReference)getOrdSql2().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getOrdSql2_Ident()
  {
        return (EReference)getOrdSql2().getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getOrdSql2_Dbcol()
  {
        return (EReference)getOrdSql2().getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getColumn()
  {
    if (columnEClass == null)
    {
      columnEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(ProcessorDslPackage.eNS_URI).getEClassifiers().get(45);
    }
    return columnEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getColumn_Columns()
  {
        return (EReference)getColumn().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getExtendedColumn()
  {
    if (extendedColumnEClass == null)
    {
      extendedColumnEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(ProcessorDslPackage.eNS_URI).getEClassifiers().get(46);
    }
    return extendedColumnEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getExtendedColumn_Col()
  {
        return (EReference)getExtendedColumn().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getExtendedColumn_Modifiers()
  {
        return (EAttribute)getExtendedColumn().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getExtendedColumnName()
  {
    if (extendedColumnNameEClass == null)
    {
      extendedColumnNameEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(ProcessorDslPackage.eNS_URI).getEClassifiers().get(47);
    }
    return extendedColumnNameEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getExtendedColumnName_Name()
  {
        return (EAttribute)getExtendedColumnName().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getConstant()
  {
    if (constantEClass == null)
    {
      constantEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(ProcessorDslPackage.eNS_URI).getEClassifiers().get(48);
    }
    return constantEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getConstant_Case()
  {
        return (EAttribute)getConstant().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getConstant_Name()
  {
        return (EAttribute)getConstant().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getConstant_Modifiers()
  {
        return (EAttribute)getConstant().getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getIdentifier()
  {
    if (identifierEClass == null)
    {
      identifierEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(ProcessorDslPackage.eNS_URI).getEClassifiers().get(49);
    }
    return identifierEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getIdentifier_Mode()
  {
        return (EAttribute)getIdentifier().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getIdentifier_Case()
  {
        return (EAttribute)getIdentifier().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getIdentifier_Name()
  {
        return (EAttribute)getIdentifier().getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getIdentifier_Modifiers()
  {
        return (EAttribute)getIdentifier().getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getConstantOperator()
  {
    if (constantOperatorEClass == null)
    {
      constantOperatorEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(ProcessorDslPackage.eNS_URI).getEClassifiers().get(50);
    }
    return constantOperatorEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getConstantOperator_Name()
  {
        return (EAttribute)getConstantOperator().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getIdentifierOperator()
  {
    if (identifierOperatorEClass == null)
    {
      identifierOperatorEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(ProcessorDslPackage.eNS_URI).getEClassifiers().get(51);
    }
    return identifierOperatorEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getIdentifierOperator_Name()
  {
        return (EAttribute)getIdentifierOperator().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getDatabaseColumn()
  {
    if (databaseColumnEClass == null)
    {
      databaseColumnEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(ProcessorDslPackage.eNS_URI).getEClassifiers().get(52);
    }
    return databaseColumnEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getDatabaseColumn_Name()
  {
        return (EAttribute)getDatabaseColumn().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getDatabaseTable()
  {
    if (databaseTableEClass == null)
    {
      databaseTableEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(ProcessorDslPackage.eNS_URI).getEClassifiers().get(53);
    }
    return databaseTableEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getDatabaseTable_Name()
  {
        return (EAttribute)getDatabaseTable().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMappingRule()
  {
    if (mappingRuleEClass == null)
    {
      mappingRuleEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(ProcessorDslPackage.eNS_URI).getEClassifiers().get(54);
    }
    return mappingRuleEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMappingRule_Name()
  {
        return (EAttribute)getMappingRule().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMappingRule_Type()
  {
        return (EAttribute)getMappingRule().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMappingRule_Modifiers()
  {
        return (EAttribute)getMappingRule().getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMappingRule_Mapping()
  {
        return (EReference)getMappingRule().getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMapping()
  {
    if (mappingEClass == null)
    {
      mappingEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(ProcessorDslPackage.eNS_URI).getEClassifiers().get(55);
    }
    return mappingEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMapping_MappingItems()
  {
        return (EReference)getMapping().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMappingItem()
  {
    if (mappingItemEClass == null)
    {
      mappingItemEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(ProcessorDslPackage.eNS_URI).getEClassifiers().get(56);
    }
    return mappingItemEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMappingItem_Name()
  {
        return (EAttribute)getMappingItem().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMappingItem_Attr()
  {
        return (EReference)getMappingItem().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMappingColumn()
  {
    if (mappingColumnEClass == null)
    {
      mappingColumnEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(ProcessorDslPackage.eNS_URI).getEClassifiers().get(57);
    }
    return mappingColumnEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMappingColumn_Items()
  {
        return (EReference)getMappingColumn().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getExtendedMappingItem()
  {
    if (extendedMappingItemEClass == null)
    {
      extendedMappingItemEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(ProcessorDslPackage.eNS_URI).getEClassifiers().get(58);
    }
    return extendedMappingItemEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getExtendedMappingItem_Attr()
  {
        return (EReference)getExtendedMappingItem().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getExtendedMappingItem_Modifiers()
  {
        return (EAttribute)getExtendedMappingItem().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMappingColumnName()
  {
    if (mappingColumnNameEClass == null)
    {
      mappingColumnNameEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(ProcessorDslPackage.eNS_URI).getEClassifiers().get(59);
    }
    return mappingColumnNameEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMappingColumnName_Name()
  {
        return (EAttribute)getMappingColumnName().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getOptionalFeature()
  {
    if (optionalFeatureEClass == null)
    {
      optionalFeatureEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(ProcessorDslPackage.eNS_URI).getEClassifiers().get(60);
    }
    return optionalFeatureEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getOptionalFeature_Name()
  {
        return (EAttribute)getOptionalFeature().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getOptionalFeature_Type()
  {
        return (EAttribute)getOptionalFeature().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getOptionalFeature_Modifiers()
  {
        return (EAttribute)getOptionalFeature().getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getOptionalFeature_Option()
  {
        return (EAttribute)getOptionalFeature().getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPackageDirective()
  {
    if (packageDirectiveEClass == null)
    {
      packageDirectiveEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(ProcessorDslPackage.eNS_URI).getEClassifiers().get(61);
    }
    return packageDirectiveEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPackageDeclaration()
  {
    if (packageDeclarationEClass == null)
    {
      packageDeclarationEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(ProcessorDslPackage.eNS_URI).getEClassifiers().get(62);
    }
    return packageDeclarationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPackageDeclaration_Directives()
  {
        return (EReference)getPackageDeclaration().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getPackageDeclaration_Name()
  {
        return (EAttribute)getPackageDeclaration().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPackageDeclaration_Elements()
  {
        return (EReference)getPackageDeclaration().getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getEntity()
  {
    if (entityEClass == null)
    {
      entityEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(ProcessorDslPackage.eNS_URI).getEClassifiers().get(63);
    }
    return entityEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getEntity_Annotations()
  {
        return (EReference)getEntity().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getEntity_Name()
  {
        return (EAttribute)getEntity().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAbstractEntity()
  {
    if (abstractEntityEClass == null)
    {
      abstractEntityEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(ProcessorDslPackage.eNS_URI).getEClassifiers().get(64);
    }
    return abstractEntityEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPojoType()
  {
    if (pojoTypeEClass == null)
    {
      pojoTypeEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(ProcessorDslPackage.eNS_URI).getEClassifiers().get(65);
    }
    return pojoTypeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPojoType_Type()
  {
        return (EReference)getPojoType().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPojoType_Ref()
  {
        return (EReference)getPojoType().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPojoType_Gtype()
  {
        return (EReference)getPojoType().getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPojoType_Gref()
  {
        return (EReference)getPojoType().getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getPojoType_Array()
  {
        return (EAttribute)getPojoType().getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getDaoType()
  {
    if (daoTypeEClass == null)
    {
      daoTypeEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(ProcessorDslPackage.eNS_URI).getEClassifiers().get(66);
    }
    return daoTypeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getDaoType_Type()
  {
        return (EReference)getDaoType().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getDaoType_Ref()
  {
        return (EReference)getDaoType().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getDaoType_Gtype()
  {
        return (EReference)getDaoType().getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getDaoType_Gref()
  {
        return (EReference)getDaoType().getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getImport()
  {
    if (importEClass == null)
    {
      importEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(ProcessorDslPackage.eNS_URI).getEClassifiers().get(67);
    }
    return importEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getImport_ImportedNamespace()
  {
        return (EAttribute)getImport().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getImplements()
  {
    if (implementsEClass == null)
    {
      implementsEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(ProcessorDslPackage.eNS_URI).getEClassifiers().get(68);
    }
    return implementsEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getImplements_Implements()
  {
        return (EReference)getImplements().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getImplements_Generics()
  {
        return (EAttribute)getImplements().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getImplements_OnlyPojos()
  {
        return (EReference)getImplements().getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getImplements_OnlyDaos()
  {
        return (EReference)getImplements().getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getImplements_ExceptPojos()
  {
        return (EReference)getImplements().getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getImplements_ExceptDaos()
  {
        return (EReference)getImplements().getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getExtends()
  {
    if (extendsEClass == null)
    {
      extendsEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(ProcessorDslPackage.eNS_URI).getEClassifiers().get(69);
    }
    return extendsEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getExtends_Extends()
  {
        return (EReference)getExtends().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getExtends_Generics()
  {
        return (EAttribute)getExtends().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getExtends_OnlyPojos()
  {
        return (EReference)getExtends().getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getExtends_OnlyDaos()
  {
        return (EReference)getExtends().getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getExtends_ExceptPojos()
  {
        return (EReference)getExtends().getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getExtends_ExceptDaos()
  {
        return (EReference)getExtends().getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getImplPackage()
  {
    if (implPackageEClass == null)
    {
      implPackageEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(ProcessorDslPackage.eNS_URI).getEClassifiers().get(70);
    }
    return implPackageEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getImplPackage_Name()
  {
        return (EAttribute)getImplPackage().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAnnotationProperty()
  {
    if (annotationPropertyEClass == null)
    {
      annotationPropertyEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(ProcessorDslPackage.eNS_URI).getEClassifiers().get(71);
    }
    return annotationPropertyEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAnnotationProperty_Name()
  {
        return (EAttribute)getAnnotationProperty().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAnnotationProperty_Type()
  {
        return (EReference)getAnnotationProperty().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAnnotationProperty_Number()
  {
        return (EAttribute)getAnnotationProperty().getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAnnotationProperty_Value()
  {
        return (EAttribute)getAnnotationProperty().getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAnnotationProperty_Constant()
  {
        return (EAttribute)getAnnotationProperty().getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAnnotation()
  {
    if (annotationEClass == null)
    {
      annotationEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(ProcessorDslPackage.eNS_URI).getEClassifiers().get(72);
    }
    return annotationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAnnotation_Type()
  {
        return (EReference)getAnnotation().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAnnotation_Features()
  {
        return (EReference)getAnnotation().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getEntityAnnotation()
  {
    if (entityAnnotationEClass == null)
    {
      entityAnnotationEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(ProcessorDslPackage.eNS_URI).getEClassifiers().get(73);
    }
    return entityAnnotationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getEntityAnnotation_Annotation()
  {
        return (EReference)getEntityAnnotation().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getDirectiveProperties()
  {
    if (directivePropertiesEClass == null)
    {
      directivePropertiesEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(ProcessorDslPackage.eNS_URI).getEClassifiers().get(74);
    }
    return directivePropertiesEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getDirectiveProperties_Features()
  {
        return (EReference)getDirectiveProperties().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPojoDirective()
  {
    if (pojoDirectiveEClass == null)
    {
      pojoDirectiveEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(ProcessorDslPackage.eNS_URI).getEClassifiers().get(75);
    }
    return pojoDirectiveEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPojoEntity()
  {
    if (pojoEntityEClass == null)
    {
      pojoEntityEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(ProcessorDslPackage.eNS_URI).getEClassifiers().get(76);
    }
    return pojoEntityEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPojoEntity_Directives()
  {
        return (EReference)getPojoEntity().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPojoEntity_Features()
  {
        return (EReference)getPojoEntity().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPojoPropertyAnnotation()
  {
    if (pojoPropertyAnnotationEClass == null)
    {
      pojoPropertyAnnotationEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(ProcessorDslPackage.eNS_URI).getEClassifiers().get(77);
    }
    return pojoPropertyAnnotationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPojoPropertyAnnotation_Annotation()
  {
        return (EReference)getPojoPropertyAnnotation().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPojoPropertyDirective()
  {
    if (pojoPropertyDirectiveEClass == null)
    {
      pojoPropertyDirectiveEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(ProcessorDslPackage.eNS_URI).getEClassifiers().get(78);
    }
    return pojoPropertyDirectiveEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPojoProperty()
  {
    if (pojoPropertyEClass == null)
    {
      pojoPropertyEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(ProcessorDslPackage.eNS_URI).getEClassifiers().get(79);
    }
    return pojoPropertyEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPojoProperty_Annotations()
  {
        return (EReference)getPojoProperty().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPojoProperty_Directives()
  {
        return (EReference)getPojoProperty().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getPojoProperty_Name()
  {
        return (EAttribute)getPojoProperty().getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPojoProperty_Type()
  {
        return (EReference)getPojoProperty().getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getEnumDirective()
  {
    if (enumDirectiveEClass == null)
    {
      enumDirectiveEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(ProcessorDslPackage.eNS_URI).getEClassifiers().get(80);
    }
    return enumDirectiveEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getEnumEntity()
  {
    if (enumEntityEClass == null)
    {
      enumEntityEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(ProcessorDslPackage.eNS_URI).getEClassifiers().get(81);
    }
    return enumEntityEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getEnumEntity_Directives()
  {
        return (EReference)getEnumEntity().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getEnumEntity_Features()
  {
        return (EReference)getEnumEntity().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getEnumPropertyValue()
  {
    if (enumPropertyValueEClass == null)
    {
      enumPropertyValueEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(ProcessorDslPackage.eNS_URI).getEClassifiers().get(82);
    }
    return enumPropertyValueEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getEnumPropertyValue_Name()
  {
        return (EAttribute)getEnumPropertyValue().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getEnumPropertyValue_Value()
  {
        return (EAttribute)getEnumPropertyValue().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getEnumPropertyDirective()
  {
    if (enumPropertyDirectiveEClass == null)
    {
      enumPropertyDirectiveEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(ProcessorDslPackage.eNS_URI).getEClassifiers().get(83);
    }
    return enumPropertyDirectiveEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getEnumProperty()
  {
    if (enumPropertyEClass == null)
    {
      enumPropertyEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(ProcessorDslPackage.eNS_URI).getEClassifiers().get(84);
    }
    return enumPropertyEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getEnumProperty_Directives()
  {
        return (EReference)getEnumProperty().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getEnumProperty_Name()
  {
        return (EAttribute)getEnumProperty().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getEnumProperty_Type()
  {
        return (EReference)getEnumProperty().getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getDaoDirectiveParameters()
  {
    if (daoDirectiveParametersEClass == null)
    {
      daoDirectiveParametersEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(ProcessorDslPackage.eNS_URI).getEClassifiers().get(85);
    }
    return daoDirectiveParametersEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getDaoDirectiveParameters_In()
  {
        return (EReference)getDaoDirectiveParameters().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getDaoDirectiveParameters_Out()
  {
        return (EReference)getDaoDirectiveParameters().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getDescendantAssignment()
  {
    if (descendantAssignmentEClass == null)
    {
      descendantAssignmentEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(ProcessorDslPackage.eNS_URI).getEClassifiers().get(86);
    }
    return descendantAssignmentEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getDescendantAssignment_Value()
  {
        return (EAttribute)getDescendantAssignment().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getDescendantAssignment_Descendant()
  {
        return (EReference)getDescendantAssignment().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getDaoDirective()
  {
    if (daoDirectiveEClass == null)
    {
      daoDirectiveEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(ProcessorDslPackage.eNS_URI).getEClassifiers().get(87);
    }
    return daoDirectiveEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPojoDao()
  {
    if (pojoDaoEClass == null)
    {
      pojoDaoEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(ProcessorDslPackage.eNS_URI).getEClassifiers().get(88);
    }
    return pojoDaoEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPojoDao_Directives()
  {
        return (EReference)getPojoDao().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getPojoDao_Name()
  {
        return (EAttribute)getPojoDao().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPackageDirectiveSuffix()
  {
    if (packageDirectiveSuffixEClass == null)
    {
      packageDirectiveSuffixEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(ProcessorDslPackage.eNS_URI).getEClassifiers().get(89);
    }
    return packageDirectiveSuffixEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getPackageDirectiveSuffix_Suffix()
  {
        return (EAttribute)getPackageDirectiveSuffix().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getConflictAnnotation()
  {
    if (conflictAnnotationEClass == null)
    {
      conflictAnnotationEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(ProcessorDslPackage.eNS_URI).getEClassifiers().get(90);
    }
    return conflictAnnotationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getStaticAnnotation()
  {
    if (staticAnnotationEClass == null)
    {
      staticAnnotationEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(ProcessorDslPackage.eNS_URI).getEClassifiers().get(91);
    }
    return staticAnnotationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getConstructorAnnotation()
  {
    if (constructorAnnotationEClass == null)
    {
      constructorAnnotationEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(ProcessorDslPackage.eNS_URI).getEClassifiers().get(92);
    }
    return constructorAnnotationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getStandardAnnotation()
  {
    if (standardAnnotationEClass == null)
    {
      standardAnnotationEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(ProcessorDslPackage.eNS_URI).getEClassifiers().get(93);
    }
    return standardAnnotationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPojoDirectiveFinal()
  {
    if (pojoDirectiveFinalEClass == null)
    {
      pojoDirectiveFinalEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(ProcessorDslPackage.eNS_URI).getEClassifiers().get(94);
    }
    return pojoDirectiveFinalEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPojoDirectiveAbstract()
  {
    if (pojoDirectiveAbstractEClass == null)
    {
      pojoDirectiveAbstractEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(ProcessorDslPackage.eNS_URI).getEClassifiers().get(95);
    }
    return pojoDirectiveAbstractEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPojoDirectiveExtends()
  {
    if (pojoDirectiveExtendsEClass == null)
    {
      pojoDirectiveExtendsEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(ProcessorDslPackage.eNS_URI).getEClassifiers().get(96);
    }
    return pojoDirectiveExtendsEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPojoDirectiveExtends_SuperType()
  {
        return (EReference)getPojoDirectiveExtends().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPojoDirectiveDiscriminator()
  {
    if (pojoDirectiveDiscriminatorEClass == null)
    {
      pojoDirectiveDiscriminatorEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(ProcessorDslPackage.eNS_URI).getEClassifiers().get(97);
    }
    return pojoDirectiveDiscriminatorEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getPojoDirectiveDiscriminator_Discriminator()
  {
        return (EAttribute)getPojoDirectiveDiscriminator().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPojoDirectiveOperators()
  {
    if (pojoDirectiveOperatorsEClass == null)
    {
      pojoDirectiveOperatorsEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(ProcessorDslPackage.eNS_URI).getEClassifiers().get(98);
    }
    return pojoDirectiveOperatorsEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getPojoDirectiveOperators_OperatorsSuffix()
  {
        return (EAttribute)getPojoDirectiveOperators().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPojoDirectiveSerializable()
  {
    if (pojoDirectiveSerializableEClass == null)
    {
      pojoDirectiveSerializableEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(ProcessorDslPackage.eNS_URI).getEClassifiers().get(99);
    }
    return pojoDirectiveSerializableEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getPojoDirectiveSerializable_Sernum()
  {
        return (EAttribute)getPojoDirectiveSerializable().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPojoDirectiveEquals()
  {
    if (pojoDirectiveEqualsEClass == null)
    {
      pojoDirectiveEqualsEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(ProcessorDslPackage.eNS_URI).getEClassifiers().get(100);
    }
    return pojoDirectiveEqualsEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPojoDirectiveEquals_Proplist()
  {
        return (EReference)getPojoDirectiveEquals().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPojoDirectiveHashCode()
  {
    if (pojoDirectiveHashCodeEClass == null)
    {
      pojoDirectiveHashCodeEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(ProcessorDslPackage.eNS_URI).getEClassifiers().get(101);
    }
    return pojoDirectiveHashCodeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPojoDirectiveHashCode_Proplist()
  {
        return (EReference)getPojoDirectiveHashCode().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPojoDirectiveToInit()
  {
    if (pojoDirectiveToInitEClass == null)
    {
      pojoDirectiveToInitEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(ProcessorDslPackage.eNS_URI).getEClassifiers().get(102);
    }
    return pojoDirectiveToInitEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPojoDirectiveToInit_Proplist()
  {
        return (EReference)getPojoDirectiveToInit().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPojoDirectiveEnumInit()
  {
    if (pojoDirectiveEnumInitEClass == null)
    {
      pojoDirectiveEnumInitEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(ProcessorDslPackage.eNS_URI).getEClassifiers().get(103);
    }
    return pojoDirectiveEnumInitEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPojoDirectiveEnumInit_Proplist()
  {
        return (EReference)getPojoDirectiveEnumInit().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPojoDirectiveIsDef()
  {
    if (pojoDirectiveIsDefEClass == null)
    {
      pojoDirectiveIsDefEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(ProcessorDslPackage.eNS_URI).getEClassifiers().get(104);
    }
    return pojoDirectiveIsDefEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPojoDirectiveIsDef_Proplist()
  {
        return (EReference)getPojoDirectiveIsDef().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPojoDirectiveEnumDef()
  {
    if (pojoDirectiveEnumDefEClass == null)
    {
      pojoDirectiveEnumDefEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(ProcessorDslPackage.eNS_URI).getEClassifiers().get(105);
    }
    return pojoDirectiveEnumDefEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPojoDirectiveEnumDef_Proplist()
  {
        return (EReference)getPojoDirectiveEnumDef().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPojoDirectiveToString()
  {
    if (pojoDirectiveToStringEClass == null)
    {
      pojoDirectiveToStringEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(ProcessorDslPackage.eNS_URI).getEClassifiers().get(106);
    }
    return pojoDirectiveToStringEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPojoDirectiveToString_Proplist()
  {
        return (EReference)getPojoDirectiveToString().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPojoDirectiveIndex()
  {
    if (pojoDirectiveIndexEClass == null)
    {
      pojoDirectiveIndexEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(ProcessorDslPackage.eNS_URI).getEClassifiers().get(107);
    }
    return pojoDirectiveIndexEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getPojoDirectiveIndex_Index()
  {
        return (EAttribute)getPojoDirectiveIndex().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPojoDirectiveIndex_Proplist()
  {
        return (EReference)getPojoDirectiveIndex().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSetterAnnotation()
  {
    if (setterAnnotationEClass == null)
    {
      setterAnnotationEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(ProcessorDslPackage.eNS_URI).getEClassifiers().get(108);
    }
    return setterAnnotationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getGetterAnnotation()
  {
    if (getterAnnotationEClass == null)
    {
      getterAnnotationEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(ProcessorDslPackage.eNS_URI).getEClassifiers().get(109);
    }
    return getterAnnotationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAttributeAnnotation()
  {
    if (attributeAnnotationEClass == null)
    {
      attributeAnnotationEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(ProcessorDslPackage.eNS_URI).getEClassifiers().get(110);
    }
    return attributeAnnotationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPojoPropertyDirectiveRequired()
  {
    if (pojoPropertyDirectiveRequiredEClass == null)
    {
      pojoPropertyDirectiveRequiredEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(ProcessorDslPackage.eNS_URI).getEClassifiers().get(111);
    }
    return pojoPropertyDirectiveRequiredEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPojoPropertyDirectivePrimaryKey()
  {
    if (pojoPropertyDirectivePrimaryKeyEClass == null)
    {
      pojoPropertyDirectivePrimaryKeyEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(ProcessorDslPackage.eNS_URI).getEClassifiers().get(112);
    }
    return pojoPropertyDirectivePrimaryKeyEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPojoPropertyDirectiveDiscriminator()
  {
    if (pojoPropertyDirectiveDiscriminatorEClass == null)
    {
      pojoPropertyDirectiveDiscriminatorEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(ProcessorDslPackage.eNS_URI).getEClassifiers().get(113);
    }
    return pojoPropertyDirectiveDiscriminatorEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getPojoPropertyDirectiveDiscriminator_Discriminator()
  {
        return (EAttribute)getPojoPropertyDirectiveDiscriminator().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPojoPropertyDirectiveIndex()
  {
    if (pojoPropertyDirectiveIndexEClass == null)
    {
      pojoPropertyDirectiveIndexEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(ProcessorDslPackage.eNS_URI).getEClassifiers().get(114);
    }
    return pojoPropertyDirectiveIndexEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getPojoPropertyDirectiveIndex_Index()
  {
        return (EAttribute)getPojoPropertyDirectiveIndex().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPojoPropertyDirectiveVersion()
  {
    if (pojoPropertyDirectiveVersionEClass == null)
    {
      pojoPropertyDirectiveVersionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(ProcessorDslPackage.eNS_URI).getEClassifiers().get(115);
    }
    return pojoPropertyDirectiveVersionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPojoPropertyDirectiveUpdateCol()
  {
    if (pojoPropertyDirectiveUpdateColEClass == null)
    {
      pojoPropertyDirectiveUpdateColEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(ProcessorDslPackage.eNS_URI).getEClassifiers().get(116);
    }
    return pojoPropertyDirectiveUpdateColEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getPojoPropertyDirectiveUpdateCol_UpdateColumn1()
  {
        return (EAttribute)getPojoPropertyDirectiveUpdateCol().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getPojoPropertyDirectiveUpdateCol_UpdateColumn2()
  {
        return (EAttribute)getPojoPropertyDirectiveUpdateCol().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPojoPropertyDirectiveCreateCol()
  {
    if (pojoPropertyDirectiveCreateColEClass == null)
    {
      pojoPropertyDirectiveCreateColEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(ProcessorDslPackage.eNS_URI).getEClassifiers().get(117);
    }
    return pojoPropertyDirectiveCreateColEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getPojoPropertyDirectiveCreateCol_CreateColumn1()
  {
        return (EAttribute)getPojoPropertyDirectiveCreateCol().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getPojoPropertyDirectiveCreateCol_CreateColumn2()
  {
        return (EAttribute)getPojoPropertyDirectiveCreateCol().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getEnumDirectiveFinal()
  {
    if (enumDirectiveFinalEClass == null)
    {
      enumDirectiveFinalEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(ProcessorDslPackage.eNS_URI).getEClassifiers().get(118);
    }
    return enumDirectiveFinalEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getEnumDirectiveExtends()
  {
    if (enumDirectiveExtendsEClass == null)
    {
      enumDirectiveExtendsEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(ProcessorDslPackage.eNS_URI).getEClassifiers().get(119);
    }
    return enumDirectiveExtendsEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getEnumDirectiveExtends_SuperType()
  {
        return (EReference)getEnumDirectiveExtends().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getEnumDirectiveSerializable()
  {
    if (enumDirectiveSerializableEClass == null)
    {
      enumDirectiveSerializableEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(ProcessorDslPackage.eNS_URI).getEClassifiers().get(120);
    }
    return enumDirectiveSerializableEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getEnumDirectiveSerializable_Sernum()
  {
        return (EAttribute)getEnumDirectiveSerializable().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getEnumPropertyDirectiveValues()
  {
    if (enumPropertyDirectiveValuesEClass == null)
    {
      enumPropertyDirectiveValuesEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(ProcessorDslPackage.eNS_URI).getEClassifiers().get(121);
    }
    return enumPropertyDirectiveValuesEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getEnumPropertyDirectiveValues_Values()
  {
        return (EReference)getEnumPropertyDirectiveValues().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getDaoDirectiveFinal()
  {
    if (daoDirectiveFinalEClass == null)
    {
      daoDirectiveFinalEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(ProcessorDslPackage.eNS_URI).getEClassifiers().get(122);
    }
    return daoDirectiveFinalEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getDaoDirectiveAbstract()
  {
    if (daoDirectiveAbstractEClass == null)
    {
      daoDirectiveAbstractEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(ProcessorDslPackage.eNS_URI).getEClassifiers().get(123);
    }
    return daoDirectiveAbstractEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getDaoDirectiveExtends()
  {
    if (daoDirectiveExtendsEClass == null)
    {
      daoDirectiveExtendsEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(ProcessorDslPackage.eNS_URI).getEClassifiers().get(124);
    }
    return daoDirectiveExtendsEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getDaoDirectiveExtends_SuperType()
  {
        return (EReference)getDaoDirectiveExtends().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getDaoDirectiveSerializable()
  {
    if (daoDirectiveSerializableEClass == null)
    {
      daoDirectiveSerializableEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(ProcessorDslPackage.eNS_URI).getEClassifiers().get(125);
    }
    return daoDirectiveSerializableEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getDaoDirectiveSerializable_Sernum()
  {
        return (EAttribute)getDaoDirectiveSerializable().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getDaoDirectiveDiscriminator()
  {
    if (daoDirectiveDiscriminatorEClass == null)
    {
      daoDirectiveDiscriminatorEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(ProcessorDslPackage.eNS_URI).getEClassifiers().get(126);
    }
    return daoDirectiveDiscriminatorEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getDaoDirectiveDiscriminator_Ancestor()
  {
        return (EReference)getDaoDirectiveDiscriminator().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getDaoDirectiveDiscriminator_Descendants()
  {
        return (EReference)getDaoDirectiveDiscriminator().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getDaoDirectivePojo()
  {
    if (daoDirectivePojoEClass == null)
    {
      daoDirectivePojoEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(ProcessorDslPackage.eNS_URI).getEClassifiers().get(127);
    }
    return daoDirectivePojoEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getDaoDirectivePojo_Pojo()
  {
        return (EReference)getDaoDirectivePojo().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getDaoDirectiveGenerics()
  {
    if (daoDirectiveGenericsEClass == null)
    {
      daoDirectiveGenericsEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(ProcessorDslPackage.eNS_URI).getEClassifiers().get(128);
    }
    return daoDirectiveGenericsEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getDaoDirectiveGenerics_Generics()
  {
        return (EReference)getDaoDirectiveGenerics().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getDaoDirectiveProcedure()
  {
    if (daoDirectiveProcedureEClass == null)
    {
      daoDirectiveProcedureEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(ProcessorDslPackage.eNS_URI).getEClassifiers().get(129);
    }
    return daoDirectiveProcedureEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getDaoDirectiveProcedure_Pojo()
  {
        return (EReference)getDaoDirectiveProcedure().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getDaoDirectiveFunction()
  {
    if (daoDirectiveFunctionEClass == null)
    {
      daoDirectiveFunctionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(ProcessorDslPackage.eNS_URI).getEClassifiers().get(130);
    }
    return daoDirectiveFunctionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getDaoDirectiveFunction_Pojo()
  {
        return (EReference)getDaoDirectiveFunction().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getDaoDirectiveUpdate()
  {
    if (daoDirectiveUpdateEClass == null)
    {
      daoDirectiveUpdateEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(ProcessorDslPackage.eNS_URI).getEClassifiers().get(131);
    }
    return daoDirectiveUpdateEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getDaoDirectiveUpdate_Paramlist()
  {
        return (EReference)getDaoDirectiveUpdate().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ProcessorDslFactory getProcessorDslFactory()
  {
    return (ProcessorDslFactory)getEFactoryInstance();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isLoaded = false;

  /**
   * Laods the package and any sub-packages from their serialized form.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void loadPackage()
  {
    if (isLoaded) return;
    isLoaded = true;

    URL url = getClass().getResource(packageFilename);
    if (url == null)
    {
      throw new RuntimeException("Missing serialized package: " + packageFilename);
    }
    URI uri = URI.createURI(url.toString());
    Resource resource = new EcoreResourceFactoryImpl().createResource(uri);
    try
    {
      resource.load(null);
    }
    catch (IOException exception)
    {
      throw new WrappedException(exception);
    }
    initializeFromLoadedEPackage(this, (EPackage)resource.getContents().get(0));
    createResource(eNS_URI);
  }


  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isFixed = false;

  /**
   * Fixes up the loaded package, to make it appear as if it had been programmatically built.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void fixPackageContents()
  {
    if (isFixed) return;
    isFixed = true;
    fixEClassifiers();
  }

  /**
   * Sets the instance class on the given classifier.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected void fixInstanceClass(EClassifier eClassifier)
  {
    if (eClassifier.getInstanceClassName() == null)
    {
      eClassifier.setInstanceClassName("org.sqlproc.dsl.processorDsl." + eClassifier.getName());
      setGeneratedClassName(eClassifier);
    }
  }

} //ProcessorDslPackageImpl
