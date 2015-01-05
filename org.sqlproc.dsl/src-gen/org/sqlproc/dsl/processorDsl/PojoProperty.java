/**
 */
package org.sqlproc.dsl.processorDsl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Pojo Property</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.sqlproc.dsl.processorDsl.PojoProperty#getAnnotations <em>Annotations</em>}</li>
 *   <li>{@link org.sqlproc.dsl.processorDsl.PojoProperty#getDirectives <em>Directives</em>}</li>
 *   <li>{@link org.sqlproc.dsl.processorDsl.PojoProperty#getName <em>Name</em>}</li>
 *   <li>{@link org.sqlproc.dsl.processorDsl.PojoProperty#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.sqlproc.dsl.processorDsl.ProcessorDslPackage#getPojoProperty()
 * @model
 * @generated
 */
public interface PojoProperty extends EObject
{
  /**
   * Returns the value of the '<em><b>Annotations</b></em>' containment reference list.
   * The list contents are of type {@link org.sqlproc.dsl.processorDsl.PojoPropertyAnnotation}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Annotations</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Annotations</em>' containment reference list.
   * @see org.sqlproc.dsl.processorDsl.ProcessorDslPackage#getPojoProperty_Annotations()
   * @model containment="true"
   * @generated
   */
  EList<PojoPropertyAnnotation> getAnnotations();

  /**
   * Returns the value of the '<em><b>Directives</b></em>' containment reference list.
   * The list contents are of type {@link org.sqlproc.dsl.processorDsl.PojoPropertyDirective}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Directives</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Directives</em>' containment reference list.
   * @see org.sqlproc.dsl.processorDsl.ProcessorDslPackage#getPojoProperty_Directives()
   * @model containment="true"
   * @generated
   */
  EList<PojoPropertyDirective> getDirectives();

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
   * @see org.sqlproc.dsl.processorDsl.ProcessorDslPackage#getPojoProperty_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.sqlproc.dsl.processorDsl.PojoProperty#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Type</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type</em>' containment reference.
   * @see #setType(PojoType)
   * @see org.sqlproc.dsl.processorDsl.ProcessorDslPackage#getPojoProperty_Type()
   * @model containment="true"
   * @generated
   */
  PojoType getType();

  /**
   * Sets the value of the '{@link org.sqlproc.dsl.processorDsl.PojoProperty#getType <em>Type</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type</em>' containment reference.
   * @see #getType()
   * @generated
   */
  void setType(PojoType value);

} // PojoProperty
