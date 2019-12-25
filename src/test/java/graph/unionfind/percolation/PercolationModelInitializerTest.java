package graph.unionfind.percolation;

import graph.UndirectedGraph;
import org.junit.Test;

import static graph.unionfind.percolation.PercolationSite.generateId;
import static org.junit.Assert.*;

public class PercolationModelInitializerTest {
    private PercolationModelInitializer modelGenerator = new PercolationModelInitializer();

    @Test
    public void shouldGenerateCompletelyBlockedPercolationModelWhenProbabilityIsZero() {
        long rows = 10;
        long columns = 10;
        double probability = 0;
        PercolationModel model = new PercolationModel(rows, columns, probability);
        modelGenerator.populate(model);
        for(long i=0; i<rows; i++) {
            for(long j=0; j<columns; j++){
                assertTrue(model.get(generateId(i, j)).getData().isBlocked());
            }
        }
    }

    @Test
    public void shouldGenerateCompletelyOpenPercolationModelWhenProbabilityIsOne() {
        long rows = 10;
        long columns = 10;
        double probability = 1;
        PercolationModel model = new PercolationModel(rows, columns, probability);
        modelGenerator.populate(model);
        for(long i=0; i<rows; i++) {
            for(long j=0; j<columns; j++){
                assertFalse(model.get(generateId(i, j)).getData().isBlocked());
            }
        }
    }

    @Test
    public void shouldGeneratePartiallyOpenPercolationModelWhenProbabilityIsBetweenZeroAndOne() {
        long rows = 10;
        long columns = 10;
        double probability = 0.7;
        long openCount = 0;
        PercolationModel model = new PercolationModel(rows, columns, probability);
        modelGenerator.populate(model);
        for(long i=0; i<rows; i++) {
            for(long j=0; j<columns; j++){
                if(!model.get(generateId(i, j)).getData().isBlocked())
                    openCount++;
            }
        }

        System.out.println(String.format("Open count: %s", openCount));
        assertTrue(openCount < 100);
    }
}