/**
 */
package org.sqlproc.dsl.processorDsl.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeEList;

import org.eclipse.xtext.common.types.JvmType;

import org.sqlproc.dsl.processorDsl.ImplementsAssignement;
import org.sqlproc.dsl.processorDsl.ProcessorDslPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Implements Assignement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.sqlproc.dsl.processorDsl.impl.ImplementsAssignementImpl#getToImplement <em>To Implement</em>}</li>
 *   <li>{@link org.sqlproc.dsl.processorDsl.impl.ImplementsAssignementImpl#isGenerics <em>Generics</em>}</li>
 *   <li>{@link org.sqlproc.dsl.processorDsl.impl.ImplementsAssignementImpl#getDbTables <em>Db Tables</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ImplementsAssignementImpl extends MinimalEObjectImpl.Container implements ImplementsAssignement
{
  /**
   * The cached value of the '{@link #getToImplement() <em>To Implement</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getToImplement()
   * @generated
   * @ordered
   */
  protected JvmType toImplement;

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
   * The cached value of the '{@link #getDbTables() <em>Db Tables</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDbTables()
   * @generated
   * @ordered
   */
  protected EList<String> dbTables;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ImplementsAssignementImpl()
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
    return ProcessorDslPackage.Literals.IMPLEMENTS_ASSIGNEMENT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public JvmType getToImplement()
  {
    if (toImplement != null && toImplement.eIsProxy())
    {
      InternalEObject oldToImplement = (InternalEObject)toImplement;
      toImplement = (JvmType)eResolveProxy(oldToImplement);
      if (toImplement != oldToImplement)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ProcessorDslPackage.IMPLEMENTS_ASSIGNEMENT__TO_IMPLEMENT, oldToImplement, toImplement));
      }
    }
    return toImplement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public JvmType basicGetToImplement()
  {
    return toImplement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setToImplement(JvmType newToImplement)
  {
    JvmType oldToImplement = toImplement;
    toImplement = newToImplement;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ProcessorDslPackage.IMPLEMENTS_ASSIGNEMENT__TO_IMPLEMENT, oldToImplement, toImplement));
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
      eNotify(new ENotificationImpl(this, Notification.SET, ProcessorDslPackage.IMPLEMENTS_ASSIGNEMENT__GENERICS, oldGenerics, generics));
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
      dbTables = new EDataTypeEList<String>(String.class, this, ProcessorDslPackage.IMPLEMENTS_ASSIGNEMENT__DB_TABLES);
    }
    return dbTables;
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
      case ProcessorDslPackage.IMPLEMENTS_ASSIGNEMENT__TO_IMPLEMENT:
        if (resolve) return getToImplement();
        return basicGetToImplement();
      case ProcessorDslPackage.IMPLEMENTS_ASSIGNEMENT__GENERICS:
        return isGenerics();
      case ProcessorDslPackage.IMPLEMENTS_ASSIGNEMENT__DB_TABLES:
        return getDbTables();
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
      case ProcessorDslPackage.IMPLEMENTS_ASSIGNEMENT__TO_IMPLEMENT:
        setToImplement((JvmType)newValue);
        return;
      case ProcessorDslPackage.IMPLEMENTS_ASSIGNEMENT__GENERICS:
        setGenerics((Boolean)newValue);
        return;
      case ProcessorDslPackage.IMPLEMENTS_ASSIGNEMENT__DB_TABLES:
        getDbTables().clear();
        getDbTables().addAll((Collection<? extends String>)newValue);
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
      case ProcessorDslPackage.IMPLEMENTS_ASSIGNEMENT__TO_IMPLEMENT:
        setToImplement((JvmType)null);
        return;
      case ProcessorDslPackage.IMPLEMENTS_ASSIGNEMENT__GENERICS:
        setGenerics(GENERICS_EDEFAULT);
        return;
      case ProcessorDslPackage.IMPLEMENTS_ASSIGNEMENT__DB_TABLES:
        getDbTables().clear();
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
      case ProcessorDslPackage.IMPLEMENTS_ASSIGNEMENT__TO_IMPLEMENT:
        return toImplement != null;
      case ProcessorDslPackage.IMPLEMENTS_ASSIGNEMENT__GENERICS:
        return generics != GENERICS_EDEFAULT;
      case ProcessorDslPackage.IMPLEMENTS_ASSIGNEMENT__DB_TABLES:
        return dbTables != null && !dbTables.isEmpty();
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
    result.append(", dbTables: ");
    result.append(dbTables);
    result.append(')');
    return result.toString();
  }

} //ImplementsAssignementImpl
