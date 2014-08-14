package org.sqlproc.dsl.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.sqlproc.dsl.processorDsl.Annotation;
import org.sqlproc.dsl.processorDsl.AnnotationProperty;

public class Annotations {
    Map<String, List<Annotation>> entityAnnotations = new HashMap<String, List<Annotation>>();
    Map<String, List<Annotation>> constructorAnnotations = new HashMap<String, List<Annotation>>();
    Map<String, List<Annotation>> staticAnnotations = new HashMap<String, List<Annotation>>();
    Map<String, List<Annotation>> conflictAnnotations = new HashMap<String, List<Annotation>>();
    Map<String, Map<String, List<Annotation>>> setterAnnotations = new HashMap<String, Map<String, List<Annotation>>>();
    Map<String, Map<String, List<Annotation>>> getterAnnotations = new HashMap<String, Map<String, List<Annotation>>>();
    Map<String, Map<String, List<Annotation>>> attributeAnnotations = new HashMap<String, Map<String, List<Annotation>>>();

    public void addEntityAnnotations(String pojoName, List<Annotation> annotations) {
        entityAnnotations.put(pojoName, new ArrayList<Annotation>());
        entityAnnotations.get(pojoName).addAll(annotations);
    }

    public void addConstructorAnnotations(String pojoName, List<Annotation> annotations) {
        constructorAnnotations.put(pojoName, new ArrayList<Annotation>());
        constructorAnnotations.get(pojoName).addAll(annotations);
    }

    public void addStaticAnnotations(String pojoName, List<Annotation> annotations) {
        staticAnnotations.put(pojoName, new ArrayList<Annotation>());
        staticAnnotations.get(pojoName).addAll(annotations);
    }

    public void addConflictAnnotations(String pojoName, List<Annotation> annotations) {
        conflictAnnotations.put(pojoName, new ArrayList<Annotation>());
        conflictAnnotations.get(pojoName).addAll(annotations);
    }

    public void addGetterAnnotations(String pojoName, String featureName, List<Annotation> annotations) {
        if (!getterAnnotations.containsKey(pojoName))
            getterAnnotations.put(pojoName, new HashMap<String, List<Annotation>>());
        List<Annotation> list = getterAnnotations.get(pojoName).get(featureName);
        if (list == null)
            getterAnnotations.get(pojoName).put(featureName, list = new ArrayList<Annotation>());
        list.addAll(annotations);
    }

    public void addSetterAnnotations(String pojoName, String featureName, List<Annotation> annotations) {
        if (!setterAnnotations.containsKey(pojoName))
            setterAnnotations.put(pojoName, new HashMap<String, List<Annotation>>());
        List<Annotation> list = setterAnnotations.get(pojoName).get(featureName);
        if (list == null)
            setterAnnotations.get(pojoName).put(featureName, list = new ArrayList<Annotation>());
        list.addAll(annotations);
    }

    public void addAttributeAnnotations(String pojoName, String featureName, List<Annotation> annotations) {
        if (!attributeAnnotations.containsKey(pojoName))
            attributeAnnotations.put(pojoName, new HashMap<String, List<Annotation>>());
        List<Annotation> list = attributeAnnotations.get(pojoName).get(featureName);
        if (list == null)
            attributeAnnotations.get(pojoName).put(featureName, list = new ArrayList<Annotation>());
        list.addAll(annotations);
    }

    public StringBuilder getEntityAnnotationsDefinitions(String pojoName, boolean simpleNames) {
        StringBuilder sb = new StringBuilder();
        if (!entityAnnotations.containsKey(pojoName))
            return sb;
        for (Annotation a : entityAnnotations.get(pojoName)) {
            getAnnotationDefinition(sb, a, "\n  @", simpleNames);
        }
        return sb;
    }

    public StringBuilder getConstructorAnnotationsDefinitions(String pojoName, boolean simpleNames) {
        StringBuilder sb = new StringBuilder();
        if (!constructorAnnotations.containsKey(pojoName))
            return sb;
        for (Annotation a : constructorAnnotations.get(pojoName)) {
            getAnnotationDefinition(sb, a, "\n  @@", simpleNames);
        }
        return sb;
    }

    public StringBuilder getStaticAnnotationsDefinitions(String pojoName, boolean simpleNames) {
        StringBuilder sb = new StringBuilder();
        if (!staticAnnotations.containsKey(pojoName))
            return sb;
        for (Annotation a : staticAnnotations.get(pojoName)) {
            getAnnotationDefinition(sb, a, "\n  @@@", simpleNames);
        }
        return sb;
    }

    public StringBuilder getConflictAnnotationsDefinitions(String pojoName, boolean simpleNames) {
        StringBuilder sb = new StringBuilder();
        if (!conflictAnnotations.containsKey(pojoName))
            return sb;
        for (Annotation a : conflictAnnotations.get(pojoName)) {
            getAnnotationDefinition(sb, a, "\n  @@@@", simpleNames);
        }
        return sb;
    }

