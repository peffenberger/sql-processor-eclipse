/**
 */
package org.sqlproc.model.processorModel;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Database Catalog Assignement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.sqlproc.model.processorModel.DatabaseCatalogAssignement#getDbCatalog <em>Db Catalog</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.sqlproc.model.processorModel.ProcessorModelPackage#getDatabaseCatalogAssignement()
 * @model
 * @generated
 */
public interface DatabaseCatalogAssignement extends EObject
{
  /**
   * Returns the value of the '<em><b>Db Catalog</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Db Catalog</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Db Catalog</em>' attribute.
   * @see #setDbCatalog(String)
   * @see org.sqlproc.model.processorModel.ProcessorModelPackage#getDatabaseCatalogAssignement_DbCatalog()
   * @model
   * @generated
   */
  String getDbCatalog();

  /**
   * Sets the value of the '{@link org.sqlproc.model.processorModel.DatabaseCatalogAssignement#getDbCatalog <em>Db Catalog</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Db Catalog</em>' attribute.
   * @see #getDbCatalog()
   * @generated
   */
  void setDbCatalog(String value);

} // DatabaseCatalogAssignement
