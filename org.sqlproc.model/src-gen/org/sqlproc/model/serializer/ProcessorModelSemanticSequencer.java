package org.sqlproc.model.serializer;

import com.google.inject.Inject;
import com.google.inject.Provider;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmGenericArrayTypeReference;
import org.eclipse.xtext.common.types.JvmInnerTypeReference;
import org.eclipse.xtext.common.types.JvmLowerBound;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmUpperBound;
import org.eclipse.xtext.common.types.JvmWildcardTypeReference;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.serializer.acceptor.ISemanticSequenceAcceptor;
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
import org.eclipse.xtext.serializer.diagnostic.ISemanticSequencerDiagnosticProvider;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic.Acceptor;
import org.eclipse.xtext.serializer.sequencer.GenericSequencer;
import org.eclipse.xtext.serializer.sequencer.ISemanticNodeProvider.INodesForEObjectProvider;
import org.eclipse.xtext.serializer.sequencer.ISemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService.ValueTransient;
import org.eclipse.xtext.xbase.XAssignment;
import org.eclipse.xtext.xbase.XBasicForLoopExpression;
import org.eclipse.xtext.xbase.XBinaryOperation;
import org.eclipse.xtext.xbase.XBlockExpression;
import org.eclipse.xtext.xbase.XBooleanLiteral;
import org.eclipse.xtext.xbase.XCasePart;
import org.eclipse.xtext.xbase.XCastedExpression;
import org.eclipse.xtext.xbase.XCatchClause;
import org.eclipse.xtext.xbase.XClosure;
import org.eclipse.xtext.xbase.XConstructorCall;
import org.eclipse.xtext.xbase.XDoWhileExpression;
import org.eclipse.xtext.xbase.XFeatureCall;
import org.eclipse.xtext.xbase.XForLoopExpression;
import org.eclipse.xtext.xbase.XIfExpression;
import org.eclipse.xtext.xbase.XInstanceOfExpression;
import org.eclipse.xtext.xbase.XListLiteral;
import org.eclipse.xtext.xbase.XMemberFeatureCall;
import org.eclipse.xtext.xbase.XNullLiteral;
import org.eclipse.xtext.xbase.XNumberLiteral;
import org.eclipse.xtext.xbase.XPostfixOperation;
import org.eclipse.xtext.xbase.XReturnExpression;
import org.eclipse.xtext.xbase.XSetLiteral;
import org.eclipse.xtext.xbase.XStringLiteral;
import org.eclipse.xtext.xbase.XSwitchExpression;
import org.eclipse.xtext.xbase.XSynchronizedExpression;
import org.eclipse.xtext.xbase.XThrowExpression;
import org.eclipse.xtext.xbase.XTryCatchFinallyExpression;
import org.eclipse.xtext.xbase.XTypeLiteral;
import org.eclipse.xtext.xbase.XUnaryOperation;
import org.eclipse.xtext.xbase.XVariableDeclaration;
import org.eclipse.xtext.xbase.XWhileExpression;
import org.eclipse.xtext.xbase.XbasePackage;
import org.eclipse.xtext.xbase.annotations.serializer.XbaseWithAnnotationsSemanticSequencer;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotation;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotationElementValuePair;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotationsPackage;
import org.eclipse.xtext.xtype.XFunctionTypeRef;
import org.eclipse.xtext.xtype.XImportDeclaration;
import org.eclipse.xtext.xtype.XImportSection;
import org.eclipse.xtext.xtype.XtypePackage;
import org.sqlproc.model.processorModel.AnnotatedEntity;
import org.sqlproc.model.processorModel.Annotation;
import org.sqlproc.model.processorModel.AnnotationDirectiveAttribute;
import org.sqlproc.model.processorModel.AnnotationDirectiveConflict;
import org.sqlproc.model.processorModel.AnnotationDirectiveConstructor;
import org.sqlproc.model.processorModel.AnnotationDirectiveGetter;
import org.sqlproc.model.processorModel.AnnotationDirectiveSetter;
import org.sqlproc.model.processorModel.AnnotationDirectiveStandard;
import org.sqlproc.model.processorModel.AnnotationDirectiveStatic;
import org.sqlproc.model.processorModel.Artifacts;
import org.sqlproc.model.processorModel.ColumnAssignement;
import org.sqlproc.model.processorModel.ColumnTypeAssignement;
import org.sqlproc.model.processorModel.DaoDirectiveCrud;
import org.sqlproc.model.processorModel.DaoDirectiveDiscriminator;
import org.sqlproc.model.processorModel.DaoDirectiveParameters;
import org.sqlproc.model.processorModel.DaoDirectivePojo;
import org.sqlproc.model.processorModel.DaoDirectiveQuery;
import org.sqlproc.model.processorModel.DaoDirectiveSerializable;
import org.sqlproc.model.processorModel.DaoEntity;
import org.sqlproc.model.processorModel.DaoFunProcDirective;
import org.sqlproc.model.processorModel.DaogenProperty;
import org.sqlproc.model.processorModel.DatabaseCatalogAssignement;
import org.sqlproc.model.processorModel.DatabaseMetaInfoAssignement;
import org.sqlproc.model.processorModel.DatabaseProperty;
import org.sqlproc.model.processorModel.DatabaseSchemaAssignement;
import org.sqlproc.model.processorModel.DatabaseTypeAssignement;
import org.sqlproc.model.processorModel.DebugLevelAssignement;
import org.sqlproc.model.processorModel.DescendantAssignment;
import org.sqlproc.model.processorModel.DirectiveProperties;
import org.sqlproc.model.processorModel.DriverMetaInfoAssignement;
import org.sqlproc.model.processorModel.DriverMethodOutputAssignement;
import org.sqlproc.model.processorModel.EnumAttribute;
import org.sqlproc.model.processorModel.EnumAttributeDirectiveValues;
import org.sqlproc.model.processorModel.EnumAttributeValue;
import org.sqlproc.model.processorModel.EnumDirectiveSerializable;
import org.sqlproc.model.processorModel.EnumEntity;
import org.sqlproc.model.processorModel.ExportAssignement;
import org.sqlproc.model.processorModel.Extends;
import org.sqlproc.model.processorModel.ExtendsAssignement;
import org.sqlproc.model.processorModel.ExtendsAssignementGenerics;
import org.sqlproc.model.processorModel.FunctionCall;
import org.sqlproc.model.processorModel.FunctionCallQuery;
import org.sqlproc.model.processorModel.FunctionDefinition;
import org.sqlproc.model.processorModel.FunctionPojoAssignement;
import org.sqlproc.model.processorModel.FunctionQuery;
import org.sqlproc.model.processorModel.Implements;
import org.sqlproc.model.processorModel.ImplementsAssignement;
import org.sqlproc.model.processorModel.ImplementsAssignementGenerics;
import org.sqlproc.model.processorModel.ImplementsExtendsDirectiveExceptDaos;
import org.sqlproc.model.processorModel.ImplementsExtendsDirectiveExceptPojos;
import org.sqlproc.model.processorModel.ImplementsExtendsDirectiveGenerics;
import org.sqlproc.model.processorModel.ImplementsExtendsDirectiveOnlyDaos;
import org.sqlproc.model.processorModel.ImplementsExtendsDirectiveOnlyPojos;
import org.sqlproc.model.processorModel.ImportAssignement;
import org.sqlproc.model.processorModel.InheritanceAssignement;
import org.sqlproc.model.processorModel.JoinTableAssignement;
import org.sqlproc.model.processorModel.ManyToManyAssignement;
import org.sqlproc.model.processorModel.MetaTypeAssignement;
import org.sqlproc.model.processorModel.MetagenProperty;
import org.sqlproc.model.processorModel.PackageDirectiveImplementation;
import org.sqlproc.model.processorModel.PojoAttribute;
import org.sqlproc.model.processorModel.PojoAttributeDirectiveCreateCol;
import org.sqlproc.model.processorModel.PojoAttributeDirectiveDiscriminator;
import org.sqlproc.model.processorModel.PojoAttributeDirectiveEnumDef;
import org.sqlproc.model.processorModel.PojoAttributeDirectiveEnumInit;
import org.sqlproc.model.processorModel.PojoAttributeDirectiveIndex;
import org.sqlproc.model.processorModel.PojoAttributeDirectiveIsDef;
import org.sqlproc.model.processorModel.PojoAttributeDirectivePrimaryKey;
import org.sqlproc.model.processorModel.PojoAttributeDirectiveRequired;
import org.sqlproc.model.processorModel.PojoAttributeDirectiveToInit;
import org.sqlproc.model.processorModel.PojoAttributeDirectiveUpdateCol;
import org.sqlproc.model.processorModel.PojoAttributeDirectiveVersion;
import org.sqlproc.model.processorModel.PojoDefinition;
import org.sqlproc.model.processorModel.PojoDirectiveDiscriminator;
import org.sqlproc.model.processorModel.PojoDirectiveEquals;
import org.sqlproc.model.processorModel.PojoDirectiveHashCode;
import org.sqlproc.model.processorModel.PojoDirectiveIndex;
import org.sqlproc.model.processorModel.PojoDirectiveOperators;
import org.sqlproc.model.processorModel.PojoDirectiveSerializable;
import org.sqlproc.model.processorModel.PojoDirectiveToString;
import org.sqlproc.model.processorModel.PojoEntity;
import org.sqlproc.model.processorModel.PojoProcedure;
import org.sqlproc.model.processorModel.PojogenProperty;
import org.sqlproc.model.processorModel.ProcedureCallQuery;
import org.sqlproc.model.processorModel.ProcedureDefinition;
import org.sqlproc.model.processorModel.ProcedurePojoAssignement;
import org.sqlproc.model.processorModel.ProcedureUpdate;
import org.sqlproc.model.processorModel.ProcessorModelPackage;
import org.sqlproc.model.processorModel.Property;
import org.sqlproc.model.processorModel.PropertyCondition;
import org.sqlproc.model.processorModel.ShowColumnTypeAssignement;
import org.sqlproc.model.processorModel.SqlTypeAssignement;
import org.sqlproc.model.processorModel.TableAssignement;
import org.sqlproc.model.processorModel.TableDefinition;
import org.sqlproc.model.processorModel.ValueType;
import org.sqlproc.model.services.ProcessorModelGrammarAccess;

@SuppressWarnings("all")
public class ProcessorModelSemanticSequencer extends XbaseWithAnnotationsSemanticSequencer {

	@Inject
	private ProcessorModelGrammarAccess grammarAccess;
	
