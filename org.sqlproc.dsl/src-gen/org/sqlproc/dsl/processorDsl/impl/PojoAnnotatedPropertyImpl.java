/**
 */
package org.sqlproc.dsl.processorDsl.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

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
 *   <li>{@link org.sqlproc.dsl.processorDsl.impl.PojoAnnotatedPropertyImpl#getSetterAnnotation <em>Setter Annotation</em>}</li>
 *   <li>{@link org.sqlproc.dsl.processorDsl.impl.PojoAnnotatedPropertyImpl#getGetterAnnotation <em>Getter Annotation</em>}</li>
 *   <li>{@link org.sqlproc.dsl.processorDsl.impl.PojoAnnotatedPropertyImpl#getAttributeAnnotation <em>Attribute Annotation</em>}</li>
 *   <li>{@link org.sqlproc.dsl.processorDsl.impl.PojoAnnotatedPropertyImpl#getFeature <em>Feature</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PojoAnnotatedPropertyImpl extends MinimalEObjectImpl.Container implements PojoAnnotatedProperty
{
  /**
   * The cached value of the '{@link #getSetterAnnotation() <em>Setter Annotation</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSetterAnnotation()
   * @generated
   * @ordered
   */
  protected Annotation setterAnnotation;

  /**
   * The cached value of the '{@link #getGetterAnnotation() <em>Getter Annotation</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getGetterAnnotation()
   * @generated
   * @ordered
   */
  protected Annotation getterAnnotation;

  /**
   * The cached value of the '{@link #getAttributeAnnotation() <em>Attribute Annotation</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAttributeAnnotation()
   * @generated
   * @ordered
   */
  protected Annotation attributeAnnotation;

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
  public Annotation getSetterAnnotation()
  {
    return setterAnnotation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetSetterAnnotation(Annotation newSetterAnnotation, NotificationChain msgs)
  {
    Annotation oldSetterAnnotation = setterAnnotation;
    setterAnnotation = newSetterAnnotation;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ProcessorDslPackage.POJO_ANNOTATED_PROPERTY__SETTER_ANNOTATION, oldSetterAnnotation, newSetterAnnotation);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSetterAnnotation(Annotation newSetterAnnotation)
  {
    if (newSetterAnnotation != setterAnnotation)
    {
      NotificationChain msgs = null;
      if (setterAnnotation != null)
        msgs = ((InternalEObject)setterAnnotation).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ProcessorDslPackage.POJO_ANNOTATED_PROPERTY__SETTER_ANNOTATION, null, msgs);
      if (newSetterAnnotation != null)
        msgs = ((InternalEObject)newSetterAnnotation).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ProcessorDslPackage.POJO_ANNOTATED_PROPERTY__SETTER_ANNOTATION, null, msgs);
      msgs = basicSetSetterAnnotation(newSetterAnnotation, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ProcessorDslPackage.POJO_ANNOTATED_PROPERTY__SETTER_ANNOTATION, newSetterAnnotation, newSetterAnnotation));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Annotation getGetterAnnotation()
  {
    return getterAnnotation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetGetterAnnotation(Annotation newGetterAnnotation, NotificationChain msgs)
  {
    Annotation oldGetterAnnotation = getterAnnotation;
    getterAnnotation = newGetterAnnotation;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ProcessorDslPackage.POJO_ANNOTATED_PROPERTY__GETTER_ANNOTATION, oldGetterAnnotation, newGetterAnnotation);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setGetterAnnotation(Annotation newGetterAnnotation)
  {
    if (newGetterAnnotation != getterAnnotation)
    {
      NotificationChain msgs = null;
      if (getterAnnotation != null)
        msgs = ((InternalEObject)getterAnnotation).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ProcessorDslPackage.POJO_ANNOTATED_PROPERTY__GETTER_ANNOTATION, null, msgs);
      if (newGetterAnnotation != null)
        msgs = ((InternalEObject)newGetterAnnotation).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ProcessorDslPackage.POJO_ANNOTATED_PROPERTY__GETTER_ANNOTATION, null, msgs);
      msgs = basicSetGetterAnnotation(newGetterAnnotation, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ProcessorDslPackage.POJO_ANNOTATED_PROPERTY__GETTER_ANNOTATION, newGetterAnnotation, newGetterAnnotation));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Annotation getAttributeAnnotation()
  {
    return attributeAnnotation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetAttributeAnnotation(Annotation newAttributeAnnotation, NotificationChain msgs)
  {
    Annotation oldAttributeAnnotation = attributeAnnotation;
    attributeAnnotation = newAttributeAnnotation;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ProcessorDslPackage.POJO_ANNOTATED_PROPERTY__ATTRIBUTE_ANNOTATION, oldAttributeAnnotation, newAttributeAnnotation);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAttributeAnnotation(Annotation newAttributeAnnotation)
  {
    if (newAttributeAnnotation != attributeAnnotation)
    {
      NotificationChain msgs = null;
      if (attributeAnnotation != null)
        msgs = ((InternalEObject)attributeAnnotation).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ProcessorDslPackage.POJO_ANNOTATED_PROPERTY__ATTRIBUTE_ANNOTATION, null, msgs);
      if (newAttributeAnnotation != null)
        msgs = ((InternalEObject)newAttributeAnnotation).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ProcessorDslPackage.POJO_ANNOTATED_PROPERTY__ATTRIBUTE_ANNOTATION, null, msgs);
      msgs = basicSetAttributeAnnotation(newAttributeAnnotation, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ProcessorDslPackage.POJO_ANNOTATED_PROPERTY__ATTRIBUTE_ANNOTATION, newAttributeAnnotation, newAttributeAnnotation));
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
      case ProcessorDslPackage.POJO_ANNOTATED_PROPERTY__SETTER_ANNOTATION:
        return basicSetSetterAnnotation(null, msgs);
      case ProcessorDslPackage.POJO_ANNOTATED_PROPERTY__GETTER_ANNOTATION:
        return basicSetGetterAnnotation(null, msgs);
      case ProcessorDslPackage.POJO_ANNOTATED_PROPERTY__ATTRIBUTE_ANNOTATION:
        return basicSetAttributeAnnotation(null, msgs);
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
      case ProcessorDslPackage.POJO_ANNOTATED_PROPERTY__SETTER_ANNOTATION:
        return getSetterAnnotation();
      case ProcessorDslPackage.POJO_ANNOTATED_PROPERTY__GETTER_ANNOTATION:
        return getGetterAnnotation();
      case ProcessorDslPackage.POJO_ANNOTATED_PROPERTY__ATTRIBUTE_ANNOTATION:
        return getAttributeAnnotation();
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
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case ProcessorDslPackage.POJO_ANNOTATED_PROPERTY__SETTER_ANNOTATION:
        setSetterAnnotation((Annotation)newValue);
        return;
      case ProcessorDslPackage.POJO_ANNOTATED_PROPERTY__GETTER_ANNOTATION:
        setGetterAnnotation((Annotation)newValue);
        return;
      case ProcessorDslPackage.POJO_ANNOTATED_PROPERTY__ATTRIBUTE_ANNOTATION:
        setAttributeAnnotation((Annotation)newValue);
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
      case ProcessorDslPackage.POJO_ANNOTATED_PROPERTY__SETTER_ANNOTATION:
        setSetterAnnotation((Annotation)null);
        return;
      case ProcessorDslPackage.POJO_ANNOTATED_PROPERTY__GETTER_ANNOTATION:
        setGetterAnnotation((Annotation)null);
        return;
      case ProcessorDslPackage.POJO_ANNOTATED_PROPERTY__ATTRIBUTE_ANNOTATION:
        setAttributeAnnotation((Annotation)null);
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
      case ProcessorDslPackage.POJO_ANNOTATED_PROPERTY__SETTER_ANNOTATION:
        return setterAnnotation != null;
      case ProcessorDslPackage.POJO_ANNOTATED_PROPERTY__GETTER_ANNOTATION:
        return getterAnnotation != null;
      case ProcessorDslPackage.POJO_ANNOTATED_PROPERTY__ATTRIBUTE_ANNOTATION:
        return attributeAnnotation != null;
      case ProcessorDslPackage.POJO_ANNOTATED_PROPERTY__FEATURE:
        return feature != null;
    }
    return super.eIsSet(featureID);
  }

} //PojoAnnotatedPropertyImpl
