/*
 * generated by Xtext
 */
package org.sqlproc.model.jvmmodel

import org.eclipse.xtext.naming.IQualifiedNameProvider
import org.sqlproc.model.processorModel.PojoAttribute
import org.sqlproc.model.processorModel.EnumAttribute
import org.sqlproc.model.processorModel.PojoEntity
import com.google.inject.Inject
import org.sqlproc.model.processorModel.PojoAttributeDirectiveUpdateCol
import org.sqlproc.model.processorModel.PojoAttributeDirectiveCreateCol
import org.sqlproc.model.processorModel.PojoAttributeDirectivePrimaryKey
import org.sqlproc.model.processorModel.PojoAttributeDirectiveRequired
import org.sqlproc.model.processorModel.PojoAttributeDirectiveIndex
import org.sqlproc.model.processorModel.PojoAttributeDirectiveVersion
import org.sqlproc.model.processorModel.EnumEntity
import java.util.List
import org.sqlproc.model.processorModel.PojoDirectiveOperators
import org.sqlproc.model.processorModel.DaoEntity
import org.sqlproc.model.processorModel.PojoDirectiveSerializable
import java.util.Map
import org.sqlproc.model.processorModel.PojoDirectiveIndex
import java.util.TreeMap
import org.sqlproc.model.processorModel.DaoDirectiveDiscriminator
import org.sqlproc.model.processorModel.PojoDirectiveDiscriminator
import org.sqlproc.model.processorModel.DaoDirectiveCrud
import org.sqlproc.model.processorModel.DaoDirectiveQuery
import org.sqlproc.model.processorModel.DaoDirective
import org.sqlproc.model.processorModel.Artifacts
import org.eclipse.xtext.scoping.IScopeProvider
import org.eclipse.xtext.naming.IQualifiedNameConverter
import org.sqlproc.model.processorModel.ProcessorModelPackage
import org.eclipse.xtext.common.types.JvmPrimitiveType
import org.sqlproc.model.processorModel.Implements
import org.sqlproc.model.processorModel.ImplementsExtendsDirectiveGenerics
import org.sqlproc.model.processorModel.Annotation
import org.sqlproc.model.processorModel.AnnotatedEntity
import org.sqlproc.model.processorModel.AnnotationDirectiveConflict
import org.sqlproc.model.processorModel.AnnotationDirectiveConstructor
import org.sqlproc.model.processorModel.AnnotationDirectiveStatic
import org.sqlproc.model.processorModel.AnnotationDirectiveStandard
import org.sqlproc.model.processorModel.AnnotationDirectiveSetter
import org.sqlproc.model.processorModel.AnnotationDirectiveGetter
import org.sqlproc.model.processorModel.AnnotationDirectiveAttribute
import org.sqlproc.model.processorModel.PojoAttributeDirectiveToInit
import org.sqlproc.model.processorModel.PojoAttributeDirectiveEnumInit
import org.sqlproc.model.processorModel.PojoAttributeDirectiveIsDef
import org.sqlproc.model.processorModel.PojoAttributeDirectiveEnumDef
import org.sqlproc.model.processorModel.PojoDirectiveToString
import org.sqlproc.model.processorModel.PojoDirectiveEquals
import org.sqlproc.model.processorModel.PojoDirectiveHashCode
import org.sqlproc.model.processorModel.Package
import org.sqlproc.model.processorModel.Entity
import org.sqlproc.model.processorModel.Extends
import org.sqlproc.model.processorModel.ImplementsExtendsDirectiveOnlyPojos
import org.sqlproc.model.processorModel.ImplementsExtendsDirectiveExceptPojos
import org.sqlproc.model.processorModel.ImplementsExtendsDirectiveOnlyDaos
import org.sqlproc.model.processorModel.ImplementsExtendsDirectiveExceptDaos
import org.sqlproc.model.processorModel.ValueType
import static extension org.eclipse.xtext.EcoreUtil2.*
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference
import org.eclipse.xtext.scoping.IScope
import org.eclipse.xtext.resource.IEObjectDescription
import org.sqlproc.model.processorModel.DaoDirectivePojo
import org.sqlproc.model.processorModel.DaoFunProcDirective
import org.sqlproc.model.util.Utils
import org.sqlproc.model.processorModel.PackageDirectiveImplementation
import org.sqlproc.plugin.lib.util.CommonUtils

