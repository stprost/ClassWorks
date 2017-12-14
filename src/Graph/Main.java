package Graph;

import java.util.ArrayDeque;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph(9);
        graph.addNode(0, new int[]{1, 3});
        graph.addNode(1, new int[]{0, 2});
        graph.addNode(2, new int[]{1, 6, 5});
        graph.addNode(3, new int[]{0, 5, 4});
        graph.addNode(4, new int[]{3, 5});
        graph.addNode(5, new int[]{2, 3, 4, 7, 8});
        graph.addNode(6, new int[]{2, 7});
        graph.addNode(7, new int[]{6, 5});
        graph.addNode(8, new int[]{5});
        int[] answ = BFS.breadthFirstSearch(graph, 1, 4);
        System.out.println(Arrays.toString(answ));
        answ = BFS.breadthFirstSearch(graph, 1);
        System.out.println();
        System.out.println(Arrays.toString(answ));

        DFS dfs = new DFS(graph);
        answ = dfs.depthfirstSearch(0,6);
        //System.out.println(Arrays.toString(answ));
        System.out.println();

        graph = new Graph(6);
        graph.addNode(0, new int[]{5, 2, 1});
        graph.addNode(1, new int[]{0, 2, 3});
        graph.addNode(2, new int[]{0, 5, 3, 1});
        graph.addNode(3, new int[]{1, 2, 4});
        graph.addNode(4, new int[]{3, 5});
        graph.addNode(5, new int[]{4, 2, 0});
        graph.addWeight(0, new int[]{14, 9, 7});
        graph.addWeight(1, new int[]{7, 10, 15});
        graph.addWeight(2, new int[]{9, 2, 11, 10});
        graph.addWeight(3, new int[]{15, 11, 6});
        graph.addWeight(4, new int[]{6, 9});
        graph.addWeight(5, new int[]{9, 2, 14});
        Integer[] answ1 = Dijkstra.dijkstra(graph, 2);
        int lenghth = Dijkstra.dijkstra(graph, 2, 4);
        System.out.println(lenghth);
        System.out.println(Arrays.toString(answ1));

    }
}
