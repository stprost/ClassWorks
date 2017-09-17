package Main;

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
        for (int i = 1; i < n; i++) {
            t = a[i];
            for (int j = i - 1; j >= 0; j--) {
                if (a[j] > a[j + 1]) {
                    a[j+1] = a[j];
                    a[j] = t;
                }
            }
        }
    }

}
