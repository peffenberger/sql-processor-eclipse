/**
 */
package org.sqlproc.model.processorModel;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Pojo Directive Index</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.sqlproc.model.processorModel.PojoDirectiveIndex#getIndex <em>Index</em>}</li>
 *   <li>{@link org.sqlproc.model.processorModel.PojoDirectiveIndex#getProplist <em>Proplist</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.sqlproc.model.processorModel.ProcessorModelPackage#getPojoDirectiveIndex()
 * @model
 * @generated
 */
public interface PojoDirectiveIndex extends PojoDirective
{
  /**
   * Returns the value of the '<em><b>Index</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Index</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Index</em>' attribute.
   * @see #setIndex(int)
   * @see org.sqlproc.model.processorModel.ProcessorModelPackage#getPojoDirectiveIndex_Index()
   * @model
   * @generated
   */
  int getIndex();

  /**
   * Sets the value of the '{@link org.sqlproc.model.processorModel.PojoDirectiveIndex#getIndex <em>Index</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Index</em>' attribute.
   * @see #getIndex()
   * @generated
   */
  void setIndex(int value);

  /**
   * Returns the value of the '<em><b>Proplist</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Proplist</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Proplist</em>' containment reference.
   * @see #setProplist(DirectiveProperties)
   * @see org.sqlproc.model.processorModel.ProcessorModelPackage#getPojoDirectiveIndex_Proplist()
   * @model containment="true"
   * @generated
   */
  DirectiveProperties getProplist();

  /**
   * Sets the value of the '{@link org.sqlproc.model.processorModel.PojoDirectiveIndex#getProplist <em>Proplist</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Proplist</em>' containment reference.
   * @see #getProplist()
   * @generated
   */
  void setProplist(DirectiveProperties value);

} // PojoDirectiveIndex
