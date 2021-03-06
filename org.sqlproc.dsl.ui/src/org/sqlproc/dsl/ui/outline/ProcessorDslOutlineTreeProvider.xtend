/*
* generated by Xtext
*/
package org.sqlproc.dsl.ui.outline

import org.eclipse.xtext.ui.editor.outline.impl.DocumentRootNode
import org.eclipse.emf.ecore.EObject
import org.sqlproc.dsl.processorDsl.Artifacts
import org.sqlproc.dsl.processorDsl.OptionalFeature
import org.sqlproc.dsl.processorDsl.MetaStatement
import org.sqlproc.dsl.processorDsl.MappingRule
import org.eclipse.xtext.ui.editor.outline.IOutlineNode
import org.sqlproc.dsl.processorDsl.Identifier
import org.sqlproc.dsl.processorDsl.Constant
import org.sqlproc.dsl.util.Utils
import org.sqlproc.dsl.processorDsl.Column
import org.sqlproc.dsl.processorDsl.DatabaseColumn
import org.sqlproc.dsl.util.Collector
import org.sqlproc.dsl.processorDsl.MappingColumn

/**
 * Customization of the default outline structure.
 *
 * see http://www.eclipse.org/Xtext/documentation.html#outline
 */
class ProcessorDslOutlineTreeProvider extends org.eclipse.xtext.ui.editor.outline.impl.DefaultOutlineTreeProvider {

	override _createChildren(DocumentRootNode parentNode, EObject rootElement) {

		// for (EObject content : rootElement.eContents()) {
		// 		createNode(parentNode, content)
		// }
		
		val artifacts = rootElement as Artifacts;
		if (artifacts.features != null) {
			for (optionalFeature : artifacts.features)
				createNode(parentNode, optionalFeature)
		}
		if (artifacts.statements != null) {
			for (metaStatement : artifacts.statements)
				createNode(parentNode, metaStatement)
		}
		if (artifacts.mappings!= null) {
			for (mappingRule : artifacts.mappings)
				createNode(parentNode, mappingRule)
		}
	}

	override _createChildren(IOutlineNode parentNode, EObject modelElement) {
		switch (modelElement) {
			MetaStatement: {
				val identifiers = <Identifier>newTreeSet[a,b|a.name.compareTo(b.name)]
	        	val constants = <Constant>newTreeSet[a,b|a.name.compareTo(b.name)]
	        	val columns = <Column>newTreeSet[a,b|Utils.getName(a).compareTo(Utils.getName(b))]
	        	val databaseColumns = <DatabaseColumn>newTreeSet[a,b|a.name.compareTo(b.name)]
	            Collector.allVariables(modelElement as MetaStatement, identifiers, constants, columns, databaseColumns)
				for (identifier : identifiers)
	            	createNode(parentNode, identifier)
	            for (constant : constants)
	                createNode(parentNode, constant)
	            for (column : columns)
	                createNode(parentNode, column)
	            for (column : databaseColumns)
	                createNode(parentNode, column)
			}
        	MappingRule: {
	        	val columns = <MappingColumn>newTreeSet[a,b|Utils.getName(a).compareTo(Utils.getName(b))]
	            Collector.allVariables(modelElement as MappingRule, columns)
                for (column : columns)
                    createNode(parentNode, column)
           	}
        }
    }

    def _isLeaf(MetaStatement metaStatement) {
        return false;
    }

    def _isLeaf(MappingRule mappingRule) {
        return false;
    }

    def _isLeaf(OptionalFeature optionalFeature) {
        return true;
    }

    def _isLeaf(Identifier identifier) {
        return true;
    }

    def _isLeaf(Constant constant) {
        return true;
    }

    def _isLeaf(Column column) {
        return true;
    }

    def _isLeaf(DatabaseColumn column) {
        return true;
    }

    def _isLeaf(MappingColumn column) {
        return true;
    }
}
