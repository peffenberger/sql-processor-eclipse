package org.sqlproc.meta.property;

import org.eclipse.xtext.common.types.JvmPrimitiveType;
import org.eclipse.xtext.common.types.JvmType;
import org.sqlproc.meta.processorMeta.PojoDefinition;
import org.sqlproc.meta.processorMeta.PojoType;

public class PojoAttrType {
    String column;
    String sqlType;
    boolean nativeType;
    JvmType type;
    JvmType gtype;
    boolean array;
    PojoDefinition ref;
    PojoDefinition gref;

    public PojoAttrType(String column, String sqlType, PojoType pojoType) {
        this.column = column;
        this.sqlType = sqlType;
        this.type = pojoType.getType();
        // JvmPrimitiveTypeImplCustom
        this.nativeType = (type != null && type instanceof JvmPrimitiveType) ? true : false;
        this.ref = pojoType.getRef();
        this.array = pojoType.isArray();
        this.gtype = pojoType.getGtype();
        this.gref = pojoType.getGref();
    }

    public String getColumn() {
        return column;
    }

    public void setColumn(String column) {
        this.column = column;
    }

    public String getSqlType() {
        return sqlType;
    }

    public void setSqlType(String sqlType) {
        this.sqlType = sqlType;
    }

    public boolean isNativeType() {
        return nativeType;
    }

    public JvmType getType() {
        return type;
    }

    public void setType(JvmType type) {
        this.type = type;
    }

    public boolean isArray() {
        return array;
    }

    public void setArray(boolean array) {
        this.array = array;
    }

    public PojoDefinition getRef() {
        return ref;
    }

    public void setRef(PojoDefinition ref) {
        this.ref = ref;
    }

    public JvmType getGtype() {
        return gtype;
    }

    public void setGtype(JvmType gtype) {
        this.gtype = gtype;
    }

    public PojoDefinition getGref() {
        return gref;
    }

    public void setGref(PojoDefinition gref) {
        this.gref = gref;
    }

    @Override
    public String toString() {
        return "PojoAttrType [column=" + column + ", sqlType=" + sqlType + ", nativeType=" + nativeType + ", type="
                + type + ", gtype=" + gtype + ", array=" + array + ", ref=" + ref + ", gref=" + gref + "]";
    }
}
