/*
 * generated by Xtext
 */
package org.sqlproc.dsl.generator

import org.eclipse.xtext.naming.IQualifiedNameProvider
import org.sqlproc.dsl.processorDsl.PojoProperty
import org.sqlproc.dsl.ImportManager

import static org.sqlproc.dsl.util.Utils.*
import static org.eclipse.xtext.EcoreUtil2.*
import org.sqlproc.dsl.processorDsl.PojoType
import org.sqlproc.dsl.processorDsl.EnumProperty
import org.sqlproc.dsl.processorDsl.PojoEntity
import com.google.inject.Inject
import org.sqlproc.dsl.processorDsl.PojoPropertyDirectiveUpdateCol
import org.sqlproc.dsl.processorDsl.PojoPropertyDirectiveCreateCol
import org.sqlproc.dsl.processorDsl.PojoPropertyDirectivePrimaryKey
import org.sqlproc.dsl.processorDsl.PojoPropertyDirectiveRequired
import org.sqlproc.dsl.processorDsl.PojoPropertyDirectiveIndex
import org.sqlproc.dsl.processorDsl.PojoPropertyDirectiveVersion
import org.sqlproc.dsl.processorDsl.EnumEntity
import java.util.List
import org.sqlproc.dsl.processorDsl.PojoDirectiveOperators
import org.sqlproc.dsl.processorDsl.PojoDao
import org.sqlproc.dsl.processorDsl.PojoDirectiveSerializable
import java.util.Map
import org.sqlproc.dsl.processorDsl.PojoDirectiveIndex
import java.util.TreeMap
import org.sqlproc.dsl.processorDsl.DaoDirectiveDiscriminator
import org.sqlproc.dsl.processorDsl.PojoDirectiveDiscriminator
import org.sqlproc.dsl.processorDsl.DaoDirectiveCrud
import org.sqlproc.dsl.processorDsl.DaoDirectiveQuery
import org.sqlproc.dsl.processorDsl.DaoDirective
import org.sqlproc.dsl.processorDsl.Artifacts
import org.eclipse.xtext.scoping.IScopeProvider
import org.eclipse.xtext.naming.IQualifiedNameConverter
import org.sqlproc.dsl.processorDsl.ProcessorDslPackage
import org.sqlproc.dsl.processorDsl.FunProcDirective
import org.eclipse.xtext.common.types.JvmPrimitiveType
import org.sqlproc.dsl.processorDsl.Implements
import org.sqlproc.dsl.processorDsl.ImplementsExtendsDirectiveGenerics
import org.sqlproc.dsl.processorDsl.Annotation
import org.sqlproc.dsl.processorDsl.AnnotatedEntity
import org.sqlproc.dsl.processorDsl.AnnotationDirectiveConflict
import org.sqlproc.dsl.processorDsl.AnnotationDirectiveConstructor
import org.sqlproc.dsl.processorDsl.AnnotationDirectiveStatic
import org.sqlproc.dsl.processorDsl.AnnotationDirectiveStandard

class ProcessorGeneratorUtils {

	@Inject extension IQualifiedNameProvider

    @Inject
    IScopeProvider scopeProvider

    @Inject
    IQualifiedNameConverter qualifiedNameConverter

	def compileType(EnumProperty f, ImportManager im) '''
	«IF f.getType != null»«im.serialize(f.getType)»«ENDIF»'''

	def compileType(PojoProperty f, ImportManager im) '''
	«IF f.getRef != null»«f.getRef.fullyQualifiedName»«ELSEIF f.
		getType != null»«im.serialize(f.getType)»«ENDIF»«IF f.getGtype != null»<«im.serialize(f.getGtype)»>«ENDIF»«IF f.
		getGref != null»<«f.getGref.fullyQualifiedName»>«ENDIF»«IF f.array»[]«ENDIF»'''

