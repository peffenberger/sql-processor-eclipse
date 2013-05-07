/**
 */
package org.sqlproc.dsl.processorDsl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Pojo Annotated Property</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.sqlproc.dsl.processorDsl.PojoAnnotatedProperty#getSetterAnnotation <em>Setter Annotation</em>}</li>
 *   <li>{@link org.sqlproc.dsl.processorDsl.PojoAnnotatedProperty#getGetterAnnotation <em>Getter Annotation</em>}</li>
 *   <li>{@link org.sqlproc.dsl.processorDsl.PojoAnnotatedProperty#getAttributeAnnotation <em>Attribute Annotation</em>}</li>
 *   <li>{@link org.sqlproc.dsl.processorDsl.PojoAnnotatedProperty#getFeature <em>Feature</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.sqlproc.dsl.processorDsl.ProcessorDslPackage#getPojoAnnotatedProperty()
 * @model
 * @generated
 */
public interface PojoAnnotatedProperty extends EObject
{
  /**
   * Returns the value of the '<em><b>Setter Annotation</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Setter Annotation</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Setter Annotation</em>' containment reference.
   * @see #setSetterAnnotation(Annotation)
   * @see org.sqlproc.dsl.processorDsl.ProcessorDslPackage#getPojoAnnotatedProperty_SetterAnnotation()
   * @model containment="true"
   * @generated
   */
  Annotation getSetterAnnotation();

  /**
   * Sets the value of the '{@link org.sqlproc.dsl.processorDsl.PojoAnnotatedProperty#getSetterAnnotation <em>Setter Annotation</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Setter Annotation</em>' containment reference.
   * @see #getSetterAnnotation()
   * @generated
   */
  void setSetterAnnotation(Annotation value);

  /**
   * Returns the value of the '<em><b>Getter Annotation</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Getter Annotation</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Getter Annotation</em>' containment reference.
   * @see #setGetterAnnotation(Annotation)
   * @see org.sqlproc.dsl.processorDsl.ProcessorDslPackage#getPojoAnnotatedProperty_GetterAnnotation()
   * @model containment="true"
   * @generated
   */
  Annotation getGetterAnnotation();

  /**
   * Sets the value of the '{@link org.sqlproc.dsl.processorDsl.PojoAnnotatedProperty#getGetterAnnotation <em>Getter Annotation</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Getter Annotation</em>' containment reference.
   * @see #getGetterAnnotation()
   * @generated
   */
  void setGetterAnnotation(Annotation value);

  /**
   * Returns the value of the '<em><b>Attribute Annotation</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Attribute Annotation</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Attribute Annotation</em>' containment reference.
   * @see #setAttributeAnnotation(Annotation)
   * @see org.sqlproc.dsl.processorDsl.ProcessorDslPackage#getPojoAnnotatedProperty_AttributeAnnotation()
   * @model containment="true"
   * @generated
   */
  Annotation getAttributeAnnotation();

  /**
   * Sets the value of the '{@link org.sqlproc.dsl.processorDsl.PojoAnnotatedProperty#getAttributeAnnotation <em>Attribute Annotation</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Attribute Annotation</em>' containment reference.
   * @see #getAttributeAnnotation()
   * @generated
   */
  void setAttributeAnnotation(Annotation value);

  /**
   * Returns the value of the '<em><b>Feature</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Feature</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Feature</em>' containment reference.
   * @see #setFeature(PojoProperty)
   * @see org.sqlproc.dsl.processorDsl.ProcessorDslPackage#getPojoAnnotatedProperty_Feature()
   * @model containment="true"
   * @generated
   */
  PojoProperty getFeature();

  /**
   * Sets the value of the '{@link org.sqlproc.dsl.processorDsl.PojoAnnotatedProperty#getFeature <em>Feature</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Feature</em>' containment reference.
   * @see #getFeature()
   * @generated
   */
  void setFeature(PojoProperty value);

} // PojoAnnotatedProperty
