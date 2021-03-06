/**
 */
package org.sqlproc.model.processorModel.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.sqlproc.model.processorModel.PojoAttributeDirectivePrimaryKey;
import org.sqlproc.model.processorModel.ProcessorModelPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Pojo Attribute Directive Primary Key</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.sqlproc.model.processorModel.impl.PojoAttributeDirectivePrimaryKeyImpl#getFromTo <em>From To</em>}</li>
 *   <li>{@link org.sqlproc.model.processorModel.impl.PojoAttributeDirectivePrimaryKeyImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.sqlproc.model.processorModel.impl.PojoAttributeDirectivePrimaryKeyImpl#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PojoAttributeDirectivePrimaryKeyImpl extends PojoAttributeDirectiveImpl implements PojoAttributeDirectivePrimaryKey
{
  /**
   * The default value of the '{@link #getFromTo() <em>From To</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFromTo()
   * @generated
   * @ordered
   */
  protected static final String FROM_TO_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getFromTo() <em>From To</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFromTo()
   * @generated
   * @ordered
   */
  protected String fromTo = FROM_TO_EDEFAULT;

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
   * The default value of the '{@link #getType() <em>Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getType()
   * @generated
   * @ordered
   */
  protected static final String TYPE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getType()
   * @generated
   * @ordered
   */
  protected String type = TYPE_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected PojoAttributeDirectivePrimaryKeyImpl()
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
    return ProcessorModelPackage.Literals.POJO_ATTRIBUTE_DIRECTIVE_PRIMARY_KEY;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getFromTo()
  {
    return fromTo;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setFromTo(String newFromTo)
  {
    String oldFromTo = fromTo;
    fromTo = newFromTo;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ProcessorModelPackage.POJO_ATTRIBUTE_DIRECTIVE_PRIMARY_KEY__FROM_TO, oldFromTo, fromTo));
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
      eNotify(new ENotificationImpl(this, Notification.SET, ProcessorModelPackage.POJO_ATTRIBUTE_DIRECTIVE_PRIMARY_KEY__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getType()
  {
    return type;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setType(String newType)
  {
    String oldType = type;
    type = newType;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ProcessorModelPackage.POJO_ATTRIBUTE_DIRECTIVE_PRIMARY_KEY__TYPE, oldType, type));
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
      case ProcessorModelPackage.POJO_ATTRIBUTE_DIRECTIVE_PRIMARY_KEY__FROM_TO:
        return getFromTo();
      case ProcessorModelPackage.POJO_ATTRIBUTE_DIRECTIVE_PRIMARY_KEY__NAME:
        return getName();
      case ProcessorModelPackage.POJO_ATTRIBUTE_DIRECTIVE_PRIMARY_KEY__TYPE:
        return getType();
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
      case ProcessorModelPackage.POJO_ATTRIBUTE_DIRECTIVE_PRIMARY_KEY__FROM_TO:
        setFromTo((String)newValue);
        return;
      case ProcessorModelPackage.POJO_ATTRIBUTE_DIRECTIVE_PRIMARY_KEY__NAME:
        setName((String)newValue);
        return;
      case ProcessorModelPackage.POJO_ATTRIBUTE_DIRECTIVE_PRIMARY_KEY__TYPE:
        setType((String)newValue);
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
      case ProcessorModelPackage.POJO_ATTRIBUTE_DIRECTIVE_PRIMARY_KEY__FROM_TO:
        setFromTo(FROM_TO_EDEFAULT);
        return;
      case ProcessorModelPackage.POJO_ATTRIBUTE_DIRECTIVE_PRIMARY_KEY__NAME:
        setName(NAME_EDEFAULT);
        return;
      case ProcessorModelPackage.POJO_ATTRIBUTE_DIRECTIVE_PRIMARY_KEY__TYPE:
        setType(TYPE_EDEFAULT);
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
      case ProcessorModelPackage.POJO_ATTRIBUTE_DIRECTIVE_PRIMARY_KEY__FROM_TO:
        return FROM_TO_EDEFAULT == null ? fromTo != null : !FROM_TO_EDEFAULT.equals(fromTo);
      case ProcessorModelPackage.POJO_ATTRIBUTE_DIRECTIVE_PRIMARY_KEY__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case ProcessorModelPackage.POJO_ATTRIBUTE_DIRECTIVE_PRIMARY_KEY__TYPE:
        return TYPE_EDEFAULT == null ? type != null : !TYPE_EDEFAULT.equals(type);
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
    result.append(" (fromTo: ");
    result.append(fromTo);
    result.append(", name: ");
    result.append(name);
    result.append(", type: ");
    result.append(type);
    result.append(')');
    return result.toString();
  }

} //PojoAttributeDirectivePrimaryKeyImpl
