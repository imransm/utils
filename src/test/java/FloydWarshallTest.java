import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FloydWarshallTest {


    @Test
    public void shouldComputeAllPairsShortestPaths() {
       int ne = FloydWarshall.NO_EDGE;
       int[][] graph = new int[][] {{0, 2, 1 ,ne, 4},
                                    {2, 0, ne, ne, 1},
                                    {1, ne, 0, 5, ne},
                                    {ne, ne, 5, 0, 4},
                                    {4, 1, ne, 4, 0}};

        FloydWarshall floydWarshall = new FloydWarshall(graph);
        floydWarshall.findShortestPaths();
        int[][] distance = floydWarshall.getDistance();
        int[][] expectedDistance = new int[][] {
                {0, 2, 1, 6, 3},
                {2, 0, 3, 5, 1},
                {1, 3, 0, 5, 4},
                {6, 5, 5, 0, 4},
                {3, 1, 4, 4, 0}
        };
        for(int i=0; i< graph.length; i++) {
            for (int j =0; j< graph.length; j++) {
                assertEquals(expectedDistance[i][j], distance[i][j]);
            }
        }

    }
}