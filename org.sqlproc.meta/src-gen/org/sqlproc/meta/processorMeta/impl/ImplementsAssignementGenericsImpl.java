/**
 */
package org.sqlproc.meta.processorMeta.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeEList;

import org.sqlproc.meta.processorMeta.ImplementsAssignementGenerics;
import org.sqlproc.meta.processorMeta.PojoType;
import org.sqlproc.meta.processorMeta.ProcessorMetaPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Implements Assignement Generics</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.sqlproc.meta.processorMeta.impl.ImplementsAssignementGenericsImpl#getToImplement <em>To Implement</em>}</li>
 *   <li>{@link org.sqlproc.meta.processorMeta.impl.ImplementsAssignementGenericsImpl#getDbTables <em>Db Tables</em>}</li>
 *   <li>{@link org.sqlproc.meta.processorMeta.impl.ImplementsAssignementGenericsImpl#getDbNotTables <em>Db Not Tables</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ImplementsAssignementGenericsImpl extends MinimalEObjectImpl.Container implements ImplementsAssignementGenerics
{
  /**
   * The cached value of the '{@link #getToImplement() <em>To Implement</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getToImplement()
   * @generated
   * @ordered
   */
  protected PojoType toImplement;

  /**
   * The cached value of the '{@link #getDbTables() <em>Db Tables</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDbTables()
   * @generated
   * @ordered
   */
  protected EList<String> dbTables;

  /**
   * The cached value of the '{@link #getDbNotTables() <em>Db Not Tables</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDbNotTables()
   * @generated
   * @ordered
   */
  protected EList<String> dbNotTables;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ImplementsAssignementGenericsImpl()
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
    return ProcessorMetaPackage.Literals.IMPLEMENTS_ASSIGNEMENT_GENERICS;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PojoType getToImplement()
  {
    return toImplement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetToImplement(PojoType newToImplement, NotificationChain msgs)
  {
    PojoType oldToImplement = toImplement;
    toImplement = newToImplement;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ProcessorMetaPackage.IMPLEMENTS_ASSIGNEMENT_GENERICS__TO_IMPLEMENT, oldToImplement, newToImplement);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setToImplement(PojoType newToImplement)
  {
    if (newToImplement != toImplement)
    {
      NotificationChain msgs = null;
      if (toImplement != null)
        msgs = ((InternalEObject)toImplement).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ProcessorMetaPackage.IMPLEMENTS_ASSIGNEMENT_GENERICS__TO_IMPLEMENT, null, msgs);
      if (newToImplement != null)
        msgs = ((InternalEObject)newToImplement).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ProcessorMetaPackage.IMPLEMENTS_ASSIGNEMENT_GENERICS__TO_IMPLEMENT, null, msgs);
      msgs = basicSetToImplement(newToImplement, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ProcessorMetaPackage.IMPLEMENTS_ASSIGNEMENT_GENERICS__TO_IMPLEMENT, newToImplement, newToImplement));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<String> getDbTables()
  {
    if (dbTables == null)
    {
      dbTables = new EDataTypeEList<String>(String.class, this, ProcessorMetaPackage.IMPLEMENTS_ASSIGNEMENT_GENERICS__DB_TABLES);
    }
    return dbTables;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<String> getDbNotTables()
  {
    if (dbNotTables == null)
    {
      dbNotTables = new EDataTypeEList<String>(String.class, this, ProcessorMetaPackage.IMPLEMENTS_ASSIGNEMENT_GENERICS__DB_NOT_TABLES);
    }
    return dbNotTables;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case ProcessorMetaPackage.IMPLEMENTS_ASSIGNEMENT_GENERICS__TO_IMPLEMENT:
        return basicSetToImplement(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
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
      case ProcessorMetaPackage.IMPLEMENTS_ASSIGNEMENT_GENERICS__TO_IMPLEMENT:
        return getToImplement();
      case ProcessorMetaPackage.IMPLEMENTS_ASSIGNEMENT_GENERICS__DB_TABLES:
        return getDbTables();
      case ProcessorMetaPackage.IMPLEMENTS_ASSIGNEMENT_GENERICS__DB_NOT_TABLES:
        return getDbNotTables();
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
      case ProcessorMetaPackage.IMPLEMENTS_ASSIGNEMENT_GENERICS__TO_IMPLEMENT:
        setToImplement((PojoType)newValue);
        return;
      case ProcessorMetaPackage.IMPLEMENTS_ASSIGNEMENT_GENERICS__DB_TABLES:
        getDbTables().clear();
        getDbTables().addAll((Collection<? extends String>)newValue);
        return;
      case ProcessorMetaPackage.IMPLEMENTS_ASSIGNEMENT_GENERICS__DB_NOT_TABLES:
        getDbNotTables().clear();
        getDbNotTables().addAll((Collection<? extends String>)newValue);
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
      case ProcessorMetaPackage.IMPLEMENTS_ASSIGNEMENT_GENERICS__TO_IMPLEMENT:
        setToImplement((PojoType)null);
        return;
      case ProcessorMetaPackage.IMPLEMENTS_ASSIGNEMENT_GENERICS__DB_TABLES:
        getDbTables().clear();
        return;
      case ProcessorMetaPackage.IMPLEMENTS_ASSIGNEMENT_GENERICS__DB_NOT_TABLES:
        getDbNotTables().clear();
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
      case ProcessorMetaPackage.IMPLEMENTS_ASSIGNEMENT_GENERICS__TO_IMPLEMENT:
        return toImplement != null;
      case ProcessorMetaPackage.IMPLEMENTS_ASSIGNEMENT_GENERICS__DB_TABLES:
        return dbTables != null && !dbTables.isEmpty();
      case ProcessorMetaPackage.IMPLEMENTS_ASSIGNEMENT_GENERICS__DB_NOT_TABLES:
        return dbNotTables != null && !dbNotTables.isEmpty();
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
    result.append(" (dbTables: ");
    result.append(dbTables);
    result.append(", dbNotTables: ");
    result.append(dbNotTables);
    result.append(')');
    return result.toString();
  }

} //ImplementsAssignementGenericsImpl