class ProcessorGeneratorUtils {

	@Inject extension IQualifiedNameProvider

    @Inject
    IScopeProvider scopeProvider

    @Inject
    IQualifiedNameConverter qualifiedNameConverter

	// Implements
	
    def isGenerics(Implements impl) {
		val d = impl.directives?.findFirst[x|x instanceof ImplementsExtendsDirectiveGenerics]
		return if(d != null) true else false
    }

	// PojoAttribute
	
	def isRequired(PojoAttribute f) {
		val d = f.directives?.findFirst[x|x instanceof PojoAttributeDirectiveRequired]
		return if(d != null) true else false
	}

	def Integer getIndex(PojoAttribute f) {
		val d = f.directives?.findFirst[x|x instanceof PojoAttributeDirectiveIndex] as PojoAttributeDirectiveIndex
		return if (d != null) d.index else null
	}

	def getUpdateColumn1(PojoAttribute f) {
		val d = f.directives?.findFirst[x|x instanceof PojoAttributeDirectiveUpdateCol] as PojoAttributeDirectiveUpdateCol
		return d?.updateColumn1
	}

	def getUpdateColumn2(PojoAttribute f) {
		val d = f.directives?.findFirst[x|x instanceof PojoAttributeDirectiveUpdateCol] as PojoAttributeDirectiveUpdateCol
		return d?.updateColumn2
	}

	def getCreateColumn1(PojoAttribute f) {
		val d = f.directives?.findFirst[x|x instanceof PojoAttributeDirectiveCreateCol] as PojoAttributeDirectiveCreateCol
		return d?.createColumn1
	}

	def getCreateColumn2(PojoAttribute f) {
		val d = f.directives?.findFirst[x|x instanceof PojoAttributeDirectiveCreateCol] as PojoAttributeDirectiveCreateCol
		return d?.createColumn2
	}

	def isPrimaryKey(PojoAttribute f) {
		val d = f.directives?.findFirst[x|x instanceof PojoAttributeDirectivePrimaryKey]
		return if(d != null) true else false
	}

	def isOptLock(PojoAttribute f) {
		val d = f.directives?.findFirst[x|x instanceof PojoAttributeDirectiveVersion]
		return if(d != null) true else false
	}

	def isList(PojoAttribute f) {
		val name = f?.type?.simpleName
		return name.startsWith("List<")
	}

	def isNative(PojoAttribute f) {
		return if (f.type != null && f.type instanceof JvmPrimitiveType) true else false
	}

	def isToInit(PojoAttribute f) {
		val d = f.directives?.findFirst[x|x instanceof PojoAttributeDirectiveToInit]
		return if(d != null) true else false
	}

	def isEnumInit(PojoAttribute f) {
		val d = f.directives?.findFirst[x|x instanceof PojoAttributeDirectiveEnumInit]
		return if(d != null) true else false
	}

	def isIsDef(PojoAttribute f) {
		val d = f.directives?.findFirst[x|x instanceof PojoAttributeDirectiveIsDef]
		return if(d != null) true else false
	}

	def isEnumDef(PojoAttribute f) {
		val d = f.directives?.findFirst[x|x instanceof PojoAttributeDirectiveEnumDef]
		return if(d != null) true else false
	}

    def dispatch String constName(PojoAttribute attr) {
        return constantName(attr.name)
    }

    def dispatch String constName(List<PojoAttribute> l) {
        val StringBuilder result = new StringBuilder("")
        var first = true
        for (attr : l) {
            if (first) {
                first = false
            } else {
                result.append("_")
            }
            result.append(constantName(attr.name))
        }
        return result.toString()
    }

