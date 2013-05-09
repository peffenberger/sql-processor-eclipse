package org.sqlproc.dsl.ui.templates;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.sqlproc.dsl.processorDsl.Annotation;
import org.sqlproc.dsl.processorDsl.AnnotationProperty;

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

    StringBuilder getEntityAnnotationsDefinitions(String pojoName) {
        StringBuilder sb = new StringBuilder();
        if (!entityAnnotations.containsKey(pojoName))
            return sb;
        for (Annotation a : entityAnnotations.get(pojoName)) {
            getAnnotationDefinition(sb, a, "\n  @");
        }
        return sb;
    }

    StringBuilder getGetterAnnotationsDefinitions(String pojoName, String featureName) {
        StringBuilder sb = new StringBuilder();
        if (!getterAnnotations.containsKey(pojoName) || !getterAnnotations.get(pojoName).containsKey(featureName))
            return sb;
        for (Annotation a : getterAnnotations.get(pojoName).get(featureName)) {
            getAnnotationDefinition(sb, a, "\n    @@");
        }
        return sb;
    }

    StringBuilder getSetterAnnotationsDefinitions(String pojoName, String featureName) {
        StringBuilder sb = new StringBuilder();
        if (!setterAnnotations.containsKey(pojoName) || !setterAnnotations.get(pojoName).containsKey(featureName))
            return sb;
        for (Annotation a : setterAnnotations.get(pojoName).get(featureName)) {
            getAnnotationDefinition(sb, a, "\n    @@@");
        }
        return sb;
    }

    StringBuilder getAttributeAnnotationsDefinitions(String pojoName, String featureName) {
        StringBuilder sb = new StringBuilder();
        if (!attributeAnnotations.containsKey(pojoName) || !attributeAnnotations.get(pojoName).containsKey(featureName))
            return sb;
        for (Annotation a : attributeAnnotations.get(pojoName).get(featureName)) {
            getAnnotationDefinition(sb, a, "\n    @");
        }
        return sb;
    }

    void getAnnotationDefinition(StringBuilder sb, Annotation a, String prefix) {
        sb.append(prefix).append(a.getType().getQualifiedName());
        if (a.getFeatures() != null && !a.getFeatures().isEmpty()) {
            sb.append(" ::: ");
            boolean first = true;
            for (AnnotationProperty ap : a.getFeatures()) {
                if (first)
                    first = false;
                else
                    sb.append(", ");
                getAnnotationPropertyDefinition(sb, ap);
            }
        }
    }

    void getAnnotationPropertyDefinition(StringBuilder sb, AnnotationProperty ap) {
        sb.append(ap.getName());
        if (ap.getType() != null)
            sb.append(" :").append(ap.getType().getQualifiedName());
        sb.append(" ").append(ap.getValue());
    }

    @Override
    public String toString() {
        return "Annotations [entityAnnotations=" + entityAnnotations + ", setterAnnotations=" + setterAnnotations
                + ", getterAnnotations=" + getterAnnotations + ", attributeAnnotations=" + attributeAnnotations + "]";
    }
}
