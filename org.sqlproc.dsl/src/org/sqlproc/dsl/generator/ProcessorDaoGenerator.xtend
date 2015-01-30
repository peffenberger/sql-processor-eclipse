/*
 * generated by Xtext
 */
package org.sqlproc.dsl.generator

import org.sqlproc.dsl.processorDsl.PojoEntity
import com.google.inject.Inject
import org.eclipse.xtext.naming.IQualifiedNameProvider
import org.sqlproc.dsl.ImportManager

import static org.sqlproc.dsl.util.Utils.*;
import java.util.ArrayList
import org.sqlproc.dsl.processorDsl.Implements
import org.sqlproc.dsl.processorDsl.Extends
import org.sqlproc.dsl.processorDsl.PojoDao
import java.util.Map
import org.sqlproc.dsl.processorDsl.PojoType
import org.sqlproc.dsl.processorDsl.DaoDirectiveParameters
import org.sqlproc.dsl.processorDsl.FunctionCallQuery
import org.sqlproc.dsl.processorDsl.ProcedureCallQuery
import org.sqlproc.dsl.processorDsl.FunctionCall
import org.sqlproc.dsl.processorDsl.ProcedureUpdate
import org.sqlproc.dsl.processorDsl.FunctionQuery

/**
 * Generates code from your model files on save.
 * 
 * see http://www.eclipse.org/Xtext/documentation.html#TutorialCodeGeneration
 */
class ProcessorDaoGenerator {
	
	@Inject extension IQualifiedNameProvider
	@Inject extension ProcessorGeneratorUtils
	
	def compile(PojoDao d) '''
		«val im = new ImportManager(true)»
		«addImplements(d, im)»
		«addExtends(d, im)»
		«val moreResultClasses = getMoreResultClasses(d)»
		«val pojo = getPojo(d)»
		«val implPackage = getImplPackage(d)»
		«val classBody = compile(d, pojo, moreResultClasses, im, implPackage)»
		«IF d.eContainer != null»package «d.eContainer.fullyQualifiedName»«IF implPackage != null».«implPackage»«ENDIF»;«ENDIF»
		«IF implPackage != null»
		
		import «d.eContainer.fullyQualifiedName».«d.name»;
		«ENDIF»
		«IF !im.imports.empty»
			
		«FOR i : im.imports»
		import «i»;
		«ENDFOR»
		«ENDIF»
		«IF getSernum(d) != null»
		
		import java.io.Serializable;
		«ENDIF»
		
		import java.util.HashMap;
		import java.util.List;
		import java.util.Map;
		
		import org.slf4j.Logger;
		import org.slf4j.LoggerFactory;
		import org.sqlproc.engine.SqlControl;
		import org.sqlproc.engine.SqlCrudEngine;
		import org.sqlproc.engine.SqlEngineFactory;
		import org.sqlproc.engine.SqlQueryEngine;
		import org.sqlproc.engine.SqlProcedureEngine;
		import org.sqlproc.engine.SqlSession;
		import org.sqlproc.engine.SqlSessionFactory;
		import org.sqlproc.engine.impl.SqlStandardControl;
		«IF pojo != null»import «pojo.completeName»;«ENDIF»
		«FOR f:moreResultClasses.entrySet»«FOR a:f.value.values SEPARATOR "
		"»import «a.ref.completeName»;«ENDFOR»«ENDFOR»
		
		«classBody»
	'''
	
	def compile(PojoDao d, PojoEntity e, Map<String, Map<String, PojoType>> moreResultClasses, ImportManager im, String implPackage) '''
		public «IF isAbstract(d)»abstract «ENDIF»class «d.name»«IF implPackage != null»Impl«ENDIF» «compileExtends(d, im)»«compileImplements(d, implPackage)»{
			«IF getSernum(d) != null»
			
			private static final long serialVersionUID = «getSernum(d)»L;
			«ENDIF»
			protected final Logger logger = LoggerFactory.getLogger(getClass());
		
			protected SqlEngineFactory sqlEngineFactory;
			protected SqlSessionFactory sqlSessionFactory;
					
			public «d.name»«IF implPackage != null»Impl«ENDIF»() {
			}
					
			public «d.name»«IF implPackage != null»Impl«ENDIF»(SqlEngineFactory sqlEngineFactory) {
				this.sqlEngineFactory = sqlEngineFactory;
			}
					
			public «d.name»«IF implPackage != null»Impl«ENDIF»(SqlEngineFactory sqlEngineFactory, SqlSessionFactory sqlSessionFactory) {
				this.sqlEngineFactory = sqlEngineFactory;
				this.sqlSessionFactory = sqlSessionFactory;
			}
			
		«IF isCRUD(d)»«compileInsert(d, e, getParent(e), im, true)»
		«compileGet(d, e, moreResultClasses, im, true)»
		«compileUpdate(d, e, getParent(e), im, true)»
		«compileDelete(d, e, getParent(e), im, true)»«ENDIF»
		«IF isQuery(d)»
		«compileList(d, e, moreResultClasses, im, true)»
		«compileCount(d, e, moreResultClasses, im, true)»«ENDIF»
		«IF !moreResultClasses.isEmpty»«compileMoreResultClasses(d, e, moreResultClasses, im)»«ENDIF»
			«FOR fp: listFunctionsDirectives(d)»«compileFunctionProcedure(d, e, fp.type, fp.paramlist, im, true)»«ENDFOR»
		}
	'''
	
