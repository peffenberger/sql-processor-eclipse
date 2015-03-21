/*
 * generated by Xtext
 */
package org.sqlproc.model.ui.contentassist

import static org.sqlproc.plugin.lib.util.Constants.*

import java.lang.reflect.ParameterizedType
import java.util.Collection
import java.util.List
import java.util.Set

import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.xtext.Assignment
import org.eclipse.xtext.RuleCall
import org.eclipse.xtext.naming.IQualifiedNameConverter
import org.eclipse.xtext.scoping.IScope
import org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext
import org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalAcceptor
import org.sqlproc.model.processorModel.AnnotatedEntity
import org.sqlproc.model.processorModel.Artifacts
import org.sqlproc.model.processorModel.DatabaseProperty
import org.sqlproc.model.processorModel.DriverMethodOutputAssignement
import org.sqlproc.model.processorModel.Entity
import org.sqlproc.model.processorModel.ExportAssignement
import org.sqlproc.model.processorModel.ImportAssignement
import org.sqlproc.model.processorModel.InheritanceAssignement
import org.sqlproc.model.processorModel.ManyToManyAssignement
import org.sqlproc.model.processorModel.MetagenProperty
import org.sqlproc.model.processorModel.Package
import org.sqlproc.model.processorModel.PojoDefinition
import org.sqlproc.model.processorModel.PojoEntity
import org.sqlproc.model.processorModel.PojogenProperty
import org.sqlproc.model.processorModel.ProcessorModelPackage
import org.sqlproc.model.processorModel.ShowColumnTypeAssignement
import org.sqlproc.model.processorModel.TableDefinition
import org.sqlproc.model.processorModel.Property
import org.sqlproc.model.util.Utils
import org.sqlproc.plugin.lib.resolver.DbResolver.DbType

import com.google.inject.Inject

import static extension org.eclipse.xtext.EcoreUtil2.*
//import org.sqlproc.model.generator.ProcessorGeneratorUtils
import org.sqlproc.model.processorModel.DirectiveProperties
import org.sqlproc.model.processorModel.PojoDirective
import java.util.TreeMap
import org.eclipse.xtext.CrossReference
import org.eclipse.emf.common.util.URI
import org.sqlproc.plugin.lib.resolver.PojoResolver
import org.sqlproc.plugin.lib.resolver.DbResolver

/**
 * see http://www.eclipse.org/Xtext/documentation.html#contentAssist on how to customize content assistant
 */
class ProcessorModelProposalProvider extends AbstractProcessorModelProposalProvider {

	@Inject
	PojoResolver pojoResolver

	@Inject
	DbResolver dbResolver

	@Inject
	IQualifiedNameConverter qualifiedNameConverter

	//@Inject extension ProcessorGeneratorUtils

	val DEBUG_LEVELS = <String>newArrayList("DEBUG", "INFO", "FATAL", "ERROR", "WARN", "TRACE")

	def addProposalList(List<String> values, String lexerRule, ContentAssistContext context,
		ICompletionProposalAcceptor acceptor, String prefix) {
		values?.forEach [ value |
			val proposal = getValueConverter().toString((prefix ?: "") + value, lexerRule)
			acceptor.accept(createCompletionProposal(proposal, context))
		]
	}

	def append(StringBuilder sb, String s) {
		if (sb.length > 0)
			sb.append(".")
		sb.append(s)
	}

	def boolean isResolvePojo(EObject model) {
		pojoResolver.isResolvePojo(model)

	}

	def boolean isResolveDb(EObject model) {
		dbResolver.isResolveDb(model)
	}

	def getClass(PojoDefinition pojo) {
		return if(pojo.getClassx() != null) pojo.getClassx().getQualifiedName() else pojo.getClass_()
	}

	def isPrimitive(Class<?> clazz) {
		if (clazz == null)
			return true
		if (clazz == typeof(String))
			return true
		if (clazz == typeof(java.util.Date))
			return true
		if (clazz == typeof(java.sql.Date))
			return true
		if (clazz == typeof(java.sql.Time))
			return true
		if (clazz == typeof(java.sql.Timestamp))
			return true
		if (clazz == typeof(java.sql.Blob))
			return true
		if (clazz == typeof(java.sql.Clob))
			return true
		if (clazz == typeof(java.math.BigDecimal))
			return true
		if (clazz == typeof(java.math.BigInteger))
			return true
		return false
	}

