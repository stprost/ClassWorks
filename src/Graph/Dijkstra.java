package Graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class Dijkstra {
    public static Integer[] dijkstra(Graph graph, int start) {
        Integer INF = Integer.MAX_VALUE;
        int[] tempPath = new int[graph.getGraphTable().length];
        Integer[] dist = new Integer[graph.getSize()];
        boolean[] used = new boolean[graph.getSize()];
        for (int i = 0; i < dist.length; i++) dist[i] = INF;
        dist[start] = 0;
        int temp = start;
        for (int i = 0; i < graph.getGraphTable().length; i++) {
            int min = INF;
            for (int j = 0; j < graph.getGraphTable().length; j++) {
                if (dist[j] < INF && dist[j] <= min && !used[j]) {
                    min = dist[j];
                    temp = j;
                }
            }
            used[temp] = true;
            for (int j = 0; j < graph.getGraphTable()[temp].size(); j++) {
                if (dist[graph.getGraphTable()[temp].get(j)] > dist[temp] + graph.getWeight()[temp].get(j)) {
                    dist[graph.getGraphTable()[temp].get(j)] = dist[temp] + graph.getWeight()[temp].get(j);
                    tempPath[graph.getGraphTable()[temp].get(j)] = temp;
                }
            }
        }

        return dist;
    }

    public static int dijkstra(Graph graph, int start, int goal){
        return dijkstra(graph, start)[goal];
    }
}
