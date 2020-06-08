public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {0, 8, 3, 5, 2, 4, 67};
        int[] res = new int[arr.length];
        mergeSort(res, arr, 0, arr.length - 1);
        for (int i : res) {
            System.out.println(i);
        }
    }

    public static void mergeSort(int[] res, int[] arr, int low, int high) {
        int middle = (high + low) / 2;
        int h = high;
        int l = low;

        if (high > low) {
            mergeSort(res, arr, low, middle);
            mergeSort(res, arr, middle + 1, high);
        }


        for (int i = low; i <= high; i++) {
            if (l == (high + low) / 2 + 1) {
                for (int j = middle; j <= h; j++) {
                    res[i] = arr[j];
                    i++;
                }
                break;
            }
            if (middle == high + 1) {
                for (int j = l; j <= (high + low) / 2; j++) {
                    res[i] = arr[j];
                    i++;
                }
                break;
            }

            if (arr[l] < arr[middle]) {
                res[i] = arr[l];
                l++;
            } else {
                res[i] = arr[middle];
                middle++;
            }
        }
        for (int i1 = low; i1 <= high; i1++) {
            arr[i1] = res[i1];
        }
    }
}
