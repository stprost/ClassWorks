package Table;

public class Main {
    public static void main(String[] args) {
        HT t = new HT(5);
        String str = t.put("c", "w");
        System.out.println(str);
        System.out.println();
        str = t.put("c", "s");
        System.out.println(str);
        System.out.println();
        t.put("ca", "t");
        t.put("cd", "r");
        t.put("cca", "t");
        t.put("cc", "t");
        t.put("ce", "t");
        t.prn();
        System.out.println();
        String answ = t.get("cd");
        System.out.println(answ);
        System.out.println();
        str = t.remove("ca");
        System.out.println(str);
        System.out.println();
        str = t.remove("ce");
        System.out.println(str);
        System.out.println();
        str = t.remove("cc");
        System.out.println(str);
        System.out.println();
        t.prn();
    }
}
