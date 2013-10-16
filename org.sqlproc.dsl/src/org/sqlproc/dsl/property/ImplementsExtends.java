package org.sqlproc.dsl.property;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.xtext.common.types.JvmType;

public class ImplementsExtends {

    JvmType toImplement;
    boolean generics;
    List<String> dbTables;

    public ImplementsExtends(JvmType toImplement, boolean generics, List<String> dbTables) {
        super();
        this.toImplement = toImplement;
        this.generics = generics;
        this.dbTables = new ArrayList<String>();
        this.dbTables.addAll(dbTables);
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

    public List<String> getDbTables() {
        return dbTables;
    }

    public void setDbTables(List<String> dbTables) {
        this.dbTables = dbTables;
    }

    @Override
    public String toString() {
        return "ImplementsExtends [toImplement=" + toImplement + ", generics=" + generics + ", dbTables=" + dbTables
                + "]";
    }
}
