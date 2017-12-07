package TravelingSalesmanProblem;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Tests {

    @Test
    public void test1(){
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
        assertEquals(10.0,tps.findTheWay(),0.0);
    }

    @Test
    public void test2(){
        TPS tps = new TPS(4, 10);
        tps.dist[0][1] = 5;
        tps.dist[1][0] = 5;
        tps.dist[0][2] = 9;
        tps.dist[2][0] = 9;
        tps.dist[0][3] = 4;
        tps.dist[3][0] = 4;
        tps.dist[1][2] = 2;
        tps.dist[2][1] = 2;
        tps.dist[1][3] = 8;
        tps.dist[3][1] = 8;
        tps.dist[2][3] = 1;
        tps.dist[3][2] = 1;
        assertEquals(12.0,tps.findTheWay(),0.0);
    }


    @Test
    public void test3(){
        TPS tps = new TPS(5, 10);
        tps.dist[0][1] = 9;
        tps.dist[1][0] = 9;
        tps.dist[0][2] = 3;
        tps.dist[2][0] = 3;
        tps.dist[0][3] = 2;
        tps.dist[3][0] = 2;
        tps.dist[0][4] = 10;
        tps.dist[4][0] = 10;
        tps.dist[1][2] = 1;
        tps.dist[2][1] = 1;
        tps.dist[1][3] = 7;
        tps.dist[3][1] = 7;
        tps.dist[1][4] = 2;
        tps.dist[4][1] = 2;
        tps.dist[2][3] = 6;
        tps.dist[3][2] = 6;
        tps.dist[2][4] = 8;
        tps.dist[4][2] = 8;
        tps.dist[3][4] = 4;
        tps.dist[4][3] = 4;
        assertEquals(12.0,tps.findTheWay(),0.0);
    }
}
