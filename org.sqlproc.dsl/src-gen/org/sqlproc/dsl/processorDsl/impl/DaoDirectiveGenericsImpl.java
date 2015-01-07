/**
 */
package org.sqlproc.dsl.processorDsl.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.sqlproc.dsl.processorDsl.DaoDirectiveGenerics;
import org.sqlproc.dsl.processorDsl.PojoType;
import org.sqlproc.dsl.processorDsl.ProcessorDslPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Dao Directive Generics</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.sqlproc.dsl.processorDsl.impl.DaoDirectiveGenericsImpl#getGenerics <em>Generics</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DaoDirectiveGenericsImpl extends DaoDirectiveImpl implements DaoDirectiveGenerics
{
  /**
   * The cached value of the '{@link #getGenerics() <em>Generics</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getGenerics()
   * @generated
   * @ordered
   */
  protected PojoType generics;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected DaoDirectiveGenericsImpl()
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
    return ProcessorDslPackage.eINSTANCE.getDaoDirectiveGenerics();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PojoType getGenerics()
  {
    return generics;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetGenerics(PojoType newGenerics, NotificationChain msgs)
  {
    PojoType oldGenerics = generics;
    generics = newGenerics;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ProcessorDslPackage.DAO_DIRECTIVE_GENERICS__GENERICS, oldGenerics, newGenerics);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setGenerics(PojoType newGenerics)
  {
    if (newGenerics != generics)
    {
      NotificationChain msgs = null;
      if (generics != null)
        msgs = ((InternalEObject)generics).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ProcessorDslPackage.DAO_DIRECTIVE_GENERICS__GENERICS, null, msgs);
      if (newGenerics != null)
        msgs = ((InternalEObject)newGenerics).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ProcessorDslPackage.DAO_DIRECTIVE_GENERICS__GENERICS, null, msgs);
      msgs = basicSetGenerics(newGenerics, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ProcessorDslPackage.DAO_DIRECTIVE_GENERICS__GENERICS, newGenerics, newGenerics));
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
      case ProcessorDslPackage.DAO_DIRECTIVE_GENERICS__GENERICS:
        return basicSetGenerics(null, msgs);
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
      case ProcessorDslPackage.DAO_DIRECTIVE_GENERICS__GENERICS:
        return getGenerics();
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
      case ProcessorDslPackage.DAO_DIRECTIVE_GENERICS__GENERICS:
        setGenerics((PojoType)newValue);
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
      case ProcessorDslPackage.DAO_DIRECTIVE_GENERICS__GENERICS:
        setGenerics((PojoType)null);
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
      case ProcessorDslPackage.DAO_DIRECTIVE_GENERICS__GENERICS:
        return generics != null;
    }
    return super.eIsSet(featureID);
  }

} //DaoDirectiveGenericsImpl
