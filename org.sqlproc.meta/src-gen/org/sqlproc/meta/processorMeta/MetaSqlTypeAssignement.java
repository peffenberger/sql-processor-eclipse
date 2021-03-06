/**
 */
package org.sqlproc.meta.processorMeta;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Meta Sql Type Assignement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.sqlproc.meta.processorMeta.MetaSqlTypeAssignement#getSqlType <em>Sql Type</em>}</li>
 *   <li>{@link org.sqlproc.meta.processorMeta.MetaSqlTypeAssignement#getType <em>Type</em>}</li>
 *   <li>{@link org.sqlproc.meta.processorMeta.MetaSqlTypeAssignement#getExtension <em>Extension</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.sqlproc.meta.processorMeta.ProcessorMetaPackage#getMetaSqlTypeAssignement()
 * @model
 * @generated
 */
public interface MetaSqlTypeAssignement extends EObject
{
  /**
   * Returns the value of the '<em><b>Sql Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Sql Type</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Sql Type</em>' containment reference.
   * @see #setSqlType(ValueType)
   * @see org.sqlproc.meta.processorMeta.ProcessorMetaPackage#getMetaSqlTypeAssignement_SqlType()
   * @model containment="true"
   * @generated
   */
  ValueType getSqlType();

  /**
   * Sets the value of the '{@link org.sqlproc.meta.processorMeta.MetaSqlTypeAssignement#getSqlType <em>Sql Type</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Sql Type</em>' containment reference.
   * @see #getSqlType()
   * @generated
   */
  void setSqlType(ValueType value);

  /**
   * Returns the value of the '<em><b>Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Type</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type</em>' attribute.
   * @see #setType(String)
   * @see org.sqlproc.meta.processorMeta.ProcessorMetaPackage#getMetaSqlTypeAssignement_Type()
   * @model
   * @generated
   */
  String getType();

  /**
   * Sets the value of the '{@link org.sqlproc.meta.processorMeta.MetaSqlTypeAssignement#getType <em>Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type</em>' attribute.
   * @see #getType()
   * @generated
   */
  void setType(String value);

  /**
   * Returns the value of the '<em><b>Extension</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Extension</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Extension</em>' attribute.
   * @see #setExtension(String)
   * @see org.sqlproc.meta.processorMeta.ProcessorMetaPackage#getMetaSqlTypeAssignement_Extension()
   * @model
   * @generated
   */
  String getExtension();

  /**
   * Sets the value of the '{@link org.sqlproc.meta.processorMeta.MetaSqlTypeAssignement#getExtension <em>Extension</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Extension</em>' attribute.
   * @see #getExtension()
   * @generated
   */
  void setExtension(String value);

} // MetaSqlTypeAssignement
