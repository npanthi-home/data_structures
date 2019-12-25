package graph.unionfind.percolation;

public class PercolationSite {
    private String id;
    private boolean isBlocked;
    private long row;
    private long column;

    public PercolationSite(long row, long column, boolean isBlocked) {
        this.row = row;
        this.column = column;
        this.id = generateId(row, column);
        this.isBlocked = isBlocked;
    }

    public static String generateId(long row, long column) {
        return row +"," + column;
    }

    @Override
    public String toString() {
        return id;
    }

    public boolean isBlocked() {
        return isBlocked;
    }
}