	public void createSequence(EObject context, EObject semanticObject) {
		if(semanticObject.eClass().getEPackage() == ProcessorModelPackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case ProcessorModelPackage.ANNOTATED_ENTITY:
				if(context == grammarAccess.getAbstractEntityRule() ||
				   context == grammarAccess.getAnnotatedEntityRule()) {
					sequence_AnnotatedEntity(context, (AnnotatedEntity) semanticObject); 
					return; 
				}
				else break;
			case ProcessorModelPackage.ANNOTATION:
				if(context == grammarAccess.getAnnotationRule()) {
					sequence_Annotation(context, (Annotation) semanticObject); 
					return; 
				}
				else break;
			case ProcessorModelPackage.ANNOTATION_DIRECTIVE_ATTRIBUTE:
				if(context == grammarAccess.getAnnotationDirectiveRule()) {
					sequence_AnnotationDirective(context, (AnnotationDirectiveAttribute) semanticObject); 
					return; 
				}
				else break;
			case ProcessorModelPackage.ANNOTATION_DIRECTIVE_CONFLICT:
				if(context == grammarAccess.getAnnotationDirectiveRule()) {
					sequence_AnnotationDirective(context, (AnnotationDirectiveConflict) semanticObject); 
					return; 
				}
				else break;
			case ProcessorModelPackage.ANNOTATION_DIRECTIVE_CONSTRUCTOR:
				if(context == grammarAccess.getAnnotationDirectiveRule()) {
					sequence_AnnotationDirective(context, (AnnotationDirectiveConstructor) semanticObject); 
					return; 
				}
				else break;
			case ProcessorModelPackage.ANNOTATION_DIRECTIVE_GETTER:
				if(context == grammarAccess.getAnnotationDirectiveRule()) {
					sequence_AnnotationDirective(context, (AnnotationDirectiveGetter) semanticObject); 
					return; 
				}
				else break;
			case ProcessorModelPackage.ANNOTATION_DIRECTIVE_SETTER:
				if(context == grammarAccess.getAnnotationDirectiveRule()) {
					sequence_AnnotationDirective(context, (AnnotationDirectiveSetter) semanticObject); 
					return; 
				}
				else break;
			case ProcessorModelPackage.ANNOTATION_DIRECTIVE_STANDARD:
				if(context == grammarAccess.getAnnotationDirectiveRule()) {
					sequence_AnnotationDirective(context, (AnnotationDirectiveStandard) semanticObject); 
					return; 
				}
				else break;
			case ProcessorModelPackage.ANNOTATION_DIRECTIVE_STATIC:
				if(context == grammarAccess.getAnnotationDirectiveRule()) {
					sequence_AnnotationDirective(context, (AnnotationDirectiveStatic) semanticObject); 
					return; 
				}
				else break;
			case ProcessorModelPackage.ARTIFACTS:
				if(context == grammarAccess.getArtifactsRule()) {
					sequence_Artifacts(context, (Artifacts) semanticObject); 
					return; 
				}
				else break;
			case ProcessorModelPackage.COLUMN_ASSIGNEMENT:
				if(context == grammarAccess.getColumnAssignementRule()) {
					sequence_ColumnAssignement(context, (ColumnAssignement) semanticObject); 
					return; 
				}
				else break;
			case ProcessorModelPackage.COLUMN_TYPE_ASSIGNEMENT:
				if(context == grammarAccess.getColumnTypeAssignementRule()) {
					sequence_ColumnTypeAssignement(context, (ColumnTypeAssignement) semanticObject); 
					return; 
				}
				else break;
			case ProcessorModelPackage.DAO_DIRECTIVE_CRUD:
				if(context == grammarAccess.getDaoDirectiveRule()) {
					sequence_DaoDirective(context, (DaoDirectiveCrud) semanticObject); 
					return; 
				}
				else break;
			case ProcessorModelPackage.DAO_DIRECTIVE_DISCRIMINATOR:
				if(context == grammarAccess.getDaoDirectiveRule()) {
					sequence_DaoDirective(context, (DaoDirectiveDiscriminator) semanticObject); 
					return; 
				}
				else break;
			case ProcessorModelPackage.DAO_DIRECTIVE_PARAMETERS:
				if(context == grammarAccess.getDaoDirectiveParametersRule()) {
					sequence_DaoDirectiveParameters(context, (DaoDirectiveParameters) semanticObject); 
					return; 
				}
				else break;
			case ProcessorModelPackage.DAO_DIRECTIVE_POJO:
				if(context == grammarAccess.getDaoDirectiveRule()) {
					sequence_DaoDirective(context, (DaoDirectivePojo) semanticObject); 
					return; 
				}
				else break;
			case ProcessorModelPackage.DAO_DIRECTIVE_QUERY:
				if(context == grammarAccess.getDaoDirectiveRule()) {
					sequence_DaoDirective(context, (DaoDirectiveQuery) semanticObject); 
					return; 
				}
				else break;
			case ProcessorModelPackage.DAO_DIRECTIVE_SERIALIZABLE:
				if(context == grammarAccess.getDaoDirectiveRule()) {
					sequence_DaoDirective(context, (DaoDirectiveSerializable) semanticObject); 
					return; 
				}
				else break;
			case ProcessorModelPackage.DAO_ENTITY:
				if(context == grammarAccess.getDaoEntityRule() ||
				   context == grammarAccess.getEntityRule()) {
					sequence_DaoEntity(context, (DaoEntity) semanticObject); 
					return; 
				}
				else break;
			case ProcessorModelPackage.DAO_FUN_PROC_DIRECTIVE:
				if(context == grammarAccess.getDaoDirectiveRule()) {
					sequence_DaoDirective(context, (DaoFunProcDirective) semanticObject); 
					return; 
				}
				else break;
			case ProcessorModelPackage.DAOGEN_PROPERTY:
				if(context == grammarAccess.getDaogenPropertyRule()) {
					sequence_DaogenProperty(context, (DaogenProperty) semanticObject); 
					return; 
				}
				else break;
			case ProcessorModelPackage.DATABASE_CATALOG_ASSIGNEMENT:
				if(context == grammarAccess.getDatabaseCatalogAssignementRule()) {
					sequence_DatabaseCatalogAssignement(context, (DatabaseCatalogAssignement) semanticObject); 
					return; 
				}
				else break;
			case ProcessorModelPackage.DATABASE_META_INFO_ASSIGNEMENT:
				if(context == grammarAccess.getDatabaseMetaInfoAssignementRule()) {
					sequence_DatabaseMetaInfoAssignement(context, (DatabaseMetaInfoAssignement) semanticObject); 
					return; 
				}
				else break;
			case ProcessorModelPackage.DATABASE_PROPERTY:
				if(context == grammarAccess.getDatabasePropertyRule()) {
					sequence_DatabaseProperty(context, (DatabaseProperty) semanticObject); 
					return; 
				}
				else break;
			case ProcessorModelPackage.DATABASE_SCHEMA_ASSIGNEMENT:
				if(context == grammarAccess.getDatabaseSchemaAssignementRule()) {
					sequence_DatabaseSchemaAssignement(context, (DatabaseSchemaAssignement) semanticObject); 
					return; 
				}
				else break;
			case ProcessorModelPackage.DATABASE_TYPE_ASSIGNEMENT:
				if(context == grammarAccess.getDatabaseTypeAssignementRule()) {
					sequence_DatabaseTypeAssignement(context, (DatabaseTypeAssignement) semanticObject); 
					return; 
				}
				else break;
			case ProcessorModelPackage.DEBUG_LEVEL_ASSIGNEMENT:
				if(context == grammarAccess.getDebugLevelAssignementRule()) {
					sequence_DebugLevelAssignement(context, (DebugLevelAssignement) semanticObject); 
					return; 
				}
				else break;
			case ProcessorModelPackage.DESCENDANT_ASSIGNMENT:
				if(context == grammarAccess.getDescendantAssignmentRule()) {
					sequence_DescendantAssignment(context, (DescendantAssignment) semanticObject); 
					return; 
				}
				else break;
			case ProcessorModelPackage.DIRECTIVE_PROPERTIES:
				if(context == grammarAccess.getDirectivePropertiesRule()) {
					sequence_DirectiveProperties(context, (DirectiveProperties) semanticObject); 
					return; 
				}
				else break;
			case ProcessorModelPackage.DRIVER_META_INFO_ASSIGNEMENT:
				if(context == grammarAccess.getDriverMetaInfoAssignementRule()) {
					sequence_DriverMetaInfoAssignement(context, (DriverMetaInfoAssignement) semanticObject); 
					return; 
				}
				else break;
			case ProcessorModelPackage.DRIVER_METHOD_OUTPUT_ASSIGNEMENT:
				if(context == grammarAccess.getDriverMethodOutputAssignementRule()) {
					sequence_DriverMethodOutputAssignement(context, (DriverMethodOutputAssignement) semanticObject); 
					return; 
				}
				else break;
			case ProcessorModelPackage.ENUM_ATTRIBUTE:
				if(context == grammarAccess.getEnumAttributeRule()) {
					sequence_EnumAttribute(context, (EnumAttribute) semanticObject); 
					return; 
				}
				else break;
			case ProcessorModelPackage.ENUM_ATTRIBUTE_DIRECTIVE_VALUES:
				if(context == grammarAccess.getEnumAttributeDirectiveRule()) {
					sequence_EnumAttributeDirective(context, (EnumAttributeDirectiveValues) semanticObject); 
					return; 
				}
				else break;
			case ProcessorModelPackage.ENUM_ATTRIBUTE_VALUE:
				if(context == grammarAccess.getEnumAttributeValueRule()) {
					sequence_EnumAttributeValue(context, (EnumAttributeValue) semanticObject); 
					return; 
				}
				else break;
			case ProcessorModelPackage.ENUM_DIRECTIVE_SERIALIZABLE:
				if(context == grammarAccess.getEnumDirectiveRule()) {
					sequence_EnumDirective(context, (EnumDirectiveSerializable) semanticObject); 
					return; 
				}
				else break;
			case ProcessorModelPackage.ENUM_ENTITY:
				if(context == grammarAccess.getEntityRule() ||
				   context == grammarAccess.getEnumEntityRule()) {
					sequence_EnumEntity(context, (EnumEntity) semanticObject); 
					return; 
				}
				else break;
			case ProcessorModelPackage.EXPORT_ASSIGNEMENT:
				if(context == grammarAccess.getExportAssignementRule()) {
					sequence_ExportAssignement(context, (ExportAssignement) semanticObject); 
					return; 
				}
				else break;
			case ProcessorModelPackage.EXTENDS:
				if(context == grammarAccess.getAbstractEntityRule() ||
				   context == grammarAccess.getExtendsRule()) {
					sequence_Extends(context, (Extends) semanticObject); 
					return; 
				}
				else break;
			case ProcessorModelPackage.EXTENDS_ASSIGNEMENT:
				if(context == grammarAccess.getExtendsAssignementRule()) {
					sequence_ExtendsAssignement(context, (ExtendsAssignement) semanticObject); 
					return; 
				}
				else break;
			case ProcessorModelPackage.EXTENDS_ASSIGNEMENT_GENERICS:
				if(context == grammarAccess.getExtendsAssignementGenericsRule()) {
					sequence_ExtendsAssignementGenerics(context, (ExtendsAssignementGenerics) semanticObject); 
					return; 
				}
				else break;
			case ProcessorModelPackage.FUNCTION_CALL:
				if(context == grammarAccess.getFunProcTypeRule()) {
					sequence_FunProcType(context, (FunctionCall) semanticObject); 
					return; 
				}
				else break;
			case ProcessorModelPackage.FUNCTION_CALL_QUERY:
				if(context == grammarAccess.getFunProcTypeRule()) {
					sequence_FunProcType(context, (FunctionCallQuery) semanticObject); 
					return; 
				}
				else break;
			case ProcessorModelPackage.FUNCTION_DEFINITION:
				if(context == grammarAccess.getFunctionDefinitionRule()) {
					sequence_FunctionDefinition(context, (FunctionDefinition) semanticObject); 
					return; 
				}
				else break;
			case ProcessorModelPackage.FUNCTION_POJO_ASSIGNEMENT:
				if(context == grammarAccess.getFunctionPojoAssignementRule()) {
					sequence_FunctionPojoAssignement(context, (FunctionPojoAssignement) semanticObject); 
					return; 
				}
				else break;
			case ProcessorModelPackage.FUNCTION_QUERY:
				if(context == grammarAccess.getFunProcTypeRule()) {
					sequence_FunProcType(context, (FunctionQuery) semanticObject); 
					return; 
				}
				else break;
			case ProcessorModelPackage.IMPLEMENTS:
				if(context == grammarAccess.getAbstractEntityRule() ||
				   context == grammarAccess.getImplementsRule()) {
					sequence_Implements(context, (Implements) semanticObject); 
					return; 
				}
				else break;
			case ProcessorModelPackage.IMPLEMENTS_ASSIGNEMENT:
				if(context == grammarAccess.getImplementsAssignementRule()) {
					sequence_ImplementsAssignement(context, (ImplementsAssignement) semanticObject); 
					return; 
				}
				else break;
			case ProcessorModelPackage.IMPLEMENTS_ASSIGNEMENT_GENERICS:
				if(context == grammarAccess.getImplementsAssignementGenericsRule()) {
					sequence_ImplementsAssignementGenerics(context, (ImplementsAssignementGenerics) semanticObject); 
					return; 
				}
				else break;
			case ProcessorModelPackage.IMPLEMENTS_EXTENDS_DIRECTIVE_EXCEPT_DAOS:
				if(context == grammarAccess.getImplementsExtendsDirectiveRule()) {
					sequence_ImplementsExtendsDirective(context, (ImplementsExtendsDirectiveExceptDaos) semanticObject); 
					return; 
				}
				else break;
			case ProcessorModelPackage.IMPLEMENTS_EXTENDS_DIRECTIVE_EXCEPT_POJOS:
				if(context == grammarAccess.getImplementsExtendsDirectiveRule()) {
					sequence_ImplementsExtendsDirective(context, (ImplementsExtendsDirectiveExceptPojos) semanticObject); 
					return; 
				}
				else break;
			case ProcessorModelPackage.IMPLEMENTS_EXTENDS_DIRECTIVE_GENERICS:
				if(context == grammarAccess.getImplementsExtendsDirectiveRule()) {
					sequence_ImplementsExtendsDirective(context, (ImplementsExtendsDirectiveGenerics) semanticObject); 
					return; 
				}
				else break;
			case ProcessorModelPackage.IMPLEMENTS_EXTENDS_DIRECTIVE_ONLY_DAOS:
				if(context == grammarAccess.getImplementsExtendsDirectiveRule()) {
					sequence_ImplementsExtendsDirective(context, (ImplementsExtendsDirectiveOnlyDaos) semanticObject); 
					return; 
				}
				else break;
			case ProcessorModelPackage.IMPLEMENTS_EXTENDS_DIRECTIVE_ONLY_POJOS:
				if(context == grammarAccess.getImplementsExtendsDirectiveRule()) {
					sequence_ImplementsExtendsDirective(context, (ImplementsExtendsDirectiveOnlyPojos) semanticObject); 
					return; 
				}
				else break;
			case ProcessorModelPackage.IMPORT_ASSIGNEMENT:
				if(context == grammarAccess.getImportAssignementRule()) {
					sequence_ImportAssignement(context, (ImportAssignement) semanticObject); 
					return; 
				}
				else break;
			case ProcessorModelPackage.INHERITANCE_ASSIGNEMENT:
				if(context == grammarAccess.getInheritanceAssignementRule()) {
					sequence_InheritanceAssignement(context, (InheritanceAssignement) semanticObject); 
					return; 
				}
				else break;
			case ProcessorModelPackage.JOIN_TABLE_ASSIGNEMENT:
				if(context == grammarAccess.getJoinTableAssignementRule()) {
					sequence_JoinTableAssignement(context, (JoinTableAssignement) semanticObject); 
					return; 
				}
				else break;
			case ProcessorModelPackage.MANY_TO_MANY_ASSIGNEMENT:
				if(context == grammarAccess.getManyToManyAssignementRule()) {
					sequence_ManyToManyAssignement(context, (ManyToManyAssignement) semanticObject); 
					return; 
				}
				else break;
			case ProcessorModelPackage.META_TYPE_ASSIGNEMENT:
				if(context == grammarAccess.getMetaTypeAssignementRule()) {
					sequence_MetaTypeAssignement(context, (MetaTypeAssignement) semanticObject); 
					return; 
				}
				else break;
			case ProcessorModelPackage.METAGEN_PROPERTY:
				if(context == grammarAccess.getMetagenPropertyRule()) {
					sequence_MetagenProperty(context, (MetagenProperty) semanticObject); 
					return; 
				}
				else break;
			case ProcessorModelPackage.PACKAGE:
				if(context == grammarAccess.getPackageRule()) {
					sequence_Package(context, (org.sqlproc.model.processorModel.Package) semanticObject); 
					return; 
				}
				else break;
			case ProcessorModelPackage.PACKAGE_DIRECTIVE_IMPLEMENTATION:
				if(context == grammarAccess.getPackageDirectiveRule()) {
					sequence_PackageDirective(context, (PackageDirectiveImplementation) semanticObject); 
					return; 
				}
				else break;
			case ProcessorModelPackage.POJO_ATTRIBUTE:
				if(context == grammarAccess.getPojoAttributeRule()) {
					sequence_PojoAttribute(context, (PojoAttribute) semanticObject); 
					return; 
				}
				else break;
			case ProcessorModelPackage.POJO_ATTRIBUTE_DIRECTIVE_CREATE_COL:
				if(context == grammarAccess.getPojoAttributeDirectiveRule()) {
					sequence_PojoAttributeDirective(context, (PojoAttributeDirectiveCreateCol) semanticObject); 
					return; 
				}
				else break;
			case ProcessorModelPackage.POJO_ATTRIBUTE_DIRECTIVE_DISCRIMINATOR:
				if(context == grammarAccess.getPojoAttributeDirectiveRule()) {
					sequence_PojoAttributeDirective(context, (PojoAttributeDirectiveDiscriminator) semanticObject); 
					return; 
				}
				else break;
			case ProcessorModelPackage.POJO_ATTRIBUTE_DIRECTIVE_ENUM_DEF:
				if(context == grammarAccess.getPojoAttributeDirectiveRule()) {
					sequence_PojoAttributeDirective(context, (PojoAttributeDirectiveEnumDef) semanticObject); 
					return; 
				}
				else break;
			case ProcessorModelPackage.POJO_ATTRIBUTE_DIRECTIVE_ENUM_INIT:
				if(context == grammarAccess.getPojoAttributeDirectiveRule()) {
					sequence_PojoAttributeDirective(context, (PojoAttributeDirectiveEnumInit) semanticObject); 
					return; 
				}
				else break;
			case ProcessorModelPackage.POJO_ATTRIBUTE_DIRECTIVE_INDEX:
				if(context == grammarAccess.getPojoAttributeDirectiveRule()) {
					sequence_PojoAttributeDirective(context, (PojoAttributeDirectiveIndex) semanticObject); 
					return; 
				}
				else break;
			case ProcessorModelPackage.POJO_ATTRIBUTE_DIRECTIVE_IS_DEF:
				if(context == grammarAccess.getPojoAttributeDirectiveRule()) {
					sequence_PojoAttributeDirective(context, (PojoAttributeDirectiveIsDef) semanticObject); 
					return; 
				}
				else break;
			case ProcessorModelPackage.POJO_ATTRIBUTE_DIRECTIVE_PRIMARY_KEY:
				if(context == grammarAccess.getPojoAttributeDirectiveRule()) {
					sequence_PojoAttributeDirective(context, (PojoAttributeDirectivePrimaryKey) semanticObject); 
					return; 
				}
				else break;
			case ProcessorModelPackage.POJO_ATTRIBUTE_DIRECTIVE_REQUIRED:
				if(context == grammarAccess.getPojoAttributeDirectiveRule()) {
					sequence_PojoAttributeDirective(context, (PojoAttributeDirectiveRequired) semanticObject); 
					return; 
				}
				else break;
			case ProcessorModelPackage.POJO_ATTRIBUTE_DIRECTIVE_TO_INIT:
				if(context == grammarAccess.getPojoAttributeDirectiveRule()) {
					sequence_PojoAttributeDirective(context, (PojoAttributeDirectiveToInit) semanticObject); 
					return; 
				}
				else break;
			case ProcessorModelPackage.POJO_ATTRIBUTE_DIRECTIVE_UPDATE_COL:
				if(context == grammarAccess.getPojoAttributeDirectiveRule()) {
					sequence_PojoAttributeDirective(context, (PojoAttributeDirectiveUpdateCol) semanticObject); 
					return; 
				}
				else break;
			case ProcessorModelPackage.POJO_ATTRIBUTE_DIRECTIVE_VERSION:
				if(context == grammarAccess.getPojoAttributeDirectiveRule()) {
					sequence_PojoAttributeDirective(context, (PojoAttributeDirectiveVersion) semanticObject); 
					return; 
				}
				else break;
			case ProcessorModelPackage.POJO_DEFINITION:
				if(context == grammarAccess.getPojoDefinitionRule()) {
					sequence_PojoDefinition(context, (PojoDefinition) semanticObject); 
					return; 
				}
				else break;
			case ProcessorModelPackage.POJO_DIRECTIVE_DISCRIMINATOR:
				if(context == grammarAccess.getPojoDirectiveRule()) {
					sequence_PojoDirective(context, (PojoDirectiveDiscriminator) semanticObject); 
					return; 
				}
				else break;
			case ProcessorModelPackage.POJO_DIRECTIVE_EQUALS:
				if(context == grammarAccess.getPojoDirectiveRule()) {
					sequence_PojoDirective(context, (PojoDirectiveEquals) semanticObject); 
					return; 
				}
				else break;
			case ProcessorModelPackage.POJO_DIRECTIVE_HASH_CODE:
				if(context == grammarAccess.getPojoDirectiveRule()) {
					sequence_PojoDirective(context, (PojoDirectiveHashCode) semanticObject); 
					return; 
				}
				else break;
			case ProcessorModelPackage.POJO_DIRECTIVE_INDEX:
				if(context == grammarAccess.getPojoDirectiveRule()) {
					sequence_PojoDirective(context, (PojoDirectiveIndex) semanticObject); 
					return; 
				}
				else break;
			case ProcessorModelPackage.POJO_DIRECTIVE_OPERATORS:
				if(context == grammarAccess.getPojoDirectiveRule()) {
					sequence_PojoDirective(context, (PojoDirectiveOperators) semanticObject); 
					return; 
				}
				else break;
			case ProcessorModelPackage.POJO_DIRECTIVE_SERIALIZABLE:
				if(context == grammarAccess.getPojoDirectiveRule()) {
					sequence_PojoDirective(context, (PojoDirectiveSerializable) semanticObject); 
					return; 
				}
				else break;
			case ProcessorModelPackage.POJO_DIRECTIVE_TO_STRING:
				if(context == grammarAccess.getPojoDirectiveRule()) {
					sequence_PojoDirective(context, (PojoDirectiveToString) semanticObject); 
					return; 
				}
				else break;
			case ProcessorModelPackage.POJO_ENTITY:
				if(context == grammarAccess.getEntityRule() ||
				   context == grammarAccess.getPojoEntityRule()) {
					sequence_PojoEntity(context, (PojoEntity) semanticObject); 
					return; 
				}
				else break;
			case ProcessorModelPackage.POJO_PROCEDURE:
				if(context == grammarAccess.getPojoProcedureRule()) {
					sequence_PojoProcedure(context, (PojoProcedure) semanticObject); 
					return; 
				}
				else break;
			case ProcessorModelPackage.POJOGEN_PROPERTY:
				if(context == grammarAccess.getPojogenPropertyRule()) {
					sequence_PojogenProperty(context, (PojogenProperty) semanticObject); 
					return; 
				}
				else break;
			case ProcessorModelPackage.PROCEDURE_CALL_QUERY:
				if(context == grammarAccess.getFunProcTypeRule()) {
					sequence_FunProcType(context, (ProcedureCallQuery) semanticObject); 
					return; 
				}
				else break;
			case ProcessorModelPackage.PROCEDURE_DEFINITION:
				if(context == grammarAccess.getProcedureDefinitionRule()) {
					sequence_ProcedureDefinition(context, (ProcedureDefinition) semanticObject); 
					return; 
				}
				else break;
			case ProcessorModelPackage.PROCEDURE_POJO_ASSIGNEMENT:
				if(context == grammarAccess.getProcedurePojoAssignementRule()) {
					sequence_ProcedurePojoAssignement(context, (ProcedurePojoAssignement) semanticObject); 
					return; 
				}
				else break;
			case ProcessorModelPackage.PROCEDURE_UPDATE:
				if(context == grammarAccess.getFunProcTypeRule()) {
					sequence_FunProcType(context, (ProcedureUpdate) semanticObject); 
					return; 
				}
				else break;
			case ProcessorModelPackage.PROPERTY:
				if(context == grammarAccess.getPropertyRule()) {
					sequence_Property(context, (Property) semanticObject); 
					return; 
				}
				else break;
			case ProcessorModelPackage.PROPERTY_CONDITION:
				if(context == grammarAccess.getPropertyConditionRule()) {
					sequence_PropertyCondition(context, (PropertyCondition) semanticObject); 
					return; 
				}
				else break;
			case ProcessorModelPackage.SHOW_COLUMN_TYPE_ASSIGNEMENT:
				if(context == grammarAccess.getShowColumnTypeAssignementRule()) {
					sequence_ShowColumnTypeAssignement(context, (ShowColumnTypeAssignement) semanticObject); 
					return; 
				}
				else break;
			case ProcessorModelPackage.SQL_TYPE_ASSIGNEMENT:
				if(context == grammarAccess.getSqlTypeAssignementRule()) {
					sequence_SqlTypeAssignement(context, (SqlTypeAssignement) semanticObject); 
					return; 
				}
				else break;
			case ProcessorModelPackage.TABLE_ASSIGNEMENT:
				if(context == grammarAccess.getTableAssignementRule()) {
					sequence_TableAssignement(context, (TableAssignement) semanticObject); 
					return; 
				}
				else break;
			case ProcessorModelPackage.TABLE_DEFINITION:
				if(context == grammarAccess.getTableDefinitionRule()) {
					sequence_TableDefinition(context, (TableDefinition) semanticObject); 
					return; 
				}
				else break;
			case ProcessorModelPackage.VALUE_TYPE:
				if(context == grammarAccess.getValueTypeRule()) {
					sequence_ValueType(context, (ValueType) semanticObject); 
					return; 
				}
				else break;
			}
		else if(semanticObject.eClass().getEPackage() == TypesPackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case TypesPackage.JVM_FORMAL_PARAMETER:
				if(context == grammarAccess.getFullJvmFormalParameterRule()) {
					sequence_FullJvmFormalParameter(context, (JvmFormalParameter) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getJvmFormalParameterRule()) {
					sequence_JvmFormalParameter(context, (JvmFormalParameter) semanticObject); 
					return; 
				}
				else break;
			case TypesPackage.JVM_GENERIC_ARRAY_TYPE_REFERENCE:
				if(context == grammarAccess.getJvmArgumentTypeReferenceRule() ||
				   context == grammarAccess.getJvmTypeReferenceRule() ||
				   context == grammarAccess.getJvmTypeReferenceAccess().getJvmGenericArrayTypeReferenceComponentTypeAction_0_1_0_0()) {
					sequence_JvmTypeReference(context, (JvmGenericArrayTypeReference) semanticObject); 
					return; 
				}
				else break;
			case TypesPackage.JVM_INNER_TYPE_REFERENCE:
				if(context == grammarAccess.getJvmArgumentTypeReferenceRule() ||
				   context == grammarAccess.getJvmParameterizedTypeReferenceRule() ||
				   context == grammarAccess.getJvmParameterizedTypeReferenceAccess().getJvmInnerTypeReferenceOuterAction_1_4_0_0_0() ||
				   context == grammarAccess.getJvmTypeReferenceRule() ||
				   context == grammarAccess.getJvmTypeReferenceAccess().getJvmGenericArrayTypeReferenceComponentTypeAction_0_1_0_0()) {
					sequence_JvmParameterizedTypeReference(context, (JvmInnerTypeReference) semanticObject); 
					return; 
				}
				else break;
			case TypesPackage.JVM_LOWER_BOUND:
				if(context == grammarAccess.getJvmLowerBoundAndedRule()) {
					sequence_JvmLowerBoundAnded(context, (JvmLowerBound) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getJvmLowerBoundRule()) {
					sequence_JvmLowerBound(context, (JvmLowerBound) semanticObject); 
					return; 
				}
				else break;
			case TypesPackage.JVM_PARAMETERIZED_TYPE_REFERENCE:
				if(context == grammarAccess.getJvmArgumentTypeReferenceRule() ||
				   context == grammarAccess.getJvmParameterizedTypeReferenceRule() ||
				   context == grammarAccess.getJvmParameterizedTypeReferenceAccess().getJvmInnerTypeReferenceOuterAction_1_4_0_0_0() ||
				   context == grammarAccess.getJvmTypeReferenceRule() ||
				   context == grammarAccess.getJvmTypeReferenceAccess().getJvmGenericArrayTypeReferenceComponentTypeAction_0_1_0_0()) {
					sequence_JvmParameterizedTypeReference(context, (JvmParameterizedTypeReference) semanticObject); 
					return; 
				}
				else break;
			case TypesPackage.JVM_TYPE_PARAMETER:
				if(context == grammarAccess.getJvmTypeParameterRule()) {
					sequence_JvmTypeParameter(context, (JvmTypeParameter) semanticObject); 
					return; 
				}
				else break;
			case TypesPackage.JVM_UPPER_BOUND:
				if(context == grammarAccess.getJvmUpperBoundAndedRule()) {
					sequence_JvmUpperBoundAnded(context, (JvmUpperBound) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getJvmUpperBoundRule()) {
					sequence_JvmUpperBound(context, (JvmUpperBound) semanticObject); 
					return; 
				}
				else break;
			case TypesPackage.JVM_WILDCARD_TYPE_REFERENCE:
				if(context == grammarAccess.getJvmArgumentTypeReferenceRule() ||
				   context == grammarAccess.getJvmWildcardTypeReferenceRule()) {
					sequence_JvmWildcardTypeReference(context, (JvmWildcardTypeReference) semanticObject); 
					return; 
				}
				else break;
			}
		else if(semanticObject.eClass().getEPackage() == XAnnotationsPackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case XAnnotationsPackage.XANNOTATION:
				if(context == grammarAccess.getXAnnotationRule() ||
				   context == grammarAccess.getXAnnotationElementValueRule() ||
				   context == grammarAccess.getXAnnotationElementValueOrCommaListRule() ||
				   context == grammarAccess.getXAnnotationElementValueOrCommaListAccess().getXListLiteralElementsAction_1_1_0() ||
				   context == grammarAccess.getXAnnotationOrExpressionRule()) {
					sequence_XAnnotation(context, (XAnnotation) semanticObject); 
					return; 
				}
				else break;
			case XAnnotationsPackage.XANNOTATION_ELEMENT_VALUE_PAIR:
				if(context == grammarAccess.getXAnnotationElementValuePairRule()) {
					sequence_XAnnotationElementValuePair(context, (XAnnotationElementValuePair) semanticObject); 
					return; 
				}
				else break;
			}
		else if(semanticObject.eClass().getEPackage() == XbasePackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case XbasePackage.XASSIGNMENT:
				if(context == grammarAccess.getXAdditiveExpressionRule() ||
				   context == grammarAccess.getXAdditiveExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXAndExpressionRule() ||
				   context == grammarAccess.getXAndExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXAnnotationElementValueRule() ||
				   context == grammarAccess.getXAnnotationElementValueOrCommaListRule() ||
				   context == grammarAccess.getXAnnotationElementValueOrCommaListAccess().getXListLiteralElementsAction_1_1_0() ||
				   context == grammarAccess.getXAnnotationOrExpressionRule() ||
				   context == grammarAccess.getXAssignmentRule() ||
				   context == grammarAccess.getXAssignmentAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0() ||
				   context == grammarAccess.getXCastedExpressionRule() ||
				   context == grammarAccess.getXCastedExpressionAccess().getXCastedExpressionTargetAction_1_0_0_0() ||
				   context == grammarAccess.getXEqualityExpressionRule() ||
				   context == grammarAccess.getXEqualityExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXExpressionRule() ||
				   context == grammarAccess.getXExpressionOrVarDeclarationRule() ||
				   context == grammarAccess.getXMemberFeatureCallRule() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXAssignmentAssignableAction_1_0_0_0_0() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXMemberFeatureCallMemberCallTargetAction_1_1_0_0_0() ||
				   context == grammarAccess.getXMultiplicativeExpressionRule() ||
				   context == grammarAccess.getXMultiplicativeExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXOrExpressionRule() ||
				   context == grammarAccess.getXOrExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXOtherOperatorExpressionRule() ||
				   context == grammarAccess.getXOtherOperatorExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXParenthesizedExpressionRule() ||
				   context == grammarAccess.getXPostfixOperationRule() ||
				   context == grammarAccess.getXPostfixOperationAccess().getXPostfixOperationOperandAction_1_0_0() ||
				   context == grammarAccess.getXPrimaryExpressionRule() ||
				   context == grammarAccess.getXRelationalExpressionRule() ||
				   context == grammarAccess.getXRelationalExpressionAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0() ||
				   context == grammarAccess.getXRelationalExpressionAccess().getXInstanceOfExpressionExpressionAction_1_0_0_0_0() ||
				   context == grammarAccess.getXUnaryOperationRule()) {
					sequence_XAssignment_XMemberFeatureCall(context, (XAssignment) semanticObject); 
					return; 
				}
				else break;
			case XbasePackage.XBASIC_FOR_LOOP_EXPRESSION:
				if(context == grammarAccess.getXAdditiveExpressionRule() ||
				   context == grammarAccess.getXAdditiveExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXAndExpressionRule() ||
				   context == grammarAccess.getXAndExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXAnnotationElementValueRule() ||
				   context == grammarAccess.getXAnnotationElementValueOrCommaListRule() ||
				   context == grammarAccess.getXAnnotationElementValueOrCommaListAccess().getXListLiteralElementsAction_1_1_0() ||
				   context == grammarAccess.getXAnnotationOrExpressionRule() ||
				   context == grammarAccess.getXAssignmentRule() ||
				   context == grammarAccess.getXAssignmentAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0() ||
				   context == grammarAccess.getXBasicForLoopExpressionRule() ||
				   context == grammarAccess.getXCastedExpressionRule() ||
				   context == grammarAccess.getXCastedExpressionAccess().getXCastedExpressionTargetAction_1_0_0_0() ||
				   context == grammarAccess.getXEqualityExpressionRule() ||
				   context == grammarAccess.getXEqualityExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXExpressionRule() ||
				   context == grammarAccess.getXExpressionOrVarDeclarationRule() ||
				   context == grammarAccess.getXMemberFeatureCallRule() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXAssignmentAssignableAction_1_0_0_0_0() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXMemberFeatureCallMemberCallTargetAction_1_1_0_0_0() ||
				   context == grammarAccess.getXMultiplicativeExpressionRule() ||
				   context == grammarAccess.getXMultiplicativeExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXOrExpressionRule() ||
				   context == grammarAccess.getXOrExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXOtherOperatorExpressionRule() ||
				   context == grammarAccess.getXOtherOperatorExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXParenthesizedExpressionRule() ||
				   context == grammarAccess.getXPostfixOperationRule() ||
				   context == grammarAccess.getXPostfixOperationAccess().getXPostfixOperationOperandAction_1_0_0() ||
				   context == grammarAccess.getXPrimaryExpressionRule() ||
				   context == grammarAccess.getXRelationalExpressionRule() ||
				   context == grammarAccess.getXRelationalExpressionAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0() ||
				   context == grammarAccess.getXRelationalExpressionAccess().getXInstanceOfExpressionExpressionAction_1_0_0_0_0() ||
				   context == grammarAccess.getXUnaryOperationRule()) {
					sequence_XBasicForLoopExpression(context, (XBasicForLoopExpression) semanticObject); 
					return; 
				}
				else break;
			case XbasePackage.XBINARY_OPERATION:
				if(context == grammarAccess.getXAdditiveExpressionRule() ||
				   context == grammarAccess.getXAdditiveExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXAndExpressionRule() ||
				   context == grammarAccess.getXAndExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXAnnotationElementValueRule() ||
				   context == grammarAccess.getXAnnotationElementValueOrCommaListRule() ||
				   context == grammarAccess.getXAnnotationElementValueOrCommaListAccess().getXListLiteralElementsAction_1_1_0() ||
				   context == grammarAccess.getXAnnotationOrExpressionRule() ||
				   context == grammarAccess.getXAssignmentRule() ||
				   context == grammarAccess.getXAssignmentAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0() ||
				   context == grammarAccess.getXCastedExpressionRule() ||
				   context == grammarAccess.getXCastedExpressionAccess().getXCastedExpressionTargetAction_1_0_0_0() ||
				   context == grammarAccess.getXEqualityExpressionRule() ||
				   context == grammarAccess.getXEqualityExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXExpressionRule() ||
				   context == grammarAccess.getXExpressionOrVarDeclarationRule() ||
				   context == grammarAccess.getXMemberFeatureCallRule() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXAssignmentAssignableAction_1_0_0_0_0() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXMemberFeatureCallMemberCallTargetAction_1_1_0_0_0() ||
				   context == grammarAccess.getXMultiplicativeExpressionRule() ||
				   context == grammarAccess.getXMultiplicativeExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXOrExpressionRule() ||
				   context == grammarAccess.getXOrExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXOtherOperatorExpressionRule() ||
				   context == grammarAccess.getXOtherOperatorExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXParenthesizedExpressionRule() ||
				   context == grammarAccess.getXPostfixOperationRule() ||
				   context == grammarAccess.getXPostfixOperationAccess().getXPostfixOperationOperandAction_1_0_0() ||
				   context == grammarAccess.getXPrimaryExpressionRule() ||
				   context == grammarAccess.getXRelationalExpressionRule() ||
				   context == grammarAccess.getXRelationalExpressionAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0() ||
				   context == grammarAccess.getXRelationalExpressionAccess().getXInstanceOfExpressionExpressionAction_1_0_0_0_0() ||
				   context == grammarAccess.getXUnaryOperationRule()) {
					sequence_XAdditiveExpression_XAndExpression_XAssignment_XEqualityExpression_XMultiplicativeExpression_XOrExpression_XOtherOperatorExpression_XRelationalExpression(context, (XBinaryOperation) semanticObject); 
					return; 
				}
				else break;
			case XbasePackage.XBLOCK_EXPRESSION:
				if(context == grammarAccess.getXAdditiveExpressionRule() ||
				   context == grammarAccess.getXAdditiveExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXAndExpressionRule() ||
				   context == grammarAccess.getXAndExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXAnnotationElementValueRule() ||
				   context == grammarAccess.getXAnnotationElementValueOrCommaListRule() ||
				   context == grammarAccess.getXAnnotationElementValueOrCommaListAccess().getXListLiteralElementsAction_1_1_0() ||
				   context == grammarAccess.getXAnnotationOrExpressionRule() ||
				   context == grammarAccess.getXAssignmentRule() ||
				   context == grammarAccess.getXAssignmentAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0() ||
				   context == grammarAccess.getXBlockExpressionRule() ||
				   context == grammarAccess.getXCastedExpressionRule() ||
				   context == grammarAccess.getXCastedExpressionAccess().getXCastedExpressionTargetAction_1_0_0_0() ||
				   context == grammarAccess.getXEqualityExpressionRule() ||
				   context == grammarAccess.getXEqualityExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXExpressionRule() ||
				   context == grammarAccess.getXExpressionOrVarDeclarationRule() ||
				   context == grammarAccess.getXMemberFeatureCallRule() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXAssignmentAssignableAction_1_0_0_0_0() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXMemberFeatureCallMemberCallTargetAction_1_1_0_0_0() ||
				   context == grammarAccess.getXMultiplicativeExpressionRule() ||
				   context == grammarAccess.getXMultiplicativeExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXOrExpressionRule() ||
				   context == grammarAccess.getXOrExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXOtherOperatorExpressionRule() ||
				   context == grammarAccess.getXOtherOperatorExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXParenthesizedExpressionRule() ||
				   context == grammarAccess.getXPostfixOperationRule() ||
				   context == grammarAccess.getXPostfixOperationAccess().getXPostfixOperationOperandAction_1_0_0() ||
				   context == grammarAccess.getXPrimaryExpressionRule() ||
				   context == grammarAccess.getXRelationalExpressionRule() ||
				   context == grammarAccess.getXRelationalExpressionAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0() ||
				   context == grammarAccess.getXRelationalExpressionAccess().getXInstanceOfExpressionExpressionAction_1_0_0_0_0() ||
				   context == grammarAccess.getXUnaryOperationRule()) {
					sequence_XBlockExpression(context, (XBlockExpression) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getXExpressionInClosureRule()) {
					sequence_XExpressionInClosure(context, (XBlockExpression) semanticObject); 
					return; 
				}
				else break;
			case XbasePackage.XBOOLEAN_LITERAL:
				if(context == grammarAccess.getXAdditiveExpressionRule() ||
				   context == grammarAccess.getXAdditiveExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXAndExpressionRule() ||
				   context == grammarAccess.getXAndExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXAnnotationElementValueRule() ||
				   context == grammarAccess.getXAnnotationElementValueOrCommaListRule() ||
				   context == grammarAccess.getXAnnotationElementValueOrCommaListAccess().getXListLiteralElementsAction_1_1_0() ||
				   context == grammarAccess.getXAnnotationOrExpressionRule() ||
				   context == grammarAccess.getXAssignmentRule() ||
				   context == grammarAccess.getXAssignmentAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0() ||
				   context == grammarAccess.getXBooleanLiteralRule() ||
				   context == grammarAccess.getXCastedExpressionRule() ||
				   context == grammarAccess.getXCastedExpressionAccess().getXCastedExpressionTargetAction_1_0_0_0() ||
				   context == grammarAccess.getXEqualityExpressionRule() ||
				   context == grammarAccess.getXEqualityExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXExpressionRule() ||
				   context == grammarAccess.getXExpressionOrVarDeclarationRule() ||
				   context == grammarAccess.getXLiteralRule() ||
				   context == grammarAccess.getXMemberFeatureCallRule() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXAssignmentAssignableAction_1_0_0_0_0() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXMemberFeatureCallMemberCallTargetAction_1_1_0_0_0() ||
				   context == grammarAccess.getXMultiplicativeExpressionRule() ||
				   context == grammarAccess.getXMultiplicativeExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXOrExpressionRule() ||
				   context == grammarAccess.getXOrExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXOtherOperatorExpressionRule() ||
				   context == grammarAccess.getXOtherOperatorExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXParenthesizedExpressionRule() ||
				   context == grammarAccess.getXPostfixOperationRule() ||
				   context == grammarAccess.getXPostfixOperationAccess().getXPostfixOperationOperandAction_1_0_0() ||
				   context == grammarAccess.getXPrimaryExpressionRule() ||
				   context == grammarAccess.getXRelationalExpressionRule() ||
				   context == grammarAccess.getXRelationalExpressionAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0() ||
				   context == grammarAccess.getXRelationalExpressionAccess().getXInstanceOfExpressionExpressionAction_1_0_0_0_0() ||
				   context == grammarAccess.getXUnaryOperationRule()) {
					sequence_XBooleanLiteral(context, (XBooleanLiteral) semanticObject); 
					return; 
				}
				else break;
			case XbasePackage.XCASE_PART:
				if(context == grammarAccess.getXCasePartRule()) {
					sequence_XCasePart(context, (XCasePart) semanticObject); 
					return; 
				}
				else break;
			case XbasePackage.XCASTED_EXPRESSION:
				if(context == grammarAccess.getXAdditiveExpressionRule() ||
				   context == grammarAccess.getXAdditiveExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXAndExpressionRule() ||
				   context == grammarAccess.getXAndExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXAnnotationElementValueRule() ||
				   context == grammarAccess.getXAnnotationElementValueOrCommaListRule() ||
				   context == grammarAccess.getXAnnotationElementValueOrCommaListAccess().getXListLiteralElementsAction_1_1_0() ||
				   context == grammarAccess.getXAnnotationOrExpressionRule() ||
				   context == grammarAccess.getXAssignmentRule() ||
				   context == grammarAccess.getXAssignmentAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0() ||
				   context == grammarAccess.getXCastedExpressionRule() ||
				   context == grammarAccess.getXCastedExpressionAccess().getXCastedExpressionTargetAction_1_0_0_0() ||
				   context == grammarAccess.getXEqualityExpressionRule() ||
				   context == grammarAccess.getXEqualityExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXExpressionRule() ||
				   context == grammarAccess.getXExpressionOrVarDeclarationRule() ||
				   context == grammarAccess.getXMemberFeatureCallRule() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXAssignmentAssignableAction_1_0_0_0_0() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXMemberFeatureCallMemberCallTargetAction_1_1_0_0_0() ||
				   context == grammarAccess.getXMultiplicativeExpressionRule() ||
				   context == grammarAccess.getXMultiplicativeExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXOrExpressionRule() ||
				   context == grammarAccess.getXOrExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXOtherOperatorExpressionRule() ||
				   context == grammarAccess.getXOtherOperatorExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXParenthesizedExpressionRule() ||
				   context == grammarAccess.getXPostfixOperationRule() ||
				   context == grammarAccess.getXPostfixOperationAccess().getXPostfixOperationOperandAction_1_0_0() ||
				   context == grammarAccess.getXPrimaryExpressionRule() ||
				   context == grammarAccess.getXRelationalExpressionRule() ||
				   context == grammarAccess.getXRelationalExpressionAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0() ||
				   context == grammarAccess.getXRelationalExpressionAccess().getXInstanceOfExpressionExpressionAction_1_0_0_0_0() ||
				   context == grammarAccess.getXUnaryOperationRule()) {
					sequence_XCastedExpression(context, (XCastedExpression) semanticObject); 
					return; 
				}
				else break;
			case XbasePackage.XCATCH_CLAUSE:
				if(context == grammarAccess.getXCatchClauseRule()) {
					sequence_XCatchClause(context, (XCatchClause) semanticObject); 
					return; 
				}
				else break;
			case XbasePackage.XCLOSURE:
				if(context == grammarAccess.getXAdditiveExpressionRule() ||
				   context == grammarAccess.getXAdditiveExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXAndExpressionRule() ||
				   context == grammarAccess.getXAndExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXAnnotationElementValueRule() ||
				   context == grammarAccess.getXAnnotationElementValueOrCommaListRule() ||
				   context == grammarAccess.getXAnnotationElementValueOrCommaListAccess().getXListLiteralElementsAction_1_1_0() ||
				   context == grammarAccess.getXAnnotationOrExpressionRule() ||
				   context == grammarAccess.getXAssignmentRule() ||
				   context == grammarAccess.getXAssignmentAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0() ||
				   context == grammarAccess.getXCastedExpressionRule() ||
				   context == grammarAccess.getXCastedExpressionAccess().getXCastedExpressionTargetAction_1_0_0_0() ||
				   context == grammarAccess.getXClosureRule() ||
				   context == grammarAccess.getXEqualityExpressionRule() ||
				   context == grammarAccess.getXEqualityExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXExpressionRule() ||
				   context == grammarAccess.getXExpressionOrVarDeclarationRule() ||
				   context == grammarAccess.getXLiteralRule() ||
				   context == grammarAccess.getXMemberFeatureCallRule() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXAssignmentAssignableAction_1_0_0_0_0() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXMemberFeatureCallMemberCallTargetAction_1_1_0_0_0() ||
				   context == grammarAccess.getXMultiplicativeExpressionRule() ||
				   context == grammarAccess.getXMultiplicativeExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXOrExpressionRule() ||
				   context == grammarAccess.getXOrExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXOtherOperatorExpressionRule() ||
				   context == grammarAccess.getXOtherOperatorExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXParenthesizedExpressionRule() ||
				   context == grammarAccess.getXPostfixOperationRule() ||
				   context == grammarAccess.getXPostfixOperationAccess().getXPostfixOperationOperandAction_1_0_0() ||
				   context == grammarAccess.getXPrimaryExpressionRule() ||
				   context == grammarAccess.getXRelationalExpressionRule() ||
				   context == grammarAccess.getXRelationalExpressionAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0() ||
				   context == grammarAccess.getXRelationalExpressionAccess().getXInstanceOfExpressionExpressionAction_1_0_0_0_0() ||
				   context == grammarAccess.getXUnaryOperationRule()) {
					sequence_XClosure(context, (XClosure) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getXShortClosureRule()) {
					sequence_XShortClosure(context, (XClosure) semanticObject); 
					return; 
				}
				else break;
			case XbasePackage.XCONSTRUCTOR_CALL:
				if(context == grammarAccess.getXAdditiveExpressionRule() ||
				   context == grammarAccess.getXAdditiveExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXAndExpressionRule() ||
				   context == grammarAccess.getXAndExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXAnnotationElementValueRule() ||
				   context == grammarAccess.getXAnnotationElementValueOrCommaListRule() ||
				   context == grammarAccess.getXAnnotationElementValueOrCommaListAccess().getXListLiteralElementsAction_1_1_0() ||
				   context == grammarAccess.getXAnnotationOrExpressionRule() ||
				   context == grammarAccess.getXAssignmentRule() ||
				   context == grammarAccess.getXAssignmentAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0() ||
				   context == grammarAccess.getXCastedExpressionRule() ||
				   context == grammarAccess.getXCastedExpressionAccess().getXCastedExpressionTargetAction_1_0_0_0() ||
				   context == grammarAccess.getXConstructorCallRule() ||
				   context == grammarAccess.getXEqualityExpressionRule() ||
				   context == grammarAccess.getXEqualityExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXExpressionRule() ||
				   context == grammarAccess.getXExpressionOrVarDeclarationRule() ||
				   context == grammarAccess.getXMemberFeatureCallRule() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXAssignmentAssignableAction_1_0_0_0_0() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXMemberFeatureCallMemberCallTargetAction_1_1_0_0_0() ||
				   context == grammarAccess.getXMultiplicativeExpressionRule() ||
				   context == grammarAccess.getXMultiplicativeExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXOrExpressionRule() ||
				   context == grammarAccess.getXOrExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXOtherOperatorExpressionRule() ||
				   context == grammarAccess.getXOtherOperatorExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXParenthesizedExpressionRule() ||
				   context == grammarAccess.getXPostfixOperationRule() ||
				   context == grammarAccess.getXPostfixOperationAccess().getXPostfixOperationOperandAction_1_0_0() ||
				   context == grammarAccess.getXPrimaryExpressionRule() ||
				   context == grammarAccess.getXRelationalExpressionRule() ||
				   context == grammarAccess.getXRelationalExpressionAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0() ||
				   context == grammarAccess.getXRelationalExpressionAccess().getXInstanceOfExpressionExpressionAction_1_0_0_0_0() ||
				   context == grammarAccess.getXUnaryOperationRule()) {
					sequence_XConstructorCall(context, (XConstructorCall) semanticObject); 
					return; 
				}
				else break;
			case XbasePackage.XDO_WHILE_EXPRESSION:
				if(context == grammarAccess.getXAdditiveExpressionRule() ||
				   context == grammarAccess.getXAdditiveExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXAndExpressionRule() ||
				   context == grammarAccess.getXAndExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXAnnotationElementValueRule() ||
				   context == grammarAccess.getXAnnotationElementValueOrCommaListRule() ||
				   context == grammarAccess.getXAnnotationElementValueOrCommaListAccess().getXListLiteralElementsAction_1_1_0() ||
				   context == grammarAccess.getXAnnotationOrExpressionRule() ||
				   context == grammarAccess.getXAssignmentRule() ||
				   context == grammarAccess.getXAssignmentAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0() ||
				   context == grammarAccess.getXCastedExpressionRule() ||
				   context == grammarAccess.getXCastedExpressionAccess().getXCastedExpressionTargetAction_1_0_0_0() ||
				   context == grammarAccess.getXDoWhileExpressionRule() ||
				   context == grammarAccess.getXEqualityExpressionRule() ||
				   context == grammarAccess.getXEqualityExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXExpressionRule() ||
				   context == grammarAccess.getXExpressionOrVarDeclarationRule() ||
				   context == grammarAccess.getXMemberFeatureCallRule() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXAssignmentAssignableAction_1_0_0_0_0() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXMemberFeatureCallMemberCallTargetAction_1_1_0_0_0() ||
				   context == grammarAccess.getXMultiplicativeExpressionRule() ||
				   context == grammarAccess.getXMultiplicativeExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXOrExpressionRule() ||
				   context == grammarAccess.getXOrExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXOtherOperatorExpressionRule() ||
				   context == grammarAccess.getXOtherOperatorExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXParenthesizedExpressionRule() ||
				   context == grammarAccess.getXPostfixOperationRule() ||
				   context == grammarAccess.getXPostfixOperationAccess().getXPostfixOperationOperandAction_1_0_0() ||
				   context == grammarAccess.getXPrimaryExpressionRule() ||
				   context == grammarAccess.getXRelationalExpressionRule() ||
				   context == grammarAccess.getXRelationalExpressionAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0() ||
				   context == grammarAccess.getXRelationalExpressionAccess().getXInstanceOfExpressionExpressionAction_1_0_0_0_0() ||
				   context == grammarAccess.getXUnaryOperationRule()) {
					sequence_XDoWhileExpression(context, (XDoWhileExpression) semanticObject); 
					return; 
				}
				else break;
			case XbasePackage.XFEATURE_CALL:
				if(context == grammarAccess.getXAdditiveExpressionRule() ||
				   context == grammarAccess.getXAdditiveExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXAndExpressionRule() ||
				   context == grammarAccess.getXAndExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXAnnotationElementValueRule() ||
				   context == grammarAccess.getXAnnotationElementValueOrCommaListRule() ||
				   context == grammarAccess.getXAnnotationElementValueOrCommaListAccess().getXListLiteralElementsAction_1_1_0() ||
				   context == grammarAccess.getXAnnotationOrExpressionRule() ||
				   context == grammarAccess.getXAssignmentRule() ||
				   context == grammarAccess.getXAssignmentAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0() ||
				   context == grammarAccess.getXCastedExpressionRule() ||
				   context == grammarAccess.getXCastedExpressionAccess().getXCastedExpressionTargetAction_1_0_0_0() ||
				   context == grammarAccess.getXEqualityExpressionRule() ||
				   context == grammarAccess.getXEqualityExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXExpressionRule() ||
				   context == grammarAccess.getXExpressionOrVarDeclarationRule() ||
				   context == grammarAccess.getXFeatureCallRule() ||
				   context == grammarAccess.getXMemberFeatureCallRule() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXAssignmentAssignableAction_1_0_0_0_0() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXMemberFeatureCallMemberCallTargetAction_1_1_0_0_0() ||
				   context == grammarAccess.getXMultiplicativeExpressionRule() ||
				   context == grammarAccess.getXMultiplicativeExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXOrExpressionRule() ||
				   context == grammarAccess.getXOrExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXOtherOperatorExpressionRule() ||
				   context == grammarAccess.getXOtherOperatorExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXParenthesizedExpressionRule() ||
				   context == grammarAccess.getXPostfixOperationRule() ||
				   context == grammarAccess.getXPostfixOperationAccess().getXPostfixOperationOperandAction_1_0_0() ||
				   context == grammarAccess.getXPrimaryExpressionRule() ||
				   context == grammarAccess.getXRelationalExpressionRule() ||
				   context == grammarAccess.getXRelationalExpressionAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0() ||
				   context == grammarAccess.getXRelationalExpressionAccess().getXInstanceOfExpressionExpressionAction_1_0_0_0_0() ||
				   context == grammarAccess.getXUnaryOperationRule()) {
					sequence_XFeatureCall(context, (XFeatureCall) semanticObject); 
					return; 
				}
				else break;
			case XbasePackage.XFOR_LOOP_EXPRESSION:
				if(context == grammarAccess.getXAdditiveExpressionRule() ||
				   context == grammarAccess.getXAdditiveExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXAndExpressionRule() ||
				   context == grammarAccess.getXAndExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXAnnotationElementValueRule() ||
				   context == grammarAccess.getXAnnotationElementValueOrCommaListRule() ||
				   context == grammarAccess.getXAnnotationElementValueOrCommaListAccess().getXListLiteralElementsAction_1_1_0() ||
				   context == grammarAccess.getXAnnotationOrExpressionRule() ||
				   context == grammarAccess.getXAssignmentRule() ||
				   context == grammarAccess.getXAssignmentAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0() ||
				   context == grammarAccess.getXCastedExpressionRule() ||
				   context == grammarAccess.getXCastedExpressionAccess().getXCastedExpressionTargetAction_1_0_0_0() ||
				   context == grammarAccess.getXEqualityExpressionRule() ||
				   context == grammarAccess.getXEqualityExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXExpressionRule() ||
				   context == grammarAccess.getXExpressionOrVarDeclarationRule() ||
				   context == grammarAccess.getXForLoopExpressionRule() ||
				   context == grammarAccess.getXMemberFeatureCallRule() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXAssignmentAssignableAction_1_0_0_0_0() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXMemberFeatureCallMemberCallTargetAction_1_1_0_0_0() ||
				   context == grammarAccess.getXMultiplicativeExpressionRule() ||
				   context == grammarAccess.getXMultiplicativeExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXOrExpressionRule() ||
				   context == grammarAccess.getXOrExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXOtherOperatorExpressionRule() ||
				   context == grammarAccess.getXOtherOperatorExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXParenthesizedExpressionRule() ||
				   context == grammarAccess.getXPostfixOperationRule() ||
				   context == grammarAccess.getXPostfixOperationAccess().getXPostfixOperationOperandAction_1_0_0() ||
				   context == grammarAccess.getXPrimaryExpressionRule() ||
				   context == grammarAccess.getXRelationalExpressionRule() ||
				   context == grammarAccess.getXRelationalExpressionAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0() ||
				   context == grammarAccess.getXRelationalExpressionAccess().getXInstanceOfExpressionExpressionAction_1_0_0_0_0() ||
				   context == grammarAccess.getXUnaryOperationRule()) {
					sequence_XForLoopExpression(context, (XForLoopExpression) semanticObject); 
					return; 
				}
				else break;
			case XbasePackage.XIF_EXPRESSION:
				if(context == grammarAccess.getXAdditiveExpressionRule() ||
				   context == grammarAccess.getXAdditiveExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXAndExpressionRule() ||
				   context == grammarAccess.getXAndExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXAnnotationElementValueRule() ||
				   context == grammarAccess.getXAnnotationElementValueOrCommaListRule() ||
				   context == grammarAccess.getXAnnotationElementValueOrCommaListAccess().getXListLiteralElementsAction_1_1_0() ||
				   context == grammarAccess.getXAnnotationOrExpressionRule() ||
				   context == grammarAccess.getXAssignmentRule() ||
				   context == grammarAccess.getXAssignmentAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0() ||
				   context == grammarAccess.getXCastedExpressionRule() ||
				   context == grammarAccess.getXCastedExpressionAccess().getXCastedExpressionTargetAction_1_0_0_0() ||
				   context == grammarAccess.getXEqualityExpressionRule() ||
				   context == grammarAccess.getXEqualityExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXExpressionRule() ||
				   context == grammarAccess.getXExpressionOrVarDeclarationRule() ||
				   context == grammarAccess.getXIfExpressionRule() ||
				   context == grammarAccess.getXMemberFeatureCallRule() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXAssignmentAssignableAction_1_0_0_0_0() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXMemberFeatureCallMemberCallTargetAction_1_1_0_0_0() ||
				   context == grammarAccess.getXMultiplicativeExpressionRule() ||
				   context == grammarAccess.getXMultiplicativeExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXOrExpressionRule() ||
				   context == grammarAccess.getXOrExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXOtherOperatorExpressionRule() ||
				   context == grammarAccess.getXOtherOperatorExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXParenthesizedExpressionRule() ||
				   context == grammarAccess.getXPostfixOperationRule() ||
				   context == grammarAccess.getXPostfixOperationAccess().getXPostfixOperationOperandAction_1_0_0() ||
				   context == grammarAccess.getXPrimaryExpressionRule() ||
				   context == grammarAccess.getXRelationalExpressionRule() ||
				   context == grammarAccess.getXRelationalExpressionAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0() ||
				   context == grammarAccess.getXRelationalExpressionAccess().getXInstanceOfExpressionExpressionAction_1_0_0_0_0() ||
				   context == grammarAccess.getXUnaryOperationRule()) {
					sequence_XIfExpression(context, (XIfExpression) semanticObject); 
					return; 
				}
				else break;
			case XbasePackage.XINSTANCE_OF_EXPRESSION:
				if(context == grammarAccess.getXAdditiveExpressionRule() ||
				   context == grammarAccess.getXAdditiveExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXAndExpressionRule() ||
				   context == grammarAccess.getXAndExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXAnnotationElementValueRule() ||
				   context == grammarAccess.getXAnnotationElementValueOrCommaListRule() ||
				   context == grammarAccess.getXAnnotationElementValueOrCommaListAccess().getXListLiteralElementsAction_1_1_0() ||
				   context == grammarAccess.getXAnnotationOrExpressionRule() ||
				   context == grammarAccess.getXAssignmentRule() ||
				   context == grammarAccess.getXAssignmentAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0() ||
				   context == grammarAccess.getXCastedExpressionRule() ||
				   context == grammarAccess.getXCastedExpressionAccess().getXCastedExpressionTargetAction_1_0_0_0() ||
				   context == grammarAccess.getXEqualityExpressionRule() ||
				   context == grammarAccess.getXEqualityExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXExpressionRule() ||
				   context == grammarAccess.getXExpressionOrVarDeclarationRule() ||
				   context == grammarAccess.getXMemberFeatureCallRule() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXAssignmentAssignableAction_1_0_0_0_0() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXMemberFeatureCallMemberCallTargetAction_1_1_0_0_0() ||
				   context == grammarAccess.getXMultiplicativeExpressionRule() ||
				   context == grammarAccess.getXMultiplicativeExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXOrExpressionRule() ||
				   context == grammarAccess.getXOrExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXOtherOperatorExpressionRule() ||
				   context == grammarAccess.getXOtherOperatorExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXParenthesizedExpressionRule() ||
				   context == grammarAccess.getXPostfixOperationRule() ||
				   context == grammarAccess.getXPostfixOperationAccess().getXPostfixOperationOperandAction_1_0_0() ||
				   context == grammarAccess.getXPrimaryExpressionRule() ||
				   context == grammarAccess.getXRelationalExpressionRule() ||
				   context == grammarAccess.getXRelationalExpressionAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0() ||
				   context == grammarAccess.getXRelationalExpressionAccess().getXInstanceOfExpressionExpressionAction_1_0_0_0_0() ||
				   context == grammarAccess.getXUnaryOperationRule()) {
					sequence_XRelationalExpression(context, (XInstanceOfExpression) semanticObject); 
					return; 
				}
				else break;
			case XbasePackage.XLIST_LITERAL:
				if(context == grammarAccess.getXAnnotationElementValueOrCommaListRule()) {
					sequence_XAnnotationElementValueOrCommaList_XListLiteral(context, (XListLiteral) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getXAnnotationElementValueRule()) {
					sequence_XAnnotationElementValue_XListLiteral(context, (XListLiteral) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getXAdditiveExpressionRule() ||
				   context == grammarAccess.getXAdditiveExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXAndExpressionRule() ||
				   context == grammarAccess.getXAndExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXAnnotationElementValueOrCommaListAccess().getXListLiteralElementsAction_1_1_0() ||
				   context == grammarAccess.getXAnnotationOrExpressionRule() ||
				   context == grammarAccess.getXAssignmentRule() ||
				   context == grammarAccess.getXAssignmentAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0() ||
				   context == grammarAccess.getXCastedExpressionRule() ||
				   context == grammarAccess.getXCastedExpressionAccess().getXCastedExpressionTargetAction_1_0_0_0() ||
				   context == grammarAccess.getXCollectionLiteralRule() ||
				   context == grammarAccess.getXEqualityExpressionRule() ||
				   context == grammarAccess.getXEqualityExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXExpressionRule() ||
				   context == grammarAccess.getXExpressionOrVarDeclarationRule() ||
				   context == grammarAccess.getXListLiteralRule() ||
				   context == grammarAccess.getXLiteralRule() ||
				   context == grammarAccess.getXMemberFeatureCallRule() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXAssignmentAssignableAction_1_0_0_0_0() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXMemberFeatureCallMemberCallTargetAction_1_1_0_0_0() ||
				   context == grammarAccess.getXMultiplicativeExpressionRule() ||
				   context == grammarAccess.getXMultiplicativeExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXOrExpressionRule() ||
				   context == grammarAccess.getXOrExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXOtherOperatorExpressionRule() ||
				   context == grammarAccess.getXOtherOperatorExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXParenthesizedExpressionRule() ||
				   context == grammarAccess.getXPostfixOperationRule() ||
				   context == grammarAccess.getXPostfixOperationAccess().getXPostfixOperationOperandAction_1_0_0() ||
				   context == grammarAccess.getXPrimaryExpressionRule() ||
				   context == grammarAccess.getXRelationalExpressionRule() ||
				   context == grammarAccess.getXRelationalExpressionAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0() ||
				   context == grammarAccess.getXRelationalExpressionAccess().getXInstanceOfExpressionExpressionAction_1_0_0_0_0() ||
				   context == grammarAccess.getXUnaryOperationRule()) {
					sequence_XListLiteral(context, (XListLiteral) semanticObject); 
					return; 
				}
				else break;
			case XbasePackage.XMEMBER_FEATURE_CALL:
				if(context == grammarAccess.getXAdditiveExpressionRule() ||
				   context == grammarAccess.getXAdditiveExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXAndExpressionRule() ||
				   context == grammarAccess.getXAndExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXAnnotationElementValueRule() ||
				   context == grammarAccess.getXAnnotationElementValueOrCommaListRule() ||
				   context == grammarAccess.getXAnnotationElementValueOrCommaListAccess().getXListLiteralElementsAction_1_1_0() ||
				   context == grammarAccess.getXAnnotationOrExpressionRule() ||
				   context == grammarAccess.getXAssignmentRule() ||
				   context == grammarAccess.getXAssignmentAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0() ||
				   context == grammarAccess.getXCastedExpressionRule() ||
				   context == grammarAccess.getXCastedExpressionAccess().getXCastedExpressionTargetAction_1_0_0_0() ||
				   context == grammarAccess.getXEqualityExpressionRule() ||
				   context == grammarAccess.getXEqualityExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXExpressionRule() ||
				   context == grammarAccess.getXExpressionOrVarDeclarationRule() ||
				   context == grammarAccess.getXMemberFeatureCallRule() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXAssignmentAssignableAction_1_0_0_0_0() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXMemberFeatureCallMemberCallTargetAction_1_1_0_0_0() ||
				   context == grammarAccess.getXMultiplicativeExpressionRule() ||
				   context == grammarAccess.getXMultiplicativeExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXOrExpressionRule() ||
				   context == grammarAccess.getXOrExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXOtherOperatorExpressionRule() ||
				   context == grammarAccess.getXOtherOperatorExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXParenthesizedExpressionRule() ||
				   context == grammarAccess.getXPostfixOperationRule() ||
				   context == grammarAccess.getXPostfixOperationAccess().getXPostfixOperationOperandAction_1_0_0() ||
				   context == grammarAccess.getXPrimaryExpressionRule() ||
				   context == grammarAccess.getXRelationalExpressionRule() ||
				   context == grammarAccess.getXRelationalExpressionAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0() ||
				   context == grammarAccess.getXRelationalExpressionAccess().getXInstanceOfExpressionExpressionAction_1_0_0_0_0() ||
				   context == grammarAccess.getXUnaryOperationRule()) {
					sequence_XMemberFeatureCall(context, (XMemberFeatureCall) semanticObject); 
					return; 
				}
				else break;
			case XbasePackage.XNULL_LITERAL:
				if(context == grammarAccess.getXAdditiveExpressionRule() ||
				   context == grammarAccess.getXAdditiveExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXAndExpressionRule() ||
				   context == grammarAccess.getXAndExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXAnnotationElementValueRule() ||
				   context == grammarAccess.getXAnnotationElementValueOrCommaListRule() ||
				   context == grammarAccess.getXAnnotationElementValueOrCommaListAccess().getXListLiteralElementsAction_1_1_0() ||
				   context == grammarAccess.getXAnnotationOrExpressionRule() ||
				   context == grammarAccess.getXAssignmentRule() ||
				   context == grammarAccess.getXAssignmentAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0() ||
				   context == grammarAccess.getXCastedExpressionRule() ||
				   context == grammarAccess.getXCastedExpressionAccess().getXCastedExpressionTargetAction_1_0_0_0() ||
				   context == grammarAccess.getXEqualityExpressionRule() ||
				   context == grammarAccess.getXEqualityExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXExpressionRule() ||
				   context == grammarAccess.getXExpressionOrVarDeclarationRule() ||
				   context == grammarAccess.getXLiteralRule() ||
				   context == grammarAccess.getXMemberFeatureCallRule() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXAssignmentAssignableAction_1_0_0_0_0() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXMemberFeatureCallMemberCallTargetAction_1_1_0_0_0() ||
				   context == grammarAccess.getXMultiplicativeExpressionRule() ||
				   context == grammarAccess.getXMultiplicativeExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXNullLiteralRule() ||
				   context == grammarAccess.getXOrExpressionRule() ||
				   context == grammarAccess.getXOrExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXOtherOperatorExpressionRule() ||
				   context == grammarAccess.getXOtherOperatorExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXParenthesizedExpressionRule() ||
				   context == grammarAccess.getXPostfixOperationRule() ||
				   context == grammarAccess.getXPostfixOperationAccess().getXPostfixOperationOperandAction_1_0_0() ||
				   context == grammarAccess.getXPrimaryExpressionRule() ||
				   context == grammarAccess.getXRelationalExpressionRule() ||
				   context == grammarAccess.getXRelationalExpressionAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0() ||
				   context == grammarAccess.getXRelationalExpressionAccess().getXInstanceOfExpressionExpressionAction_1_0_0_0_0() ||
				   context == grammarAccess.getXUnaryOperationRule()) {
					sequence_XNullLiteral(context, (XNullLiteral) semanticObject); 
					return; 
				}
				else break;
			case XbasePackage.XNUMBER_LITERAL:
				if(context == grammarAccess.getXAdditiveExpressionRule() ||
				   context == grammarAccess.getXAdditiveExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXAndExpressionRule() ||
				   context == grammarAccess.getXAndExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXAnnotationElementValueRule() ||
				   context == grammarAccess.getXAnnotationElementValueOrCommaListRule() ||
				   context == grammarAccess.getXAnnotationElementValueOrCommaListAccess().getXListLiteralElementsAction_1_1_0() ||
				   context == grammarAccess.getXAnnotationOrExpressionRule() ||
				   context == grammarAccess.getXAssignmentRule() ||
				   context == grammarAccess.getXAssignmentAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0() ||
				   context == grammarAccess.getXCastedExpressionRule() ||
				   context == grammarAccess.getXCastedExpressionAccess().getXCastedExpressionTargetAction_1_0_0_0() ||
				   context == grammarAccess.getXEqualityExpressionRule() ||
				   context == grammarAccess.getXEqualityExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXExpressionRule() ||
				   context == grammarAccess.getXExpressionOrVarDeclarationRule() ||
				   context == grammarAccess.getXLiteralRule() ||
				   context == grammarAccess.getXMemberFeatureCallRule() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXAssignmentAssignableAction_1_0_0_0_0() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXMemberFeatureCallMemberCallTargetAction_1_1_0_0_0() ||
				   context == grammarAccess.getXMultiplicativeExpressionRule() ||
				   context == grammarAccess.getXMultiplicativeExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXNumberLiteralRule() ||
				   context == grammarAccess.getXOrExpressionRule() ||
				   context == grammarAccess.getXOrExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXOtherOperatorExpressionRule() ||
				   context == grammarAccess.getXOtherOperatorExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXParenthesizedExpressionRule() ||
				   context == grammarAccess.getXPostfixOperationRule() ||
				   context == grammarAccess.getXPostfixOperationAccess().getXPostfixOperationOperandAction_1_0_0() ||
				   context == grammarAccess.getXPrimaryExpressionRule() ||
				   context == grammarAccess.getXRelationalExpressionRule() ||
				   context == grammarAccess.getXRelationalExpressionAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0() ||
				   context == grammarAccess.getXRelationalExpressionAccess().getXInstanceOfExpressionExpressionAction_1_0_0_0_0() ||
				   context == grammarAccess.getXUnaryOperationRule()) {
					sequence_XNumberLiteral(context, (XNumberLiteral) semanticObject); 
					return; 
				}
				else break;
			case XbasePackage.XPOSTFIX_OPERATION:
				if(context == grammarAccess.getXAdditiveExpressionRule() ||
				   context == grammarAccess.getXAdditiveExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXAndExpressionRule() ||
				   context == grammarAccess.getXAndExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXAnnotationElementValueRule() ||
				   context == grammarAccess.getXAnnotationElementValueOrCommaListRule() ||
				   context == grammarAccess.getXAnnotationElementValueOrCommaListAccess().getXListLiteralElementsAction_1_1_0() ||
				   context == grammarAccess.getXAnnotationOrExpressionRule() ||
				   context == grammarAccess.getXAssignmentRule() ||
				   context == grammarAccess.getXAssignmentAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0() ||
				   context == grammarAccess.getXCastedExpressionRule() ||
				   context == grammarAccess.getXCastedExpressionAccess().getXCastedExpressionTargetAction_1_0_0_0() ||
				   context == grammarAccess.getXEqualityExpressionRule() ||
				   context == grammarAccess.getXEqualityExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXExpressionRule() ||
				   context == grammarAccess.getXExpressionOrVarDeclarationRule() ||
				   context == grammarAccess.getXMemberFeatureCallRule() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXAssignmentAssignableAction_1_0_0_0_0() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXMemberFeatureCallMemberCallTargetAction_1_1_0_0_0() ||
				   context == grammarAccess.getXMultiplicativeExpressionRule() ||
				   context == grammarAccess.getXMultiplicativeExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXOrExpressionRule() ||
				   context == grammarAccess.getXOrExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXOtherOperatorExpressionRule() ||
				   context == grammarAccess.getXOtherOperatorExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXParenthesizedExpressionRule() ||
				   context == grammarAccess.getXPostfixOperationRule() ||
				   context == grammarAccess.getXPostfixOperationAccess().getXPostfixOperationOperandAction_1_0_0() ||
				   context == grammarAccess.getXPrimaryExpressionRule() ||
				   context == grammarAccess.getXRelationalExpressionRule() ||
				   context == grammarAccess.getXRelationalExpressionAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0() ||
				   context == grammarAccess.getXRelationalExpressionAccess().getXInstanceOfExpressionExpressionAction_1_0_0_0_0() ||
				   context == grammarAccess.getXUnaryOperationRule()) {
					sequence_XPostfixOperation(context, (XPostfixOperation) semanticObject); 
					return; 
				}
				else break;
			case XbasePackage.XRETURN_EXPRESSION:
				if(context == grammarAccess.getXAdditiveExpressionRule() ||
				   context == grammarAccess.getXAdditiveExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXAndExpressionRule() ||
				   context == grammarAccess.getXAndExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXAnnotationElementValueRule() ||
				   context == grammarAccess.getXAnnotationElementValueOrCommaListRule() ||
				   context == grammarAccess.getXAnnotationElementValueOrCommaListAccess().getXListLiteralElementsAction_1_1_0() ||
				   context == grammarAccess.getXAnnotationOrExpressionRule() ||
				   context == grammarAccess.getXAssignmentRule() ||
				   context == grammarAccess.getXAssignmentAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0() ||
				   context == grammarAccess.getXCastedExpressionRule() ||
				   context == grammarAccess.getXCastedExpressionAccess().getXCastedExpressionTargetAction_1_0_0_0() ||
				   context == grammarAccess.getXEqualityExpressionRule() ||
				   context == grammarAccess.getXEqualityExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXExpressionRule() ||
				   context == grammarAccess.getXExpressionOrVarDeclarationRule() ||
				   context == grammarAccess.getXMemberFeatureCallRule() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXAssignmentAssignableAction_1_0_0_0_0() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXMemberFeatureCallMemberCallTargetAction_1_1_0_0_0() ||
				   context == grammarAccess.getXMultiplicativeExpressionRule() ||
				   context == grammarAccess.getXMultiplicativeExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXOrExpressionRule() ||
				   context == grammarAccess.getXOrExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXOtherOperatorExpressionRule() ||
				   context == grammarAccess.getXOtherOperatorExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXParenthesizedExpressionRule() ||
				   context == grammarAccess.getXPostfixOperationRule() ||
				   context == grammarAccess.getXPostfixOperationAccess().getXPostfixOperationOperandAction_1_0_0() ||
				   context == grammarAccess.getXPrimaryExpressionRule() ||
				   context == grammarAccess.getXRelationalExpressionRule() ||
				   context == grammarAccess.getXRelationalExpressionAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0() ||
				   context == grammarAccess.getXRelationalExpressionAccess().getXInstanceOfExpressionExpressionAction_1_0_0_0_0() ||
				   context == grammarAccess.getXReturnExpressionRule() ||
				   context == grammarAccess.getXUnaryOperationRule()) {
					sequence_XReturnExpression(context, (XReturnExpression) semanticObject); 
					return; 
				}
				else break;
			case XbasePackage.XSET_LITERAL:
				if(context == grammarAccess.getXAdditiveExpressionRule() ||
				   context == grammarAccess.getXAdditiveExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXAndExpressionRule() ||
				   context == grammarAccess.getXAndExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXAnnotationElementValueRule() ||
				   context == grammarAccess.getXAnnotationElementValueOrCommaListRule() ||
				   context == grammarAccess.getXAnnotationElementValueOrCommaListAccess().getXListLiteralElementsAction_1_1_0() ||
				   context == grammarAccess.getXAnnotationOrExpressionRule() ||
				   context == grammarAccess.getXAssignmentRule() ||
				   context == grammarAccess.getXAssignmentAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0() ||
				   context == grammarAccess.getXCastedExpressionRule() ||
				   context == grammarAccess.getXCastedExpressionAccess().getXCastedExpressionTargetAction_1_0_0_0() ||
				   context == grammarAccess.getXCollectionLiteralRule() ||
				   context == grammarAccess.getXEqualityExpressionRule() ||
				   context == grammarAccess.getXEqualityExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXExpressionRule() ||
				   context == grammarAccess.getXExpressionOrVarDeclarationRule() ||
				   context == grammarAccess.getXLiteralRule() ||
				   context == grammarAccess.getXMemberFeatureCallRule() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXAssignmentAssignableAction_1_0_0_0_0() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXMemberFeatureCallMemberCallTargetAction_1_1_0_0_0() ||
				   context == grammarAccess.getXMultiplicativeExpressionRule() ||
				   context == grammarAccess.getXMultiplicativeExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXOrExpressionRule() ||
				   context == grammarAccess.getXOrExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXOtherOperatorExpressionRule() ||
				   context == grammarAccess.getXOtherOperatorExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXParenthesizedExpressionRule() ||
				   context == grammarAccess.getXPostfixOperationRule() ||
				   context == grammarAccess.getXPostfixOperationAccess().getXPostfixOperationOperandAction_1_0_0() ||
				   context == grammarAccess.getXPrimaryExpressionRule() ||
				   context == grammarAccess.getXRelationalExpressionRule() ||
				   context == grammarAccess.getXRelationalExpressionAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0() ||
				   context == grammarAccess.getXRelationalExpressionAccess().getXInstanceOfExpressionExpressionAction_1_0_0_0_0() ||
				   context == grammarAccess.getXSetLiteralRule() ||
				   context == grammarAccess.getXUnaryOperationRule()) {
					sequence_XSetLiteral(context, (XSetLiteral) semanticObject); 
					return; 
				}
				else break;
			case XbasePackage.XSTRING_LITERAL:
				if(context == grammarAccess.getXAdditiveExpressionRule() ||
				   context == grammarAccess.getXAdditiveExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXAndExpressionRule() ||
				   context == grammarAccess.getXAndExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXAnnotationElementValueRule() ||
				   context == grammarAccess.getXAnnotationElementValueOrCommaListRule() ||
				   context == grammarAccess.getXAnnotationElementValueOrCommaListAccess().getXListLiteralElementsAction_1_1_0() ||
				   context == grammarAccess.getXAnnotationOrExpressionRule() ||
				   context == grammarAccess.getXAssignmentRule() ||
				   context == grammarAccess.getXAssignmentAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0() ||
				   context == grammarAccess.getXCastedExpressionRule() ||
				   context == grammarAccess.getXCastedExpressionAccess().getXCastedExpressionTargetAction_1_0_0_0() ||
				   context == grammarAccess.getXEqualityExpressionRule() ||
				   context == grammarAccess.getXEqualityExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXExpressionRule() ||
				   context == grammarAccess.getXExpressionOrVarDeclarationRule() ||
				   context == grammarAccess.getXLiteralRule() ||
				   context == grammarAccess.getXMemberFeatureCallRule() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXAssignmentAssignableAction_1_0_0_0_0() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXMemberFeatureCallMemberCallTargetAction_1_1_0_0_0() ||
				   context == grammarAccess.getXMultiplicativeExpressionRule() ||
				   context == grammarAccess.getXMultiplicativeExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXOrExpressionRule() ||
				   context == grammarAccess.getXOrExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXOtherOperatorExpressionRule() ||
				   context == grammarAccess.getXOtherOperatorExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXParenthesizedExpressionRule() ||
				   context == grammarAccess.getXPostfixOperationRule() ||
				   context == grammarAccess.getXPostfixOperationAccess().getXPostfixOperationOperandAction_1_0_0() ||
				   context == grammarAccess.getXPrimaryExpressionRule() ||
				   context == grammarAccess.getXRelationalExpressionRule() ||
				   context == grammarAccess.getXRelationalExpressionAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0() ||
				   context == grammarAccess.getXRelationalExpressionAccess().getXInstanceOfExpressionExpressionAction_1_0_0_0_0() ||
				   context == grammarAccess.getXStringLiteralRule() ||
				   context == grammarAccess.getXUnaryOperationRule()) {
					sequence_XStringLiteral(context, (XStringLiteral) semanticObject); 
					return; 
				}
				else break;
			case XbasePackage.XSWITCH_EXPRESSION:
				if(context == grammarAccess.getXAdditiveExpressionRule() ||
				   context == grammarAccess.getXAdditiveExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXAndExpressionRule() ||
				   context == grammarAccess.getXAndExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXAnnotationElementValueRule() ||
				   context == grammarAccess.getXAnnotationElementValueOrCommaListRule() ||
				   context == grammarAccess.getXAnnotationElementValueOrCommaListAccess().getXListLiteralElementsAction_1_1_0() ||
				   context == grammarAccess.getXAnnotationOrExpressionRule() ||
				   context == grammarAccess.getXAssignmentRule() ||
				   context == grammarAccess.getXAssignmentAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0() ||
				   context == grammarAccess.getXCastedExpressionRule() ||
				   context == grammarAccess.getXCastedExpressionAccess().getXCastedExpressionTargetAction_1_0_0_0() ||
				   context == grammarAccess.getXEqualityExpressionRule() ||
				   context == grammarAccess.getXEqualityExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXExpressionRule() ||
				   context == grammarAccess.getXExpressionOrVarDeclarationRule() ||
				   context == grammarAccess.getXMemberFeatureCallRule() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXAssignmentAssignableAction_1_0_0_0_0() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXMemberFeatureCallMemberCallTargetAction_1_1_0_0_0() ||
				   context == grammarAccess.getXMultiplicativeExpressionRule() ||
				   context == grammarAccess.getXMultiplicativeExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXOrExpressionRule() ||
				   context == grammarAccess.getXOrExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXOtherOperatorExpressionRule() ||
				   context == grammarAccess.getXOtherOperatorExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXParenthesizedExpressionRule() ||
				   context == grammarAccess.getXPostfixOperationRule() ||
				   context == grammarAccess.getXPostfixOperationAccess().getXPostfixOperationOperandAction_1_0_0() ||
				   context == grammarAccess.getXPrimaryExpressionRule() ||
				   context == grammarAccess.getXRelationalExpressionRule() ||
				   context == grammarAccess.getXRelationalExpressionAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0() ||
				   context == grammarAccess.getXRelationalExpressionAccess().getXInstanceOfExpressionExpressionAction_1_0_0_0_0() ||
				   context == grammarAccess.getXSwitchExpressionRule() ||
				   context == grammarAccess.getXUnaryOperationRule()) {
					sequence_XSwitchExpression(context, (XSwitchExpression) semanticObject); 
					return; 
				}
				else break;
			case XbasePackage.XSYNCHRONIZED_EXPRESSION:
				if(context == grammarAccess.getXAdditiveExpressionRule() ||
				   context == grammarAccess.getXAdditiveExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXAndExpressionRule() ||
				   context == grammarAccess.getXAndExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXAnnotationElementValueRule() ||
				   context == grammarAccess.getXAnnotationElementValueOrCommaListRule() ||
				   context == grammarAccess.getXAnnotationElementValueOrCommaListAccess().getXListLiteralElementsAction_1_1_0() ||
				   context == grammarAccess.getXAnnotationOrExpressionRule() ||
				   context == grammarAccess.getXAssignmentRule() ||
				   context == grammarAccess.getXAssignmentAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0() ||
				   context == grammarAccess.getXCastedExpressionRule() ||
				   context == grammarAccess.getXCastedExpressionAccess().getXCastedExpressionTargetAction_1_0_0_0() ||
				   context == grammarAccess.getXEqualityExpressionRule() ||
				   context == grammarAccess.getXEqualityExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXExpressionRule() ||
				   context == grammarAccess.getXExpressionOrVarDeclarationRule() ||
				   context == grammarAccess.getXMemberFeatureCallRule() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXAssignmentAssignableAction_1_0_0_0_0() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXMemberFeatureCallMemberCallTargetAction_1_1_0_0_0() ||
				   context == grammarAccess.getXMultiplicativeExpressionRule() ||
				   context == grammarAccess.getXMultiplicativeExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXOrExpressionRule() ||
				   context == grammarAccess.getXOrExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXOtherOperatorExpressionRule() ||
				   context == grammarAccess.getXOtherOperatorExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXParenthesizedExpressionRule() ||
				   context == grammarAccess.getXPostfixOperationRule() ||
				   context == grammarAccess.getXPostfixOperationAccess().getXPostfixOperationOperandAction_1_0_0() ||
				   context == grammarAccess.getXPrimaryExpressionRule() ||
				   context == grammarAccess.getXRelationalExpressionRule() ||
				   context == grammarAccess.getXRelationalExpressionAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0() ||
				   context == grammarAccess.getXRelationalExpressionAccess().getXInstanceOfExpressionExpressionAction_1_0_0_0_0() ||
				   context == grammarAccess.getXSynchronizedExpressionRule() ||
				   context == grammarAccess.getXUnaryOperationRule()) {
					sequence_XSynchronizedExpression(context, (XSynchronizedExpression) semanticObject); 
					return; 
				}
				else break;
			case XbasePackage.XTHROW_EXPRESSION:
				if(context == grammarAccess.getXAdditiveExpressionRule() ||
				   context == grammarAccess.getXAdditiveExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXAndExpressionRule() ||
				   context == grammarAccess.getXAndExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXAnnotationElementValueRule() ||
				   context == grammarAccess.getXAnnotationElementValueOrCommaListRule() ||
				   context == grammarAccess.getXAnnotationElementValueOrCommaListAccess().getXListLiteralElementsAction_1_1_0() ||
				   context == grammarAccess.getXAnnotationOrExpressionRule() ||
				   context == grammarAccess.getXAssignmentRule() ||
				   context == grammarAccess.getXAssignmentAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0() ||
				   context == grammarAccess.getXCastedExpressionRule() ||
				   context == grammarAccess.getXCastedExpressionAccess().getXCastedExpressionTargetAction_1_0_0_0() ||
				   context == grammarAccess.getXEqualityExpressionRule() ||
				   context == grammarAccess.getXEqualityExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXExpressionRule() ||
				   context == grammarAccess.getXExpressionOrVarDeclarationRule() ||
				   context == grammarAccess.getXMemberFeatureCallRule() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXAssignmentAssignableAction_1_0_0_0_0() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXMemberFeatureCallMemberCallTargetAction_1_1_0_0_0() ||
				   context == grammarAccess.getXMultiplicativeExpressionRule() ||
				   context == grammarAccess.getXMultiplicativeExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXOrExpressionRule() ||
				   context == grammarAccess.getXOrExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXOtherOperatorExpressionRule() ||
				   context == grammarAccess.getXOtherOperatorExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXParenthesizedExpressionRule() ||
				   context == grammarAccess.getXPostfixOperationRule() ||
				   context == grammarAccess.getXPostfixOperationAccess().getXPostfixOperationOperandAction_1_0_0() ||
				   context == grammarAccess.getXPrimaryExpressionRule() ||
				   context == grammarAccess.getXRelationalExpressionRule() ||
				   context == grammarAccess.getXRelationalExpressionAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0() ||
				   context == grammarAccess.getXRelationalExpressionAccess().getXInstanceOfExpressionExpressionAction_1_0_0_0_0() ||
				   context == grammarAccess.getXThrowExpressionRule() ||
				   context == grammarAccess.getXUnaryOperationRule()) {
					sequence_XThrowExpression(context, (XThrowExpression) semanticObject); 
					return; 
				}
				else break;
			case XbasePackage.XTRY_CATCH_FINALLY_EXPRESSION:
				if(context == grammarAccess.getXAdditiveExpressionRule() ||
				   context == grammarAccess.getXAdditiveExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXAndExpressionRule() ||
				   context == grammarAccess.getXAndExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXAnnotationElementValueRule() ||
				   context == grammarAccess.getXAnnotationElementValueOrCommaListRule() ||
				   context == grammarAccess.getXAnnotationElementValueOrCommaListAccess().getXListLiteralElementsAction_1_1_0() ||
				   context == grammarAccess.getXAnnotationOrExpressionRule() ||
				   context == grammarAccess.getXAssignmentRule() ||
				   context == grammarAccess.getXAssignmentAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0() ||
				   context == grammarAccess.getXCastedExpressionRule() ||
				   context == grammarAccess.getXCastedExpressionAccess().getXCastedExpressionTargetAction_1_0_0_0() ||
				   context == grammarAccess.getXEqualityExpressionRule() ||
				   context == grammarAccess.getXEqualityExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXExpressionRule() ||
				   context == grammarAccess.getXExpressionOrVarDeclarationRule() ||
				   context == grammarAccess.getXMemberFeatureCallRule() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXAssignmentAssignableAction_1_0_0_0_0() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXMemberFeatureCallMemberCallTargetAction_1_1_0_0_0() ||
				   context == grammarAccess.getXMultiplicativeExpressionRule() ||
				   context == grammarAccess.getXMultiplicativeExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXOrExpressionRule() ||
				   context == grammarAccess.getXOrExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXOtherOperatorExpressionRule() ||
				   context == grammarAccess.getXOtherOperatorExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXParenthesizedExpressionRule() ||
				   context == grammarAccess.getXPostfixOperationRule() ||
				   context == grammarAccess.getXPostfixOperationAccess().getXPostfixOperationOperandAction_1_0_0() ||
				   context == grammarAccess.getXPrimaryExpressionRule() ||
				   context == grammarAccess.getXRelationalExpressionRule() ||
				   context == grammarAccess.getXRelationalExpressionAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0() ||
				   context == grammarAccess.getXRelationalExpressionAccess().getXInstanceOfExpressionExpressionAction_1_0_0_0_0() ||
				   context == grammarAccess.getXTryCatchFinallyExpressionRule() ||
				   context == grammarAccess.getXUnaryOperationRule()) {
					sequence_XTryCatchFinallyExpression(context, (XTryCatchFinallyExpression) semanticObject); 
					return; 
				}
				else break;
			case XbasePackage.XTYPE_LITERAL:
				if(context == grammarAccess.getXAdditiveExpressionRule() ||
				   context == grammarAccess.getXAdditiveExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXAndExpressionRule() ||
				   context == grammarAccess.getXAndExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXAnnotationElementValueRule() ||
				   context == grammarAccess.getXAnnotationElementValueOrCommaListRule() ||
				   context == grammarAccess.getXAnnotationElementValueOrCommaListAccess().getXListLiteralElementsAction_1_1_0() ||
				   context == grammarAccess.getXAnnotationOrExpressionRule() ||
				   context == grammarAccess.getXAssignmentRule() ||
				   context == grammarAccess.getXAssignmentAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0() ||
				   context == grammarAccess.getXCastedExpressionRule() ||
				   context == grammarAccess.getXCastedExpressionAccess().getXCastedExpressionTargetAction_1_0_0_0() ||
				   context == grammarAccess.getXEqualityExpressionRule() ||
				   context == grammarAccess.getXEqualityExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXExpressionRule() ||
				   context == grammarAccess.getXExpressionOrVarDeclarationRule() ||
				   context == grammarAccess.getXLiteralRule() ||
				   context == grammarAccess.getXMemberFeatureCallRule() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXAssignmentAssignableAction_1_0_0_0_0() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXMemberFeatureCallMemberCallTargetAction_1_1_0_0_0() ||
				   context == grammarAccess.getXMultiplicativeExpressionRule() ||
				   context == grammarAccess.getXMultiplicativeExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXOrExpressionRule() ||
				   context == grammarAccess.getXOrExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXOtherOperatorExpressionRule() ||
				   context == grammarAccess.getXOtherOperatorExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXParenthesizedExpressionRule() ||
				   context == grammarAccess.getXPostfixOperationRule() ||
				   context == grammarAccess.getXPostfixOperationAccess().getXPostfixOperationOperandAction_1_0_0() ||
				   context == grammarAccess.getXPrimaryExpressionRule() ||
				   context == grammarAccess.getXRelationalExpressionRule() ||
				   context == grammarAccess.getXRelationalExpressionAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0() ||
				   context == grammarAccess.getXRelationalExpressionAccess().getXInstanceOfExpressionExpressionAction_1_0_0_0_0() ||
				   context == grammarAccess.getXTypeLiteralRule() ||
				   context == grammarAccess.getXUnaryOperationRule()) {
					sequence_XTypeLiteral(context, (XTypeLiteral) semanticObject); 
					return; 
				}
				else break;
			case XbasePackage.XUNARY_OPERATION:
				if(context == grammarAccess.getXAdditiveExpressionRule() ||
				   context == grammarAccess.getXAdditiveExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXAndExpressionRule() ||
				   context == grammarAccess.getXAndExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXAnnotationElementValueRule() ||
				   context == grammarAccess.getXAnnotationElementValueOrCommaListRule() ||
				   context == grammarAccess.getXAnnotationElementValueOrCommaListAccess().getXListLiteralElementsAction_1_1_0() ||
				   context == grammarAccess.getXAnnotationOrExpressionRule() ||
				   context == grammarAccess.getXAssignmentRule() ||
				   context == grammarAccess.getXAssignmentAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0() ||
				   context == grammarAccess.getXCastedExpressionRule() ||
				   context == grammarAccess.getXCastedExpressionAccess().getXCastedExpressionTargetAction_1_0_0_0() ||
				   context == grammarAccess.getXEqualityExpressionRule() ||
				   context == grammarAccess.getXEqualityExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXExpressionRule() ||
				   context == grammarAccess.getXExpressionOrVarDeclarationRule() ||
				   context == grammarAccess.getXMemberFeatureCallRule() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXAssignmentAssignableAction_1_0_0_0_0() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXMemberFeatureCallMemberCallTargetAction_1_1_0_0_0() ||
				   context == grammarAccess.getXMultiplicativeExpressionRule() ||
				   context == grammarAccess.getXMultiplicativeExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXOrExpressionRule() ||
				   context == grammarAccess.getXOrExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXOtherOperatorExpressionRule() ||
				   context == grammarAccess.getXOtherOperatorExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXParenthesizedExpressionRule() ||
				   context == grammarAccess.getXPostfixOperationRule() ||
				   context == grammarAccess.getXPostfixOperationAccess().getXPostfixOperationOperandAction_1_0_0() ||
				   context == grammarAccess.getXPrimaryExpressionRule() ||
				   context == grammarAccess.getXRelationalExpressionRule() ||
				   context == grammarAccess.getXRelationalExpressionAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0() ||
				   context == grammarAccess.getXRelationalExpressionAccess().getXInstanceOfExpressionExpressionAction_1_0_0_0_0() ||
				   context == grammarAccess.getXUnaryOperationRule()) {
					sequence_XUnaryOperation(context, (XUnaryOperation) semanticObject); 
					return; 
				}
				else break;
			case XbasePackage.XVARIABLE_DECLARATION:
				if(context == grammarAccess.getXExpressionOrVarDeclarationRule() ||
				   context == grammarAccess.getXVariableDeclarationRule()) {
					sequence_XVariableDeclaration(context, (XVariableDeclaration) semanticObject); 
					return; 
				}
				else break;
			case XbasePackage.XWHILE_EXPRESSION:
				if(context == grammarAccess.getXAdditiveExpressionRule() ||
				   context == grammarAccess.getXAdditiveExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXAndExpressionRule() ||
				   context == grammarAccess.getXAndExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXAnnotationElementValueRule() ||
				   context == grammarAccess.getXAnnotationElementValueOrCommaListRule() ||
				   context == grammarAccess.getXAnnotationElementValueOrCommaListAccess().getXListLiteralElementsAction_1_1_0() ||
				   context == grammarAccess.getXAnnotationOrExpressionRule() ||
				   context == grammarAccess.getXAssignmentRule() ||
				   context == grammarAccess.getXAssignmentAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0() ||
				   context == grammarAccess.getXCastedExpressionRule() ||
				   context == grammarAccess.getXCastedExpressionAccess().getXCastedExpressionTargetAction_1_0_0_0() ||
				   context == grammarAccess.getXEqualityExpressionRule() ||
				   context == grammarAccess.getXEqualityExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXExpressionRule() ||
				   context == grammarAccess.getXExpressionOrVarDeclarationRule() ||
				   context == grammarAccess.getXMemberFeatureCallRule() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXAssignmentAssignableAction_1_0_0_0_0() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXMemberFeatureCallMemberCallTargetAction_1_1_0_0_0() ||
				   context == grammarAccess.getXMultiplicativeExpressionRule() ||
				   context == grammarAccess.getXMultiplicativeExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXOrExpressionRule() ||
				   context == grammarAccess.getXOrExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXOtherOperatorExpressionRule() ||
				   context == grammarAccess.getXOtherOperatorExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXParenthesizedExpressionRule() ||
				   context == grammarAccess.getXPostfixOperationRule() ||
				   context == grammarAccess.getXPostfixOperationAccess().getXPostfixOperationOperandAction_1_0_0() ||
				   context == grammarAccess.getXPrimaryExpressionRule() ||
				   context == grammarAccess.getXRelationalExpressionRule() ||
				   context == grammarAccess.getXRelationalExpressionAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0() ||
				   context == grammarAccess.getXRelationalExpressionAccess().getXInstanceOfExpressionExpressionAction_1_0_0_0_0() ||
				   context == grammarAccess.getXUnaryOperationRule() ||
				   context == grammarAccess.getXWhileExpressionRule()) {
					sequence_XWhileExpression(context, (XWhileExpression) semanticObject); 
					return; 
				}
				else break;
			}
		else if(semanticObject.eClass().getEPackage() == XtypePackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case XtypePackage.XFUNCTION_TYPE_REF:
				if(context == grammarAccess.getJvmArgumentTypeReferenceRule() ||
				   context == grammarAccess.getJvmTypeReferenceRule() ||
				   context == grammarAccess.getXFunctionTypeRefRule()) {
					sequence_XFunctionTypeRef(context, (XFunctionTypeRef) semanticObject); 
					return; 
				}
				else break;
			case XtypePackage.XIMPORT_DECLARATION:
				if(context == grammarAccess.getXImportDeclarationRule()) {
					sequence_XImportDeclaration(context, (XImportDeclaration) semanticObject); 
					return; 
				}
				else break;
			case XtypePackage.XIMPORT_SECTION:
				if(context == grammarAccess.getXImportSectionRule()) {
					sequence_XImportSection(context, (XImportSection) semanticObject); 
					return; 
				}
				else break;
			}
		if (errorAcceptor != null) errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Constraint:
	 *     (annotations+=Annotation* entity=Entity)
	 */
	protected void sequence_AnnotatedEntity(EObject context, AnnotatedEntity semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     {AnnotationDirectiveAttribute}
	 */
	protected void sequence_AnnotationDirective(EObject context, AnnotationDirectiveAttribute semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     {AnnotationDirectiveConflict}
	 */
	protected void sequence_AnnotationDirective(EObject context, AnnotationDirectiveConflict semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     {AnnotationDirectiveConstructor}
	 */
	protected void sequence_AnnotationDirective(EObject context, AnnotationDirectiveConstructor semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     {AnnotationDirectiveGetter}
	 */
	protected void sequence_AnnotationDirective(EObject context, AnnotationDirectiveGetter semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     {AnnotationDirectiveSetter}
	 */
	protected void sequence_AnnotationDirective(EObject context, AnnotationDirectiveSetter semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     {AnnotationDirectiveStandard}
	 */
	protected void sequence_AnnotationDirective(EObject context, AnnotationDirectiveStandard semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     {AnnotationDirectiveStatic}
	 */
	protected void sequence_AnnotationDirective(EObject context, AnnotationDirectiveStatic semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (directives+=AnnotationDirective* annotation=XAnnotation)
	 */
	protected void sequence_Annotation(EObject context, Annotation semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         (
	 *             properties+=Property | 
	 *             pojos+=PojoDefinition | 
	 *             tables+=TableDefinition | 
	 *             procedures+=ProcedureDefinition | 
	 *             functions+=FunctionDefinition | 
	 *             packages+=Package
	 *         )*
	 *     )
	 */
	protected void sequence_Artifacts(EObject context, Artifacts semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (dbColumn=ValidID newName=ValidID)
	 */
	protected void sequence_ColumnAssignement(EObject context, ColumnAssignement semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, ProcessorModelPackage.Literals.COLUMN_ASSIGNEMENT__DB_COLUMN) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ProcessorModelPackage.Literals.COLUMN_ASSIGNEMENT__DB_COLUMN));
			if(transientValues.isValueTransient(semanticObject, ProcessorModelPackage.Literals.COLUMN_ASSIGNEMENT__NEW_NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ProcessorModelPackage.Literals.COLUMN_ASSIGNEMENT__NEW_NAME));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getColumnAssignementAccess().getDbColumnValidIDParserRuleCall_0_0(), semanticObject.getDbColumn());
		feeder.accept(grammarAccess.getColumnAssignementAccess().getNewNameValidIDParserRuleCall_2_0(), semanticObject.getNewName());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (dbColumn=ValidID type=JvmParameterizedTypeReference)
	 */
	protected void sequence_ColumnTypeAssignement(EObject context, ColumnTypeAssignement semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, ProcessorModelPackage.Literals.COLUMN_TYPE_ASSIGNEMENT__DB_COLUMN) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ProcessorModelPackage.Literals.COLUMN_TYPE_ASSIGNEMENT__DB_COLUMN));
			if(transientValues.isValueTransient(semanticObject, ProcessorModelPackage.Literals.COLUMN_TYPE_ASSIGNEMENT__TYPE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ProcessorModelPackage.Literals.COLUMN_TYPE_ASSIGNEMENT__TYPE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getColumnTypeAssignementAccess().getDbColumnValidIDParserRuleCall_0_0(), semanticObject.getDbColumn());
		feeder.accept(grammarAccess.getColumnTypeAssignementAccess().getTypeJvmParameterizedTypeReferenceParserRuleCall_3_0(), semanticObject.getType());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (out=JvmParameterizedTypeReference ins+=JvmParameterizedTypeReference*)
	 */
	protected void sequence_DaoDirectiveParameters(EObject context, DaoDirectiveParameters semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (pojo=[PojoEntity|ValidID]?)
	 */
	protected void sequence_DaoDirective(EObject context, DaoDirectiveCrud semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (ancestor=[PojoAttribute|ValidID] descendants+=DescendantAssignment+)
	 */
	protected void sequence_DaoDirective(EObject context, DaoDirectiveDiscriminator semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     pojo=[PojoEntity|ValidID]
	 */
	protected void sequence_DaoDirective(EObject context, DaoDirectivePojo semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, ProcessorModelPackage.Literals.DAO_DIRECTIVE_POJO__POJO) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ProcessorModelPackage.Literals.DAO_DIRECTIVE_POJO__POJO));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getDaoDirectiveAccess().getPojoPojoEntityValidIDParserRuleCall_5_2_1_0_1(), semanticObject.getPojo());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (pojo=[PojoEntity|ValidID]?)
	 */
	protected void sequence_DaoDirective(EObject context, DaoDirectiveQuery semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     sernum=INT
	 */
	protected void sequence_DaoDirective(EObject context, DaoDirectiveSerializable semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, ProcessorModelPackage.Literals.DAO_DIRECTIVE_SERIALIZABLE__SERNUM) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ProcessorModelPackage.Literals.DAO_DIRECTIVE_SERIALIZABLE__SERNUM));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getDaoDirectiveAccess().getSernumINTTerminalRuleCall_0_3_0(), semanticObject.getSernum());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (type=FunProcType paramlist=DaoDirectiveParameters?)
	 */
	protected void sequence_DaoDirective(EObject context, DaoFunProcDirective semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         directives+=DaoDirective* 
	 *         final?='final'? 
	 *         abstract?='abstract'? 
	 *         name=ValidID 
	 *         superType=JvmParameterizedTypeReference? 
	 *         attributes+=PojoAttribute* 
	 *         procedures+=PojoProcedure*
	 *     )
	 */
	protected void sequence_DaoEntity(EObject context, DaoEntity semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         (name='ignore-tables' dbTables+=ValidID+) | 
	 *         (name='only-tables' dbTables+=ValidID*) | 
	 *         (name='implements-interfaces' toImplements=ImplementsAssignement) | 
	 *         (name='extends-class' toExtends=ExtendsAssignement) | 
	 *         (name='implements-interfaces-generics' toImplementsGenerics=ImplementsAssignementGenerics) | 
	 *         (name='extends-class-generics' toExtendsGenerics=ExtendsAssignementGenerics) | 
	 *         name='make-it-final' | 
	 *         (name='function-result' dbFunction=ValidID resultType=JvmParameterizedTypeReference) | 
	 *         (name='debug-level' debug=DebugLevelAssignement) | 
	 *         (name='active-filter' activeFilter=ValueType) | 
	 *         (name='package' pckg=QualifiedName)
	 *     )
	 */
	protected void sequence_DaogenProperty(EObject context, DaogenProperty semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     dbCatalog=QualifiedName
	 */
	protected void sequence_DatabaseCatalogAssignement(EObject context, DatabaseCatalogAssignement semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, ProcessorModelPackage.Literals.DATABASE_CATALOG_ASSIGNEMENT__DB_CATALOG) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ProcessorModelPackage.Literals.DATABASE_CATALOG_ASSIGNEMENT__DB_CATALOG));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getDatabaseCatalogAssignementAccess().getDbCatalogQualifiedNameParserRuleCall_0(), semanticObject.getDbCatalog());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     dbMetaInfo=ValueType
	 */
	protected void sequence_DatabaseMetaInfoAssignement(EObject context, DatabaseMetaInfoAssignement semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, ProcessorModelPackage.Literals.DATABASE_META_INFO_ASSIGNEMENT__DB_META_INFO) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ProcessorModelPackage.Literals.DATABASE_META_INFO_ASSIGNEMENT__DB_META_INFO));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getDatabaseMetaInfoAssignementAccess().getDbMetaInfoValueTypeParserRuleCall_0(), semanticObject.getDbMetaInfo());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         name='is-online' | 
	 *         name='is-offline' | 
	 *         (name='has-url' dbUrl=ValueType) | 
	 *         (name='login-username' dbUsername=ValueType) | 
	 *         (name='login-password' dbPassword=ValueType) | 
	 *         (name='in-catalog' dbCatalog=DatabaseCatalogAssignement) | 
	 *         (name='active-schema' dbSchema=DatabaseSchemaAssignement) | 
	 *         (name='jdbc-driver' (dbDriverx=JvmParameterizedTypeReference | dbDriver=ValueType)) | 
	 *         (name='ddl-create' dbExecuteBefore=ValueType) | 
	 *         (name='ddl-drop' dbExecuteAfter=ValueType) | 
	 *         (name='index-types' dbIndexTypes=ValueType) | 
	 *         name='skip-indexes' | 
	 *         name='skip-functions-procedures' | 
	 *         name='skip-check-constraints' | 
	 *         (name='is-of-type' dbType=DatabaseTypeAssignement) | 
	 *         (name='show-database-info' dbMetaInfo=DatabaseMetaInfoAssignement) | 
	 *         (name='show-driver-info' dbDriverInfo=DriverMetaInfoAssignement) | 
	 *         (name='show-driver-output' dbMethodsCalls+=DriverMethodOutputAssignement+) | 
	 *         (name='debug-level' debug=DebugLevelAssignement) | 
	 *         name='take-comments' | 
	 *         name='lowercase-names' | 
	 *         name='uppercase-names'
	 *     )
	 */
	protected void sequence_DatabaseProperty(EObject context, DatabaseProperty semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     dbSchema=QualifiedName
	 */
	protected void sequence_DatabaseSchemaAssignement(EObject context, DatabaseSchemaAssignement semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, ProcessorModelPackage.Literals.DATABASE_SCHEMA_ASSIGNEMENT__DB_SCHEMA) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ProcessorModelPackage.Literals.DATABASE_SCHEMA_ASSIGNEMENT__DB_SCHEMA));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getDatabaseSchemaAssignementAccess().getDbSchemaQualifiedNameParserRuleCall_0(), semanticObject.getDbSchema());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     dbType=ValidID
	 */
	protected void sequence_DatabaseTypeAssignement(EObject context, DatabaseTypeAssignement semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, ProcessorModelPackage.Literals.DATABASE_TYPE_ASSIGNEMENT__DB_TYPE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ProcessorModelPackage.Literals.DATABASE_TYPE_ASSIGNEMENT__DB_TYPE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getDatabaseTypeAssignementAccess().getDbTypeValidIDParserRuleCall_0(), semanticObject.getDbType());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (debug=ValidID scope=ValidID?)
	 */
	protected void sequence_DebugLevelAssignement(EObject context, DebugLevelAssignement semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (value=ValueType descendant=JvmParameterizedTypeReference)
	 */
	protected void sequence_DescendantAssignment(EObject context, DescendantAssignment semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, ProcessorModelPackage.Literals.DESCENDANT_ASSIGNMENT__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ProcessorModelPackage.Literals.DESCENDANT_ASSIGNMENT__VALUE));
			if(transientValues.isValueTransient(semanticObject, ProcessorModelPackage.Literals.DESCENDANT_ASSIGNMENT__DESCENDANT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ProcessorModelPackage.Literals.DESCENDANT_ASSIGNMENT__DESCENDANT));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getDescendantAssignmentAccess().getValueValueTypeParserRuleCall_0_0(), semanticObject.getValue());
		feeder.accept(grammarAccess.getDescendantAssignmentAccess().getDescendantJvmParameterizedTypeReferenceParserRuleCall_2_0(), semanticObject.getDescendant());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (features+=[PojoAttribute|ValidID] features+=[PojoAttribute|ValidID]*)
	 */
	protected void sequence_DirectiveProperties(EObject context, DirectiveProperties semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     dbDriverInfo=ValueType
	 */
	protected void sequence_DriverMetaInfoAssignement(EObject context, DriverMetaInfoAssignement semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, ProcessorModelPackage.Literals.DRIVER_META_INFO_ASSIGNEMENT__DB_DRIVER_INFO) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ProcessorModelPackage.Literals.DRIVER_META_INFO_ASSIGNEMENT__DB_DRIVER_INFO));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getDriverMetaInfoAssignementAccess().getDbDriverInfoValueTypeParserRuleCall_0(), semanticObject.getDbDriverInfo());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (driverMethod=ValidID callOutput=ValueType)
	 */
	protected void sequence_DriverMethodOutputAssignement(EObject context, DriverMethodOutputAssignement semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, ProcessorModelPackage.Literals.DRIVER_METHOD_OUTPUT_ASSIGNEMENT__DRIVER_METHOD) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ProcessorModelPackage.Literals.DRIVER_METHOD_OUTPUT_ASSIGNEMENT__DRIVER_METHOD));
			if(transientValues.isValueTransient(semanticObject, ProcessorModelPackage.Literals.DRIVER_METHOD_OUTPUT_ASSIGNEMENT__CALL_OUTPUT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ProcessorModelPackage.Literals.DRIVER_METHOD_OUTPUT_ASSIGNEMENT__CALL_OUTPUT));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getDriverMethodOutputAssignementAccess().getDriverMethodValidIDParserRuleCall_0_0(), semanticObject.getDriverMethod());
		feeder.accept(grammarAccess.getDriverMethodOutputAssignementAccess().getCallOutputValueTypeParserRuleCall_2_0(), semanticObject.getCallOutput());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (values+=EnumAttributeValue values+=EnumAttributeValue*)
	 */
	protected void sequence_EnumAttributeDirective(EObject context, EnumAttributeDirectiveValues semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=ValidID value=XExpression)
	 */
	protected void sequence_EnumAttributeValue(EObject context, EnumAttributeValue semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, ProcessorModelPackage.Literals.ENUM_ATTRIBUTE_VALUE__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ProcessorModelPackage.Literals.ENUM_ATTRIBUTE_VALUE__NAME));
			if(transientValues.isValueTransient(semanticObject, ProcessorModelPackage.Literals.ENUM_ATTRIBUTE_VALUE__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ProcessorModelPackage.Literals.ENUM_ATTRIBUTE_VALUE__VALUE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getEnumAttributeValueAccess().getNameValidIDParserRuleCall_0_0(), semanticObject.getName());
		feeder.accept(grammarAccess.getEnumAttributeValueAccess().getValueXExpressionParserRuleCall_2_0(), semanticObject.getValue());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (directives+=EnumAttributeDirective final?='final'? static?='static'? type=JvmTypeReference name=ValidID)
	 */
	protected void sequence_EnumAttribute(EObject context, EnumAttribute semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     sernum=INT
	 */
	protected void sequence_EnumDirective(EObject context, EnumDirectiveSerializable semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, ProcessorModelPackage.Literals.ENUM_DIRECTIVE_SERIALIZABLE__SERNUM) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ProcessorModelPackage.Literals.ENUM_DIRECTIVE_SERIALIZABLE__SERNUM));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getEnumDirectiveAccess().getSernumINTTerminalRuleCall_3_0(), semanticObject.getSernum());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (directives+=EnumDirective* final?='final'? name=ValidID attribute=EnumAttribute procedures+=PojoProcedure*)
	 */
	protected void sequence_EnumEntity(EObject context, EnumEntity semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (dbColumn=ValidID fkTable=ValidID fkColumn=ValidID?)
	 */
	protected void sequence_ExportAssignement(EObject context, ExportAssignement semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (toExtends=JvmParameterizedTypeReference dbTables+=ValidID* dbNotTables+=ValidID*)
	 */
	protected void sequence_ExtendsAssignementGenerics(EObject context, ExtendsAssignementGenerics semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (toExtends=JvmParameterizedTypeReference dbTables+=ValidID* dbNotTables+=ValidID*)
	 */
	protected void sequence_ExtendsAssignement(EObject context, ExtendsAssignement semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (directives+=ImplementsExtendsDirective* extends=JvmParameterizedTypeReference)
	 */
	protected void sequence_Extends(EObject context, Extends semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     {FunctionCall}
	 */
	protected void sequence_FunProcType(EObject context, FunctionCall semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     {FunctionCallQuery}
	 */
	protected void sequence_FunProcType(EObject context, FunctionCallQuery semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     {FunctionQuery}
	 */
	protected void sequence_FunProcType(EObject context, FunctionQuery semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     {ProcedureCallQuery}
	 */
	protected void sequence_FunProcType(EObject context, ProcedureCallQuery semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     {ProcedureUpdate}
	 */
	protected void sequence_FunProcType(EObject context, ProcedureUpdate semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=ValidID table=ValidID)
	 */
	protected void sequence_FunctionDefinition(EObject context, FunctionDefinition semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, ProcessorModelPackage.Literals.FUNCTION_DEFINITION__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ProcessorModelPackage.Literals.FUNCTION_DEFINITION__NAME));
			if(transientValues.isValueTransient(semanticObject, ProcessorModelPackage.Literals.FUNCTION_DEFINITION__TABLE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ProcessorModelPackage.Literals.FUNCTION_DEFINITION__TABLE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getFunctionDefinitionAccess().getNameValidIDParserRuleCall_1_0(), semanticObject.getName());
		feeder.accept(grammarAccess.getFunctionDefinitionAccess().getTableValidIDParserRuleCall_2_0(), semanticObject.getTable());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (dbFunction=ValidID pojo=JvmParameterizedTypeReference)
	 */
	protected void sequence_FunctionPojoAssignement(EObject context, FunctionPojoAssignement semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, ProcessorModelPackage.Literals.FUNCTION_POJO_ASSIGNEMENT__DB_FUNCTION) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ProcessorModelPackage.Literals.FUNCTION_POJO_ASSIGNEMENT__DB_FUNCTION));
			if(transientValues.isValueTransient(semanticObject, ProcessorModelPackage.Literals.FUNCTION_POJO_ASSIGNEMENT__POJO) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ProcessorModelPackage.Literals.FUNCTION_POJO_ASSIGNEMENT__POJO));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getFunctionPojoAssignementAccess().getDbFunctionValidIDParserRuleCall_0_0(), semanticObject.getDbFunction());
		feeder.accept(grammarAccess.getFunctionPojoAssignementAccess().getPojoJvmParameterizedTypeReferenceParserRuleCall_3_0(), semanticObject.getPojo());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (toImplement=JvmParameterizedTypeReference dbTables+=ValidID* dbNotTables+=ValidID*)
	 */
	protected void sequence_ImplementsAssignementGenerics(EObject context, ImplementsAssignementGenerics semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (toImplement=JvmParameterizedTypeReference dbTables+=ValidID* dbNotTables+=ValidID*)
	 */
	protected void sequence_ImplementsAssignement(EObject context, ImplementsAssignement semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (exceptDaos+=[DaoEntity|ValidID]*)
	 */
	protected void sequence_ImplementsExtendsDirective(EObject context, ImplementsExtendsDirectiveExceptDaos semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (exceptPojos+=[PojoEntity|ValidID]*)
	 */
	protected void sequence_ImplementsExtendsDirective(EObject context, ImplementsExtendsDirectiveExceptPojos semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     {ImplementsExtendsDirectiveGenerics}
	 */
	protected void sequence_ImplementsExtendsDirective(EObject context, ImplementsExtendsDirectiveGenerics semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (onlyDaos+=[DaoEntity|ValidID]*)
	 */
	protected void sequence_ImplementsExtendsDirective(EObject context, ImplementsExtendsDirectiveOnlyDaos semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (onlyPojos+=[PojoEntity|ValidID]*)
	 */
	protected void sequence_ImplementsExtendsDirective(EObject context, ImplementsExtendsDirectiveOnlyPojos semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (directives+=ImplementsExtendsDirective* implements=JvmParameterizedTypeReference)
	 */
	protected void sequence_Implements(EObject context, Implements semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (dbColumn=ValidID pkTable=ValidID pkColumn=ValidID?)
	 */
	protected void sequence_ImportAssignement(EObject context, ImportAssignement semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (discriminator=ValidID dbTable=ValidID dbColumns+=ValidID+)
	 */
	protected void sequence_InheritanceAssignement(EObject context, InheritanceAssignement semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (dbTable=ValidID dbTables+=ValidID+)
	 */
	protected void sequence_JoinTableAssignement(EObject context, JoinTableAssignement semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (pkColumn=ValidID pkTable=ValidID fkColumn=ValidID?)
	 */
	protected void sequence_ManyToManyAssignement(EObject context, ManyToManyAssignement semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (dbColumn=ValidID type=ValidID extension=ValidID?)
	 */
	protected void sequence_MetaTypeAssignement(EObject context, MetaTypeAssignement semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         (name='global-sequence' sequence=ValidID type=ValidID? dbTables+=ValidID* dbNotTables+=ValidID*) | 
	 *         (name='table-sequence' dbTable=ValidID sequence=ValidID type=ValidID?) | 
	 *         (name='global-identity' (identity=ValidID type=ValidID?)? dbTables+=ValidID* dbNotTables+=ValidID*) | 
	 *         (name='table-identity' dbTable=ValidID identity=ValidID type=ValidID?) | 
	 *         (name='column-meta-type' dbTable=ValidID metaTypes+=MetaTypeAssignement+) | 
	 *         (name='statement-meta-type' dbStatement=ValidID metaTypes+=MetaTypeAssignement+) | 
	 *         name='make-it-final' | 
	 *         (name='like-columns' (dbTable=ValidID dbColumns+=ValidID+)?) | 
	 *         (name='not-like-columns' (dbTable=ValidID dbColumns+=ValidID+)?) | 
	 *         name='generate-sequences' | 
	 *         name='generate-identities' | 
	 *         name='generate-idgenerators' | 
	 *         name='generate-default-idgenerators' | 
	 *         (name='function-result' dbFunction=ValidID type=ValidID) | 
	 *         (name='function-result-set' dbFunction=ValidID dbTable=ValidID) | 
	 *         (name='procedure-result-set' dbProcedure=ValidID dbTable=ValidID) | 
	 *         (name='debug-level' debug=DebugLevelAssignement) | 
	 *         name='generate-operators' | 
	 *         (name='optimize-insert' dbTables+=ValidID*) | 
	 *         (name='optional-features' dbStatement=ValidID optionalFeatures+=ValidID+) | 
	 *         (name='active-filter' activeFilter=ValueType)
	 *     )
	 */
	protected void sequence_MetagenProperty(EObject context, MetagenProperty semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     implementation=QualifiedName
	 */
	protected void sequence_PackageDirective(EObject context, PackageDirectiveImplementation semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, ProcessorModelPackage.Literals.PACKAGE_DIRECTIVE_IMPLEMENTATION__IMPLEMENTATION) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ProcessorModelPackage.Literals.PACKAGE_DIRECTIVE_IMPLEMENTATION__IMPLEMENTATION));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getPackageDirectiveAccess().getImplementationQualifiedNameParserRuleCall_3_0(), semanticObject.getImplementation());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (directives+=PackageDirective* name=QualifiedName importSection=XImportSection? elements+=AbstractEntity*)
	 */
	protected void sequence_Package(EObject context, org.sqlproc.model.processorModel.Package semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (createColumn1=[PojoAttribute|ValidID] createColumn2=[PojoAttribute|ValidID])
	 */
	protected void sequence_PojoAttributeDirective(EObject context, PojoAttributeDirectiveCreateCol semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, ProcessorModelPackage.Literals.POJO_ATTRIBUTE_DIRECTIVE_CREATE_COL__CREATE_COLUMN1) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ProcessorModelPackage.Literals.POJO_ATTRIBUTE_DIRECTIVE_CREATE_COL__CREATE_COLUMN1));
			if(transientValues.isValueTransient(semanticObject, ProcessorModelPackage.Literals.POJO_ATTRIBUTE_DIRECTIVE_CREATE_COL__CREATE_COLUMN2) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ProcessorModelPackage.Literals.POJO_ATTRIBUTE_DIRECTIVE_CREATE_COL__CREATE_COLUMN2));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getPojoAttributeDirectiveAccess().getCreateColumn1PojoAttributeValidIDParserRuleCall_6_3_0_1(), semanticObject.getCreateColumn1());
		feeder.accept(grammarAccess.getPojoAttributeDirectiveAccess().getCreateColumn2PojoAttributeValidIDParserRuleCall_6_5_0_1(), semanticObject.getCreateColumn2());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     {PojoAttributeDirectiveDiscriminator}
	 */
	protected void sequence_PojoAttributeDirective(EObject context, PojoAttributeDirectiveDiscriminator semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     {PojoAttributeDirectiveEnumDef}
	 */
	protected void sequence_PojoAttributeDirective(EObject context, PojoAttributeDirectiveEnumDef semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     {PojoAttributeDirectiveEnumInit}
	 */
	protected void sequence_PojoAttributeDirective(EObject context, PojoAttributeDirectiveEnumInit semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     index=INT
	 */
	protected void sequence_PojoAttributeDirective(EObject context, PojoAttributeDirectiveIndex semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, ProcessorModelPackage.Literals.POJO_ATTRIBUTE_DIRECTIVE_INDEX__INDEX) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ProcessorModelPackage.Literals.POJO_ATTRIBUTE_DIRECTIVE_INDEX__INDEX));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getPojoAttributeDirectiveAccess().getIndexINTTerminalRuleCall_3_3_0(), semanticObject.getIndex());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     {PojoAttributeDirectiveIsDef}
	 */
	protected void sequence_PojoAttributeDirective(EObject context, PojoAttributeDirectiveIsDef semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     {PojoAttributeDirectivePrimaryKey}
	 */
	protected void sequence_PojoAttributeDirective(EObject context, PojoAttributeDirectivePrimaryKey semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     {PojoAttributeDirectiveRequired}
	 */
	protected void sequence_PojoAttributeDirective(EObject context, PojoAttributeDirectiveRequired semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     {PojoAttributeDirectiveToInit}
	 */
	protected void sequence_PojoAttributeDirective(EObject context, PojoAttributeDirectiveToInit semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (updateColumn1=[PojoAttribute|ValidID] updateColumn2=[PojoAttribute|ValidID])
	 */
	protected void sequence_PojoAttributeDirective(EObject context, PojoAttributeDirectiveUpdateCol semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, ProcessorModelPackage.Literals.POJO_ATTRIBUTE_DIRECTIVE_UPDATE_COL__UPDATE_COLUMN1) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ProcessorModelPackage.Literals.POJO_ATTRIBUTE_DIRECTIVE_UPDATE_COL__UPDATE_COLUMN1));
			if(transientValues.isValueTransient(semanticObject, ProcessorModelPackage.Literals.POJO_ATTRIBUTE_DIRECTIVE_UPDATE_COL__UPDATE_COLUMN2) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ProcessorModelPackage.Literals.POJO_ATTRIBUTE_DIRECTIVE_UPDATE_COL__UPDATE_COLUMN2));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getPojoAttributeDirectiveAccess().getUpdateColumn1PojoAttributeValidIDParserRuleCall_5_3_0_1(), semanticObject.getUpdateColumn1());
		feeder.accept(grammarAccess.getPojoAttributeDirectiveAccess().getUpdateColumn2PojoAttributeValidIDParserRuleCall_5_5_0_1(), semanticObject.getUpdateColumn2());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     {PojoAttributeDirectiveVersion}
	 */
	protected void sequence_PojoAttributeDirective(EObject context, PojoAttributeDirectiveVersion semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         annotations+=Annotation* 
	 *         directives+=PojoAttributeDirective* 
	 *         final?='final'? 
	 *         static?='static'? 
	 *         (kind='#Attr' | kind='#Simple') 
	 *         type=JvmTypeReference? 
	 *         name=ValidID 
	 *         initExpr=XExpression?
	 *     )
	 */
	protected void sequence_PojoAttribute(EObject context, PojoAttribute semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=ValidID (class=QualifiedName | classx=JvmParameterizedTypeReference))
	 */
	protected void sequence_PojoDefinition(EObject context, PojoDefinition semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     discriminator=ValidID
	 */
	protected void sequence_PojoDirective(EObject context, PojoDirectiveDiscriminator semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, ProcessorModelPackage.Literals.POJO_DIRECTIVE_DISCRIMINATOR__DISCRIMINATOR) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ProcessorModelPackage.Literals.POJO_DIRECTIVE_DISCRIMINATOR__DISCRIMINATOR));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getPojoDirectiveAccess().getDiscriminatorValidIDParserRuleCall_4_3_0(), semanticObject.getDiscriminator());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     proplist=DirectiveProperties
	 */
	protected void sequence_PojoDirective(EObject context, PojoDirectiveEquals semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, ProcessorModelPackage.Literals.POJO_DIRECTIVE_EQUALS__PROPLIST) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ProcessorModelPackage.Literals.POJO_DIRECTIVE_EQUALS__PROPLIST));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getPojoDirectiveAccess().getProplistDirectivePropertiesParserRuleCall_5_3_0(), semanticObject.getProplist());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     proplist=DirectiveProperties
	 */
	protected void sequence_PojoDirective(EObject context, PojoDirectiveHashCode semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, ProcessorModelPackage.Literals.POJO_DIRECTIVE_HASH_CODE__PROPLIST) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ProcessorModelPackage.Literals.POJO_DIRECTIVE_HASH_CODE__PROPLIST));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getPojoDirectiveAccess().getProplistDirectivePropertiesParserRuleCall_6_3_0(), semanticObject.getProplist());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (index=INT proplist=DirectiveProperties)
	 */
	protected void sequence_PojoDirective(EObject context, PojoDirectiveIndex semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, ProcessorModelPackage.Literals.POJO_DIRECTIVE_INDEX__INDEX) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ProcessorModelPackage.Literals.POJO_DIRECTIVE_INDEX__INDEX));
			if(transientValues.isValueTransient(semanticObject, ProcessorModelPackage.Literals.POJO_DIRECTIVE_INDEX__PROPLIST) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ProcessorModelPackage.Literals.POJO_DIRECTIVE_INDEX__PROPLIST));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getPojoDirectiveAccess().getIndexINTTerminalRuleCall_1_3_0(), semanticObject.getIndex());
		feeder.accept(grammarAccess.getPojoDirectiveAccess().getProplistDirectivePropertiesParserRuleCall_1_5_0(), semanticObject.getProplist());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (operatorsSuffix=ValidID?)
	 */
	protected void sequence_PojoDirective(EObject context, PojoDirectiveOperators semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     sernum=INT
	 */
	protected void sequence_PojoDirective(EObject context, PojoDirectiveSerializable semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, ProcessorModelPackage.Literals.POJO_DIRECTIVE_SERIALIZABLE__SERNUM) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ProcessorModelPackage.Literals.POJO_DIRECTIVE_SERIALIZABLE__SERNUM));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getPojoDirectiveAccess().getSernumINTTerminalRuleCall_3_3_0(), semanticObject.getSernum());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     proplist=DirectiveProperties
	 */
	protected void sequence_PojoDirective(EObject context, PojoDirectiveToString semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, ProcessorModelPackage.Literals.POJO_DIRECTIVE_TO_STRING__PROPLIST) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ProcessorModelPackage.Literals.POJO_DIRECTIVE_TO_STRING__PROPLIST));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getPojoDirectiveAccess().getProplistDirectivePropertiesParserRuleCall_0_3_0(), semanticObject.getProplist());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         directives+=PojoDirective* 
	 *         final?='final'? 
	 *         abstract?='abstract'? 
	 *         name=ValidID 
	 *         superType=JvmParameterizedTypeReference? 
	 *         attributes+=PojoAttribute* 
	 *         procedures+=PojoProcedure*
	 *     )
	 */
	protected void sequence_PojoEntity(EObject context, PojoEntity semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         annotations+=Annotation* 
	 *         final?='final'? 
	 *         static?='static'? 
	 *         type=JvmTypeReference? 
	 *         name=ValidID 
	 *         (params+=FullJvmFormalParameter params+=FullJvmFormalParameter*)? 
	 *         body=XBlockExpression
	 *     )
	 */
	protected void sequence_PojoProcedure(EObject context, PojoProcedure semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         (name='types-sqltypes' sqlTypes+=SqlTypeAssignement+) | 
	 *         (name='types-in-table' dbTable=ValidID sqlTypes+=SqlTypeAssignement+) | 
	 *         (name='types-for-columns' dbTable=ValidID columnTypes+=ColumnTypeAssignement+) | 
	 *         (name='types-for-procedure' dbProcedure=ValidID columnTypes+=ColumnTypeAssignement+) | 
	 *         (name='types-for-function' dbFunction=ValidID columnTypes+=ColumnTypeAssignement+) | 
	 *         (name='show-type-for-column' dbTable=ValidID columnType=ShowColumnTypeAssignement) | 
	 *         (name='show-type-for-procedure' dbProcedure=ValidID columnType=ShowColumnTypeAssignement) | 
	 *         (name='show-type-for-function' dbFunction=ValidID columnType=ShowColumnTypeAssignement) | 
	 *         (name='ignore-tables' dbTables+=ValidID+) | 
	 *         (name='only-tables' dbTables+=ValidID+) | 
	 *         (name='not-abstract-tables' dbTables+=ValidID+) | 
	 *         (name='join-tables' joinTables+=JoinTableAssignement+) | 
	 *         (name='ignore-columns' dbTable=ValidID dbColumns+=ValidID+) | 
	 *         (name='required-columns' dbTable=ValidID dbColumns+=ValidID+) | 
	 *         (name='not-required-columns' dbTable=ValidID dbColumns+=ValidID+) | 
	 *         (name='create-columns' dbTable=ValidID columnTypes+=ColumnTypeAssignement+) | 
	 *         (name='rename-tables' tables+=TableAssignement+) | 
	 *         (name='rename-columns' dbTable=ValidID columns+=ColumnAssignement+) | 
	 *         (name='ignore-one-to-many' dbTable=ValidID exports+=ExportAssignement+) | 
	 *         (name='ignore-many-to-one' dbTable=ValidID imports+=ImportAssignement+) | 
	 *         (name='inherit-many-to-one' dbTable=ValidID imports+=ImportAssignement+) | 
	 *         (name='create-one-to-many' dbTable=ValidID exports+=ExportAssignement+) | 
	 *         (name='create-many-to-one' dbTable=ValidID imports+=ImportAssignement+) | 
	 *         (name='table-many-to-many' dbTable=ValidID many2s+=ManyToManyAssignement+) | 
	 *         (name='inherit-discriminator' dbTable=ValidID dbColumn=ValidID inheritance+=InheritanceAssignement+) | 
	 *         (name='generate-methods' methods+=ValidID+) | 
	 *         (name='generate-operators' operatorsSuffix=ValidID?) | 
	 *         (name='implements-interfaces' toImplements=ImplementsAssignement) | 
	 *         (name='extends-class' toExtends=ExtendsAssignement) | 
	 *         (name='implements-interfaces-generics' toImplementsGenerics=ImplementsAssignementGenerics) | 
	 *         (name='extends-class-generics' toExtendsGenerics=ExtendsAssignementGenerics) | 
	 *         name='generate-wrappers' | 
	 *         name='generate-validation-annotations' | 
	 *         (name='preserve-foreign-keys' dbTables+=ValidID*) | 
	 *         name='make-it-final' | 
	 *         (name='version-column' version=ValidID dbTables+=ValidID* dbNotTables+=ValidID*) | 
	 *         (name='debug-level' debug=DebugLevelAssignement) | 
	 *         (name='pojos-for-procedures' procPojos+=ProcedurePojoAssignement+) | 
	 *         (name='pojos-for-functions' funPojos+=FunctionPojoAssignement+) | 
	 *         (name='active-filter' activeFilter=ValueType) | 
	 *         (name='package' pckg=QualifiedName) | 
	 *         (name='enum-for-check-constraints' enumName=ValidID dbCheckConstraints+=ValidID+)
	 *     )
	 */
	protected void sequence_PojogenProperty(EObject context, PojogenProperty semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=ValidID table=ValidID)
	 */
	protected void sequence_ProcedureDefinition(EObject context, ProcedureDefinition semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, ProcessorModelPackage.Literals.PROCEDURE_DEFINITION__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ProcessorModelPackage.Literals.PROCEDURE_DEFINITION__NAME));
			if(transientValues.isValueTransient(semanticObject, ProcessorModelPackage.Literals.PROCEDURE_DEFINITION__TABLE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ProcessorModelPackage.Literals.PROCEDURE_DEFINITION__TABLE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getProcedureDefinitionAccess().getNameValidIDParserRuleCall_1_0(), semanticObject.getName());
		feeder.accept(grammarAccess.getProcedureDefinitionAccess().getTableValidIDParserRuleCall_2_0(), semanticObject.getTable());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (dbProcedure=ValidID pojo=JvmParameterizedTypeReference)
	 */
	protected void sequence_ProcedurePojoAssignement(EObject context, ProcedurePojoAssignement semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, ProcessorModelPackage.Literals.PROCEDURE_POJO_ASSIGNEMENT__DB_PROCEDURE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ProcessorModelPackage.Literals.PROCEDURE_POJO_ASSIGNEMENT__DB_PROCEDURE));
			if(transientValues.isValueTransient(semanticObject, ProcessorModelPackage.Literals.PROCEDURE_POJO_ASSIGNEMENT__POJO) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ProcessorModelPackage.Literals.PROCEDURE_POJO_ASSIGNEMENT__POJO));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getProcedurePojoAssignementAccess().getDbProcedureValidIDParserRuleCall_0_0(), semanticObject.getDbProcedure());
		feeder.accept(grammarAccess.getProcedurePojoAssignementAccess().getPojoJvmParameterizedTypeReferenceParserRuleCall_3_0(), semanticObject.getPojo());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (name=ValidID value=ValueType)
	 */
	protected void sequence_PropertyCondition(EObject context, PropertyCondition semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, ProcessorModelPackage.Literals.PROPERTY_CONDITION__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ProcessorModelPackage.Literals.PROPERTY_CONDITION__NAME));
			if(transientValues.isValueTransient(semanticObject, ProcessorModelPackage.Literals.PROPERTY_CONDITION__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ProcessorModelPackage.Literals.PROPERTY_CONDITION__VALUE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getPropertyConditionAccess().getNameValidIDParserRuleCall_1_0(), semanticObject.getName());
		feeder.accept(grammarAccess.getPropertyConditionAccess().getValueValueTypeParserRuleCall_3_0(), semanticObject.getValue());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         condition=PropertyCondition? 
	 *         (
	 *             name='resolve-pojo-on' | 
	 *             name='resolve-pojo-off' | 
	 *             (name='database-' database=DatabaseProperty) | 
	 *             (name='pojogen-' pojogen=PojogenProperty) | 
	 *             (name='metagen-' metagen=MetagenProperty) | 
	 *             (name='daogen-' daogen=DaogenProperty) | 
	 *             (name='replace-all-regex' replaceId=ValidID regex=ValueType) | 
	 *             (name='replace-all-replacement' replaceId=ValidID replacement=ValueType) | 
	 *             name='compress-meta-directives'
	 *         )
	 *     )
	 */
	protected void sequence_Property(EObject context, Property semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (dbColumn=ValidID type=ValueType)
	 */
	protected void sequence_ShowColumnTypeAssignement(EObject context, ShowColumnTypeAssignement semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, ProcessorModelPackage.Literals.SHOW_COLUMN_TYPE_ASSIGNEMENT__DB_COLUMN) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ProcessorModelPackage.Literals.SHOW_COLUMN_TYPE_ASSIGNEMENT__DB_COLUMN));
			if(transientValues.isValueTransient(semanticObject, ProcessorModelPackage.Literals.SHOW_COLUMN_TYPE_ASSIGNEMENT__TYPE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ProcessorModelPackage.Literals.SHOW_COLUMN_TYPE_ASSIGNEMENT__TYPE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getShowColumnTypeAssignementAccess().getDbColumnValidIDParserRuleCall_0_0(), semanticObject.getDbColumn());
		feeder.accept(grammarAccess.getShowColumnTypeAssignementAccess().getTypeValueTypeParserRuleCall_2_0(), semanticObject.getType());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (sqlType=ValueType type=JvmParameterizedTypeReference)
	 */
	protected void sequence_SqlTypeAssignement(EObject context, SqlTypeAssignement semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, ProcessorModelPackage.Literals.SQL_TYPE_ASSIGNEMENT__SQL_TYPE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ProcessorModelPackage.Literals.SQL_TYPE_ASSIGNEMENT__SQL_TYPE));
			if(transientValues.isValueTransient(semanticObject, ProcessorModelPackage.Literals.SQL_TYPE_ASSIGNEMENT__TYPE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ProcessorModelPackage.Literals.SQL_TYPE_ASSIGNEMENT__TYPE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getSqlTypeAssignementAccess().getSqlTypeValueTypeParserRuleCall_0_0(), semanticObject.getSqlType());
		feeder.accept(grammarAccess.getSqlTypeAssignementAccess().getTypeJvmParameterizedTypeReferenceParserRuleCall_3_0(), semanticObject.getType());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (dbTable=ValidID newName=ValidID)
	 */
	protected void sequence_TableAssignement(EObject context, TableAssignement semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, ProcessorModelPackage.Literals.TABLE_ASSIGNEMENT__DB_TABLE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ProcessorModelPackage.Literals.TABLE_ASSIGNEMENT__DB_TABLE));
			if(transientValues.isValueTransient(semanticObject, ProcessorModelPackage.Literals.TABLE_ASSIGNEMENT__NEW_NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ProcessorModelPackage.Literals.TABLE_ASSIGNEMENT__NEW_NAME));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getTableAssignementAccess().getDbTableValidIDParserRuleCall_0_0(), semanticObject.getDbTable());
		feeder.accept(grammarAccess.getTableAssignementAccess().getNewNameValidIDParserRuleCall_2_0(), semanticObject.getNewName());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (name=ValidID table=ValidID)
	 */
	protected void sequence_TableDefinition(EObject context, TableDefinition semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, ProcessorModelPackage.Literals.TABLE_DEFINITION__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ProcessorModelPackage.Literals.TABLE_DEFINITION__NAME));
			if(transientValues.isValueTransient(semanticObject, ProcessorModelPackage.Literals.TABLE_DEFINITION__TABLE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ProcessorModelPackage.Literals.TABLE_DEFINITION__TABLE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getTableDefinitionAccess().getNameValidIDParserRuleCall_1_0(), semanticObject.getName());
		feeder.accept(grammarAccess.getTableDefinitionAccess().getTableValidIDParserRuleCall_2_0(), semanticObject.getTable());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (value=STRING | number=INT | id=QualifiedName)
	 */
	protected void sequence_ValueType(EObject context, ValueType semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
}
