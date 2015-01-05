package org.sqlproc.dsl.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.sqlproc.dsl.processorDsl.Annotation;
import org.sqlproc.dsl.processorDsl.AnnotationProperty;
import org.sqlproc.dsl.processorDsl.AttributeAnnotation;
import org.sqlproc.dsl.processorDsl.ConflictAnnotation;
import org.sqlproc.dsl.processorDsl.ConstructorAnnotation;
import org.sqlproc.dsl.processorDsl.EntityAnnotation;
import org.sqlproc.dsl.processorDsl.GetterAnnotation;
import org.sqlproc.dsl.processorDsl.PojoPropertyAnnotation;
import org.sqlproc.dsl.processorDsl.SetterAnnotation;
import org.sqlproc.dsl.processorDsl.StandardAnnotation;
import org.sqlproc.dsl.processorDsl.StaticAnnotation;

public class Annotations {
    Map<String, List<Annotation>> entityAnnotations = new HashMap<String, List<Annotation>>();
    Map<String, List<Annotation>> constructorAnnotations = new HashMap<String, List<Annotation>>();
    Map<String, List<Annotation>> staticAnnotations = new HashMap<String, List<Annotation>>();
    Map<String, List<Annotation>> conflictAnnotations = new HashMap<String, List<Annotation>>();
    Map<String, Map<String, List<Annotation>>> setterAnnotations = new HashMap<String, Map<String, List<Annotation>>>();
    Map<String, Map<String, List<Annotation>>> getterAnnotations = new HashMap<String, Map<String, List<Annotation>>>();
    Map<String, Map<String, List<Annotation>>> attributeAnnotations = new HashMap<String, Map<String, List<Annotation>>>();

    public void addAnnotation(String entityName, EntityAnnotation annotation) {
        if (annotation instanceof StandardAnnotation) {
            if (!entityAnnotations.containsKey(entityName))
                entityAnnotations.put(entityName, new ArrayList<Annotation>());
            entityAnnotations.get(entityName).add(annotation.getAnnotation());
        } else if (annotation instanceof ConstructorAnnotation) {
            if (!constructorAnnotations.containsKey(entityName))
                constructorAnnotations.put(entityName, new ArrayList<Annotation>());
            constructorAnnotations.get(entityName).add(annotation.getAnnotation());
        } else if (annotation instanceof StaticAnnotation) {
            if (!staticAnnotations.containsKey(entityName))
                staticAnnotations.put(entityName, new ArrayList<Annotation>());
            staticAnnotations.get(entityName).add(annotation.getAnnotation());
        } else if (annotation instanceof ConflictAnnotation) {
            if (!conflictAnnotations.containsKey(entityName))
                conflictAnnotations.put(entityName, new ArrayList<Annotation>());
            conflictAnnotations.get(entityName).add(annotation.getAnnotation());
        }
    }

    public void addAnnotation(String entityName, String featureName, PojoPropertyAnnotation annotation) {
        if (annotation instanceof SetterAnnotation) {
            if (!setterAnnotations.containsKey(entityName))
                setterAnnotations.put(entityName, new HashMap<String, List<Annotation>>());
            List<Annotation> list = setterAnnotations.get(entityName).get(featureName);
            if (list == null)
                setterAnnotations.get(entityName).put(featureName, list = new ArrayList<Annotation>());
            list.add(annotation.getAnnotation());
        } else if (annotation instanceof GetterAnnotation) {
            if (!getterAnnotations.containsKey(entityName))
                getterAnnotations.put(entityName, new HashMap<String, List<Annotation>>());
            List<Annotation> list = getterAnnotations.get(entityName).get(featureName);
            if (list == null)
                getterAnnotations.get(entityName).put(featureName, list = new ArrayList<Annotation>());
            list.add(annotation.getAnnotation());
        } else if (annotation instanceof AttributeAnnotation) {
            if (!attributeAnnotations.containsKey(entityName))
                attributeAnnotations.put(entityName, new HashMap<String, List<Annotation>>());
            List<Annotation> list = attributeAnnotations.get(entityName).get(featureName);
            if (list == null)
                attributeAnnotations.get(entityName).put(featureName, list = new ArrayList<Annotation>());
            list.add(annotation.getAnnotation());
        }
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
            String aName = (a.getType().getType() != null) ? a.getType().getType().getQualifiedName() : null;
            if (annotationName.equals(aName))
                return true;
        }
        return false;
    }

    // TODO
    public void getAnnotationDefinition(StringBuilder sb, Annotation a, String prefix, boolean simpleNames) {
        // sb.append(prefix).append(
        // (simpleNames) ? a.getType().getType().getSimpleName() : a.getType().getType().getQualifiedName());
        // if (a.getFeatures() != null && !a.getFeatures().isEmpty()) {
        // sb.append(" ::: ");
        // boolean first = true;
        // for (AnnotationProperty ap : a.getFeatures()) {
        // if (first)
        // first = false;
        // else
        // sb.append(", ");
        // getAnnotationPropertyDefinition(sb, ap, simpleNames);
        // }
        // }
    }

    // TODO
    public void getAnnotationPropertyDefinition(StringBuilder sb, AnnotationProperty ap, boolean simpleNames) {
        // sb.append(ap.getName());
        // if (ap.getType() != null)
        // sb.append(" :").append((simpleNames) ? ap.getType().getSimpleName() : ap.getType().getQualifiedName());
        // else if (ap.getRef() != null)
        // sb.append(" ::").append(ap.getRef().getName());
        // sb.append(" ");
        // if (ap.getValue() != null)
        // sb.append(ap.getValue());
        // else if (ap.getNumber() != null)
        // sb.append(ap.getNumber());
        // else
        // sb.append(ap.getConstant());
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
            if (a.getType() != null && a.getType().getType() != null)
                imports.add(a.getType().getType().getQualifiedName());
            for (AnnotationProperty ap : a.getFeatures()) {
                if (ap.getType() != null && ap.getType().getType() != null)
                    imports.add(ap.getType().getType().getQualifiedName());
            }
        }
    }

    public static void grabAnnotations(List<EntityAnnotation> annotations, String entityName,
            Annotations resultAnnotations) {
        if (annotations != null)
            for (EntityAnnotation an : annotations) {
                resultAnnotations.addAnnotation(entityName, an);
            }
    }

    public static void grabAnnotations(List<PojoPropertyAnnotation> annotations, String entityName, String featureName,
            Annotations resultAnnotations) {
        if (annotations != null)
            for (PojoPropertyAnnotation an : annotations) {
                resultAnnotations.addAnnotation(entityName, featureName, an);
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
