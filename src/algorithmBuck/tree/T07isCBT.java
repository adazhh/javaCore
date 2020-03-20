package algorithmBuck.tree;

import java.util.Stack;

public class T07isCBT {
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }
    public static boolean isCBT(Node head){
        if (head == null) return true;
        Stack<Node> stack = new Stack<>();
        stack.push(head);
        boolean leaf = false;
        Node left;
        Node right;
        while (!stack.isEmpty()){
            head = stack.pop();
            left = head.left;
            right = head.right;
            if (left == null){ // 左子树为空
                if (right != null) return false; // 左子树为空右子树也只能为空
                leaf = true;
            }else { // 左子树不为空
                if (leaf) return false; // 如果已经开启了叶子节点，左子树必须为空
                stack.push(left);
                if (right != null){
                    stack.push(right);
                } else {
                    leaf = true;
                }
            }
        }
        return true;
    }
    // for test -- print tree
    public static void printTree(Node head) {
        System.out.println("Binary Tree:");
        printInOrder(head, 0, "H", 17);
        System.out.println();
    }

    public static void printInOrder(Node head, int height, String to, int len) {
        if (head == null) {
            return;
        }
        printInOrder(head.right, height + 1, "v", len);
        String val = to + head.value + to;
        int lenM = val.length();
        int lenL = (len - lenM) / 2;
        int lenR = len - lenM - lenL;
        val = getSpace(lenL) + val + getSpace(lenR);
        System.out.println(getSpace(height * len) + val);
        printInOrder(head.left, height + 1, "^", len);
    }

    public static String getSpace(int num) {
        String space = " ";
        StringBuffer buf = new StringBuffer("");
        for (int i = 0; i < num; i++) {
            buf.append(space);
        }
        return buf.toString();
    }

    public static void main(String[] args) {
        Node head = new Node(4);
        head.left = new Node(2);
        head.right = new Node(6);
        head.left.left = new Node(1);
        head.left.right = new Node(3);
        head.right.left = new Node(5);

        printTree(head);
        System.out.println(isCBT(head));

    }
}
