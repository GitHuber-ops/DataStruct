import java.util.Arrays;

public class FibonacciSearch {
    public static int max = 20;

    public static void main(String[] args) {
        int arr[] = {1, 9, 11, 23, 34, 89};
        System.out.println(fibSearch(arr, 23));
    }

    public static int[] fib() {
        int[] fib = new int[max];
        fib[0] = 1;
        fib[1] = 1;
        for (int i = 2; i < fib.length; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }
        return fib;
    }

    public static int fibSearch(int[] arr, int key) {
        int low = 0;
        int high = arr.length - 1;
        int k = 0;
        int mid = 0;
        int f[] = fib();

        while (high > f[k] - 1) {
            k++;
        }

        int[] temp = Arrays.copyOf(arr, f[k]);

        for (int i = high + 1; i < temp.length; i++) {
            temp[i] = arr[high];
        }

        while (low <= high) {
            mid = low + f[k - 1] - 1;
            if (key < temp[mid]) {
                high = mid - 1;
                k--;
            } else if (key > temp[mid]) {
                low = mid + 1;
                k -= 2;
            } else {
                if (mid <= high) {
                    return mid;
                } else {
                    return high;
                }
            }
        }
        return -1;
    }
}
