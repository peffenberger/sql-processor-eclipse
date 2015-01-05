package org.sqlproc.dsl.serializer;

import com.google.inject.Inject;
import com.google.inject.Provider;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.serializer.acceptor.ISemanticSequenceAcceptor;
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
import org.eclipse.xtext.serializer.diagnostic.ISemanticSequencerDiagnosticProvider;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic.Acceptor;
import org.eclipse.xtext.serializer.sequencer.AbstractDelegatingSemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.GenericSequencer;
import org.eclipse.xtext.serializer.sequencer.ISemanticNodeProvider.INodesForEObjectProvider;
import org.eclipse.xtext.serializer.sequencer.ISemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService.ValueTransient;
import org.sqlproc.dsl.processorDsl.Annotation;
import org.sqlproc.dsl.processorDsl.AnnotationProperty;
import org.sqlproc.dsl.processorDsl.Artifacts;
import org.sqlproc.dsl.processorDsl.AttributeAnnotations;
import org.sqlproc.dsl.processorDsl.Column;
import org.sqlproc.dsl.processorDsl.ColumnAssignement;
import org.sqlproc.dsl.processorDsl.ColumnTypeAssignement;
import org.sqlproc.dsl.processorDsl.ConflictAnnotations;
import org.sqlproc.dsl.processorDsl.Constant;
import org.sqlproc.dsl.processorDsl.ConstantOperator;
import org.sqlproc.dsl.processorDsl.ConstructorAnnotations;
import org.sqlproc.dsl.processorDsl.DaoDirectiveAbstract;
import org.sqlproc.dsl.processorDsl.DaoDirectiveDiscriminator;
import org.sqlproc.dsl.processorDsl.DaoDirectiveExtends;
import org.sqlproc.dsl.processorDsl.DaoDirectiveFinal;
import org.sqlproc.dsl.processorDsl.DaoDirectiveFunction;
import org.sqlproc.dsl.processorDsl.DaoDirectiveGenerics;
import org.sqlproc.dsl.processorDsl.DaoDirectivePojo;
import org.sqlproc.dsl.processorDsl.DaoDirectiveProcedure;
import org.sqlproc.dsl.processorDsl.DaoDirectiveSerializable;
import org.sqlproc.dsl.processorDsl.DaoDirectiveUpdate;
import org.sqlproc.dsl.processorDsl.DaoType;
import org.sqlproc.dsl.processorDsl.DaogenProperty;
import org.sqlproc.dsl.processorDsl.DatabaseCatalogAssignement;
import org.sqlproc.dsl.processorDsl.DatabaseColumn;
import org.sqlproc.dsl.processorDsl.DatabaseMetaInfoAssignement;
import org.sqlproc.dsl.processorDsl.DatabaseProperty;
import org.sqlproc.dsl.processorDsl.DatabaseSchemaAssignement;
import org.sqlproc.dsl.processorDsl.DatabaseTable;
import org.sqlproc.dsl.processorDsl.DatabaseTypeAssignement;
import org.sqlproc.dsl.processorDsl.DebugLevelAssignement;
import org.sqlproc.dsl.processorDsl.DirectiveParameters;
import org.sqlproc.dsl.processorDsl.DirectiveProperties;
import org.sqlproc.dsl.processorDsl.DriverMetaInfoAssignement;
import org.sqlproc.dsl.processorDsl.DriverMethodOutputAssignement;
import org.sqlproc.dsl.processorDsl.EnumDirectiveExtends;
import org.sqlproc.dsl.processorDsl.EnumDirectiveFinal;
import org.sqlproc.dsl.processorDsl.EnumDirectiveSerializable;
import org.sqlproc.dsl.processorDsl.EnumEntity;
import org.sqlproc.dsl.processorDsl.EnumProperty;
import org.sqlproc.dsl.processorDsl.EnumPropertyDirectiveValues;
import org.sqlproc.dsl.processorDsl.ExportAssignement;
import org.sqlproc.dsl.processorDsl.ExtendedColumn;
import org.sqlproc.dsl.processorDsl.ExtendedColumnName;
import org.sqlproc.dsl.processorDsl.ExtendedMappingItem;
import org.sqlproc.dsl.processorDsl.Extends;
import org.sqlproc.dsl.processorDsl.ExtendsAssignement;
import org.sqlproc.dsl.processorDsl.ExtendsAssignementGenerics;
import org.sqlproc.dsl.processorDsl.FunctionDefinition;
import org.sqlproc.dsl.processorDsl.FunctionPojoAssignement;
import org.sqlproc.dsl.processorDsl.GetterAnnotations;
import org.sqlproc.dsl.processorDsl.Identifier;
import org.sqlproc.dsl.processorDsl.IdentifierOperator;
import org.sqlproc.dsl.processorDsl.IfMetaSql;
import org.sqlproc.dsl.processorDsl.IfSql;
import org.sqlproc.dsl.processorDsl.IfSqlBool;
import org.sqlproc.dsl.processorDsl.IfSqlCond;
import org.sqlproc.dsl.processorDsl.IfSqlFragment;
import org.sqlproc.dsl.processorDsl.ImplPackage;
import org.sqlproc.dsl.processorDsl.Implements;
import org.sqlproc.dsl.processorDsl.ImplementsAssignement;
import org.sqlproc.dsl.processorDsl.ImplementsAssignementGenerics;
import org.sqlproc.dsl.processorDsl.Import;
import org.sqlproc.dsl.processorDsl.ImportAssignement;
import org.sqlproc.dsl.processorDsl.InheritanceAssignement;
import org.sqlproc.dsl.processorDsl.JoinTableAssignement;
import org.sqlproc.dsl.processorDsl.ManyToManyAssignement;
import org.sqlproc.dsl.processorDsl.Mapping;
import org.sqlproc.dsl.processorDsl.MappingColumn;
import org.sqlproc.dsl.processorDsl.MappingColumnName;
import org.sqlproc.dsl.processorDsl.MappingItem;
import org.sqlproc.dsl.processorDsl.MappingRule;
import org.sqlproc.dsl.processorDsl.MetaSql;
import org.sqlproc.dsl.processorDsl.MetaStatement;
import org.sqlproc.dsl.processorDsl.MetaTypeAssignement;
import org.sqlproc.dsl.processorDsl.MetagenProperty;
import org.sqlproc.dsl.processorDsl.OptionalFeature;
import org.sqlproc.dsl.processorDsl.OrdSql;
import org.sqlproc.dsl.processorDsl.OrdSql2;
import org.sqlproc.dsl.processorDsl.PackageDeclaration;
import org.sqlproc.dsl.processorDsl.PackageDirectiveSuffix;
import org.sqlproc.dsl.processorDsl.PojoDao;
import org.sqlproc.dsl.processorDsl.PojoDefinition;
import org.sqlproc.dsl.processorDsl.PojoDirectiveAbstract;
import org.sqlproc.dsl.processorDsl.PojoDirectiveDiscriminator;
import org.sqlproc.dsl.processorDsl.PojoDirectiveEquals;
import org.sqlproc.dsl.processorDsl.PojoDirectiveExtends;
import org.sqlproc.dsl.processorDsl.PojoDirectiveFinal;
import org.sqlproc.dsl.processorDsl.PojoDirectiveHashCode;
import org.sqlproc.dsl.processorDsl.PojoDirectiveIsDef;
import org.sqlproc.dsl.processorDsl.PojoDirectiveOperators;
import org.sqlproc.dsl.processorDsl.PojoDirectiveSerializable;
import org.sqlproc.dsl.processorDsl.PojoDirectiveToInit;
import org.sqlproc.dsl.processorDsl.PojoDirectiveToString;
import org.sqlproc.dsl.processorDsl.PojoEntity;
import org.sqlproc.dsl.processorDsl.PojoProperty;
import org.sqlproc.dsl.processorDsl.PojoPropertyDirectiveCreateCol;
import org.sqlproc.dsl.processorDsl.PojoPropertyDirectiveDiscriminator;
import org.sqlproc.dsl.processorDsl.PojoPropertyDirectiveIndex;
import org.sqlproc.dsl.processorDsl.PojoPropertyDirectivePrimaryKey;
import org.sqlproc.dsl.processorDsl.PojoPropertyDirectiveRequired;
import org.sqlproc.dsl.processorDsl.PojoPropertyDirectiveUpdateCol;
import org.sqlproc.dsl.processorDsl.PojoPropertyDirectiveVersion;
import org.sqlproc.dsl.processorDsl.PojoType;
import org.sqlproc.dsl.processorDsl.PojogenProperty;
import org.sqlproc.dsl.processorDsl.ProcedureDefinition;
import org.sqlproc.dsl.processorDsl.ProcedurePojoAssignement;
import org.sqlproc.dsl.processorDsl.ProcessorDslPackage;
import org.sqlproc.dsl.processorDsl.Property;
import org.sqlproc.dsl.processorDsl.SetterAnnotations;
import org.sqlproc.dsl.processorDsl.ShowColumnTypeAssignement;
import org.sqlproc.dsl.processorDsl.Sql;
import org.sqlproc.dsl.processorDsl.SqlFragment;
import org.sqlproc.dsl.processorDsl.SqlTypeAssignement;
import org.sqlproc.dsl.processorDsl.StandardAnnotation;
import org.sqlproc.dsl.processorDsl.StaticAnnotations;
import org.sqlproc.dsl.processorDsl.TableAssignement;
import org.sqlproc.dsl.processorDsl.TableDefinition;
import org.sqlproc.dsl.services.ProcessorDslGrammarAccess;

@SuppressWarnings("all")
public class ProcessorDslSemanticSequencer extends AbstractDelegatingSemanticSequencer {

	@Inject
	private ProcessorDslGrammarAccess grammarAccess;
	
