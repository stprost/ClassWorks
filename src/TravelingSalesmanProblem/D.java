package TravelingSalesmanProblem;

import java.util.Random;

public class D {
    private static int a = 0;
    static int n (){
        Random random = new Random();
        a = random.nextInt(5)+1;
        return a;
    }
    public static void main(String[] args){
        TPS tps = new TPS(30, 100);
        System.out.print(tps.findTheWay());
    }
}