	def dispatch compileFunctionProcedure(PojoDao d, PojoEntity e, FunctionCallQuery type, DaoDirectiveParameters p, ImportManager im, boolean all) '''
		«val name = d.getFunProcName»
		public «p.out.compileType(im)» «name»(SqlSession sqlSession, «FOR ma:p.ins SEPARATOR ", "»«ma.compileType(im)» «ma.paramName»«ENDFOR», SqlControl sqlControl) {
			if (logger.isTraceEnabled()) {
				logger.trace("«name»: " + «FOR ma:p.ins SEPARATOR " + \" \" "»«ma.paramName»«ENDFOR» + " " + sqlControl);
			}
			SqlProcedureEngine sqlProc«d.name» = sqlEngineFactory.getCheckedProcedureEngine("FUN_«dbName(d)»");
			«p.out.compileType(im)» list = sqlProc«d.name».callQuery(sqlSession, «p.out.gref.name».class, «FOR ma:p.ins SEPARATOR ", "»«ma.paramName»«ENDFOR», sqlControl);
			if (logger.isTraceEnabled()) {
				logger.trace("«name» result: " + list);
			}
			return list;
		}
		«IF all»
		public «p.out.compileType(im)» «name»(«FOR ma:p.ins SEPARATOR ", "»«ma.compileType(im)» «ma.paramName»«ENDFOR», SqlControl sqlControl) {
			return «name»(sqlSessionFactory.getSqlSession(), «FOR ma:p.ins SEPARATOR ", "»«ma.paramName»«ENDFOR», sqlControl);
		}
		«ENDIF»
		public «p.out.compileType(im)» «name»(SqlSession sqlSession, «FOR ma:p.ins SEPARATOR ", "»«ma.compileType(im)» «ma.paramName»«ENDFOR») {
			return «name»(sqlSession, «FOR ma:p.ins SEPARATOR ", "»«ma.paramName»«ENDFOR», null);
		}
		«IF all»
		public «p.out.compileType(im)» «name»(«FOR ma:p.ins SEPARATOR ", "»«ma.compileType(im)» «ma.paramName»«ENDFOR») {
			return «name»(«FOR ma:p.ins SEPARATOR ", "»«ma.paramName»«ENDFOR», null);
		}
		«ENDIF»
	'''
	
	def dispatch compileFunctionProcedure(PojoDao d, PojoEntity e, ProcedureCallQuery type, DaoDirectiveParameters p, ImportManager im, boolean all) '''
		«val name = d.getFunProcName»
		public «p.out.compileType(im)» «name»(SqlSession sqlSession, «FOR ma:p.ins SEPARATOR ", "»«ma.compileType(im)» «ma.paramName»«ENDFOR», SqlControl sqlControl) {
			if (logger.isTraceEnabled()) {
				logger.trace("«name»: " + «FOR ma:p.ins SEPARATOR " + \" \" "»«ma.paramName»«ENDFOR» + " " + sqlControl);
			}
			SqlProcedureEngine sqlProc«d.name» = sqlEngineFactory.getCheckedProcedureEngine("PROC_«dbName(d)»");
			«p.out.compileType(im)» list = sqlProc«d.name».callQuery(sqlSession, «IF p.out.gref != null»«p.out.gref.name»«ELSE»«p.out.gtype.simpleName»«ENDIF».class, «FOR ma:p.ins SEPARATOR ", "»«ma.paramName»«ENDFOR», sqlControl);
			if (logger.isTraceEnabled()) {
				logger.trace("«name» result: " + list);
			}
			return list;
		}
		«IF all»
		public «p.out.compileType(im)» «name»(«FOR ma:p.ins SEPARATOR ", "»«ma.compileType(im)» «ma.paramName»«ENDFOR», SqlControl sqlControl) {
			return «name»(sqlSessionFactory.getSqlSession(), «FOR ma:p.ins SEPARATOR ", "»«ma.paramName»«ENDFOR», sqlControl);
		}
		«ENDIF»
		public «p.out.compileType(im)» «name»(SqlSession sqlSession, «FOR ma:p.ins SEPARATOR ", "»«ma.compileType(im)» «ma.paramName»«ENDFOR») {
			return «name»(sqlSession, «FOR ma:p.ins SEPARATOR ", "»«ma.paramName»«ENDFOR», null);
		}
		«IF all»
		public «p.out.compileType(im)» «name»(«FOR ma:p.ins SEPARATOR ", "»«ma.compileType(im)» «ma.paramName»«ENDFOR») {
			return «name»(«FOR ma:p.ins SEPARATOR ", "»«ma.paramName»«ENDFOR», null);
		}
		«ENDIF»
	'''
	
