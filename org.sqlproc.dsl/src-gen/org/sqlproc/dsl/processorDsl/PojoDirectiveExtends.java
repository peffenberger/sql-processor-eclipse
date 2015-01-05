/**
 */
package org.sqlproc.dsl.processorDsl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Pojo Directive Extends</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.sqlproc.dsl.processorDsl.PojoDirectiveExtends#getSuperType <em>Super Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.sqlproc.dsl.processorDsl.ProcessorDslPackage#getPojoDirectiveExtends()
 * @model
 * @generated
 */
public interface PojoDirectiveExtends extends PojoDirective
{
  /**
   * Returns the value of the '<em><b>Super Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Super Type</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Super Type</em>' containment reference.
   * @see #setSuperType(PojoType)
   * @see org.sqlproc.dsl.processorDsl.ProcessorDslPackage#getPojoDirectiveExtends_SuperType()
   * @model containment="true"
   * @generated
   */
  PojoType getSuperType();

  /**
   * Sets the value of the '{@link org.sqlproc.dsl.processorDsl.PojoDirectiveExtends#getSuperType <em>Super Type</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Super Type</em>' containment reference.
   * @see #getSuperType()
   * @generated
   */
  void setSuperType(PojoType value);

} // PojoDirectiveExtends