	def compileType(PojoType f, ImportManager im) '''
	«IF f.getRef != null»«im.serialize(pojoMethod2jvmType(f.getRef))»«ELSEIF f.
		getType != null»«im.serialize(f.getType)»«ENDIF»«IF f.getGtype != null»<«im.serialize(f.getGtype)»>«ENDIF»«IF f.
		getGref != null»<«im.serialize(pojoMethod2jvmType(f.getGref))»>«ENDIF»«IF f.array»[]«ENDIF»'''

	def completeName(PojoEntity e) {
		return getPackage(e) + "." + e.name
	}

	// Implements
    def isGenerics(Implements impl) {
		val d = impl.directives?.findFirst[x|x instanceof ImplementsExtendsDirectiveGenerics]
		return if(d != null) true else false
    }

	// PojoProperty
	def isRequired(PojoProperty f) {
		val d = f.directives?.findFirst[x|x instanceof PojoPropertyDirectiveRequired]
		return if(d != null) true else false
	}

	def getIndex(PojoProperty f) {
		val d = f.directives?.findFirst[x|x instanceof PojoPropertyDirectiveIndex] as PojoPropertyDirectiveIndex
		return d?.index
	}

	def getUpdateColumn1(PojoProperty f) {
		val d = f.directives?.findFirst[x|x instanceof PojoPropertyDirectiveUpdateCol] as PojoPropertyDirectiveUpdateCol
		return d?.updateColumn1
	}

	def getUpdateColumn2(PojoProperty f) {
		val d = f.directives?.findFirst[x|x instanceof PojoPropertyDirectiveUpdateCol] as PojoPropertyDirectiveUpdateCol
		return d?.updateColumn2
	}

	def getCreateColumn1(PojoProperty f) {
		val d = f.directives?.findFirst[x|x instanceof PojoPropertyDirectiveCreateCol] as PojoPropertyDirectiveCreateCol
		return d?.createColumn1
	}

	def getCreateColumn2(PojoProperty f) {
		val d = f.directives?.findFirst[x|x instanceof PojoPropertyDirectiveCreateCol] as PojoPropertyDirectiveCreateCol
		return d?.createColumn2
	}

	def isPrimaryKey(PojoProperty f) {
		val d = f.directives?.findFirst[x|x instanceof PojoPropertyDirectivePrimaryKey]
		return if(d != null) true else false
	}

	def isOptLock(PojoProperty f) {
		val d = f.directives?.findFirst[x|x instanceof PojoPropertyDirectiveVersion]
		return if(d != null) true else false
	}

	def isAttribute(PojoProperty f) {
		return if(f.attrs == null || f.attrs.isEmpty()) true else false
	}

	def isList(PojoProperty f) {
		val name = f?.type?.simpleName
		return "List" == name
	}

	def isNative(PojoProperty f) {
		return if (f.type != null && f.type instanceof JvmPrimitiveType) true else false
	}

	// PojoEntity

    def isAbstract(PojoEntity pojo) {
		val m = pojo.modifiers1?.findFirst[x|x.abstract]
		return if(m != null) true else false
    }

    def hasOperators(PojoEntity pojo) {
		val d = pojo.directives?.findFirst[x|x instanceof PojoDirectiveOperators]
		return if(d != null) true else false
    }

    def getOperatorsSuffix(PojoEntity pojo) {
		val d = pojo.directives?.findFirst[x|x instanceof PojoDirectiveOperators] as PojoDirectiveOperators
		return d?.operatorsSuffix
    }

    def String getSernum(PojoEntity pojo) {
		val d = pojo.directives?.findFirst[x|x instanceof PojoDirectiveSerializable] as PojoDirectiveSerializable
		return d?.sernum
    }
    
    def getDiscriminator(PojoEntity pojo) {
		val d = pojo?.directives?.findFirst[x|x instanceof PojoDirectiveDiscriminator] as PojoDirectiveDiscriminator
		return d?.discriminator
    }

    def isFinal(PojoEntity pojo) {
		val m = pojo.modifiers1?.findFirst[x|x.final]
		return if(m != null) true else false
    }

	def PojoEntity getSuperType(PojoEntity pojo) {
		val m = pojo?.modifiers2?.findFirst[x|x.superType != null]
		return m?.superType
	}

