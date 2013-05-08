/**
 */
package org.sqlproc.dsl.processorDsl;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Annotated Entity</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.sqlproc.dsl.processorDsl.AnnotatedEntity#getSetterAnnotation <em>Setter Annotation</em>}</li>
 *   <li>{@link org.sqlproc.dsl.processorDsl.AnnotatedEntity#getEntity <em>Entity</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.sqlproc.dsl.processorDsl.ProcessorDslPackage#getAnnotatedEntity()
 * @model
 * @generated
 */
public interface AnnotatedEntity extends AbstractPojoEntity
{
  /**
   * Returns the value of the '<em><b>Setter Annotation</b></em>' containment reference list.
   * The list contents are of type {@link org.sqlproc.dsl.processorDsl.Annotation}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Setter Annotation</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Setter Annotation</em>' containment reference list.
   * @see org.sqlproc.dsl.processorDsl.ProcessorDslPackage#getAnnotatedEntity_SetterAnnotation()
   * @model containment="true"
   * @generated
   */
  EList<Annotation> getSetterAnnotation();

  /**
   * Returns the value of the '<em><b>Entity</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Entity</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Entity</em>' containment reference.
   * @see #setEntity(Entity)
   * @see org.sqlproc.dsl.processorDsl.ProcessorDslPackage#getAnnotatedEntity_Entity()
   * @model containment="true"
   * @generated
   */
  Entity getEntity();

  /**
   * Sets the value of the '{@link org.sqlproc.dsl.processorDsl.AnnotatedEntity#getEntity <em>Entity</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Entity</em>' containment reference.
   * @see #getEntity()
   * @generated
   */
  void setEntity(Entity value);

} // AnnotatedEntity