	def dispatch compileFunctionProcedure(PojoDao d, PojoEntity e, FunctionCall type, DaoDirectiveParameters p, ImportManager im, boolean all) '''
		«val name = d.getFunProcName»
		public «p.out.compileType(im)» «name»(SqlSession sqlSession, «FOR ma:p.ins SEPARATOR ", "»«ma.compileType(im)» «ma.paramName»«ENDFOR», SqlControl sqlControl) {
			if (logger.isTraceEnabled()) {
				logger.trace("«name»: " + «FOR ma:p.ins SEPARATOR " + \" \" "»«ma.paramName»«ENDFOR» + " " + sqlControl);
			}
			SqlProcedureEngine sqlFun«d.name» = sqlEngineFactory.getCheckedProcedureEngine("FUN_«dbName(d)»");
			Object result = sqlFun«d.name».callFunction(sqlSession, «FOR ma:p.ins SEPARATOR ", "»«ma.paramName»«ENDFOR», sqlControl);
			if (logger.isTraceEnabled()) {
				logger.trace("«name» result: " + result);
			}
			return («p.out.compileType(im)») result;
		}
		«IF all»
		public «p.out.compileType(im)» «name»(«FOR ma:p.ins SEPARATOR ", "»«ma.compileType(im)» «ma.paramName»«ENDFOR», SqlControl sqlControl) {
			return «name»(sqlSessionFactory.getSqlSession(), «FOR ma:p.ins SEPARATOR ", "»«ma.paramName»«ENDFOR», sqlControl);
		}
		«ENDIF»
		public «p.out.compileType(im)» «name»(SqlSession sqlSession, «FOR ma:p.ins SEPARATOR ", "»«ma.compileType(im)» «ma.paramName»«ENDFOR») {
			return «name»(sqlSession, «FOR ma:p.ins SEPARATOR ", "»«ma.paramName»«ENDFOR», null);
		}
		«IF all»
		public «p.out.compileType(im)» «name»(«FOR ma:p.ins SEPARATOR ", "»«ma.compileType(im)» «ma.paramName»«ENDFOR») {
			return «name»(«FOR ma:p.ins SEPARATOR ", "»«ma.paramName»«ENDFOR», null);
		}
		«ENDIF»
	'''
	
	def dispatch compileFunctionProcedure(PojoDao d, PojoEntity e, ProcedureUpdate type, DaoDirectiveParameters p, ImportManager im, boolean all) '''
		«val name = d.getFunProcName»
		public int «name»(SqlSession sqlSession, «FOR ma:p.ins SEPARATOR ", "»«ma.compileType(im)» «ma.paramName»«ENDFOR», SqlControl sqlControl) {
			if (logger.isTraceEnabled()) {
				logger.trace("«name»: " + «FOR ma:p.ins SEPARATOR " + \" \" "»«ma.paramName»«ENDFOR» + " " + sqlControl);
			}
			SqlProcedureEngine sqlProc«d.name» = sqlEngineFactory.getCheckedProcedureEngine("PROC_«dbName(d)»");
			int count = sqlProc«d.name».callUpdate(sqlSession, «FOR ma:p.ins SEPARATOR ", "»«ma.paramName»«ENDFOR», sqlControl);
			if (logger.isTraceEnabled()) {
				logger.trace("«name» result: " + count);
			}
			return count;
		}
		«IF all»
		public int «name»(«FOR ma:p.ins SEPARATOR ", "»«ma.compileType(im)» «ma.paramName»«ENDFOR», SqlControl sqlControl) {
			return «name»(sqlSessionFactory.getSqlSession(), «FOR ma:p.ins SEPARATOR ", "»«ma.paramName»«ENDFOR», sqlControl);
		}
		«ENDIF»
		public int «name»(SqlSession sqlSession, «FOR ma:p.ins SEPARATOR ", "»«ma.compileType(im)» «ma.paramName»«ENDFOR») {
			return «name»(sqlSession, «FOR ma:p.ins SEPARATOR ", "»«ma.paramName»«ENDFOR», null);
		}
		«IF all»
		public int «name»(«FOR ma:p.ins SEPARATOR ", "»«ma.compileType(im)» «ma.paramName»«ENDFOR») {
			return «name»(«FOR ma:p.ins SEPARATOR ", "»«ma.paramName»«ENDFOR», null);
		}
		«ENDIF»
	'''
	
	def dispatch compileFunctionProcedure(PojoDao d, PojoEntity e, FunctionQuery type, DaoDirectiveParameters p, ImportManager im, boolean all) '''
		«val name = d.getFunProcName»
		public «p.out.compileType(im)» «name»(SqlSession sqlSession, «FOR ma:p.ins SEPARATOR ", "»«ma.compileType(im)» «ma.paramName»«ENDFOR», SqlControl sqlControl) {
			if (logger.isTraceEnabled()) {
				logger.trace("«name»: " + «FOR ma:p.ins SEPARATOR " + \" \" "»«ma.paramName»«ENDFOR» + " " + sqlControl);
			}
			SqlQueryEngine sqlFun«d.name» = sqlEngineFactory.getCheckedQueryEngine("FUN_«dbName(d)»");
			java.util.List<«p.ins.get(0).compileType(im)»> list = sqlFun«d.name».query(sqlSession, «p.ins.get(0).compileType(im)».class, «FOR ma:p.ins SEPARATOR ", "»«ma.paramName»«ENDFOR», sqlControl);
			if (logger.isTraceEnabled()) {
				logger.trace("«name» result: " + list);
			}
			return (list != null && !list.isEmpty()) ? list.get(0).getResult() : null;
		}
		«IF all»
		public «p.out.compileType(im)» «name»(«FOR ma:p.ins SEPARATOR ", "»«ma.compileType(im)» «ma.paramName»«ENDFOR», SqlControl sqlControl) {
			return «name»(sqlSessionFactory.getSqlSession(), «FOR ma:p.ins SEPARATOR ", "»«ma.paramName»«ENDFOR», sqlControl);
		}
		«ENDIF»
		public «p.out.compileType(im)» «name»(SqlSession sqlSession, «FOR ma:p.ins SEPARATOR ", "»«ma.compileType(im)» «ma.paramName»«ENDFOR») {
			return «name»(sqlSession, «FOR ma:p.ins SEPARATOR ", "»«ma.paramName»«ENDFOR», null);
		}
		«IF all»
		public «p.out.compileType(im)» «name»(«FOR ma:p.ins SEPARATOR ", "»«ma.compileType(im)» «ma.paramName»«ENDFOR») {
			return «name»(«FOR ma:p.ins SEPARATOR ", "»«ma.paramName»«ENDFOR», null);
		}
		«ENDIF»
	'''
	
