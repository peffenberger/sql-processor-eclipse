/**
 */
package org.sqlproc.meta.processorMeta;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Database Catalog Assignement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.sqlproc.meta.processorMeta.DatabaseCatalogAssignement#getDbCatalog <em>Db Catalog</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.sqlproc.meta.processorMeta.ProcessorMetaPackage#getDatabaseCatalogAssignement()
 * @model
 * @generated
 */
public interface DatabaseCatalogAssignement extends EObject
{
  /**
   * Returns the value of the '<em><b>Db Catalog</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Db Catalog</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Db Catalog</em>' containment reference.
   * @see #setDbCatalog(ValueType)
   * @see org.sqlproc.meta.processorMeta.ProcessorMetaPackage#getDatabaseCatalogAssignement_DbCatalog()
   * @model containment="true"
   * @generated
   */
  ValueType getDbCatalog();

  /**
   * Sets the value of the '{@link org.sqlproc.meta.processorMeta.DatabaseCatalogAssignement#getDbCatalog <em>Db Catalog</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Db Catalog</em>' containment reference.
   * @see #getDbCatalog()
   * @generated
   */
  void setDbCatalog(ValueType value);

} // DatabaseCatalogAssignement
