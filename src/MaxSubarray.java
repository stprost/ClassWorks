import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class MaxSubarray {
    public static int a[] = new int[10];

    public static void main(String[] args) {
        fill(a);
        System.out.println(Arrays.toString(a));
        System.out.println(max(a).toString());
    }

    public static void fill(int a[]) {
        int n = a.length;
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            a[i] = random.nextInt(39) - 20;
        }
    }

    public static int elemSum(ArrayList<Integer> a) {
        int sum = 0;
        for (Integer el : a) {
            sum += el;
        }
        return sum;
    }

    public static ArrayList max(int a[]) {
        ArrayList ans = new ArrayList();
        ArrayList temp = new ArrayList();
        ans.add(a[0]);
        temp.add(a[0]);
        int n = a.length;
        if (n == 1) return ans;
        else for (int i = 1; i < n; i++) {
            if (elemSum(temp) > elemSum(ans)) {
                ans.clear();
                temp.forEach(ans::add);
            }
            if (elemSum(temp) <= 0) {
                if (elemSum(temp) <= a[i]) {
                    temp.clear();
                    temp.add(a[i]);
                }
            } else if (elemSum(temp) + a[i] <= 0) {
                temp.clear();
                temp.add(a[i]);
            } else temp.add(a[i]);
        }

        if (elemSum(temp) > elemSum(ans)) {
            ans.clear();
            temp.forEach(ans::add);
        }
        return ans;
    }
}

