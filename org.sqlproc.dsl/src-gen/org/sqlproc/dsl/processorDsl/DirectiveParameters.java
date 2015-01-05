/**
 */
package org.sqlproc.dsl.processorDsl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Directive Parameters</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.sqlproc.dsl.processorDsl.DirectiveParameters#getIn <em>In</em>}</li>
 *   <li>{@link org.sqlproc.dsl.processorDsl.DirectiveParameters#getOut <em>Out</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.sqlproc.dsl.processorDsl.ProcessorDslPackage#getDirectiveParameters()
 * @model
 * @generated
 */
public interface DirectiveParameters extends EObject
{
  /**
   * Returns the value of the '<em><b>In</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>In</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>In</em>' containment reference.
   * @see #setIn(PojoType)
   * @see org.sqlproc.dsl.processorDsl.ProcessorDslPackage#getDirectiveParameters_In()
   * @model containment="true"
   * @generated
   */
  PojoType getIn();

  /**
   * Sets the value of the '{@link org.sqlproc.dsl.processorDsl.DirectiveParameters#getIn <em>In</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>In</em>' containment reference.
   * @see #getIn()
   * @generated
   */
  void setIn(PojoType value);

  /**
   * Returns the value of the '<em><b>Out</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Out</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Out</em>' containment reference.
   * @see #setOut(PojoType)
   * @see org.sqlproc.dsl.processorDsl.ProcessorDslPackage#getDirectiveParameters_Out()
   * @model containment="true"
   * @generated
   */
  PojoType getOut();

  /**
   * Sets the value of the '{@link org.sqlproc.dsl.processorDsl.DirectiveParameters#getOut <em>Out</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Out</em>' containment reference.
   * @see #getOut()
   * @generated
   */
  void setOut(PojoType value);

} // DirectiveParameters
