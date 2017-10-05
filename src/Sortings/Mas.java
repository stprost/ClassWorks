package Sortings;

import java.util.Random;

public class Mas {
    final static int length = 16;
    final static int a[] = new int[length];

    public static void arrayInst() {
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            a[i] = random.nextInt(20);
        }
    }

    public static void main(String[] args) {
        arrayInst();
        Sorted.prn(a);
        HardSort.quickSort(a);
        System.out.println("Sorted:");
        Sorted.prn(a);
    }
}
