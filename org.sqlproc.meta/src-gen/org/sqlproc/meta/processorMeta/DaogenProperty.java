/**
 */
package org.sqlproc.meta.processorMeta;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Daogen Property</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.sqlproc.meta.processorMeta.DaogenProperty#getName <em>Name</em>}</li>
 *   <li>{@link org.sqlproc.meta.processorMeta.DaogenProperty#getDbTables <em>Db Tables</em>}</li>
 *   <li>{@link org.sqlproc.meta.processorMeta.DaogenProperty#getToImplements <em>To Implements</em>}</li>
 *   <li>{@link org.sqlproc.meta.processorMeta.DaogenProperty#getToExtends <em>To Extends</em>}</li>
 *   <li>{@link org.sqlproc.meta.processorMeta.DaogenProperty#getToImplementsGenerics <em>To Implements Generics</em>}</li>
 *   <li>{@link org.sqlproc.meta.processorMeta.DaogenProperty#getToExtendsGenerics <em>To Extends Generics</em>}</li>
 *   <li>{@link org.sqlproc.meta.processorMeta.DaogenProperty#getDbFunction <em>Db Function</em>}</li>
 *   <li>{@link org.sqlproc.meta.processorMeta.DaogenProperty#getResultType <em>Result Type</em>}</li>
 *   <li>{@link org.sqlproc.meta.processorMeta.DaogenProperty#getDebug <em>Debug</em>}</li>
 *   <li>{@link org.sqlproc.meta.processorMeta.DaogenProperty#getActiveFilter <em>Active Filter</em>}</li>
 *   <li>{@link org.sqlproc.meta.processorMeta.DaogenProperty#getPckg <em>Pckg</em>}</li>
 *   <li>{@link org.sqlproc.meta.processorMeta.DaogenProperty#getImplPckg <em>Impl Pckg</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.sqlproc.meta.processorMeta.ProcessorMetaPackage#getDaogenProperty()
 * @model
 * @generated
 */
public interface DaogenProperty extends EObject
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see org.sqlproc.meta.processorMeta.ProcessorMetaPackage#getDaogenProperty_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.sqlproc.meta.processorMeta.DaogenProperty#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Db Tables</b></em>' attribute list.
   * The list contents are of type {@link java.lang.String}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Db Tables</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Db Tables</em>' attribute list.
   * @see org.sqlproc.meta.processorMeta.ProcessorMetaPackage#getDaogenProperty_DbTables()
   * @model unique="false"
   * @generated
   */
  EList<String> getDbTables();

  /**
   * Returns the value of the '<em><b>To Implements</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>To Implements</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>To Implements</em>' containment reference.
   * @see #setToImplements(ImplementsAssignement)
   * @see org.sqlproc.meta.processorMeta.ProcessorMetaPackage#getDaogenProperty_ToImplements()
   * @model containment="true"
   * @generated
   */
  ImplementsAssignement getToImplements();

  /**
   * Sets the value of the '{@link org.sqlproc.meta.processorMeta.DaogenProperty#getToImplements <em>To Implements</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>To Implements</em>' containment reference.
   * @see #getToImplements()
   * @generated
   */
  void setToImplements(ImplementsAssignement value);

  /**
   * Returns the value of the '<em><b>To Extends</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>To Extends</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>To Extends</em>' containment reference.
   * @see #setToExtends(ExtendsAssignement)
   * @see org.sqlproc.meta.processorMeta.ProcessorMetaPackage#getDaogenProperty_ToExtends()
   * @model containment="true"
   * @generated
   */
  ExtendsAssignement getToExtends();

  /**
   * Sets the value of the '{@link org.sqlproc.meta.processorMeta.DaogenProperty#getToExtends <em>To Extends</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>To Extends</em>' containment reference.
   * @see #getToExtends()
   * @generated
   */
  void setToExtends(ExtendsAssignement value);

  /**
   * Returns the value of the '<em><b>To Implements Generics</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>To Implements Generics</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>To Implements Generics</em>' containment reference.
   * @see #setToImplementsGenerics(ImplementsAssignementGenerics)
   * @see org.sqlproc.meta.processorMeta.ProcessorMetaPackage#getDaogenProperty_ToImplementsGenerics()
   * @model containment="true"
   * @generated
   */
  ImplementsAssignementGenerics getToImplementsGenerics();

  /**
   * Sets the value of the '{@link org.sqlproc.meta.processorMeta.DaogenProperty#getToImplementsGenerics <em>To Implements Generics</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>To Implements Generics</em>' containment reference.
   * @see #getToImplementsGenerics()
   * @generated
   */
  void setToImplementsGenerics(ImplementsAssignementGenerics value);

  /**
   * Returns the value of the '<em><b>To Extends Generics</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>To Extends Generics</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>To Extends Generics</em>' containment reference.
   * @see #setToExtendsGenerics(ExtendsAssignementGenerics)
   * @see org.sqlproc.meta.processorMeta.ProcessorMetaPackage#getDaogenProperty_ToExtendsGenerics()
   * @model containment="true"
   * @generated
   */
  ExtendsAssignementGenerics getToExtendsGenerics();

  /**
   * Sets the value of the '{@link org.sqlproc.meta.processorMeta.DaogenProperty#getToExtendsGenerics <em>To Extends Generics</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>To Extends Generics</em>' containment reference.
   * @see #getToExtendsGenerics()
   * @generated
   */
  void setToExtendsGenerics(ExtendsAssignementGenerics value);

  /**
   * Returns the value of the '<em><b>Db Function</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Db Function</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Db Function</em>' attribute.
   * @see #setDbFunction(String)
   * @see org.sqlproc.meta.processorMeta.ProcessorMetaPackage#getDaogenProperty_DbFunction()
   * @model
   * @generated
   */
  String getDbFunction();

  /**
   * Sets the value of the '{@link org.sqlproc.meta.processorMeta.DaogenProperty#getDbFunction <em>Db Function</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Db Function</em>' attribute.
   * @see #getDbFunction()
   * @generated
   */
  void setDbFunction(String value);

  /**
   * Returns the value of the '<em><b>Result Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Result Type</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Result Type</em>' containment reference.
   * @see #setResultType(PojoType)
   * @see org.sqlproc.meta.processorMeta.ProcessorMetaPackage#getDaogenProperty_ResultType()
   * @model containment="true"
   * @generated
   */
  PojoType getResultType();

  /**
   * Sets the value of the '{@link org.sqlproc.meta.processorMeta.DaogenProperty#getResultType <em>Result Type</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Result Type</em>' containment reference.
   * @see #getResultType()
   * @generated
   */
  void setResultType(PojoType value);

  /**
   * Returns the value of the '<em><b>Debug</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Debug</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Debug</em>' containment reference.
   * @see #setDebug(DebugLevelAssignement)
   * @see org.sqlproc.meta.processorMeta.ProcessorMetaPackage#getDaogenProperty_Debug()
   * @model containment="true"
   * @generated
   */
  DebugLevelAssignement getDebug();

  /**
   * Sets the value of the '{@link org.sqlproc.meta.processorMeta.DaogenProperty#getDebug <em>Debug</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Debug</em>' containment reference.
   * @see #getDebug()
   * @generated
   */
  void setDebug(DebugLevelAssignement value);

  /**
   * Returns the value of the '<em><b>Active Filter</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Active Filter</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Active Filter</em>' containment reference.
   * @see #setActiveFilter(ValueType)
   * @see org.sqlproc.meta.processorMeta.ProcessorMetaPackage#getDaogenProperty_ActiveFilter()
   * @model containment="true"
   * @generated
   */
  ValueType getActiveFilter();

  /**
   * Sets the value of the '{@link org.sqlproc.meta.processorMeta.DaogenProperty#getActiveFilter <em>Active Filter</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Active Filter</em>' containment reference.
   * @see #getActiveFilter()
   * @generated
   */
  void setActiveFilter(ValueType value);

  /**
   * Returns the value of the '<em><b>Pckg</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Pckg</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Pckg</em>' attribute.
   * @see #setPckg(String)
   * @see org.sqlproc.meta.processorMeta.ProcessorMetaPackage#getDaogenProperty_Pckg()
   * @model
   * @generated
   */
  String getPckg();

  /**
   * Sets the value of the '{@link org.sqlproc.meta.processorMeta.DaogenProperty#getPckg <em>Pckg</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Pckg</em>' attribute.
   * @see #getPckg()
   * @generated
   */
  void setPckg(String value);

  /**
   * Returns the value of the '<em><b>Impl Pckg</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Impl Pckg</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Impl Pckg</em>' attribute.
   * @see #setImplPckg(String)
   * @see org.sqlproc.meta.processorMeta.ProcessorMetaPackage#getDaogenProperty_ImplPckg()
   * @model
   * @generated
   */
  String getImplPckg();

  /**
   * Sets the value of the '{@link org.sqlproc.meta.processorMeta.DaogenProperty#getImplPckg <em>Impl Pckg</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Impl Pckg</em>' attribute.
   * @see #getImplPckg()
   * @generated
   */
  void setImplPckg(String value);

} // DaogenProperty
