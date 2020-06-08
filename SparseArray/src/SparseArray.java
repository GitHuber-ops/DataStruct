public class SparseArray {
    public static void main(String[] args) {
        int chessArr1[][] = new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;
        for (int[] row : chessArr1) {
            for (int data : row) {
                System.out.printf("%s\t", data);
            }
            System.out.println();
        }


//        Parse to chess.
        int sum = 0;
        for (int[] i : chessArr1) {
            for (int j : i) {
                if (j != 0) {
                    sum += 1;
                }
            }
        }

        int[][] spareArr = new int[sum + 1][3];
        spareArr[0][0] = 11;
        spareArr[0][1] = 11;
        spareArr[0][2] = sum;

        int count = 1;
        for (int i = 0; i < chessArr1.length; i++) {
            for (int j = 0; j < chessArr1.length; j++) {

                if (chessArr1[i][j] != 0) {
                    spareArr[count][0] = i;
                    spareArr[count][1] = j;
                    spareArr[count][2] = chessArr1[i][j];
                    count++;
                }
            }
        }

        System.out.println();
        for (int[] i : spareArr) {
            for (int j : i) {
                System.out.print(j + "   ");
            }
            System.out.println();
        }
        System.out.println();

        int chessArr2[][] = new int[spareArr[0][0]][spareArr[0][1]];
        for (int i = 1; i < spareArr.length; i++) {
            chessArr2[spareArr[i][0]][spareArr[i][1]] = spareArr[i][2];
        }

        for (int[] i : chessArr2) {
            for (int j : i) {
                System.out.print(j + "   ");
            }
            System.out.println();
        }
    }
}
