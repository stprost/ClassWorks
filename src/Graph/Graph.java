package Graph;

import java.util.ArrayList;
import java.util.List;

public class Graph {

    private int size;
    private List<Integer> graphTable[];
    private List<Integer> weight[];

    public List<Integer>[] getWeight() {
        return weight;
    }

    public int getSize() {
        return size;
    }

    public List<Integer>[] getGraphTable() {
        return graphTable;
    }

    public Graph(int size) {
        this.size = size;
        graphTable = new List[size];
        weight = new List[size];
    }

    public void addNode(int key, int[] neighbors) {
        if (graphTable[key] == null) {
            graphTable[key] = new ArrayList<>();
            for (int el : neighbors) {
                graphTable[key].add(el);
            }
        }
    }


    public void addWeight(int key, int[] arcWeight) {
        if (graphTable[key] != null) {
            if (weight[key] == null) {
                weight[key] = new ArrayList<>();
                for (int i = 0; i < graphTable[key].size(); i++) {
                    weight[key].add(arcWeight[i]);
                }
            }
        }
    }
}
