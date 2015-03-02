/**
 */
package org.sqlproc.meta.processorMeta;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Database Schema Assignement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.sqlproc.meta.processorMeta.DatabaseSchemaAssignement#getDbSchema <em>Db Schema</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.sqlproc.meta.processorMeta.ProcessorMetaPackage#getDatabaseSchemaAssignement()
 * @model
 * @generated
 */
public interface DatabaseSchemaAssignement extends EObject
{
  /**
   * Returns the value of the '<em><b>Db Schema</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Db Schema</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Db Schema</em>' attribute.
   * @see #setDbSchema(String)
   * @see org.sqlproc.meta.processorMeta.ProcessorMetaPackage#getDatabaseSchemaAssignement_DbSchema()
   * @model
   * @generated
   */
  String getDbSchema();

  /**
   * Sets the value of the '{@link org.sqlproc.meta.processorMeta.DatabaseSchemaAssignement#getDbSchema <em>Db Schema</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Db Schema</em>' attribute.
   * @see #getDbSchema()
   * @generated
   */
  void setDbSchema(String value);

} // DatabaseSchemaAssignement
