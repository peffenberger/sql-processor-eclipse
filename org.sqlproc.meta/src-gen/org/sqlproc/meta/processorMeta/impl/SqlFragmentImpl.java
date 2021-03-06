/**
 */
package org.sqlproc.meta.processorMeta.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.sqlproc.meta.processorMeta.Column;
import org.sqlproc.meta.processorMeta.Constant;
import org.sqlproc.meta.processorMeta.ConstantOperator;
import org.sqlproc.meta.processorMeta.DatabaseColumn;
import org.sqlproc.meta.processorMeta.DatabaseTable;
import org.sqlproc.meta.processorMeta.Identifier;
import org.sqlproc.meta.processorMeta.IdentifierOperator;
import org.sqlproc.meta.processorMeta.MetaSql;
import org.sqlproc.meta.processorMeta.ProcessorMetaPackage;
import org.sqlproc.meta.processorMeta.SqlFragment;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Sql Fragment</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.sqlproc.meta.processorMeta.impl.SqlFragmentImpl#getValue <em>Value</em>}</li>
 *   <li>{@link org.sqlproc.meta.processorMeta.impl.SqlFragmentImpl#getCol <em>Col</em>}</li>
 *   <li>{@link org.sqlproc.meta.processorMeta.impl.SqlFragmentImpl#getCnst <em>Cnst</em>}</li>
 *   <li>{@link org.sqlproc.meta.processorMeta.impl.SqlFragmentImpl#getIdent <em>Ident</em>}</li>
 *   <li>{@link org.sqlproc.meta.processorMeta.impl.SqlFragmentImpl#getCnstOper <em>Cnst Oper</em>}</li>
 *   <li>{@link org.sqlproc.meta.processorMeta.impl.SqlFragmentImpl#getIdentOper <em>Ident Oper</em>}</li>
 *   <li>{@link org.sqlproc.meta.processorMeta.impl.SqlFragmentImpl#getMeta <em>Meta</em>}</li>
 *   <li>{@link org.sqlproc.meta.processorMeta.impl.SqlFragmentImpl#getDbtab <em>Dbtab</em>}</li>
 *   <li>{@link org.sqlproc.meta.processorMeta.impl.SqlFragmentImpl#getDbcol <em>Dbcol</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SqlFragmentImpl extends MinimalEObjectImpl.Container implements SqlFragment
{
  /**
   * The default value of the '{@link #getValue() <em>Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getValue()
   * @generated
   * @ordered
   */
  protected static final String VALUE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getValue() <em>Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getValue()
   * @generated
   * @ordered
   */
  protected String value = VALUE_EDEFAULT;

  /**
   * The cached value of the '{@link #getCol() <em>Col</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCol()
   * @generated
   * @ordered
   */
  protected Column col;

  /**
   * The cached value of the '{@link #getCnst() <em>Cnst</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCnst()
   * @generated
   * @ordered
   */
  protected Constant cnst;

  /**
   * The cached value of the '{@link #getIdent() <em>Ident</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getIdent()
   * @generated
   * @ordered
   */
  protected Identifier ident;

  /**
   * The cached value of the '{@link #getCnstOper() <em>Cnst Oper</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCnstOper()
   * @generated
   * @ordered
   */
  protected ConstantOperator cnstOper;

  /**
   * The cached value of the '{@link #getIdentOper() <em>Ident Oper</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getIdentOper()
   * @generated
   * @ordered
   */
  protected IdentifierOperator identOper;

  /**
   * The cached value of the '{@link #getMeta() <em>Meta</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMeta()
   * @generated
   * @ordered
   */
  protected MetaSql meta;

  /**
   * The cached value of the '{@link #getDbtab() <em>Dbtab</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDbtab()
   * @generated
   * @ordered
   */
  protected DatabaseTable dbtab;

  /**
   * The cached value of the '{@link #getDbcol() <em>Dbcol</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDbcol()
   * @generated
   * @ordered
   */
  protected DatabaseColumn dbcol;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected SqlFragmentImpl()
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
    return ProcessorMetaPackage.Literals.SQL_FRAGMENT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getValue()
  {
    return value;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setValue(String newValue)
  {
    String oldValue = value;
    value = newValue;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ProcessorMetaPackage.SQL_FRAGMENT__VALUE, oldValue, value));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Column getCol()
  {
    return col;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetCol(Column newCol, NotificationChain msgs)
  {
    Column oldCol = col;
    col = newCol;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ProcessorMetaPackage.SQL_FRAGMENT__COL, oldCol, newCol);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setCol(Column newCol)
  {
    if (newCol != col)
    {
      NotificationChain msgs = null;
      if (col != null)
        msgs = ((InternalEObject)col).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ProcessorMetaPackage.SQL_FRAGMENT__COL, null, msgs);
      if (newCol != null)
        msgs = ((InternalEObject)newCol).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ProcessorMetaPackage.SQL_FRAGMENT__COL, null, msgs);
      msgs = basicSetCol(newCol, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ProcessorMetaPackage.SQL_FRAGMENT__COL, newCol, newCol));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Constant getCnst()
  {
    return cnst;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetCnst(Constant newCnst, NotificationChain msgs)
  {
    Constant oldCnst = cnst;
    cnst = newCnst;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ProcessorMetaPackage.SQL_FRAGMENT__CNST, oldCnst, newCnst);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setCnst(Constant newCnst)
  {
    if (newCnst != cnst)
    {
      NotificationChain msgs = null;
      if (cnst != null)
        msgs = ((InternalEObject)cnst).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ProcessorMetaPackage.SQL_FRAGMENT__CNST, null, msgs);
      if (newCnst != null)
        msgs = ((InternalEObject)newCnst).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ProcessorMetaPackage.SQL_FRAGMENT__CNST, null, msgs);
      msgs = basicSetCnst(newCnst, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ProcessorMetaPackage.SQL_FRAGMENT__CNST, newCnst, newCnst));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Identifier getIdent()
  {
    return ident;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetIdent(Identifier newIdent, NotificationChain msgs)
  {
    Identifier oldIdent = ident;
    ident = newIdent;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ProcessorMetaPackage.SQL_FRAGMENT__IDENT, oldIdent, newIdent);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setIdent(Identifier newIdent)
  {
    if (newIdent != ident)
    {
      NotificationChain msgs = null;
      if (ident != null)
        msgs = ((InternalEObject)ident).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ProcessorMetaPackage.SQL_FRAGMENT__IDENT, null, msgs);
      if (newIdent != null)
        msgs = ((InternalEObject)newIdent).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ProcessorMetaPackage.SQL_FRAGMENT__IDENT, null, msgs);
      msgs = basicSetIdent(newIdent, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ProcessorMetaPackage.SQL_FRAGMENT__IDENT, newIdent, newIdent));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ConstantOperator getCnstOper()
  {
    return cnstOper;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetCnstOper(ConstantOperator newCnstOper, NotificationChain msgs)
  {
    ConstantOperator oldCnstOper = cnstOper;
    cnstOper = newCnstOper;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ProcessorMetaPackage.SQL_FRAGMENT__CNST_OPER, oldCnstOper, newCnstOper);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setCnstOper(ConstantOperator newCnstOper)
  {
    if (newCnstOper != cnstOper)
    {
      NotificationChain msgs = null;
      if (cnstOper != null)
        msgs = ((InternalEObject)cnstOper).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ProcessorMetaPackage.SQL_FRAGMENT__CNST_OPER, null, msgs);
      if (newCnstOper != null)
        msgs = ((InternalEObject)newCnstOper).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ProcessorMetaPackage.SQL_FRAGMENT__CNST_OPER, null, msgs);
      msgs = basicSetCnstOper(newCnstOper, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ProcessorMetaPackage.SQL_FRAGMENT__CNST_OPER, newCnstOper, newCnstOper));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public IdentifierOperator getIdentOper()
  {
    return identOper;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetIdentOper(IdentifierOperator newIdentOper, NotificationChain msgs)
  {
    IdentifierOperator oldIdentOper = identOper;
    identOper = newIdentOper;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ProcessorMetaPackage.SQL_FRAGMENT__IDENT_OPER, oldIdentOper, newIdentOper);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setIdentOper(IdentifierOperator newIdentOper)
  {
    if (newIdentOper != identOper)
    {
      NotificationChain msgs = null;
      if (identOper != null)
        msgs = ((InternalEObject)identOper).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ProcessorMetaPackage.SQL_FRAGMENT__IDENT_OPER, null, msgs);
      if (newIdentOper != null)
        msgs = ((InternalEObject)newIdentOper).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ProcessorMetaPackage.SQL_FRAGMENT__IDENT_OPER, null, msgs);
      msgs = basicSetIdentOper(newIdentOper, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ProcessorMetaPackage.SQL_FRAGMENT__IDENT_OPER, newIdentOper, newIdentOper));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MetaSql getMeta()
  {
    return meta;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetMeta(MetaSql newMeta, NotificationChain msgs)
  {
    MetaSql oldMeta = meta;
    meta = newMeta;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ProcessorMetaPackage.SQL_FRAGMENT__META, oldMeta, newMeta);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setMeta(MetaSql newMeta)
  {
    if (newMeta != meta)
    {
      NotificationChain msgs = null;
      if (meta != null)
        msgs = ((InternalEObject)meta).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ProcessorMetaPackage.SQL_FRAGMENT__META, null, msgs);
      if (newMeta != null)
        msgs = ((InternalEObject)newMeta).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ProcessorMetaPackage.SQL_FRAGMENT__META, null, msgs);
      msgs = basicSetMeta(newMeta, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ProcessorMetaPackage.SQL_FRAGMENT__META, newMeta, newMeta));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DatabaseTable getDbtab()
  {
    return dbtab;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetDbtab(DatabaseTable newDbtab, NotificationChain msgs)
  {
    DatabaseTable oldDbtab = dbtab;
    dbtab = newDbtab;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ProcessorMetaPackage.SQL_FRAGMENT__DBTAB, oldDbtab, newDbtab);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDbtab(DatabaseTable newDbtab)
  {
    if (newDbtab != dbtab)
    {
      NotificationChain msgs = null;
      if (dbtab != null)
        msgs = ((InternalEObject)dbtab).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ProcessorMetaPackage.SQL_FRAGMENT__DBTAB, null, msgs);
      if (newDbtab != null)
        msgs = ((InternalEObject)newDbtab).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ProcessorMetaPackage.SQL_FRAGMENT__DBTAB, null, msgs);
      msgs = basicSetDbtab(newDbtab, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ProcessorMetaPackage.SQL_FRAGMENT__DBTAB, newDbtab, newDbtab));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DatabaseColumn getDbcol()
  {
    return dbcol;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetDbcol(DatabaseColumn newDbcol, NotificationChain msgs)
  {
    DatabaseColumn oldDbcol = dbcol;
    dbcol = newDbcol;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ProcessorMetaPackage.SQL_FRAGMENT__DBCOL, oldDbcol, newDbcol);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDbcol(DatabaseColumn newDbcol)
  {
    if (newDbcol != dbcol)
    {
      NotificationChain msgs = null;
      if (dbcol != null)
        msgs = ((InternalEObject)dbcol).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ProcessorMetaPackage.SQL_FRAGMENT__DBCOL, null, msgs);
      if (newDbcol != null)
        msgs = ((InternalEObject)newDbcol).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ProcessorMetaPackage.SQL_FRAGMENT__DBCOL, null, msgs);
      msgs = basicSetDbcol(newDbcol, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ProcessorMetaPackage.SQL_FRAGMENT__DBCOL, newDbcol, newDbcol));
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
      case ProcessorMetaPackage.SQL_FRAGMENT__COL:
        return basicSetCol(null, msgs);
      case ProcessorMetaPackage.SQL_FRAGMENT__CNST:
        return basicSetCnst(null, msgs);
      case ProcessorMetaPackage.SQL_FRAGMENT__IDENT:
        return basicSetIdent(null, msgs);
      case ProcessorMetaPackage.SQL_FRAGMENT__CNST_OPER:
        return basicSetCnstOper(null, msgs);
      case ProcessorMetaPackage.SQL_FRAGMENT__IDENT_OPER:
        return basicSetIdentOper(null, msgs);
      case ProcessorMetaPackage.SQL_FRAGMENT__META:
        return basicSetMeta(null, msgs);
      case ProcessorMetaPackage.SQL_FRAGMENT__DBTAB:
        return basicSetDbtab(null, msgs);
      case ProcessorMetaPackage.SQL_FRAGMENT__DBCOL:
        return basicSetDbcol(null, msgs);
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
      case ProcessorMetaPackage.SQL_FRAGMENT__VALUE:
        return getValue();
      case ProcessorMetaPackage.SQL_FRAGMENT__COL:
        return getCol();
      case ProcessorMetaPackage.SQL_FRAGMENT__CNST:
        return getCnst();
      case ProcessorMetaPackage.SQL_FRAGMENT__IDENT:
        return getIdent();
      case ProcessorMetaPackage.SQL_FRAGMENT__CNST_OPER:
        return getCnstOper();
      case ProcessorMetaPackage.SQL_FRAGMENT__IDENT_OPER:
        return getIdentOper();
      case ProcessorMetaPackage.SQL_FRAGMENT__META:
        return getMeta();
      case ProcessorMetaPackage.SQL_FRAGMENT__DBTAB:
        return getDbtab();
      case ProcessorMetaPackage.SQL_FRAGMENT__DBCOL:
        return getDbcol();
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
      case ProcessorMetaPackage.SQL_FRAGMENT__VALUE:
        setValue((String)newValue);
        return;
      case ProcessorMetaPackage.SQL_FRAGMENT__COL:
        setCol((Column)newValue);
        return;
      case ProcessorMetaPackage.SQL_FRAGMENT__CNST:
        setCnst((Constant)newValue);
        return;
      case ProcessorMetaPackage.SQL_FRAGMENT__IDENT:
        setIdent((Identifier)newValue);
        return;
      case ProcessorMetaPackage.SQL_FRAGMENT__CNST_OPER:
        setCnstOper((ConstantOperator)newValue);
        return;
      case ProcessorMetaPackage.SQL_FRAGMENT__IDENT_OPER:
        setIdentOper((IdentifierOperator)newValue);
        return;
      case ProcessorMetaPackage.SQL_FRAGMENT__META:
        setMeta((MetaSql)newValue);
        return;
      case ProcessorMetaPackage.SQL_FRAGMENT__DBTAB:
        setDbtab((DatabaseTable)newValue);
        return;
      case ProcessorMetaPackage.SQL_FRAGMENT__DBCOL:
        setDbcol((DatabaseColumn)newValue);
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
      case ProcessorMetaPackage.SQL_FRAGMENT__VALUE:
        setValue(VALUE_EDEFAULT);
        return;
      case ProcessorMetaPackage.SQL_FRAGMENT__COL:
        setCol((Column)null);
        return;
      case ProcessorMetaPackage.SQL_FRAGMENT__CNST:
        setCnst((Constant)null);
        return;
      case ProcessorMetaPackage.SQL_FRAGMENT__IDENT:
        setIdent((Identifier)null);
        return;
      case ProcessorMetaPackage.SQL_FRAGMENT__CNST_OPER:
        setCnstOper((ConstantOperator)null);
        return;
      case ProcessorMetaPackage.SQL_FRAGMENT__IDENT_OPER:
        setIdentOper((IdentifierOperator)null);
        return;
      case ProcessorMetaPackage.SQL_FRAGMENT__META:
        setMeta((MetaSql)null);
        return;
      case ProcessorMetaPackage.SQL_FRAGMENT__DBTAB:
        setDbtab((DatabaseTable)null);
        return;
      case ProcessorMetaPackage.SQL_FRAGMENT__DBCOL:
        setDbcol((DatabaseColumn)null);
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
      case ProcessorMetaPackage.SQL_FRAGMENT__VALUE:
        return VALUE_EDEFAULT == null ? value != null : !VALUE_EDEFAULT.equals(value);
      case ProcessorMetaPackage.SQL_FRAGMENT__COL:
        return col != null;
      case ProcessorMetaPackage.SQL_FRAGMENT__CNST:
        return cnst != null;
      case ProcessorMetaPackage.SQL_FRAGMENT__IDENT:
        return ident != null;
      case ProcessorMetaPackage.SQL_FRAGMENT__CNST_OPER:
        return cnstOper != null;
      case ProcessorMetaPackage.SQL_FRAGMENT__IDENT_OPER:
        return identOper != null;
      case ProcessorMetaPackage.SQL_FRAGMENT__META:
        return meta != null;
      case ProcessorMetaPackage.SQL_FRAGMENT__DBTAB:
        return dbtab != null;
      case ProcessorMetaPackage.SQL_FRAGMENT__DBCOL:
        return dbcol != null;
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
    result.append(" (value: ");
    result.append(value);
    result.append(')');
    return result.toString();
  }

} //SqlFragmentImpl