	def String getClassName(String baseClass, String property, URI uri) {
		if (baseClass == null || property == null)
			return baseClass
		var pos1 = property.indexOf('.')
		if (pos1 == -1)
			return baseClass
		var checkProperty = property
		pos1 = checkProperty.indexOf('=')
		if (pos1 > 0) {
			var pos2 = checkProperty.indexOf('.', pos1)
			if (pos2 > pos1)
				checkProperty = checkProperty.substring(0, pos1) + checkProperty.substring(pos2)
		}
		var innerProperty = null as String
		pos1 = checkProperty.indexOf('.')
		if (pos1 > 0) {
			innerProperty = checkProperty.substring(pos1 + 1)
			checkProperty = checkProperty.substring(0, pos1)
		}
		var descriptors = pojoResolver.getPropertyDescriptors(baseClass, uri)
		if (descriptors == null)
			return null
		val _checkProperty = checkProperty
		var innerDesriptor = descriptors.findFirst [ descriptor |
			descriptor.name == _checkProperty
		]
		if (innerDesriptor == null)
			return null
		var innerClass = innerDesriptor.getPropertyType()
		if (innerClass.isArray()) {
			var type = innerDesriptor.getReadMethod().getGenericReturnType() as ParameterizedType
			if (type.getActualTypeArguments() == null || type.getActualTypeArguments().length == 0)
				return null
			innerClass = type.getActualTypeArguments().head as Class<?>
			if (isPrimitive(innerClass))
				return null
			return getClassName(innerClass.getName(), innerProperty, uri)
		} else if (typeof(Collection).isAssignableFrom(innerClass)) {
			var type = innerDesriptor.getReadMethod().getGenericReturnType() as ParameterizedType
			if (type.getActualTypeArguments() == null || type.getActualTypeArguments().length == 0)
				return null
			innerClass = type.getActualTypeArguments().head as Class<?>
			if (isPrimitive(innerClass))
				return null
			return getClassName(innerClass.getName(), innerProperty, uri)
		} else {
			if (isPrimitive(innerClass))
				return null
			return getClassName(innerClass.getName(), innerProperty, uri)
		}
	}

	def acceptTables(EObject model, ContentAssistContext context, ICompletionProposalAcceptor acceptor, String suffix) {
		dbResolver.getTables(model).filter[indexOf('$') < 0].forEach [ table |
			val proposal = getValueConverter().toString(table, "IDENT")
			acceptor.accept(createCompletionProposal(proposal + suffix, context))
		]
	}

	def acceptProcedures(EObject model, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		dbResolver.getProcedures(model).filter[indexOf('$') < 0].forEach [ table |
			val proposal = getValueConverter().toString(table, "IDENT")
			acceptor.accept(createCompletionProposal(proposal, context))
		]
	}

	def acceptFunctions(EObject model, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		dbResolver.getFunctions(model).filter[indexOf('$') < 0].forEach [ table |
			val proposal = getValueConverter().toString(table, "IDENT")
			acceptor.accept(createCompletionProposal(proposal, context))
		]
	}

	def acceptCheckConstraints(EObject model, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		dbResolver.getCheckConstraints(model).filter[indexOf('$') < 0].forEach [ table |
			val proposal = getValueConverter().toString(table, "IDENT")
			acceptor.accept(createCompletionProposal(proposal, context))
		]
	}

	def acceptSequences(EObject model, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		dbResolver.getSequences(model).filter[indexOf('$') < 0].forEach [ table |
			val proposal = getValueConverter().toString(table, "IDENT")
			acceptor.accept(createCompletionProposal(proposal, context))
		]
	}

	def acceptColumns(List<String> columns, ContentAssistContext context, ICompletionProposalAcceptor acceptor,
		String prefix, String suffix) {
		columns.forEach [ column |
			val proposal = getValueConverter().toString(column, "IDENT")
			var completion = if(prefix != null) prefix + '.' + proposal else proposal
			completion = if(suffix != null) completion + suffix else completion
			acceptor.accept(createCompletionProposal(completion, context))
		]
	}

	override completeTableDefinition_Table(EObject model, Assignment assignment, ContentAssistContext context,
		ICompletionProposalAcceptor acceptor) {
		if (!isResolveDb(model)) {
			super.completeTableDefinition_Table(model, assignment, context, acceptor)
			return
		}
		acceptTables(model, context, acceptor, "")
	}

	override completeProcedureDefinition_Table(EObject model, Assignment assignment, ContentAssistContext context,
		ICompletionProposalAcceptor acceptor) {
		if (!isResolveDb(model)) {
			super.completeProcedureDefinition_Table(model, assignment, context, acceptor)
			return
		}
		acceptProcedures(model, context, acceptor)
	}

	override completeFunctionDefinition_Table(EObject model, Assignment assignment, ContentAssistContext context,
		ICompletionProposalAcceptor acceptor) {
		if (!isResolveDb(model)) {
			super.completeFunctionDefinition_Table(model, assignment, context, acceptor)
			return
		}
		acceptFunctions(model, context, acceptor)
	}

	override completePojogenProperty_DbTable(EObject model, Assignment assignment, ContentAssistContext context,
		ICompletionProposalAcceptor acceptor) {
		if (!isResolveDb(model)) {
			super.completePojogenProperty_DbTable(model, assignment, context, acceptor)
			return
		}
		acceptTables(model, context, acceptor, "")
		acceptCheckConstraints(model, context, acceptor)
	}

	override completePojogenProperty_DbProcedure(EObject model, Assignment assignment, ContentAssistContext context,
		ICompletionProposalAcceptor acceptor) {
		if (!isResolveDb(model)) {
			super.completePojogenProperty_DbProcedure(model, assignment, context, acceptor)
			return
		}
		acceptProcedures(model, context, acceptor)
	}

