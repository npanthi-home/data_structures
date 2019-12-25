package graph.unionfind.percolation;

public class PercolationModelFactory {
    private PercolationModelInitializer initializer = new PercolationModelInitializer();

    public PercolationModel create(long rowCount, long columnCount, long openProbability) {
        PercolationModel model = new PercolationModel(rowCount, columnCount, openProbability);
        initializer.populate(model);
        return model;
    }
}
