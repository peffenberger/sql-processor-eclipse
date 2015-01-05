package org.sqlproc.dsl.property;

import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.sqlproc.dsl.processorDsl.Entity;
import org.sqlproc.dsl.processorDsl.PojoEntity;
import org.sqlproc.dsl.processorDsl.PojoType;

public class PojoAttrType {
    String name;
    int size;
    String nativeType;
    JvmType type;
    JvmType gtype;
    boolean array;
    Entity ref;
    Entity gref;
    String text;

    public PojoAttrType(String typeName, String size, PojoType pojoType) {
        this.type = pojoType.getType();
        if (type != null) {
            String name = type.getSimpleName();
            if (name.equals("void") || name.equals("byte") || name.equals("char") || name.equals("short")
                    || name.equals("int") || name.equals("long"))
                this.nativeType = name;
        }
        this.ref = pojoType.getRef();
        this.array = pojoType.isArray();
        this.gtype = pojoType.getGtype();
        this.gref = pojoType.getGref();
        if (size != null) {
            try {
                this.size = Integer.parseInt(size);
            } catch (NumberFormatException ignore) {
            }
        }

        String name = typeName;
        int ix = name.indexOf('(');
        int ix2 = (ix >= 0) ? name.indexOf(')', ix + 1) : -1;
        if (ix >= 0 && ix2 >= 0) {
            String num = name.substring(ix + 1, ix2);
            name = name.substring(0, ix);
            try {
                this.size = Integer.parseInt(num);
            } catch (NumberFormatException ignore) {
            }
        }
        this.name = name;
        ICompositeNode node = NodeModelUtils.getNode(pojoType);
        this.text = node.getText();
        if (this.text.startsWith(":"))
            this.text = this.text.substring(1);
        if (this.text.startsWith(":"))
            this.text = this.text.substring(1);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getNativeType() {
        return nativeType;
    }

    public void setNativeType(String nativeType) {
        this.nativeType = nativeType;
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

    public Entity getRef() {
        return ref;
    }

    public void setRef(PojoEntity ref) {
        this.ref = ref;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public JvmType getGtype() {
        return gtype;
    }

    public void setGtype(JvmType gtype) {
        this.gtype = gtype;
    }

    public Entity getGref() {
        return gref;
    }

    public void setGref(PojoEntity gref) {
        this.gref = gref;
    }

    @Override
    public String toString() {
        return "PojoAttrType [name=" + name + ", size=" + size + "]";
    }
}
