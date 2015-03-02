/**
 */
package org.sqlproc.meta.processorMeta;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ord Sql</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.sqlproc.meta.processorMeta.OrdSql#getSqls <em>Sqls</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.sqlproc.meta.processorMeta.ProcessorMetaPackage#getOrdSql()
 * @model
 * @generated
 */
public interface OrdSql extends EObject
{
  /**
   * Returns the value of the '<em><b>Sqls</b></em>' containment reference list.
   * The list contents are of type {@link org.sqlproc.meta.processorMeta.OrdSql2}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Sqls</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Sqls</em>' containment reference list.
   * @see org.sqlproc.meta.processorMeta.ProcessorMetaPackage#getOrdSql_Sqls()
   * @model containment="true"
   * @generated
   */
  EList<OrdSql2> getSqls();

} // OrdSql
