package Graph;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class BFS {

    public static int[] breadthFirstSearch(Graph graph, int start) {
        int[] parent = new int[graph.getSize()];
        ArrayDeque<Integer> nodeQueue = new ArrayDeque<>();
        boolean[] used = new boolean[graph.getSize()];
        used[start] = true;
        nodeQueue.addFirst(start);
        while (!nodeQueue.isEmpty()) {
            int temp = nodeQueue.pollLast();
            for (Integer el : graph.getGraphTable()[temp]) {
                if (!used[el]) {
                    nodeQueue.addFirst(el);
                    parent[el] = temp;
                    used[el] = true;
                }
            }
        }
        return parent;
    }
}
