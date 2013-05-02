package org.sqlproc.dsl.property;

public class EnumAttribute {

    private String name;
    private String className;
    private Integer intValue;
    private String strValue;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Integer getIntValue() {
        return intValue;
    }

    public void setIntValue(Integer intValue) {
        this.intValue = intValue;
    }

    public String getStrValue() {
        return strValue;
    }

    public void setStrValue(String strValue) {
        this.strValue = strValue;
    }

    @Override
    public String toString() {
        return "EnumAttribute [name=" + name + ", className=" + className + ", intValue=" + intValue + ", strValue="
                + strValue + "]";
    }

}
