package Table2;

import java.util.ArrayList;

public class HT {
    private static int length;
    private static Data[] table;
    private static Data flag = new Data("0", "0");

    public static int hashFun(String key) {
        return key.hashCode() % length;
    }

    public HT() {
        length = 3;
        table = new Data[length];
    }

    public static String put(String k, String v) {
        String str = get(k);
        int temp = hashFun(k);
        if (str == null) {
            Data data = new Data(k, v);
            int count = 0;
            if (table[temp] == null) table[temp] = data;
            else {
                for (int i = 1; i < length; i++) {
                    int ind = i + temp;
                    if (ind > length - 1) ind -= length;
                    if (table[ind] == null) {
                        table[ind] = data;
                        count++;
                        break;
                    }
                }
                if (count == 0) {
                    System.out.println("Таблица заполнена");
                }
            }
        } else {
            for (int i = 0; i < length; i++) {
                int ind = i + temp;
                if (ind >= length) ind -= length;
                if (table[ind] != null && table[ind].getKey().equals(k)) {
                    table[ind].setValue(v);
                }
            }
        }
        return str;
    }

    public static String get(String k) {
        int temp = hashFun(k);
        for (int i = 0; i < length; i++) {
            int ind = i + temp;
            if (ind >= length) ind -= length;
            if (table[ind] != null && table[ind].getKey().equals(k)) {
                return table[ind].getValue();
            }
        }
        return null;
    }

    public static String remove(String k) {
        String str = null;
        int temp = hashFun(k);
        for (int i = 0; i < length; i++) {
            int ind = i + temp;
            if (ind >= length) ind -= length;
            if (table[ind].getKey().equals(k)) {
                str = table[ind].getValue();
                table[ind] = null;
            }
        }
        return str;
    }

    public static void prn() {
        for (int i = 0; i < length; i++) {
            if (table[i] == null) System.out.println("[" + i + "] -> null");
            else if (table[i] == flag) System.out.println("[" + i + "] -> flag");
            else
                System.out.println("[" + i + "] -> " + "(" + table[i].getKey() + ", " + table[i].getValue() + ")");

        }
    }
}