    def String constantName(String name) {
        val StringBuilder result = new StringBuilder("")
        for (c : name.toCharArray) {
            if (Character.isUpperCase(c)) {
            	result.append("_")
            	result.append(c)
            }
            else {
            	result.append(Character.toUpperCase(c))
            }
        }
        return result.toString
    }

    def String dbName(String name) {
        val StringBuilder result = new StringBuilder("")
        var boolean lastDigit = false
        for (c : name.toCharArray) {
            if (Character.isUpperCase(c) || (Character.isDigit(c) && !lastDigit)) {
            	result.append('_')
            	result.append(c)
            }
            else {
            	result.append(Character.toUpperCase(c))
            }
            lastDigit = Character.isDigit(c)
        }
        val s = result.toString
        if (s.startsWith('_'))
        	return s.substring(1)
        return s
    }

	// PojoEntity

   	def annotations(PojoEntity it) {
   		val an = getContainerOfType(typeof(AnnotatedEntity))
		an.annotations
	}

    def hasOperators(PojoEntity pojo) {
		val d = pojo.directives?.findFirst[x|x instanceof PojoDirectiveOperators]
		return if(d != null) true else false
    }

    def getOperatorsSuffix(PojoEntity pojo) {
		val d = pojo.directives?.findFirst[x|x instanceof PojoDirectiveOperators] as PojoDirectiveOperators
		return d?.operatorsSuffix
    }

    def Integer getSernum(PojoEntity pojo) {
		val d = pojo.directives?.findFirst[x|x instanceof PojoDirectiveSerializable] as PojoDirectiveSerializable
		return if (d != null) d.sernum else null
    }
    
    def getDiscriminator(PojoEntity pojo) {
		val d = pojo?.directives?.findFirst[x|x instanceof PojoDirectiveDiscriminator] as PojoDirectiveDiscriminator
		return d?.discriminator
    }

	def PojoAttribute getOptLock(PojoEntity pojo) {
		val fea = pojo?.attributes?.findFirst[x|isOptLock(x)]
		if (fea != null)
			return fea
		val se = pojo?.getSuperType
		if (se == null || !(se instanceof PojoEntity))
			return null
		return (se as PojoEntity).getOptLock
		}

    def Map<Integer, List<PojoAttribute>> getIndex(PojoEntity pojo) {
        val Map<Integer, List<PojoAttribute>> result = new TreeMap()
		pojo?.directives.filter[x|x instanceof PojoDirectiveIndex].forEach[
			val d = it as PojoDirectiveIndex
			result.put(d.index, d.proplist.features)
		]
        return result
    }

    def List<PojoAttribute> toStringAttributes(PojoEntity pojo) {
        val List<PojoAttribute> result = newArrayList()
		pojo?.directives.filter[x|x instanceof PojoDirectiveToString].forEach[
			val d = it as PojoDirectiveToString
			result.addAll(d.proplist.features)
		]
        return result
    }

    def List<PojoAttribute> equalsAttributes(PojoEntity pojo) {
        val List<PojoAttribute> result = newArrayList()
		pojo?.directives.filter[x|x instanceof PojoDirectiveEquals].forEach[
			val d = it as PojoDirectiveEquals
			result.addAll(d.proplist.features)
		]
        return result
    }

    def List<PojoAttribute> hashCodeAttributes(PojoEntity pojo) {
        val List<PojoAttribute> result = newArrayList()
		pojo?.directives.filter[x|x instanceof PojoDirectiveHashCode].forEach[
			val d = it as PojoDirectiveHashCode
			result.addAll(d.proplist.features)
		]
        return result
    }
//    def PojoEntity findEntity(IQualifiedNameConverter qualifiedNameConverter, Artifacts artifacts,
//            IScope scope, String name) {
//        for (description : scope.getAllElements()) {
//        	println(description)
//            val Package packageDeclaration = artifacts.eResource().getResourceSet()
//                    .getEObject(description.getEObjectURI(), true) as Package
//            for (aEntity : packageDeclaration.getElements()) {
//                if (aEntity instanceof AnnotatedEntity) {
//                    val ae = aEntity as AnnotatedEntity
//                    if (ae.entity instanceof PojoEntity) {
//                        val entity = ae.entity as PojoEntity
//                        if (name.equals(entity.name))
//                            return entity
//                    }
//                }
//            }
//        }
//        return null
//    }
	
