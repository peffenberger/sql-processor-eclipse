package org.sqlproc.dsl.ui.templates;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.sqlproc.dsl.processorDsl.Annotation;

public class Annotations {
    Map<String, List<Annotation>> entityAnnotations = new HashMap<String, List<Annotation>>();
    Map<String, Map<String, List<Annotation>>> setterAnnotations = new HashMap<String, Map<String, List<Annotation>>>();
    Map<String, Map<String, List<Annotation>>> getterAnnotations = new HashMap<String, Map<String, List<Annotation>>>();
    Map<String, Map<String, List<Annotation>>> attributeAnnotations = new HashMap<String, Map<String, List<Annotation>>>();

    void addEntityAnnotations(String pojoName, List<Annotation> annotations) {
        entityAnnotations.put(pojoName, new ArrayList<Annotation>());
        entityAnnotations.get(pojoName).addAll(annotations);
    }

    void addGetterAnnotations(String pojoName, String featureName, List<Annotation> annotations) {
        if (!getterAnnotations.containsKey(pojoName))
            getterAnnotations.put(pojoName, new HashMap<String, List<Annotation>>());
        List<Annotation> list = getterAnnotations.get(pojoName).get(featureName);
        if (list == null)
            getterAnnotations.get(pojoName).put(featureName, list = new ArrayList<Annotation>());
        list.addAll(annotations);
    }

    void addSetterAnnotations(String pojoName, String featureName, List<Annotation> annotations) {
        if (!setterAnnotations.containsKey(pojoName))
            setterAnnotations.put(pojoName, new HashMap<String, List<Annotation>>());
        List<Annotation> list = setterAnnotations.get(pojoName).get(featureName);
        if (list == null)
            setterAnnotations.get(pojoName).put(featureName, list = new ArrayList<Annotation>());
        list.addAll(annotations);
    }

    void addAttributeAnnotations(String pojoName, String featureName, List<Annotation> annotations) {
        if (!attributeAnnotations.containsKey(pojoName))
            attributeAnnotations.put(pojoName, new HashMap<String, List<Annotation>>());
        List<Annotation> list = attributeAnnotations.get(pojoName).get(featureName);
        if (list == null)
            attributeAnnotations.get(pojoName).put(featureName, list = new ArrayList<Annotation>());
        list.addAll(annotations);
    }

    @Override
    public String toString() {
        return "Annotations [entityAnnotations=" + entityAnnotations + ", setterAnnotations=" + setterAnnotations
                + ", getterAnnotations=" + getterAnnotations + ", attributeAnnotations=" + attributeAnnotations + "]";
    }
}
