/**
 */
package org.sqlproc.dsl.processorDsl.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.sqlproc.dsl.processorDsl.PojoDirectiveOperators;
import org.sqlproc.dsl.processorDsl.ProcessorDslPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Pojo Directive Operators</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.sqlproc.dsl.processorDsl.impl.PojoDirectiveOperatorsImpl#getOperatorsSuffix <em>Operators Suffix</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PojoDirectiveOperatorsImpl extends PojoDirectiveImpl implements PojoDirectiveOperators
{
  /**
   * The default value of the '{@link #getOperatorsSuffix() <em>Operators Suffix</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOperatorsSuffix()
   * @generated
   * @ordered
   */
  protected static final String OPERATORS_SUFFIX_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getOperatorsSuffix() <em>Operators Suffix</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOperatorsSuffix()
   * @generated
   * @ordered
   */
  protected String operatorsSuffix = OPERATORS_SUFFIX_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected PojoDirectiveOperatorsImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return ProcessorDslPackage.Literals.POJO_DIRECTIVE_OPERATORS;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getOperatorsSuffix()
  {
    return operatorsSuffix;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setOperatorsSuffix(String newOperatorsSuffix)
  {
    String oldOperatorsSuffix = operatorsSuffix;
    operatorsSuffix = newOperatorsSuffix;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ProcessorDslPackage.POJO_DIRECTIVE_OPERATORS__OPERATORS_SUFFIX, oldOperatorsSuffix, operatorsSuffix));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case ProcessorDslPackage.POJO_DIRECTIVE_OPERATORS__OPERATORS_SUFFIX:
        return getOperatorsSuffix();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case ProcessorDslPackage.POJO_DIRECTIVE_OPERATORS__OPERATORS_SUFFIX:
        setOperatorsSuffix((String)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case ProcessorDslPackage.POJO_DIRECTIVE_OPERATORS__OPERATORS_SUFFIX:
        setOperatorsSuffix(OPERATORS_SUFFIX_EDEFAULT);
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case ProcessorDslPackage.POJO_DIRECTIVE_OPERATORS__OPERATORS_SUFFIX:
        return OPERATORS_SUFFIX_EDEFAULT == null ? operatorsSuffix != null : !OPERATORS_SUFFIX_EDEFAULT.equals(operatorsSuffix);
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (operatorsSuffix: ");
    result.append(operatorsSuffix);
    result.append(')');
    return result.toString();
  }

} //PojoDirectiveOperatorsImpl
