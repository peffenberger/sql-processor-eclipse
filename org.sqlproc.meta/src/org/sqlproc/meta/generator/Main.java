/*
 * generated by Xtext
 */
package org.sqlproc.meta.generator;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.generator.JavaIoFileSystemAccess;
import org.eclipse.xtext.resource.IResourceFactory;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.scoping.IScopeProvider;
import org.eclipse.xtext.validation.IResourceValidator;
import org.sqlproc.meta.processorMeta.Artifacts;
import org.sqlproc.meta.processorMeta.MetaStatement;
import org.sqlproc.meta.property.ModelPropertyBean;
import org.sqlproc.meta.property.ModelPropertyBean.ModelValues;
import org.sqlproc.plugin.lib.resolver.DbResolver;
import org.sqlproc.plugin.lib.resolver.DbResolverBean;
import org.sqlproc.plugin.lib.util.MainUtils;

import com.google.common.io.Files;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Provider;

public class Main {

	@Inject
	private Provider<ResourceSet> resourceSetProvider;
	@Inject
	private IResourceValidator validator;
	@Inject
	private JavaIoFileSystemAccess fileAccess;
	@Inject
	IScopeProvider scopeProvider;
	@Inject
	private IResourceFactory resourceFactory;

	public static void main(String[] args) throws IOException, ClassNotFoundException {

		String target = null;
		String source = null;
		String control = null;
		String sql = null;
		String ddl = null;
		boolean merge = true;
		boolean generate = true;
		for (int i = 0; i < args.length; i++) {
			String arg = args[i];
			if ("-target".equals(arg) && i < args.length - 1)
				target = args[++i];
			else if ("-source".equals(arg) && i < args.length - 1)
				source = args[++i];
			else if ("-control".equals(arg) && i < args.length - 1)
				control = args[++i];
			else if ("-sql".equals(arg) && i < args.length - 1)
				sql = args[++i];
			else if ("-ddl".equals(arg) && i < args.length - 1)
				ddl = args[++i];
			else if ("-nomerge".equals(arg))
				merge = false;
			else if ("-verify".equals(arg))
				generate = false;
			else {
				usage(arg);
				return;
			}
		}
		if (control == null || sql == null) {
			usage(null);
			return;
		}

		Injector injector = new org.sqlproc.meta.ProcessorMetaStandaloneSetup().createInjectorAndDoEMFRegistration();
		Main main = injector.getInstance(Main.class);

		if (target == null)
			target = "./";
		else if (!target.endsWith("/"))
			target = target + "/";
		if (source == null)
			source = "";
		else if (!source.endsWith("/"))
			source = source + "/";

		main.runGenerator(control, sql, ddl, source, target, merge);
	}

	private static void usage(String arg) {
		System.out.println();
		if (arg != null)
			System.out.println("Incorrect argument '" + arg + "'.");
		else
			System.out.println("Incorrect usage.");
		System.out.println("META SQL models generation using control directives:");
		System.out
		        .println("  java -jar sqlmeta.jar -control controlDirectivesFile -sql metaSqlsFile [-ddl ddlsFile] [-source sourceDir] [-target targetDir] [-nomerge]");
		System.out.println("For example:");
		System.out.println("  java -jar sqlmeta.jar -control definitions.meta -sql statements.meta");
		System.out.println();
		System.out.println("Arguments:");
		System.out.println("  -target dirname - a target directory (eg. src-gen)");
		System.out.println("  -source dirname - a source directory (eg. src/main/resources)");
		System.out.println("  -control filename - a control directives file name");
		System.out.println("  -sql filename - a META SQLs file name");
		System.out.println("  -ddl filename - a DDLs file name");
		System.out.println("  -nomerge - do not merge generated artefacts with existing ones");
		System.out.println("  -verify - do not generate Java source files, only verify models files");
		System.out.println();
		System.exit(1);
	}

	protected void runGenerator(String control, String sql, String ddl, String source, String target, boolean merge)
	        throws IOException, ClassNotFoundException {

		ResourceSet resourceSet = resourceSetProvider.get();
		Resource controlResource = resourceSet.getResource(URI.createURI(MainUtils.getFile(source, control)), true);
		resourceSet.getResources().add(controlResource);
		Resource sqlResource = null;
		if (merge) {
			try {
				sqlResource = resourceSet.getResource(URI.createURI(MainUtils.getFile(source, sql)), true);
				resourceSet.getResources().add(sqlResource);
			} catch (Exception ex) {
				System.out.println("Can't read " + MainUtils.getFile(source, sql));
			}
		}

		System.out.println("Going to validate " + controlResource);
		Set<String> failedReferences = new HashSet<String>();
		int controlResourceIsOk = MainUtils.isValid(controlResource, failedReferences, validator);
		if (controlResourceIsOk == MainUtils.ERROR) {
			System.exit(2);
			return;
		} else if (controlResourceIsOk == MainUtils.REFERENCE_ERROR) {
			String controlResourceContent = MainUtils.handleResourceReferences(controlResource, failedReferences);
			System.out.println(controlResourceContent);
			controlResource = MainUtils.reloadResourceFromString(controlResourceContent, resourceSet, resourceFactory);
			controlResourceIsOk = MainUtils.isValid(controlResource, failedReferences, validator);
			if (controlResourceIsOk != MainUtils.OK) {
				System.exit(2);
				return;
			}
		}
		System.out.println("Validated " + controlResource);
		if (merge && sqlResource != null) {
			System.out.println("Going to validate " + sqlResource);
			int sqlResourceIsOk = MainUtils.isValid(sqlResource, null, validator);
			if (sqlResourceIsOk != MainUtils.OK) {
				System.exit(2);
				return;
			}
			System.out.println("Validated " + sqlResource);
		}

		Artifacts definitions = (Artifacts) controlResource.getContents().get(0);
		if (definitions.getProperties().isEmpty()) {
			System.err.println("No control directive.");
			System.exit(3);
			return;
		}
		fileAccess.setOutputPath(target);
		ModelValues modelValues = ModelPropertyBean.loadModel(null, definitions);
		modelValues.doResolveDb = true;
		ModelPropertyBean modelProperty = new ModelPropertyBean(modelValues);
		String sDbDriver = modelProperty.getModelValues(null).dbDriver;
		Class<?> driverClass = this.getClass().getClassLoader().loadClass(sDbDriver);
		String dbSqlsBefore = null;
		if (ddl != null) {
			File file = new File(MainUtils.getFile(source, ddl));
			dbSqlsBefore = new String(Files.toByteArray(file));
		}
		DbResolver dbResolver = new DbResolverBean(modelProperty, driverClass, dbSqlsBefore, null);

		Artifacts sqls = null;
		List<MetaStatement> statements = null;
		if (!merge) {
			statements = new ArrayList<MetaStatement>();
		} else {
			if (sqlResource != null) {
				sqls = (Artifacts) sqlResource.getContents().get(0);
				statements = sqls.getStatements();
			}
		}

		System.out.println("Going to generate " + sql);
		String metaDefinitions = TableMetaGenerator.generateMeta(definitions, statements,
		        ((XtextResource) controlResource).getSerializer(), dbResolver, scopeProvider, modelProperty);
		fileAccess.generateFile(sql, metaDefinitions);
		System.out.println(sql + " generation finished.");
	}
}
