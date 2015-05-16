package org.sqlproc.model.property;

import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.sqlproc.plugin.lib.property.PojoDefinition;

public class PojoDefinitionImpl implements PojoDefinition {

    String name;
    String clazz;
    JvmParameterizedTypeReference classx;

    public PojoDefinitionImpl(String name, String clazz, JvmParameterizedTypeReference classx) {
        super();
        this.name = name;
        this.clazz = clazz;
        this.classx = classx;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getClazz() {
        return clazz;
    }

    public JvmParameterizedTypeReference getClassx() {
        return classx;
    }

    @Override
    public String getQualifiedName() {
        return (classx != null) ? classx.getQualifiedName() : clazz;
    }
}
