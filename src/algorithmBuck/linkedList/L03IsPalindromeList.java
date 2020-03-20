package algorithmBuck.linkedList;

import java.util.Stack;

public class L03IsPalindromeList {
    public static class Node {
        public int value;
        public Node next;
        public Node(int value){
            this.value = value;
        }
    }

    // need n extra space
    // 简单用一个栈
    public static boolean isPalindrome1(Node head) {
        Node cur = head;
        Stack<Integer> stack = new Stack<>();
        while (cur != null){
            stack.push(cur.value);
            cur = cur.next;
        }
        cur = head;
        while (!stack.isEmpty()){
            if (stack.pop() != cur.value){
                return false;
            }
            cur = cur.next;
        }
        return true;
    }

    // need n/2 extra space
    // 快慢指针
    public static boolean isPalindrome2(Node head) {
        if (head == null || head.next == null){
            return true;
        }
        Node cur1 = head;
        Node cur2 = head; // 快指针
        while (cur2.next != null && cur2.next.next != null){
            cur1 = cur1.next;
            cur2 = cur2.next.next;
        }
        Stack<Integer> stack = new Stack<>();
        while (cur1.next != null){
            stack.push(cur1.next.value);
            cur1 = cur1.next;
        }
        cur1 = head;
        while (!stack.isEmpty()){
            if (stack.pop() != cur1.value){
                return false;
            }
            cur1 = cur1.next;
        }
        return true;
    }
    // 空间复杂度O(1)
    public static boolean isPalindrome3(Node head){
        if (head == null || head.next == null){
            return true;
        }
        Node cur1 = head; // 慢指针
        Node cur2 = head;
        // 单数慢指针停在中间，偶数是中间偏前面那个
        while (cur2.next != null && cur2.next.next != null){
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        cur2 = cur1.next; // 右半链表的头节点
        Node pre = null;
        Node next = null;
        while (cur2 != null){ // 逆转右半链表
            next = cur2.next;
            cur2.next = pre;
            pre = cur2;
            cur2 = next;
        }
        cur2 = pre; // pre是逆转后右半链表的头节点
        cur1 = head;
        boolean res = true; // 不能直接返回false，还要把调整过的链表调整回来
        while (cur2 != null){
            if (cur1.value != cur2.value){
                res = false;
                break;
            }
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        cur2 = pre; // pre记录着逆转后的头节点
        pre = null;
        next = null;
        while (cur2 != null){
            next = cur2.next;
            cur2.next = pre;
            pre = cur2;
            cur2 = next;
        }
        return res;
    }

    public static void printLinkedList(Node node) {
        System.out.print("Linked List: ");
        while (node != null) {
            System.out.print(node.value + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {

        Node head = null;
        printLinkedList(head);
        System.out.print(isPalindrome1(head) + " | ");
        System.out.print(isPalindrome2(head) + " | ");
        System.out.println(isPalindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        printLinkedList(head);
        System.out.print(isPalindrome1(head) + " | ");
        System.out.print(isPalindrome2(head) + " | ");
        System.out.println(isPalindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        printLinkedList(head);
        System.out.print(isPalindrome1(head) + " | ");
        System.out.print(isPalindrome2(head) + " | ");
        System.out.println(isPalindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(1);
        printLinkedList(head);
        System.out.print(isPalindrome1(head) + " | ");
        System.out.print(isPalindrome2(head) + " | ");
        System.out.println(isPalindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        printLinkedList(head);
        System.out.print(isPalindrome1(head) + " | ");
        System.out.print(isPalindrome2(head) + " | ");
        System.out.println(isPalindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(1);
        printLinkedList(head);
        System.out.print(isPalindrome1(head) + " | ");
        System.out.print(isPalindrome2(head) + " | ");
        System.out.println(isPalindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(1);
        printLinkedList(head);
        System.out.print(isPalindrome1(head) + " | ");
        System.out.print(isPalindrome2(head) + " | ");
        System.out.println(isPalindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(2);
        head.next.next.next = new Node(1);
        printLinkedList(head);
        System.out.print(isPalindrome1(head) + " | ");
        System.out.print(isPalindrome2(head) + " | ");
        System.out.println(isPalindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(2);
        head.next.next.next.next = new Node(1);
        printLinkedList(head);
        System.out.print(isPalindrome1(head) + " | ");
        System.out.print(isPalindrome2(head) + " | ");
        System.out.println(isPalindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

    }
}
