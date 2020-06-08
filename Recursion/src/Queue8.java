import javax.swing.*;

public class Queue8 {
    int number = 8;
    int[] array = new int[number];
    static int count = 0;

    public static void main(String[] args) {
        Queue8 queue8 = new Queue8();
        queue8.check(0);
        System.out.println(count);
    }

    private void check(int n) {
        if (n == number) {
            print();
            return;
        }
        for (int i = 0; i < number; i++) {
            array[n] = i;
            if (!conflict(n)) {
                check(n + 1);
            }
        }
    }

    private void print() {
        count++;
        for (int i : array) {
            System.out.print(i + "  ");
        }
        System.out.println();
    }

    public boolean conflict(int n) {
        for (int i = 0; i < n; i++) {
            if (array[i] == array[n] || Math.abs(n - i) == Math.abs(array[n] - array[i])) {
                return true;
            }
        }
        return false;
    }
}