    def PojoEntity getParentReflectInheritance(PojoEntity pojo) {
    	if (getDiscriminator(pojo) != null)
			return null;
		return getParent(pojo)
	}

    def PojoEntity getParent(PojoEntity pojo) {

    	val superType = pojo?.superType
    	if (superType == null)
    		return null;
    	if (superType instanceof PojoEntity)
    		return superType as PojoEntity
    	val Package pkg = getContainerOfType(pojo, Package)
    	val name = superType.simpleName
    	val AnnotatedEntity _pojo =  CommonUtils.getContentsOfType(pkg, AnnotatedEntity).findFirst[p|p.entity.name == name]
    	if (_pojo != null)
    		return _pojo.entity as PojoEntity
    	return null
    }

	def List<PojoAttribute> allRequiredAttributes(PojoEntity pojo) {
		val List<PojoAttribute> features = newArrayList()
		if (pojo == null)
			return features
		val se = pojo.parent
		if (se != null)
			features.addAll(se.allRequiredAttributes)
		features.addAll(pojo.attributes.filter[x|x.isRequired].toList)
		return features
	}

	def List<PojoAttribute> requiredAttributes(PojoEntity pojo) {
		val List<PojoAttribute> features = newArrayList()
		if (pojo == null)
			return features
		features.addAll(pojo.attributes.filter[x|x.isRequired].toList)
		return features
	}

	def List<PojoAttribute> parentRequiredAttributes(PojoEntity pojo) {
		val List<PojoAttribute> features = newArrayList()
		if (pojo == null)
			return features
		val se = pojo.parent
		if (se != null)
			features.addAll(se.allRequiredAttributes)
		return features
	}

	def List<PojoAttribute> allAttributes(PojoEntity pojo) {
		if (pojo == null)
			return newArrayList()
		val features = pojo.attributes.toList
		val se = pojo.parent
		if (se == null)
			return features
		features.addAll(se.allAttributes)
		return features
	}

	def Map<String, PojoAttribute> allAttributesAsMap(PojoEntity pojo) {
		val result = new TreeMap()
		if (pojo == null)
			return result
		pojo.attributes.forEach[
			result.put(it.name, it)
		]
		val se = pojo.parent
		if (se == null)
			return result
		result.putAll(se.allAttributesAsMap)
		return result
	}

	def List<PojoAttribute> toInitAttributes(PojoEntity pojo) {
		if (pojo == null)
			return newArrayList()
		val features = pojo.attributes.filter[x|x.isToInit].toList
		val se = pojo.parent
		if (se == null)
			return features
		features.addAll(se.toInitAttributes)
		return features
	}

	def List<PojoAttribute> enumInitAttributes(PojoEntity pojo) {
		if (pojo == null)
			return newArrayList()
		val features = pojo.attributes.filter[x|x.isEnumInit].toList
		val se = pojo.parent
		if (se == null)
			return features
		features.addAll(se.enumInitAttributes)
		return features
	}

	def List<PojoAttribute> isDefAttributes(PojoEntity pojo) {
		if (pojo == null)
			return newArrayList()
		val features = pojo.attributes.filter[x|x.isIsDef].toList
		val se = pojo.parent
		if (se == null)
			return features
		features.addAll(se.isDefAttributes)
		return features
	}

	def List<PojoAttribute> enumDefAttributes(PojoEntity pojo) {
		if (pojo == null)
			return newArrayList()
		val features = pojo.attributes.filter[x|x.isEnumDef].toList
		val se = pojo.parent
		if (se == null)
			return features
		features.addAll(se.enumDefAttributes)
		return features
	}
	
	def boolean hasIsDef(PojoEntity pojo) {
		val result = pojo.attributes.findFirst(f|f.isIsDef || f.isEnumDef)
		if (result != null)
			return true
		val se = pojo.superType
		if (se == null || !(se instanceof PojoEntity))
			return false
		return hasIsDef(se as PojoEntity)
	}
	