	def compileInsert(PojoDao d, PojoEntity e, PojoEntity pe, ImportManager im, boolean all) '''
	
		public «e.name» insert(SqlSession sqlSession, «e.name» «e.name.toFirstLower», SqlControl sqlControl) {
			if (logger.isTraceEnabled()) {
				logger.trace("insert «e.name.toFirstLower»: " + «e.name.toFirstLower» + " " + sqlControl);
			}
			SqlCrudEngine sqlInsert«e.name» = sqlEngineFactory.getCheckedCrudEngine("INSERT_«dbName(e)»");«IF pe != null»
			SqlCrudEngine sqlInsert«pe.name» = sqlEngineFactory.getCheckedCrudEngine("INSERT_«dbName(pe)»");
			int count = sqlInsert«pe.name».insert(sqlSession, «e.name.toFirstLower», sqlControl);
			if (count > 0) {
				sqlInsert«e.name».insert(sqlSession, «e.name.toFirstLower», sqlControl);
			}«ELSE»
			int count = sqlInsert«e.name».insert(sqlSession, «e.name.toFirstLower», sqlControl);«ENDIF»
			if (logger.isTraceEnabled()) {
				logger.trace("insert «e.name.toFirstLower» result: " + count + " " + «e.name.toFirstLower»);
			}
			return (count > 0) ? «e.name.toFirstLower» : null;
		}
		«IF all»
		public «e.name» insert(«e.name» «e.name.toFirstLower», SqlControl sqlControl) {
			return insert(sqlSessionFactory.getSqlSession(), «e.name.toFirstLower», sqlControl);
		}
		«ENDIF»
		public «e.name» insert(SqlSession sqlSession, «e.name» «e.name.toFirstLower») {
			return insert(sqlSession, «e.name.toFirstLower», null);
		}
		«IF all»
		public «e.name» insert(«e.name» «e.name.toFirstLower») {
			return insert(«e.name.toFirstLower», null);
		}
		«ENDIF»
	'''	
	def compileGet(PojoDao d, PojoEntity e, Map<String, Map<String, PojoType>> moreResultClasses, ImportManager im, boolean all) '''
	
		public «e.name» get(SqlSession sqlSession, «e.name» «e.name.toFirstLower», SqlControl sqlControl) {
			if (logger.isTraceEnabled()) {
				logger.trace("get get: " + «e.name.toFirstLower» + " " + sqlControl);
			}
			SqlCrudEngine sqlGetEngine«e.name» = sqlEngineFactory.getCheckedCrudEngine("GET_«dbName(e)»");
			«IF moreResultClasses.empty»//«ENDIF»sqlControl = getMoreResultClasses(«e.name.toFirstLower», sqlControl);
			«e.name» «e.name.toFirstLower»Got = sqlGetEngine«e.name».get(sqlSession, «e.name».class, «e.name.toFirstLower», sqlControl);
			if (logger.isTraceEnabled()) {
				logger.trace("get «e.name.toFirstLower» result: " + «e.name.toFirstLower»Got);
			}
			return «e.name.toFirstLower»Got;
		}
		«IF all»
		public «e.name» get(«e.name» «e.name.toFirstLower», SqlControl sqlControl) {
			return get(sqlSessionFactory.getSqlSession(), «e.name.toFirstLower», sqlControl);
		}
		«ENDIF»
		public «e.name» get(SqlSession sqlSession, «e.name» «e.name.toFirstLower») {
			return get(sqlSession, «e.name.toFirstLower», null);
		}
		«IF all»
		public «e.name» get(«e.name» «e.name.toFirstLower») {
			return get(«e.name.toFirstLower», null);
		}
		«ENDIF»
	'''
	
