/**
 */
package org.sqlproc.dsl.processorDsl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Dao Directive Extends</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.sqlproc.dsl.processorDsl.DaoDirectiveExtends#getSuperType <em>Super Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.sqlproc.dsl.processorDsl.ProcessorDslPackage#getDaoDirectiveExtends()
 * @model
 * @generated
 */
public interface DaoDirectiveExtends extends DaoDirective
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
   * @see #setSuperType(DaoType)
   * @see org.sqlproc.dsl.processorDsl.ProcessorDslPackage#getDaoDirectiveExtends_SuperType()
   * @model containment="true"
   * @generated
   */
  DaoType getSuperType();

  /**
   * Sets the value of the '{@link org.sqlproc.dsl.processorDsl.DaoDirectiveExtends#getSuperType <em>Super Type</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Super Type</em>' containment reference.
   * @see #getSuperType()
   * @generated
   */
  void setSuperType(DaoType value);

} // DaoDirectiveExtends