	def boolean hasToInit(PojoEntity pojo) {
		val result = pojo.attributes.findFirst(f|f.isToInit || f.isEnumInit)
		if (result != null)
			return true
		val se = pojo.parent
		if (se == null)
			return false
		return hasIsDef(se)
	}
	
    def PojoAttribute getAttribute(PojoEntity pojo, String name) {
		if (pojo == null || name == null)
			return null
		val feature = pojo.attributes.findFirst[x| x.name == name]
		if (feature != null)
			return feature
		val se = pojo.parent
		if (se == null)
			return null
		return se.getAttribute(name)
    }
	
	def PojoAttribute getPrimaryKey(PojoEntity pojo) {
		if (pojo == null)
			return null;
		val result = pojo.attributes.findFirst(f|f.isPrimaryKey)
		if (result != null)
			return result
		val se = pojo.superType
		if (se == null || !(se instanceof PojoEntity))
			return null
		return getPrimaryKey(se as PojoEntity)
	}

	// EnumEntity

   	def annotations(EnumEntity it) {
   		val an = getContainerOfType(typeof(AnnotatedEntity))
		an.annotations
	}

    def Integer getSernum(EnumEntity ^enum) {
		val d = ^enum.directives?.findFirst[x|x instanceof PojoDirectiveSerializable] as PojoDirectiveSerializable
		return if (d != null) d.sernum else null
    }

	// DaoEntity

   	def annotations(DaoEntity it) {
   		val an = getContainerOfType(typeof(AnnotatedEntity))
		an.annotations
	}
	
    def Integer getSernum(DaoEntity dao) {
		val d = dao.directives?.findFirst[x|x instanceof PojoDirectiveSerializable] as PojoDirectiveSerializable
		return if (d != null) d.sernum else null
    }

    def DaoEntity getParent(DaoEntity pojo) {
    	val superType = pojo?.superType
    	if (superType == null)
    		return null;
    	if (superType instanceof DaoEntity)
    		return superType as DaoEntity
    	val Package pkg = getContainerOfType(pojo, Package)
    	val DaoEntity _dao =  pkg?.eAllOfType(DaoEntity)?.findFirst[d|d.name == superType.simpleName]
    	if (_dao != null)
    		return _dao
    	return null
    }

    def Map<String, Map<String, JvmParameterizedTypeReference>> getMoreResultClasses(DaoEntity dao) {
        val Map<String, Map<String, JvmParameterizedTypeReference>> result = new TreeMap()
		dao?.directives.filter[x|x instanceof DaoDirectiveDiscriminator].forEach[
			val d = it as DaoDirectiveDiscriminator
			val Map<String, JvmParameterizedTypeReference> map = new TreeMap()
			d.descendants.forEach[dd|
				map.put(value0(dd.value), dd.descendant)
			]
			result.put(d.ancestor.name, map)
		]
        return result
    }
    
    def getPojoDirectiveIndirect(DaoEntity dao) {
    	dao?.directives.findFirst[x|x instanceof DaoDirectiveCrud || 
    		x instanceof DaoDirectiveQuery || x instanceof DaoFunProcDirective
    	] 
    }
    
    def String getFunProcName(DaoEntity dao) {
        var pojoName = dao.getName()
        if (pojoName.endsWith("Dao"))
            pojoName = pojoName.substring(0, pojoName.length() - 3)
        return pojoName.toFirstLower
	}    
	
    def PojoEntity getPojoImplicit(DaoEntity dao) {
        var pojoName = dao.getName()
        if (pojoName.endsWith("Dao"))
            pojoName = pojoName.substring(0, pojoName.length() - 3)
//        val Artifacts artifacts = getContainerOfType(dao, Artifacts)
//        return findEntity(qualifiedNameConverter, artifacts,
//                scopeProvider.getScope(artifacts, ProcessorModelPackage.Literals.ARTIFACTS__POJOS), pojoName)
		// TODO
		return null
    }
    
