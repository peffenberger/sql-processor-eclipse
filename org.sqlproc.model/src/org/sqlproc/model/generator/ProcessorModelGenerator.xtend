package org.sqlproc.model.generator

import org.eclipse.xtext.xbase.compiler.JvmModelGenerator
import org.eclipse.xtext.common.types.JvmEnumerationLiteral
import org.eclipse.xtext.xbase.compiler.output.ITreeAppendable
import org.eclipse.xtext.xbase.compiler.GeneratorConfig
import org.eclipse.xtext.common.types.JvmFormalParameter
import org.eclipse.xtext.common.types.JvmGenericArrayTypeReference

class ProcessorModelGenerator extends JvmModelGenerator {
	
	override generateEnumLiteral(JvmEnumerationLiteral it, ITreeAppendable appendable, GeneratorConfig config) {
      super.generateEnumLiteral(it, appendable, config)
      compilationStrategy?.apply(appendable)
    }

	override generateParameter(JvmFormalParameter it, ITreeAppendable appendable, boolean vararg, GeneratorConfig config) {
		if (it.name != 'sqlControl')
			super.generateParameter(it, appendable, vararg, config)
		else {
			val tracedAppendable = appendable.trace(it)
			annotations.generateAnnotations(tracedAppendable, false, config)
			parameterType.serializeSafely("Object", tracedAppendable)
			tracedAppendable.append(" ")
			val name = tracedAppendable.declareVariable(it, makeJavaIdentifier(simpleName))
			tracedAppendable.traceSignificant(it).append(name)
		}
	}
}