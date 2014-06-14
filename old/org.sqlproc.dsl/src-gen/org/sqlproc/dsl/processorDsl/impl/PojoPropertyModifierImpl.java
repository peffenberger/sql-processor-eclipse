/**
 */
package org.sqlproc.dsl.processorDsl.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.sqlproc.dsl.processorDsl.PojoPropertyModifier;
import org.sqlproc.dsl.processorDsl.ProcessorDslPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Pojo Property Modifier</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.sqlproc.dsl.processorDsl.impl.PojoPropertyModifierImpl#isRequired <em>Required</em>}</li>
 *   <li>{@link org.sqlproc.dsl.processorDsl.impl.PojoPropertyModifierImpl#isDiscriminator <em>Discriminator</em>}</li>
 *   <li>{@link org.sqlproc.dsl.processorDsl.impl.PojoPropertyModifierImpl#isPrimaryKey <em>Primary Key</em>}</li>
 *   <li>{@link org.sqlproc.dsl.processorDsl.impl.PojoPropertyModifierImpl#getIndex <em>Index</em>}</li>
 *   <li>{@link org.sqlproc.dsl.processorDsl.impl.PojoPropertyModifierImpl#isVersion <em>Version</em>}</li>
 *   <li>{@link org.sqlproc.dsl.processorDsl.impl.PojoPropertyModifierImpl#getUpdateColumn1 <em>Update Column1</em>}</li>
 *   <li>{@link org.sqlproc.dsl.processorDsl.impl.PojoPropertyModifierImpl#getUpdateColumn2 <em>Update Column2</em>}</li>
 *   <li>{@link org.sqlproc.dsl.processorDsl.impl.PojoPropertyModifierImpl#getCreateColumn1 <em>Create Column1</em>}</li>
 *   <li>{@link org.sqlproc.dsl.processorDsl.impl.PojoPropertyModifierImpl#getCreateColumn2 <em>Create Column2</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PojoPropertyModifierImpl extends MinimalEObjectImpl.Container implements PojoPropertyModifier
{
  /**
   * The default value of the '{@link #isRequired() <em>Required</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isRequired()
   * @generated
   * @ordered
   */
  protected static final boolean REQUIRED_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isRequired() <em>Required</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isRequired()
   * @generated
   * @ordered
   */
  protected boolean required = REQUIRED_EDEFAULT;

  /**
   * The default value of the '{@link #isDiscriminator() <em>Discriminator</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isDiscriminator()
   * @generated
   * @ordered
   */
  protected static final boolean DISCRIMINATOR_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isDiscriminator() <em>Discriminator</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isDiscriminator()
   * @generated
   * @ordered
   */
  protected boolean discriminator = DISCRIMINATOR_EDEFAULT;

  /**
   * The default value of the '{@link #isPrimaryKey() <em>Primary Key</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isPrimaryKey()
   * @generated
   * @ordered
   */
  protected static final boolean PRIMARY_KEY_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isPrimaryKey() <em>Primary Key</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isPrimaryKey()
   * @generated
   * @ordered
   */
  protected boolean primaryKey = PRIMARY_KEY_EDEFAULT;

  /**
   * The default value of the '{@link #getIndex() <em>Index</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getIndex()
   * @generated
   * @ordered
   */
  protected static final String INDEX_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getIndex() <em>Index</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getIndex()
   * @generated
   * @ordered
   */
  protected String index = INDEX_EDEFAULT;

  /**
   * The default value of the '{@link #isVersion() <em>Version</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isVersion()
   * @generated
   * @ordered
   */
  protected static final boolean VERSION_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isVersion() <em>Version</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isVersion()
   * @generated
   * @ordered
   */
  protected boolean version = VERSION_EDEFAULT;

  /**
   * The default value of the '{@link #getUpdateColumn1() <em>Update Column1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getUpdateColumn1()
   * @generated
   * @ordered
   */
  protected static final String UPDATE_COLUMN1_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getUpdateColumn1() <em>Update Column1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getUpdateColumn1()
   * @generated
   * @ordered
   */
  protected String updateColumn1 = UPDATE_COLUMN1_EDEFAULT;

  /**
   * The default value of the '{@link #getUpdateColumn2() <em>Update Column2</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getUpdateColumn2()
   * @generated
   * @ordered
   */
  protected static final String UPDATE_COLUMN2_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getUpdateColumn2() <em>Update Column2</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getUpdateColumn2()
   * @generated
   * @ordered
   */
  protected String updateColumn2 = UPDATE_COLUMN2_EDEFAULT;

  /**
   * The default value of the '{@link #getCreateColumn1() <em>Create Column1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCreateColumn1()
   * @generated
   * @ordered
   */
  protected static final String CREATE_COLUMN1_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getCreateColumn1() <em>Create Column1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCreateColumn1()
   * @generated
   * @ordered
   */
  protected String createColumn1 = CREATE_COLUMN1_EDEFAULT;

  /**
   * The default value of the '{@link #getCreateColumn2() <em>Create Column2</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCreateColumn2()
   * @generated
   * @ordered
   */
  protected static final String CREATE_COLUMN2_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getCreateColumn2() <em>Create Column2</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCreateColumn2()
   * @generated
   * @ordered
   */
  protected String createColumn2 = CREATE_COLUMN2_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected PojoPropertyModifierImpl()
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
    return ProcessorDslPackage.Literals.POJO_PROPERTY_MODIFIER;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isRequired()
  {
    return required;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setRequired(boolean newRequired)
  {
    boolean oldRequired = required;
    required = newRequired;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ProcessorDslPackage.POJO_PROPERTY_MODIFIER__REQUIRED, oldRequired, required));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isDiscriminator()
  {
    return discriminator;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDiscriminator(boolean newDiscriminator)
  {
    boolean oldDiscriminator = discriminator;
    discriminator = newDiscriminator;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ProcessorDslPackage.POJO_PROPERTY_MODIFIER__DISCRIMINATOR, oldDiscriminator, discriminator));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isPrimaryKey()
  {
    return primaryKey;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPrimaryKey(boolean newPrimaryKey)
  {
    boolean oldPrimaryKey = primaryKey;
    primaryKey = newPrimaryKey;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ProcessorDslPackage.POJO_PROPERTY_MODIFIER__PRIMARY_KEY, oldPrimaryKey, primaryKey));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getIndex()
  {
    return index;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setIndex(String newIndex)
  {
    String oldIndex = index;
    index = newIndex;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ProcessorDslPackage.POJO_PROPERTY_MODIFIER__INDEX, oldIndex, index));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isVersion()
  {
    return version;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setVersion(boolean newVersion)
  {
    boolean oldVersion = version;
    version = newVersion;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ProcessorDslPackage.POJO_PROPERTY_MODIFIER__VERSION, oldVersion, version));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getUpdateColumn1()
  {
    return updateColumn1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setUpdateColumn1(String newUpdateColumn1)
  {
    String oldUpdateColumn1 = updateColumn1;
    updateColumn1 = newUpdateColumn1;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ProcessorDslPackage.POJO_PROPERTY_MODIFIER__UPDATE_COLUMN1, oldUpdateColumn1, updateColumn1));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getUpdateColumn2()
  {
    return updateColumn2;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setUpdateColumn2(String newUpdateColumn2)
  {
    String oldUpdateColumn2 = updateColumn2;
    updateColumn2 = newUpdateColumn2;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ProcessorDslPackage.POJO_PROPERTY_MODIFIER__UPDATE_COLUMN2, oldUpdateColumn2, updateColumn2));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getCreateColumn1()
  {
    return createColumn1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setCreateColumn1(String newCreateColumn1)
  {
    String oldCreateColumn1 = createColumn1;
    createColumn1 = newCreateColumn1;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ProcessorDslPackage.POJO_PROPERTY_MODIFIER__CREATE_COLUMN1, oldCreateColumn1, createColumn1));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getCreateColumn2()
  {
    return createColumn2;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setCreateColumn2(String newCreateColumn2)
  {
    String oldCreateColumn2 = createColumn2;
    createColumn2 = newCreateColumn2;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ProcessorDslPackage.POJO_PROPERTY_MODIFIER__CREATE_COLUMN2, oldCreateColumn2, createColumn2));
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
      case ProcessorDslPackage.POJO_PROPERTY_MODIFIER__REQUIRED:
        return isRequired();
      case ProcessorDslPackage.POJO_PROPERTY_MODIFIER__DISCRIMINATOR:
        return isDiscriminator();
      case ProcessorDslPackage.POJO_PROPERTY_MODIFIER__PRIMARY_KEY:
        return isPrimaryKey();
      case ProcessorDslPackage.POJO_PROPERTY_MODIFIER__INDEX:
        return getIndex();
      case ProcessorDslPackage.POJO_PROPERTY_MODIFIER__VERSION:
        return isVersion();
      case ProcessorDslPackage.POJO_PROPERTY_MODIFIER__UPDATE_COLUMN1:
        return getUpdateColumn1();
      case ProcessorDslPackage.POJO_PROPERTY_MODIFIER__UPDATE_COLUMN2:
        return getUpdateColumn2();
      case ProcessorDslPackage.POJO_PROPERTY_MODIFIER__CREATE_COLUMN1:
        return getCreateColumn1();
      case ProcessorDslPackage.POJO_PROPERTY_MODIFIER__CREATE_COLUMN2:
        return getCreateColumn2();
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
      case ProcessorDslPackage.POJO_PROPERTY_MODIFIER__REQUIRED:
        setRequired((Boolean)newValue);
        return;
      case ProcessorDslPackage.POJO_PROPERTY_MODIFIER__DISCRIMINATOR:
        setDiscriminator((Boolean)newValue);
        return;
      case ProcessorDslPackage.POJO_PROPERTY_MODIFIER__PRIMARY_KEY:
        setPrimaryKey((Boolean)newValue);
        return;
      case ProcessorDslPackage.POJO_PROPERTY_MODIFIER__INDEX:
        setIndex((String)newValue);
        return;
      case ProcessorDslPackage.POJO_PROPERTY_MODIFIER__VERSION:
        setVersion((Boolean)newValue);
        return;
      case ProcessorDslPackage.POJO_PROPERTY_MODIFIER__UPDATE_COLUMN1:
        setUpdateColumn1((String)newValue);
        return;
      case ProcessorDslPackage.POJO_PROPERTY_MODIFIER__UPDATE_COLUMN2:
        setUpdateColumn2((String)newValue);
        return;
      case ProcessorDslPackage.POJO_PROPERTY_MODIFIER__CREATE_COLUMN1:
        setCreateColumn1((String)newValue);
        return;
      case ProcessorDslPackage.POJO_PROPERTY_MODIFIER__CREATE_COLUMN2:
        setCreateColumn2((String)newValue);
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
      case ProcessorDslPackage.POJO_PROPERTY_MODIFIER__REQUIRED:
        setRequired(REQUIRED_EDEFAULT);
        return;
      case ProcessorDslPackage.POJO_PROPERTY_MODIFIER__DISCRIMINATOR:
        setDiscriminator(DISCRIMINATOR_EDEFAULT);
        return;
      case ProcessorDslPackage.POJO_PROPERTY_MODIFIER__PRIMARY_KEY:
        setPrimaryKey(PRIMARY_KEY_EDEFAULT);
        return;
      case ProcessorDslPackage.POJO_PROPERTY_MODIFIER__INDEX:
        setIndex(INDEX_EDEFAULT);
        return;
      case ProcessorDslPackage.POJO_PROPERTY_MODIFIER__VERSION:
        setVersion(VERSION_EDEFAULT);
        return;
      case ProcessorDslPackage.POJO_PROPERTY_MODIFIER__UPDATE_COLUMN1:
        setUpdateColumn1(UPDATE_COLUMN1_EDEFAULT);
        return;
      case ProcessorDslPackage.POJO_PROPERTY_MODIFIER__UPDATE_COLUMN2:
        setUpdateColumn2(UPDATE_COLUMN2_EDEFAULT);
        return;
      case ProcessorDslPackage.POJO_PROPERTY_MODIFIER__CREATE_COLUMN1:
        setCreateColumn1(CREATE_COLUMN1_EDEFAULT);
        return;
      case ProcessorDslPackage.POJO_PROPERTY_MODIFIER__CREATE_COLUMN2:
        setCreateColumn2(CREATE_COLUMN2_EDEFAULT);
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
      case ProcessorDslPackage.POJO_PROPERTY_MODIFIER__REQUIRED:
        return required != REQUIRED_EDEFAULT;
      case ProcessorDslPackage.POJO_PROPERTY_MODIFIER__DISCRIMINATOR:
        return discriminator != DISCRIMINATOR_EDEFAULT;
      case ProcessorDslPackage.POJO_PROPERTY_MODIFIER__PRIMARY_KEY:
        return primaryKey != PRIMARY_KEY_EDEFAULT;
      case ProcessorDslPackage.POJO_PROPERTY_MODIFIER__INDEX:
        return INDEX_EDEFAULT == null ? index != null : !INDEX_EDEFAULT.equals(index);
      case ProcessorDslPackage.POJO_PROPERTY_MODIFIER__VERSION:
        return version != VERSION_EDEFAULT;
      case ProcessorDslPackage.POJO_PROPERTY_MODIFIER__UPDATE_COLUMN1:
        return UPDATE_COLUMN1_EDEFAULT == null ? updateColumn1 != null : !UPDATE_COLUMN1_EDEFAULT.equals(updateColumn1);
      case ProcessorDslPackage.POJO_PROPERTY_MODIFIER__UPDATE_COLUMN2:
        return UPDATE_COLUMN2_EDEFAULT == null ? updateColumn2 != null : !UPDATE_COLUMN2_EDEFAULT.equals(updateColumn2);
      case ProcessorDslPackage.POJO_PROPERTY_MODIFIER__CREATE_COLUMN1:
        return CREATE_COLUMN1_EDEFAULT == null ? createColumn1 != null : !CREATE_COLUMN1_EDEFAULT.equals(createColumn1);
      case ProcessorDslPackage.POJO_PROPERTY_MODIFIER__CREATE_COLUMN2:
        return CREATE_COLUMN2_EDEFAULT == null ? createColumn2 != null : !CREATE_COLUMN2_EDEFAULT.equals(createColumn2);
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
    result.append(" (required: ");
    result.append(required);
    result.append(", discriminator: ");
    result.append(discriminator);
    result.append(", primaryKey: ");
    result.append(primaryKey);
    result.append(", index: ");
    result.append(index);
    result.append(", version: ");
    result.append(version);
    result.append(", updateColumn1: ");
    result.append(updateColumn1);
    result.append(", updateColumn2: ");
    result.append(updateColumn2);
    result.append(", createColumn1: ");
    result.append(createColumn1);
    result.append(", createColumn2: ");
    result.append(createColumn2);
    result.append(')');
    return result.toString();
  }

} //PojoPropertyModifierImpl
