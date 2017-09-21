package Main;

public class HardSort {
    public static int[] f2(int a[], int k, int n) {
        int t = a[k];
        if (a[k * 2 + 1] > a[k * 2 + 2]) {
            a[k] = a[k * 2 + 1];
            a[k * 2 + 1] = t;
        } else {
            a[k] = a[k * 2 + 2];
            a[k * 2 + 2] = t;
        }
        if (k <=)
    }
}
