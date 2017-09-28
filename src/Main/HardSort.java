package Main;

public class HardSort {

    public static void f2(int a[], int k, int n) {
        int t = a[k];
        int max;
        if (k * 2 + 2 > n) max = k * 2 + 1;
        else if (a[k * 2 + 1] >= a[k * 2 + 2]) max = k * 2 + 1;
        else max = k * 2 + 2;
        if (a[max] > a[k]) {
            a[k] = a[max];
            a[max] = t;
        }
        if (max * 2 + 1 <= n) f2(a, max, n);
    }

    public static void heapsort(int a[]) {
        int n = a.length;
        for (int i = n / 2 - 2; i >= 0; i--) f2(a, i, n);
        for (int i = n - 1; i > 0; i--) {
            f2(a, 0, i);
            int t = a[0];
            a[0] = a[i];
            a[i] = t;
        }
    }
}