    def PojoEntity getParent(PojoEntity pojo) {
        if (getDiscriminator(pojo) != null)
            return null;
        return pojo.superType
    }

	def PojoProperty getOptLock(PojoEntity pojo) {
		val fea = pojo?.features?.findFirst[x|isOptLock(x.feature)]?.feature
		return fea ?: pojo?.getSuperType?.getOptLock
	}

    def Map<String, List<PojoProperty>> getIndex(PojoEntity pojo) {
        val Map<String, List<PojoProperty>> result = new TreeMap()
		pojo?.directives.filter[x|x instanceof PojoDirectiveIndex].forEach[
			val d = it as PojoDirectiveIndex
			result.put(d.index, d.proplist.features)
		]
        return result
    }

	def List<PojoProperty> requiredFeatures(PojoEntity pojo) {
		if (pojo == null)
			return newArrayList()
		val features = pojo.features.filter[x|x.feature.isRequired].map[feature].toList
		val se = pojo.superType
		if (se == null)
			return features
		features.addAll(se.requiredFeatures)
		return features
	}

	def List<PojoProperty> attributes(PojoEntity pojo) {
		if (pojo == null)
			return newArrayList()
		val features = pojo.features.filter[x|x.feature.isAttribute].map[feature].toList
		val se = pojo.superType
		if (se == null)
			return features
		features.addAll(se.requiredFeatures)
		return features
	}

    def PojoProperty getAttribute(PojoEntity pojo, String name) {
		if (pojo == null)
			return null
		val feature = pojo.features.findFirst[x|x.feature.isAttribute && x.feature.name == name].feature
		return feature ?: pojo.superType?.getAttribute(name)
    }

	// EnumEntity
    def isFinal(EnumEntity ^enum) {
		val m = ^enum.modifiers1?.findFirst[x|x.final]
		return if(m != null) true else false
    }

	def PojoEntity getSuperType(EnumEntity ^enum) {
		val m = ^enum.modifiers2?.findFirst[x|x.superType != null]
		return m?.superType
	}

    def String getSernum(EnumEntity ^enum) {
		val d = ^enum.directives?.findFirst[x|x instanceof PojoDirectiveSerializable] as PojoDirectiveSerializable
		return d?.sernum
    }

	// PojoDao
    def isFinal(PojoDao dao) {
		val m = dao.modifiers1?.findFirst[x|x.final]
		return if(m != null) true else false
    }

    def isAbstract(PojoDao dao) {
		val m = dao.modifiers1?.findFirst[x|x.abstract]
		return if(m != null) true else false
    }

    def getSernum(PojoDao dao) {
		val d = dao.directives?.findFirst[x|x instanceof PojoDirectiveSerializable] as PojoDirectiveSerializable
		return d?.sernum
    }

    def PojoDao getSuperType(PojoDao dao) {
		val m = dao.modifiers2?.findFirst[x|x.superType != null]
		return m?.superType
    }

    def Map<String, Map<String, PojoType>> getMoreResultClasses(PojoDao dao) {
        val Map<String, Map<String, PojoType>> result = new TreeMap()
		dao?.directives.filter[x|x instanceof DaoDirectiveDiscriminator].forEach[
			val d = it as DaoDirectiveDiscriminator
			val Map<String, PojoType> map = new TreeMap()
			d.descendants.forEach[dd|
				map.put(getValue(dd), dd.descendant)
			]
			result.put(d.ancestor.name, map)
		]
        return result
    }
    
    def getPojoDirective(PojoDao dao) {
    	dao?.directives.findFirst[x|x instanceof DaoDirectiveCrud || 
    		x instanceof DaoDirectiveQuery || x instanceof FunProcDirective
    	] 
    }
    
    def String getFunProcName(PojoDao dao) {
        var pojoName = dao.getName()
        if (pojoName.endsWith("Dao"))
            pojoName = pojoName.substring(0, pojoName.length() - 3)
        return pojoName.toFirstLower
	}    
	
