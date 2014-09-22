/**
 * Created by Imran on 9/21/2014.
 */
public class FloydWarshall {

    static final int NO_EDGE  = 9999;
    private final int[][] graph;
    private int[][] path;
    private int[][] distance;

    public FloydWarshall(int[][] graph) {
        this.graph = graph;
    }
    public void findShortestPaths() {
        distance = new int[graph.length][graph.length];
        path = new int[graph.length][graph.length];
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph.length; j++) {
                distance[i][j] = graph[i][j];
                path[i][j] = j;
            }
        }

        for(int k=0; k< graph.length; k++) {
            for(int i=0; i<graph.length; i++) {
                for(int j=0; j< graph.length; j++) {
                        if (distance[i][j] > distance[i][k] + distance[k][j]) {
                            distance[i][j] = distance[i][k] + distance[k][j];
                            path[i][j] = k;
                        }
                    }
            }
        }
    }

    public int[][] getDistance() {
        return distance;
    }

    public int[][] getPath() {
        return path;
    }
}
