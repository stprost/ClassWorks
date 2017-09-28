package Main;

import java.util.Arrays;

public class HardSort {
    //HeapSort
    public static void f(int a[], int k, int n) {
        int t = a[k];
        int max;
        if (k * 2 + 2 > n) max = k * 2 + 1;
        else if (a[k * 2 + 1] >= a[k * 2 + 2]) max = k * 2 + 1;
        else max = k * 2 + 2;
        if (a[max] > a[k]) {
            a[k] = a[max];
            a[max] = t;
        }
        if (max * 2 + 1 <= n) f(a, max, n);
    }

    public static void heapSort(int a[]) {
        int n = a.length;
        for (int i = n / 2 - 2; i >= 0; i--) f(a, i, n);
        for (int i = n - 1; i > 0; i--) {
            f(a, 0, i);
            int t = a[0];
            a[0] = a[i];
            a[i] = t;
        }
    }

    //QuickSort
    public static void f1(int a[], int l, int m) {
        int t = a[(m + l) / 2];
        int k;
        int i = l;
        int j = m;
        while (i <= j) {
            if (a[i] >= t && a[j] <= t) {
                k = a[i];
                a[i] = a[j];
                a[j] = k;
                i++;
                j--;
            } else {
                if (a[i] < t) i++;
                if (a[j] > t) j--;
            }
        }
        if (j > l) f1(a, l, j);
        if (i < m) f1(a, i, m);
    }

    public static void quickSort(int a[]) {
        f1(a, 0, a.length - 1);
    }

    //Merge sort
    public static void merge(int a[], int l, int m, int r) {
        int left[] = Arrays.copyOfRange(a, l, m + 1);
        int right[] = Arrays.copyOfRange(a, m + 1, r + 1);
        int i = 0;
        int j = 0;
        for (int k = 0; k <= r; k++){
            //if (left[i] < right[j]) a[i]
        }
    }
}
