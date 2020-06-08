public class RadixSort {
    public static void main(String[] args) {
        int arr[] = {53, 3, 542, 748, 14, 214};
        radix(arr);
        for (int i : arr) {
            System.out.print(i + "  ");
        }
    }

    public static void radix(int[] arr) {
        int[][] bucket = new int[10][arr.length];
        int[] bucketElementCounts = new int[10];

        for (int i = 0; i < arr.length; i++) {
            int digitOfElement = arr[i] % 10;

            bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[i];
            bucketElementCounts[digitOfElement]++;
        }
        int index = 0;
        for (int k = 0; k < 10; k++) {
            if (bucketElementCounts[k] != 0) {
                for (int i = 0; i < bucketElementCounts[k]; i++) {
                    arr[index] = bucket[k][i];
                    index++;
                }
            }
        }
        for (int i = 0; i < bucketElementCounts.length; i++) {
            bucketElementCounts[i] = 0;
        }

        for (int i = 0; i < arr.length; i++) {
            int digitOfElement = (arr[i] / 10) % 10;

            bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[i];
            bucketElementCounts[digitOfElement]++;
        }
        index = 0;
        for (int k = 0; k < 10; k++) {
            if (bucketElementCounts[k] != 0) {
                for (int i = 0; i < bucketElementCounts[k]; i++) {
                    arr[index] = bucket[k][i];
                    index++;
                }
            }
        }
        for (int i = 0; i < bucketElementCounts.length; i++) {
            bucketElementCounts[i] = 0;
        }



        for (int i = 0; i < arr.length; i++) {
            int digitOfElement = (arr[i] / 100) % 10;

            bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[i];
            bucketElementCounts[digitOfElement]++;
        }
        index = 0;
        for (int k = 0; k < 10; k++) {
            if (bucketElementCounts[k] != 0) {
                for (int i = 0; i < bucketElementCounts[k]; i++) {
                    arr[index] = bucket[k][i];
                    index++;
                }
            }
        }
        for (int i = 0; i < bucketElementCounts.length; i++) {
            bucketElementCounts[i] = 0;
        }
    }


}