	override completePojogenProperty_DbFunction(EObject model, Assignment assignment, ContentAssistContext context,
		ICompletionProposalAcceptor acceptor) {
		if (!isResolveDb(model)) {
			super.completePojogenProperty_DbFunction(model, assignment, context, acceptor)
			return
		}
		acceptFunctions(model, context, acceptor)
	}

	override completeTableAssignement_DbTable(EObject model, Assignment assignment, ContentAssistContext context,
		ICompletionProposalAcceptor acceptor) {
		if (!isResolveDb(model)) {
			super.completeTableAssignement_DbTable(model, assignment, context, acceptor)
			return
		}
		acceptTables(model, context, acceptor, "->")
	}

	override completeInheritanceAssignement_DbTable(EObject model, Assignment assignment, ContentAssistContext context,
		ICompletionProposalAcceptor acceptor) {
		if (!isResolveDb(model)) {
			super.completeInheritanceAssignement_DbTable(model, assignment, context, acceptor)
			return
		}
		acceptTables(model, context, acceptor, "->")
	}

	override completePojogenProperty_DbTables(EObject model, Assignment assignment, ContentAssistContext context,
		ICompletionProposalAcceptor acceptor) {
		if (!isResolveDb(model)) {
			super.completePojogenProperty_DbTables(model, assignment, context, acceptor)
			return
		}
		acceptTables(model, context, acceptor, "")
	}

	override completePojogenProperty_DbNotTables(EObject model, Assignment assignment, ContentAssistContext context,
		ICompletionProposalAcceptor acceptor) {
		if (!isResolveDb(model)) {
			super.completePojogenProperty_DbNotTables(model, assignment, context, acceptor)
			return
		}
		acceptTables(model, context, acceptor, "")
	}

	override completeMetagenProperty_DbNotTables(EObject model, Assignment assignment, ContentAssistContext context,
		ICompletionProposalAcceptor acceptor) {
		if (!isResolveDb(model)) {
			super.completeMetagenProperty_DbNotTables(model, assignment, context, acceptor)
			return
		}
		acceptTables(model, context, acceptor, "")
	}

	override completePojogenProperty_DbColumn(EObject model, Assignment assignment, ContentAssistContext context,
		ICompletionProposalAcceptor acceptor) {
		if (!isResolveDb(model) || (!(model instanceof PojogenProperty) && !(model instanceof Property))) {
			super.completeColumnTypeAssignement_DbColumn(model, assignment, context, acceptor)
			return
		}
		val prop = if (model instanceof Property) (model as Property).pojogen else model as PojogenProperty
		if (prop.dbTable != null) {
			acceptColumns(dbResolver.getColumns(model, prop.dbTable), context, acceptor, null, null)
		}
	}

	override completePojogenProperty_DbColumns(EObject model, Assignment assignment, ContentAssistContext context,
		ICompletionProposalAcceptor acceptor) {
		if (!isResolveDb(model) || (!(model instanceof PojogenProperty) && !(model instanceof Property))) {
			super.completeColumnTypeAssignement_DbColumn(model, assignment, context, acceptor)
			return
		}
		val prop = if (model instanceof Property) (model as Property).pojogen else model as PojogenProperty
		if (prop.dbTable != null) {
			acceptColumns(dbResolver.getColumns(model, prop.dbTable), context, acceptor, null, null)
		}
	}

	override completeImplementsAssignement_DbTables(EObject model, Assignment assignment, ContentAssistContext context,
		ICompletionProposalAcceptor acceptor) {
		if (!isResolveDb(model)) {
			super.completeImplementsAssignement_DbTables(model, assignment, context, acceptor)
			return
		}
		acceptTables(model, context, acceptor, "")
		acceptProcedures(model, context, acceptor)
		acceptFunctions(model, context, acceptor)
	}

	override completeExtendsAssignement_DbTables(EObject model, Assignment assignment, ContentAssistContext context,
		ICompletionProposalAcceptor acceptor) {
		if (!isResolveDb(model)) {
			super.completeExtendsAssignement_DbTables(model, assignment, context, acceptor)
			return
		}
		acceptTables(model, context, acceptor, "")
		acceptProcedures(model, context, acceptor)
		acceptFunctions(model, context, acceptor)
	}

	override completeImplementsAssignement_DbNotTables(EObject model, Assignment assignment,
		ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		if (!isResolveDb(model)) {
			super.completeImplementsAssignement_DbNotTables(model, assignment, context, acceptor)
			return
		}
		acceptTables(model, context, acceptor, "")
		acceptProcedures(model, context, acceptor)
		acceptFunctions(model, context, acceptor)
	}

	override completeExtendsAssignement_DbNotTables(EObject model, Assignment assignment, ContentAssistContext context,
		ICompletionProposalAcceptor acceptor) {
		if (!isResolveDb(model)) {
			super.completeExtendsAssignement_DbNotTables(model, assignment, context, acceptor)
			return
		}
		acceptTables(model, context, acceptor, "")
		acceptProcedures(model, context, acceptor)
		acceptFunctions(model, context, acceptor)
	}