	def compileUpdate(PojoDao d, PojoEntity e, PojoEntity pe, ImportManager im, boolean all) '''
	
		public int update(SqlSession sqlSession, «e.name» «e.name.toFirstLower», SqlControl sqlControl) {
			if (logger.isTraceEnabled()) {
				logger.trace("update «e.name.toFirstLower»: " + «e.name.toFirstLower» + " " + sqlControl);
			}
			SqlCrudEngine sqlUpdateEngine«e.name» = sqlEngineFactory.getCheckedCrudEngine("UPDATE_«dbName(e)»");«IF pe != null»
			SqlCrudEngine sqlUpdate«pe.name» = sqlEngineFactory.getCheckedCrudEngine("UPDATE_«dbName(pe)»");«ENDIF»
			int count = sqlUpdateEngine«e.name».update(sqlSession, «e.name.toFirstLower», sqlControl);«IF pe != null»
			if (count > 0) {
				sqlUpdate«pe.name».update(sqlSession, «e.name.toFirstLower», sqlControl);
			}«ENDIF»«val f=getOptLock(e)»«IF f != null»
			if (count > 0) {
				«e.name.toFirstLower».set«f.name.toFirstUpper»(«e.name.toFirstLower».get«f.name.toFirstUpper»() + 1);
			}«ENDIF»
			if (logger.isTraceEnabled()) {
				logger.trace("update «e.name.toFirstLower» result count: " + count);
			}
			return count;
		}
		«IF all»
		public int update(«e.name» «e.name.toFirstLower», SqlControl sqlControl) {
			return update(sqlSessionFactory.getSqlSession(), «e.name.toFirstLower», sqlControl);
		}
		«ENDIF»
		public int update(SqlSession sqlSession, «e.name» «e.name.toFirstLower») {
			return update(sqlSession, «e.name.toFirstLower», null);
		}
		«IF all»
		public int update(«e.name» «e.name.toFirstLower») {
			return update(«e.name.toFirstLower», null);
		}
		«ENDIF»
	'''	
	def compileDelete(PojoDao d, PojoEntity e, PojoEntity pe, ImportManager im, boolean all) '''
	
		public int delete(SqlSession sqlSession, «e.name» «e.name.toFirstLower», SqlControl sqlControl) {
			if (logger.isTraceEnabled()) {
				logger.trace("delete «e.name.toFirstLower»: " + «e.name.toFirstLower» + " " + sqlControl);
			}
			SqlCrudEngine sqlDeleteEngine«e.name» = sqlEngineFactory.getCheckedCrudEngine("DELETE_«dbName(e)»");«IF pe != null»
			SqlCrudEngine sqlDelete«pe.name» = sqlEngineFactory.getCheckedCrudEngine("DELETE_«dbName(pe)»");«ENDIF»
			int count = sqlDeleteEngine«e.name».delete(sqlSession, «e.name.toFirstLower», sqlControl);«IF pe != null»
			if (count > 0) {
				sqlDelete«pe.name».delete(sqlSession, «e.name.toFirstLower», sqlControl);
			}«ENDIF»«val f=getOptLock(e)»«IF f != null»
			if (count > 0) {
				«e.name.toFirstLower».set«f.name.toFirstUpper»(«e.name.toFirstLower».get«f.name.toFirstUpper»() + 1);
			}«ENDIF»
			if (logger.isTraceEnabled()) {
				logger.trace("delete «e.name.toFirstLower» result count: " + count);
			}
			return count;
		}
		«IF all»
		public int delete(«e.name» «e.name.toFirstLower», SqlControl sqlControl) {
			return delete(sqlSessionFactory.getSqlSession(), «e.name.toFirstLower», sqlControl);
		}
		«ENDIF»
		public int delete(SqlSession sqlSession, «e.name» «e.name.toFirstLower») {
			return delete(sqlSession, «e.name.toFirstLower», null);
		}
		«IF all»
		public int delete(«e.name» «e.name.toFirstLower») {
			return delete(«e.name.toFirstLower», null);
		}
		«ENDIF»
	'''
	
	def compileList(PojoDao d, PojoEntity e, Map<String, Map<String, PojoType>> moreResultClasses, ImportManager im, boolean all) '''
	
		public List<«e.name»> list(SqlSession sqlSession, «e.name» «e.name.toFirstLower», SqlControl sqlControl) {
			if (logger.isTraceEnabled()) {
				logger.trace("list «e.name.toFirstLower»: " + «e.name.toFirstLower» + " " + sqlControl);
			}
			SqlQueryEngine sqlEngine«e.name» = sqlEngineFactory.getCheckedQueryEngine("SELECT_«dbName(e)»");
			«IF moreResultClasses.empty»//«ENDIF»sqlControl = getMoreResultClasses(«e.name.toFirstLower», sqlControl);
			List<«e.name»> «e.name.toFirstLower»List = sqlEngine«e.name».query(sqlSession, «e.name».class, «e.name.toFirstLower», sqlControl);
			if (logger.isTraceEnabled()) {
				logger.trace("list «e.name.toFirstLower» size: " + ((«e.name.toFirstLower»List != null) ? «e.name.toFirstLower»List.size() : "null"));
			}
			return «e.name.toFirstLower»List;
		}
		«IF all»
		public List<«e.name»> list(«e.name» «e.name.toFirstLower», SqlControl sqlControl) {
			return list(sqlSessionFactory.getSqlSession(), «e.name.toFirstLower», sqlControl);
		}
		«ENDIF»
		public List<«e.name»> list(SqlSession sqlSession, «e.name» «e.name.toFirstLower») {
			return list(sqlSession, «e.name.toFirstLower», null);
		}
		«IF all»
		public List<«e.name»> list(«e.name» «e.name.toFirstLower») {
			return list(«e.name.toFirstLower», null);
		}
		«ENDIF»
	'''
	
