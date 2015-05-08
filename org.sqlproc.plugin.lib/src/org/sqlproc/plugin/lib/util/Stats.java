package org.sqlproc.plugin.lib.util;

public class Stats {
    public int nTables;
    public int nColumns;
    public int nPrimaryKeys;
    public int nExports;
    public int nImports;
    public int nIndexes;
    public int nCheckConstraints;

    @Override
    public String toString() {
        return "\n// Model statistics\n// Tables=" + nTables + "\n// Columns=" + nColumns + "\n// Primary Keys="
                + nPrimaryKeys + "\n// Exports=" + nExports + "\n// Imports=" + nImports + "\n// Indexes=" + nIndexes
                + "\n// Check Constraints=" + nCheckConstraints + "\n";
    }
}
