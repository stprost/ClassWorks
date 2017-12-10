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

    public static int[] breadthFirstSearch(Graph graph, int start, int goal) {
        int temp = goal;
        ArrayDeque<Integer> queuePath = new ArrayDeque<>();
        queuePath.addFirst(temp);
        int[] bsf = breadthFirstSearch(graph, start);
        while (temp != start) {
            temp = bsf[temp];
            queuePath.addFirst(temp);
        }
        int[] path = new int[queuePath.size()];
        for (int i = 0; i < path.length; i++) {
            path[i] = queuePath.pollFirst();
        }
        return path;
    }
}
