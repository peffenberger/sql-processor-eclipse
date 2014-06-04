/**
 */
package org.sqlproc.dsl.processorDsl.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.eclipse.xtext.common.types.JvmType;

import org.sqlproc.dsl.processorDsl.Extends;
import org.sqlproc.dsl.processorDsl.PojoDao;
import org.sqlproc.dsl.processorDsl.PojoEntity;
import org.sqlproc.dsl.processorDsl.ProcessorDslPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Extends</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.sqlproc.dsl.processorDsl.impl.ExtendsImpl#getExtends <em>Extends</em>}</li>
 *   <li>{@link org.sqlproc.dsl.processorDsl.impl.ExtendsImpl#isGenerics <em>Generics</em>}</li>
 *   <li>{@link org.sqlproc.dsl.processorDsl.impl.ExtendsImpl#getOnlyPojos <em>Only Pojos</em>}</li>
 *   <li>{@link org.sqlproc.dsl.processorDsl.impl.ExtendsImpl#getOnlyDaos <em>Only Daos</em>}</li>
 *   <li>{@link org.sqlproc.dsl.processorDsl.impl.ExtendsImpl#getExceptPojos <em>Except Pojos</em>}</li>
 *   <li>{@link org.sqlproc.dsl.processorDsl.impl.ExtendsImpl#getExceptDaos <em>Except Daos</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ExtendsImpl extends AbstractPojoEntityImpl implements Extends
{
  /**
   * The cached value of the '{@link #getExtends() <em>Extends</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExtends()
   * @generated
   * @ordered
   */
  protected JvmType extends_;

  /**
   * The default value of the '{@link #isGenerics() <em>Generics</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isGenerics()
   * @generated
   * @ordered
   */
  protected static final boolean GENERICS_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isGenerics() <em>Generics</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isGenerics()
   * @generated
   * @ordered
   */
  protected boolean generics = GENERICS_EDEFAULT;

  /**
   * The cached value of the '{@link #getOnlyPojos() <em>Only Pojos</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOnlyPojos()
   * @generated
   * @ordered
   */
  protected EList<PojoEntity> onlyPojos;

  /**
   * The cached value of the '{@link #getOnlyDaos() <em>Only Daos</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOnlyDaos()
   * @generated
   * @ordered
   */
  protected EList<PojoDao> onlyDaos;

  /**
   * The cached value of the '{@link #getExceptPojos() <em>Except Pojos</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExceptPojos()
   * @generated
   * @ordered
   */
  protected EList<PojoEntity> exceptPojos;

  /**
   * The cached value of the '{@link #getExceptDaos() <em>Except Daos</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExceptDaos()
   * @generated
   * @ordered
   */
  protected EList<PojoDao> exceptDaos;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ExtendsImpl()
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
    return ProcessorDslPackage.Literals.EXTENDS;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public JvmType getExtends()
  {
    if (extends_ != null && extends_.eIsProxy())
    {
      InternalEObject oldExtends = (InternalEObject)extends_;
      extends_ = (JvmType)eResolveProxy(oldExtends);
      if (extends_ != oldExtends)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ProcessorDslPackage.EXTENDS__EXTENDS, oldExtends, extends_));
      }
    }
    return extends_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public JvmType basicGetExtends()
  {
    return extends_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setExtends(JvmType newExtends)
  {
    JvmType oldExtends = extends_;
    extends_ = newExtends;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ProcessorDslPackage.EXTENDS__EXTENDS, oldExtends, extends_));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isGenerics()
  {
    return generics;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setGenerics(boolean newGenerics)
  {
    boolean oldGenerics = generics;
    generics = newGenerics;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ProcessorDslPackage.EXTENDS__GENERICS, oldGenerics, generics));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<PojoEntity> getOnlyPojos()
  {
    if (onlyPojos == null)
    {
      onlyPojos = new EObjectResolvingEList<PojoEntity>(PojoEntity.class, this, ProcessorDslPackage.EXTENDS__ONLY_POJOS);
    }
    return onlyPojos;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<PojoDao> getOnlyDaos()
  {
    if (onlyDaos == null)
    {
      onlyDaos = new EObjectResolvingEList<PojoDao>(PojoDao.class, this, ProcessorDslPackage.EXTENDS__ONLY_DAOS);
    }
    return onlyDaos;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<PojoEntity> getExceptPojos()
  {
    if (exceptPojos == null)
    {
      exceptPojos = new EObjectResolvingEList<PojoEntity>(PojoEntity.class, this, ProcessorDslPackage.EXTENDS__EXCEPT_POJOS);
    }
    return exceptPojos;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<PojoDao> getExceptDaos()
  {
    if (exceptDaos == null)
    {
      exceptDaos = new EObjectResolvingEList<PojoDao>(PojoDao.class, this, ProcessorDslPackage.EXTENDS__EXCEPT_DAOS);
    }
    return exceptDaos;
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
      case ProcessorDslPackage.EXTENDS__EXTENDS:
        if (resolve) return getExtends();
        return basicGetExtends();
      case ProcessorDslPackage.EXTENDS__GENERICS:
        return isGenerics();
      case ProcessorDslPackage.EXTENDS__ONLY_POJOS:
        return getOnlyPojos();
      case ProcessorDslPackage.EXTENDS__ONLY_DAOS:
        return getOnlyDaos();
      case ProcessorDslPackage.EXTENDS__EXCEPT_POJOS:
        return getExceptPojos();
      case ProcessorDslPackage.EXTENDS__EXCEPT_DAOS:
        return getExceptDaos();
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
      case ProcessorDslPackage.EXTENDS__EXTENDS:
        setExtends((JvmType)newValue);
        return;
      case ProcessorDslPackage.EXTENDS__GENERICS:
        setGenerics((Boolean)newValue);
        return;
      case ProcessorDslPackage.EXTENDS__ONLY_POJOS:
        getOnlyPojos().clear();
        getOnlyPojos().addAll((Collection<? extends PojoEntity>)newValue);
        return;
      case ProcessorDslPackage.EXTENDS__ONLY_DAOS:
        getOnlyDaos().clear();
        getOnlyDaos().addAll((Collection<? extends PojoDao>)newValue);
        return;
      case ProcessorDslPackage.EXTENDS__EXCEPT_POJOS:
        getExceptPojos().clear();
        getExceptPojos().addAll((Collection<? extends PojoEntity>)newValue);
        return;
      case ProcessorDslPackage.EXTENDS__EXCEPT_DAOS:
        getExceptDaos().clear();
        getExceptDaos().addAll((Collection<? extends PojoDao>)newValue);
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
      case ProcessorDslPackage.EXTENDS__EXTENDS:
        setExtends((JvmType)null);
        return;
      case ProcessorDslPackage.EXTENDS__GENERICS:
        setGenerics(GENERICS_EDEFAULT);
        return;
      case ProcessorDslPackage.EXTENDS__ONLY_POJOS:
        getOnlyPojos().clear();
        return;
      case ProcessorDslPackage.EXTENDS__ONLY_DAOS:
        getOnlyDaos().clear();
        return;
      case ProcessorDslPackage.EXTENDS__EXCEPT_POJOS:
        getExceptPojos().clear();
        return;
      case ProcessorDslPackage.EXTENDS__EXCEPT_DAOS:
        getExceptDaos().clear();
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
      case ProcessorDslPackage.EXTENDS__EXTENDS:
        return extends_ != null;
      case ProcessorDslPackage.EXTENDS__GENERICS:
        return generics != GENERICS_EDEFAULT;
      case ProcessorDslPackage.EXTENDS__ONLY_POJOS:
        return onlyPojos != null && !onlyPojos.isEmpty();
      case ProcessorDslPackage.EXTENDS__ONLY_DAOS:
        return onlyDaos != null && !onlyDaos.isEmpty();
      case ProcessorDslPackage.EXTENDS__EXCEPT_POJOS:
        return exceptPojos != null && !exceptPojos.isEmpty();
      case ProcessorDslPackage.EXTENDS__EXCEPT_DAOS:
        return exceptDaos != null && !exceptDaos.isEmpty();
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
    result.append(" (generics: ");
    result.append(generics);
    result.append(')');
    return result.toString();
  }

} //ExtendsImpl
