package org.sqlproc.plugin.lib.resolver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URLClassLoader;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.URI;
import org.sqlproc.plugin.lib.property.ModelProperty;
import org.sqlproc.plugin.lib.util.MainUtils;

import com.google.inject.Singleton;

@Singleton
public class StandalonePojoResolverImpl extends BasePojoResolverImpl implements PojoResolver {

    protected Logger LOGGER = Logger.getLogger(StandalonePojoResolverImpl.class);

    ModelProperty modelProperty;
    String source;

    public StandalonePojoResolverImpl(ModelProperty modelProperty, String source) {
        this.modelProperty = modelProperty;
        this.source = source;
    }

    protected ModelProperty getModelProperty() {
        return modelProperty;
    };

    protected void init() {
        allLoaders = new LinkedHashMap<String, URLClassLoader>();
    }

    @Override
    public Class<?> loadClass(String name, URI uri) {
        try {
            Class<?> clazz = this.getClass().getClassLoader().loadClass(name);
            return clazz;
        } catch (ClassNotFoundException e) {
        }
        LOGGER.warn("Can't find class '" + name);
        return null;
    }

    @Override
    public List<Class<?>> getPojoClasses(URI uri) {
        return Collections.EMPTY_LIST;
    }

    @Override
    public InputStream getFile(String filename, URI uri) {
        File file = new File(MainUtils.getFile(source, filename));
        try {
            return new FileInputStream(file);
        } catch (FileNotFoundException e) {
        }
        LOGGER.warn("Can't find file '" + filename + "' in project");
        return null;
    }
}
