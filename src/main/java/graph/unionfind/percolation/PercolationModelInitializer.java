package graph.unionfind.percolation;

public class PercolationModelInitializer {
    public void populate(PercolationModel model) {
        for (long i = 0; i < model.getRowCount(); i++) {
            for (long j = 0; j < model.getColumnCount(); j++) {
                model.add(new PercolationSite(i, j, isBlocked(model.getOpenProbability())));
            }
        }
    }

    private boolean isBlocked(double openProbability) {
        return Math.random() >= openProbability;
    }
}
