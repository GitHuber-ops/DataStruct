public class InsertSort {
    public static void main(String[] args) {
        int[] arr = {101, 34, 119, 1};
        insertSort(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }

    public static void insertSort(int[] arr) {
        int insertIndex = 0;
        for (int i = 1; i < arr.length; i++) {
            int value = arr[i];
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    insertIndex++;
                }
            }
            for (int k = i; k > insertIndex; k--) {
                arr[k] = arr[k - 1];
            }
            arr[insertIndex] = value;
            insertIndex = 0;
        }
    }
}
