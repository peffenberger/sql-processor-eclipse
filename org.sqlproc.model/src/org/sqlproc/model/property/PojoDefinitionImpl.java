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

    public String getName() {
        return name;
    }

    public String getClazz() {
        return clazz;
    }

    public JvmParameterizedTypeReference getClassx() {
        return classx;
    }
}
