package graph.unionfind;

import org.junit.Test;

public class WeightedQuickUnionTest {
    @Test
    public void run() {
        new UnionFindTest(new WeightedQuickUnion<>()).run();
    }
}
