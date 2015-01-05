/**
 */
package org.sqlproc.dsl.processorDsl;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Extends</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.sqlproc.dsl.processorDsl.Extends#getExtends <em>Extends</em>}</li>
 *   <li>{@link org.sqlproc.dsl.processorDsl.Extends#isGenerics <em>Generics</em>}</li>
 *   <li>{@link org.sqlproc.dsl.processorDsl.Extends#getOnlyPojos <em>Only Pojos</em>}</li>
 *   <li>{@link org.sqlproc.dsl.processorDsl.Extends#getOnlyDaos <em>Only Daos</em>}</li>
 *   <li>{@link org.sqlproc.dsl.processorDsl.Extends#getExceptPojos <em>Except Pojos</em>}</li>
 *   <li>{@link org.sqlproc.dsl.processorDsl.Extends#getExceptDaos <em>Except Daos</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.sqlproc.dsl.processorDsl.ProcessorDslPackage#getExtends()
 * @model
 * @generated
 */
public interface Extends extends AbstractEntity
{
  /**
   * Returns the value of the '<em><b>Extends</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Extends</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Extends</em>' containment reference.
   * @see #setExtends(PojoType)
   * @see org.sqlproc.dsl.processorDsl.ProcessorDslPackage#getExtends_Extends()
   * @model containment="true"
   * @generated
   */
  PojoType getExtends();

  /**
   * Sets the value of the '{@link org.sqlproc.dsl.processorDsl.Extends#getExtends <em>Extends</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Extends</em>' containment reference.
   * @see #getExtends()
   * @generated
   */
  void setExtends(PojoType value);

  /**
   * Returns the value of the '<em><b>Generics</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Generics</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Generics</em>' attribute.
   * @see #setGenerics(boolean)
   * @see org.sqlproc.dsl.processorDsl.ProcessorDslPackage#getExtends_Generics()
   * @model
   * @generated
   */
  boolean isGenerics();

  /**
   * Sets the value of the '{@link org.sqlproc.dsl.processorDsl.Extends#isGenerics <em>Generics</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Generics</em>' attribute.
   * @see #isGenerics()
   * @generated
   */
  void setGenerics(boolean value);

  /**
   * Returns the value of the '<em><b>Only Pojos</b></em>' reference list.
   * The list contents are of type {@link org.sqlproc.dsl.processorDsl.PojoEntity}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Only Pojos</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Only Pojos</em>' reference list.
   * @see org.sqlproc.dsl.processorDsl.ProcessorDslPackage#getExtends_OnlyPojos()
   * @model
   * @generated
   */
  EList<PojoEntity> getOnlyPojos();

  /**
   * Returns the value of the '<em><b>Only Daos</b></em>' reference list.
   * The list contents are of type {@link org.sqlproc.dsl.processorDsl.PojoDao}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Only Daos</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Only Daos</em>' reference list.
   * @see org.sqlproc.dsl.processorDsl.ProcessorDslPackage#getExtends_OnlyDaos()
   * @model
   * @generated
   */
  EList<PojoDao> getOnlyDaos();

  /**
   * Returns the value of the '<em><b>Except Pojos</b></em>' reference list.
   * The list contents are of type {@link org.sqlproc.dsl.processorDsl.PojoEntity}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Except Pojos</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Except Pojos</em>' reference list.
   * @see org.sqlproc.dsl.processorDsl.ProcessorDslPackage#getExtends_ExceptPojos()
   * @model
   * @generated
   */
  EList<PojoEntity> getExceptPojos();

  /**
   * Returns the value of the '<em><b>Except Daos</b></em>' reference list.
   * The list contents are of type {@link org.sqlproc.dsl.processorDsl.PojoDao}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Except Daos</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Except Daos</em>' reference list.
   * @see org.sqlproc.dsl.processorDsl.ProcessorDslPackage#getExtends_ExceptDaos()
   * @model
   * @generated
   */
  EList<PojoDao> getExceptDaos();

} // Extends
