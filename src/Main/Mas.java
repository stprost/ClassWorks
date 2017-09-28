package Main;

public class Mas {
    final static int a[] = {8, 2, 1, 3};

    public static void main(String[] args) {
        Sorted.prn(a);
        HardSort.heapSort(a);
        System.out.println("Sorted:");
        Sorted.prn(a);
    }
}
