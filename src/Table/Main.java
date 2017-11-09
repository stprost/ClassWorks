package Table;

public class Main {
    public static void main(String[] args) {
        HT t = new HT(5);
        t.put("c", "w");
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
        t.remove("ca");
        t.remove("ce");
        t.remove("cc");
        t.prn();
    }
}