	public void createSequence(EObject context, EObject semanticObject) {
		if(semanticObject.eClass().getEPackage() == ProcessorDslPackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case ProcessorDslPackage.ANNOTATION:
				if(context == grammarAccess.getAnnotationRule()) {
					sequence_Annotation(context, (Annotation) semanticObject); 
					return; 
				}
				else break;
			case ProcessorDslPackage.ANNOTATION_PROPERTY:
				if(context == grammarAccess.getAnnotationPropertyRule()) {
					sequence_AnnotationProperty(context, (AnnotationProperty) semanticObject); 
					return; 
				}
				else break;
			case ProcessorDslPackage.ARTIFACTS:
				if(context == grammarAccess.getArtifactsRule()) {
					sequence_Artifacts(context, (Artifacts) semanticObject); 
					return; 
				}
				else break;
			case ProcessorDslPackage.ATTRIBUTE_ANNOTATIONS:
				if(context == grammarAccess.getPojoPropertyAnnotationRule()) {
					sequence_PojoPropertyAnnotation(context, (AttributeAnnotations) semanticObject); 
					return; 
				}
				else break;
			case ProcessorDslPackage.COLUMN:
				if(context == grammarAccess.getColumnRule()) {
					sequence_Column(context, (Column) semanticObject); 
					return; 
				}
				else break;
			case ProcessorDslPackage.COLUMN_ASSIGNEMENT:
				if(context == grammarAccess.getColumnAssignementRule()) {
					sequence_ColumnAssignement(context, (ColumnAssignement) semanticObject); 
					return; 
				}
				else break;
			case ProcessorDslPackage.COLUMN_TYPE_ASSIGNEMENT:
				if(context == grammarAccess.getColumnTypeAssignementRule()) {
					sequence_ColumnTypeAssignement(context, (ColumnTypeAssignement) semanticObject); 
					return; 
				}
				else break;
			case ProcessorDslPackage.CONFLICT_ANNOTATIONS:
				if(context == grammarAccess.getEntityAnnotationRule()) {
					sequence_EntityAnnotation(context, (ConflictAnnotations) semanticObject); 
					return; 
				}
				else break;
			case ProcessorDslPackage.CONSTANT:
				if(context == grammarAccess.getConstantRule()) {
					sequence_Constant(context, (Constant) semanticObject); 
					return; 
				}
				else break;
			case ProcessorDslPackage.CONSTANT_OPERATOR:
				if(context == grammarAccess.getConstantOperatorRule()) {
					sequence_ConstantOperator(context, (ConstantOperator) semanticObject); 
					return; 
				}
				else break;
			case ProcessorDslPackage.CONSTRUCTOR_ANNOTATIONS:
				if(context == grammarAccess.getEntityAnnotationRule()) {
					sequence_EntityAnnotation(context, (ConstructorAnnotations) semanticObject); 
					return; 
				}
				else break;
			case ProcessorDslPackage.DAO_DIRECTIVE_ABSTRACT:
				if(context == grammarAccess.getDaoDirectiveRule()) {
					sequence_DaoDirective(context, (DaoDirectiveAbstract) semanticObject); 
					return; 
				}
				else break;
			case ProcessorDslPackage.DAO_DIRECTIVE_DISCRIMINATOR:
				if(context == grammarAccess.getDaoDirectiveRule()) {
					sequence_DaoDirective(context, (DaoDirectiveDiscriminator) semanticObject); 
					return; 
				}
				else break;
			case ProcessorDslPackage.DAO_DIRECTIVE_EXTENDS:
				if(context == grammarAccess.getDaoDirectiveRule()) {
					sequence_DaoDirective(context, (DaoDirectiveExtends) semanticObject); 
					return; 
				}
				else break;
			case ProcessorDslPackage.DAO_DIRECTIVE_FINAL:
				if(context == grammarAccess.getDaoDirectiveRule()) {
					sequence_DaoDirective(context, (DaoDirectiveFinal) semanticObject); 
					return; 
				}
				else break;
			case ProcessorDslPackage.DAO_DIRECTIVE_FUNCTION:
				if(context == grammarAccess.getDaoDirectiveRule()) {
					sequence_DaoDirective(context, (DaoDirectiveFunction) semanticObject); 
					return; 
				}
				else break;
			case ProcessorDslPackage.DAO_DIRECTIVE_GENERICS:
				if(context == grammarAccess.getDaoDirectiveRule()) {
					sequence_DaoDirective(context, (DaoDirectiveGenerics) semanticObject); 
					return; 
				}
				else break;
			case ProcessorDslPackage.DAO_DIRECTIVE_POJO:
				if(context == grammarAccess.getDaoDirectiveRule()) {
					sequence_DaoDirective(context, (DaoDirectivePojo) semanticObject); 
					return; 
				}
				else break;
			case ProcessorDslPackage.DAO_DIRECTIVE_PROCEDURE:
				if(context == grammarAccess.getDaoDirectiveRule()) {
					sequence_DaoDirective(context, (DaoDirectiveProcedure) semanticObject); 
					return; 
				}
				else break;
			case ProcessorDslPackage.DAO_DIRECTIVE_SERIALIZABLE:
				if(context == grammarAccess.getDaoDirectiveRule()) {
					sequence_DaoDirective(context, (DaoDirectiveSerializable) semanticObject); 
					return; 
				}
				else break;
			case ProcessorDslPackage.DAO_DIRECTIVE_UPDATE:
				if(context == grammarAccess.getDaoDirectiveRule()) {
					sequence_DaoDirective(context, (DaoDirectiveUpdate) semanticObject); 
					return; 
				}
				else break;
			case ProcessorDslPackage.DAO_TYPE:
				if(context == grammarAccess.getDaoTypeRule()) {
					sequence_DaoType(context, (DaoType) semanticObject); 
					return; 
				}
				else break;
			case ProcessorDslPackage.DAOGEN_PROPERTY:
				if(context == grammarAccess.getDaogenPropertyRule()) {
					sequence_DaogenProperty(context, (DaogenProperty) semanticObject); 
					return; 
				}
				else break;
			case ProcessorDslPackage.DATABASE_CATALOG_ASSIGNEMENT:
				if(context == grammarAccess.getDatabaseCatalogAssignementRule()) {
					sequence_DatabaseCatalogAssignement(context, (DatabaseCatalogAssignement) semanticObject); 
					return; 
				}
				else break;
			case ProcessorDslPackage.DATABASE_COLUMN:
				if(context == grammarAccess.getDatabaseColumnRule()) {
					sequence_DatabaseColumn(context, (DatabaseColumn) semanticObject); 
					return; 
				}
				else break;
			case ProcessorDslPackage.DATABASE_META_INFO_ASSIGNEMENT:
				if(context == grammarAccess.getDatabaseMetaInfoAssignementRule()) {
					sequence_DatabaseMetaInfoAssignement(context, (DatabaseMetaInfoAssignement) semanticObject); 
					return; 
				}
				else break;
			case ProcessorDslPackage.DATABASE_PROPERTY:
				if(context == grammarAccess.getDatabasePropertyRule()) {
					sequence_DatabaseProperty(context, (DatabaseProperty) semanticObject); 
					return; 
				}
				else break;
			case ProcessorDslPackage.DATABASE_SCHEMA_ASSIGNEMENT:
				if(context == grammarAccess.getDatabaseSchemaAssignementRule()) {
					sequence_DatabaseSchemaAssignement(context, (DatabaseSchemaAssignement) semanticObject); 
					return; 
				}
				else break;
			case ProcessorDslPackage.DATABASE_TABLE:
				if(context == grammarAccess.getDatabaseTableRule()) {
					sequence_DatabaseTable(context, (DatabaseTable) semanticObject); 
					return; 
				}
				else break;
			case ProcessorDslPackage.DATABASE_TYPE_ASSIGNEMENT:
				if(context == grammarAccess.getDatabaseTypeAssignementRule()) {
					sequence_DatabaseTypeAssignement(context, (DatabaseTypeAssignement) semanticObject); 
					return; 
				}
				else break;
			case ProcessorDslPackage.DEBUG_LEVEL_ASSIGNEMENT:
				if(context == grammarAccess.getDebugLevelAssignementRule()) {
					sequence_DebugLevelAssignement(context, (DebugLevelAssignement) semanticObject); 
					return; 
				}
				else break;
			case ProcessorDslPackage.DIRECTIVE_PARAMETERS:
				if(context == grammarAccess.getDirectiveParametersRule()) {
					sequence_DirectiveParameters(context, (DirectiveParameters) semanticObject); 
					return; 
				}
				else break;
			case ProcessorDslPackage.DIRECTIVE_PROPERTIES:
				if(context == grammarAccess.getDirectivePropertiesRule()) {
					sequence_DirectiveProperties(context, (DirectiveProperties) semanticObject); 
					return; 
				}
				else break;
			case ProcessorDslPackage.DRIVER_META_INFO_ASSIGNEMENT:
				if(context == grammarAccess.getDriverMetaInfoAssignementRule()) {
					sequence_DriverMetaInfoAssignement(context, (DriverMetaInfoAssignement) semanticObject); 
					return; 
				}
				else break;
			case ProcessorDslPackage.DRIVER_METHOD_OUTPUT_ASSIGNEMENT:
				if(context == grammarAccess.getDriverMethodOutputAssignementRule()) {
					sequence_DriverMethodOutputAssignement(context, (DriverMethodOutputAssignement) semanticObject); 
					return; 
				}
				else break;
			case ProcessorDslPackage.ENUM_DIRECTIVE_EXTENDS:
				if(context == grammarAccess.getEnumDirectiveRule()) {
					sequence_EnumDirective(context, (EnumDirectiveExtends) semanticObject); 
					return; 
				}
				else break;
			case ProcessorDslPackage.ENUM_DIRECTIVE_FINAL:
				if(context == grammarAccess.getEnumDirectiveRule()) {
					sequence_EnumDirective(context, (EnumDirectiveFinal) semanticObject); 
					return; 
				}
				else break;
			case ProcessorDslPackage.ENUM_DIRECTIVE_SERIALIZABLE:
				if(context == grammarAccess.getEnumDirectiveRule()) {
					sequence_EnumDirective(context, (EnumDirectiveSerializable) semanticObject); 
					return; 
				}
				else break;
			case ProcessorDslPackage.ENUM_ENTITY:
				if(context == grammarAccess.getAbstractEntityRule() ||
				   context == grammarAccess.getEnumEntityRule()) {
					sequence_EnumEntity(context, (EnumEntity) semanticObject); 
					return; 
				}
				else break;
			case ProcessorDslPackage.ENUM_PROPERTY:
				if(context == grammarAccess.getEnumPropertyRule()) {
					sequence_EnumProperty(context, (EnumProperty) semanticObject); 
					return; 
				}
				else break;
			case ProcessorDslPackage.ENUM_PROPERTY_DIRECTIVE_VALUES:
				if(context == grammarAccess.getEnumPropertyDirectiveRule()) {
					sequence_EnumPropertyDirective(context, (EnumPropertyDirectiveValues) semanticObject); 
					return; 
				}
				else break;
			case ProcessorDslPackage.EXPORT_ASSIGNEMENT:
				if(context == grammarAccess.getExportAssignementRule()) {
					sequence_ExportAssignement(context, (ExportAssignement) semanticObject); 
					return; 
				}
				else break;
			case ProcessorDslPackage.EXTENDED_COLUMN:
				if(context == grammarAccess.getExtendedColumnRule()) {
					sequence_ExtendedColumn(context, (ExtendedColumn) semanticObject); 
					return; 
				}
				else break;
			case ProcessorDslPackage.EXTENDED_COLUMN_NAME:
				if(context == grammarAccess.getExtendedColumnNameRule()) {
					sequence_ExtendedColumnName(context, (ExtendedColumnName) semanticObject); 
					return; 
				}
				else break;
			case ProcessorDslPackage.EXTENDED_MAPPING_ITEM:
				if(context == grammarAccess.getExtendedMappingItemRule()) {
					sequence_ExtendedMappingItem(context, (ExtendedMappingItem) semanticObject); 
					return; 
				}
				else break;
			case ProcessorDslPackage.EXTENDS:
				if(context == grammarAccess.getAbstractEntityRule() ||
				   context == grammarAccess.getExtendsRule()) {
					sequence_Extends(context, (Extends) semanticObject); 
					return; 
				}
				else break;
			case ProcessorDslPackage.EXTENDS_ASSIGNEMENT:
				if(context == grammarAccess.getExtendsAssignementRule()) {
					sequence_ExtendsAssignement(context, (ExtendsAssignement) semanticObject); 
					return; 
				}
				else break;
			case ProcessorDslPackage.EXTENDS_ASSIGNEMENT_GENERICS:
				if(context == grammarAccess.getExtendsAssignementGenericsRule()) {
					sequence_ExtendsAssignementGenerics(context, (ExtendsAssignementGenerics) semanticObject); 
					return; 
				}
				else break;
			case ProcessorDslPackage.FUNCTION_DEFINITION:
				if(context == grammarAccess.getFunctionDefinitionRule()) {
					sequence_FunctionDefinition(context, (FunctionDefinition) semanticObject); 
					return; 
				}
				else break;
			case ProcessorDslPackage.FUNCTION_POJO_ASSIGNEMENT:
				if(context == grammarAccess.getFunctionPojoAssignementRule()) {
					sequence_FunctionPojoAssignement(context, (FunctionPojoAssignement) semanticObject); 
					return; 
				}
				else break;
			case ProcessorDslPackage.GETTER_ANNOTATIONS:
				if(context == grammarAccess.getPojoPropertyAnnotationRule()) {
					sequence_PojoPropertyAnnotation(context, (GetterAnnotations) semanticObject); 
					return; 
				}
				else break;
			case ProcessorDslPackage.IDENTIFIER:
				if(context == grammarAccess.getIdentifierRule()) {
					sequence_Identifier(context, (Identifier) semanticObject); 
					return; 
				}
				else break;
			case ProcessorDslPackage.IDENTIFIER_OPERATOR:
				if(context == grammarAccess.getIdentifierOperatorRule()) {
					sequence_IdentifierOperator(context, (IdentifierOperator) semanticObject); 
					return; 
				}
				else break;
			case ProcessorDslPackage.IF_META_SQL:
				if(context == grammarAccess.getIfMetaSqlRule()) {
					sequence_IfMetaSql(context, (IfMetaSql) semanticObject); 
					return; 
				}
				else break;
			case ProcessorDslPackage.IF_SQL:
				if(context == grammarAccess.getIfSqlRule()) {
					sequence_IfSql(context, (IfSql) semanticObject); 
					return; 
				}
				else break;
			case ProcessorDslPackage.IF_SQL_BOOL:
				if(context == grammarAccess.getIfSqlBoolRule()) {
					sequence_IfSqlBool(context, (IfSqlBool) semanticObject); 
					return; 
				}
				else break;
			case ProcessorDslPackage.IF_SQL_COND:
				if(context == grammarAccess.getIfSqlCondRule()) {
					sequence_IfSqlCond(context, (IfSqlCond) semanticObject); 
					return; 
				}
				else break;
			case ProcessorDslPackage.IF_SQL_FRAGMENT:
				if(context == grammarAccess.getIfSqlFragmentRule()) {
					sequence_IfSqlFragment(context, (IfSqlFragment) semanticObject); 
					return; 
				}
				else break;
			case ProcessorDslPackage.IMPL_PACKAGE:
				if(context == grammarAccess.getAbstractEntityRule() ||
				   context == grammarAccess.getImplPackageRule()) {
					sequence_ImplPackage(context, (ImplPackage) semanticObject); 
					return; 
				}
				else break;
			case ProcessorDslPackage.IMPLEMENTS:
				if(context == grammarAccess.getAbstractEntityRule() ||
				   context == grammarAccess.getImplementsRule()) {
					sequence_Implements(context, (Implements) semanticObject); 
					return; 
				}
				else break;
			case ProcessorDslPackage.IMPLEMENTS_ASSIGNEMENT:
				if(context == grammarAccess.getImplementsAssignementRule()) {
					sequence_ImplementsAssignement(context, (ImplementsAssignement) semanticObject); 
					return; 
				}
				else break;
			case ProcessorDslPackage.IMPLEMENTS_ASSIGNEMENT_GENERICS:
				if(context == grammarAccess.getImplementsAssignementGenericsRule()) {
					sequence_ImplementsAssignementGenerics(context, (ImplementsAssignementGenerics) semanticObject); 
					return; 
				}
				else break;
			case ProcessorDslPackage.IMPORT:
				if(context == grammarAccess.getAbstractEntityRule() ||
				   context == grammarAccess.getImportRule()) {
					sequence_Import(context, (Import) semanticObject); 
					return; 
				}
				else break;
			case ProcessorDslPackage.IMPORT_ASSIGNEMENT:
				if(context == grammarAccess.getImportAssignementRule()) {
					sequence_ImportAssignement(context, (ImportAssignement) semanticObject); 
					return; 
				}
				else break;
			case ProcessorDslPackage.INHERITANCE_ASSIGNEMENT:
				if(context == grammarAccess.getInheritanceAssignementRule()) {
					sequence_InheritanceAssignement(context, (InheritanceAssignement) semanticObject); 
					return; 
				}
				else break;
			case ProcessorDslPackage.JOIN_TABLE_ASSIGNEMENT:
				if(context == grammarAccess.getJoinTableAssignementRule()) {
					sequence_JoinTableAssignement(context, (JoinTableAssignement) semanticObject); 
					return; 
				}
				else break;
			case ProcessorDslPackage.MANY_TO_MANY_ASSIGNEMENT:
				if(context == grammarAccess.getManyToManyAssignementRule()) {
					sequence_ManyToManyAssignement(context, (ManyToManyAssignement) semanticObject); 
					return; 
				}
				else break;
			case ProcessorDslPackage.MAPPING:
				if(context == grammarAccess.getMappingRule()) {
					sequence_Mapping(context, (Mapping) semanticObject); 
					return; 
				}
				else break;
			case ProcessorDslPackage.MAPPING_COLUMN:
				if(context == grammarAccess.getMappingColumnRule()) {
					sequence_MappingColumn(context, (MappingColumn) semanticObject); 
					return; 
				}
				else break;
			case ProcessorDslPackage.MAPPING_COLUMN_NAME:
				if(context == grammarAccess.getMappingColumnNameRule()) {
					sequence_MappingColumnName(context, (MappingColumnName) semanticObject); 
					return; 
				}
				else break;
			case ProcessorDslPackage.MAPPING_ITEM:
				if(context == grammarAccess.getMappingItemRule()) {
					sequence_MappingItem(context, (MappingItem) semanticObject); 
					return; 
				}
				else break;
			case ProcessorDslPackage.MAPPING_RULE:
				if(context == grammarAccess.getMappingRuleRule()) {
					sequence_MappingRule(context, (MappingRule) semanticObject); 
					return; 
				}
				else break;
			case ProcessorDslPackage.META_SQL:
				if(context == grammarAccess.getMetaSqlRule()) {
					sequence_MetaSql(context, (MetaSql) semanticObject); 
					return; 
				}
				else break;
			case ProcessorDslPackage.META_STATEMENT:
				if(context == grammarAccess.getMetaStatementRule()) {
					sequence_MetaStatement(context, (MetaStatement) semanticObject); 
					return; 
				}
				else break;
			case ProcessorDslPackage.META_TYPE_ASSIGNEMENT:
				if(context == grammarAccess.getMetaTypeAssignementRule()) {
					sequence_MetaTypeAssignement(context, (MetaTypeAssignement) semanticObject); 
					return; 
				}
				else break;
			case ProcessorDslPackage.METAGEN_PROPERTY:
				if(context == grammarAccess.getMetagenPropertyRule()) {
					sequence_MetagenProperty(context, (MetagenProperty) semanticObject); 
					return; 
				}
				else break;
			case ProcessorDslPackage.OPTIONAL_FEATURE:
				if(context == grammarAccess.getOptionalFeatureRule()) {
					sequence_OptionalFeature(context, (OptionalFeature) semanticObject); 
					return; 
				}
				else break;
			case ProcessorDslPackage.ORD_SQL:
				if(context == grammarAccess.getOrdSqlRule()) {
					sequence_OrdSql(context, (OrdSql) semanticObject); 
					return; 
				}
				else break;
			case ProcessorDslPackage.ORD_SQL2:
				if(context == grammarAccess.getOrdSql2Rule()) {
					sequence_OrdSql2(context, (OrdSql2) semanticObject); 
					return; 
				}
				else break;
			case ProcessorDslPackage.PACKAGE_DECLARATION:
				if(context == grammarAccess.getAbstractEntityRule() ||
				   context == grammarAccess.getPackageDeclarationRule()) {
					sequence_PackageDeclaration(context, (PackageDeclaration) semanticObject); 
					return; 
				}
				else break;
			case ProcessorDslPackage.PACKAGE_DIRECTIVE_SUFFIX:
				if(context == grammarAccess.getPackageDirectiveRule()) {
					sequence_PackageDirective(context, (PackageDirectiveSuffix) semanticObject); 
					return; 
				}
				else break;
			case ProcessorDslPackage.POJO_DAO:
				if(context == grammarAccess.getAbstractEntityRule() ||
				   context == grammarAccess.getPojoDaoRule()) {
					sequence_PojoDao(context, (PojoDao) semanticObject); 
					return; 
				}
				else break;
			case ProcessorDslPackage.POJO_DEFINITION:
				if(context == grammarAccess.getPojoDefinitionRule()) {
					sequence_PojoDefinition(context, (PojoDefinition) semanticObject); 
					return; 
				}
				else break;
			case ProcessorDslPackage.POJO_DIRECTIVE_ABSTRACT:
				if(context == grammarAccess.getPojoDirectiveRule()) {
					sequence_PojoDirective(context, (PojoDirectiveAbstract) semanticObject); 
					return; 
				}
				else break;
			case ProcessorDslPackage.POJO_DIRECTIVE_DISCRIMINATOR:
				if(context == grammarAccess.getPojoDirectiveRule()) {
					sequence_PojoDirective(context, (PojoDirectiveDiscriminator) semanticObject); 
					return; 
				}
				else break;
			case ProcessorDslPackage.POJO_DIRECTIVE_EQUALS:
				if(context == grammarAccess.getPojoDirectiveRule()) {
					sequence_PojoDirective(context, (PojoDirectiveEquals) semanticObject); 
					return; 
				}
				else break;
			case ProcessorDslPackage.POJO_DIRECTIVE_EXTENDS:
				if(context == grammarAccess.getPojoDirectiveRule()) {
					sequence_PojoDirective(context, (PojoDirectiveExtends) semanticObject); 
					return; 
				}
				else break;
			case ProcessorDslPackage.POJO_DIRECTIVE_FINAL:
				if(context == grammarAccess.getPojoDirectiveRule()) {
					sequence_PojoDirective(context, (PojoDirectiveFinal) semanticObject); 
					return; 
				}
				else break;
			case ProcessorDslPackage.POJO_DIRECTIVE_HASH_CODE:
				if(context == grammarAccess.getPojoDirectiveRule()) {
					sequence_PojoDirective(context, (PojoDirectiveHashCode) semanticObject); 
					return; 
				}
				else break;
			case ProcessorDslPackage.POJO_DIRECTIVE_IS_DEF:
				if(context == grammarAccess.getPojoDirectiveRule()) {
					sequence_PojoDirective(context, (PojoDirectiveIsDef) semanticObject); 
					return; 
				}
				else break;
			case ProcessorDslPackage.POJO_DIRECTIVE_OPERATORS:
				if(context == grammarAccess.getPojoDirectiveRule()) {
					sequence_PojoDirective(context, (PojoDirectiveOperators) semanticObject); 
					return; 
				}
				else break;
			case ProcessorDslPackage.POJO_DIRECTIVE_SERIALIZABLE:
				if(context == grammarAccess.getPojoDirectiveRule()) {
					sequence_PojoDirective(context, (PojoDirectiveSerializable) semanticObject); 
					return; 
				}
				else break;
			case ProcessorDslPackage.POJO_DIRECTIVE_TO_INIT:
				if(context == grammarAccess.getPojoDirectiveRule()) {
					sequence_PojoDirective(context, (PojoDirectiveToInit) semanticObject); 
					return; 
				}
				else break;
			case ProcessorDslPackage.POJO_DIRECTIVE_TO_STRING:
				if(context == grammarAccess.getPojoDirectiveRule()) {
					sequence_PojoDirective(context, (PojoDirectiveToString) semanticObject); 
					return; 
				}
				else break;
			case ProcessorDslPackage.POJO_ENTITY:
				if(context == grammarAccess.getAbstractEntityRule() ||
				   context == grammarAccess.getPojoEntityRule()) {
					sequence_PojoEntity(context, (PojoEntity) semanticObject); 
					return; 
				}
				else break;
			case ProcessorDslPackage.POJO_PROPERTY:
				if(context == grammarAccess.getPojoPropertyRule()) {
					sequence_PojoProperty(context, (PojoProperty) semanticObject); 
					return; 
				}
				else break;
			case ProcessorDslPackage.POJO_PROPERTY_DIRECTIVE_CREATE_COL:
				if(context == grammarAccess.getPojoPropertyDirectiveRule()) {
					sequence_PojoPropertyDirective(context, (PojoPropertyDirectiveCreateCol) semanticObject); 
					return; 
				}
				else break;
			case ProcessorDslPackage.POJO_PROPERTY_DIRECTIVE_DISCRIMINATOR:
				if(context == grammarAccess.getPojoPropertyDirectiveRule()) {
					sequence_PojoPropertyDirective(context, (PojoPropertyDirectiveDiscriminator) semanticObject); 
					return; 
				}
				else break;
			case ProcessorDslPackage.POJO_PROPERTY_DIRECTIVE_INDEX:
				if(context == grammarAccess.getPojoPropertyDirectiveRule()) {
					sequence_PojoPropertyDirective(context, (PojoPropertyDirectiveIndex) semanticObject); 
					return; 
				}
				else break;
			case ProcessorDslPackage.POJO_PROPERTY_DIRECTIVE_PRIMARY_KEY:
				if(context == grammarAccess.getPojoPropertyDirectiveRule()) {
					sequence_PojoPropertyDirective(context, (PojoPropertyDirectivePrimaryKey) semanticObject); 
					return; 
				}
				else break;
			case ProcessorDslPackage.POJO_PROPERTY_DIRECTIVE_REQUIRED:
				if(context == grammarAccess.getPojoPropertyDirectiveRule()) {
					sequence_PojoPropertyDirective(context, (PojoPropertyDirectiveRequired) semanticObject); 
					return; 
				}
				else break;
			case ProcessorDslPackage.POJO_PROPERTY_DIRECTIVE_UPDATE_COL:
				if(context == grammarAccess.getPojoPropertyDirectiveRule()) {
					sequence_PojoPropertyDirective(context, (PojoPropertyDirectiveUpdateCol) semanticObject); 
					return; 
				}
				else break;
			case ProcessorDslPackage.POJO_PROPERTY_DIRECTIVE_VERSION:
				if(context == grammarAccess.getPojoPropertyDirectiveRule()) {
					sequence_PojoPropertyDirective(context, (PojoPropertyDirectiveVersion) semanticObject); 
					return; 
				}
				else break;
			case ProcessorDslPackage.POJO_TYPE:
				if(context == grammarAccess.getPojoTypeRule()) {
					sequence_PojoType(context, (PojoType) semanticObject); 
					return; 
				}
				else break;
			case ProcessorDslPackage.POJOGEN_PROPERTY:
				if(context == grammarAccess.getPojogenPropertyRule()) {
					sequence_PojogenProperty(context, (PojogenProperty) semanticObject); 
					return; 
				}
				else break;
			case ProcessorDslPackage.PROCEDURE_DEFINITION:
				if(context == grammarAccess.getProcedureDefinitionRule()) {
					sequence_ProcedureDefinition(context, (ProcedureDefinition) semanticObject); 
					return; 
				}
				else break;
			case ProcessorDslPackage.PROCEDURE_POJO_ASSIGNEMENT:
				if(context == grammarAccess.getProcedurePojoAssignementRule()) {
					sequence_ProcedurePojoAssignement(context, (ProcedurePojoAssignement) semanticObject); 
					return; 
				}
				else break;
			case ProcessorDslPackage.PROPERTY:
				if(context == grammarAccess.getPropertyRule()) {
					sequence_Property(context, (Property) semanticObject); 
					return; 
				}
				else break;
			case ProcessorDslPackage.SETTER_ANNOTATIONS:
				if(context == grammarAccess.getPojoPropertyAnnotationRule()) {
					sequence_PojoPropertyAnnotation(context, (SetterAnnotations) semanticObject); 
					return; 
				}
				else break;
			case ProcessorDslPackage.SHOW_COLUMN_TYPE_ASSIGNEMENT:
				if(context == grammarAccess.getShowColumnTypeAssignementRule()) {
					sequence_ShowColumnTypeAssignement(context, (ShowColumnTypeAssignement) semanticObject); 
					return; 
				}
				else break;
			case ProcessorDslPackage.SQL:
				if(context == grammarAccess.getSqlRule()) {
					sequence_Sql(context, (Sql) semanticObject); 
					return; 
				}
				else break;
			case ProcessorDslPackage.SQL_FRAGMENT:
				if(context == grammarAccess.getSqlFragmentRule()) {
					sequence_SqlFragment(context, (SqlFragment) semanticObject); 
					return; 
				}
				else break;
			case ProcessorDslPackage.SQL_TYPE_ASSIGNEMENT:
				if(context == grammarAccess.getSqlTypeAssignementRule()) {
					sequence_SqlTypeAssignement(context, (SqlTypeAssignement) semanticObject); 
					return; 
				}
				else break;
			case ProcessorDslPackage.STANDARD_ANNOTATION:
				if(context == grammarAccess.getEntityAnnotationRule()) {
					sequence_EntityAnnotation(context, (StandardAnnotation) semanticObject); 
					return; 
				}
				else break;
			case ProcessorDslPackage.STATIC_ANNOTATIONS:
				if(context == grammarAccess.getEntityAnnotationRule()) {
					sequence_EntityAnnotation(context, (StaticAnnotations) semanticObject); 
					return; 
				}
				else break;
			case ProcessorDslPackage.TABLE_ASSIGNEMENT:
				if(context == grammarAccess.getTableAssignementRule()) {
					sequence_TableAssignement(context, (TableAssignement) semanticObject); 
					return; 
				}
				else break;
			case ProcessorDslPackage.TABLE_DEFINITION:
				if(context == grammarAccess.getTableDefinitionRule()) {
					sequence_TableDefinition(context, (TableDefinition) semanticObject); 
					return; 
				}
				else break;
			}
		if (errorAcceptor != null) errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Constraint:
	 *     (name=IDENT (type=PojoType | number=NUMBER | value=STRING_VALUE | constant=IDENT))
	 */
	protected void sequence_AnnotationProperty(EObject context, AnnotationProperty semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (type=PojoType (features+=AnnotationProperty features+=AnnotationProperty*)?)
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
	 *             statements+=MetaStatement | 
	 *             mappings+=MappingRule | 
	 *             features+=OptionalFeature | 
	 *             pojoPackages+=PackageDeclaration
	 *         )*
	 *     )
	 */
	protected void sequence_Artifacts(EObject context, Artifacts semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (dbColumn=IDENT newName=IDENT)
	 */
	protected void sequence_ColumnAssignement(EObject context, ColumnAssignement semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, ProcessorDslPackage.Literals.COLUMN_ASSIGNEMENT__DB_COLUMN) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ProcessorDslPackage.Literals.COLUMN_ASSIGNEMENT__DB_COLUMN));
			if(transientValues.isValueTransient(semanticObject, ProcessorDslPackage.Literals.COLUMN_ASSIGNEMENT__NEW_NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ProcessorDslPackage.Literals.COLUMN_ASSIGNEMENT__NEW_NAME));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getColumnAssignementAccess().getDbColumnIDENTTerminalRuleCall_0_0(), semanticObject.getDbColumn());
		feeder.accept(grammarAccess.getColumnAssignementAccess().getNewNameIDENTTerminalRuleCall_2_0(), semanticObject.getNewName());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (dbColumn=IDENT type=PojoType)
	 */
	protected void sequence_ColumnTypeAssignement(EObject context, ColumnTypeAssignement semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, ProcessorDslPackage.Literals.COLUMN_TYPE_ASSIGNEMENT__DB_COLUMN) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ProcessorDslPackage.Literals.COLUMN_TYPE_ASSIGNEMENT__DB_COLUMN));
			if(transientValues.isValueTransient(semanticObject, ProcessorDslPackage.Literals.COLUMN_TYPE_ASSIGNEMENT__TYPE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ProcessorDslPackage.Literals.COLUMN_TYPE_ASSIGNEMENT__TYPE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getColumnTypeAssignementAccess().getDbColumnIDENTTerminalRuleCall_0_0(), semanticObject.getDbColumn());
		feeder.accept(grammarAccess.getColumnTypeAssignementAccess().getTypePojoTypeParserRuleCall_2_0(), semanticObject.getType());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (columns+=ExtendedColumn columns+=ExtendedColumn*)
	 */
	protected void sequence_Column(EObject context, Column semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=IDENT | name=EQUALS)
	 */
	protected void sequence_ConstantOperator(EObject context, ConstantOperator semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     ((case=PLUS | case=MINUS)? (name=IDENT | name=IDENT_DOT) (modifiers+=Modifier modifiers+=Modifier*)?)
	 */
	protected void sequence_Constant(EObject context, Constant semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     {DaoDirectiveAbstract}
	 */
	protected void sequence_DaoDirective(EObject context, DaoDirectiveAbstract semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (discriminator=IDENT | discriminator=NUMBER)
	 */
	protected void sequence_DaoDirective(EObject context, DaoDirectiveDiscriminator semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     superType=DaoType
	 */
	protected void sequence_DaoDirective(EObject context, DaoDirectiveExtends semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, ProcessorDslPackage.Literals.DAO_DIRECTIVE_EXTENDS__SUPER_TYPE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ProcessorDslPackage.Literals.DAO_DIRECTIVE_EXTENDS__SUPER_TYPE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getDaoDirectiveAccess().getSuperTypeDaoTypeParserRuleCall_2_3_0(), semanticObject.getSuperType());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     {DaoDirectiveFinal}
	 */
	protected void sequence_DaoDirective(EObject context, DaoDirectiveFinal semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     pojo=PojoType
	 */
	protected void sequence_DaoDirective(EObject context, DaoDirectiveFunction semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, ProcessorDslPackage.Literals.DAO_DIRECTIVE_FUNCTION__POJO) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ProcessorDslPackage.Literals.DAO_DIRECTIVE_FUNCTION__POJO));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getDaoDirectiveAccess().getPojoPojoTypeParserRuleCall_8_3_0(), semanticObject.getPojo());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     generics=PojoType
	 */
	protected void sequence_DaoDirective(EObject context, DaoDirectiveGenerics semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, ProcessorDslPackage.Literals.DAO_DIRECTIVE_GENERICS__GENERICS) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ProcessorDslPackage.Literals.DAO_DIRECTIVE_GENERICS__GENERICS));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getDaoDirectiveAccess().getGenericsPojoTypeParserRuleCall_6_3_0(), semanticObject.getGenerics());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     pojo=PojoType
	 */
	protected void sequence_DaoDirective(EObject context, DaoDirectivePojo semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, ProcessorDslPackage.Literals.DAO_DIRECTIVE_POJO__POJO) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ProcessorDslPackage.Literals.DAO_DIRECTIVE_POJO__POJO));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getDaoDirectiveAccess().getPojoPojoTypeParserRuleCall_5_3_0(), semanticObject.getPojo());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     pojo=PojoType
	 */
	protected void sequence_DaoDirective(EObject context, DaoDirectiveProcedure semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, ProcessorDslPackage.Literals.DAO_DIRECTIVE_PROCEDURE__POJO) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ProcessorDslPackage.Literals.DAO_DIRECTIVE_PROCEDURE__POJO));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getDaoDirectiveAccess().getPojoPojoTypeParserRuleCall_7_3_0(), semanticObject.getPojo());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     sernum=NUMBER
	 */
	protected void sequence_DaoDirective(EObject context, DaoDirectiveSerializable semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, ProcessorDslPackage.Literals.DAO_DIRECTIVE_SERIALIZABLE__SERNUM) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ProcessorDslPackage.Literals.DAO_DIRECTIVE_SERIALIZABLE__SERNUM));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getDaoDirectiveAccess().getSernumNUMBERTerminalRuleCall_4_3_0(), semanticObject.getSernum());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     ((paramlist=DirectiveParameters?) | (paramlist=DirectiveParameters?) | (paramlist=DirectiveParameters?))
	 */
	protected void sequence_DaoDirective(EObject context, DaoDirectiveUpdate semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     ((type=[JvmType|QualifiedName] | ref=[PojoDao|IDENT]) (gtype=[JvmType|QualifiedName] | gref=[PojoDao|IDENT])?)
	 */
	protected void sequence_DaoType(EObject context, DaoType semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         (name='ignore-tables' dbTables+=IDENT+) | 
	 *         (name='only-tables' dbTables+=IDENT*) | 
	 *         (name='implementation-package' implPackage=IDENT) | 
	 *         (name='implements-interfaces' toImplements=ImplementsAssignement) | 
	 *         (name='extends-class' toExtends=ExtendsAssignement) | 
	 *         (name='implements-interfaces-generics' toImplementsGenerics=ImplementsAssignementGenerics) | 
	 *         (name='extends-class-generics' toExtendsGenerics=ExtendsAssignementGenerics) | 
	 *         name='make-it-final' | 
	 *         (name='function-result' dbFunction=IDENT resultType=PojoType) | 
	 *         (name='debug-level' debug=DebugLevelAssignement) | 
	 *         (name='active-filter' activeFilter=PropertyValue) | 
	 *         (name='package' pckg=PropertyValue)
	 *     )
	 */
	protected void sequence_DaogenProperty(EObject context, DaogenProperty semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     dbCatalog=PropertyValue
	 */
	protected void sequence_DatabaseCatalogAssignement(EObject context, DatabaseCatalogAssignement semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, ProcessorDslPackage.Literals.DATABASE_CATALOG_ASSIGNEMENT__DB_CATALOG) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ProcessorDslPackage.Literals.DATABASE_CATALOG_ASSIGNEMENT__DB_CATALOG));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getDatabaseCatalogAssignementAccess().getDbCatalogPropertyValueParserRuleCall_0(), semanticObject.getDbCatalog());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (name=IDENT | name=IDENT_DOT)
	 */
	protected void sequence_DatabaseColumn(EObject context, DatabaseColumn semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     dbMetaInfo=PropertyValue
	 */
	protected void sequence_DatabaseMetaInfoAssignement(EObject context, DatabaseMetaInfoAssignement semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, ProcessorDslPackage.Literals.DATABASE_META_INFO_ASSIGNEMENT__DB_META_INFO) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ProcessorDslPackage.Literals.DATABASE_META_INFO_ASSIGNEMENT__DB_META_INFO));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getDatabaseMetaInfoAssignementAccess().getDbMetaInfoPropertyValueParserRuleCall_0(), semanticObject.getDbMetaInfo());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         name='is-online' | 
	 *         name='is-offline' | 
	 *         (name='has-url' dbUrl=PropertyValue) | 
	 *         (name='login-username' dbUsername=PropertyValue) | 
	 *         (name='login-password' dbPassword=PropertyValue) | 
	 *         (name='in-catalog' dbCatalog=DatabaseCatalogAssignement) | 
	 *         (name='active-schema' dbSchema=DatabaseSchemaAssignement) | 
	 *         (name='jdbc-driver' (dbDriverx=[JvmType|QualifiedName] | dbDriver=PropertyValue)) | 
	 *         (name='ddl-create' dbExecuteBefore=PropertyValue) | 
	 *         (name='ddl-drop' dbExecuteAfter=PropertyValue) | 
	 *         (name='index-types' dbIndexTypes=PropertyValue) | 
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
	 *     dbSchema=PropertyValue
	 */
	protected void sequence_DatabaseSchemaAssignement(EObject context, DatabaseSchemaAssignement semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, ProcessorDslPackage.Literals.DATABASE_SCHEMA_ASSIGNEMENT__DB_SCHEMA) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ProcessorDslPackage.Literals.DATABASE_SCHEMA_ASSIGNEMENT__DB_SCHEMA));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getDatabaseSchemaAssignementAccess().getDbSchemaPropertyValueParserRuleCall_0(), semanticObject.getDbSchema());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (name=IDENT | name=IDENT_DOT)
	 */
	protected void sequence_DatabaseTable(EObject context, DatabaseTable semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     dbType=IDENT
	 */
	protected void sequence_DatabaseTypeAssignement(EObject context, DatabaseTypeAssignement semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, ProcessorDslPackage.Literals.DATABASE_TYPE_ASSIGNEMENT__DB_TYPE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ProcessorDslPackage.Literals.DATABASE_TYPE_ASSIGNEMENT__DB_TYPE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getDatabaseTypeAssignementAccess().getDbTypeIDENTTerminalRuleCall_0(), semanticObject.getDbType());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (debug=IDENT scope=PropertyValue?)
	 */
	protected void sequence_DebugLevelAssignement(EObject context, DebugLevelAssignement semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (in=PojoType out=PojoType?)
	 */
	protected void sequence_DirectiveParameters(EObject context, DirectiveParameters semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (properties+=PojogenProperty properties+=PojogenProperty*)
	 */
	protected void sequence_DirectiveProperties(EObject context, DirectiveProperties semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     dbDriverInfo=PropertyValue
	 */
	protected void sequence_DriverMetaInfoAssignement(EObject context, DriverMetaInfoAssignement semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, ProcessorDslPackage.Literals.DRIVER_META_INFO_ASSIGNEMENT__DB_DRIVER_INFO) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ProcessorDslPackage.Literals.DRIVER_META_INFO_ASSIGNEMENT__DB_DRIVER_INFO));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getDriverMetaInfoAssignementAccess().getDbDriverInfoPropertyValueParserRuleCall_0(), semanticObject.getDbDriverInfo());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (driverMethod=IDENT callOutput=PropertyValue)
	 */
	protected void sequence_DriverMethodOutputAssignement(EObject context, DriverMethodOutputAssignement semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, ProcessorDslPackage.Literals.DRIVER_METHOD_OUTPUT_ASSIGNEMENT__DRIVER_METHOD) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ProcessorDslPackage.Literals.DRIVER_METHOD_OUTPUT_ASSIGNEMENT__DRIVER_METHOD));
			if(transientValues.isValueTransient(semanticObject, ProcessorDslPackage.Literals.DRIVER_METHOD_OUTPUT_ASSIGNEMENT__CALL_OUTPUT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ProcessorDslPackage.Literals.DRIVER_METHOD_OUTPUT_ASSIGNEMENT__CALL_OUTPUT));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getDriverMethodOutputAssignementAccess().getDriverMethodIDENTTerminalRuleCall_0_0(), semanticObject.getDriverMethod());
		feeder.accept(grammarAccess.getDriverMethodOutputAssignementAccess().getCallOutputPropertyValueParserRuleCall_2_0(), semanticObject.getCallOutput());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     annotation=Annotation
	 */
	protected void sequence_EntityAnnotation(EObject context, ConflictAnnotations semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, ProcessorDslPackage.Literals.ENTITY_ANNOTATION__ANNOTATION) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ProcessorDslPackage.Literals.ENTITY_ANNOTATION__ANNOTATION));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getEntityAnnotationAccess().getAnnotationAnnotationParserRuleCall_1_0_1_0_1_0_2_0(), semanticObject.getAnnotation());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     annotation=Annotation
	 */
	protected void sequence_EntityAnnotation(EObject context, ConstructorAnnotations semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, ProcessorDslPackage.Literals.ENTITY_ANNOTATION__ANNOTATION) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ProcessorDslPackage.Literals.ENTITY_ANNOTATION__ANNOTATION));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getEntityAnnotationAccess().getAnnotationAnnotationParserRuleCall_1_0_1_1_1_0(), semanticObject.getAnnotation());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     annotation=Annotation
	 */
	protected void sequence_EntityAnnotation(EObject context, StandardAnnotation semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, ProcessorDslPackage.Literals.ENTITY_ANNOTATION__ANNOTATION) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ProcessorDslPackage.Literals.ENTITY_ANNOTATION__ANNOTATION));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getEntityAnnotationAccess().getAnnotationAnnotationParserRuleCall_1_1_1_0(), semanticObject.getAnnotation());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     annotation=Annotation
	 */
	protected void sequence_EntityAnnotation(EObject context, StaticAnnotations semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, ProcessorDslPackage.Literals.ENTITY_ANNOTATION__ANNOTATION) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ProcessorDslPackage.Literals.ENTITY_ANNOTATION__ANNOTATION));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getEntityAnnotationAccess().getAnnotationAnnotationParserRuleCall_1_0_1_0_1_1_1_0(), semanticObject.getAnnotation());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     superType=PojoType
	 */
	protected void sequence_EnumDirective(EObject context, EnumDirectiveExtends semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, ProcessorDslPackage.Literals.ENUM_DIRECTIVE_EXTENDS__SUPER_TYPE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ProcessorDslPackage.Literals.ENUM_DIRECTIVE_EXTENDS__SUPER_TYPE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getEnumDirectiveAccess().getSuperTypePojoTypeParserRuleCall_1_3_0(), semanticObject.getSuperType());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     {EnumDirectiveFinal}
	 */
	protected void sequence_EnumDirective(EObject context, EnumDirectiveFinal semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     sernum=NUMBER
	 */
	protected void sequence_EnumDirective(EObject context, EnumDirectiveSerializable semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, ProcessorDslPackage.Literals.ENUM_DIRECTIVE_SERIALIZABLE__SERNUM) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ProcessorDslPackage.Literals.ENUM_DIRECTIVE_SERIALIZABLE__SERNUM));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getEnumDirectiveAccess().getSernumNUMBERTerminalRuleCall_2_3_0(), semanticObject.getSernum());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (annotations+=EntityAnnotation+ directives+=EnumDirective* name=IDENT features+=EnumProperty*)
	 */
	protected void sequence_EnumEntity(EObject context, EnumEntity semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (values+=NUMBER | values+=STRING_VALUE)
	 */
	protected void sequence_EnumPropertyDirective(EObject context, EnumPropertyDirectiveValues semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (directives+=EnumPropertyDirective name=IDENT type=PojoType)
	 */
	protected void sequence_EnumProperty(EObject context, EnumProperty semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (dbColumn=IDENT fkTable=IDENT fkColumn=IDENT?)
	 */
	protected void sequence_ExportAssignement(EObject context, ExportAssignement semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=IDENT | name=NUMBER | name=IDENT_DOT)
	 */
	protected void sequence_ExtendedColumnName(EObject context, ExtendedColumnName semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (col=ExtendedColumnName (modifiers+=Modifier modifiers+=Modifier*)?)
	 */
	protected void sequence_ExtendedColumn(EObject context, ExtendedColumn semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (attr=MappingColumnName (modifiers+=MappingItemModifier modifiers+=MappingItemModifier*)?)
	 */
	protected void sequence_ExtendedMappingItem(EObject context, ExtendedMappingItem semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (toExtends=[JvmType|QualifiedName] dbTables+=IDENT* dbNotTables+=IDENT*)
	 */
	protected void sequence_ExtendsAssignementGenerics(EObject context, ExtendsAssignementGenerics semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (toExtends=[JvmType|QualifiedName] dbTables+=IDENT* dbNotTables+=IDENT*)
	 */
	protected void sequence_ExtendsAssignement(EObject context, ExtendsAssignement semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         extends=PojoType 
	 *         generics?='<<>>'? 
	 *         onlyPojos+=[PojoEntity|IDENT]* 
	 *         onlyDaos+=[PojoDao|IDENT]* 
	 *         exceptPojos+=[PojoEntity|IDENT]* 
	 *         exceptDaos+=[PojoDao|IDENT]*
	 *     )
	 */
	protected void sequence_Extends(EObject context, Extends semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=IDENT table=IDENT)
	 */
	protected void sequence_FunctionDefinition(EObject context, FunctionDefinition semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, ProcessorDslPackage.Literals.FUNCTION_DEFINITION__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ProcessorDslPackage.Literals.FUNCTION_DEFINITION__NAME));
			if(transientValues.isValueTransient(semanticObject, ProcessorDslPackage.Literals.FUNCTION_DEFINITION__TABLE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ProcessorDslPackage.Literals.FUNCTION_DEFINITION__TABLE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getFunctionDefinitionAccess().getNameIDENTTerminalRuleCall_1_0(), semanticObject.getName());
		feeder.accept(grammarAccess.getFunctionDefinitionAccess().getTableIDENTTerminalRuleCall_2_0(), semanticObject.getTable());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (dbFunction=IDENT pojo=PojoType)
	 */
	protected void sequence_FunctionPojoAssignement(EObject context, FunctionPojoAssignement semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, ProcessorDslPackage.Literals.FUNCTION_POJO_ASSIGNEMENT__DB_FUNCTION) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ProcessorDslPackage.Literals.FUNCTION_POJO_ASSIGNEMENT__DB_FUNCTION));
			if(transientValues.isValueTransient(semanticObject, ProcessorDslPackage.Literals.FUNCTION_POJO_ASSIGNEMENT__POJO) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ProcessorDslPackage.Literals.FUNCTION_POJO_ASSIGNEMENT__POJO));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getFunctionPojoAssignementAccess().getDbFunctionIDENTTerminalRuleCall_0_0(), semanticObject.getDbFunction());
		feeder.accept(grammarAccess.getFunctionPojoAssignementAccess().getPojoPojoTypeParserRuleCall_2_0(), semanticObject.getPojo());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (name=IDENT | name=EQUALS)
	 */
	protected void sequence_IdentifierOperator(EObject context, IdentifierOperator semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         (mode=EQUALS | mode=LESS_THAN | mode=MORE_THAN)? 
	 *         (case=PLUS | case=MINUS)? 
	 *         (name=IDENT | name=NUMBER | name=IDENT_DOT) 
	 *         (modifiers+=Modifier modifiers+=Modifier*)?
	 *     )
	 */
	protected void sequence_Identifier(EObject context, Identifier semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         (ifs+=IfSql ifs+=IfSql*) | 
	 *         (type=QUESTI cond=IfSqlCond ifs+=IfSql ifs+=IfSql*) | 
	 *         (type=BAND ifs+=IfSql ifs+=IfSql*) | 
	 *         (type=BOR ifs+=IfSql ifs+=IfSql*)
	 *     )
	 */
	protected void sequence_IfMetaSql(EObject context, IfMetaSql semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     ((not?=NOT? cnst=Constant) | (not?=NOT? ident=Identifier) | (not?=NOT? cond=IfSqlCond))
	 */
	protected void sequence_IfSqlBool(EObject context, IfSqlBool semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (bool1=IfSqlBool ((oper+=AND | oper+=OR) bool2+=IfSqlBool)*)
	 */
	protected void sequence_IfSqlCond(EObject context, IfSqlCond semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         value=IfSqlValue | 
	 *         col=Column | 
	 *         cnst=Constant | 
	 *         ident=Identifier | 
	 *         cnstOper=ConstantOperator | 
	 *         identOper=IdentifierOperator | 
	 *         dbtab=DatabaseTable | 
	 *         dbcol=DatabaseColumn | 
	 *         meta=IfMetaSql
	 *     )
	 */
	protected void sequence_IfSqlFragment(EObject context, IfSqlFragment semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     sqls+=IfSqlFragment+
	 */
	protected void sequence_IfSql(EObject context, IfSql semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=IDENT | name=IDENT_DOT)
	 */
	protected void sequence_ImplPackage(EObject context, ImplPackage semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (toImplement=[JvmType|QualifiedName] dbTables+=IDENT* dbNotTables+=IDENT*)
	 */
	protected void sequence_ImplementsAssignementGenerics(EObject context, ImplementsAssignementGenerics semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (toImplement=[JvmType|QualifiedName] dbTables+=IDENT* dbNotTables+=IDENT*)
	 */
	protected void sequence_ImplementsAssignement(EObject context, ImplementsAssignement semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         implements=PojoType 
	 *         generics?='<<>>'? 
	 *         onlyPojos+=[PojoEntity|IDENT]* 
	 *         onlyDaos+=[PojoDao|IDENT]* 
	 *         exceptPojos+=[PojoEntity|IDENT]* 
	 *         exceptDaos+=[PojoDao|IDENT]*
	 *     )
	 */
	protected void sequence_Implements(EObject context, Implements semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (dbColumn=IDENT pkTable=IDENT pkColumn=IDENT?)
	 */
	protected void sequence_ImportAssignement(EObject context, ImportAssignement semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     importedNamespace=QualifiedNameWithWildcard
	 */
	protected void sequence_Import(EObject context, Import semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, ProcessorDslPackage.Literals.IMPORT__IMPORTED_NAMESPACE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ProcessorDslPackage.Literals.IMPORT__IMPORTED_NAMESPACE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getImportAccess().getImportedNamespaceQualifiedNameWithWildcardParserRuleCall_1_0(), semanticObject.getImportedNamespace());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (discriminator=IDENT dbTable=IDENT dbColumns+=IDENT+)
	 */
	protected void sequence_InheritanceAssignement(EObject context, InheritanceAssignement semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (dbTable=IDENT dbTables+=IDENT+)
	 */
	protected void sequence_JoinTableAssignement(EObject context, JoinTableAssignement semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (pkColumn=IDENT pkTable=IDENT fkColumn=IDENT?)
	 */
	protected void sequence_ManyToManyAssignement(EObject context, ManyToManyAssignement semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=IDENT | name=IDENT_DOT | name=NUMBER)
	 */
	protected void sequence_MappingColumnName(EObject context, MappingColumnName semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (items+=ExtendedMappingItem items+=ExtendedMappingItem*)
	 */
	protected void sequence_MappingColumn(EObject context, MappingColumn semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     ((name=IDENT | name=NUMBER) attr=MappingColumn?)
	 */
	protected void sequence_MappingItem(EObject context, MappingItem semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=IDENT type=MAPPING_TYPE modifiers+=MappingRuleModifier* mapping=Mapping)
	 */
	protected void sequence_MappingRule(EObject context, MappingRule semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (mappingItems+=MappingItem mappingItems+=MappingItem*)
	 */
	protected void sequence_Mapping(EObject context, Mapping semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         (ifs+=IfSql ifs+=IfSql*) | 
	 *         (type=QUESTI cond=IfSqlCond ifs+=IfSql ifs+=IfSql*) | 
	 *         (type=BAND ifs+=IfSql ifs+=IfSql*) | 
	 *         (type=BOR ifs+=IfSql ifs+=IfSql*) | 
	 *         (type=EQUALS ftype=IDENT ifs+=IfSql) | 
	 *         (type=HASH ord=OrdSql)
	 *     )
	 */
	protected void sequence_MetaSql(EObject context, MetaSql semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=IDENT type=STATEMENT_TYPE modifiers+=StatementModifier* statement=Sql)
	 */
	protected void sequence_MetaStatement(EObject context, MetaStatement semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (dbColumn=IDENT type=IDENT extension=IDENT?)
	 */
	protected void sequence_MetaTypeAssignement(EObject context, MetaTypeAssignement semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         (name='global-sequence' sequence=IDENT type=IDENT? dbTables+=IDENT* dbNotTables+=IDENT*) | 
	 *         (name='table-sequence' dbTable=IDENT sequence=IDENT type=IDENT?) | 
	 *         (name='global-identity' (identity=IDENT type=IDENT?)? dbTables+=IDENT* dbNotTables+=IDENT*) | 
	 *         (name='table-identity' dbTable=IDENT identity=IDENT type=IDENT?) | 
	 *         (name='column-meta-type' dbTable=IDENT metaTypes+=MetaTypeAssignement+) | 
	 *         (name='statement-meta-type' dbStatement=IDENT metaTypes+=MetaTypeAssignement+) | 
	 *         name='make-it-final' | 
	 *         (name='like-columns' (dbTable=IDENT dbColumns+=IDENT+)?) | 
	 *         (name='not-like-columns' (dbTable=IDENT dbColumns+=IDENT+)?) | 
	 *         name='generate-sequences' | 
	 *         name='generate-identities' | 
	 *         name='generate-idgenerators' | 
	 *         name='generate-default-idgenerators' | 
	 *         (name='function-result' dbFunction=IDENT type=IDENT) | 
	 *         (name='function-result-set' dbFunction=IDENT dbTable=IDENT) | 
	 *         (name='procedure-result-set' dbProcedure=IDENT dbTable=IDENT) | 
	 *         (name='debug-level' debug=DebugLevelAssignement) | 
	 *         name='generate-operators' | 
	 *         (name='optimize-insert' dbTables+=IDENT*) | 
	 *         (name='optional-features' dbStatement=IDENT optionalFeatures+=IDENT+) | 
	 *         (name='active-filter' activeFilter=PropertyValue)
	 *     )
	 */
	protected void sequence_MetagenProperty(EObject context, MetagenProperty semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=IDENT type=OPTION_TYPE modifiers+=OptionalFeatureModifier* option=FeatureValue)
	 */
	protected void sequence_OptionalFeature(EObject context, OptionalFeature semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (value=OrdSqlValue | cnst=Constant | ident=Identifier | dbcol=DatabaseColumn)
	 */
	protected void sequence_OrdSql2(EObject context, OrdSql2 semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     sqls+=OrdSql2+
	 */
	protected void sequence_OrdSql(EObject context, OrdSql semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (directives+=PackageDirective (name=IDENT | name=IDENT_DOT) elements+=AbstractEntity*)
	 */
	protected void sequence_PackageDeclaration(EObject context, PackageDeclaration semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (suffix=IDENT | suffix=NUMBER)
	 */
	protected void sequence_PackageDirective(EObject context, PackageDirectiveSuffix semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (directives+=DaoDirective* name=IDENT)
	 */
	protected void sequence_PojoDao(EObject context, PojoDao semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=IDENT (class=IDENT | class=IDENT_DOT | classx=[JvmType|QualifiedName]))
	 */
	protected void sequence_PojoDefinition(EObject context, PojoDefinition semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     {PojoDirectiveAbstract}
	 */
	protected void sequence_PojoDirective(EObject context, PojoDirectiveAbstract semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (discriminator=IDENT | discriminator=NUMBER)
	 */
	protected void sequence_PojoDirective(EObject context, PojoDirectiveDiscriminator semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (proplist=DirectiveProperties?)
	 */
	protected void sequence_PojoDirective(EObject context, PojoDirectiveEquals semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     superType=PojoType
	 */
	protected void sequence_PojoDirective(EObject context, PojoDirectiveExtends semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, ProcessorDslPackage.Literals.POJO_DIRECTIVE_EXTENDS__SUPER_TYPE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ProcessorDslPackage.Literals.POJO_DIRECTIVE_EXTENDS__SUPER_TYPE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getPojoDirectiveAccess().getSuperTypePojoTypeParserRuleCall_2_3_0(), semanticObject.getSuperType());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     {PojoDirectiveFinal}
	 */
	protected void sequence_PojoDirective(EObject context, PojoDirectiveFinal semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (proplist=DirectiveProperties?)
	 */
	protected void sequence_PojoDirective(EObject context, PojoDirectiveHashCode semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (proplist=DirectiveProperties?)
	 */
	protected void sequence_PojoDirective(EObject context, PojoDirectiveIsDef semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (operatorsSuffix=IDENT?)
	 */
	protected void sequence_PojoDirective(EObject context, PojoDirectiveOperators semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     sernum=NUMBER
	 */
	protected void sequence_PojoDirective(EObject context, PojoDirectiveSerializable semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, ProcessorDslPackage.Literals.POJO_DIRECTIVE_SERIALIZABLE__SERNUM) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ProcessorDslPackage.Literals.POJO_DIRECTIVE_SERIALIZABLE__SERNUM));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getPojoDirectiveAccess().getSernumNUMBERTerminalRuleCall_5_3_0(), semanticObject.getSernum());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (proplist=DirectiveProperties?)
	 */
	protected void sequence_PojoDirective(EObject context, PojoDirectiveToInit semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (proplist=DirectiveProperties?)
	 */
	protected void sequence_PojoDirective(EObject context, PojoDirectiveToString semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (annotations+=EntityAnnotation+ directives+=PojoDirective* name=IDENT features+=PojoProperty*)
	 */
	protected void sequence_PojoEntity(EObject context, PojoEntity semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     annotation=Annotation
	 */
	protected void sequence_PojoPropertyAnnotation(EObject context, AttributeAnnotations semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, ProcessorDslPackage.Literals.POJO_PROPERTY_ANNOTATION__ANNOTATION) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ProcessorDslPackage.Literals.POJO_PROPERTY_ANNOTATION__ANNOTATION));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getPojoPropertyAnnotationAccess().getAnnotationAnnotationParserRuleCall_1_1_1_0(), semanticObject.getAnnotation());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     annotation=Annotation
	 */
	protected void sequence_PojoPropertyAnnotation(EObject context, GetterAnnotations semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, ProcessorDslPackage.Literals.POJO_PROPERTY_ANNOTATION__ANNOTATION) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ProcessorDslPackage.Literals.POJO_PROPERTY_ANNOTATION__ANNOTATION));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getPojoPropertyAnnotationAccess().getAnnotationAnnotationParserRuleCall_1_0_1_1_1_0(), semanticObject.getAnnotation());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     annotation=Annotation
	 */
	protected void sequence_PojoPropertyAnnotation(EObject context, SetterAnnotations semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, ProcessorDslPackage.Literals.POJO_PROPERTY_ANNOTATION__ANNOTATION) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ProcessorDslPackage.Literals.POJO_PROPERTY_ANNOTATION__ANNOTATION));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getPojoPropertyAnnotationAccess().getAnnotationAnnotationParserRuleCall_1_0_1_0_2_0(), semanticObject.getAnnotation());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (createColumn1=IDENT createColumn2=IDENT)
	 */
	protected void sequence_PojoPropertyDirective(EObject context, PojoPropertyDirectiveCreateCol semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, ProcessorDslPackage.Literals.POJO_PROPERTY_DIRECTIVE_CREATE_COL__CREATE_COLUMN1) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ProcessorDslPackage.Literals.POJO_PROPERTY_DIRECTIVE_CREATE_COL__CREATE_COLUMN1));
			if(transientValues.isValueTransient(semanticObject, ProcessorDslPackage.Literals.POJO_PROPERTY_DIRECTIVE_CREATE_COL__CREATE_COLUMN2) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ProcessorDslPackage.Literals.POJO_PROPERTY_DIRECTIVE_CREATE_COL__CREATE_COLUMN2));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getPojoPropertyDirectiveAccess().getCreateColumn1IDENTTerminalRuleCall_6_3_0(), semanticObject.getCreateColumn1());
		feeder.accept(grammarAccess.getPojoPropertyDirectiveAccess().getCreateColumn2IDENTTerminalRuleCall_6_5_0(), semanticObject.getCreateColumn2());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (discriminator=IDENT | discriminator=NUMBER)
	 */
	protected void sequence_PojoPropertyDirective(EObject context, PojoPropertyDirectiveDiscriminator semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     index=NUMBER
	 */
	protected void sequence_PojoPropertyDirective(EObject context, PojoPropertyDirectiveIndex semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, ProcessorDslPackage.Literals.POJO_PROPERTY_DIRECTIVE_INDEX__INDEX) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ProcessorDslPackage.Literals.POJO_PROPERTY_DIRECTIVE_INDEX__INDEX));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getPojoPropertyDirectiveAccess().getIndexNUMBERTerminalRuleCall_3_3_0(), semanticObject.getIndex());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     {PojoPropertyDirectivePrimaryKey}
	 */
	protected void sequence_PojoPropertyDirective(EObject context, PojoPropertyDirectivePrimaryKey semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     {PojoPropertyDirectiveRequired}
	 */
	protected void sequence_PojoPropertyDirective(EObject context, PojoPropertyDirectiveRequired semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (updateColumn1=IDENT updateColumn2=IDENT)
	 */
	protected void sequence_PojoPropertyDirective(EObject context, PojoPropertyDirectiveUpdateCol semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, ProcessorDslPackage.Literals.POJO_PROPERTY_DIRECTIVE_UPDATE_COL__UPDATE_COLUMN1) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ProcessorDslPackage.Literals.POJO_PROPERTY_DIRECTIVE_UPDATE_COL__UPDATE_COLUMN1));
			if(transientValues.isValueTransient(semanticObject, ProcessorDslPackage.Literals.POJO_PROPERTY_DIRECTIVE_UPDATE_COL__UPDATE_COLUMN2) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ProcessorDslPackage.Literals.POJO_PROPERTY_DIRECTIVE_UPDATE_COL__UPDATE_COLUMN2));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getPojoPropertyDirectiveAccess().getUpdateColumn1IDENTTerminalRuleCall_5_3_0(), semanticObject.getUpdateColumn1());
		feeder.accept(grammarAccess.getPojoPropertyDirectiveAccess().getUpdateColumn2IDENTTerminalRuleCall_5_5_0(), semanticObject.getUpdateColumn2());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     {PojoPropertyDirectiveVersion}
	 */
	protected void sequence_PojoPropertyDirective(EObject context, PojoPropertyDirectiveVersion semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (annotations+=PojoPropertyAnnotation directives+=PojoPropertyDirective* name=IDENT type=PojoType)
	 */
	protected void sequence_PojoProperty(EObject context, PojoProperty semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     ((type=[JvmType|QualifiedName] | ref=[PojoEntity|IDENT]) (gtype=[JvmType|QualifiedName] | gref=[PojoEntity|IDENT])? array?='[]'?)
	 */
	protected void sequence_PojoType(EObject context, PojoType semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         (name='types-sqltypes' sqlTypes+=SqlTypeAssignement+) | 
	 *         (name='types-in-table' dbTable=IDENT sqlTypes+=SqlTypeAssignement+) | 
	 *         (name='types-for-columns' dbTable=IDENT columnTypes+=ColumnTypeAssignement+) | 
	 *         (name='types-for-procedure' dbProcedure=IDENT columnTypes+=ColumnTypeAssignement+) | 
	 *         (name='types-for-function' dbFunction=IDENT columnTypes+=ColumnTypeAssignement+) | 
	 *         (name='show-type-for-column' dbTable=IDENT columnType=ShowColumnTypeAssignement) | 
	 *         (name='show-type-for-procedure' dbProcedure=IDENT columnType=ShowColumnTypeAssignement) | 
	 *         (name='show-type-for-function' dbFunction=IDENT columnType=ShowColumnTypeAssignement) | 
	 *         (name='ignore-tables' dbTables+=IDENT+) | 
	 *         (name='only-tables' dbTables+=IDENT+) | 
	 *         (name='not-abstract-tables' dbTables+=IDENT+) | 
	 *         (name='join-tables' joinTables+=JoinTableAssignement+) | 
	 *         (name='ignore-columns' dbTable=IDENT dbColumns+=IDENT+) | 
	 *         (name='required-columns' dbTable=IDENT dbColumns+=IDENT+) | 
	 *         (name='not-required-columns' dbTable=IDENT dbColumns+=IDENT+) | 
	 *         (name='create-columns' dbTable=IDENT columnTypes+=ColumnTypeAssignement+) | 
	 *         (name='rename-tables' tables+=TableAssignement+) | 
	 *         (name='rename-columns' dbTable=IDENT columns+=ColumnAssignement+) | 
	 *         (name='ignore-one-to-many' dbTable=IDENT exports+=ExportAssignement+) | 
	 *         (name='ignore-many-to-one' dbTable=IDENT imports+=ImportAssignement+) | 
	 *         (name='inherit-many-to-one' dbTable=IDENT imports+=ImportAssignement+) | 
	 *         (name='create-one-to-many' dbTable=IDENT exports+=ExportAssignement+) | 
	 *         (name='create-many-to-one' dbTable=IDENT imports+=ImportAssignement+) | 
	 *         (name='table-many-to-many' dbTable=IDENT many2s+=ManyToManyAssignement+) | 
	 *         (name='inherit-discriminator' dbTable=IDENT dbColumn=IDENT inheritance+=InheritanceAssignement+) | 
	 *         (name='generate-methods' methods+=IDENT+) | 
	 *         (name='generate-operators' operatorsSuffix=IDENT?) | 
	 *         (name='implements-interfaces' toImplements=ImplementsAssignement) | 
	 *         (name='extends-class' toExtends=ExtendsAssignement) | 
	 *         (name='implements-interfaces-generics' toImplementsGenerics=ImplementsAssignementGenerics) | 
	 *         (name='extends-class-generics' toExtendsGenerics=ExtendsAssignementGenerics) | 
	 *         name='generate-wrappers' | 
	 *         name='generate-validation-annotations' | 
	 *         (name='preserve-foreign-keys' dbTables+=IDENT*) | 
	 *         (name='implementation-package' implPackage=IDENT) | 
	 *         name='make-it-final' | 
	 *         (name='version-column' version=IDENT dbTables+=IDENT* dbNotTables+=IDENT*) | 
	 *         (name='debug-level' debug=DebugLevelAssignement) | 
	 *         (name='pojos-for-procedures' procPojos+=ProcedurePojoAssignement+) | 
	 *         (name='pojos-for-functions' funPojos+=FunctionPojoAssignement+) | 
	 *         (name='active-filter' activeFilter=PropertyValue) | 
	 *         (name='package' pckg=PropertyValue) | 
	 *         (name='enum-for-check-constraints' enumName=IDENT dbCheckConstraints+=IDENT+)
	 *     )
	 */
	protected void sequence_PojogenProperty(EObject context, PojogenProperty semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=IDENT table=IDENT)
	 */
	protected void sequence_ProcedureDefinition(EObject context, ProcedureDefinition semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, ProcessorDslPackage.Literals.PROCEDURE_DEFINITION__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ProcessorDslPackage.Literals.PROCEDURE_DEFINITION__NAME));
			if(transientValues.isValueTransient(semanticObject, ProcessorDslPackage.Literals.PROCEDURE_DEFINITION__TABLE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ProcessorDslPackage.Literals.PROCEDURE_DEFINITION__TABLE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getProcedureDefinitionAccess().getNameIDENTTerminalRuleCall_1_0(), semanticObject.getName());
		feeder.accept(grammarAccess.getProcedureDefinitionAccess().getTableIDENTTerminalRuleCall_2_0(), semanticObject.getTable());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (dbProcedure=IDENT pojo=PojoType)
	 */
	protected void sequence_ProcedurePojoAssignement(EObject context, ProcedurePojoAssignement semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, ProcessorDslPackage.Literals.PROCEDURE_POJO_ASSIGNEMENT__DB_PROCEDURE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ProcessorDslPackage.Literals.PROCEDURE_POJO_ASSIGNEMENT__DB_PROCEDURE));
			if(transientValues.isValueTransient(semanticObject, ProcessorDslPackage.Literals.PROCEDURE_POJO_ASSIGNEMENT__POJO) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ProcessorDslPackage.Literals.PROCEDURE_POJO_ASSIGNEMENT__POJO));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getProcedurePojoAssignementAccess().getDbProcedureIDENTTerminalRuleCall_0_0(), semanticObject.getDbProcedure());
		feeder.accept(grammarAccess.getProcedurePojoAssignementAccess().getPojoPojoTypeParserRuleCall_2_0(), semanticObject.getPojo());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         name='resolve-pojo-on' | 
	 *         name='resolve-pojo-off' | 
	 *         (name='database-' database=DatabaseProperty) | 
	 *         (name='pojogen-' pojogen=PojogenProperty) | 
	 *         (name='metagen-' metagen=MetagenProperty) | 
	 *         (name='daogen-' daogen=DaogenProperty) | 
	 *         (name='replace-all-regex' replaceId=IDENT regex=PropertyValue) | 
	 *         (name='replace-all-replacement' replaceId=IDENT replacement=PropertyValue)
	 *     )
	 */
	protected void sequence_Property(EObject context, Property semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (dbColumn=IDENT type=PropertyValue)
	 */
	protected void sequence_ShowColumnTypeAssignement(EObject context, ShowColumnTypeAssignement semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, ProcessorDslPackage.Literals.SHOW_COLUMN_TYPE_ASSIGNEMENT__DB_COLUMN) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ProcessorDslPackage.Literals.SHOW_COLUMN_TYPE_ASSIGNEMENT__DB_COLUMN));
			if(transientValues.isValueTransient(semanticObject, ProcessorDslPackage.Literals.SHOW_COLUMN_TYPE_ASSIGNEMENT__TYPE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ProcessorDslPackage.Literals.SHOW_COLUMN_TYPE_ASSIGNEMENT__TYPE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getShowColumnTypeAssignementAccess().getDbColumnIDENTTerminalRuleCall_0_0(), semanticObject.getDbColumn());
		feeder.accept(grammarAccess.getShowColumnTypeAssignementAccess().getTypePropertyValueParserRuleCall_2_0(), semanticObject.getType());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         value=SqlValue | 
	 *         col=Column | 
	 *         cnst=Constant | 
	 *         ident=Identifier | 
	 *         cnstOper=ConstantOperator | 
	 *         identOper=IdentifierOperator | 
	 *         meta=MetaSql | 
	 *         dbtab=DatabaseTable | 
	 *         dbcol=DatabaseColumn
	 *     )
	 */
	protected void sequence_SqlFragment(EObject context, SqlFragment semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (typeName=IDENT size=NUMBER? type=PojoType)
	 */
	protected void sequence_SqlTypeAssignement(EObject context, SqlTypeAssignement semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     sqls+=SqlFragment+
	 */
	protected void sequence_Sql(EObject context, Sql semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (dbTable=IDENT newName=IDENT)
	 */
	protected void sequence_TableAssignement(EObject context, TableAssignement semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, ProcessorDslPackage.Literals.TABLE_ASSIGNEMENT__DB_TABLE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ProcessorDslPackage.Literals.TABLE_ASSIGNEMENT__DB_TABLE));
			if(transientValues.isValueTransient(semanticObject, ProcessorDslPackage.Literals.TABLE_ASSIGNEMENT__NEW_NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ProcessorDslPackage.Literals.TABLE_ASSIGNEMENT__NEW_NAME));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getTableAssignementAccess().getDbTableIDENTTerminalRuleCall_0_0(), semanticObject.getDbTable());
		feeder.accept(grammarAccess.getTableAssignementAccess().getNewNameIDENTTerminalRuleCall_2_0(), semanticObject.getNewName());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (name=IDENT table=IDENT)
	 */
	protected void sequence_TableDefinition(EObject context, TableDefinition semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, ProcessorDslPackage.Literals.TABLE_DEFINITION__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ProcessorDslPackage.Literals.TABLE_DEFINITION__NAME));
			if(transientValues.isValueTransient(semanticObject, ProcessorDslPackage.Literals.TABLE_DEFINITION__TABLE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ProcessorDslPackage.Literals.TABLE_DEFINITION__TABLE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getTableDefinitionAccess().getNameIDENTTerminalRuleCall_1_0(), semanticObject.getName());
		feeder.accept(grammarAccess.getTableDefinitionAccess().getTableIDENTTerminalRuleCall_2_0(), semanticObject.getTable());
		feeder.finish();
	}
}
