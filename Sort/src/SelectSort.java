public class SelectSort {
    public static void main(String[] args) {
        int[] arr = {101, 34, 119, 1};
        selectSort(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }

    public static void selectSort(int[] arr) {
        int min;
        int minIndex;
        for (int i = 0; i < arr.length; i++) {
            min = arr[i];
            minIndex = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < min) {
                    minIndex = j;
                    min = arr[j];
                }
            }
            arr[minIndex] = arr[i];
            arr[i] = min;
        }
    }
}
