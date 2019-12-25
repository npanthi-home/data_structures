package graph.unionfind.percolation;

import graph.UndirectedGraph;

public class PercolationModel extends UndirectedGraph<PercolationSite> {
    private long rowCount;
    private long columnCount;
    private double openProbability;

    PercolationModel(long rowCount, long columnCount, double openProbability) {
        this.rowCount = rowCount;
        this.columnCount = columnCount;
        this.openProbability = openProbability;
    }

    public long getRowCount() {
        return rowCount;
    }

    public long getColumnCount() {
        return columnCount;
    }

    public double getOpenProbability() {
        return openProbability;
    }
}