	override completeImplementsAssignementGenerics_DbTables(EObject model, Assignment assignment,
		ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		if (!isResolveDb(model)) {
			super.completeImplementsAssignementGenerics_DbTables(model, assignment, context, acceptor)
			return
		}
		acceptTables(model, context, acceptor, "")
		acceptProcedures(model, context, acceptor)
		acceptFunctions(model, context, acceptor)
	}

	override completeExtendsAssignementGenerics_DbTables(EObject model, Assignment assignment,
		ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		if (!isResolveDb(model)) {
			super.completeExtendsAssignementGenerics_DbTables(model, assignment, context, acceptor)
			return
		}
		acceptTables(model, context, acceptor, "")
		acceptProcedures(model, context, acceptor)
		acceptFunctions(model, context, acceptor)
	}

	override completeImplementsAssignementGenerics_DbNotTables(EObject model, Assignment assignment,
		ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		if (!isResolveDb(model)) {
			super.completeImplementsAssignementGenerics_DbNotTables(model, assignment, context, acceptor)
			return
		}
		acceptTables(model, context, acceptor, "")
		acceptProcedures(model, context, acceptor)
		acceptFunctions(model, context, acceptor)
	}

	override completeExtendsAssignementGenerics_DbNotTables(EObject model, Assignment assignment,
		ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		if (!isResolveDb(model)) {
			super.completeExtendsAssignementGenerics_DbNotTables(model, assignment, context, acceptor)
			return
		}
		acceptTables(model, context, acceptor, "")
		acceptProcedures(model, context, acceptor)
		acceptFunctions(model, context, acceptor)
	}

	override completeColumnTypeAssignement_DbColumn(EObject model, Assignment assignment, ContentAssistContext context,
		ICompletionProposalAcceptor acceptor) {
		if (!isResolveDb(model) || (!(model instanceof PojogenProperty) && !(model instanceof Property))) {
			super.completeColumnTypeAssignement_DbColumn(model, assignment, context, acceptor)
			return
		}
		val prop = if (model instanceof Property) (model as Property).pojogen else model as PojogenProperty
		if (prop.getDbTable() != null) {
			acceptColumns(dbResolver.getColumns(model, prop.dbTable), context, acceptor, null, "->")
		} else if (prop.getDbProcedure() != null) {
			acceptColumns(dbResolver.getProcColumns(model, prop.dbProcedure), context, acceptor, null, "->")
		} else if (prop.getDbFunction() != null) {
			acceptColumns(dbResolver.getFunColumns(model, prop.dbFunction), context, acceptor, null, "->")
		}
	}

	override completeColumnAssignement_DbColumn(EObject model, Assignment assignment, ContentAssistContext context,
		ICompletionProposalAcceptor acceptor) {
		if (!isResolveDb(model) || (!(model instanceof PojogenProperty) && !(model instanceof Property))) {
			super.completeColumnTypeAssignement_DbColumn(model, assignment, context, acceptor)
			return
		}
		val prop = if (model instanceof Property) (model as Property).pojogen else model as PojogenProperty
		if (prop.getDbTable() != null) {
			acceptColumns(dbResolver.getColumns(model, prop.dbTable), context, acceptor, null, "->")
			acceptColumns(dbResolver.getCheckColumns(model, prop.dbTable), context, acceptor, null, "->")
		}
	}

	override completeImportAssignement_PkTable(EObject model, Assignment assignment, ContentAssistContext context,
		ICompletionProposalAcceptor acceptor) {
		if (!isResolveDb(model) || !(model instanceof ImportAssignement)) {
			super.completeImportAssignement_PkTable(model, assignment, context, acceptor)
			return
		}
		val imp = model as ImportAssignement
		val prop = model.getContainerOfType(typeof(PojogenProperty))
		if (prop.getDbTable() != null && imp.getDbColumn() != null) {
			if ("create-many-to-one" == prop.name) {
				acceptTables(model, context, acceptor, "")
			} else {
				dbResolver.getDbImports(model, prop.getDbTable()).forEach [ dbImport |
					if (dbImport.getFkColumn() != null && dbImport.getFkColumn().equals(imp.getDbColumn())) {
						val proposal = getValueConverter().toString(dbImport.getPkTable(), "IDENT")
						acceptor.accept(createCompletionProposal(proposal, context))
					}
				]
			}
		}
	}

	override completeImportAssignement_PkColumn(EObject model, Assignment assignment, ContentAssistContext context,
		ICompletionProposalAcceptor acceptor) {
		if (!isResolveDb(model) || !(model instanceof ImportAssignement)) {
			super.completeImportAssignement_PkColumn(model, assignment, context, acceptor)
			return
		}
		val imp = model as ImportAssignement
		val prop = model.getContainerOfType(typeof(PojogenProperty))
		if (prop.getDbTable() != null && imp.getDbColumn() != null && imp.getPkTable() != null) {
			if ("create-many-to-one" == prop.name) {
				acceptColumns(dbResolver.getColumns(model, imp.getPkTable()), context, acceptor, null, null)
			} else {
				dbResolver.getDbImports(model, prop.getDbTable()).forEach [ dbImport |
					if (dbImport.getFkColumn() != null && dbImport.getFkColumn().equals(imp.getDbColumn())) {
						if (dbImport.getPkTable() != null && dbImport.getPkTable().equals(imp.getPkTable())) {
							val proposal = getValueConverter().toString(dbImport.getPkColumn(), "IDENT")
							acceptor.accept(createCompletionProposal(proposal, context))
						}
					}
				]
			}
		}
	}

