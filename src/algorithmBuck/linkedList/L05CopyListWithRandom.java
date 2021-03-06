package algorithmBuck.linkedList;

import java.util.HashMap;

public class L05CopyListWithRandom {
    public static class Node{
        public int value;
        public Node next;
        public Node rand;
        public Node(int value){
            this.value = value;
        }
    }

    public static Node copyListWithRand1(Node head){
        Node cur = head;
        HashMap<Node, Node> hashMap = new HashMap<>();
        while (cur != null){
            hashMap.put(cur, new Node(cur.value));
            cur = cur.next;
        }
        cur = head;
        while (cur != null){
            hashMap.get(cur).next = hashMap.get(cur.next);
            hashMap.get(cur).rand = hashMap.get(cur.rand);
            cur = cur.next;
        }
        return hashMap.get(head);
    }
    public static Node copyListWithRand2(Node head){
        if (head == null) return null;
        Node cur = head;
        Node copyNode = null;
        while (cur != null){
            copyNode = new Node(cur.value);
            copyNode.next = cur.next;
            cur.next = copyNode;
            cur = copyNode.next;
        }
        cur = head;
        while (cur != null){
            copyNode = cur.next;
            copyNode.rand = (cur.rand != null) ? cur.rand.next : null;
            cur = copyNode.next;
        }
        cur = head;
        Node copyHead = head.next;
        while (cur != null){
            copyNode = cur.next;
            cur.next = cur.next.next;
            cur = cur.next;
            copyNode.next = (cur != null) ? cur.next : null;
        }
        return copyHead;
    }
    public static void printRandLinkedList(Node head) {
        Node cur = head;
        System.out.print("order: ");
        while (cur != null) {
            System.out.print(cur.value + " ");
            cur = cur.next;
        }
        System.out.println();
        cur = head;
        System.out.print("rand:  ");
        while (cur != null) {
            System.out.print(cur.rand == null ? "- " : cur.rand.value + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head = null;
        Node res1 = null;
        Node res2 = null;
        printRandLinkedList(head);
        res1 = copyListWithRand1(head);
        printRandLinkedList(res1);
        res2 = copyListWithRand2(head);
        printRandLinkedList(res2);
        printRandLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);

        head.rand = head.next.next.next.next.next; // 1 -> 6
        head.next.rand = head.next.next.next.next.next; // 2 -> 6
        head.next.next.rand = head.next.next.next.next; // 3 -> 5
        head.next.next.next.rand = head.next.next; // 4 -> 3
        head.next.next.next.next.rand = null; // 5 -> null
        head.next.next.next.next.next.rand = head.next.next.next; // 6 -> 4

        printRandLinkedList(head);
        res1 = copyListWithRand1(head);
        printRandLinkedList(res1);
        System.out.println("-------------");
        res2 = copyListWithRand2(head);
        printRandLinkedList(res2);
        printRandLinkedList(head);
        System.out.println("=========================");

    }
}