	def compileCount(PojoDao d, PojoEntity e, Map<String, Map<String, PojoType>> moreResultClasses, ImportManager im, boolean all) '''
	
		public int count(SqlSession sqlSession, «e.name» «e.name.toFirstLower», SqlControl sqlControl) {
			if (logger.isTraceEnabled()) {
				logger.trace("count «e.name.toFirstLower»: " + «e.name.toFirstLower» + " " + sqlControl);
			}
			SqlQueryEngine sqlEngine«e.name» = sqlEngineFactory.getCheckedQueryEngine("SELECT_«dbName(e)»");
			«IF moreResultClasses.empty»//«ENDIF»sqlControl = getMoreResultClasses(«e.name.toFirstLower», sqlControl);
			int count = sqlEngine«e.name».queryCount(sqlSession, «e.name.toFirstLower», sqlControl);
			if (logger.isTraceEnabled()) {
				logger.trace("count: " + count);
			}
			return count;
		}
		«IF all»
		public int count(«e.name» «e.name.toFirstLower», SqlControl sqlControl) {
			return count(sqlSessionFactory.getSqlSession(), «e.name.toFirstLower», sqlControl);
		}
		«ENDIF»
		public int count(SqlSession sqlSession, «e.name» «e.name.toFirstLower») {
			return count(sqlSession, «e.name.toFirstLower», null);
		}
		«IF all»
		public int count(«e.name» «e.name.toFirstLower») {
			return count(«e.name.toFirstLower», null);
		}
		«ENDIF»
	'''
	
	def compileMoreResultClasses(PojoDao d, PojoEntity e, Map<String, Map<String, PojoType>> moreResultClasses, ImportManager im) '''
	
		SqlControl getMoreResultClasses(«e.name» «e.name.toFirstLower», SqlControl sqlControl) {
			if (sqlControl != null && sqlControl.getMoreResultClasses() != null)
				return sqlControl;
			Map<String, Class<?>> moreResultClasses = null;
			«FOR f:moreResultClasses.entrySet SEPARATOR "
	"»		if («e.name.toFirstLower» != null && «e.name.toFirstLower».toInit(«e.name».Association.«f.key».name())) {
				if (moreResultClasses == null)
					moreResultClasses = new HashMap<String, Class<?>>();
			«FOR a:f.value.entrySet SEPARATOR "
	"»		moreResultClasses.put("«a.key»", «a.value.ref.fullyQualifiedName».class);«ENDFOR»
			}
			«ENDFOR»
			if (moreResultClasses != null) {
				sqlControl = new SqlStandardControl(sqlControl);
				((SqlStandardControl) sqlControl).setMoreResultClasses(moreResultClasses);
			}
			return sqlControl;
		}
	'''
	
	def compileIfx(PojoDao d) '''
	«val im = new ImportManager(true)»
	«addImplements(d, im)»
	«addExtends(d, im)»
	«val pojo = getPojo(d)»
	«val classBody = compileIfx(d, pojo, im)»
	«IF d.eContainer != null»package «d.eContainer.fullyQualifiedName»;«ENDIF»
	
	import java.util.List;
	import org.sqlproc.engine.SqlSession;
	import org.sqlproc.engine.SqlControl;
	import «pojo.completeName»;
	«IF !im.imports.empty»
	«FOR i : im.imports»
	import «i»;
	«ENDFOR»
	«ENDIF»
		
	«classBody»
	'''
	
	def compileIfx(PojoDao d, PojoEntity e, ImportManager im) '''
	public interface «d.name» {
		«IF isCRUD(d)»«compileInsertIfx(d, e, im, true)»
		«compileGetIfx(d, e, im, true)»
		«compileUpdateIfx(d, e, im, true)»
		«compileDeleteIfx(d, e, im, true)»«ENDIF»«IF isQuery(d)»
		«compileListIfx(d, e, im, true)»
		«compileCountIfx(d, e, im, true)»«ENDIF»
		«FOR fp: listFunctionsDirectives(d)»«compileFunctionProcedureIfx(d, e, fp.type, fp.paramlist, im, true)»«ENDFOR»
	}
	'''
	
	def dispatch compileFunctionProcedureIfx(PojoDao d, PojoEntity e, FunctionCallQuery type, DaoDirectiveParameters p, ImportManager im, boolean all) '''
		«val name = d.getFunProcName»
		public «p.out.compileType(im)» «name»(SqlSession sqlSession, «FOR ma:p.ins SEPARATOR ", "»«ma.compileType(im)» «ma.paramName»«ENDFOR», SqlControl sqlControl);
		«IF all»
		public «p.out.compileType(im)» «name»(«FOR ma:p.ins SEPARATOR ", "»«ma.compileType(im)» «ma.paramName»«ENDFOR», SqlControl sqlControl);
		«ENDIF»
		public «p.out.compileType(im)» «name»(SqlSession sqlSession, «FOR ma:p.ins SEPARATOR ", "»«ma.compileType(im)» «ma.paramName»«ENDFOR»);
		«IF all»
		public «p.out.compileType(im)» «name»(«FOR ma:p.ins SEPARATOR ", "»«ma.compileType(im)» «ma.paramName»«ENDFOR»);
		«ENDIF»
	'''
	
