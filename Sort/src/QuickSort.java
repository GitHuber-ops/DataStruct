public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {0, 8, 3, 5, 2, 4, 67};
        quickSort(arr, 0, arr.length - 1);
        for (int i : arr) {
            System.out.println(i);
        }
    }

    public static void quickSort(int[] arr, int left, int right) {
        int l = left;
        int r = right;
        int middle = (l + r) / 2;
        int pivot = arr[(l + r) / 2];

        if (left >= right) {
            return;
        }

        while (l < r) {
            while (arr[l] < pivot) {
                l += 1;
            }
            while (arr[r] > pivot) {
                r -= 1;
            }
            if (l >= r) {
                break;
            }
            int temp = arr[r];
            arr[r] = arr[l];
            arr[l] = temp;
        }
        quickSort(arr, left, middle);
        quickSort(arr, middle + 1, right);
        return;
    }
}