    public StringBuilder getGetterAnnotationsDefinitions(String pojoName, String featureName, boolean simpleNames) {
        StringBuilder sb = new StringBuilder();
        if (!getterAnnotations.containsKey(pojoName) || !getterAnnotations.get(pojoName).containsKey(featureName))
            return sb;
        for (Annotation a : getterAnnotations.get(pojoName).get(featureName)) {
            getAnnotationDefinition(sb, a, "\n    @@", simpleNames);
        }
        return sb;
    }

    public StringBuilder getSetterAnnotationsDefinitions(String pojoName, String featureName, boolean simpleNames) {
        StringBuilder sb = new StringBuilder();
        if (!setterAnnotations.containsKey(pojoName) || !setterAnnotations.get(pojoName).containsKey(featureName))
            return sb;
        for (Annotation a : setterAnnotations.get(pojoName).get(featureName)) {
            getAnnotationDefinition(sb, a, "\n    @@@", simpleNames);
        }
        return sb;
    }

    public StringBuilder getAttributeAnnotationsDefinitions(String pojoName, String featureName, boolean simpleNames) {
        StringBuilder sb = new StringBuilder();
        if (!attributeAnnotations.containsKey(pojoName) || !attributeAnnotations.get(pojoName).containsKey(featureName))
            return sb;
        for (Annotation a : attributeAnnotations.get(pojoName).get(featureName)) {
            getAnnotationDefinition(sb, a, "\n    @", simpleNames);
        }
        return sb;
    }

    public boolean hasAttributeAnnotationsDefinitions(String pojoName, String featureName, String annotationName) {
        if (attributeAnnotations == null)
            return false;
        if (!attributeAnnotations.containsKey(pojoName) || !attributeAnnotations.get(pojoName).containsKey(featureName))
            return false;
        for (Annotation a : attributeAnnotations.get(pojoName).get(featureName)) {
            String aName = a.getType().getQualifiedName();
            if (annotationName.equals(aName))
                return true;
        }
        return false;
    }

    public void getAnnotationDefinition(StringBuilder sb, Annotation a, String prefix, boolean simpleNames) {
        sb.append(prefix).append((simpleNames) ? a.getType().getSimpleName() : a.getType().getQualifiedName());
        if (a.getFeatures() != null && !a.getFeatures().isEmpty()) {
            sb.append(" ::: ");
            boolean first = true;
            for (AnnotationProperty ap : a.getFeatures()) {
                if (first)
                    first = false;
                else
                    sb.append(", ");
                getAnnotationPropertyDefinition(sb, ap, simpleNames);
            }
        }
    }

    public void getAnnotationPropertyDefinition(StringBuilder sb, AnnotationProperty ap, boolean simpleNames) {
        sb.append(ap.getName());
        if (ap.getType() != null)
            sb.append(" :").append((simpleNames) ? ap.getType().getSimpleName() : ap.getType().getQualifiedName());
        else if (ap.getRef() != null)
            sb.append(" ::").append(ap.getRef().getName());
        sb.append(" ");
        if (ap.getValue() != null)
            sb.append(ap.getValue());
        else if (ap.getNumber() != null)
            sb.append(ap.getNumber());
        else
            sb.append(ap.getConstant());
    }

    public Set<String> getImports() {
        Set<String> imports = new HashSet<String>();
        for (List<Annotation> al : entityAnnotations.values())
            getImports(imports, al);
        for (List<Annotation> al : constructorAnnotations.values())
            getImports(imports, al);
        for (List<Annotation> al : staticAnnotations.values())
            getImports(imports, al);
        for (List<Annotation> al : conflictAnnotations.values())
            getImports(imports, al);
        for (Map<String, List<Annotation>> am : attributeAnnotations.values()) {
            for (List<Annotation> al : am.values()) {
                getImports(imports, al);
            }
        }
        for (Map<String, List<Annotation>> am : getterAnnotations.values()) {
            for (List<Annotation> al : am.values()) {
                getImports(imports, al);
            }
        }
        for (Map<String, List<Annotation>> am : setterAnnotations.values()) {
            for (List<Annotation> al : am.values()) {
                getImports(imports, al);
            }
        }
        return imports;
    }

    public void getImports(Set<String> imports, List<Annotation> al) {
        for (Annotation a : al) {
            if (a.getType() != null)
                imports.add(a.getType().getQualifiedName());
            for (AnnotationProperty ap : a.getFeatures()) {
                if (ap.getType() != null)
                    imports.add(ap.getType().getQualifiedName());
            }
        }
    }

    @Override
    public String toString() {
        return "Annotations [entityAnnotations=" + entityAnnotations + ", constructorAnnotations="
                + constructorAnnotations + ", staticAnnotations=" + staticAnnotations + ", conflictAnnotations="
                + conflictAnnotations + ", setterAnnotations=" + setterAnnotations + ", getterAnnotations="
                + getterAnnotations + ", attributeAnnotations=" + attributeAnnotations + "]";
    }
}
