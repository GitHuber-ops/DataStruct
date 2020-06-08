public class BinarySearch {
    public static void main(String[] args) {
        int arr[] = {1, 8, 8, 8, 8, 8};
        int res[] = {-1, -1, -1, -1, -1 - 1};
        System.out.println(binarySearch(arr, 0, arr.length - 1, 8));
    }

    public static int binarySearch(int[] arr, int left, int right, int findVal) {
        if (left >= right && arr[left] != findVal) {
            return -1;
        }
        int mid = (left + right) / 2;
        int midVal = arr[mid];

        if (findVal > midVal) {
            return binarySearch(arr, mid + 1, right, findVal);
        } else if (findVal < midVal) {
            return binarySearch(arr, left, mid, findVal);
        } else {
            return mid;
        }
    }
}
