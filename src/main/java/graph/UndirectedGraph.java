package graph;

import common.node.GraphNode;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class UndirectedGraph<T> {
    private Map<T, GraphNode<T>> nodes = new HashMap<>();

    public void link(T source, T target) {
        if (isAbsent(source))
            add(source);
        if (isAbsent(target))
            add(target);

        GraphNode<T> sourceNode = nodes.get(source);
        GraphNode<T> targetNode = nodes.get(target);
        sourceNode.getConnectedNodes().add(targetNode);
        targetNode.getConnectedNodes().add(sourceNode);
    }

    private boolean isAbsent(T source) {
        return nodes.get(source) == null;
    }

    public void add(T value) {
        nodes.put(value, new GraphNode<T>(value));
    }

    public Set<T> getNodes() {
        return nodes.keySet();
    }

    public GraphNode<T> get(T value) {
        return nodes.get(value);
    }
}
