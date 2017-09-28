package Main;

public class Mas {
    final static int a[] = {9, 2, 7, 4, 3, 8, 1, 5, 6, 0};

    public static void main(String[] args) {
        Sorted.prn(a);
        HardSort.heapsort(a);
        System.out.println("Sorted:");
        Sorted.prn(a);
    }
}
