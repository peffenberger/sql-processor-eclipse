/*
 * generated by Xtext
 */
package org.sqlproc.dsl.generator

import static org.sqlproc.dsl.util.Utils.*;
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.IGenerator
import org.eclipse.xtext.generator.IFileSystemAccess
import org.sqlproc.dsl.processorDsl.AnnotatedEntity
import org.sqlproc.dsl.processorDsl.PojoDao
import com.google.inject.Inject
import org.eclipse.xtext.naming.IQualifiedNameProvider

/**
 * Generates code from your model files on save.
 * 
 * see http://www.eclipse.org/Xtext/documentation.html#TutorialCodeGeneration
 */
class ProcessorDslGenerator implements IGenerator {

	@Inject extension IQualifiedNameProvider
	@Inject extension ProcessorPojoGenerator
	@Inject extension ProcessorDaoGenerator

	override void doGenerate(Resource resource, IFileSystemAccess fsa) {
		for(e: resource.allContents.toIterable.filter(typeof(AnnotatedEntity))) {
			fsa.generateFile(e.eContainer.fullyQualifiedName.toString("/") + "/"+
				e.fullyQualifiedName + ".java",e.compile
			)
		}
		for(d: resource.allContents.toIterable.filter(typeof(PojoDao))) {
			val implPackage = getImplPackage(d)
			if (implPackage != null) {
	    		fsa.generateFile(d.eContainer.fullyQualifiedName.toString("/") + "/"+
		      		d.fullyQualifiedName + ".java",d.compileIfx
			    )
	    		fsa.generateFile(d.eContainer.fullyQualifiedName.toString("/") + "/"+ 
		      		implPackage + "/" + d.fullyQualifiedName + "Impl.java",d.compile
			    )
			}
			else {
	    		fsa.generateFile(d.eContainer.fullyQualifiedName.toString("/") + "/"+
		      		d.fullyQualifiedName + ".java",d.compile
			    )
			}
		}
	}
}
