package graph;

import common.node.GraphNode;
import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.*;

public class UndirectedGraphTest {
    @Test
    public void shouldBeAbleToBeCreatedForStringBasedNodes() {
        UndirectedGraph<String> graph = new UndirectedGraph<>();
    }

    @Test
    public void shouldBeAbleToBeCreatedForIntegerBasedNodes() {
        UndirectedGraph<Integer> graph = new UndirectedGraph<>();
    }

    @Test
    public void shouldBeAbleToAddNewNode() {
        UndirectedGraph<Integer> integerGraph = new UndirectedGraph<>();
        integerGraph.add(2);
        integerGraph.add(10);
    }

    @Test
    public void shouldBeAbleToPrintAllNodes() {
        UndirectedGraph<Integer> integerGraph = new UndirectedGraph<>();
        integerGraph.add(2);
        integerGraph.add(5);
        integerGraph.add(7);
        integerGraph.add(10);
        Set<Integer> nodes = integerGraph.getNodes();
        assertTrue(nodes.contains(2));
        assertTrue(nodes.contains(5));
        assertTrue(nodes.contains(7));
        assertTrue(nodes.contains(10));
    }

    @Test
    public void shouldBeAbleToFetchAGivenNode() {
        UndirectedGraph<Integer> integerGraph = new UndirectedGraph<>();
        integerGraph.add(2);
        integerGraph.add(5);
        integerGraph.add(7);
        integerGraph.add(10);
        GraphNode<Integer> node = integerGraph.get(2);
        assertEquals(2, node.getData(), 0.0);
    }

    @Test
    public void shouldAddABidirectionalLinkBetweenNodes() {
        UndirectedGraph<Integer> integerGraph = new UndirectedGraph<>();
        integerGraph.add(2);
        integerGraph.add(5);
        integerGraph.link(2, 5);
        GraphNode<Integer> node2 = integerGraph.get(2);
        GraphNode<Integer> node5 = integerGraph.get(5);
        assertEquals(node5, node2.getConnectedNodes().get(0));
        assertEquals(node2, node5.getConnectedNodes().get(0));
    }

    @Test
    public void shouldCreateNodesBeforeCreatingBidirectionalLinksIfTheyDoNotExist() {
        UndirectedGraph<Integer> integerGraph = new UndirectedGraph<>();
        integerGraph.link(2, 5);
        GraphNode<Integer> node2 = integerGraph.get(2);
        GraphNode<Integer> node5 = integerGraph.get(5);
        assertNotNull(node2);
        assertNotNull(node5);
        assertEquals(node5, node2.getConnectedNodes().get(0));
        assertEquals(node2, node5.getConnectedNodes().get(0));
    }
}