	override completeImportAssignement_DbColumn(EObject model, Assignment assignment, ContentAssistContext context,
		ICompletionProposalAcceptor acceptor) {
		if (!isResolveDb(model) || (!(model instanceof PojogenProperty) && !(model instanceof Property))) {
			super.completeColumnTypeAssignement_DbColumn(model, assignment, context, acceptor)
			return
		}
		val prop = if (model instanceof Property) (model as Property).pojogen else model as PojogenProperty
		if (prop.getDbTable() != null) {
			acceptColumns(dbResolver.getColumns(model, prop.getDbTable()), context, acceptor, null, "->")
		}
	}

	override completeExportAssignement_FkTable(EObject model, Assignment assignment, ContentAssistContext context,
		ICompletionProposalAcceptor acceptor) {
		if (!isResolveDb(model) || !(model instanceof ExportAssignement)) {
			super.completeExportAssignement_FkTable(model, assignment, context, acceptor)
			return
		}
		val exp = model as ExportAssignement
		val prop = model.getContainerOfType(typeof(PojogenProperty))
		if (prop.getDbTable() != null && exp.getDbColumn() != null) {
			if ("create-one-to-many" == prop.name) {
				acceptTables(model, context, acceptor, "")
			} else {
				dbResolver.getDbExports(model, prop.getDbTable()).forEach [ dbExport |
					if (dbExport.getPkColumn() != null && dbExport.getPkColumn().equals(exp.getDbColumn())) {
						val proposal = getValueConverter().toString(dbExport.getFkTable(), "IDENT")
						acceptor.accept(createCompletionProposal(proposal, context))
					}
				]
			}
		}
	}

	override completeExportAssignement_FkColumn(EObject model, Assignment assignment, ContentAssistContext context,
		ICompletionProposalAcceptor acceptor) {
		if (!isResolveDb(model) || !(model instanceof ExportAssignement)) {
			super.completeExportAssignement_FkColumn(model, assignment, context, acceptor)
			return
		}
		val exp = model as ExportAssignement
		val prop = model.getContainerOfType(typeof(PojogenProperty))
		if (prop.getDbTable() != null && exp.getDbColumn() != null && exp.getFkTable() != null) {
			if ("create-one-to-many" == prop.name) {
				acceptColumns(dbResolver.getColumns(model, exp.getFkTable()), context, acceptor, null, null)
			} else {
				dbResolver.getDbExports(model, prop.getDbTable()).forEach [ dbExport |
					if (dbExport.getPkColumn() != null && dbExport.getPkColumn().equals(exp.getDbColumn())) {
						if (dbExport.getFkTable() != null && dbExport.getFkTable().equals(exp.getFkTable())) {
							val proposal = getValueConverter().toString(dbExport.getFkColumn(), "IDENT")
							acceptor.accept(createCompletionProposal(proposal, context))
						}
					}
				]
			}
		}
	}

	override completeExportAssignement_DbColumn(EObject model, Assignment assignment, ContentAssistContext context,
		ICompletionProposalAcceptor acceptor) {
		if (!isResolveDb(model) || (!(model instanceof PojogenProperty) && !(model instanceof Property))) {
			super.completeColumnTypeAssignement_DbColumn(model, assignment, context, acceptor)
			return
		}
		val prop = if (model instanceof Property) (model as Property).pojogen else model as PojogenProperty
		if (prop.getDbTable() != null) {
			acceptColumns(dbResolver.getColumns(model, prop.getDbTable()), context, acceptor, null, "->")
		}
	}

	override completeManyToManyAssignement_PkColumn(EObject model, Assignment assignment, ContentAssistContext context,
		ICompletionProposalAcceptor acceptor) {
		if (!isResolveDb(model) || (!(model instanceof PojogenProperty) && !(model instanceof Property))) {
			super.completeColumnTypeAssignement_DbColumn(model, assignment, context, acceptor)
			return
		}
		val prop = if (model instanceof Property) (model as Property).pojogen else model as PojogenProperty
		if (prop.getDbTable() != null) {
			acceptColumns(dbResolver.getColumns(model, prop.getDbTable()), context, acceptor, null, "->")
		}
	}

	override completeManyToManyAssignement_PkTable(EObject model, Assignment assignment, ContentAssistContext context,
		ICompletionProposalAcceptor acceptor) {
		if (!isResolveDb(model) || !(model instanceof ManyToManyAssignement)) {
			super.completeManyToManyAssignement_PkTable(model, assignment, context, acceptor)
			return
		}
		val many2 = model as ManyToManyAssignement
		val prop = model.getContainerOfType(typeof(PojogenProperty))
		if (prop.getDbTable() != null && many2.getPkColumn() != null) {
			dbResolver.getDbImports(model, prop.getDbTable()).forEach [ dbImport |
				if (dbImport.getPkColumn() != null && dbImport.getPkColumn().equals(many2.getPkColumn())) {
					val proposal = getValueConverter().toString(dbImport.getPkTable(), "IDENT")
					acceptor.accept(createCompletionProposal(proposal, context))
				}
			]
		}
	}

