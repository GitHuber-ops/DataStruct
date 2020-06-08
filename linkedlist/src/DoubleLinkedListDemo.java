public class DoubleLinkedListDemo {
    class HeroNode {
        public int no;
        public String name;
        public HeroNode next;
        public HeroNode pre;

        public HeroNode(int no, String name) {
            this.no = no;
            this.name = name;
        }

        @Override
        public String toString() {
            return this.name + "   " + "   " + "   " + this.no;
        }

    }
}
