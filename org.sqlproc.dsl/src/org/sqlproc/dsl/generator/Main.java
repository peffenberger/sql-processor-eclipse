/*
 * generated by Xtext
 */
package org.sqlproc.dsl.generator;

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
import org.eclipse.xtext.scoping.IScopeProvider;
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
        String control = null;
        String pojo = null;
        String dao = null;
        String sql = null;
        String ddl = null;
        for (int i = 0; i < args.length; i++) {
            String arg = args[i];
            if ("-models".equals(arg) && i < args.length - 1)
                models = args[i + 1];
            else if ("-models".equals(arg) && i < args.length - 1)
                target = args[i + 1];
            else if ("-control".equals(arg) && i < args.length - 1)
                control = args[i + 1];
            else if ("-pojo".equals(arg) && i < args.length - 1)
                pojo = args[i + 1];
            else if ("-dao".equals(arg) && i < args.length - 1)
                dao = args[i + 1];
            else if ("-sql".equals(arg) && i < args.length - 1)
                sql = args[i + 1];
            else if ("-ddl".equals(arg) && i < args.length - 1)
                ddl = args[i + 1];
        }
        if (models == null && (control == null || pojo == null || dao == null || sql == null)) {
            usage();
            return;
        }

        Injector injector = new org.sqlproc.dsl.ProcessorDslStandaloneSetup().createInjectorAndDoEMFRegistration();
        Main main = injector.getInstance(Main.class);

        if (models != null) {
            if (target == null)
                target = "src-gen";
            if (!target.endsWith("/"))
                target = target + "/";
            main.runGenerator(models, target);
        } else if (control != null) {
            if (target == null)
                target = ".";
            if (!target.endsWith("/"))
                target = target + "/";
            main.runGenerator(control, pojo, dao, sql, ddl, target);
        }
    }

    private static void usage() {
        System.out.println();
        System.out.println("Incorrect usage. Two modes are supported.");
        System.out.println("Mode 1: POJO & DAO Java source files generation using model files:");
        System.out.println("  java -jar sqlep.jar -models modelFile1,modelFile2... [-target targetDir]");
        System.out.println("For example:");
        System.out.println("  java -jar sqlep.jar -models pojo.qry,dao.qry -target src-gen");
        System.out.println("Mode 2: POJO, DAO and META SQL models generation using control directives:");
        System.out
                .println("  java -jar sqlep.jar -control controlDirectivesFile -pojo pojoModelFile -dao daoModelFile -sql metaSqlFile [-target targetDir]");
        System.out.println("For example:");
        System.out
                .println("  java -jar sqlep.jar -control definitions.qry -pojo pojo.qry -dao dao.qry -sql statements.qry");
        System.out.println();
    }

    protected void runGenerator(String models, String target) throws IOException, ClassNotFoundException {

        String[] sResources = models.split(",");
        ResourceSet set = resourceSetProvider.get();
        List<Resource> set2 = new ArrayList<Resource>();
        for (String sResource : sResources) {
            Resource resource = set.getResource(URI.createURI(sResource), true);
            set.getResources().add(resource);
            set2.add(resource);
        }

        for (Resource resource : set2) {
            if (!isValid(resource))
                return;
        }
        System.out.println("Resource(s) validation finished.");

        fileAccess.setOutputPath(target);
        generator.doGenerate(set, fileAccess);
        System.out.println("Java code generation finished.");
    }

    protected void runGenerator(String control, String pojo, String dao, String sql, String ddl, String target)
            throws IOException, ClassNotFoundException {

        ResourceSet set = resourceSetProvider.get();
        Resource controlResource = set.getResource(URI.createURI(control), true);
        set.getResources().add(controlResource);
        Resource pojoResource = null;
        File pojoFile = new File(URI.createURI(pojo).toFileString());
        if (pojoFile.canRead()) {
            pojoResource = set.getResource(URI.createURI(pojo), true);
            set.getResources().add(pojoResource);
        }
        Resource daoResource = null;
        File daoFile = new File(URI.createURI(dao).toFileString());
        if (daoFile.canRead()) {
            daoResource = set.getResource(URI.createURI(dao), true);
            set.getResources().add(daoResource);
        }

        if (!isValid(controlResource) || (pojoResource != null && !isValid(pojoResource))
                || (daoResource != null && !isValid(daoResource)))
            return;
        System.out.println("Resource(s) validation finished.");

        Artifacts definitions = (Artifacts) controlResource.getContents().get(0);
        if (definitions.getProperties().isEmpty()) {
            System.err.println("No control directive.");
            return;
        }
        fileAccess.setOutputPath(target);
        ModelValues modelValues = ModelPropertyBean.loadModel(null, definitions);
        ModelPropertyBean modelProperty = new ModelPropertyBean(modelValues);
        String sDbDriver = modelProperty.getModelValues(null).dbDriver;
        Class<?> driverClass = this.getClass().getClassLoader().loadClass(sDbDriver);
        String dbSqlsBefore = null;
        if (ddl != null) {
            File file = new File(ddl);
            dbSqlsBefore = new String(Files.toByteArray(file));
        }
        DbResolver dbResolver = new DbResolverBean(modelProperty, driverClass, dbSqlsBefore, null);

        Artifacts pojos = null;
        PackageDeclaration pojoPackage = null;
        String pojoPackageName = null;
        if (pojoResource != null) {
            pojos = (Artifacts) pojoResource.getContents().get(0);
            if (!pojos.getPojoPackages().isEmpty()) {
                pojoPackage = pojos.getPojoPackages().get(0);
                pojoPackageName = pojoPackage.getName();
            }
        } else {
            pojoPackageName = modelProperty.getPackage(null);
        }
        if (pojoPackage == null && pojoPackageName == null) {
            System.err.println("Missing POJO package.");
            return;
        }

        Artifacts daos = null;
        PackageDeclaration daoPackage = null;
        String daoPackageName = null;
        if (daoResource != null) {
            daos = (Artifacts) pojoResource.getContents().get(0);
            if (!daos.getPojoPackages().isEmpty()) {
                daoPackage = daos.getPojoPackages().get(0);
                daoPackageName = daoPackage.getName();
            }
        } else {
            daoPackageName = modelProperty.getDaoPackage(null);
        }
        if (daoPackage == null && daoPackageName == null) {
            System.err.println("Missing DAO package.");
            return;
        }

        String pojoDefinitions = getPojoDefinitions(modelProperty, dbResolver, definitions, pojoPackage);
        fileAccess.generateFile(pojo, "package " + pojoPackageName + " {\n" + pojoDefinitions + "}");
        System.out.println(pojo + " generation finished.");

        String daoDefinitions = getDaoDefinitions(modelProperty, dbResolver, definitions, daoPackage);
        fileAccess.generateFile(dao, "package " + daoPackageName + " {\n" + daoDefinitions + "}");
        System.out.println(dao + " generation finished.");

        String metaDefinitions = getMetaDefinitions(modelProperty, dbResolver, definitions);
        fileAccess.generateFile(sql, metaDefinitions);
        System.out.println(sql + " generation finished.");
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
            PackageDeclaration packagex) {

        if (artifacts != null && dbResolver.isResolveDb(artifacts)) {
            List<PojoEntity> entitiesToRemove = new ArrayList<PojoEntity>();
            Set<String> finalEntities = new HashSet<String>();
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
                                // finalEntities.add(pojo.getName()
                                // .substring(0, pojo.getName().length() - suffix.length()));
                                // else
                                finalEntities.add(pojo.getName());
                            } else {
                                entitiesToRemove.add(pojo);
                            }
                        } else if (apojo.getEntity() != null && apojo.getEntity() instanceof EnumEntity) {
                            EnumEntity pojo = (EnumEntity) apojo.getEntity();
                            if (Utils.isFinal(pojo)) {
                                // if (suffix != null && pojo.getName().endsWith(suffix))
                                // finalEntities.add(pojo.getName()
                                // .substring(0, pojo.getName().length() - suffix.length()));
                                // else
                                finalEntities.add(pojo.getName());
                            }
                        }
                    }
                }
                // for (PojoEntity pojo : entitiesToRemove) {
                // packagex.getElements().remove(pojo);
                // }
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
            PackageDeclaration packagex) {

        if (artifacts != null && dbResolver.isResolveDb(artifacts)) {
            List<PojoDao> daosToRemove = new ArrayList<PojoDao>();
            Set<String> finalDaos = new HashSet<String>();
            String suffix = null;
            if (packagex != null) {
                suffix = packagex.getSuffix();

                for (AbstractPojoEntity ape : packagex.getElements()) {
                    if (ape instanceof PojoDao) {
                        PojoDao dao = (PojoDao) ape;
                        if (Utils.isFinal(dao)) {
                            // if (suffix != null && dao.getName().endsWith(suffix))
                            // finalDaos.add(dao.getName()
                            // .substring(0, dao.getName().length() - suffix.length()));
                            // else
                            finalDaos.add(dao.getName());
                        } else {
                            daosToRemove.add(dao);
                        }
                    }
                }
                // for (PojoDao dao : daosToRemove) {
                // packagex.getElements().remove(dao);
                // }
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

    protected String getMetaDefinitions(ModelPropertyBean modelProperty, DbResolver dbResolver, Artifacts artifacts) {

        if (artifacts != null && dbResolver.isResolveDb(artifacts)) {
            List<MetaStatement> metasToRemove = new ArrayList<MetaStatement>();
            Set<String> finalMetas = new HashSet<String>();

            for (MetaStatement meta : artifacts.getStatements()) {
                if (Utils.isFinal(meta)) {
                    finalMetas.add(meta.getName());
                } else {
                    metasToRemove.add(meta);
                }
            }
            // for (MetaStatement meta : metasToRemove) {
            // artifacts.getElements().remove(meta);
            // }

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