	override completeInheritanceAssignement_DbColumns(EObject model, Assignment assignment,
		ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		if (!isResolveDb(model) || !(model instanceof InheritanceAssignement)) {
			super.completeInheritanceAssignement_DbColumns(model, assignment, context, acceptor)
			return
		}
		val prop = model.getContainerOfType(typeof(PojogenProperty))
		if (prop.getDbTable() != null) {
			acceptColumns(dbResolver.getColumns(model, prop.getDbTable()), context, acceptor, null, null)
		}
	}

	val methods = newArrayList("toString", "hashCode", "equals", "isDef", "toInit", "enumDef", "enumInit", "index")

	override completePojogenProperty_Methods(EObject model, Assignment assignment, ContentAssistContext context,
		ICompletionProposalAcceptor acceptor) {
		if (!(model instanceof PojogenProperty)) {
			super.completePojogenProperty_Methods(model, assignment, context, acceptor)
			return
		}
		methods.forEach [ method |
			val proposal = getValueConverter().toString(method, "IDENT")
			acceptor.accept(createCompletionProposal(proposal, context))
		]
	}

	override completeShowColumnTypeAssignement_DbColumn(EObject model, Assignment assignment,
		ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		if (!isResolveDb(model) || (!(model instanceof PojogenProperty) && !(model instanceof Property))) {
			super.completeColumnTypeAssignement_DbColumn(model, assignment, context, acceptor)
			return
		}
		val prop = if (model instanceof Property) (model as Property).pojogen else model as PojogenProperty
		if (prop.getDbTable() != null) {
			acceptColumns(dbResolver.getColumns(model, prop.dbTable), context, acceptor, null, "->")
		} else if (prop.getDbProcedure() != null) {
			acceptColumns(dbResolver.getProcColumns(model, prop.dbProcedure), context, acceptor, null, "->")
		} else if (prop.getDbFunction() != null) {
			acceptColumns(dbResolver.getFunColumns(model, prop.dbFunction), context, acceptor, null, "->")
		}
	}

	override completeShowColumnTypeAssignement_Type(EObject model, Assignment assignment, ContentAssistContext context,
		ICompletionProposalAcceptor acceptor) {
		if (!isResolveDb(model) || !(model instanceof ShowColumnTypeAssignement)) {
			super.completeShowColumnTypeAssignement_Type(model, assignment, context, acceptor)
			return
		}
		val prop = model as ShowColumnTypeAssignement
		val prop2 = model.getContainerOfType(typeof(PojogenProperty))
		var type = null as String
		if (prop2.getDbTable() != null) {
			type = dbResolver.getType(model, prop2.getDbTable(), prop.getDbColumn())
		} else if (prop2.getDbProcedure() != null) {
			type = dbResolver.getType(model, prop2.getDbProcedure(), prop.getDbColumn())
		} else if (prop2.getDbFunction() != null) {
			type = dbResolver.getType(model, prop2.getDbFunction(), prop.getDbColumn())
		}
		if (type != null) {
			val proposal = getValueConverter().toString("\""+type+"\"", "PropertyValue")
			acceptor.accept(createCompletionProposal(proposal, context))
		}
	}

	override completeJoinTableAssignement_DbTable(EObject model, Assignment assignment, ContentAssistContext context,
		ICompletionProposalAcceptor acceptor) {
		if (!isResolveDb(model)) {
			super.completeJoinTableAssignement_DbTable(model, assignment, context, acceptor)
			return
		}
		acceptTables(model, context, acceptor, "->")
	}

	override completeJoinTableAssignement_DbTables(EObject model, Assignment assignment, ContentAssistContext context,
		ICompletionProposalAcceptor acceptor) {
		if (!isResolveDb(model)) {
			super.completeJoinTableAssignement_DbTables(model, assignment, context, acceptor)
			return
		}
		acceptTables(model, context, acceptor, "")
	}

	def Set<PojoEntity> listEntities(ResourceSet resourceSet, IScope scope) {
		val result = <PojoEntity>newTreeSet[o1, o2|o1.name.compareTo(o2.name)]
		scope.getAllElements().forEach [ description |
			val packageDeclaration = resourceSet.getEObject(description.getEObjectURI(), true) as Package
			packageDeclaration.getElements().forEach [ aEntity |
				if (aEntity instanceof AnnotatedEntity) {
					var ae = aEntity as AnnotatedEntity
					if (ae.getEntity() instanceof PojoEntity)
						result.add(ae.getEntity() as PojoEntity)
				}
			]
		]
		return result
	}

