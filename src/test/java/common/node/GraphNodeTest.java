package common.node;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class GraphNodeTest {
    @Test
    public void shouldBeAbleToContainIntegerValue() {
        GraphNode<Integer> node = new GraphNode<>(10);
        assertEquals(10, node.getData(), 0.0);
    }

    @Test
    public void shouldBeAbleToContainStringValue() {
        GraphNode<String> node = new GraphNode<>("Hello");
        assertEquals("Hello", node.getData());
    }

    @Test
    public void shouldBeAbleToGetAllConnectedNodes() {
        GraphNode<Integer> node = new GraphNode<>(10);
        GraphNode<Integer> connectedNode = new GraphNode<>(5);
        node.link(connectedNode);
        List<GraphNode<Integer>> connectedNodes = node.getConnectedNodes();
        assertEquals(connectedNode, connectedNodes.get(0));
    }
}