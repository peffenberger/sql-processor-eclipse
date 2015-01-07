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

import org.eclipse.emf.ecore.util.EDataTypeEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.sqlproc.dsl.processorDsl.ColumnAssignement;
import org.sqlproc.dsl.processorDsl.ColumnTypeAssignement;
import org.sqlproc.dsl.processorDsl.DebugLevelAssignement;
import org.sqlproc.dsl.processorDsl.ExportAssignement;
import org.sqlproc.dsl.processorDsl.ExtendsAssignement;
import org.sqlproc.dsl.processorDsl.ExtendsAssignementGenerics;
import org.sqlproc.dsl.processorDsl.FunctionPojoAssignement;
import org.sqlproc.dsl.processorDsl.ImplementsAssignement;
import org.sqlproc.dsl.processorDsl.ImplementsAssignementGenerics;
import org.sqlproc.dsl.processorDsl.ImportAssignement;
import org.sqlproc.dsl.processorDsl.InheritanceAssignement;
import org.sqlproc.dsl.processorDsl.JoinTableAssignement;
import org.sqlproc.dsl.processorDsl.ManyToManyAssignement;
import org.sqlproc.dsl.processorDsl.PojogenProperty;
import org.sqlproc.dsl.processorDsl.ProcedurePojoAssignement;
import org.sqlproc.dsl.processorDsl.ProcessorDslPackage;
import org.sqlproc.dsl.processorDsl.ShowColumnTypeAssignement;
import org.sqlproc.dsl.processorDsl.SqlTypeAssignement;
import org.sqlproc.dsl.processorDsl.TableAssignement;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Pojogen Property</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.sqlproc.dsl.processorDsl.impl.PojogenPropertyImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.sqlproc.dsl.processorDsl.impl.PojogenPropertyImpl#getSqlTypes <em>Sql Types</em>}</li>
 *   <li>{@link org.sqlproc.dsl.processorDsl.impl.PojogenPropertyImpl#getDbTable <em>Db Table</em>}</li>
 *   <li>{@link org.sqlproc.dsl.processorDsl.impl.PojogenPropertyImpl#getColumnTypes <em>Column Types</em>}</li>
 *   <li>{@link org.sqlproc.dsl.processorDsl.impl.PojogenPropertyImpl#getDbProcedure <em>Db Procedure</em>}</li>
 *   <li>{@link org.sqlproc.dsl.processorDsl.impl.PojogenPropertyImpl#getDbFunction <em>Db Function</em>}</li>
 *   <li>{@link org.sqlproc.dsl.processorDsl.impl.PojogenPropertyImpl#getColumnType <em>Column Type</em>}</li>
 *   <li>{@link org.sqlproc.dsl.processorDsl.impl.PojogenPropertyImpl#getDbTables <em>Db Tables</em>}</li>
 *   <li>{@link org.sqlproc.dsl.processorDsl.impl.PojogenPropertyImpl#getJoinTables <em>Join Tables</em>}</li>
 *   <li>{@link org.sqlproc.dsl.processorDsl.impl.PojogenPropertyImpl#getDbColumns <em>Db Columns</em>}</li>
 *   <li>{@link org.sqlproc.dsl.processorDsl.impl.PojogenPropertyImpl#getTables <em>Tables</em>}</li>
 *   <li>{@link org.sqlproc.dsl.processorDsl.impl.PojogenPropertyImpl#getColumns <em>Columns</em>}</li>
 *   <li>{@link org.sqlproc.dsl.processorDsl.impl.PojogenPropertyImpl#getExports <em>Exports</em>}</li>
 *   <li>{@link org.sqlproc.dsl.processorDsl.impl.PojogenPropertyImpl#getImports <em>Imports</em>}</li>
 *   <li>{@link org.sqlproc.dsl.processorDsl.impl.PojogenPropertyImpl#getMany2s <em>Many2s</em>}</li>
 *   <li>{@link org.sqlproc.dsl.processorDsl.impl.PojogenPropertyImpl#getDbColumn <em>Db Column</em>}</li>
 *   <li>{@link org.sqlproc.dsl.processorDsl.impl.PojogenPropertyImpl#getInheritance <em>Inheritance</em>}</li>
 *   <li>{@link org.sqlproc.dsl.processorDsl.impl.PojogenPropertyImpl#getMethods <em>Methods</em>}</li>
 *   <li>{@link org.sqlproc.dsl.processorDsl.impl.PojogenPropertyImpl#getOperatorsSuffix <em>Operators Suffix</em>}</li>
 *   <li>{@link org.sqlproc.dsl.processorDsl.impl.PojogenPropertyImpl#getToImplements <em>To Implements</em>}</li>
 *   <li>{@link org.sqlproc.dsl.processorDsl.impl.PojogenPropertyImpl#getToExtends <em>To Extends</em>}</li>
 *   <li>{@link org.sqlproc.dsl.processorDsl.impl.PojogenPropertyImpl#getToImplementsGenerics <em>To Implements Generics</em>}</li>
 *   <li>{@link org.sqlproc.dsl.processorDsl.impl.PojogenPropertyImpl#getToExtendsGenerics <em>To Extends Generics</em>}</li>
 *   <li>{@link org.sqlproc.dsl.processorDsl.impl.PojogenPropertyImpl#getImplPackage <em>Impl Package</em>}</li>
 *   <li>{@link org.sqlproc.dsl.processorDsl.impl.PojogenPropertyImpl#getVersion <em>Version</em>}</li>
 *   <li>{@link org.sqlproc.dsl.processorDsl.impl.PojogenPropertyImpl#getDbNotTables <em>Db Not Tables</em>}</li>
 *   <li>{@link org.sqlproc.dsl.processorDsl.impl.PojogenPropertyImpl#getDebug <em>Debug</em>}</li>
 *   <li>{@link org.sqlproc.dsl.processorDsl.impl.PojogenPropertyImpl#getProcPojos <em>Proc Pojos</em>}</li>
 *   <li>{@link org.sqlproc.dsl.processorDsl.impl.PojogenPropertyImpl#getFunPojos <em>Fun Pojos</em>}</li>
 *   <li>{@link org.sqlproc.dsl.processorDsl.impl.PojogenPropertyImpl#getActiveFilter <em>Active Filter</em>}</li>
 *   <li>{@link org.sqlproc.dsl.processorDsl.impl.PojogenPropertyImpl#getPckg <em>Pckg</em>}</li>
 *   <li>{@link org.sqlproc.dsl.processorDsl.impl.PojogenPropertyImpl#getEnumName <em>Enum Name</em>}</li>
 *   <li>{@link org.sqlproc.dsl.processorDsl.impl.PojogenPropertyImpl#getDbCheckConstraints <em>Db Check Constraints</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PojogenPropertyImpl extends MinimalEObjectImpl.Container implements PojogenProperty
{
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
   * The cached value of the '{@link #getSqlTypes() <em>Sql Types</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSqlTypes()
   * @generated
   * @ordered
   */
  protected EList<SqlTypeAssignement> sqlTypes;

  /**
   * The default value of the '{@link #getDbTable() <em>Db Table</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDbTable()
   * @generated
   * @ordered
   */
  protected static final String DB_TABLE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getDbTable() <em>Db Table</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDbTable()
   * @generated
   * @ordered
   */
  protected String dbTable = DB_TABLE_EDEFAULT;

  /**
   * The cached value of the '{@link #getColumnTypes() <em>Column Types</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getColumnTypes()
   * @generated
   * @ordered
   */
  protected EList<ColumnTypeAssignement> columnTypes;

  /**
   * The default value of the '{@link #getDbProcedure() <em>Db Procedure</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDbProcedure()
   * @generated
   * @ordered
   */
  protected static final String DB_PROCEDURE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getDbProcedure() <em>Db Procedure</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDbProcedure()
   * @generated
   * @ordered
   */
  protected String dbProcedure = DB_PROCEDURE_EDEFAULT;

  /**
   * The default value of the '{@link #getDbFunction() <em>Db Function</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDbFunction()
   * @generated
   * @ordered
   */
  protected static final String DB_FUNCTION_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getDbFunction() <em>Db Function</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDbFunction()
   * @generated
   * @ordered
   */
  protected String dbFunction = DB_FUNCTION_EDEFAULT;

  /**
   * The cached value of the '{@link #getColumnType() <em>Column Type</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getColumnType()
   * @generated
   * @ordered
   */
  protected ShowColumnTypeAssignement columnType;

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
   * The cached value of the '{@link #getJoinTables() <em>Join Tables</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getJoinTables()
   * @generated
   * @ordered
   */
  protected EList<JoinTableAssignement> joinTables;

  /**
   * The cached value of the '{@link #getDbColumns() <em>Db Columns</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDbColumns()
   * @generated
   * @ordered
   */
  protected EList<String> dbColumns;

  /**
   * The cached value of the '{@link #getTables() <em>Tables</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTables()
   * @generated
   * @ordered
   */
  protected EList<TableAssignement> tables;

  /**
   * The cached value of the '{@link #getColumns() <em>Columns</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getColumns()
   * @generated
   * @ordered
   */
  protected EList<ColumnAssignement> columns;

  /**
   * The cached value of the '{@link #getExports() <em>Exports</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExports()
   * @generated
   * @ordered
   */
  protected EList<ExportAssignement> exports;

  /**
   * The cached value of the '{@link #getImports() <em>Imports</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getImports()
   * @generated
   * @ordered
   */
  protected EList<ImportAssignement> imports;

  /**
   * The cached value of the '{@link #getMany2s() <em>Many2s</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMany2s()
   * @generated
   * @ordered
   */
  protected EList<ManyToManyAssignement> many2s;

  /**
   * The default value of the '{@link #getDbColumn() <em>Db Column</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDbColumn()
   * @generated
   * @ordered
   */
  protected static final String DB_COLUMN_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getDbColumn() <em>Db Column</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDbColumn()
   * @generated
   * @ordered
   */
  protected String dbColumn = DB_COLUMN_EDEFAULT;

  /**
   * The cached value of the '{@link #getInheritance() <em>Inheritance</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getInheritance()
   * @generated
   * @ordered
   */
  protected EList<InheritanceAssignement> inheritance;

  /**
   * The cached value of the '{@link #getMethods() <em>Methods</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMethods()
   * @generated
   * @ordered
   */
  protected EList<String> methods;

  /**
   * The default value of the '{@link #getOperatorsSuffix() <em>Operators Suffix</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOperatorsSuffix()
   * @generated
   * @ordered
   */
  protected static final String OPERATORS_SUFFIX_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getOperatorsSuffix() <em>Operators Suffix</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOperatorsSuffix()
   * @generated
   * @ordered
   */
  protected String operatorsSuffix = OPERATORS_SUFFIX_EDEFAULT;

  /**
   * The cached value of the '{@link #getToImplements() <em>To Implements</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getToImplements()
   * @generated
   * @ordered
   */
  protected ImplementsAssignement toImplements;

  /**
   * The cached value of the '{@link #getToExtends() <em>To Extends</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getToExtends()
   * @generated
   * @ordered
   */
  protected ExtendsAssignement toExtends;

  /**
   * The cached value of the '{@link #getToImplementsGenerics() <em>To Implements Generics</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getToImplementsGenerics()
   * @generated
   * @ordered
   */
  protected ImplementsAssignementGenerics toImplementsGenerics;

  /**
   * The cached value of the '{@link #getToExtendsGenerics() <em>To Extends Generics</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getToExtendsGenerics()
   * @generated
   * @ordered
   */
  protected ExtendsAssignementGenerics toExtendsGenerics;

  /**
   * The default value of the '{@link #getImplPackage() <em>Impl Package</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getImplPackage()
   * @generated
   * @ordered
   */
  protected static final String IMPL_PACKAGE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getImplPackage() <em>Impl Package</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getImplPackage()
   * @generated
   * @ordered
   */
  protected String implPackage = IMPL_PACKAGE_EDEFAULT;

  /**
   * The default value of the '{@link #getVersion() <em>Version</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getVersion()
   * @generated
   * @ordered
   */
  protected static final String VERSION_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getVersion() <em>Version</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getVersion()
   * @generated
   * @ordered
   */
  protected String version = VERSION_EDEFAULT;

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
   * The cached value of the '{@link #getDebug() <em>Debug</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDebug()
   * @generated
   * @ordered
   */
  protected DebugLevelAssignement debug;

  /**
   * The cached value of the '{@link #getProcPojos() <em>Proc Pojos</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getProcPojos()
   * @generated
   * @ordered
   */
  protected EList<ProcedurePojoAssignement> procPojos;

  /**
   * The cached value of the '{@link #getFunPojos() <em>Fun Pojos</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFunPojos()
   * @generated
   * @ordered
   */
  protected EList<FunctionPojoAssignement> funPojos;

  /**
   * The default value of the '{@link #getActiveFilter() <em>Active Filter</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getActiveFilter()
   * @generated
   * @ordered
   */
  protected static final String ACTIVE_FILTER_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getActiveFilter() <em>Active Filter</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getActiveFilter()
   * @generated
   * @ordered
   */
  protected String activeFilter = ACTIVE_FILTER_EDEFAULT;

  /**
   * The default value of the '{@link #getPckg() <em>Pckg</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPckg()
   * @generated
   * @ordered
   */
  protected static final String PCKG_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getPckg() <em>Pckg</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPckg()
   * @generated
   * @ordered
   */
  protected String pckg = PCKG_EDEFAULT;

  /**
   * The default value of the '{@link #getEnumName() <em>Enum Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEnumName()
   * @generated
   * @ordered
   */
  protected static final String ENUM_NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getEnumName() <em>Enum Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEnumName()
   * @generated
   * @ordered
   */
  protected String enumName = ENUM_NAME_EDEFAULT;

  /**
   * The cached value of the '{@link #getDbCheckConstraints() <em>Db Check Constraints</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDbCheckConstraints()
   * @generated
   * @ordered
   */
  protected EList<String> dbCheckConstraints;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected PojogenPropertyImpl()
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
    return ProcessorDslPackage.eINSTANCE.getPojogenProperty();
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
      eNotify(new ENotificationImpl(this, Notification.SET, ProcessorDslPackage.POJOGEN_PROPERTY__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<SqlTypeAssignement> getSqlTypes()
  {
    if (sqlTypes == null)
    {
      sqlTypes = new EObjectContainmentEList<SqlTypeAssignement>(SqlTypeAssignement.class, this, ProcessorDslPackage.POJOGEN_PROPERTY__SQL_TYPES);
    }
    return sqlTypes;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getDbTable()
  {
    return dbTable;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDbTable(String newDbTable)
  {
    String oldDbTable = dbTable;
    dbTable = newDbTable;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ProcessorDslPackage.POJOGEN_PROPERTY__DB_TABLE, oldDbTable, dbTable));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ColumnTypeAssignement> getColumnTypes()
  {
    if (columnTypes == null)
    {
      columnTypes = new EObjectContainmentEList<ColumnTypeAssignement>(ColumnTypeAssignement.class, this, ProcessorDslPackage.POJOGEN_PROPERTY__COLUMN_TYPES);
    }
    return columnTypes;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getDbProcedure()
  {
    return dbProcedure;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDbProcedure(String newDbProcedure)
  {
    String oldDbProcedure = dbProcedure;
    dbProcedure = newDbProcedure;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ProcessorDslPackage.POJOGEN_PROPERTY__DB_PROCEDURE, oldDbProcedure, dbProcedure));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getDbFunction()
  {
    return dbFunction;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDbFunction(String newDbFunction)
  {
    String oldDbFunction = dbFunction;
    dbFunction = newDbFunction;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ProcessorDslPackage.POJOGEN_PROPERTY__DB_FUNCTION, oldDbFunction, dbFunction));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ShowColumnTypeAssignement getColumnType()
  {
    return columnType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetColumnType(ShowColumnTypeAssignement newColumnType, NotificationChain msgs)
  {
    ShowColumnTypeAssignement oldColumnType = columnType;
    columnType = newColumnType;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ProcessorDslPackage.POJOGEN_PROPERTY__COLUMN_TYPE, oldColumnType, newColumnType);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setColumnType(ShowColumnTypeAssignement newColumnType)
  {
    if (newColumnType != columnType)
    {
      NotificationChain msgs = null;
      if (columnType != null)
        msgs = ((InternalEObject)columnType).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ProcessorDslPackage.POJOGEN_PROPERTY__COLUMN_TYPE, null, msgs);
      if (newColumnType != null)
        msgs = ((InternalEObject)newColumnType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ProcessorDslPackage.POJOGEN_PROPERTY__COLUMN_TYPE, null, msgs);
      msgs = basicSetColumnType(newColumnType, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ProcessorDslPackage.POJOGEN_PROPERTY__COLUMN_TYPE, newColumnType, newColumnType));
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
      dbTables = new EDataTypeEList<String>(String.class, this, ProcessorDslPackage.POJOGEN_PROPERTY__DB_TABLES);
    }
    return dbTables;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<JoinTableAssignement> getJoinTables()
  {
    if (joinTables == null)
    {
      joinTables = new EObjectContainmentEList<JoinTableAssignement>(JoinTableAssignement.class, this, ProcessorDslPackage.POJOGEN_PROPERTY__JOIN_TABLES);
    }
    return joinTables;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<String> getDbColumns()
  {
    if (dbColumns == null)
    {
      dbColumns = new EDataTypeEList<String>(String.class, this, ProcessorDslPackage.POJOGEN_PROPERTY__DB_COLUMNS);
    }
    return dbColumns;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<TableAssignement> getTables()
  {
    if (tables == null)
    {
      tables = new EObjectContainmentEList<TableAssignement>(TableAssignement.class, this, ProcessorDslPackage.POJOGEN_PROPERTY__TABLES);
    }
    return tables;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ColumnAssignement> getColumns()
  {
    if (columns == null)
    {
      columns = new EObjectContainmentEList<ColumnAssignement>(ColumnAssignement.class, this, ProcessorDslPackage.POJOGEN_PROPERTY__COLUMNS);
    }
    return columns;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ExportAssignement> getExports()
  {
    if (exports == null)
    {
      exports = new EObjectContainmentEList<ExportAssignement>(ExportAssignement.class, this, ProcessorDslPackage.POJOGEN_PROPERTY__EXPORTS);
    }
    return exports;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ImportAssignement> getImports()
  {
    if (imports == null)
    {
      imports = new EObjectContainmentEList<ImportAssignement>(ImportAssignement.class, this, ProcessorDslPackage.POJOGEN_PROPERTY__IMPORTS);
    }
    return imports;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ManyToManyAssignement> getMany2s()
  {
    if (many2s == null)
    {
      many2s = new EObjectContainmentEList<ManyToManyAssignement>(ManyToManyAssignement.class, this, ProcessorDslPackage.POJOGEN_PROPERTY__MANY2S);
    }
    return many2s;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getDbColumn()
  {
    return dbColumn;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDbColumn(String newDbColumn)
  {
    String oldDbColumn = dbColumn;
    dbColumn = newDbColumn;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ProcessorDslPackage.POJOGEN_PROPERTY__DB_COLUMN, oldDbColumn, dbColumn));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<InheritanceAssignement> getInheritance()
  {
    if (inheritance == null)
    {
      inheritance = new EObjectContainmentEList<InheritanceAssignement>(InheritanceAssignement.class, this, ProcessorDslPackage.POJOGEN_PROPERTY__INHERITANCE);
    }
    return inheritance;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<String> getMethods()
  {
    if (methods == null)
    {
      methods = new EDataTypeEList<String>(String.class, this, ProcessorDslPackage.POJOGEN_PROPERTY__METHODS);
    }
    return methods;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getOperatorsSuffix()
  {
    return operatorsSuffix;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setOperatorsSuffix(String newOperatorsSuffix)
  {
    String oldOperatorsSuffix = operatorsSuffix;
    operatorsSuffix = newOperatorsSuffix;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ProcessorDslPackage.POJOGEN_PROPERTY__OPERATORS_SUFFIX, oldOperatorsSuffix, operatorsSuffix));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ImplementsAssignement getToImplements()
  {
    return toImplements;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetToImplements(ImplementsAssignement newToImplements, NotificationChain msgs)
  {
    ImplementsAssignement oldToImplements = toImplements;
    toImplements = newToImplements;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ProcessorDslPackage.POJOGEN_PROPERTY__TO_IMPLEMENTS, oldToImplements, newToImplements);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setToImplements(ImplementsAssignement newToImplements)
  {
    if (newToImplements != toImplements)
    {
      NotificationChain msgs = null;
      if (toImplements != null)
        msgs = ((InternalEObject)toImplements).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ProcessorDslPackage.POJOGEN_PROPERTY__TO_IMPLEMENTS, null, msgs);
      if (newToImplements != null)
        msgs = ((InternalEObject)newToImplements).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ProcessorDslPackage.POJOGEN_PROPERTY__TO_IMPLEMENTS, null, msgs);
      msgs = basicSetToImplements(newToImplements, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ProcessorDslPackage.POJOGEN_PROPERTY__TO_IMPLEMENTS, newToImplements, newToImplements));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ExtendsAssignement getToExtends()
  {
    return toExtends;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetToExtends(ExtendsAssignement newToExtends, NotificationChain msgs)
  {
    ExtendsAssignement oldToExtends = toExtends;
    toExtends = newToExtends;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ProcessorDslPackage.POJOGEN_PROPERTY__TO_EXTENDS, oldToExtends, newToExtends);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setToExtends(ExtendsAssignement newToExtends)
  {
    if (newToExtends != toExtends)
    {
      NotificationChain msgs = null;
      if (toExtends != null)
        msgs = ((InternalEObject)toExtends).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ProcessorDslPackage.POJOGEN_PROPERTY__TO_EXTENDS, null, msgs);
      if (newToExtends != null)
        msgs = ((InternalEObject)newToExtends).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ProcessorDslPackage.POJOGEN_PROPERTY__TO_EXTENDS, null, msgs);
      msgs = basicSetToExtends(newToExtends, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ProcessorDslPackage.POJOGEN_PROPERTY__TO_EXTENDS, newToExtends, newToExtends));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ImplementsAssignementGenerics getToImplementsGenerics()
  {
    return toImplementsGenerics;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetToImplementsGenerics(ImplementsAssignementGenerics newToImplementsGenerics, NotificationChain msgs)
  {
    ImplementsAssignementGenerics oldToImplementsGenerics = toImplementsGenerics;
    toImplementsGenerics = newToImplementsGenerics;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ProcessorDslPackage.POJOGEN_PROPERTY__TO_IMPLEMENTS_GENERICS, oldToImplementsGenerics, newToImplementsGenerics);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setToImplementsGenerics(ImplementsAssignementGenerics newToImplementsGenerics)
  {
    if (newToImplementsGenerics != toImplementsGenerics)
    {
      NotificationChain msgs = null;
      if (toImplementsGenerics != null)
        msgs = ((InternalEObject)toImplementsGenerics).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ProcessorDslPackage.POJOGEN_PROPERTY__TO_IMPLEMENTS_GENERICS, null, msgs);
      if (newToImplementsGenerics != null)
        msgs = ((InternalEObject)newToImplementsGenerics).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ProcessorDslPackage.POJOGEN_PROPERTY__TO_IMPLEMENTS_GENERICS, null, msgs);
      msgs = basicSetToImplementsGenerics(newToImplementsGenerics, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ProcessorDslPackage.POJOGEN_PROPERTY__TO_IMPLEMENTS_GENERICS, newToImplementsGenerics, newToImplementsGenerics));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ExtendsAssignementGenerics getToExtendsGenerics()
  {
    return toExtendsGenerics;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetToExtendsGenerics(ExtendsAssignementGenerics newToExtendsGenerics, NotificationChain msgs)
  {
    ExtendsAssignementGenerics oldToExtendsGenerics = toExtendsGenerics;
    toExtendsGenerics = newToExtendsGenerics;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ProcessorDslPackage.POJOGEN_PROPERTY__TO_EXTENDS_GENERICS, oldToExtendsGenerics, newToExtendsGenerics);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setToExtendsGenerics(ExtendsAssignementGenerics newToExtendsGenerics)
  {
    if (newToExtendsGenerics != toExtendsGenerics)
    {
      NotificationChain msgs = null;
      if (toExtendsGenerics != null)
        msgs = ((InternalEObject)toExtendsGenerics).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ProcessorDslPackage.POJOGEN_PROPERTY__TO_EXTENDS_GENERICS, null, msgs);
      if (newToExtendsGenerics != null)
        msgs = ((InternalEObject)newToExtendsGenerics).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ProcessorDslPackage.POJOGEN_PROPERTY__TO_EXTENDS_GENERICS, null, msgs);
      msgs = basicSetToExtendsGenerics(newToExtendsGenerics, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ProcessorDslPackage.POJOGEN_PROPERTY__TO_EXTENDS_GENERICS, newToExtendsGenerics, newToExtendsGenerics));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getImplPackage()
  {
    return implPackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setImplPackage(String newImplPackage)
  {
    String oldImplPackage = implPackage;
    implPackage = newImplPackage;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ProcessorDslPackage.POJOGEN_PROPERTY__IMPL_PACKAGE, oldImplPackage, implPackage));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getVersion()
  {
    return version;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setVersion(String newVersion)
  {
    String oldVersion = version;
    version = newVersion;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ProcessorDslPackage.POJOGEN_PROPERTY__VERSION, oldVersion, version));
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
      dbNotTables = new EDataTypeEList<String>(String.class, this, ProcessorDslPackage.POJOGEN_PROPERTY__DB_NOT_TABLES);
    }
    return dbNotTables;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DebugLevelAssignement getDebug()
  {
    return debug;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetDebug(DebugLevelAssignement newDebug, NotificationChain msgs)
  {
    DebugLevelAssignement oldDebug = debug;
    debug = newDebug;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ProcessorDslPackage.POJOGEN_PROPERTY__DEBUG, oldDebug, newDebug);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDebug(DebugLevelAssignement newDebug)
  {
    if (newDebug != debug)
    {
      NotificationChain msgs = null;
      if (debug != null)
        msgs = ((InternalEObject)debug).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ProcessorDslPackage.POJOGEN_PROPERTY__DEBUG, null, msgs);
      if (newDebug != null)
        msgs = ((InternalEObject)newDebug).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ProcessorDslPackage.POJOGEN_PROPERTY__DEBUG, null, msgs);
      msgs = basicSetDebug(newDebug, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ProcessorDslPackage.POJOGEN_PROPERTY__DEBUG, newDebug, newDebug));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ProcedurePojoAssignement> getProcPojos()
  {
    if (procPojos == null)
    {
      procPojos = new EObjectContainmentEList<ProcedurePojoAssignement>(ProcedurePojoAssignement.class, this, ProcessorDslPackage.POJOGEN_PROPERTY__PROC_POJOS);
    }
    return procPojos;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<FunctionPojoAssignement> getFunPojos()
  {
    if (funPojos == null)
    {
      funPojos = new EObjectContainmentEList<FunctionPojoAssignement>(FunctionPojoAssignement.class, this, ProcessorDslPackage.POJOGEN_PROPERTY__FUN_POJOS);
    }
    return funPojos;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getActiveFilter()
  {
    return activeFilter;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setActiveFilter(String newActiveFilter)
  {
    String oldActiveFilter = activeFilter;
    activeFilter = newActiveFilter;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ProcessorDslPackage.POJOGEN_PROPERTY__ACTIVE_FILTER, oldActiveFilter, activeFilter));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getPckg()
  {
    return pckg;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPckg(String newPckg)
  {
    String oldPckg = pckg;
    pckg = newPckg;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ProcessorDslPackage.POJOGEN_PROPERTY__PCKG, oldPckg, pckg));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getEnumName()
  {
    return enumName;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setEnumName(String newEnumName)
  {
    String oldEnumName = enumName;
    enumName = newEnumName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ProcessorDslPackage.POJOGEN_PROPERTY__ENUM_NAME, oldEnumName, enumName));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<String> getDbCheckConstraints()
  {
    if (dbCheckConstraints == null)
    {
      dbCheckConstraints = new EDataTypeEList<String>(String.class, this, ProcessorDslPackage.POJOGEN_PROPERTY__DB_CHECK_CONSTRAINTS);
    }
    return dbCheckConstraints;
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
      case ProcessorDslPackage.POJOGEN_PROPERTY__SQL_TYPES:
        return ((InternalEList<?>)getSqlTypes()).basicRemove(otherEnd, msgs);
      case ProcessorDslPackage.POJOGEN_PROPERTY__COLUMN_TYPES:
        return ((InternalEList<?>)getColumnTypes()).basicRemove(otherEnd, msgs);
      case ProcessorDslPackage.POJOGEN_PROPERTY__COLUMN_TYPE:
        return basicSetColumnType(null, msgs);
      case ProcessorDslPackage.POJOGEN_PROPERTY__JOIN_TABLES:
        return ((InternalEList<?>)getJoinTables()).basicRemove(otherEnd, msgs);
      case ProcessorDslPackage.POJOGEN_PROPERTY__TABLES:
        return ((InternalEList<?>)getTables()).basicRemove(otherEnd, msgs);
      case ProcessorDslPackage.POJOGEN_PROPERTY__COLUMNS:
        return ((InternalEList<?>)getColumns()).basicRemove(otherEnd, msgs);
      case ProcessorDslPackage.POJOGEN_PROPERTY__EXPORTS:
        return ((InternalEList<?>)getExports()).basicRemove(otherEnd, msgs);
      case ProcessorDslPackage.POJOGEN_PROPERTY__IMPORTS:
        return ((InternalEList<?>)getImports()).basicRemove(otherEnd, msgs);
      case ProcessorDslPackage.POJOGEN_PROPERTY__MANY2S:
        return ((InternalEList<?>)getMany2s()).basicRemove(otherEnd, msgs);
      case ProcessorDslPackage.POJOGEN_PROPERTY__INHERITANCE:
        return ((InternalEList<?>)getInheritance()).basicRemove(otherEnd, msgs);
      case ProcessorDslPackage.POJOGEN_PROPERTY__TO_IMPLEMENTS:
        return basicSetToImplements(null, msgs);
      case ProcessorDslPackage.POJOGEN_PROPERTY__TO_EXTENDS:
        return basicSetToExtends(null, msgs);
      case ProcessorDslPackage.POJOGEN_PROPERTY__TO_IMPLEMENTS_GENERICS:
        return basicSetToImplementsGenerics(null, msgs);
      case ProcessorDslPackage.POJOGEN_PROPERTY__TO_EXTENDS_GENERICS:
        return basicSetToExtendsGenerics(null, msgs);
      case ProcessorDslPackage.POJOGEN_PROPERTY__DEBUG:
        return basicSetDebug(null, msgs);
      case ProcessorDslPackage.POJOGEN_PROPERTY__PROC_POJOS:
        return ((InternalEList<?>)getProcPojos()).basicRemove(otherEnd, msgs);
      case ProcessorDslPackage.POJOGEN_PROPERTY__FUN_POJOS:
        return ((InternalEList<?>)getFunPojos()).basicRemove(otherEnd, msgs);
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
      case ProcessorDslPackage.POJOGEN_PROPERTY__NAME:
        return getName();
      case ProcessorDslPackage.POJOGEN_PROPERTY__SQL_TYPES:
        return getSqlTypes();
      case ProcessorDslPackage.POJOGEN_PROPERTY__DB_TABLE:
        return getDbTable();
      case ProcessorDslPackage.POJOGEN_PROPERTY__COLUMN_TYPES:
        return getColumnTypes();
      case ProcessorDslPackage.POJOGEN_PROPERTY__DB_PROCEDURE:
        return getDbProcedure();
      case ProcessorDslPackage.POJOGEN_PROPERTY__DB_FUNCTION:
        return getDbFunction();
      case ProcessorDslPackage.POJOGEN_PROPERTY__COLUMN_TYPE:
        return getColumnType();
      case ProcessorDslPackage.POJOGEN_PROPERTY__DB_TABLES:
        return getDbTables();
      case ProcessorDslPackage.POJOGEN_PROPERTY__JOIN_TABLES:
        return getJoinTables();
      case ProcessorDslPackage.POJOGEN_PROPERTY__DB_COLUMNS:
        return getDbColumns();
      case ProcessorDslPackage.POJOGEN_PROPERTY__TABLES:
        return getTables();
      case ProcessorDslPackage.POJOGEN_PROPERTY__COLUMNS:
        return getColumns();
      case ProcessorDslPackage.POJOGEN_PROPERTY__EXPORTS:
        return getExports();
      case ProcessorDslPackage.POJOGEN_PROPERTY__IMPORTS:
        return getImports();
      case ProcessorDslPackage.POJOGEN_PROPERTY__MANY2S:
        return getMany2s();
      case ProcessorDslPackage.POJOGEN_PROPERTY__DB_COLUMN:
        return getDbColumn();
      case ProcessorDslPackage.POJOGEN_PROPERTY__INHERITANCE:
        return getInheritance();
      case ProcessorDslPackage.POJOGEN_PROPERTY__METHODS:
        return getMethods();
      case ProcessorDslPackage.POJOGEN_PROPERTY__OPERATORS_SUFFIX:
        return getOperatorsSuffix();
      case ProcessorDslPackage.POJOGEN_PROPERTY__TO_IMPLEMENTS:
        return getToImplements();
      case ProcessorDslPackage.POJOGEN_PROPERTY__TO_EXTENDS:
        return getToExtends();
      case ProcessorDslPackage.POJOGEN_PROPERTY__TO_IMPLEMENTS_GENERICS:
        return getToImplementsGenerics();
      case ProcessorDslPackage.POJOGEN_PROPERTY__TO_EXTENDS_GENERICS:
        return getToExtendsGenerics();
      case ProcessorDslPackage.POJOGEN_PROPERTY__IMPL_PACKAGE:
        return getImplPackage();
      case ProcessorDslPackage.POJOGEN_PROPERTY__VERSION:
        return getVersion();
      case ProcessorDslPackage.POJOGEN_PROPERTY__DB_NOT_TABLES:
        return getDbNotTables();
      case ProcessorDslPackage.POJOGEN_PROPERTY__DEBUG:
        return getDebug();
      case ProcessorDslPackage.POJOGEN_PROPERTY__PROC_POJOS:
        return getProcPojos();
      case ProcessorDslPackage.POJOGEN_PROPERTY__FUN_POJOS:
        return getFunPojos();
      case ProcessorDslPackage.POJOGEN_PROPERTY__ACTIVE_FILTER:
        return getActiveFilter();
      case ProcessorDslPackage.POJOGEN_PROPERTY__PCKG:
        return getPckg();
      case ProcessorDslPackage.POJOGEN_PROPERTY__ENUM_NAME:
        return getEnumName();
      case ProcessorDslPackage.POJOGEN_PROPERTY__DB_CHECK_CONSTRAINTS:
        return getDbCheckConstraints();
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
      case ProcessorDslPackage.POJOGEN_PROPERTY__NAME:
        setName((String)newValue);
        return;
      case ProcessorDslPackage.POJOGEN_PROPERTY__SQL_TYPES:
        getSqlTypes().clear();
        getSqlTypes().addAll((Collection<? extends SqlTypeAssignement>)newValue);
        return;
      case ProcessorDslPackage.POJOGEN_PROPERTY__DB_TABLE:
        setDbTable((String)newValue);
        return;
      case ProcessorDslPackage.POJOGEN_PROPERTY__COLUMN_TYPES:
        getColumnTypes().clear();
        getColumnTypes().addAll((Collection<? extends ColumnTypeAssignement>)newValue);
        return;
      case ProcessorDslPackage.POJOGEN_PROPERTY__DB_PROCEDURE:
        setDbProcedure((String)newValue);
        return;
      case ProcessorDslPackage.POJOGEN_PROPERTY__DB_FUNCTION:
        setDbFunction((String)newValue);
        return;
      case ProcessorDslPackage.POJOGEN_PROPERTY__COLUMN_TYPE:
        setColumnType((ShowColumnTypeAssignement)newValue);
        return;
      case ProcessorDslPackage.POJOGEN_PROPERTY__DB_TABLES:
        getDbTables().clear();
        getDbTables().addAll((Collection<? extends String>)newValue);
        return;
      case ProcessorDslPackage.POJOGEN_PROPERTY__JOIN_TABLES:
        getJoinTables().clear();
        getJoinTables().addAll((Collection<? extends JoinTableAssignement>)newValue);
        return;
      case ProcessorDslPackage.POJOGEN_PROPERTY__DB_COLUMNS:
        getDbColumns().clear();
        getDbColumns().addAll((Collection<? extends String>)newValue);
        return;
      case ProcessorDslPackage.POJOGEN_PROPERTY__TABLES:
        getTables().clear();
        getTables().addAll((Collection<? extends TableAssignement>)newValue);
        return;
      case ProcessorDslPackage.POJOGEN_PROPERTY__COLUMNS:
        getColumns().clear();
        getColumns().addAll((Collection<? extends ColumnAssignement>)newValue);
        return;
      case ProcessorDslPackage.POJOGEN_PROPERTY__EXPORTS:
        getExports().clear();
        getExports().addAll((Collection<? extends ExportAssignement>)newValue);
        return;
      case ProcessorDslPackage.POJOGEN_PROPERTY__IMPORTS:
        getImports().clear();
        getImports().addAll((Collection<? extends ImportAssignement>)newValue);
        return;
      case ProcessorDslPackage.POJOGEN_PROPERTY__MANY2S:
        getMany2s().clear();
        getMany2s().addAll((Collection<? extends ManyToManyAssignement>)newValue);
        return;
      case ProcessorDslPackage.POJOGEN_PROPERTY__DB_COLUMN:
        setDbColumn((String)newValue);
        return;
      case ProcessorDslPackage.POJOGEN_PROPERTY__INHERITANCE:
        getInheritance().clear();
        getInheritance().addAll((Collection<? extends InheritanceAssignement>)newValue);
        return;
      case ProcessorDslPackage.POJOGEN_PROPERTY__METHODS:
        getMethods().clear();
        getMethods().addAll((Collection<? extends String>)newValue);
        return;
      case ProcessorDslPackage.POJOGEN_PROPERTY__OPERATORS_SUFFIX:
        setOperatorsSuffix((String)newValue);
        return;
      case ProcessorDslPackage.POJOGEN_PROPERTY__TO_IMPLEMENTS:
        setToImplements((ImplementsAssignement)newValue);
        return;
      case ProcessorDslPackage.POJOGEN_PROPERTY__TO_EXTENDS:
        setToExtends((ExtendsAssignement)newValue);
        return;
      case ProcessorDslPackage.POJOGEN_PROPERTY__TO_IMPLEMENTS_GENERICS:
        setToImplementsGenerics((ImplementsAssignementGenerics)newValue);
        return;
      case ProcessorDslPackage.POJOGEN_PROPERTY__TO_EXTENDS_GENERICS:
        setToExtendsGenerics((ExtendsAssignementGenerics)newValue);
        return;
      case ProcessorDslPackage.POJOGEN_PROPERTY__IMPL_PACKAGE:
        setImplPackage((String)newValue);
        return;
      case ProcessorDslPackage.POJOGEN_PROPERTY__VERSION:
        setVersion((String)newValue);
        return;
      case ProcessorDslPackage.POJOGEN_PROPERTY__DB_NOT_TABLES:
        getDbNotTables().clear();
        getDbNotTables().addAll((Collection<? extends String>)newValue);
        return;
      case ProcessorDslPackage.POJOGEN_PROPERTY__DEBUG:
        setDebug((DebugLevelAssignement)newValue);
        return;
      case ProcessorDslPackage.POJOGEN_PROPERTY__PROC_POJOS:
        getProcPojos().clear();
        getProcPojos().addAll((Collection<? extends ProcedurePojoAssignement>)newValue);
        return;
      case ProcessorDslPackage.POJOGEN_PROPERTY__FUN_POJOS:
        getFunPojos().clear();
        getFunPojos().addAll((Collection<? extends FunctionPojoAssignement>)newValue);
        return;
      case ProcessorDslPackage.POJOGEN_PROPERTY__ACTIVE_FILTER:
        setActiveFilter((String)newValue);
        return;
      case ProcessorDslPackage.POJOGEN_PROPERTY__PCKG:
        setPckg((String)newValue);
        return;
      case ProcessorDslPackage.POJOGEN_PROPERTY__ENUM_NAME:
        setEnumName((String)newValue);
        return;
      case ProcessorDslPackage.POJOGEN_PROPERTY__DB_CHECK_CONSTRAINTS:
        getDbCheckConstraints().clear();
        getDbCheckConstraints().addAll((Collection<? extends String>)newValue);
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
      case ProcessorDslPackage.POJOGEN_PROPERTY__NAME:
        setName(NAME_EDEFAULT);
        return;
      case ProcessorDslPackage.POJOGEN_PROPERTY__SQL_TYPES:
        getSqlTypes().clear();
        return;
      case ProcessorDslPackage.POJOGEN_PROPERTY__DB_TABLE:
        setDbTable(DB_TABLE_EDEFAULT);
        return;
      case ProcessorDslPackage.POJOGEN_PROPERTY__COLUMN_TYPES:
        getColumnTypes().clear();
        return;
      case ProcessorDslPackage.POJOGEN_PROPERTY__DB_PROCEDURE:
        setDbProcedure(DB_PROCEDURE_EDEFAULT);
        return;
      case ProcessorDslPackage.POJOGEN_PROPERTY__DB_FUNCTION:
        setDbFunction(DB_FUNCTION_EDEFAULT);
        return;
      case ProcessorDslPackage.POJOGEN_PROPERTY__COLUMN_TYPE:
        setColumnType((ShowColumnTypeAssignement)null);
        return;
      case ProcessorDslPackage.POJOGEN_PROPERTY__DB_TABLES:
        getDbTables().clear();
        return;
      case ProcessorDslPackage.POJOGEN_PROPERTY__JOIN_TABLES:
        getJoinTables().clear();
        return;
      case ProcessorDslPackage.POJOGEN_PROPERTY__DB_COLUMNS:
        getDbColumns().clear();
        return;
      case ProcessorDslPackage.POJOGEN_PROPERTY__TABLES:
        getTables().clear();
        return;
      case ProcessorDslPackage.POJOGEN_PROPERTY__COLUMNS:
        getColumns().clear();
        return;
      case ProcessorDslPackage.POJOGEN_PROPERTY__EXPORTS:
        getExports().clear();
        return;
      case ProcessorDslPackage.POJOGEN_PROPERTY__IMPORTS:
        getImports().clear();
        return;
      case ProcessorDslPackage.POJOGEN_PROPERTY__MANY2S:
        getMany2s().clear();
        return;
      case ProcessorDslPackage.POJOGEN_PROPERTY__DB_COLUMN:
        setDbColumn(DB_COLUMN_EDEFAULT);
        return;
      case ProcessorDslPackage.POJOGEN_PROPERTY__INHERITANCE:
        getInheritance().clear();
        return;
      case ProcessorDslPackage.POJOGEN_PROPERTY__METHODS:
        getMethods().clear();
        return;
      case ProcessorDslPackage.POJOGEN_PROPERTY__OPERATORS_SUFFIX:
        setOperatorsSuffix(OPERATORS_SUFFIX_EDEFAULT);
        return;
      case ProcessorDslPackage.POJOGEN_PROPERTY__TO_IMPLEMENTS:
        setToImplements((ImplementsAssignement)null);
        return;
      case ProcessorDslPackage.POJOGEN_PROPERTY__TO_EXTENDS:
        setToExtends((ExtendsAssignement)null);
        return;
      case ProcessorDslPackage.POJOGEN_PROPERTY__TO_IMPLEMENTS_GENERICS:
        setToImplementsGenerics((ImplementsAssignementGenerics)null);
        return;
      case ProcessorDslPackage.POJOGEN_PROPERTY__TO_EXTENDS_GENERICS:
        setToExtendsGenerics((ExtendsAssignementGenerics)null);
        return;
      case ProcessorDslPackage.POJOGEN_PROPERTY__IMPL_PACKAGE:
        setImplPackage(IMPL_PACKAGE_EDEFAULT);
        return;
      case ProcessorDslPackage.POJOGEN_PROPERTY__VERSION:
        setVersion(VERSION_EDEFAULT);
        return;
      case ProcessorDslPackage.POJOGEN_PROPERTY__DB_NOT_TABLES:
        getDbNotTables().clear();
        return;
      case ProcessorDslPackage.POJOGEN_PROPERTY__DEBUG:
        setDebug((DebugLevelAssignement)null);
        return;
      case ProcessorDslPackage.POJOGEN_PROPERTY__PROC_POJOS:
        getProcPojos().clear();
        return;
      case ProcessorDslPackage.POJOGEN_PROPERTY__FUN_POJOS:
        getFunPojos().clear();
        return;
      case ProcessorDslPackage.POJOGEN_PROPERTY__ACTIVE_FILTER:
        setActiveFilter(ACTIVE_FILTER_EDEFAULT);
        return;
      case ProcessorDslPackage.POJOGEN_PROPERTY__PCKG:
        setPckg(PCKG_EDEFAULT);
        return;
      case ProcessorDslPackage.POJOGEN_PROPERTY__ENUM_NAME:
        setEnumName(ENUM_NAME_EDEFAULT);
        return;
      case ProcessorDslPackage.POJOGEN_PROPERTY__DB_CHECK_CONSTRAINTS:
        getDbCheckConstraints().clear();
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
      case ProcessorDslPackage.POJOGEN_PROPERTY__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case ProcessorDslPackage.POJOGEN_PROPERTY__SQL_TYPES:
        return sqlTypes != null && !sqlTypes.isEmpty();
      case ProcessorDslPackage.POJOGEN_PROPERTY__DB_TABLE:
        return DB_TABLE_EDEFAULT == null ? dbTable != null : !DB_TABLE_EDEFAULT.equals(dbTable);
      case ProcessorDslPackage.POJOGEN_PROPERTY__COLUMN_TYPES:
        return columnTypes != null && !columnTypes.isEmpty();
      case ProcessorDslPackage.POJOGEN_PROPERTY__DB_PROCEDURE:
        return DB_PROCEDURE_EDEFAULT == null ? dbProcedure != null : !DB_PROCEDURE_EDEFAULT.equals(dbProcedure);
      case ProcessorDslPackage.POJOGEN_PROPERTY__DB_FUNCTION:
        return DB_FUNCTION_EDEFAULT == null ? dbFunction != null : !DB_FUNCTION_EDEFAULT.equals(dbFunction);
      case ProcessorDslPackage.POJOGEN_PROPERTY__COLUMN_TYPE:
        return columnType != null;
      case ProcessorDslPackage.POJOGEN_PROPERTY__DB_TABLES:
        return dbTables != null && !dbTables.isEmpty();
      case ProcessorDslPackage.POJOGEN_PROPERTY__JOIN_TABLES:
        return joinTables != null && !joinTables.isEmpty();
      case ProcessorDslPackage.POJOGEN_PROPERTY__DB_COLUMNS:
        return dbColumns != null && !dbColumns.isEmpty();
      case ProcessorDslPackage.POJOGEN_PROPERTY__TABLES:
        return tables != null && !tables.isEmpty();
      case ProcessorDslPackage.POJOGEN_PROPERTY__COLUMNS:
        return columns != null && !columns.isEmpty();
      case ProcessorDslPackage.POJOGEN_PROPERTY__EXPORTS:
        return exports != null && !exports.isEmpty();
      case ProcessorDslPackage.POJOGEN_PROPERTY__IMPORTS:
        return imports != null && !imports.isEmpty();
      case ProcessorDslPackage.POJOGEN_PROPERTY__MANY2S:
        return many2s != null && !many2s.isEmpty();
      case ProcessorDslPackage.POJOGEN_PROPERTY__DB_COLUMN:
        return DB_COLUMN_EDEFAULT == null ? dbColumn != null : !DB_COLUMN_EDEFAULT.equals(dbColumn);
      case ProcessorDslPackage.POJOGEN_PROPERTY__INHERITANCE:
        return inheritance != null && !inheritance.isEmpty();
      case ProcessorDslPackage.POJOGEN_PROPERTY__METHODS:
        return methods != null && !methods.isEmpty();
      case ProcessorDslPackage.POJOGEN_PROPERTY__OPERATORS_SUFFIX:
        return OPERATORS_SUFFIX_EDEFAULT == null ? operatorsSuffix != null : !OPERATORS_SUFFIX_EDEFAULT.equals(operatorsSuffix);
      case ProcessorDslPackage.POJOGEN_PROPERTY__TO_IMPLEMENTS:
        return toImplements != null;
      case ProcessorDslPackage.POJOGEN_PROPERTY__TO_EXTENDS:
        return toExtends != null;
      case ProcessorDslPackage.POJOGEN_PROPERTY__TO_IMPLEMENTS_GENERICS:
        return toImplementsGenerics != null;
      case ProcessorDslPackage.POJOGEN_PROPERTY__TO_EXTENDS_GENERICS:
        return toExtendsGenerics != null;
      case ProcessorDslPackage.POJOGEN_PROPERTY__IMPL_PACKAGE:
        return IMPL_PACKAGE_EDEFAULT == null ? implPackage != null : !IMPL_PACKAGE_EDEFAULT.equals(implPackage);
      case ProcessorDslPackage.POJOGEN_PROPERTY__VERSION:
        return VERSION_EDEFAULT == null ? version != null : !VERSION_EDEFAULT.equals(version);
      case ProcessorDslPackage.POJOGEN_PROPERTY__DB_NOT_TABLES:
        return dbNotTables != null && !dbNotTables.isEmpty();
      case ProcessorDslPackage.POJOGEN_PROPERTY__DEBUG:
        return debug != null;
      case ProcessorDslPackage.POJOGEN_PROPERTY__PROC_POJOS:
        return procPojos != null && !procPojos.isEmpty();
      case ProcessorDslPackage.POJOGEN_PROPERTY__FUN_POJOS:
        return funPojos != null && !funPojos.isEmpty();
      case ProcessorDslPackage.POJOGEN_PROPERTY__ACTIVE_FILTER:
        return ACTIVE_FILTER_EDEFAULT == null ? activeFilter != null : !ACTIVE_FILTER_EDEFAULT.equals(activeFilter);
      case ProcessorDslPackage.POJOGEN_PROPERTY__PCKG:
        return PCKG_EDEFAULT == null ? pckg != null : !PCKG_EDEFAULT.equals(pckg);
      case ProcessorDslPackage.POJOGEN_PROPERTY__ENUM_NAME:
        return ENUM_NAME_EDEFAULT == null ? enumName != null : !ENUM_NAME_EDEFAULT.equals(enumName);
      case ProcessorDslPackage.POJOGEN_PROPERTY__DB_CHECK_CONSTRAINTS:
        return dbCheckConstraints != null && !dbCheckConstraints.isEmpty();
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
    result.append(", dbTable: ");
    result.append(dbTable);
    result.append(", dbProcedure: ");
    result.append(dbProcedure);
    result.append(", dbFunction: ");
    result.append(dbFunction);
    result.append(", dbTables: ");
    result.append(dbTables);
    result.append(", dbColumns: ");
    result.append(dbColumns);
    result.append(", dbColumn: ");
    result.append(dbColumn);
    result.append(", methods: ");
    result.append(methods);
    result.append(", operatorsSuffix: ");
    result.append(operatorsSuffix);
    result.append(", implPackage: ");
    result.append(implPackage);
    result.append(", version: ");
    result.append(version);
    result.append(", dbNotTables: ");
    result.append(dbNotTables);
    result.append(", activeFilter: ");
    result.append(activeFilter);
    result.append(", pckg: ");
    result.append(pckg);
    result.append(", enumName: ");
    result.append(enumName);
    result.append(", dbCheckConstraints: ");
    result.append(dbCheckConstraints);
    result.append(')');
    return result.toString();
  }

} //PojogenPropertyImpl
