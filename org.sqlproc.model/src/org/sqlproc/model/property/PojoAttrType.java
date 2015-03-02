package org.sqlproc.model.property;

import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmPrimitiveType;

public class PojoAttrType {
    String column;
    String sqlType;
    boolean nativeType;
    JvmParameterizedTypeReference type;

    public PojoAttrType(String column, String sqlType, JvmParameterizedTypeReference type) {
        this.column = column;
        this.sqlType = sqlType;
        this.type = type;
        // JvmPrimitiveTypeImplCustom
        this.nativeType = (type != null && type instanceof JvmPrimitiveType) ? true : false;
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

    public void setNativeType(boolean nativeType) {
        this.nativeType = nativeType;
    }

    public JvmParameterizedTypeReference getType() {
        return type;
    }

    public void setType(JvmParameterizedTypeReference type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "PojoAttrType [column=" + column + ", sqlType=" + sqlType + ", nativeType=" + nativeType + ", type="
                + type + "]";
    }
}
