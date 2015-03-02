/**
 */
package org.sqlproc.meta.processorMeta.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.xtext.common.types.JvmType;

import org.sqlproc.meta.processorMeta.PojoDefinition;
import org.sqlproc.meta.processorMeta.PojoType;
import org.sqlproc.meta.processorMeta.ProcessorMetaPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Pojo Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.sqlproc.meta.processorMeta.impl.PojoTypeImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.sqlproc.meta.processorMeta.impl.PojoTypeImpl#getRef <em>Ref</em>}</li>
 *   <li>{@link org.sqlproc.meta.processorMeta.impl.PojoTypeImpl#getGtype <em>Gtype</em>}</li>
 *   <li>{@link org.sqlproc.meta.processorMeta.impl.PojoTypeImpl#getGref <em>Gref</em>}</li>
 *   <li>{@link org.sqlproc.meta.processorMeta.impl.PojoTypeImpl#isArray <em>Array</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PojoTypeImpl extends MinimalEObjectImpl.Container implements PojoType
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
  protected PojoDefinition ref;

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
  protected PojoDefinition gref;

  /**
   * The default value of the '{@link #isArray() <em>Array</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isArray()
   * @generated
   * @ordered
   */
  protected static final boolean ARRAY_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isArray() <em>Array</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isArray()
   * @generated
   * @ordered
   */
  protected boolean array = ARRAY_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected PojoTypeImpl()
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
    return ProcessorMetaPackage.Literals.POJO_TYPE;
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
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ProcessorMetaPackage.POJO_TYPE__TYPE, oldType, type));
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
      eNotify(new ENotificationImpl(this, Notification.SET, ProcessorMetaPackage.POJO_TYPE__TYPE, oldType, type));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PojoDefinition getRef()
  {
    if (ref != null && ref.eIsProxy())
    {
      InternalEObject oldRef = (InternalEObject)ref;
      ref = (PojoDefinition)eResolveProxy(oldRef);
      if (ref != oldRef)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ProcessorMetaPackage.POJO_TYPE__REF, oldRef, ref));
      }
    }
    return ref;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PojoDefinition basicGetRef()
  {
    return ref;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setRef(PojoDefinition newRef)
  {
    PojoDefinition oldRef = ref;
    ref = newRef;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ProcessorMetaPackage.POJO_TYPE__REF, oldRef, ref));
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
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ProcessorMetaPackage.POJO_TYPE__GTYPE, oldGtype, gtype));
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
      eNotify(new ENotificationImpl(this, Notification.SET, ProcessorMetaPackage.POJO_TYPE__GTYPE, oldGtype, gtype));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PojoDefinition getGref()
  {
    if (gref != null && gref.eIsProxy())
    {
      InternalEObject oldGref = (InternalEObject)gref;
      gref = (PojoDefinition)eResolveProxy(oldGref);
      if (gref != oldGref)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ProcessorMetaPackage.POJO_TYPE__GREF, oldGref, gref));
      }
    }
    return gref;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PojoDefinition basicGetGref()
  {
    return gref;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setGref(PojoDefinition newGref)
  {
    PojoDefinition oldGref = gref;
    gref = newGref;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ProcessorMetaPackage.POJO_TYPE__GREF, oldGref, gref));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isArray()
  {
    return array;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setArray(boolean newArray)
  {
    boolean oldArray = array;
    array = newArray;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ProcessorMetaPackage.POJO_TYPE__ARRAY, oldArray, array));
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
      case ProcessorMetaPackage.POJO_TYPE__TYPE:
        if (resolve) return getType();
        return basicGetType();
      case ProcessorMetaPackage.POJO_TYPE__REF:
        if (resolve) return getRef();
        return basicGetRef();
      case ProcessorMetaPackage.POJO_TYPE__GTYPE:
        if (resolve) return getGtype();
        return basicGetGtype();
      case ProcessorMetaPackage.POJO_TYPE__GREF:
        if (resolve) return getGref();
        return basicGetGref();
      case ProcessorMetaPackage.POJO_TYPE__ARRAY:
        return isArray();
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
      case ProcessorMetaPackage.POJO_TYPE__TYPE:
        setType((JvmType)newValue);
        return;
      case ProcessorMetaPackage.POJO_TYPE__REF:
        setRef((PojoDefinition)newValue);
        return;
      case ProcessorMetaPackage.POJO_TYPE__GTYPE:
        setGtype((JvmType)newValue);
        return;
      case ProcessorMetaPackage.POJO_TYPE__GREF:
        setGref((PojoDefinition)newValue);
        return;
      case ProcessorMetaPackage.POJO_TYPE__ARRAY:
        setArray((Boolean)newValue);
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
      case ProcessorMetaPackage.POJO_TYPE__TYPE:
        setType((JvmType)null);
        return;
      case ProcessorMetaPackage.POJO_TYPE__REF:
        setRef((PojoDefinition)null);
        return;
      case ProcessorMetaPackage.POJO_TYPE__GTYPE:
        setGtype((JvmType)null);
        return;
      case ProcessorMetaPackage.POJO_TYPE__GREF:
        setGref((PojoDefinition)null);
        return;
      case ProcessorMetaPackage.POJO_TYPE__ARRAY:
        setArray(ARRAY_EDEFAULT);
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
      case ProcessorMetaPackage.POJO_TYPE__TYPE:
        return type != null;
      case ProcessorMetaPackage.POJO_TYPE__REF:
        return ref != null;
      case ProcessorMetaPackage.POJO_TYPE__GTYPE:
        return gtype != null;
      case ProcessorMetaPackage.POJO_TYPE__GREF:
        return gref != null;
      case ProcessorMetaPackage.POJO_TYPE__ARRAY:
        return array != ARRAY_EDEFAULT;
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
    result.append(" (array: ");
    result.append(array);
    result.append(')');
    return result.toString();
  }

} //PojoTypeImpl