	def dispatch compileFunctionProcedureIfx(PojoDao d, PojoEntity e, ProcedureCallQuery type, DaoDirectiveParameters p, ImportManager im, boolean all) '''
		«val name = d.getFunProcName»
		public «p.out.compileType(im)» «name»(SqlSession sqlSession, «FOR ma:p.ins SEPARATOR ", "»«ma.compileType(im)» «ma.paramName»«ENDFOR», SqlControl sqlControl);
		«IF all»
		public «p.out.compileType(im)» «name»(«FOR ma:p.ins SEPARATOR ", "»«ma.compileType(im)» «ma.paramName»«ENDFOR», SqlControl sqlControl);
		«ENDIF»
		public «p.out.compileType(im)» «name»(SqlSession sqlSession, «FOR ma:p.ins SEPARATOR ", "»«ma.compileType(im)» «ma.paramName»«ENDFOR»);
		«IF all»
		public «p.out.compileType(im)» «name»(«FOR ma:p.ins SEPARATOR ", "»«ma.compileType(im)» «ma.paramName»«ENDFOR»);
		«ENDIF»
	'''
	
	def dispatch compileFunctionProcedureIfx(PojoDao d, PojoEntity e, FunctionCall type, DaoDirectiveParameters p, ImportManager im, boolean all) '''
		«val name = d.getFunProcName»
		public «p.out.compileType(im)» «name»(SqlSession sqlSession, «FOR ma:p.ins SEPARATOR ", "»«ma.compileType(im)» «ma.paramName»«ENDFOR», SqlControl sqlControl);
		«IF all»
		public «p.out.compileType(im)» «name»(«FOR ma:p.ins SEPARATOR ", "»«ma.compileType(im)» «ma.paramName»«ENDFOR», SqlControl sqlControl);
		«ENDIF»
		public «p.out.compileType(im)» «name»(SqlSession sqlSession, «FOR ma:p.ins SEPARATOR ", "»«ma.compileType(im)» «ma.paramName»«ENDFOR»);
		«IF all»
		public «p.out.compileType(im)» «name»(«FOR ma:p.ins SEPARATOR ", "»«ma.compileType(im)» «ma.paramName»«ENDFOR»);
		«ENDIF»
	'''
	
	def dispatch compileFunctionProcedureIfx(PojoDao d, PojoEntity e, ProcedureUpdate type, DaoDirectiveParameters p, ImportManager im, boolean all) '''
		«val name = d.getFunProcName»
		public int «name»(SqlSession sqlSession, «FOR ma:p.ins SEPARATOR ", "»«ma.compileType(im)» «ma.paramName»«ENDFOR», SqlControl sqlControl);
		«IF all»
		public int «name»(«FOR ma:p.ins SEPARATOR ", "»«ma.compileType(im)» «ma.paramName»«ENDFOR», SqlControl sqlControl);
		«ENDIF»
		public int «name»(SqlSession sqlSession, «FOR ma:p.ins SEPARATOR ", "»«ma.compileType(im)» «ma.paramName»«ENDFOR»);
		«IF all»
		public int «name»(«FOR ma:p.ins SEPARATOR ", "»«ma.compileType(im)» «ma.paramName»«ENDFOR»);
		«ENDIF»
	'''
	
	def dispatch compileFunctionProcedureIfx(PojoDao d, PojoEntity e, FunctionQuery type, DaoDirectiveParameters p, ImportManager im, boolean all) '''
		«val name = d.getFunProcName»
		public «p.out.compileType(im)» «name»(SqlSession sqlSession, «FOR ma:p.ins SEPARATOR ", "»«ma.compileType(im)» «ma.paramName»«ENDFOR», SqlControl sqlControl);
		«IF all»
		public «p.out.compileType(im)» «name»(«FOR ma:p.ins SEPARATOR ", "»«ma.compileType(im)» «ma.paramName»«ENDFOR», SqlControl sqlControl);
		«ENDIF»
		public «p.out.compileType(im)» «name»(SqlSession sqlSession, «FOR ma:p.ins SEPARATOR ", "»«ma.compileType(im)» «ma.paramName»«ENDFOR»);
		«IF all»
		public «p.out.compileType(im)» «name»(«FOR ma:p.ins SEPARATOR ", "»«ma.compileType(im)» «ma.paramName»«ENDFOR»);
		«ENDIF»
	'''
	
	def compileInsertIfx(PojoDao d, PojoEntity e, ImportManager im, boolean all) '''
	
		public «e.name» insert(SqlSession sqlSession, «e.name» «e.name.toFirstLower», SqlControl sqlControl);
		«IF all»
		public «e.name» insert(«e.name» «e.name.toFirstLower», SqlControl sqlControl);
		«ENDIF»
		public «e.name» insert(SqlSession sqlSession, «e.name» «e.name.toFirstLower»);
		«IF all»
		public «e.name» insert(«e.name» «e.name.toFirstLower»);
		«ENDIF»
	'''
	
	def compileGetIfx(PojoDao d, PojoEntity e, ImportManager im, boolean all) '''
	
		public «e.name» get(SqlSession sqlSession, «e.name» «e.name.toFirstLower», SqlControl sqlControl);
		«IF all»
		public «e.name» get(«e.name» «e.name.toFirstLower», SqlControl sqlControl);
		«ENDIF»
			public «e.name» get(SqlSession sqlSession, «e.name» «e.name.toFirstLower»);
		«IF all»
		public «e.name» get(«e.name» «e.name.toFirstLower»);
		«ENDIF»
	'''
	
