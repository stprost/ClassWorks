package Graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;

public class DFS {
    private static boolean[] used;
    private static int[] path;
    private static Graph graph;

    public DFS(Graph graph) {
        this.graph = graph;
        used = new boolean[graph.getSize()];
        path = new int[graph.getSize()];
    }

    public static int[] getPath() {
        return path;
    }

    public static int[] depthfirstSearch(int start, int goal) {
        int temp = goal;
        ArrayDeque<Integer> queuePath = new ArrayDeque<>();
        queuePath.addFirst(temp);
        path[start] = 0;
        dfs(start);
        while (temp != start) {
            temp = path[temp];
            queuePath.addFirst(temp);
        }
        int[] answ = new int[queuePath.size()];
        for (int i = 0; i < answ.length; i++) {
            answ[i] = queuePath.pollFirst();
        }
        return answ;
    }

    private static void dfs(int temp) {
        if (used[temp]) return;
        used[temp] = true;
        for (int next : graph.getGraphTable()[temp]) {
            if (!used[next]) {
                dfs(next);
            }
        }
    }

}
