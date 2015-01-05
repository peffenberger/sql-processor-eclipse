/**
 */
package org.sqlproc.dsl.processorDsl;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Enum Entity</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.sqlproc.dsl.processorDsl.EnumEntity#getAnnotations <em>Annotations</em>}</li>
 *   <li>{@link org.sqlproc.dsl.processorDsl.EnumEntity#getDirectives <em>Directives</em>}</li>
 *   <li>{@link org.sqlproc.dsl.processorDsl.EnumEntity#getName <em>Name</em>}</li>
 *   <li>{@link org.sqlproc.dsl.processorDsl.EnumEntity#getFeatures <em>Features</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.sqlproc.dsl.processorDsl.ProcessorDslPackage#getEnumEntity()
 * @model
 * @generated
 */
public interface EnumEntity extends AbstractEntity
{
  /**
   * Returns the value of the '<em><b>Annotations</b></em>' containment reference list.
   * The list contents are of type {@link org.sqlproc.dsl.processorDsl.EntityAnnotation}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Annotations</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Annotations</em>' containment reference list.
   * @see org.sqlproc.dsl.processorDsl.ProcessorDslPackage#getEnumEntity_Annotations()
   * @model containment="true"
   * @generated
   */
  EList<EntityAnnotation> getAnnotations();

  /**
   * Returns the value of the '<em><b>Directives</b></em>' containment reference list.
   * The list contents are of type {@link org.sqlproc.dsl.processorDsl.EnumDirective}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Directives</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Directives</em>' containment reference list.
   * @see org.sqlproc.dsl.processorDsl.ProcessorDslPackage#getEnumEntity_Directives()
   * @model containment="true"
   * @generated
   */
  EList<EnumDirective> getDirectives();

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
   * @see org.sqlproc.dsl.processorDsl.ProcessorDslPackage#getEnumEntity_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.sqlproc.dsl.processorDsl.EnumEntity#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Features</b></em>' containment reference list.
   * The list contents are of type {@link org.sqlproc.dsl.processorDsl.EnumProperty}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Features</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Features</em>' containment reference list.
   * @see org.sqlproc.dsl.processorDsl.ProcessorDslPackage#getEnumEntity_Features()
   * @model containment="true"
   * @generated
   */
  EList<EnumProperty> getFeatures();

} // EnumEntity