    def PojoEntity getPojo(DaoEntity dao) {
    	for (dir : dao.directives) {
    		if (dir instanceof DaoDirectiveCrud)
    			return (dir as DaoDirectiveCrud).pojo
    		else if (dir instanceof DaoDirectiveQuery)
    			return (dir as DaoDirectiveQuery).pojo
    		else if (dir instanceof DaoDirectivePojo)
    			return (dir as DaoDirectivePojo).pojo
    	}
    	return getPojoImplicit(dao)
    }

    def isCRUD(DaoEntity dao) {
		val d = dao.directives?.findFirst[x|x instanceof DaoDirectiveCrud]
		return if(d != null) true else false
    }

    def isQuery(DaoEntity dao) {
		val d = dao.directives?.findFirst[x|x instanceof DaoDirectiveQuery]
		return if(d != null) true else false
    }

    def isFunctionProcedure(DaoEntity dao) {
		val d = dao.directives?.findFirst[x|x instanceof DaoFunProcDirective]
		return if(d != null) true else false
    }

    def listFunctionsDirectives(DaoEntity dao) {
    	val List<DaoFunProcDirective> result = newArrayList()
		dao.directives?.filter[x|x instanceof DaoFunProcDirective].forEach[
			result.add(it as DaoFunProcDirective)
		]
		return result
    }

