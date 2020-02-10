package algorithm.tree;

import java.util.LinkedList;
import java.util.Queue;

public class T03SerializeAndReconstructTree {
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    // 先序遍历序列化
    public static String serialByPre(Node head) {
        if (head == null){
            return "#!";
        }
        StringBuilder builder = new StringBuilder(head.value + "!");
        builder.append(serialByPre(head.left));
        builder.append(serialByPre(head.right));
        return builder.toString();
    }
    // 先序遍历反序列化，先把字符串分解成字符串数组，然后调用递归函数
    public static Node reconByPreString(String preStr) {
        String[] strArr = preStr.split("!");
        LinkedList<String> list = new LinkedList<>();
        for (String s : strArr) {
            list.add(s);
        }
        return reconPreOrder(list);
    }
    // 字符串数组反序列化，递归调用
    public static Node reconPreOrder(LinkedList<String> list) {
        String value = list.poll();
        if (value.equals("#")){
            return null;
        }
        Node head = new Node(Integer.valueOf(value));
        head.left = reconPreOrder(list);
        head.right = reconPreOrder(list);
        return head;
    }


    // 层次遍历序列化
    public static String serialByLevel(Node head) {
        if (head == null) {
            return "#!";
        }
        StringBuilder builder = new StringBuilder(head.value + "!");
        LinkedList<Node> list = new LinkedList<>();
        list.add(head);
        while (!list.isEmpty()){
            head = list.poll();
            if (head.left != null){
                list.add(head.left);
                builder.append(head.left.value + "!");
            }else {
                builder.append("#!");
            }
            if (head.right != null){
                list.add(head.right);
                builder.append(head.right.value + "!");
            }else {
                builder.append("#!");
            }
        }
        return builder.toString();
    }

    public static Node reconByLevelString(String levelStr) {
        String[] strArr = levelStr.split("!");
        int index = 0;
        Node head = generateNodeByString(strArr[index++]);
        if (head == null){
            return null;
        }
        LinkedList<Node> list = new LinkedList<>();
        list.add(head);
        Node node = null;
        while (!list.isEmpty()){
            node = list.poll();
            node.left = generateNodeByString(strArr[index++]);
            node.right = generateNodeByString(strArr[index++]);
            if (node.left != null){
                list.add(node.left);
            }
            if (node.right != null){
                list.add(node.right);
            }
        }
        return head;
    }

    public static Node generateNodeByString(String val) {
        if (val.equals("#")) {
            return null;
        }
        return new Node(Integer.valueOf(val));
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
        Node head = null;
        printTree(head);

        String pre = serialByPre(head);
        System.out.println("serialize tree by pre-order: " + pre);
        head = reconByPreString(pre);
        System.out.print("reconstruct tree by pre-order, ");
        printTree(head);

        String level = serialByLevel(head);
        System.out.println("serialize tree by level: " + level);
        head = reconByLevelString(level);
        System.out.print("reconstruct tree by level, ");
        printTree(head);

        System.out.println("====================================");

        head = new Node(1);
        printTree(head);

        pre = serialByPre(head);
        System.out.println("serialize tree by pre-order: " + pre);
        head = reconByPreString(pre);
        System.out.print("reconstruct tree by pre-order, ");
        printTree(head);

        level = serialByLevel(head);
        System.out.println("serialize tree by level: " + level);
        head = reconByLevelString(level);
        System.out.print("reconstruct tree by level, ");
        printTree(head);

        System.out.println("====================================");

        head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.right.right = new Node(5);
        printTree(head);

        pre = serialByPre(head);
        System.out.println("serialize tree by pre-order: " + pre);
        head = reconByPreString(pre);
        System.out.print("reconstruct tree by pre-order, ");
        printTree(head);

        level = serialByLevel(head);
        System.out.println("serialize tree by level: " + level);
        head = reconByLevelString(level);
        System.out.print("reconstruct tree by level, ");
        printTree(head);

        System.out.println("====================================");

        head = new Node(100);
        head.left = new Node(21);
        head.left.left = new Node(37);
        head.right = new Node(-42);
        head.right.left = new Node(0);
        head.right.right = new Node(666);
        printTree(head);

        pre = serialByPre(head);
        System.out.println("serialize tree by pre-order: " + pre);
        head = reconByPreString(pre);
        System.out.print("reconstruct tree by pre-order, ");
        printTree(head);

        level = serialByLevel(head);
        System.out.println("serialize tree by level: " + level);
        head = reconByLevelString(level);
        System.out.print("reconstruct tree by level, ");
        printTree(head);

        System.out.println("====================================");

    }
}
