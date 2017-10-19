package Table2;

import java.util.ArrayList;

public class HT {
    private static int length;
    private static ArrayList<Data> table;

    public ArrayList<Data> getTable() {
        return this.table;
    }

    public static int hashFun(String key) {
        return key.hashCode() % length;
    }

    public HT(int length) {
        this.length = length;
        table = new ArrayList<>(length);
    }

    public static void put(String k, String v) {
        Data data = new Data(k, v);
        int temp = hashFun(k);
        int count = 0;
        if (table.get(temp) == null) table.add(temp, data);
        else {
            for (int i = 1; i < length - 1; i++) {
                int ind = i + temp;
                if (ind >= length) ind -= length;
                if (table.get(ind) == null) {
                    table.add(ind, data);
                    count++;
                    break;
                }
            }
            if (count == 0) table.add(data);
        }
    }

    public static String get(String k) {
        int temp = hashFun(k);
        for (int i = 0; i < length; i++) {
            int ind = i + temp;
            if (ind >= length) ind -= length;
            if (table.get(ind).getKey() == k) {
                return table.get(ind).getValue();
            }
        }
        return "null";
    }

    public static void remove(String k) {
        Data data = new Data(k, get(k));
        table.remove(data);
    }

    public static void prn() {
        for (int i = 0; i < length; i++) {
            System.out.print("[" + i + "] -> " + table.get(i));
        }
    }
}
