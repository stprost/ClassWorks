package Sortings;

public class Sorted {

    public static void prn(int a[]) {
        for (int e : a) {
            System.out.print(e + " ");
        }
        System.out.println();
    }

    public static void sort1(int a[]) {
        int k;
        int n = a.length - 1;
        boolean f;
        do {
            f = false;
            for (int i = 0; i < n; i++) {
                if (a[i] > a[i + 1]) {
                    k = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = k;
                    f = true;
                }
            }
            n--;
        } while (f == true);
    }

    public static void sort2(int a[]) {
        int n = a.length;
        int t;
        int j;
        for (int i = 1; i < n; i++) {
            t = a[i];
            for (j = i - 1; j >= 0; j--) {
                if (a[j] > t) {
                    a[j + 1] = a[j];
                }
                else break;
            }
            a[j+1] = t;
        }
    }

    public static void sort3(int a[]) {
        int n = a.length;
        int min = a[0];
        int max = a[0];
        int k = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] < min) min = a[i];
            if (a[i] > max) max = a[i];
        }
        int count[] = new int[max - min + 1];
        for (int i = 0; i < a.length; i++) count[a[i] - min]++;
        for (int j = 0; j < count.length; j++) {
            while (count[j] > 0) {
                a[k] = j + min;
                k++;
                count[j]--;
            }
        }
    }

}
