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

import org.sqlproc.dsl.processorDsl.EntityAnnotation;
import org.sqlproc.dsl.processorDsl.PojoDirective;
import org.sqlproc.dsl.processorDsl.PojoEntity;
import org.sqlproc.dsl.processorDsl.PojoProperty;
import org.sqlproc.dsl.processorDsl.ProcessorDslPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Pojo Entity</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.sqlproc.dsl.processorDsl.impl.PojoEntityImpl#getAnnotations <em>Annotations</em>}</li>
 *   <li>{@link org.sqlproc.dsl.processorDsl.impl.PojoEntityImpl#getDirectives <em>Directives</em>}</li>
 *   <li>{@link org.sqlproc.dsl.processorDsl.impl.PojoEntityImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.sqlproc.dsl.processorDsl.impl.PojoEntityImpl#getFeatures <em>Features</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PojoEntityImpl extends AbstractEntityImpl implements PojoEntity
{
  /**
   * The cached value of the '{@link #getAnnotations() <em>Annotations</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAnnotations()
   * @generated
   * @ordered
   */
  protected EList<EntityAnnotation> annotations;

  /**
   * The cached value of the '{@link #getDirectives() <em>Directives</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDirectives()
   * @generated
   * @ordered
   */
  protected EList<PojoDirective> directives;

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
   * The cached value of the '{@link #getFeatures() <em>Features</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFeatures()
   * @generated
   * @ordered
   */
  protected EList<PojoProperty> features;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected PojoEntityImpl()
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
    return ProcessorDslPackage.Literals.POJO_ENTITY;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<EntityAnnotation> getAnnotations()
  {
    if (annotations == null)
    {
      annotations = new EObjectContainmentEList<EntityAnnotation>(EntityAnnotation.class, this, ProcessorDslPackage.POJO_ENTITY__ANNOTATIONS);
    }
    return annotations;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<PojoDirective> getDirectives()
  {
    if (directives == null)
    {
      directives = new EObjectContainmentEList<PojoDirective>(PojoDirective.class, this, ProcessorDslPackage.POJO_ENTITY__DIRECTIVES);
    }
    return directives;
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
      eNotify(new ENotificationImpl(this, Notification.SET, ProcessorDslPackage.POJO_ENTITY__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<PojoProperty> getFeatures()
  {
    if (features == null)
    {
      features = new EObjectContainmentEList<PojoProperty>(PojoProperty.class, this, ProcessorDslPackage.POJO_ENTITY__FEATURES);
    }
    return features;
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
      case ProcessorDslPackage.POJO_ENTITY__ANNOTATIONS:
        return ((InternalEList<?>)getAnnotations()).basicRemove(otherEnd, msgs);
      case ProcessorDslPackage.POJO_ENTITY__DIRECTIVES:
        return ((InternalEList<?>)getDirectives()).basicRemove(otherEnd, msgs);
      case ProcessorDslPackage.POJO_ENTITY__FEATURES:
        return ((InternalEList<?>)getFeatures()).basicRemove(otherEnd, msgs);
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
      case ProcessorDslPackage.POJO_ENTITY__ANNOTATIONS:
        return getAnnotations();
      case ProcessorDslPackage.POJO_ENTITY__DIRECTIVES:
        return getDirectives();
      case ProcessorDslPackage.POJO_ENTITY__NAME:
        return getName();
      case ProcessorDslPackage.POJO_ENTITY__FEATURES:
        return getFeatures();
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
      case ProcessorDslPackage.POJO_ENTITY__ANNOTATIONS:
        getAnnotations().clear();
        getAnnotations().addAll((Collection<? extends EntityAnnotation>)newValue);
        return;
      case ProcessorDslPackage.POJO_ENTITY__DIRECTIVES:
        getDirectives().clear();
        getDirectives().addAll((Collection<? extends PojoDirective>)newValue);
        return;
      case ProcessorDslPackage.POJO_ENTITY__NAME:
        setName((String)newValue);
        return;
      case ProcessorDslPackage.POJO_ENTITY__FEATURES:
        getFeatures().clear();
        getFeatures().addAll((Collection<? extends PojoProperty>)newValue);
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
      case ProcessorDslPackage.POJO_ENTITY__ANNOTATIONS:
        getAnnotations().clear();
        return;
      case ProcessorDslPackage.POJO_ENTITY__DIRECTIVES:
        getDirectives().clear();
        return;
      case ProcessorDslPackage.POJO_ENTITY__NAME:
        setName(NAME_EDEFAULT);
        return;
      case ProcessorDslPackage.POJO_ENTITY__FEATURES:
        getFeatures().clear();
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
      case ProcessorDslPackage.POJO_ENTITY__ANNOTATIONS:
        return annotations != null && !annotations.isEmpty();
      case ProcessorDslPackage.POJO_ENTITY__DIRECTIVES:
        return directives != null && !directives.isEmpty();
      case ProcessorDslPackage.POJO_ENTITY__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case ProcessorDslPackage.POJO_ENTITY__FEATURES:
        return features != null && !features.isEmpty();
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
    result.append(')');
    return result.toString();
  }

} //PojoEntityImpl
