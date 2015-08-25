package org.sqlproc.plugin.lib.resolver;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.net.URLClassLoader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.sqlproc.plugin.lib.property.ModelProperty;

import com.google.inject.Singleton;

@Singleton
public abstract class BasePojoResolverImpl implements PojoResolver {

    protected Logger LOGGER = Logger.getLogger(BasePojoResolverImpl.class);

    protected Map<String, URLClassLoader> allLoaders;
    protected Set<String> nokLoaders = new HashSet<String>();

    abstract protected ModelProperty getModelProperty();

    abstract protected void init();

    @Override
    public Class<?> loadClass(String name, URI uri) {
        // platform:/resource/simple-jdbc-dao/src/main/resources/statements.meta
        String pname = getProjectName(uri);
        if (allLoaders == null)
            init();
        boolean retry = false;
        if (pname != null) {
            URLClassLoader loader = allLoaders.get(pname);
            if (loader != null) {
                try {
                    return loader.loadClass(name);
                } catch (ClassNotFoundException ignore) {
                }
                // for the case a new project is opened
                init();
                loader = allLoaders.get(pname);
                if (loader != null) {
                    try {
                        return loader.loadClass(name);
                    } catch (ClassNotFoundException ignore) {
                        LOGGER.warn("Can't find class '" + name + "' in loader " + loader + " " + uri);
                    }
                } else {
                    retry = true;
                }
            } else {
                retry = true;
            }
        }
        if (!retry)
            return null;
        for (Entry<String, URLClassLoader> e : allLoaders.entrySet()) {
            try {
                Class<?> clazz = e.getValue().loadClass(name);
                LOGGER.warn("Found " + name + "(" + uri + ") in " + e.getKey());
                return clazz;
            } catch (ClassNotFoundException ignore) {
            }
        }
        // for the case a new project is opened
        init();
        for (Entry<String, URLClassLoader> e : allLoaders.entrySet()) {
            try {
                Class<?> clazz = e.getValue().loadClass(name);
                LOGGER.warn("Found " + name + "(" + uri + ") in " + e.getKey());
                return clazz;
            } catch (ClassNotFoundException ignore) {
            }
        }
        LOGGER.warn("Can't find class '" + name + "' in any loader " + allLoaders);
        return null;
    }

    @Override
    public PropertyDescriptor[] getPropertyDescriptors(String name, URI uri) {
        // platform:/resource/simple-jdbc-dao/src/main/resources/statements.meta
        if (allLoaders == null)
            init();
        Class<?> beanClass = loadClass(name, uri);
        if (beanClass == null)
            return null;

        // Look up any cached descriptors for this bean class
        PropertyDescriptor[] descriptors = null;
        // descriptors = (PropertyDescriptor[]) descriptorsCache.get(beanClass);
        // if (descriptors != null) {
        // return (descriptors);
        // }

        // Introspect the bean and cache the generated descriptors
        BeanInfo beanInfo = null;
        try {
            beanInfo = Introspector.getBeanInfo(beanClass);
        } catch (IntrospectionException e) {
            return (new PropertyDescriptor[0]);
        }
        descriptors = beanInfo.getPropertyDescriptors();
        if (descriptors == null) {
            descriptors = new PropertyDescriptor[0];
        }

        // descriptorsCache.put(beanClass, descriptors);
        return descriptors;
    }

    @Override
    public Map<String, String> getOrders(String name, URI uri) {
        // platform:/resource/simple-jdbc-dao/src/main/resources/statements.meta
        if (allLoaders == null)
            init();
        Class<?> beanClass = loadClass(name, uri);
        if (beanClass == null)
            return null;

        Map<String, String> orders = new HashMap<>();
        while (beanClass != null) {
            Field[] fields = beanClass.getFields();
            for (Field f : fields) {
                if (Modifier.isStatic(f.getModifiers())) {
                    try {
                        if (f.getType() == int.class)
                            orders.put(f.getName(), "" + f.getInt(null));
                        else if (f.getType() == String.class)
                            orders.put(f.getName(), (String) f.get(null));
                    } catch (IllegalArgumentException | IllegalAccessException e) {
                    }
                }
            }
            beanClass = beanClass.getSuperclass();
        }

        beanClass = loadClass(name, uri);
        Class<?> orderBeanClass = loadClass(name + "$Order", uri);
        while (orderBeanClass != null && orderBeanClass.isEnum()) {
            for (Object en : orderBeanClass.getEnumConstants()) {
                String ename = en.toString();
                orders.put(ename, ename);
            }

            beanClass = beanClass.getSuperclass();
            if (beanClass == null)
                break;
            orderBeanClass = loadClass(beanClass.getName() + "$Order", uri);
        }
        return orders;
    }

    @Override
    public boolean isResolvePojo(EObject model) {
        if (!getModelProperty().isDoResolvePojo(model)) {
            return false;
        }
        if (allLoaders == null) {
            init();
        }
        return allLoaders != null;
    }

    private static final String PREFIX1 = "platform:/resource/";
    private static final int PLEN1 = PREFIX1.length();

    private String getProjectName(URI uri) {
        // platform:/resource/simple-jdbc-dao/src/main/resources/statements.meta
        if (uri == null)
            return null;
        String name = uri.toString();
        if (name.startsWith(PREFIX1))
            name = name.substring(PLEN1);
        int ix = name.indexOf("/");
        if (ix >= 0)
            name = name.substring(0, ix);
        return name;
    }
}
