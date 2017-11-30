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
        return Math.abs(key.hashCode()) % length;
    }

    public HT(int length) {
        this.length = length;
        table = new List[length];
    }

    public HT() {
        this.length = 5;
        table = new List[length];
    }


    public static String put(String k, String v) {
        String str = get(k);
        int temp = hashFun(k);
        if (str == null) {
            Data data = new Data(k, v);
            if (table[temp] == null) {
                table[temp] = new ArrayList<Data>();
            }
            table[temp].add(data);
        }else{
            for (Data data : table[temp])
                if (data.getKey().equals(k))
                    data.setValue(v);
        }
        return str;
    }

    public static String get(String k) {
        int temp = hashFun(k);
        if (table[temp] != null) {
            for (Data data : table[temp])
                if (data.getKey().equals(k))
                    return data.getValue();
        }
        return null;
    }

    public static String  remove(String k) {
        String str = get(k);
        int temp = hashFun(k);
        // == null ret
        if (table[temp] != null) {
            int ind = 0;
            for (Data data : table[temp])
                if (data.getKey().equals(k)) {
                    ind = table[temp].indexOf(data);
                }
            table[temp].remove(ind);
        }
        return str;
        // ret null
    }

    public static void prn() {
        for (int i = 0; i < length; i++) {
            if (table[i] == null) System.out.print("[" + i + "] -> null");
            else {
                System.out.print("[" + i + "]");
                for (Data data : table[i]) System.out.print(" -> (" + data.getKey() + ", " + data.getValue() + ")");
            }
            System.out.println();
        }
    }
}