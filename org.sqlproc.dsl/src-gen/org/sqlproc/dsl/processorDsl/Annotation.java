/**
 */
package org.sqlproc.dsl.processorDsl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Annotation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.sqlproc.dsl.processorDsl.Annotation#getType <em>Type</em>}</li>
 *   <li>{@link org.sqlproc.dsl.processorDsl.Annotation#getFeatures <em>Features</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.sqlproc.dsl.processorDsl.ProcessorDslPackage#getAnnotation()
 * @model
 * @generated
 */
public interface Annotation extends EObject
{
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
   * @see org.sqlproc.dsl.processorDsl.ProcessorDslPackage#getAnnotation_Type()
   * @model containment="true"
   * @generated
   */
  PojoType getType();

  /**
   * Sets the value of the '{@link org.sqlproc.dsl.processorDsl.Annotation#getType <em>Type</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type</em>' containment reference.
   * @see #getType()
   * @generated
   */
  void setType(PojoType value);

  /**
   * Returns the value of the '<em><b>Features</b></em>' containment reference list.
   * The list contents are of type {@link org.sqlproc.dsl.processorDsl.AnnotationProperty}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Features</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Features</em>' containment reference list.
   * @see org.sqlproc.dsl.processorDsl.ProcessorDslPackage#getAnnotation_Features()
   * @model containment="true"
   * @generated
   */
  EList<AnnotationProperty> getFeatures();

} // Annotation
