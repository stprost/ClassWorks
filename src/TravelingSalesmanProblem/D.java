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
        TPS tps = new TPS(4, 10);
        tps.dist[0][1] = 5;
        tps.dist[1][0] = 5;
        tps.dist[0][2] = 3;
        tps.dist[2][0] = 3;
        tps.dist[0][3] = 4;
        tps.dist[3][0] = 4;
        tps.dist[1][2] = 2;
        tps.dist[2][1] = 2;
        tps.dist[1][3] = 1;
        tps.dist[3][1] = 1;
        tps.dist[2][3] = 6;
        tps.dist[3][2] = 6;
        System.out.print(tps.findTheWay());
    }
}

