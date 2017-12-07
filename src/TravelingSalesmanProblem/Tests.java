package TravelingSalesmanProblem;

import org.junit.Test;

import java.util.Arrays;

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

    //Тесты на сравнения муравьиного алгоритма с жадным

    //С 20 городами
    @Test
    public void test4(){
        int itersQuantity = 20;
        int count = 0;
        for (int i = 0; i < itersQuantity; i++) {
            TPS tps = new TPS(20, 100);
            if(tps.findTheWay() < tps.findTheWayGreedy()) count++;
        }
        System.out.print("В "+count+" случаях "+"из "+itersQuantity+" муравьиный алгоритм лучше жадного.");
    }

    //С выводом на экран всех длин
    @Test
    public void test5(){
        int itersQuantity = 20;
        int count = 0;
        for (int i = 0; i < itersQuantity; i++) {
            TPS tps = new TPS(20, 100);
            System.out.println(tps.findTheWay() + " " + tps.findTheWayGreedy());
            if(tps.findTheWay() < tps.findTheWayGreedy()) count++;
        }
        System.out.print("В "+count+" случаях "+"из "+itersQuantity+" муравьиный алгоритм лучше жадного.");
    }

    //С 30 городами
    @Test
    public void test6(){
        int itersQuantity = 20;
        int count = 0;
        for (int i = 0; i < itersQuantity; i++) {
            TPS tps = new TPS(30, 100);
            if(tps.findTheWay() < tps.findTheWayGreedy()) count++;
        }
        System.out.print("В "+count+" случаях "+"из "+itersQuantity+" муравьиный алгоритм лучше жадного.");
    }

    @Test
    public void test7(){
        int itersQuantity = 20;
        int count = 0;
        for (int i = 0; i < itersQuantity; i++) {
            TPS tps = new TPS(30, 100);
            System.out.println(tps.findTheWay() + " " + tps.findTheWayGreedy());
            if(tps.findTheWay() < tps.findTheWayGreedy()) count++;
        }
        System.out.print("В "+count+" случаях "+"из "+itersQuantity+" муравьиный алгоритм лучше жадного.");
    }
}
