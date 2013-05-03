package org.sqlproc.dsl.resolver;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DbCheckConstraint {
    String constraintName;
    String checkClause;
    String enumName;
    List<String> values;
    String table;
    String column;

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

    public String getEnumName() {
        return enumName;
    }

    public void setEnumName(String enumName) {
        this.enumName = enumName;
    }

    public List<String> getValues() {
        return values;
    }

    public void setValues(List<String> values) {
        this.values = values;
    }

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public String getColumn() {
        return column;
    }

    public void setColumn(String column) {
        this.column = column;
    }

    static final Pattern HSQLDB_CHECK = Pattern
            .compile("\\(([^\\)]*)\\)\\s*IN\\s*\\(\\s*\\('?(.*?)'?\\)\\s*,(?:s*\\('?(.*?)'?\\)\\s*)*\\)");

    public static DbCheckConstraint parseHsqldb(String name, String clause) {
        // (PUBLIC.CONTACT.TYPE) IN ((0),(1))
        // (PUBLIC.PERSON.GENDER) IN (('M'),('F'))
        Matcher matcher = HSQLDB_CHECK.matcher(clause);
        if (matcher.matches()) {
            String[] names = matcher.group(1).trim().split("\\.");
            String relTable = names[names.length - 2];
            String relCol = names[names.length - 1];
            String enumName = relTable + "_" + relCol;
            List<String> values = new ArrayList<String>();
            for (int j = 2; j <= matcher.groupCount(); j++) {
                values.add(matcher.group(j));
            }
            DbCheckConstraint dbCheckConstraint = new DbCheckConstraint();
            dbCheckConstraint.setConstraintName(name);
            dbCheckConstraint.setCheckClause(clause);
            dbCheckConstraint.setEnumName(enumName);
            dbCheckConstraint.setValues(values);
            dbCheckConstraint.setTable(relTable);
            dbCheckConstraint.setColumn(relCol);
            return dbCheckConstraint;
        }
        return null;
    }

    @Override
    public String toString() {
        return "DbCheckConstraint [constraintName=" + constraintName + ", checkClause=" + checkClause + "]";
    }

}
