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
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.sqlproc.dsl.processorDsl.Annotation;
import org.sqlproc.dsl.processorDsl.PojoAnnotatedProperty;
import org.sqlproc.dsl.processorDsl.PojoProperty;
import org.sqlproc.dsl.processorDsl.ProcessorDslPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Pojo Annotated Property</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.sqlproc.dsl.processorDsl.impl.PojoAnnotatedPropertyImpl#getSetterAnnotations <em>Setter Annotations</em>}</li>
 *   <li>{@link org.sqlproc.dsl.processorDsl.impl.PojoAnnotatedPropertyImpl#getGetterAnnotations <em>Getter Annotations</em>}</li>
 *   <li>{@link org.sqlproc.dsl.processorDsl.impl.PojoAnnotatedPropertyImpl#getAttributeAnnotations <em>Attribute Annotations</em>}</li>
 *   <li>{@link org.sqlproc.dsl.processorDsl.impl.PojoAnnotatedPropertyImpl#getFeature <em>Feature</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PojoAnnotatedPropertyImpl extends MinimalEObjectImpl.Container implements PojoAnnotatedProperty
{
  /**
   * The cached value of the '{@link #getSetterAnnotations() <em>Setter Annotations</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSetterAnnotations()
   * @generated
   * @ordered
   */
  protected EList<Annotation> setterAnnotations;

  /**
   * The cached value of the '{@link #getGetterAnnotations() <em>Getter Annotations</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getGetterAnnotations()
   * @generated
   * @ordered
   */
  protected EList<Annotation> getterAnnotations;

  /**
   * The cached value of the '{@link #getAttributeAnnotations() <em>Attribute Annotations</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAttributeAnnotations()
   * @generated
   * @ordered
   */
  protected EList<Annotation> attributeAnnotations;

  /**
   * The cached value of the '{@link #getFeature() <em>Feature</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFeature()
   * @generated
   * @ordered
   */
  protected PojoProperty feature;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected PojoAnnotatedPropertyImpl()
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
    return ProcessorDslPackage.Literals.POJO_ANNOTATED_PROPERTY;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Annotation> getSetterAnnotations()
  {
    if (setterAnnotations == null)
    {
      setterAnnotations = new EObjectContainmentEList<Annotation>(Annotation.class, this, ProcessorDslPackage.POJO_ANNOTATED_PROPERTY__SETTER_ANNOTATIONS);
    }
    return setterAnnotations;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Annotation> getGetterAnnotations()
  {
    if (getterAnnotations == null)
    {
      getterAnnotations = new EObjectContainmentEList<Annotation>(Annotation.class, this, ProcessorDslPackage.POJO_ANNOTATED_PROPERTY__GETTER_ANNOTATIONS);
    }
    return getterAnnotations;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Annotation> getAttributeAnnotations()
  {
    if (attributeAnnotations == null)
    {
      attributeAnnotations = new EObjectContainmentEList<Annotation>(Annotation.class, this, ProcessorDslPackage.POJO_ANNOTATED_PROPERTY__ATTRIBUTE_ANNOTATIONS);
    }
    return attributeAnnotations;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PojoProperty getFeature()
  {
    return feature;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetFeature(PojoProperty newFeature, NotificationChain msgs)
  {
    PojoProperty oldFeature = feature;
    feature = newFeature;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ProcessorDslPackage.POJO_ANNOTATED_PROPERTY__FEATURE, oldFeature, newFeature);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setFeature(PojoProperty newFeature)
  {
    if (newFeature != feature)
    {
      NotificationChain msgs = null;
      if (feature != null)
        msgs = ((InternalEObject)feature).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ProcessorDslPackage.POJO_ANNOTATED_PROPERTY__FEATURE, null, msgs);
      if (newFeature != null)
        msgs = ((InternalEObject)newFeature).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ProcessorDslPackage.POJO_ANNOTATED_PROPERTY__FEATURE, null, msgs);
      msgs = basicSetFeature(newFeature, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ProcessorDslPackage.POJO_ANNOTATED_PROPERTY__FEATURE, newFeature, newFeature));
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
      case ProcessorDslPackage.POJO_ANNOTATED_PROPERTY__SETTER_ANNOTATIONS:
        return ((InternalEList<?>)getSetterAnnotations()).basicRemove(otherEnd, msgs);
      case ProcessorDslPackage.POJO_ANNOTATED_PROPERTY__GETTER_ANNOTATIONS:
        return ((InternalEList<?>)getGetterAnnotations()).basicRemove(otherEnd, msgs);
      case ProcessorDslPackage.POJO_ANNOTATED_PROPERTY__ATTRIBUTE_ANNOTATIONS:
        return ((InternalEList<?>)getAttributeAnnotations()).basicRemove(otherEnd, msgs);
      case ProcessorDslPackage.POJO_ANNOTATED_PROPERTY__FEATURE:
        return basicSetFeature(null, msgs);
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
      case ProcessorDslPackage.POJO_ANNOTATED_PROPERTY__SETTER_ANNOTATIONS:
        return getSetterAnnotations();
      case ProcessorDslPackage.POJO_ANNOTATED_PROPERTY__GETTER_ANNOTATIONS:
        return getGetterAnnotations();
      case ProcessorDslPackage.POJO_ANNOTATED_PROPERTY__ATTRIBUTE_ANNOTATIONS:
        return getAttributeAnnotations();
      case ProcessorDslPackage.POJO_ANNOTATED_PROPERTY__FEATURE:
        return getFeature();
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
      case ProcessorDslPackage.POJO_ANNOTATED_PROPERTY__SETTER_ANNOTATIONS:
        getSetterAnnotations().clear();
        getSetterAnnotations().addAll((Collection<? extends Annotation>)newValue);
        return;
      case ProcessorDslPackage.POJO_ANNOTATED_PROPERTY__GETTER_ANNOTATIONS:
        getGetterAnnotations().clear();
        getGetterAnnotations().addAll((Collection<? extends Annotation>)newValue);
        return;
      case ProcessorDslPackage.POJO_ANNOTATED_PROPERTY__ATTRIBUTE_ANNOTATIONS:
        getAttributeAnnotations().clear();
        getAttributeAnnotations().addAll((Collection<? extends Annotation>)newValue);
        return;
      case ProcessorDslPackage.POJO_ANNOTATED_PROPERTY__FEATURE:
        setFeature((PojoProperty)newValue);
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
      case ProcessorDslPackage.POJO_ANNOTATED_PROPERTY__SETTER_ANNOTATIONS:
        getSetterAnnotations().clear();
        return;
      case ProcessorDslPackage.POJO_ANNOTATED_PROPERTY__GETTER_ANNOTATIONS:
        getGetterAnnotations().clear();
        return;
      case ProcessorDslPackage.POJO_ANNOTATED_PROPERTY__ATTRIBUTE_ANNOTATIONS:
        getAttributeAnnotations().clear();
        return;
      case ProcessorDslPackage.POJO_ANNOTATED_PROPERTY__FEATURE:
        setFeature((PojoProperty)null);
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
      case ProcessorDslPackage.POJO_ANNOTATED_PROPERTY__SETTER_ANNOTATIONS:
        return setterAnnotations != null && !setterAnnotations.isEmpty();
      case ProcessorDslPackage.POJO_ANNOTATED_PROPERTY__GETTER_ANNOTATIONS:
        return getterAnnotations != null && !getterAnnotations.isEmpty();
      case ProcessorDslPackage.POJO_ANNOTATED_PROPERTY__ATTRIBUTE_ANNOTATIONS:
        return attributeAnnotations != null && !attributeAnnotations.isEmpty();
      case ProcessorDslPackage.POJO_ANNOTATED_PROPERTY__FEATURE:
        return feature != null;
    }
    return super.eIsSet(featureID);
  }

} //PojoAnnotatedPropertyImpl
