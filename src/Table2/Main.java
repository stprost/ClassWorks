package Table2;


public class Main {
    public static void main(String[] args) {
        HT t = new HT(5);
        t.put("c", "w");
        t.put("ca", "t");
        t.put("cd", "t");
        t.put("cca", "t");
        String answ = t.get("cd");
        System.out.println(answ);
        t.prn();
    }
}
