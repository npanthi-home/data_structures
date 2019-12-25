package graph.unionfind.percolation;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PercolationFinderTest {
    private PercolationModelFactory factory = new PercolationModelFactory();
    private PercolationFinder percolationFinder = new PercolationFinder();

    @Test
    public void shouldReturnTrueIfItPercolates() {
        PercolationModel model = factory.create(10, 5, 1);
        assertTrue(percolationFinder.doesPercolate(model));
    }

    @Test
    public void shouldReturnFalseIfItDoesNotPercolate() {
        PercolationModel model = factory.create(10, 5, 0);
        assertFalse(percolationFinder.doesPercolate(model));
    }
}
