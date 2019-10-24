package graph.unionfind;

import java.util.HashMap;
import java.util.Map;

public class WeightedQuickUnion<T> implements UnionFind<T> {
    private Map<T, NodeDetails> nodeDetails = new HashMap<>();

    public void connect(T source, T target) {
        long newSize = groupSize(source) + groupSize(target);
        if (groupSize(source) > groupSize(target))
            nodeDetails.put(target, new NodeDetails(getRoot(source), newSize));
        else
            nodeDetails.put(source, new NodeDetails(getRoot(target), newSize));
    }

    private T getRoot(T node) {
        if (getParent(node) == null) {
            return node;
        }
        return getRoot(getParent(node));
    }

    private T getParent(T node) {
        NodeDetails details = nodeDetails.get(node);
        return details == null ? null : details.parent;
    }

    private long groupSize(T node) {
        NodeDetails details = nodeDetails.get(node);
        return details == null ? 0 : details.groupSize;
    }

    public boolean isConnected(T source, T target) {
        return getRoot(source).equals(getRoot(target));
    }

    class NodeDetails {
        NodeDetails(T parent, long groupSize) {
            this.parent = parent;
            this.groupSize = groupSize;
        }

        private T parent;
        private long groupSize = 0;
    }
}
