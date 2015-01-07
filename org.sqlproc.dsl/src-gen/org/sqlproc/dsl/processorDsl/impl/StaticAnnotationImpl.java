/**
 */
package org.sqlproc.dsl.processorDsl.impl;

import org.eclipse.emf.ecore.EClass;

import org.sqlproc.dsl.processorDsl.ProcessorDslPackage;
import org.sqlproc.dsl.processorDsl.StaticAnnotation;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Static Annotation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class StaticAnnotationImpl extends EntityAnnotationImpl implements StaticAnnotation
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected StaticAnnotationImpl()
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
    return ProcessorDslPackage.eINSTANCE.getStaticAnnotation();
  }

} //StaticAnnotationImpl
