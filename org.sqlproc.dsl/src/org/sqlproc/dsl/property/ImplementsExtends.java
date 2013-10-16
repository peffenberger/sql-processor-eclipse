package org.sqlproc.dsl.property;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.xtext.common.types.JvmType;

public class ImplementsExtends {

    JvmType toImplement;
    boolean generics;
    List<String> dbColumns;

    public ImplementsExtends(JvmType toImplement, boolean generics, List<String> dbColumns) {
        super();
        this.toImplement = toImplement;
        this.generics = generics;
        this.dbColumns = new ArrayList<String>();
        this.dbColumns.addAll(dbColumns);
    }

    public JvmType getToImplement() {
        return toImplement;
    }

    public void setToImplement(JvmType toImplement) {
        this.toImplement = toImplement;
    }

    public boolean isGenerics() {
        return generics;
    }

    public void setGenerics(boolean generics) {
        this.generics = generics;
    }

    public List<String> getDbColumns() {
        return dbColumns;
    }

    public void setDbColumns(List<String> dbColumns) {
        this.dbColumns = dbColumns;
    }

    @Override
    public String toString() {
        return "ImplementsExtends [toImplement=" + toImplement + ", generics=" + generics + ", dbColumns=" + dbColumns
                + "]";
    }
}
