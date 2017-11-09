package Table2;


public class Main {
    public static void main(String[] args) {
        HT t = new HT(5);
        t.put("a", "w");
        t.put("b", "w");
        t.put("c", "aaa");
        t.put("d", "w");
        t.put("e", "w");
        t.put("f", "w");
        t.remove("f");
        t.prn();
        System.out.println();
        String answ = t.get("c");
        System.out.println(answ);
        System.out.println();
    }
}