    def String getImplPackage(DaoEntity dao) {
    	val Package pkg = getContainerOfType(dao, Package)
		val d = pkg?.directives?.findFirst[x|x instanceof PackageDirectiveImplementation] as PackageDirectiveImplementation
		return if (d != null) d.implementation else null
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

	def List<Annotation> conflictAnnotations(PojoEntity pojo) {
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

	def List<Annotation> constructorAnnotations(PojoEntity pojo) {
		if (pojo == null)
			return newArrayList()
		return pojo.annotations.filter[x|x.isConstructor].toList
	}

	def List<Annotation> constructorAnnotations(DaoEntity pojo) {
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

	def List<Annotation> staticAnnotations(PojoEntity pojo) {
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
	
	def List<Annotation> standardAnnotations(PojoEntity pojo) {
		if (pojo == null)
			return newArrayList()
		return pojo.annotations.filter[x|x.isStandard].toList
	}
	
	def List<Annotation> standardAnnotations(DaoEntity pojo) {
		if (pojo == null)
			return newArrayList()
		return pojo.annotations.filter[x|x.isStandard].toList
	}

    def isSetter(Annotation an) {
		val d = an.directives?.findFirst[x|x instanceof AnnotationDirectiveSetter]
		return if(d != null) true else false
    }
	
	def List<Annotation> setterAnnotations(PojoAttribute prop) {
		if (prop == null)
			return newArrayList()
		return prop.annotations.filter[x|x.isSetter].toList
	}

    def isGetter(Annotation an) {
		val d = an.directives?.findFirst[x|x instanceof AnnotationDirectiveGetter]
		return if(d != null) true else false
    }
	
	def List<Annotation> getterAnnotations(PojoAttribute prop) {
		if (prop == null)
			return newArrayList()
		return prop.annotations.filter[x|x.isGetter].toList
	}

    def isAttribute(Annotation an) {
    	if (an.directives == null || an.directives.isEmpty)
    		return true
		val d = an.directives?.findFirst[x|x instanceof AnnotationDirectiveAttribute]
		return if(d != null) true else false
    }
	
	def List<Annotation> attributeAnnotations(PojoAttribute prop) {
		if (prop == null)
			return newArrayList()
		return prop.annotations.filter[x|x.isAttribute].toList
	}
	
	// Extends, Implements

	def List<PojoEntity> onlyPojos(Extends ext) {
    	val List<PojoEntity> result = newArrayList()
		ext.directives?.filter[x|x instanceof ImplementsExtendsDirectiveOnlyPojos].forEach[
			result.addAll((it as ImplementsExtendsDirectiveOnlyPojos).onlyPojos)
		]
		return result
	}

	def List<PojoEntity> exceptPojos(Extends ext) {
    	val List<PojoEntity> result = newArrayList()
		ext.directives?.filter[x|x instanceof ImplementsExtendsDirectiveExceptPojos].forEach[
			result.addAll((it as ImplementsExtendsDirectiveExceptPojos).exceptPojos)
		]
		return result
	}

	def List<PojoEntity> onlyPojos(Implements imp) {
    	val List<PojoEntity> result = newArrayList()
		imp.directives?.filter[x|x instanceof ImplementsExtendsDirectiveOnlyPojos].forEach[
			result.addAll((it as ImplementsExtendsDirectiveOnlyPojos).onlyPojos)
		]
		return result
	}

	def List<PojoEntity> exceptPojos(Implements imp) {
    	val List<PojoEntity> result = newArrayList()
		imp.directives?.filter[x|x instanceof ImplementsExtendsDirectiveExceptPojos].forEach[
			result.addAll((it as ImplementsExtendsDirectiveExceptPojos).exceptPojos)
		]
		return result
	}

	def List<DaoEntity> onlyDaos(Extends ext) {
    	val List<DaoEntity> result = newArrayList()
		ext.directives?.filter[x|x instanceof ImplementsExtendsDirectiveOnlyDaos].forEach[
			result.addAll((it as ImplementsExtendsDirectiveOnlyDaos).onlyDaos)
		]
		return result
	}

	def List<DaoEntity> exceptDaos(Extends ext) {
    	val List<DaoEntity> result = newArrayList()
		ext.directives?.filter[x|x instanceof ImplementsExtendsDirectiveExceptDaos].forEach[
			result.addAll((it as ImplementsExtendsDirectiveExceptDaos).exceptDaos)
		]
		return result
	}

	def List<DaoEntity> onlyDaos(Implements imp) {
    	val List<DaoEntity> result = newArrayList()
		imp.directives?.filter[x|x instanceof ImplementsExtendsDirectiveOnlyDaos].forEach[
			result.addAll((it as ImplementsExtendsDirectiveOnlyDaos).onlyDaos)
		]
		return result
	}

	def List<DaoEntity> exceptDaos(Implements imp) {
    	val List<DaoEntity> result = newArrayList()
		imp.directives?.filter[x|x instanceof ImplementsExtendsDirectiveExceptDaos].forEach[
			result.addAll((it as ImplementsExtendsDirectiveExceptDaos).exceptDaos)
		]
		return result
	}

	def getExtends(EnumEntity e) {
		for(ext: e.eContainer.eContainer.eContents.filter(typeof(Extends))) {
			return ext.getExtends().simpleName
		}
		return ""
	}
	
	def isImplements(EnumEntity e) {
		for(ext: e.eContainer.eContainer.eContents.filter(typeof(Implements))) {
			return true
		}
		return false
	}
	
	def isExtends(PojoEntity e) {
		for(ext: e.eContainer.eContainer.eContents.filter(typeof(Extends))) {
			if (!ext.onlyPojos.empty) {
				for (ee : ext.onlyPojos) {
					if (ee.name == e.name)
						return true
				}
				return false
			}
			for (ee : ext.exceptPojos) {
				if (ee.name == e.name)
					return false
			}
			return true
		}
		return false
	}
	
	def isExtends(PojoEntity e, Extends ext) {
		if (!ext.onlyPojos.empty) {
			for (ee : ext.onlyPojos) {
				if (ee.name == e.name)
				return true
			}
			return false
		}
		for (ee : ext.exceptPojos) {
			if (ee.name == e.name)
				return false
		}
		return true
	}
	
	def getExtends(PojoEntity e) {
		for(ext: e.eContainer.eContainer.eContents.filter(typeof(Extends))) {
			if (isExtends(e, ext))
				return ext
		}
		return null
	}
	
	def isImplements(PojoEntity e) {
		for(ext: e.eContainer.eContainer.eContents.filter(typeof(Implements))) {
			for (ee : ext.exceptPojos) {
				if (ee.name == e.name)
					return false
			}
			if (!ext.onlyPojos.empty) {
				for (ee : ext.onlyPojos) {
					if (ee.name == e.name)
						return true
				}
			}
			else {
				return true
			}
		}
		return false
	}
	
	def isImplements(PojoEntity e, Implements ext) {
		if (!ext.onlyPojos.empty) {
			for (ee : ext.onlyPojos) {
				if (ee.name == e.name)
				return true
			}
			return false
		}
		for (ee : ext.exceptPojos) {
			if (ee.name == e.name)
				return false
		}
		return true
	}
	
	def getImplements(PojoEntity e) {
		val List<Implements> list = newArrayList()
		
		for(ext: e.eContainer.eContainer.eContents.filter(typeof(Implements))) {
			if (isImplements(e, ext))
				list.add(ext)
		}
		return list
	}

	def isExtends(DaoEntity e) {
		for(ext: e.eContainer.eContainer.eContents.filter(typeof(Extends))) {
			if (!ext.onlyDaos.empty) {
				for (ee : ext.onlyDaos) {
					if (ee.name == e.name)
						return true
				}
				return false
			}
			for (ee : ext.exceptDaos) {
				if (ee.name == e.name)
					return false
			}
			return true
		}
		return false
	}
	
	def isExtends(DaoEntity e, Extends ext) {
		if (!ext.onlyDaos.empty) {
			for (ee : ext.onlyDaos) {
				if (ee.name == e.name)
				return true
			}
			return false
		}
		for (ee : ext.exceptDaos) {
			if (ee.name == e.name)
				return false
		}
		return true
	}
	
	def getExtends(DaoEntity e) {
		for(ext: e.eContainer.eContainer.eContents.filter(typeof(Extends))) {
			if (isExtends(e, ext))
				return ext
		}
		return null
	}
	
	def isImplements(DaoEntity e) {
		for(ext: e.eContainer.eContainer.eContents.filter(typeof(Implements))) {
			for (ee : ext.exceptDaos) {
				if (ee.name == e.name)
					return false
			}
			if (!ext.onlyDaos.empty) {
				for (ee : ext.onlyDaos) {
					if (ee.name == e.name)
						return true
				}
			}
			else {
				return true
			}
		}
		return false
	}
	
	def isImplements(DaoEntity e, Implements ext) {
		if (!ext.onlyDaos.empty) {
			for (ee : ext.onlyDaos) {
				if (ee.name == e.name)
				return true
			}
			return false
		}
		for (ee : ext.exceptDaos) {
			if (ee.name == e.name)
				return false
		}
		return true
	}
	
	def getImplements(DaoEntity e) {
		val List<Implements> list = newArrayList()
		
		for(ext: e.eContainer.eContainer.eContents.filter(typeof(Implements))) {
			if (isImplements(e, ext))
				list.add(ext)
		}
		return list
	}

	// Misc
	
    def String value(ValueType pv) {
        if (pv == null)
            return null
        var String s = pv.getValue()
        if (s != null) {
            s = s.trim()
            if (!s.startsWith("\""))
                s = "\"" + s
            if (!s.endsWith("\""))
                s = s + "\""
            return s
        } else if (pv.getId() != null)
            return pv.getId()
        else
            return "" + pv.getNumber()
    }

    def String value0(ValueType pv) {
        if (pv == null)
            return null
        var String s = pv.getValue()
        if (s != null) {
            s = s.trim()
            return s
        } else if (pv.getId() != null)
            return pv.getId()
        else
            return "" + pv.getNumber()
    }
   	
   	def String getSimpleName(JvmParameterizedTypeReference ref) {
   		val StringBuilder name = new StringBuilder(ref.type.simpleName)
   		if (ref.arguments != null && !ref.arguments.empty) {
   			name.append('<')
   			var boolean first = true
   			for (arg : ref.arguments) {
   				if (first)
   					first = false
   				else
   					name.append(',')
   				name.append(arg.simpleName)
   			} 
   			name.append('>')
   		}
   		return name.toString	
   	}
}