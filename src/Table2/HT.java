package Table2;

import java.util.ArrayList;

public class HT {
    private static int length;
    private static ArrayList<Data> table;
    private static Data flag = new Data("0", "0");

    public ArrayList<Data> getTable() {
        return this.table;
    }

    public static int hashFun(String key) {
        return key.hashCode() % length;
    }

    public HT(int length) {
        this.length = length;
        table = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            table.add(null);
        }
    }

    public static void put(String k, String v) {
        Data data = new Data(k, v);
        int temp = hashFun(k);
        int count = 0;
        if (table.get(temp) == null) table.set(temp, data);
        else {
            for (int i = 1; i < length - 1; i++) {
                int ind = i + temp;
                if (ind > length - 1) ind -= length;
                if (table.get(ind) == null || table.get(ind) == flag) {
                    table.set(ind, data);
                    count++;
                    break;
                }
            }
            if (count == 0) table.add(data);
            length++;
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
        int temp = hashFun(k);
        for (int i = 0; i < length; i++) {
            int ind = i + temp;
            if (ind >= length) ind -= length;
            if (table.get(ind).getKey() == k) {
                table.set(ind, flag);
            }
        }
    }

    public static void prn() {
        for (int i = 0; i < length; i++) {
            if (table.get(i) == null) System.out.println("[" + i + "] -> null");
            else if (table.get(i) == flag) System.out.println("[" + i + "] -> flag");
            else
                System.out.println("[" + i + "] -> " + "(" + table.get(i).getKey() + ", " + table.get(i).getValue() + ")");

        }
    }
}
