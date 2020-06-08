public class SingleLinkedList {
    public static void main(String[] args) {
        HeroNode h1 = new HeroNode(1, "a");
        HeroNode h2 = new HeroNode(2, "b");
        HeroNode h3 = new HeroNode(3, "c");
        SingleLinkedListDemo singleLinkedListDemo = new SingleLinkedListDemo();

        singleLinkedListDemo.add(h1);
        singleLinkedListDemo.add(h2);
        singleLinkedListDemo.add(h3);

        singleLinkedListDemo.list();

        singleLinkedListDemo.reverse();
        singleLinkedListDemo.list();
    }
}

class SingleLinkedListDemo {
    private HeroNode head = new HeroNode(0, "");

    public void add(HeroNode heroNode) {
        HeroNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = heroNode;
    }

    public void list() {
        if (head.next == null) {
            System.out.println("Empty list...");
            return;
        }
        HeroNode temp = head.next;
        while (temp != null) {
            System.out.println(temp);
            temp = temp.next;
        }
    }

    public void reverse() {
        HeroNode pre, cur, next;
        cur = head.next.next;
        pre = head.next;
        next = cur.next;
        pre.next = null;

        while (next != null) {
            cur.next = pre;
            pre = cur;
            cur = next;
            next = next.next;
        }
        cur.next = pre;

        head.next = cur;
    }
}

class HeroNode {
    public int no;
    public String name;
    public HeroNode next;

    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name + "   " + "   " + "   " + this.no;
    }

}
