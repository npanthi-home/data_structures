package graph.unionfind.percolation;

import common.node.GraphNode;
import graph.unionfind.UnionFind;
import graph.unionfind.WeightedQuickUnionWithPathCompression;

import static graph.unionfind.percolation.PercolationSite.generateId;

public class PercolationFinder {
    private UnionFind<String> unionFind = new WeightedQuickUnionWithPathCompression<>();

    public boolean doesPercolate(PercolationModel model) {
        String topVirtualNode = "_top_";
        String bottomVirtualNode = "_bottom_";

        connectRowToVirtualNode(model, 0, topVirtualNode);
        connectRowToVirtualNode(model, model.getRowCount() - 1, bottomVirtualNode);
        connectUnblockedNodes(model);

        return unionFind.isConnected(topVirtualNode, bottomVirtualNode);
    }

    private void connectUnblockedNodes(PercolationModel model) {
        for (long row = 0; row < model.getRowCount(); row++) {
            for (long column = 0; column < model.getColumnCount(); column++) {
                String siteId = generateId(row, column);
                GraphNode<PercolationSite> site = model.get(siteId);
                if (!site.getData().isBlocked()) {
                    if (isRightAvailable(model, column)) {
                        String rightSiteId = generateId(row, column + 1);
                        GraphNode<PercolationSite> rightSite = model.get(rightSiteId);
                        if (!rightSite.getData().isBlocked())
                            unionFind.connect(siteId, rightSiteId);
                    }

                    if (isBottomAvailable(model, row)) {
                        String bottomSiteId = generateId(row + 1, column);
                        GraphNode<PercolationSite> bottomSite = model.get(bottomSiteId);
                        if (!bottomSite.getData().isBlocked())
                            unionFind.connect(siteId, bottomSiteId);
                    }
                }
            }
        }
    }

    private boolean isRightAvailable(PercolationModel model, long currentColumn) {
        return currentColumn < model.getColumnCount() - 1;
    }

    private boolean isBottomAvailable(PercolationModel model, long currentRow) {
        return currentRow < model.getRowCount() - 1;
    }

    private void connectRowToVirtualNode(PercolationModel model, long row, String virtualNode) {
        for (int column = 0; column < model.getColumnCount(); column++) {
            unionFind.connect(virtualNode, generateId(row, column));
        }
    }
}
