package Graph;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph(7);
        graph.addNode(1, new int[]{6, 3, 2});
        graph.addNode(2, new int[]{1, 3, 4});
        graph.addNode(3, new int[]{1, 6, 4, 2});
        graph.addNode(4, new int[]{2, 3, 5});
        graph.addNode(5, new int[]{4, 6});
        graph.addNode(6, new int[]{5, 3, 1});
        graph.addWeight(1, new int[]{14, 9, 7});
        graph.addWeight(2, new int[]{7, 10, 15});
        graph.addWeight(3, new int[]{9, 2, 11, 10});
        graph.addWeight(4, new int[]{15, 11, 6});
        graph.addWeight(5, new int[]{6, 9});
        graph.addWeight(6, new int[]{9, 2, 14});
        Integer[] answ = Dijkstra.dijkstra(graph, 4);
        System.out.println(Arrays.toString(answ));
    }
}
