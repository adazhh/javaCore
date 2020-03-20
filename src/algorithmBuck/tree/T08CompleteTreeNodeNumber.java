package algorithmBuck.tree;

public class T08CompleteTreeNodeNumber {
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    public static int nodeNum(Node head) {
        if (head == null) return 0;
        return bs(head, 1, mostLeftLevel(head, 1));
    }
    // l表示当前在第几层，h为总深度
    public static int bs(Node node, int level, int high) {
        if (level == high) return 1;
        if (mostLeftLevel(node.right, level+1) == high){
            return (1<<(high - level)) + bs(node.right, level+1, high);
        } else {
            return (1<<(high-level-1)) + bs(node.left, level+1, high);
        }
    }

    public static int mostLeftLevel(Node node, int level) {
       while (node != null){
           level++;
           node = node.left;
       }
       return level-1;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.left.right = new Node(5);
        head.right.left = new Node(6);
        System.out.println(nodeNum(head));

    }
}
