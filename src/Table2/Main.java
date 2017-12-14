package Table2;


public class Main {
    public static void main(String[] args) {
        HT t = new HT();
        String str = t.put("a", "78w");
        System.out.println(str);
        System.out.println();
        str = t.put("a", "wwww");
        System.out.println(str);
        System.out.println();
        t.put("b", "w");
        t.put("c", "aaa");
        t.prn();
        System.out.println();
        t.remove("b");
        t.prn();
        System.out.println();
        t.put("b", "w");
        t.prn();
        System.out.println();
        String answ = t.get("c");
        System.out.println(answ);
        System.out.println();
        t.put("g","weq");
    }
}
