/**
 */
package org.sqlproc.dsl.processorDsl.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.xtext.common.types.JvmType;

import org.sqlproc.dsl.processorDsl.DaoType;
import org.sqlproc.dsl.processorDsl.PojoDao;
import org.sqlproc.dsl.processorDsl.ProcessorDslPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Dao Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.sqlproc.dsl.processorDsl.impl.DaoTypeImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.sqlproc.dsl.processorDsl.impl.DaoTypeImpl#getRef <em>Ref</em>}</li>
 *   <li>{@link org.sqlproc.dsl.processorDsl.impl.DaoTypeImpl#getGtype <em>Gtype</em>}</li>
 *   <li>{@link org.sqlproc.dsl.processorDsl.impl.DaoTypeImpl#getGref <em>Gref</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DaoTypeImpl extends MinimalEObjectImpl.Container implements DaoType
{
  /**
   * The cached value of the '{@link #getType() <em>Type</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getType()
   * @generated
   * @ordered
   */
  protected JvmType type;

  /**
   * The cached value of the '{@link #getRef() <em>Ref</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRef()
   * @generated
   * @ordered
   */
  protected PojoDao ref;

  /**
   * The cached value of the '{@link #getGtype() <em>Gtype</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getGtype()
   * @generated
   * @ordered
   */
  protected JvmType gtype;

  /**
   * The cached value of the '{@link #getGref() <em>Gref</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getGref()
   * @generated
   * @ordered
   */
  protected PojoDao gref;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected DaoTypeImpl()
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
    return ProcessorDslPackage.Literals.DAO_TYPE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public JvmType getType()
  {
    if (type != null && type.eIsProxy())
    {
      InternalEObject oldType = (InternalEObject)type;
      type = (JvmType)eResolveProxy(oldType);
      if (type != oldType)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ProcessorDslPackage.DAO_TYPE__TYPE, oldType, type));
      }
    }
    return type;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public JvmType basicGetType()
  {
    return type;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setType(JvmType newType)
  {
    JvmType oldType = type;
    type = newType;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ProcessorDslPackage.DAO_TYPE__TYPE, oldType, type));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PojoDao getRef()
  {
    if (ref != null && ref.eIsProxy())
    {
      InternalEObject oldRef = (InternalEObject)ref;
      ref = (PojoDao)eResolveProxy(oldRef);
      if (ref != oldRef)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ProcessorDslPackage.DAO_TYPE__REF, oldRef, ref));
      }
    }
    return ref;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PojoDao basicGetRef()
  {
    return ref;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setRef(PojoDao newRef)
  {
    PojoDao oldRef = ref;
    ref = newRef;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ProcessorDslPackage.DAO_TYPE__REF, oldRef, ref));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public JvmType getGtype()
  {
    if (gtype != null && gtype.eIsProxy())
    {
      InternalEObject oldGtype = (InternalEObject)gtype;
      gtype = (JvmType)eResolveProxy(oldGtype);
      if (gtype != oldGtype)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ProcessorDslPackage.DAO_TYPE__GTYPE, oldGtype, gtype));
      }
    }
    return gtype;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public JvmType basicGetGtype()
  {
    return gtype;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setGtype(JvmType newGtype)
  {
    JvmType oldGtype = gtype;
    gtype = newGtype;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ProcessorDslPackage.DAO_TYPE__GTYPE, oldGtype, gtype));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PojoDao getGref()
  {
    if (gref != null && gref.eIsProxy())
    {
      InternalEObject oldGref = (InternalEObject)gref;
      gref = (PojoDao)eResolveProxy(oldGref);
      if (gref != oldGref)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ProcessorDslPackage.DAO_TYPE__GREF, oldGref, gref));
      }
    }
    return gref;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PojoDao basicGetGref()
  {
    return gref;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setGref(PojoDao newGref)
  {
    PojoDao oldGref = gref;
    gref = newGref;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ProcessorDslPackage.DAO_TYPE__GREF, oldGref, gref));
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
      case ProcessorDslPackage.DAO_TYPE__TYPE:
        if (resolve) return getType();
        return basicGetType();
      case ProcessorDslPackage.DAO_TYPE__REF:
        if (resolve) return getRef();
        return basicGetRef();
      case ProcessorDslPackage.DAO_TYPE__GTYPE:
        if (resolve) return getGtype();
        return basicGetGtype();
      case ProcessorDslPackage.DAO_TYPE__GREF:
        if (resolve) return getGref();
        return basicGetGref();
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
      case ProcessorDslPackage.DAO_TYPE__TYPE:
        setType((JvmType)newValue);
        return;
      case ProcessorDslPackage.DAO_TYPE__REF:
        setRef((PojoDao)newValue);
        return;
      case ProcessorDslPackage.DAO_TYPE__GTYPE:
        setGtype((JvmType)newValue);
        return;
      case ProcessorDslPackage.DAO_TYPE__GREF:
        setGref((PojoDao)newValue);
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
      case ProcessorDslPackage.DAO_TYPE__TYPE:
        setType((JvmType)null);
        return;
      case ProcessorDslPackage.DAO_TYPE__REF:
        setRef((PojoDao)null);
        return;
      case ProcessorDslPackage.DAO_TYPE__GTYPE:
        setGtype((JvmType)null);
        return;
      case ProcessorDslPackage.DAO_TYPE__GREF:
        setGref((PojoDao)null);
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
      case ProcessorDslPackage.DAO_TYPE__TYPE:
        return type != null;
      case ProcessorDslPackage.DAO_TYPE__REF:
        return ref != null;
      case ProcessorDslPackage.DAO_TYPE__GTYPE:
        return gtype != null;
      case ProcessorDslPackage.DAO_TYPE__GREF:
        return gref != null;
    }
    return super.eIsSet(featureID);
  }

} //DaoTypeImpl
