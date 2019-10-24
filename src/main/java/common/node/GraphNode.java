package common.node;

import java.util.ArrayList;
import java.util.List;

public class GraphNode<T> extends Node<T> {
    private List<GraphNode<T>> links = new ArrayList<>();

    public GraphNode(T data) {
        super(data);
    }

    public void link(GraphNode<T> node) {
        links.add(node);
    }

    public List<GraphNode<T>> getConnectedNodes() {
        return links;
    }
}
