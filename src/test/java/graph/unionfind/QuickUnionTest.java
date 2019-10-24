package graph.unionfind;

import org.junit.Test;

public class QuickUnionTest {
    @Test
    public void run() {
        new UnionFindTest(new QuickUnion<>()).run();
    }
}
