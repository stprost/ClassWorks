package TravelingSalesmanProblem;

import java.util.Random;

public class TPS {
    private int maxCities;
    private int maxDistance;
    private int maxTour;
    private double alpha = 1;
    private double beta = 1;
    private double ro = 0.6;
    private int q = 100;
    private int maxTime;
    private int maxAnts;
    private double minPher;

    private Ant[] ants;
    private City[] cities;
    private double[][] dist;
    private double[][] pher;
    private double bestTour;
    private int[] bestPath;
    private int bestInd;

    class Ant {
        int tempCity;
        int nextCity;
        int pathInd;
        int[] path;
        boolean[] used;
        double tourLength;

        Ant() {
            tempCity = -1;
            nextCity = -1;
            pathInd = -1;
            path = new int[maxCities];
            used = new boolean[maxCities];
            tourLength = 0;
        }
    }

    class City {
        int x;
        int y;

        City() {
            x = 0;
            x = 0;
        }
    }

    public TPS(int maxCities, int maxDistance) {
        this.maxCities = maxCities;
        this.maxDistance = maxDistance;
        maxTour = maxCities * maxDistance;
        maxTime = maxCities*2;
        maxAnts = maxCities;
        minPher = 1.0 / maxCities;
        ants = new Ant[maxAnts];
        dist = new double[maxCities][maxCities];
        pher = new double[maxCities][maxCities];
        bestTour = maxTour;

        cities = new City[maxCities];
        Random random = new Random();
        for (int i = 0; i < maxCities; i++) {
            cities[i] = new City();
            cities[i].x = random.nextInt(maxDistance) + 1;
            cities[i].y = random.nextInt(maxDistance) + 1;
            for (int j = 0; j < maxCities; j++) {
                pher[i][j] = minPher;
                dist[i][j] = 0;
            }
        }
        for (int i = 0; i < maxCities; i++) {
            for (int j = 0; j < maxCities; j++) {
                if (i != j && dist[i][j] == 0) {
                    int x = Math.abs(cities[i].x - cities[j].x);
                    int y = Math.abs(cities[i].y - cities[j].y);
                    dist[i][j] = Math.sqrt((x * x) + (y * y));
                    dist[j][i] = dist[i][j];
                }
            }
        }
    }

    public double findTheWay() {
        int time = 0;
        int goal = 0;
        for (int i = 0; i < maxAnts; i++) {
            ants[i] = new Ant();
            if (goal == maxCities) goal = 0;
            ants[i].tempCity = goal++;
            for (int j = 0; j < maxCities; j++) {
                ants[i].used[j] = false;
            }
            ants[i].pathInd = 1;
            ants[i].tourLength = 0;
            ants[i].path[0] = ants[i].tempCity;
            ants[i].used[ants[i].tempCity] = true;
        }
        while (time++ < maxTime) {
            if (makeMove() == 0) {
                pheromone();
                if (time != maxTime) reloadAnts();
            }
        }
        return bestTour;
    }

    private void pheromone() {
        int start, goal;
        for (int i = 0; i < maxCities; i++) {
            for (int j = 0; j < maxCities; j++) {
                if (i != j) {
                    pher[i][j] *= (1 - ro);
                    if (pher[i][j] < 0) pher[i][j] = minPher;
                }
            }
        }
        for (int i = 0; i < maxAnts; i++) {
            for (int j = 0; j < maxCities; j++) {
                if (j < maxCities - 1) {
                    start = ants[i].path[j];
                    goal = ants[i].path[j + 1];
                } else {
                    start = ants[i].path[j];
                    goal = ants[i].path[0];
                }
                pher[start][goal] += (q / ants[i].tourLength);
                pher[goal][start] = pher[start][goal];
            }
        }
    }

    private int makeMove() {
        int m = 0;
        for (int i = 0; i < maxAnts; i++) {
            if (ants[i].pathInd < maxCities) {
                ants[i].nextCity = chooseTarget(i);
                ants[i].path[ants[i].pathInd++] = ants[i].nextCity;
                ants[i].tourLength += dist[ants[i].tempCity][ants[i].nextCity];
                ants[i].used[ants[i].nextCity] = true;
                if (ants[i].pathInd == maxCities) {
                    ants[i].tourLength += dist[ants[i].path[maxCities - 1]][ants[i].path[0]];
                }
                ants[i].tempCity = ants[i].nextCity;
                m++;
            }
        }
        return m;
    }

    private int chooseTarget(int ant) {
        int start = ants[ant].tempCity;
        int goal = -1;
        double p;
        double d = 0.0;
        for (int i = 0; i < maxCities; i++) {
            d += (Math.pow(pher[start][i], alpha)) / (Math.pow((1.0 / dist[start][i]), beta));
        }
        while (true) {
            goal++;
            if (goal == maxCities) goal = 0;
            if (!ants[ant].used[goal]) {
                p = num(start, goal) / d;
                if (Math.random() < p) break;
            }
        }
        return goal;
    }

    private double num(int start, int goal) {
        return (Math.pow(pher[start][goal], alpha)) / (Math.pow((1.0 / dist[start][goal]), beta));
    }


    private void reloadAnts() {
        int next = 0;
        for (int i = 0; i < maxAnts; i++) {
            if (ants[i].tourLength < bestTour) {
                bestTour = ants[i].tourLength;
                bestPath = ants[i].path;
                bestInd = i;
            }
            ants[i].nextCity = -1;
            ants[i].tourLength = 0;
            for (int j = 0; j < maxCities; j++) {
                ants[i].used[j] = false;
                ants[i].path[j] = -1;
            }
            if (next == maxCities) next = 0;
            ants[i].tempCity = next++;
            ants[i].pathInd = 1;
            ants[i].path[0] = ants[i].tempCity;
            ants[i].used[ants[i].tempCity] = true;
        }
    }
}
