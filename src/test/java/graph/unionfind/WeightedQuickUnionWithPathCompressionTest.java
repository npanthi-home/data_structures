package graph.unionfind;

import org.junit.Test;

public class WeightedQuickUnionWithPathCompressionTest {
    @Test
    public void run() {
        new UnionFindTest(new WeightedQuickUnionWithPathCompression<>()).run();
    }
}
