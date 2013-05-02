package org.sqlproc.dsl.resolver;

public class DbCheckConstraint {
    String constraintName;
    String checkClause;

    public String getConstraintName() {
        return constraintName;
    }

    public void setConstraintName(String constraintName) {
        this.constraintName = constraintName;
    }

    public String getCheckClause() {
        return checkClause;
    }

    public void setCheckClause(String checkClause) {
        this.checkClause = checkClause;
    }

    @Override
    public String toString() {
        return "DbCheckConstraint [constraintName=" + constraintName + ", checkClause=" + checkClause + "]";
    }

}
