package org.sqlproc.model.ui.resolver;

import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.launching.JavaRuntime;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.PlatformUI;
import org.sqlproc.plugin.lib.property.ModelProperty;
import org.sqlproc.plugin.lib.resolver.BasePojoResolverImpl;
import org.sqlproc.plugin.lib.resolver.PojoResolver;

import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
public class WorkspacePojoResolverImpl extends BasePojoResolverImpl implements PojoResolver {

    protected Logger LOGGER = Logger.getLogger(WorkspacePojoResolverImpl.class);

    @Inject
    ModelProperty modelProperty;

    protected ModelProperty getModelProperty() {
        return modelProperty;
    };

    protected void init() {
        LOGGER.info("POJO START");
        // List<IJavaProject> javaProjects = new ArrayList<IJavaProject>();
        Map<String, URLClassLoader> loaders = null;
        IProject[] projects = ResourcesPlugin.getWorkspace().getRoot().getProjects();
        // [P/RemoteSystemsTempFiles, P/Servers, P/simple-jdbc-crud, P/simple-jdbc-dao]
        for (IProject project : projects) {
            String pname = project.toString();
            if (pname.startsWith("P/"))
                pname = pname.substring(2);
            else
                pname = project.getName();
            try {
                if (nokLoaders.contains(pname))
                    continue;
                if (allLoaders != null && allLoaders.containsKey(pname))
                    continue;
                project.open(null /* IProgressMonitor */);
                IJavaProject javaProject = JavaCore.create(project);
                // javaProjects.add(javaProject);
                URLClassLoader classLoader = getProjectClassLoader(javaProject);
                if (loaders == null)
                    loaders = new LinkedHashMap<String, URLClassLoader>();
                loaders.put(pname, classLoader);
            } catch (CoreException e) {
                nokLoaders.add(pname);
                LOGGER.warn("Can't handle project '" + project + "': " + e.getMessage());
            }
        }
        if (loaders != null && !loaders.isEmpty()) {
            if (allLoaders != null)
                allLoaders.putAll(loaders);
            else
                allLoaders = loaders;
        }
    }

    @SuppressWarnings("unused")
    private URLClassLoader getProjectClassLoader(IJavaProject javaProject) throws CoreException {
        String[] classPathEntries = JavaRuntime.computeDefaultRuntimeClassPath(javaProject);
        List<URL> urlList = new ArrayList<URL>();
        for (int i = 0; i < classPathEntries.length; i++) {
            String entry = classPathEntries[i];
            IPath path = new Path(entry);
            URL url;
            try {
                url = path.toFile().toURI().toURL();
                urlList.add(url);
            } catch (MalformedURLException e) {
                LOGGER.warn("Can't accept URL for '" + path + "': " + e.getMessage());
            }
        }
        ClassLoader parentClassLoader = javaProject.getClass().getClassLoader();
        URL[] urls = (URL[]) urlList.toArray(new URL[urlList.size()]);
        URLClassLoader classLoader = new URLClassLoader(urls, parentClassLoader);
        return classLoader;
    }

    @Override
    public List<Class<?>> getPojoClasses(URI uri) {
        List<Class<?>> pojos = new ArrayList<Class<?>>();
        IEditorPart editorPart = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
        if (editorPart != null) {
            IFileEditorInput input = (IFileEditorInput) editorPart.getEditorInput();
            IProject project = input.getFile().getProject();
            try {
                project.open(null /* IProgressMonitor */);
                IJavaProject javaProject = JavaCore.create(project);
                URLClassLoader classLoader = getProjectClassLoader(javaProject);

                for (IPackageFragment fragment : javaProject.getPackageFragments()) {
                    if (fragment.getKind() == IPackageFragmentRoot.K_SOURCE) {
                        for (ICompilationUnit unit : fragment.getCompilationUnits()) {
                            if (unit.getTypes() != null && unit.getTypes().length > 0) {
                                String classname = unit.getParent().getElementName() + "."
                                        + unit.getTypes()[0].getElementName();
                                // Class<?> clazz = loadClass(classname);
                                Class<?> clazz = null;
                                try {
                                    clazz = classLoader.loadClass(classname);
                                } catch (ClassNotFoundException ignore) {
                                }
                                if (clazz == null)
                                    continue;
                                for (Annotation annotation : clazz.getAnnotations()) {
                                    if (POJO_ANNOTATION_CLASS.equals(annotation.annotationType().getName())) {
                                        pojos.add(clazz);
                                        break;
                                    }
                                }
                            }
                        }
                    }
                }
            } catch (CoreException e) {
                LOGGER.warn("Can't handle project '" + project + "': " + e.getMessage());
            }
        }
        return pojos;
    }

    // 0000000a org.sqlproc.meta.processorMeta.impl.TableDefinitionImpl@d452db (name: person, table: PERSON)
    // 0000000b org.eclipse.xtext.linking.lazy.LazyLinkingResource@1386e14
    // uri='platform:/resource/simple-jdbc-all/src/main/resources/definitions.qry'
    // 0000000c platform:/resource/simple-jdbc-all/src/main/resources/definitions.qry
    // 0000000d R/
    // 0000000e /simple-jdbc-all/src/main/resources/definitions.qry
    // 0000000f /simple-jdbc-all/src/main/resources/definitions.qry
    // 0000000g L/simple-jdbc-all/src/main/resources/definitions.qry
    // 0000000h F/simple-jdbc-all/src/main/resources
    // 0000000i F/simple-jdbc-all/src/main/resources
    // 0000000j L/simple-jdbc-all/src/main/resources/hsqldb.ddl

    @Override
    public InputStream getFile(String filename, URI uri) {
        if (uri.isPlatformResource()) {
            IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
            IFile modelFile = root.getFile(new Path(uri.toPlatformString(false)));
            IContainer modelParent = modelFile.getParent();
            if (modelParent instanceof IFolder) {
                IFolder modelDir = (IFolder) modelParent;
                IFile file = modelDir.getFile(filename);
                try {
                    return file.getContents();
                } catch (CoreException e) {
                    LOGGER.warn("Can't handle file '" + filename + "': " + e.getMessage());
                }
            }
        }
        LOGGER.warn("Can't find file '" + filename + "' in project");
        return null;
    }
}
