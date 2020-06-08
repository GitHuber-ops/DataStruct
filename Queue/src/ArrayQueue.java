import java.util.Scanner;

public class ArrayQueue {
    public static void main(String[] args) {
        ArrayQueueDemo arrayQueue = new ArrayQueueDemo(3);
        char key = ' ';
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while (loop) {
            System.out.println("s(show):显示队列");
            System.out.println("e(exit):退出程序");
            System.out.println("a(add):添加数据");
            System.out.println("g(get):取出数据");
            key = scanner.next().charAt(0);
            switch (key) {
                case 's':
                    arrayQueue.showQueue();
                    break;
                case 'a':
                    System.out.println("请输入一个数：");
                    int value = scanner.nextInt();
                    arrayQueue.addQueue(value);
                    break;
                case 'g':
                    System.out.println(arrayQueue.getQueue());
                    break;
            }
        }
    }
}

class ArrayQueueDemo {
    private final int maxSize;
    private int front;
    private int rear;
    private final int[] arr;

    public ArrayQueueDemo(int maxSize) {
        this.maxSize = maxSize;
        this.front = -1;
        this.rear = -1;
        this.arr = new int[maxSize];
    }

    public boolean isFull() {
        return rear == maxSize - 1;
    }

    public boolean isEmpty() {
        return rear == front;
    }

    public void addQueue(int n) {
        if (isFull()) {
            System.out.println("队列已满");
            return;
        }
        rear++;
        arr[rear] = n;
    }

    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        front++;
        return arr[front];
    }

    public void showQueue() {
        if (isEmpty()) {
            System.out.println("队列为空");
            return;
        }

        for (int i : arr) {
            System.out.println(i + "   ");
        }
    }

}
