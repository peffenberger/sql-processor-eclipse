/**
 */
package org.sqlproc.dsl.processorDsl.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.sqlproc.dsl.processorDsl.EnumEntityModifier2;
import org.sqlproc.dsl.processorDsl.PojoEntity;
import org.sqlproc.dsl.processorDsl.ProcessorDslPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Enum Entity Modifier2</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.sqlproc.dsl.processorDsl.impl.EnumEntityModifier2Impl#getSuperType <em>Super Type</em>}</li>
 *   <li>{@link org.sqlproc.dsl.processorDsl.impl.EnumEntityModifier2Impl#getSernum <em>Sernum</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EnumEntityModifier2Impl extends MinimalEObjectImpl.Container implements EnumEntityModifier2
{
  /**
   * The cached value of the '{@link #getSuperType() <em>Super Type</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSuperType()
   * @generated
   * @ordered
   */
  protected PojoEntity superType;

  /**
   * The default value of the '{@link #getSernum() <em>Sernum</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSernum()
   * @generated
   * @ordered
   */
  protected static final String SERNUM_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getSernum() <em>Sernum</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSernum()
   * @generated
   * @ordered
   */
  protected String sernum = SERNUM_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected EnumEntityModifier2Impl()
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
    return ProcessorDslPackage.Literals.ENUM_ENTITY_MODIFIER2;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PojoEntity getSuperType()
  {
    if (superType != null && superType.eIsProxy())
    {
      InternalEObject oldSuperType = (InternalEObject)superType;
      superType = (PojoEntity)eResolveProxy(oldSuperType);
      if (superType != oldSuperType)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ProcessorDslPackage.ENUM_ENTITY_MODIFIER2__SUPER_TYPE, oldSuperType, superType));
      }
    }
    return superType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PojoEntity basicGetSuperType()
  {
    return superType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSuperType(PojoEntity newSuperType)
  {
    PojoEntity oldSuperType = superType;
    superType = newSuperType;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ProcessorDslPackage.ENUM_ENTITY_MODIFIER2__SUPER_TYPE, oldSuperType, superType));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getSernum()
  {
    return sernum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSernum(String newSernum)
  {
    String oldSernum = sernum;
    sernum = newSernum;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ProcessorDslPackage.ENUM_ENTITY_MODIFIER2__SERNUM, oldSernum, sernum));
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
      case ProcessorDslPackage.ENUM_ENTITY_MODIFIER2__SUPER_TYPE:
        if (resolve) return getSuperType();
        return basicGetSuperType();
      case ProcessorDslPackage.ENUM_ENTITY_MODIFIER2__SERNUM:
        return getSernum();
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
      case ProcessorDslPackage.ENUM_ENTITY_MODIFIER2__SUPER_TYPE:
        setSuperType((PojoEntity)newValue);
        return;
      case ProcessorDslPackage.ENUM_ENTITY_MODIFIER2__SERNUM:
        setSernum((String)newValue);
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
      case ProcessorDslPackage.ENUM_ENTITY_MODIFIER2__SUPER_TYPE:
        setSuperType((PojoEntity)null);
        return;
      case ProcessorDslPackage.ENUM_ENTITY_MODIFIER2__SERNUM:
        setSernum(SERNUM_EDEFAULT);
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
      case ProcessorDslPackage.ENUM_ENTITY_MODIFIER2__SUPER_TYPE:
        return superType != null;
      case ProcessorDslPackage.ENUM_ENTITY_MODIFIER2__SERNUM:
        return SERNUM_EDEFAULT == null ? sernum != null : !SERNUM_EDEFAULT.equals(sernum);
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
    result.append(" (sernum: ");
    result.append(sernum);
    result.append(')');
    return result.toString();
  }

} //EnumEntityModifier2Impl
