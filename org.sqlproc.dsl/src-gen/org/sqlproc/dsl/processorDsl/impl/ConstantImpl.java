/**
 */
package org.sqlproc.dsl.processorDsl.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeEList;

import org.sqlproc.dsl.processorDsl.Constant;
import org.sqlproc.dsl.processorDsl.ProcessorDslPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Constant</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.sqlproc.dsl.processorDsl.impl.ConstantImpl#getCase <em>Case</em>}</li>
 *   <li>{@link org.sqlproc.dsl.processorDsl.impl.ConstantImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.sqlproc.dsl.processorDsl.impl.ConstantImpl#getModifiers <em>Modifiers</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ConstantImpl extends MinimalEObjectImpl.Container implements Constant
{
  /**
   * The default value of the '{@link #getCase() <em>Case</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCase()
   * @generated
   * @ordered
   */
  protected static final String CASE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getCase() <em>Case</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCase()
   * @generated
   * @ordered
   */
  protected String case_ = CASE_EDEFAULT;

  /**
   * The default value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected static final String NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected String name = NAME_EDEFAULT;

  /**
   * The cached value of the '{@link #getModifiers() <em>Modifiers</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getModifiers()
   * @generated
   * @ordered
   */
  protected EList<String> modifiers;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ConstantImpl()
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
    return ProcessorDslPackage.eINSTANCE.getConstant();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getCase()
  {
    return case_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setCase(String newCase)
  {
    String oldCase = case_;
    case_ = newCase;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ProcessorDslPackage.CONSTANT__CASE, oldCase, case_));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getName()
  {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setName(String newName)
  {
    String oldName = name;
    name = newName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ProcessorDslPackage.CONSTANT__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<String> getModifiers()
  {
    if (modifiers == null)
    {
      modifiers = new EDataTypeEList<String>(String.class, this, ProcessorDslPackage.CONSTANT__MODIFIERS);
    }
    return modifiers;
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
      case ProcessorDslPackage.CONSTANT__CASE:
        return getCase();
      case ProcessorDslPackage.CONSTANT__NAME:
        return getName();
      case ProcessorDslPackage.CONSTANT__MODIFIERS:
        return getModifiers();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case ProcessorDslPackage.CONSTANT__CASE:
        setCase((String)newValue);
        return;
      case ProcessorDslPackage.CONSTANT__NAME:
        setName((String)newValue);
        return;
      case ProcessorDslPackage.CONSTANT__MODIFIERS:
        getModifiers().clear();
        getModifiers().addAll((Collection<? extends String>)newValue);
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
      case ProcessorDslPackage.CONSTANT__CASE:
        setCase(CASE_EDEFAULT);
        return;
      case ProcessorDslPackage.CONSTANT__NAME:
        setName(NAME_EDEFAULT);
        return;
      case ProcessorDslPackage.CONSTANT__MODIFIERS:
        getModifiers().clear();
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
      case ProcessorDslPackage.CONSTANT__CASE:
        return CASE_EDEFAULT == null ? case_ != null : !CASE_EDEFAULT.equals(case_);
      case ProcessorDslPackage.CONSTANT__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case ProcessorDslPackage.CONSTANT__MODIFIERS:
        return modifiers != null && !modifiers.isEmpty();
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
    result.append(" (case: ");
    result.append(case_);
    result.append(", name: ");
    result.append(name);
    result.append(", modifiers: ");
    result.append(modifiers);
    result.append(')');
    return result.toString();
  }

} //ConstantImpl