    def PojoEntity getPojoImplicit(PojoDao dao) {
        var pojoName = dao.getName()
        if (pojoName.endsWith("Dao"))
            pojoName = pojoName.substring(0, pojoName.length() - 3)
        val Artifacts artifacts = getContainerOfType(dao, Artifacts)
        return findEntity(qualifiedNameConverter, artifacts,
                scopeProvider.getScope(artifacts, ProcessorDslPackage.Literals.ARTIFACTS__POJOS), pojoName)
    }

    def dispatch PojoEntity getPojo(PojoDao dao, DaoDirectiveCrud pojoDirective) {
    	return pojoDirective?.pojo?.ref ?: getPojoImplicit(dao)
    }

    def dispatch PojoEntity getPojo(PojoDao dao, DaoDirectiveQuery pojoDirective) {
    	return pojoDirective?.pojo?.ref ?: getPojoImplicit(dao)
    }

    def dispatch PojoEntity getPojo(PojoDao dao, FunProcDirective pojoDirective) {
    	return pojoDirective?.paramlist?.out?.ref ?: getPojoImplicit(dao)
    }

    def PojoEntity getPojo(PojoDao dao) {
    	val DaoDirective pojoDirective = dao?.getPojoDirective
    	return dao?.getPojo(pojoDirective)
    }

    def String getDaoImplements(PojoDao dao, Implements impl) {
        val StringBuilder sb = new StringBuilder()
        sb.append(impl.getImplements().getSimpleName())
        if (isGenerics(impl)) {
        	val pojo = getPojo(dao)
        	if (pojo != null)
        	sb.append("<").append(pojo.getName()).append(">");
        }
        return sb.toString();
    }

    def isCRUD(PojoDao dao) {
		val d = dao.directives?.findFirst[x|x instanceof DaoDirectiveCrud]
		return if(d != null) true else false
    }

    def isQuery(PojoDao dao) {
		val d = dao.directives?.findFirst[x|x instanceof DaoDirectiveQuery]
		return if(d != null) true else false
    }

    def listFunctionsDirectives(PojoDao dao) {
    	val List<FunProcDirective> result = newArrayList()
		dao.directives?.filter[x|x instanceof FunProcDirective].forEach[
			result.add(it as FunProcDirective)
		]
		return result
    }

	def getParamName(PojoType pojo) {
		if (pojo.ref != null)
			return pojo.ref.name.toFirstLower
		return pojo.type.simpleName.toFirstLower
	}

	// Annotations
    def isConflict(Annotation an) {
		val d = an.directives?.findFirst[x|x instanceof AnnotationDirectiveConflict]
		return if(d != null) true else false
    }
	
	def List<Annotation> conflictAnnotations(AnnotatedEntity pojo) {
		if (pojo == null)
			return newArrayList()
		return pojo.annotations.filter[x|x.isConflict].toList
	}

    def isConstructor(Annotation an) {
		val d = an.directives?.findFirst[x|x instanceof AnnotationDirectiveConstructor]
		return if(d != null) true else false
    }
	
	def List<Annotation> constructorAnnotations(AnnotatedEntity pojo) {
		if (pojo == null)
			return newArrayList()
		return pojo.annotations.filter[x|x.isConstructor].toList
	}

    def isStatic(Annotation an) {
		val d = an.directives?.findFirst[x|x instanceof AnnotationDirectiveStatic]
		return if(d != null) true else false
    }
	
	def List<Annotation> staticAnnotations(AnnotatedEntity pojo) {
		if (pojo == null)
			return newArrayList()
		return pojo.annotations.filter[x|x.isStatic].toList
	}

    def isStandard(Annotation an) {
    	if (an.directives == null || an.directives.isEmpty)
    		return true
		val d = an.directives?.findFirst[x|x instanceof AnnotationDirectiveStandard]
		return if(d != null) true else false
    }
	
	def List<Annotation> standardAnnotations(AnnotatedEntity pojo) {
		if (pojo == null)
			return newArrayList()
		return pojo.annotations.filter[x|x.isStandard].toList
	}
}
