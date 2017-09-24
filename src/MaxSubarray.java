import java.util.Arrays;
import java.util.Random;

public class MaxSubarray {
    public static int a[] = new int[10];

    public static void main(String[] args) {
        fill(a);
        System.out.println(Arrays.toString(a));
        System.out.println();
        fill(a);
        System.out.println(Arrays.toString(a));
        System.out.println();
        fill(a);
        System.out.println(Arrays.toString(a));
        System.out.println();
        fill(a);
        System.out.println(Arrays.toString(a));
    }

    public static void fill(int a[]) {
        int n = a.length;
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            a[i] = random.nextInt(39) - 20;
        }
    }

   // public static int[] max(int a[]) {

   // }
}
