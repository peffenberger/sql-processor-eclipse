/**
 */
package org.sqlproc.dsl.processorDsl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Pojo Directive To Init</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.sqlproc.dsl.processorDsl.PojoDirectiveToInit#getProplist <em>Proplist</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.sqlproc.dsl.processorDsl.ProcessorDslPackage#getPojoDirectiveToInit()
 * @model
 * @generated
 */
public interface PojoDirectiveToInit extends PojoDirective
{
  /**
   * Returns the value of the '<em><b>Proplist</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Proplist</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Proplist</em>' containment reference.
   * @see #setProplist(DirectiveProperties)
   * @see org.sqlproc.dsl.processorDsl.ProcessorDslPackage#getPojoDirectiveToInit_Proplist()
   * @model containment="true"
   * @generated
   */
  DirectiveProperties getProplist();

  /**
   * Sets the value of the '{@link org.sqlproc.dsl.processorDsl.PojoDirectiveToInit#getProplist <em>Proplist</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Proplist</em>' containment reference.
   * @see #getProplist()
   * @generated
   */
  void setProplist(DirectiveProperties value);

} // PojoDirectiveToInit
