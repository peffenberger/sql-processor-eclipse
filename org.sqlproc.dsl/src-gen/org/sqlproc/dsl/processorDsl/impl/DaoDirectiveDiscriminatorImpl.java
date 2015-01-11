/**
 */
package org.sqlproc.dsl.processorDsl.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.sqlproc.dsl.processorDsl.DaoDirectiveDiscriminator;
import org.sqlproc.dsl.processorDsl.DescendantAssignment;
import org.sqlproc.dsl.processorDsl.PojoProperty;
import org.sqlproc.dsl.processorDsl.ProcessorDslPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Dao Directive Discriminator</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.sqlproc.dsl.processorDsl.impl.DaoDirectiveDiscriminatorImpl#getAncestor <em>Ancestor</em>}</li>
 *   <li>{@link org.sqlproc.dsl.processorDsl.impl.DaoDirectiveDiscriminatorImpl#getDescendants <em>Descendants</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DaoDirectiveDiscriminatorImpl extends DaoDirectiveImpl implements DaoDirectiveDiscriminator
{
  /**
   * The cached value of the '{@link #getAncestor() <em>Ancestor</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAncestor()
   * @generated
   * @ordered
   */
  protected PojoProperty ancestor;

  /**
   * The cached value of the '{@link #getDescendants() <em>Descendants</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDescendants()
   * @generated
   * @ordered
   */
  protected EList<DescendantAssignment> descendants;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected DaoDirectiveDiscriminatorImpl()
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
    return ProcessorDslPackage.Literals.DAO_DIRECTIVE_DISCRIMINATOR;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PojoProperty getAncestor()
  {
    return ancestor;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetAncestor(PojoProperty newAncestor, NotificationChain msgs)
  {
    PojoProperty oldAncestor = ancestor;
    ancestor = newAncestor;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ProcessorDslPackage.DAO_DIRECTIVE_DISCRIMINATOR__ANCESTOR, oldAncestor, newAncestor);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAncestor(PojoProperty newAncestor)
  {
    if (newAncestor != ancestor)
    {
      NotificationChain msgs = null;
      if (ancestor != null)
        msgs = ((InternalEObject)ancestor).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ProcessorDslPackage.DAO_DIRECTIVE_DISCRIMINATOR__ANCESTOR, null, msgs);
      if (newAncestor != null)
        msgs = ((InternalEObject)newAncestor).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ProcessorDslPackage.DAO_DIRECTIVE_DISCRIMINATOR__ANCESTOR, null, msgs);
      msgs = basicSetAncestor(newAncestor, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ProcessorDslPackage.DAO_DIRECTIVE_DISCRIMINATOR__ANCESTOR, newAncestor, newAncestor));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<DescendantAssignment> getDescendants()
  {
    if (descendants == null)
    {
      descendants = new EObjectContainmentEList<DescendantAssignment>(DescendantAssignment.class, this, ProcessorDslPackage.DAO_DIRECTIVE_DISCRIMINATOR__DESCENDANTS);
    }
    return descendants;
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
      case ProcessorDslPackage.DAO_DIRECTIVE_DISCRIMINATOR__ANCESTOR:
        return basicSetAncestor(null, msgs);
      case ProcessorDslPackage.DAO_DIRECTIVE_DISCRIMINATOR__DESCENDANTS:
        return ((InternalEList<?>)getDescendants()).basicRemove(otherEnd, msgs);
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
      case ProcessorDslPackage.DAO_DIRECTIVE_DISCRIMINATOR__ANCESTOR:
        return getAncestor();
      case ProcessorDslPackage.DAO_DIRECTIVE_DISCRIMINATOR__DESCENDANTS:
        return getDescendants();
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
      case ProcessorDslPackage.DAO_DIRECTIVE_DISCRIMINATOR__ANCESTOR:
        setAncestor((PojoProperty)newValue);
        return;
      case ProcessorDslPackage.DAO_DIRECTIVE_DISCRIMINATOR__DESCENDANTS:
        getDescendants().clear();
        getDescendants().addAll((Collection<? extends DescendantAssignment>)newValue);
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
      case ProcessorDslPackage.DAO_DIRECTIVE_DISCRIMINATOR__ANCESTOR:
        setAncestor((PojoProperty)null);
        return;
      case ProcessorDslPackage.DAO_DIRECTIVE_DISCRIMINATOR__DESCENDANTS:
        getDescendants().clear();
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
      case ProcessorDslPackage.DAO_DIRECTIVE_DISCRIMINATOR__ANCESTOR:
        return ancestor != null;
      case ProcessorDslPackage.DAO_DIRECTIVE_DISCRIMINATOR__DESCENDANTS:
        return descendants != null && !descendants.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //DaoDirectiveDiscriminatorImpl
