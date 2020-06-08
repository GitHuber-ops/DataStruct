public class RadixSortPlus {
    public static void main(String[] args) {
        int arr[] = {53, 3, 542, 748, 14, 214};
        radix(arr);
        for (int i : arr) {
            System.out.print(i + "  ");
        }
    }

    public static void radix(int[] arr) {
        int max = arr[0];
        for (int i : arr) {
            if (i > max) {
                max = i;
            }
        }
        int maxLength = (max + "").length();

        int[][] bucket = new int[10][arr.length];
        int[] bucketElementCounts = new int[10];

        for (int i = 0, n = 1; i < maxLength; i++, n *= 10) {
            for (int j = 0; j < arr.length; j++) {

                int digitOfElement = (arr[j] / 10) % 10;

                bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
                bucketElementCounts[digitOfElement]++;
            }
            int index = 0;
            for (int k = 0; k < 10; k++) {
                if (bucketElementCounts[k] != 0) {
                    for (int l = 0; l < bucketElementCounts[k]; l++) {
                        arr[index] = bucket[k][l];
                        index++;
                    }
                }
            }
            for (int l = 0; l < bucketElementCounts.length; l++) {
                bucketElementCounts[l] = 0;
            }
        }
    }


}
