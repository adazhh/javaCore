package algorithm.linkedList;

public class L04SmallerEqualBigger {
    public static class Node {
        public int value;
        public Node next;
        public Node(int value){
            this.value = value;
        }
    }

    public static Node listPartition1(Node head, int pivot) {
        if (head == null || head.next == null){
            return head;
        }
        Node cur = head;
        int len = 0;
        while (cur != null){
            len++;
            cur = cur.next;
        }
        Node[] nodeArr = new Node[len];
        cur = head;
        int i;
        for (i = 0; i < len; i++) {
            nodeArr[i] = cur;
            cur = cur.next;
        }
        arrPartition(nodeArr, pivot);
        // len - 1是因为最后一个会越界，要额外处理
        for (i = 0; i < len - 1; i++) {
            nodeArr[i].next = nodeArr[i+1];
        }
        nodeArr[i].next = null;
        return nodeArr[0];
    }

    public static void arrPartition(Node[] nodeArr, int pivot) {
        int less = -1;
        int more = nodeArr.length;
        int index = 0;
        while (index < more){
            if (nodeArr[index].value < pivot){
                swap(nodeArr, ++less, index++);
            } else if (nodeArr[index].value == pivot){
                index++;
            } else if (nodeArr[index].value > pivot){
                swap(nodeArr, index, --more);
            }
        }
    }

    public static void swap(Node[] nodeArr, int a, int b) {
        Node tmp = nodeArr[a];
        nodeArr[a] = nodeArr[b];
        nodeArr[b] = tmp;
    }

    public static Node listPartition2(Node head, int pivot) {
        if (head == null || head.next == null){
            return head;
        }
        Node sHead = null;
        Node sTail = null;
        Node eHead = null;
        Node eTail = null;
        Node bHead = null;
        Node bTail = null;
        Node next = null;
        while (head != null){
            next = head.next;
            head.next = null;
            if (head.value < pivot){
                if (sHead == null){
                    sHead = head;
                    sTail = head;
                } else {
                    sTail.next  = head;
                    sTail = head;
                }
            } else if (head.value == pivot){
                if (eHead == null){
                    eHead = head;
                    eTail = head;
                } else {
                    eTail.next  = head;
                    eTail = head;
                }
            } else if (head.value > pivot){
                if (bHead == null){
                    bHead = head;
                    bTail = head;
                } else {
                    bTail.next = head;
                    bTail = head;
                }
            }
            head = next;
        }
        if (sHead != null){
            sTail.next = eHead;
            eTail = (eHead != null) ? eTail : sTail;
        }
        if (eTail != null){
            eTail.next = bHead;
            bTail = (bHead != null) ? bTail : eTail;
        }
        return (sHead != null) ? sHead :
                (eHead != null) ? eHead : bHead;
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
        Node head1 = new Node(7);
        head1.next = new Node(9);
        head1.next.next = new Node(1);
        head1.next.next.next = new Node(8);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(2);
        head1.next.next.next.next.next.next = new Node(5);
        printLinkedList(head1);
        // head1 = listPartition1(head1, 5);
        head1 = listPartition2(head1, 5);
        printLinkedList(head1);

    }
}