	def compileUpdateIfx(PojoDao d, PojoEntity e, ImportManager im, boolean all) '''
	
		public int update(SqlSession sqlSession, «e.name» «e.name.toFirstLower», SqlControl sqlControl);
		«IF all»
		public int update(«e.name» «e.name.toFirstLower», SqlControl sqlControl);
		«ENDIF»
		public int update(SqlSession sqlSession, «e.name» «e.name.toFirstLower»);
		«IF all»
		public int update(«e.name» «e.name.toFirstLower»);
		«ENDIF»
	'''
	
	def compileDeleteIfx(PojoDao d, PojoEntity e, ImportManager im, boolean all) '''
	
		public int delete(SqlSession sqlSession, «e.name» «e.name.toFirstLower», SqlControl sqlControl);
		«IF all»
		public int delete(«e.name» «e.name.toFirstLower», SqlControl sqlControl);
		«ENDIF»
		public int delete(SqlSession sqlSession, «e.name» «e.name.toFirstLower»);
		«IF all»
		public int delete(«e.name» «e.name.toFirstLower»);
		«ENDIF»
	'''
	
	def compileListIfx(PojoDao d, PojoEntity e, ImportManager im, boolean all) '''
	
		public List<«e.name»> list(SqlSession sqlSession, «e.name» «e.name.toFirstLower», SqlControl sqlControl);
		«IF all»
		public List<«e.name»> list(«e.name» «e.name.toFirstLower», SqlControl sqlControl);
		«ENDIF»
		public List<«e.name»> list(SqlSession sqlSession, «e.name» «e.name.toFirstLower»);
		«IF all»
		public List<«e.name»> list(«e.name» «e.name.toFirstLower»);
		«ENDIF»
	'''
	
	def compileCountIfx(PojoDao d, PojoEntity e, ImportManager im, boolean all) '''
	
		public int count(SqlSession sqlSession, «e.name» «e.name.toFirstLower», SqlControl sqlControl);
		«IF all»
		public int count(«e.name» «e.name.toFirstLower», SqlControl sqlControl);
		«ENDIF»
		public int count(SqlSession sqlSession, «e.name» «e.name.toFirstLower»);
		«IF all»
		public int count(«e.name» «e.name.toFirstLower»);
		«ENDIF»
	'''
	
	def compileExtends(PojoDao e, ImportManager im) '''
		«IF getSuperType(e) != null»extends «getFullName(e, getSuperType(e), getSuperType(e).fullyQualifiedName, im)» «ELSEIF getExtends(e) != ""»extends «getExtends(e)» «ENDIF»'''
	
	def compileImplements(PojoDao d, String implPackage) '''
		«IF isImplements(d) || getSernum(d) != null || implPackage != null»implements «FOR f:getImplements(d) SEPARATOR ", " »«getDaoImplements(d, f)»«ENDFOR»«IF getSernum(d) != null»«IF isImplements(d)», «ENDIF»Serializable«ENDIF»«IF implPackage != null»«IF isImplements(d) || getSernum(d) != null», «ENDIF»«d.name»«ENDIF» «ENDIF»'''
	
	def addImplements(PojoDao e, ImportManager im) {
		for(impl: e.eContainer.eContents.filter(typeof(Implements))) {
			im.addImportFor(impl.getImplements())
		}
	}
	
	def addExtends(PojoDao e, ImportManager im) {
		for(ext: e.eContainer.eContents.filter(typeof(Extends))) {
			im.addImportFor(ext.getExtends())
		}
	}
	
	def isExtends(PojoDao e) {
		for(ext: e.eContainer.eContents.filter(typeof(Extends))) {
			if (!ext.onlyDaos.empty) {
				for (ee : ext.onlyDaos) {
					if (ee.name == e.name)
						return true
				}
				return false
			}
			for (ee : ext.exceptDaos) {
				if (ee.name == e.name)
					return false;
			}
			return true
		}
		return false
	}
	
	def isExtends(PojoDao e, Extends ext) {
		if (!ext.onlyDaos.empty) {
			for (ee : ext.onlyDaos) {
				if (ee.name == e.name)
				return true
			}
			return false
		}
		for (ee : ext.exceptDaos) {
			if (ee.name == e.name)
				return false;
		}
		return true
	}
	
	def getExtends(PojoDao e) {
		for(ext: e.eContainer.eContents.filter(typeof(Extends))) {
			if (isExtends(e, ext))
				return ext.getExtends().simpleName
		}
		return ""
	}
	
	def isImplements(PojoDao e) {
		for(ext: e.eContainer.eContents.filter(typeof(Implements))) {
			for (ee : ext.exceptDaos) {
				if (ee.name == e.name)
					return false;
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
	
	def isImplements(PojoDao e, Implements ext) {
		if (!ext.onlyDaos.empty) {
			for (ee : ext.onlyDaos) {
				if (ee.name == e.name)
				return true
			}
			return false
		}
		for (ee : ext.exceptDaos) {
			if (ee.name == e.name)
				return false;
		}
		return true
	}
	
	def getImplements(PojoDao e) {
		val list = new ArrayList<Implements>()
		
		for(ext: e.eContainer.eContents.filter(typeof(Implements))) {
			if (isImplements(e, ext))
				list.add(ext)
		}
		return list
	}
}
