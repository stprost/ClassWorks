package Table;

import java.util.ArrayList;
import java.util.List;

public class HT {
    private static int length;
    private static List<Data> table[];

    public List[] getTable() {
        return this.table;
    }

    public static int hashFun(String key) {
        return key.hashCode() % length;
    }

    public HT(int length) {
        this.length = length;
        table = new List[length];
    }

    public static void put(String k, String v) {
        Data data = new Data(k, v);
        int temp = hashFun(k);
        if (table[temp] == null) {
            table[temp] = new ArrayList<Data>();
        }
        table[temp].add(data);
    }

    public static String get(String k) {
        int temp = hashFun(k);
        if (table[temp] != null) {
            for (Data data : table[temp]) if (data.getKey() == k) return data.getValue();
        }
        return "null";
    }

    public static void remove(String k) {
        int temp = hashFun(k);
        if (table[temp] != null) {
            int ind = 0;
            for (Data data : table[temp])
                if (data.getKey() == k) {
                    ind = table[temp].indexOf(data);
                }
            table[temp].remove(ind);
        }

    }

    public static void prn() {
        for (int i = 0; i < length; i++) {
            if (table[i] == null) System.out.print("["+i+"] -> null");
            else {
                System.out.print("["+i+"]");
                for (Data data : table[i]) System.out.print(" -> ("+data.getKey()+", "+data.getValue()+")");
            }
            System.out.println();
        }
    }
}