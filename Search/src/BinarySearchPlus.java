import java.util.ArrayList;

class BinarySearchPlus {
    public static void main(String[] args) {
        int arr[] = {1, 8, 8, 8, 8, 8};
        int res[] = {-1, -1, -1, -1, -1 - 1};
        System.out.println(binarySearch(arr, 0, arr.length - 1, 8));
    }

    public static ArrayList<Integer> binarySearch(int[] arr, int left, int right, int findVal) {
        if (left >= right && arr[left] != findVal) {
            return null;
        }
        int mid = (left + right) / 2;
        int midVal = arr[mid];

        if (findVal > midVal) {
            return binarySearch(arr, mid + 1, right, findVal);
        } else if (findVal < midVal) {
            return binarySearch(arr, left, mid, findVal);
        } else {
            ArrayList<Integer> resIndexList = new ArrayList<>();
            int temp = mid - 1;
            while (true) {
                if (temp < 0 || arr[temp] != findVal) {
                    break;
                }
                resIndexList.add(temp);
                temp--;
            }
            resIndexList.add(mid);

            temp = mid + 1;
            while (true) {
                if (temp > arr.length - 1 || arr[temp] != findVal) {
                    break;
                }
                resIndexList.add(temp);
                temp++;
            }
            return resIndexList;
        }
    }
}

