/**
 */
package org.sqlproc.meta.processorMeta.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.xtext.common.types.JvmType;

import org.sqlproc.meta.processorMeta.PojoDefinitionModel;
import org.sqlproc.meta.processorMeta.ProcessorMetaPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Pojo Definition Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.sqlproc.meta.processorMeta.impl.PojoDefinitionModelImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.sqlproc.meta.processorMeta.impl.PojoDefinitionModelImpl#getClass_ <em>Class</em>}</li>
 *   <li>{@link org.sqlproc.meta.processorMeta.impl.PojoDefinitionModelImpl#getClassx <em>Classx</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PojoDefinitionModelImpl extends MinimalEObjectImpl.Container implements PojoDefinitionModel
{
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
   * The default value of the '{@link #getClass_() <em>Class</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getClass_()
   * @generated
   * @ordered
   */
  protected static final String CLASS_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getClass_() <em>Class</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getClass_()
   * @generated
   * @ordered
   */
  protected String class_ = CLASS_EDEFAULT;

  /**
   * The cached value of the '{@link #getClassx() <em>Classx</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getClassx()
   * @generated
   * @ordered
   */
  protected JvmType classx;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected PojoDefinitionModelImpl()
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
    return ProcessorMetaPackage.Literals.POJO_DEFINITION_MODEL;
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
      eNotify(new ENotificationImpl(this, Notification.SET, ProcessorMetaPackage.POJO_DEFINITION_MODEL__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getClass_()
  {
    return class_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setClass(String newClass)
  {
    String oldClass = class_;
    class_ = newClass;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ProcessorMetaPackage.POJO_DEFINITION_MODEL__CLASS, oldClass, class_));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public JvmType getClassx()
  {
    if (classx != null && classx.eIsProxy())
    {
      InternalEObject oldClassx = (InternalEObject)classx;
      classx = (JvmType)eResolveProxy(oldClassx);
      if (classx != oldClassx)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ProcessorMetaPackage.POJO_DEFINITION_MODEL__CLASSX, oldClassx, classx));
      }
    }
    return classx;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public JvmType basicGetClassx()
  {
    return classx;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setClassx(JvmType newClassx)
  {
    JvmType oldClassx = classx;
    classx = newClassx;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ProcessorMetaPackage.POJO_DEFINITION_MODEL__CLASSX, oldClassx, classx));
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
      case ProcessorMetaPackage.POJO_DEFINITION_MODEL__NAME:
        return getName();
      case ProcessorMetaPackage.POJO_DEFINITION_MODEL__CLASS:
        return getClass_();
      case ProcessorMetaPackage.POJO_DEFINITION_MODEL__CLASSX:
        if (resolve) return getClassx();
        return basicGetClassx();
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
      case ProcessorMetaPackage.POJO_DEFINITION_MODEL__NAME:
        setName((String)newValue);
        return;
      case ProcessorMetaPackage.POJO_DEFINITION_MODEL__CLASS:
        setClass((String)newValue);
        return;
      case ProcessorMetaPackage.POJO_DEFINITION_MODEL__CLASSX:
        setClassx((JvmType)newValue);
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
      case ProcessorMetaPackage.POJO_DEFINITION_MODEL__NAME:
        setName(NAME_EDEFAULT);
        return;
      case ProcessorMetaPackage.POJO_DEFINITION_MODEL__CLASS:
        setClass(CLASS_EDEFAULT);
        return;
      case ProcessorMetaPackage.POJO_DEFINITION_MODEL__CLASSX:
        setClassx((JvmType)null);
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
      case ProcessorMetaPackage.POJO_DEFINITION_MODEL__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case ProcessorMetaPackage.POJO_DEFINITION_MODEL__CLASS:
        return CLASS_EDEFAULT == null ? class_ != null : !CLASS_EDEFAULT.equals(class_);
      case ProcessorMetaPackage.POJO_DEFINITION_MODEL__CLASSX:
        return classx != null;
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
    result.append(" (name: ");
    result.append(name);
    result.append(", class: ");
    result.append(class_);
    result.append(')');
    return result.toString();
  }

} //PojoDefinitionModelImpl
