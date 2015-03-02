package org.sqlproc.model.ui.templates;

import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.templates.SimpleTemplateVariableResolver;
import org.eclipse.jface.text.templates.TemplateContext;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.scoping.IScopeProvider;
import org.eclipse.xtext.ui.editor.templates.XtextTemplateContext;
import org.eclipse.xtext.xbase.ui.templates.XbaseTemplateContextType;
import org.sqlproc.model.processorModel.Artifacts;
import org.sqlproc.model.processorModel.Package;
import org.sqlproc.model.processorModel.ProcessorModelPackage;
import org.sqlproc.model.property.ModelProperty;
import org.sqlproc.model.resolver.DbResolver;
import org.sqlproc.model.resolver.PojoResolver;
import org.sqlproc.model.util.Utils;

import com.google.inject.Inject;

public class ProcessorModelTemplateContextType extends XbaseTemplateContextType {

    @Inject
    PojoResolver pojoResolver;

    @Inject
    DbResolver dbResolver;

    @Inject
    IScopeProvider scopeProvider;

    @Inject
    ModelProperty modelProperty;

    // @Inject
    // TableDaoGenerator tableDaoGenerator;
    //
    // @Inject
    // TableMetaGenerator tableMetaGenerator;
    //
    // @Inject
    // TablePojoGenerator tablePojoGenerator;

    @Override
    protected void addDefaultTemplateVariables() {
        super.addDefaultTemplateVariables();
        super.addResolver(new PojoDefinitionsResolver());
        super.addResolver(new TablesDefinitionsResolver());
        super.addResolver(new ProceduresDefinitionsResolver());
        super.addResolver(new FunctionsDefinitionsResolver());
        super.addResolver(new PojoGeneratorResolver());
        super.addResolver(new DaoGeneratorResolver());
    }

    protected Artifacts getArtifacts(XtextTemplateContext xtextTemplateContext) {
        if (xtextTemplateContext == null)
            return null;
        EObject object = xtextTemplateContext.getContentAssistContext().getCurrentModel();
        if (object == null)
            return null;
        return EcoreUtil2.getContainerOfType(object, Artifacts.class);
    }

    protected Package getPackage(XtextTemplateContext xtextTemplateContext) {
        if (xtextTemplateContext == null)
            return null;
        EObject object = xtextTemplateContext.getContentAssistContext().getCurrentModel();
        Package packagex = EcoreUtil2.getContainerOfType(object, Package.class);
        return packagex;
    }

    /*
     * Template variable resolvers
     */
    public class PojoDefinitionsResolver extends SimpleTemplateVariableResolver {

        public static final String NAME = "pojoDefinitions";

        public PojoDefinitionsResolver() {
            super(NAME, "PojoDefinitions");
        }

        @Override
        protected String resolve(TemplateContext context) {
            Artifacts artifacts = getArtifacts((XtextTemplateContext) context);
            if (artifacts != null && pojoResolver.isResolvePojo(artifacts)) {
                URI uri = (artifacts.eResource() != null) ? artifacts.eResource().getURI() : null;
                List<Class<?>> pojoClasses = pojoResolver.getPojoClasses(uri);
                return Utils.getPojoDefinitions(pojoClasses);
            }
            return super.resolve(context);
        }

        @Override
        protected boolean isUnambiguous(TemplateContext context) {
            return true;
        }
    }

    public class TablesDefinitionsResolver extends SimpleTemplateVariableResolver {

        public static final String NAME = "tableDefinitions";

        public TablesDefinitionsResolver() {
            super(NAME, "TableDefinitions");
        }

        @Override
        protected String resolve(TemplateContext context) {
            Artifacts artifacts = getArtifacts((XtextTemplateContext) context);
            if (artifacts != null && dbResolver.isResolveDb(artifacts)) {
                List<String> tablesPresented = Utils.findTables(null, artifacts,
                        scopeProvider.getScope(artifacts, ProcessorModelPackage.Literals.ARTIFACTS__TABLES));
                List<String> tables = dbResolver.getTables(artifacts);
                return Utils.getTablesDefinitions(tables, tablesPresented);
            }
            return super.resolve(context);
        }

        @Override
        protected boolean isUnambiguous(TemplateContext context) {
            return true;
        }
    }

    public class ProceduresDefinitionsResolver extends SimpleTemplateVariableResolver {

        public static final String NAME = "procedureDefinitions";

        public ProceduresDefinitionsResolver() {
            super(NAME, "ProcedureDefinitions");
        }

        @Override
        protected String resolve(TemplateContext context) {
            Artifacts artifacts = getArtifacts((XtextTemplateContext) context);
            if (artifacts != null && dbResolver.isResolveDb(artifacts)) {
                List<String> proceduresPresented = Utils.findProcedures(null, artifacts,
                        scopeProvider.getScope(artifacts, ProcessorModelPackage.Literals.ARTIFACTS__PROCEDURES));
                List<String> procedures = dbResolver.getProcedures(artifacts);
                return Utils.getProceduresDefinitions(procedures, proceduresPresented);
            }
            return super.resolve(context);
        }

        @Override
        protected boolean isUnambiguous(TemplateContext context) {
            return true;
        }
    }

    public class FunctionsDefinitionsResolver extends SimpleTemplateVariableResolver {

        public static final String NAME = "functionDefinitions";

        public FunctionsDefinitionsResolver() {
            super(NAME, "FunctionDefinitions");
        }

        @Override
        protected String resolve(TemplateContext context) {
            Artifacts artifacts = getArtifacts((XtextTemplateContext) context);
            if (artifacts != null && dbResolver.isResolveDb(artifacts)) {
                List<String> functionsPresented = Utils.findFunctions(null, artifacts,
                        scopeProvider.getScope(artifacts, ProcessorModelPackage.Literals.ARTIFACTS__FUNCTIONS));
                List<String> functions = dbResolver.getFunctions(artifacts);
                return Utils.getFunctionsDefinitions(functions, functionsPresented);
            }
            return super.resolve(context);
        }

        @Override
        protected boolean isUnambiguous(TemplateContext context) {
            return true;
        }
    }

    public class PojoGeneratorResolver extends SimpleTemplateVariableResolver {

        public static final String NAME = "pojoGenerator";

        public PojoGeneratorResolver() {
            super(NAME, "PojoGenerator");
        }

        @Override
        protected String resolve(TemplateContext context) {
            Artifacts artifacts = getArtifacts((XtextTemplateContext) context);
            Package packagex = getPackage((XtextTemplateContext) context);
            String pojos = Utils.generatePojo(artifacts, packagex, null, dbResolver, scopeProvider, modelProperty);
            if (pojos != null)
                return pojos;
            return super.resolve(context);
        }

        @Override
        protected boolean isUnambiguous(TemplateContext context) {
            return true;
        }
    }

    public class DaoGeneratorResolver extends SimpleTemplateVariableResolver {

        public static final String NAME = "daoGenerator";

        public DaoGeneratorResolver() {
            super(NAME, "DaoGenerator");
        }

        @Override
        protected String resolve(TemplateContext context) {
            Artifacts artifacts = getArtifacts((XtextTemplateContext) context);
            Package packagex = getPackage((XtextTemplateContext) context);
            String daos = Utils.generateDao(artifacts, packagex, null, dbResolver, scopeProvider, modelProperty);
            if (daos != null)
                return daos;
            return super.resolve(context);
        }

        @Override
        protected boolean isUnambiguous(TemplateContext context) {
            return true;
        }
    }
}
