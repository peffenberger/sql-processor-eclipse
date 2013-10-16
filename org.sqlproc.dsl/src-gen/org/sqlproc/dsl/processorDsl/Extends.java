/**
 */
package org.sqlproc.dsl.processorDsl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.xtext.common.types.JvmType;

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
 *   <li>{@link org.sqlproc.dsl.processorDsl.Extends#getPojos <em>Pojos</em>}</li>
 *   <li>{@link org.sqlproc.dsl.processorDsl.Extends#getDaos <em>Daos</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.sqlproc.dsl.processorDsl.ProcessorDslPackage#getExtends()
 * @model
 * @generated
 */
public interface Extends extends AbstractPojoEntity
{
  /**
   * Returns the value of the '<em><b>Extends</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Extends</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Extends</em>' reference.
   * @see #setExtends(JvmType)
   * @see org.sqlproc.dsl.processorDsl.ProcessorDslPackage#getExtends_Extends()
   * @model
   * @generated
   */
  JvmType getExtends();

  /**
   * Sets the value of the '{@link org.sqlproc.dsl.processorDsl.Extends#getExtends <em>Extends</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Extends</em>' reference.
   * @see #getExtends()
   * @generated
   */
  void setExtends(JvmType value);

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
   * Returns the value of the '<em><b>Pojos</b></em>' reference list.
   * The list contents are of type {@link org.sqlproc.dsl.processorDsl.PojoEntity}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Pojos</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Pojos</em>' reference list.
   * @see org.sqlproc.dsl.processorDsl.ProcessorDslPackage#getExtends_Pojos()
   * @model
   * @generated
   */
  EList<PojoEntity> getPojos();

  /**
   * Returns the value of the '<em><b>Daos</b></em>' reference list.
   * The list contents are of type {@link org.sqlproc.dsl.processorDsl.PojoDao}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Daos</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Daos</em>' reference list.
   * @see org.sqlproc.dsl.processorDsl.ProcessorDslPackage#getExtends_Daos()
   * @model
   * @generated
   */
  EList<PojoDao> getDaos();

} // Extends