	def Set<PojoDefinition> listPojos(ResourceSet resourceSet, IScope scope) {
		val result = <PojoDefinition>newTreeSet[o1, o2|o1.name.compareTo(o2.name)]
		scope.getAllElements().forEach [ description |
			val pojo = resourceSet.getEObject(description.getEObjectURI(), true) as PojoDefinition
			result.add(pojo)
		]
		return result
	}

	def Set<TableDefinition> listTables(ResourceSet resourceSet, IScope scope) {
		val result = <TableDefinition>newTreeSet[o1, o2|o1.name.compareTo(o2.name)]
		scope.getAllElements().forEach [ description |
			val table = resourceSet.getEObject(description.getEObjectURI(), true) as TableDefinition
			result.add(table)
		]
		return result
	}

	override completeMetagenProperty_DbTable(EObject model, Assignment assignment, ContentAssistContext context,
		ICompletionProposalAcceptor acceptor) {
		if (!isResolveDb(model)) {
			super.completeMetagenProperty_DbTable(model, assignment, context, acceptor)
			return
		}
		acceptTables(model, context, acceptor, "")
	}

	override completeMetagenProperty_DbTables(EObject model, Assignment assignment, ContentAssistContext context,
		ICompletionProposalAcceptor acceptor) {
		if (!isResolveDb(model)) {
			super.completeMetagenProperty_DbTables(model, assignment, context, acceptor)
			return
		}
		acceptTables(model, context, acceptor, "")
	}

	override completeMetagenProperty_DbFunction(EObject model, Assignment assignment, ContentAssistContext context,
		ICompletionProposalAcceptor acceptor) {
		if (!isResolveDb(model)) {
			super.completeMetagenProperty_DbFunction(model, assignment, context, acceptor)
			return
		}
		acceptFunctions(model, context, acceptor)
	}

	override completeMetagenProperty_DbProcedure(EObject model, Assignment assignment, ContentAssistContext context,
		ICompletionProposalAcceptor acceptor) {
		if (!isResolveDb(model)) {
			super.completeMetagenProperty_DbProcedure(model, assignment, context, acceptor)
			return
		}
		acceptProcedures(model, context, acceptor)
	}

	override completeMetagenProperty_Sequence(EObject model, Assignment assignment, ContentAssistContext context,
		ICompletionProposalAcceptor acceptor) {
		if (!isResolveDb(model)) {
			super.completeMetagenProperty_Sequence(model, assignment, context, acceptor)
			return
		}
		acceptSequences(model, context, acceptor)
	}

	override completeMetaTypeAssignement_DbColumn(EObject model, Assignment assignment, ContentAssistContext context,
		ICompletionProposalAcceptor acceptor) {
		if (!isResolveDb(model) || (!(model instanceof MetagenProperty) && !(model instanceof Property))) {
			super.completeColumnTypeAssignement_DbColumn(model, assignment, context, acceptor)
			return
		}
		val prop = if (model instanceof Property) (model as Property).metagen else model as MetagenProperty
		acceptColumns(dbResolver.getColumns(model, prop.dbTable), context, acceptor, null, null)
	}

	override completeDaogenProperty_DbTables(EObject model, Assignment assignment, ContentAssistContext context,
		ICompletionProposalAcceptor acceptor) {
		if (!isResolveDb(model)) {
			super.completeDaogenProperty_DbTables(model, assignment, context, acceptor)
			return
		}
		acceptTables(model, context, acceptor, "")
	}

	override completeMetagenProperty_DbColumns(EObject model, Assignment assignment, ContentAssistContext context,
		ICompletionProposalAcceptor acceptor) {
		if (!isResolveDb(model) || !(model instanceof MetagenProperty)) {
			super.completeMetagenProperty_DbColumns(model, assignment, context, acceptor)
			return
		}
		val prop = model as MetagenProperty
		acceptColumns(dbResolver.getColumns(model, prop.dbTable), context, acceptor, null, null)
	}

	override completeDatabaseMetaInfoAssignement_DbMetaInfo(EObject model, Assignment assignment,
		ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		if (!isResolveDb(model)) {
			super.completeDatabaseMetaInfoAssignement_DbMetaInfo(model, assignment, context, acceptor)
			return
		}
		var String dbMetaInfo = dbResolver.getDbMetaInfo(model)
		if (dbMetaInfo != null)
			dbMetaInfo = '"'+dbMetaInfo+'"'
		val proposal = getValueConverter().toString(dbMetaInfo, "PropertyValue")
		acceptor.accept(createCompletionProposal(proposal, context))
	}

	override completeDriverMetaInfoAssignement_DbDriverInfo(EObject model, Assignment assignment,
		ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		if (!isResolveDb(model)) {
			super.completeDriverMetaInfoAssignement_DbDriverInfo(model, assignment, context, acceptor)
			return
		}
		var String dbDriverInfo = dbResolver.getDbDriverInfo(model)
		if (dbDriverInfo != null)
			dbDriverInfo = '"'+dbDriverInfo+'"'
		val proposal = getValueConverter().toString(dbDriverInfo, "PropertyValue")
		acceptor.accept(createCompletionProposal(proposal, context))
	}

