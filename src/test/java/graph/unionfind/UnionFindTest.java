package graph.unionfind;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class UnionFindTest {
    private UnionFind<Integer> unionFind;

    public UnionFindTest(UnionFind<Integer> unionFind) {
        this.unionFind = unionFind;
    }

    void run() {
        shouldBeAbleToConnectTwoNodes();
        shouldBeAbleToIdentifyDirectConnections();
        shouldBeAbleToIdentifyIndirectConnections();
    }

    private void shouldBeAbleToConnectTwoNodes() {
        unionFind.connect(1, 2);
        unionFind.connect( 1, 4);
        unionFind.connect( 5, 6);
    }

    private void shouldBeAbleToIdentifyDirectConnections() {
        unionFind.connect( 1, 2);
        unionFind.connect(5,6);
        assertTrue(unionFind.isConnected(1, 2));
        assertTrue(unionFind.isConnected(2, 1));
        assertFalse(unionFind.isConnected(1, 3));
        assertFalse(unionFind.isConnected(1, 5));
    }

    private void shouldBeAbleToIdentifyIndirectConnections() {
        unionFind.connect( 1, 2);
        unionFind.connect( 3, 4);
        unionFind.connect(4, 8);
        unionFind.connect(5,6);
        unionFind.connect( 2, 4);
        assertTrue(unionFind.isConnected(1, 4));
        assertTrue(unionFind.isConnected(3, 2));
        assertFalse(unionFind.isConnected(1, 5));
        assertFalse(unionFind.isConnected(1, 7));
    }
}
