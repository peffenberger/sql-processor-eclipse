/**
 */
package org.sqlproc.dsl.processorDsl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.xtext.common.types.JvmType;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Extends Assignement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.sqlproc.dsl.processorDsl.ExtendsAssignement#getToExtends <em>To Extends</em>}</li>
 *   <li>{@link org.sqlproc.dsl.processorDsl.ExtendsAssignement#isGenerics <em>Generics</em>}</li>
 *   <li>{@link org.sqlproc.dsl.processorDsl.ExtendsAssignement#getDbColumns <em>Db Columns</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.sqlproc.dsl.processorDsl.ProcessorDslPackage#getExtendsAssignement()
 * @model
 * @generated
 */
public interface ExtendsAssignement extends EObject
{
  /**
   * Returns the value of the '<em><b>To Extends</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>To Extends</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>To Extends</em>' reference.
   * @see #setToExtends(JvmType)
   * @see org.sqlproc.dsl.processorDsl.ProcessorDslPackage#getExtendsAssignement_ToExtends()
   * @model
   * @generated
   */
  JvmType getToExtends();

  /**
   * Sets the value of the '{@link org.sqlproc.dsl.processorDsl.ExtendsAssignement#getToExtends <em>To Extends</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>To Extends</em>' reference.
   * @see #getToExtends()
   * @generated
   */
  void setToExtends(JvmType value);

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
   * @see org.sqlproc.dsl.processorDsl.ProcessorDslPackage#getExtendsAssignement_Generics()
   * @model
   * @generated
   */
  boolean isGenerics();

  /**
   * Sets the value of the '{@link org.sqlproc.dsl.processorDsl.ExtendsAssignement#isGenerics <em>Generics</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Generics</em>' attribute.
   * @see #isGenerics()
   * @generated
   */
  void setGenerics(boolean value);

  /**
   * Returns the value of the '<em><b>Db Columns</b></em>' attribute list.
   * The list contents are of type {@link java.lang.String}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Db Columns</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Db Columns</em>' attribute list.
   * @see org.sqlproc.dsl.processorDsl.ProcessorDslPackage#getExtendsAssignement_DbColumns()
   * @model unique="false"
   * @generated
   */
  EList<String> getDbColumns();

} // ExtendsAssignement