	override completeDriverMethodOutputAssignement_DriverMethod(EObject model, Assignment assignment,
		ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		if (!isResolveDb(model) || !(model instanceof DatabaseProperty)) {
			super.completeDriverMethodOutputAssignement_DriverMethod(model, assignment, context, acceptor)
			return
		}
		dbResolver.getDriverMethods(model).forEach [ driverMetod |
			val proposal = getValueConverter().toString(driverMetod, "PropertyValue")
			acceptor.accept(createCompletionProposal(proposal + "->", context))
		]
	}

	override completeDriverMethodOutputAssignement_CallOutput(EObject model, Assignment assignment,
		ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		if (!isResolveDb(model) || !(model instanceof DriverMethodOutputAssignement)) {
			super.completeDriverMethodOutputAssignement_CallOutput(model, assignment, context, acceptor)
			return
		}
		val prop = model as DriverMethodOutputAssignement
		var methodCallOutput = dbResolver.getDriverMethodOutput(model, prop.getDriverMethod()) ?: "null"
		val proposal = getValueConverter().toString('"' + methodCallOutput + '"', "PropertyValue")
		acceptor.accept(createCompletionProposal(proposal, context))
	}

	override completeDatabaseTypeAssignement_DbType(EObject model, Assignment assignment, ContentAssistContext context,
		ICompletionProposalAcceptor acceptor) {
		if (!isResolveDb(model)) {
			super.completeDatabaseTypeAssignement_DbType(model, assignment, context, acceptor)
			return
		}
		val dbMetaInfo = dbResolver.getDbMetaInfo(model)
		DbType.fromDbMetaInfo(dbMetaInfo).forEach [ dbType |
			val proposal = getValueConverter().toString(dbType.getValue(), "PropertyValue")
			acceptor.accept(createCompletionProposal(proposal, context))
		]
	}

	override completeDatabaseCatalogAssignement_DbCatalog(EObject model, Assignment assignment,
		ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		if (!isResolveDb(model)) {
			super.completeDatabaseCatalogAssignement_DbCatalog(model, assignment, context, acceptor)
			return
		}
		dbResolver.getCatalogs(model).forEach [ catalog |
			val proposal = getValueConverter().toString(catalog, "IDENT")
			acceptor.accept(createCompletionProposal(proposal, context))
		]
	}

	override completeDatabaseSchemaAssignement_DbSchema(EObject model, Assignment assignment,
		ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		if (!isResolveDb(model)) {
			super.completeDatabaseSchemaAssignement_DbSchema(model, assignment, context, acceptor)
			return
		}
		dbResolver.getSchemas(model).forEach [ schema |
			val proposal = getValueConverter().toString(schema, "IDENT")
			acceptor.accept(createCompletionProposal(proposal, context))
		]
	}

	override completeDebugLevelAssignement_Debug(EObject model, Assignment assignment, ContentAssistContext context,
		ICompletionProposalAcceptor acceptor) {
		addProposalList(DEBUG_LEVELS, "DEBUG_LEVELS", context, acceptor, null)
	}

	override completeProcedurePojoAssignement_DbProcedure(EObject model, Assignment assignment,
		ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		if (!isResolveDb(model)) {
			super.completeProcedurePojoAssignement_DbProcedure(model, assignment, context, acceptor)
			return
		}
		acceptProcedures(model, context, acceptor)
	}

	override completeFunctionPojoAssignement_DbFunction(EObject model, Assignment assignment,
		ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		if (!isResolveDb(model)) {
			super.completeFunctionPojoAssignement_DbFunction(model, assignment, context, acceptor)
			return
		}
		acceptFunctions(model, context, acceptor)
	}

	override completePojogenProperty_DbCheckConstraints(EObject model, Assignment assignment,
		ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		if (!isResolveDb(model)) {
			super.completePojogenProperty_DbCheckConstraints(model, assignment, context, acceptor)
			return
		}
		acceptCheckConstraints(model, context, acceptor)
	}

	// TODO: id doesn't work (model is Artifacts), nor ProcessorDslScopeProvider can help
//	override completeDirectiveProperties_Features(EObject model, Assignment assignment, ContentAssistContext context,
//		ICompletionProposalAcceptor acceptor) {
//		println(model)
//		if (!(model instanceof DirectiveProperties) || (model as DirectiveProperties).features == null ||
//			(model as DirectiveProperties).features.empty) {
//			super.completeDirectiveProperties_Features(model, assignment, context, acceptor)
//			return
//		}
//		val directiveProperties = model as DirectiveProperties
//		val directive = model.getContainerOfType(typeof(PojoDirective))
//		val entity = directive.getContainerOfType(typeof(PojoEntity))
//		val attributes = attributesAsMap(entity)
//		for (PojoProperty prop : directiveProperties.features) {
//			attributes.remove(prop.name)
//		}
//		attributes.forEach [ name, attr |
//			val proposal = getValueConverter().toString(name, "IDENT")
//			acceptor.accept(createCompletionProposal(proposal, context))
//		]

//		lookupCrossReference(assignment.getTerminal() as CrossReference, context, acceptor, [
//			(EObjectOrProxy as PojoProperty). // test it belongs to model
//		])
//	}
}
