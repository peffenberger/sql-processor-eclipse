/*
 * generated by Xtext
 */
package org.sqlproc.dsl.generator;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.generator.JavaIoFileSystemAccess;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.scoping.IScopeProvider;
import org.eclipse.xtext.serializer.ISerializer;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IResourceValidator;
import org.eclipse.xtext.validation.Issue;
import org.sqlproc.dsl.processorDsl.AbstractPojoEntity;
import org.sqlproc.dsl.processorDsl.AnnotatedEntity;
import org.sqlproc.dsl.processorDsl.Artifacts;
import org.sqlproc.dsl.processorDsl.EnumEntity;
import org.sqlproc.dsl.processorDsl.MetaStatement;
import org.sqlproc.dsl.processorDsl.PackageDeclaration;
import org.sqlproc.dsl.processorDsl.PojoDao;
import org.sqlproc.dsl.processorDsl.PojoEntity;
import org.sqlproc.dsl.property.ModelPropertyBean;
import org.sqlproc.dsl.property.ModelPropertyBean.ModelValues;
import org.sqlproc.dsl.resolver.DbResolver;
import org.sqlproc.dsl.resolver.DbResolver.DbType;
import org.sqlproc.dsl.resolver.DbResolverBean;
import org.sqlproc.dsl.util.Annotations;
import org.sqlproc.dsl.util.Utils;

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
    private IGenerator2 generator;
    @Inject
    private JavaIoFileSystemAccess fileAccess;
    @Inject
    IScopeProvider scopeProvider;

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        String models = null;
        String target = null;
        String source = null;
        String control = null;
        String pojo = null;
        String dao = null;
        String sql = null;
        String ddl = null;
        boolean merge = true;
        boolean generate = true;
        for (int i = 0; i < args.length; i++) {
            String arg = args[i];
            if ("-models".equals(arg) && i < args.length - 1)
                models = args[++i];
            else if ("-target".equals(arg) && i < args.length - 1)
                target = args[++i];
            else if ("-source".equals(arg) && i < args.length - 1)
                source = args[++i];
            else if ("-control".equals(arg) && i < args.length - 1)
                control = args[++i];
            else if ("-pojo".equals(arg) && i < args.length - 1)
                pojo = args[++i];
            else if ("-dao".equals(arg) && i < args.length - 1)
                dao = args[++i];
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
        if (models == null && (control == null || pojo == null || dao == null || sql == null)) {
            usage(null);
            return;
        }

        Injector injector = new org.sqlproc.dsl.ProcessorDslStandaloneSetup().createInjectorAndDoEMFRegistration();
        Main main = injector.getInstance(Main.class);

        if (target == null)
            target = (models != null) ? "src-gen/" : "./";
        else if (!target.endsWith("/"))
            target = target + "/";
        if (source == null)
            source = "";
        else if (!source.endsWith("/"))
            source = source + "/";

        if (models != null) {
            main.runGenerator(models, source, target, generate);
        } else if (control != null) {
            main.runGenerator(control, pojo, dao, sql, ddl, source, target, merge);
        }
    }

    private static void usage(String arg) {
        System.out.println();
        if (arg != null)
            System.out.println("Incorrect argument '" + arg + "'. Two modes are supported.");
        else
            System.out.println("Incorrect usage. Two modes are supported.");
        System.out.println("Mode 1: POJO & DAO Java source files generation using model files:");
        System.out
                .println("  java -jar sqlep.jar -models modelsFile1,modelsFile2... [-source sourceDir] [-target targetDir] [-verify]");
        System.out.println("For example:");
        System.out.println("  java -jar sqlep.jar -models pojo.qry,dao.qry -target src-gen");
        System.out.println("Mode 2: POJO, DAO and META SQL models generation using control directives:");
        System.out
                .println("  java -jar sqlep.jar -control controlDirectivesFile -pojo pojoModelsFile -dao daoModelsFile -sql metaSqlsFile [-ddl ddlsFile] [-source sourceDir] [-target targetDir] [-nomerge]");
        System.out.println("For example:");
        System.out
                .println("  java -jar sqlep.jar -control definitions.qry -pojo pojo.qry -dao dao.qry -sql statements.qry");
        System.out.println();
        System.out.println("Arguments:");
        System.out
                .println("  -models filename[.filename] - comma separated list of model files names (eg. pojo.qry,dao.qry)");
        System.out.println("  -target dirname - a target directory (eg. src-gen)");
        System.out.println("  -source dirname - a source directory (eg. src/main/resources)");
        System.out.println("  -control filename - a control directives file name");
        System.out.println("  -pojo filename - a POJO models file name");
        System.out.println("  -dao filename - a DAO models file name");
        System.out.println("  -sql filename - a META SQLs file name");
        System.out.println("  -ddl filename - a DDLs file name");
        System.out.println("  -nomerge - do not merge generated artefacts with existing ones");
        System.out.println("  -verify - do not generate Java source files, only verify models files");
        System.out.println();
    }

    protected void runGenerator(String models, String source, String target, boolean generate) throws IOException,
            ClassNotFoundException {

        String[] sResources = models.split(",");
        ResourceSet set = resourceSetProvider.get();
        List<Resource> set2 = new ArrayList<Resource>();
        for (String sResource : sResources) {
            Resource resource = set.getResource(URI.createURI(getFile(source, sResource)), true);
            set.getResources().add(resource);
            set2.add(resource);
        }

        for (Resource resource : set2) {
            if (!isValid(resource))
                return;
        }
        System.out.println("Resource(s) validation finished.");

        if (generate) {
            fileAccess.setOutputPath(target);
            generator.doGenerate(set, fileAccess);
            System.out.println("Java code generation finished.");
        }
    }

    protected void runGenerator(String control, String pojo, String dao, String sql, String ddl, String source,
            String target, boolean merge) throws IOException, ClassNotFoundException {

        ResourceSet set = resourceSetProvider.get();
        Resource controlResource = set.getResource(URI.createURI(getFile(source, control)), true);
        set.getResources().add(controlResource);
        Resource pojoResource = null;
        File pojoFile = new File(URI.createURI(getFile(source, pojo)).toFileString());
        if (pojoFile.canRead()) {
            pojoResource = set.getResource(URI.createURI(getFile(source, pojo)), true);
            set.getResources().add(pojoResource);
        }
        Resource daoResource = null;
        File daoFile = new File(URI.createURI(getFile(source, dao)).toFileString());
        if (daoFile.canRead()) {
            daoResource = set.getResource(URI.createURI(getFile(source, dao)), true);
            set.getResources().add(daoResource);
        }
        Resource sqlResource = null;
        File sqlFile = new File(URI.createURI(getFile(source, sql)).toFileString());
        if (sqlFile.canRead()) {
            sqlResource = set.getResource(URI.createURI(getFile(source, sql)), true);
            set.getResources().add(sqlResource);
        }

        if (!isValid(controlResource) || (merge && pojoResource != null && !isValid(pojoResource))
                || (merge && daoResource != null && !isValid(daoResource))
                || (merge && sqlResource != null && !isValid(sqlResource)))
            return;
        System.out.println("Resource(s) validation finished.");

        Artifacts definitions = (Artifacts) controlResource.getContents().get(0);
        if (definitions.getProperties().isEmpty()) {
            System.err.println("No control directive.");
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
            File file = new File(getFile(source, ddl));
            dbSqlsBefore = new String(Files.toByteArray(file));
        }
        DbResolver dbResolver = new DbResolverBean(modelProperty, driverClass, dbSqlsBefore, null);

        Artifacts pojos = null;
        PackageDeclaration pojoPackage = null;
        String pojoPackageName = null;
        if (!merge) {
            pojoPackageName = modelProperty.getPackage(null);
        } else {
            if (pojoResource != null) {
                pojos = (Artifacts) pojoResource.getContents().get(0);
                if (!pojos.getPojoPackages().isEmpty()) {
                    pojoPackage = pojos.getPojoPackages().get(0);
                    pojoPackageName = pojoPackage.getName();
                }
            } else {
                pojoPackageName = modelProperty.getPackage(null);
            }
        }
        if (pojoPackage == null && pojoPackageName == null) {
            System.err.println("Missing POJO package.");
            return;
        }

        Artifacts daos = null;
        PackageDeclaration daoPackage = null;
        String daoPackageName = null;
        if (!merge) {
            daoPackageName = modelProperty.getDaoPackage(null);
        } else {
            if (daoResource != null) {
                daos = (Artifacts) daoResource.getContents().get(0);
                if (!daos.getPojoPackages().isEmpty()) {
                    daoPackage = daos.getPojoPackages().get(0);
                    daoPackageName = daoPackage.getName();
                }
            } else {
                daoPackageName = modelProperty.getDaoPackage(null);
            }
        }
        if (daoPackage == null && daoPackageName == null) {
            System.err.println("Missing DAO package.");
            return;
        }

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

        String pojoDefinitions = getPojoDefinitions(modelProperty, dbResolver, definitions, pojoPackage,
                ((XtextResource) controlResource).getSerializer());
        fileAccess.generateFile(pojo, "package " + pojoPackageName + " {\n" + pojoDefinitions + "}");
        System.out.println(pojo + " generation finished.");

        String daoDefinitions = getDaoDefinitions(modelProperty, dbResolver, definitions, daoPackage,
                ((XtextResource) controlResource).getSerializer());
        fileAccess.generateFile(dao, "package " + daoPackageName + " {\n" + daoDefinitions + "}");
        System.out.println(dao + " generation finished.");

        String metaDefinitions = getMetaDefinitions(modelProperty, dbResolver, definitions, statements,
                ((XtextResource) controlResource).getSerializer());
        fileAccess.generateFile(sql, metaDefinitions);
        System.out.println(sql + " generation finished.");
    }

    protected String getFile(String source, String file) {
        if (file.startsWith("/"))
            return file;
        return source + file;
    }

    protected boolean isValid(Resource resource) throws IOException {
        resource.load(null);
        List<Issue> list = validator.validate(resource, CheckMode.ALL, CancelIndicator.NullImpl);
        if (!list.isEmpty()) {
            for (Issue issue : list) {
                System.err.println(issue);
            }
            return false;
        }
        return true;
    }

    protected String getPojoDefinitions(ModelPropertyBean modelProperty, DbResolver dbResolver, Artifacts artifacts,
            PackageDeclaration packagex, ISerializer serializer) {

        if (artifacts != null && dbResolver.isResolveDb(artifacts)) {
            Map<String, String> finalEntities = new HashMap<String, String>();
            Annotations annotations = new Annotations();
            String suffix = null;
            if (packagex != null) {
                suffix = packagex.getSuffix();
                for (AbstractPojoEntity ape : packagex.getElements()) {
                    if (ape instanceof AnnotatedEntity) {
                        AnnotatedEntity apojo = (AnnotatedEntity) ape;
                        if (apojo.getEntity() != null && apojo.getEntity() instanceof PojoEntity) {
                            PojoEntity pojo = (PojoEntity) apojo.getEntity();
                            Annotations.grabAnnotations(apojo, pojo, annotations);
                            if (Utils.isFinal(pojo)) {
                                // if (suffix != null && pojo.getName().endsWith(suffix))
                                // finalEntities.put(
                                // pojo.getName().substring(0, pojo.getName().length() - suffix.length()),
                                // serializer.serialize(pojo));
                                // else
                                finalEntities.put(pojo.getName(), serializer.serialize(pojo));
                            }
                        } else if (apojo.getEntity() != null && apojo.getEntity() instanceof EnumEntity) {
                            EnumEntity pojo = (EnumEntity) apojo.getEntity();
                            if (Utils.isFinal(pojo)) {
                                // if (suffix != null && pojo.getName().endsWith(suffix))
                                // finalEntities.put(
                                // pojo.getName().substring(0, pojo.getName().length() - suffix.length()),
                                // serializer.serialize(pojo));
                                // else
                                finalEntities.put(pojo.getName(), serializer.serialize(pojo));
                            }
                        }
                    }
                }
            }
            // List<String> tables = dbResolver.getTables(artifacts);
            List<String> dbSequences = dbResolver.getSequences(artifacts);
            DbType dbType = Utils.getDbType(dbResolver, artifacts);
            TablePojoGenerator generator = new TablePojoGenerator(modelProperty, artifacts, suffix, finalEntities,
                    annotations, dbSequences, dbType);
            if (TablePojoGenerator.addDefinitions(scopeProvider, dbResolver, generator, artifacts))
                return generator.getPojoDefinitions(modelProperty, artifacts);
        }
        return null;
    }

    protected String getDaoDefinitions(ModelPropertyBean modelProperty, DbResolver dbResolver, Artifacts artifacts,
            PackageDeclaration packagex, ISerializer serializer) {

        if (artifacts != null && dbResolver.isResolveDb(artifacts)) {
            Map<String, String> finalDaos = new HashMap<String, String>();
            String suffix = null;
            if (packagex != null) {
                suffix = packagex.getSuffix();
                for (AbstractPojoEntity ape : packagex.getElements()) {
                    if (ape instanceof PojoDao) {
                        PojoDao dao = (PojoDao) ape;
                        if (Utils.isFinal(dao)) {
                            // if (suffix != null && dao.getName().endsWith(suffix))
                            // finalDaos.put(dao.getName().substring(0, dao.getName().length() - suffix.length()),
                            // serializer.serialize(dao));
                            // else
                            finalDaos.put(dao.getName(), serializer.serialize(dao));
                        }
                    }
                }
            }
            // List<String> tables = dbResolver.getTables(artifacts);
            List<String> dbSequences = dbResolver.getSequences(artifacts);
            DbType dbType = Utils.getDbType(dbResolver, artifacts);
            TableDaoGenerator generator = new TableDaoGenerator(modelProperty, artifacts, suffix, scopeProvider,
                    finalDaos, dbSequences, dbType);
            if (TablePojoGenerator.addDefinitions(scopeProvider, dbResolver, generator, artifacts)) {
                return generator.getDaoDefinitions(modelProperty, artifacts);
            }
        }
        return null;
    }

    protected String getMetaDefinitions(ModelPropertyBean modelProperty, DbResolver dbResolver, Artifacts artifacts,
            List<MetaStatement> statements, ISerializer serializer) {

        if (artifacts != null && dbResolver.isResolveDb(artifacts)) {
            Map<String, String> finalMetas = new HashMap<String, String>();
            for (MetaStatement meta : statements) {
                if (Utils.isFinal(meta)) {
                    finalMetas.put(meta.getName(), serializer.serialize(meta));
                }
            }
            // List<String> tables = dbResolver.getTables(artifacts);
            List<String> dbSequences = dbResolver.getSequences(artifacts);
            DbType dbType = Utils.getDbType(dbResolver, artifacts);
            TableMetaGenerator generator = new TableMetaGenerator(modelProperty, artifacts, scopeProvider, finalMetas,
                    dbSequences, dbType);
            if (TablePojoGenerator.addDefinitions(scopeProvider, dbResolver, generator, artifacts))
                return generator.getMetaDefinitions(modelProperty, artifacts);
        }
        return null;
    }
}
