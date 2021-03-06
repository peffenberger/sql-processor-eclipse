/**
 */
package org.sqlproc.meta.processorMeta;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Procedure Definition Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.sqlproc.meta.processorMeta.ProcedureDefinitionModel#getName <em>Name</em>}</li>
 *   <li>{@link org.sqlproc.meta.processorMeta.ProcedureDefinitionModel#getTable <em>Table</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.sqlproc.meta.processorMeta.ProcessorMetaPackage#getProcedureDefinitionModel()
 * @model
 * @generated
 */
public interface ProcedureDefinitionModel extends EObject
{
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
   * @see org.sqlproc.meta.processorMeta.ProcessorMetaPackage#getProcedureDefinitionModel_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.sqlproc.meta.processorMeta.ProcedureDefinitionModel#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Table</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Table</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Table</em>' attribute.
   * @see #setTable(String)
   * @see org.sqlproc.meta.processorMeta.ProcessorMetaPackage#getProcedureDefinitionModel_Table()
   * @model
   * @generated
   */
  String getTable();

  /**
   * Sets the value of the '{@link org.sqlproc.meta.processorMeta.ProcedureDefinitionModel#getTable <em>Table</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Table</em>' attribute.
   * @see #getTable()
   * @generated
   */
  void setTable(String value);

} // ProcedureDefinitionModel
