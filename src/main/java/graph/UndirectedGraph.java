package graph;

import common.node.GraphNode;
import common.node.Node;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class UndirectedGraph<T> {
    private Map<String, GraphNode<T>> nodes = new HashMap<>();

    public void link(T source, T target) {
        if (isAbsent(source))
            add(source);
        if (isAbsent(target))
            add(target);

        GraphNode<T> sourceNode = getValue(source);
        GraphNode<T> targetNode = getValue(target);
        sourceNode.getConnectedNodes().add(targetNode);
        targetNode.getConnectedNodes().add(sourceNode);
    }

    private GraphNode<T> getValue(T node) {
        return nodes.get(node.toString());
    }

    private boolean isAbsent(T source) {
        return getValue(source) == null;
    }

    public void add(T value) {
        nodes.put(value.toString(), new GraphNode<T>(value));
    }

    public Set<T> getNodes() {
        return nodes.values().stream()
                .map(Node::getData)
                .collect(Collectors.toSet());
    }

    public GraphNode<T> get(T value) {
        return getValue(value);
    }

    public GraphNode<T> get(String identifier) {
        return nodes.get(identifier);
    }
}
