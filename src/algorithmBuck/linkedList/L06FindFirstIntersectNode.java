package algorithmBuck.linkedList;

public class L06FindFirstIntersectNode {
    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    public static Node getIntersectNode(Node head1, Node head2) {
        if (head1 == null || head2 == null) {
            return null;
        }
        Node loop1 = getLoopNode(head1); // 得到第一个入环节点
        Node loop2 = getLoopNode(head2);
        if (loop1 == null && loop2 == null) {
            return noLoop(head1, head2); // 两个无环链表相交问题
        }
        if (loop1 != null && loop2 != null) { // 有环相交问题
            return bothLoop(head1, loop1, head2, loop2);
        }
        return null; // 一个有环一个无环则必定不相交
    }

    // 慢指针从第二个节点出发，快指针从打三个节点出发，相遇后快指针从头节点一节一节走
    // 再相遇的节点的就是环形链表的开始
    public static Node getLoopNode(Node head) { // 不用hash表
        if (head == null || head.next == null || head.next.next == null){
            return null;
        }
        Node cur1 = head.next;
        Node cur2 = head.next.next;
        while (cur1 != cur2){
            if (cur2.next == null || cur2.next.next == null){
                return null;
            }
            cur1 = cur1.next;
            cur2 = cur2.next.next;
        }
        cur2 = head;
        while (cur1 != cur2){
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return cur1;
    }
    // 无环相交问题
    public static Node noLoop(Node head1, Node head2) {
        if (head1 == null || head2 == null) {
            return null;
        }
        int len = 0; // len表示长度差，head1是+1，head2-1，最后判断大小
        Node cur1 = head1, cur2 = head2;
        while (cur1 != null){
            len++;
            cur1 = cur1.next;
        }
        while (cur2 != null){
            len--;
            cur2 = cur2.next;
        }
        if (cur1 != cur2){ // 如果尾节点不同可以直接返回
            return null;
        }
        cur1 = len > 0 ? head1 : head2; // cur1是长的链表
        cur2 = len < 0 ? head1 : head2;
        len = Math.abs(len);
        while (len-- != 0){
            cur1 = cur1.next;
        }
        while (cur1 != cur2){
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return cur1;
    }

    public static Node bothLoop(Node head1, Node loop1, Node head2, Node loop2) {
        Node cur1 = null;
        Node cur2 = null;
        if (loop1 == loop2) { // 入环节点相同，也就是在外面相交，相当于无环相交问题
            int n = 0;
            cur1 = head1;
            cur2 = head2;
            while (cur1 != loop1){
                n++;
                cur1 = cur1.next;
            }
            while (cur2 != loop2){
                n--;
                cur2 = cur2.next;
            }
            cur1 = (n > 0) ? head1 : head2;
            cur2 = (n < 0) ? head1 : head2;
            n = Math.abs(n);
            while (n-- != 0){
                cur1 = cur1.next;
            }
            while (cur1 != cur2){
                cur1 = cur1.next;
                cur2 = cur2.next;
            }
            return cur1;
        } else {  // 环内相交
            cur1 = loop1.next;
            while (cur1 != loop1){
                if (cur1 == loop2){
                    return loop1;
                }
                cur1 = cur1.next;
            }
            return null;
        }
    }

    public static void main(String[] args) {
        // 1->2->3->4->5->6->7->null
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(6);
        head1.next.next.next.next.next.next = new Node(7);

        // 0->9->8->6->7->null
        Node head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next.next.next.next.next; // 8->6
        System.out.println(getIntersectNode(head1, head2).value);

        // 1->2->3->4->5->6->7->4...
        head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(6);
        head1.next.next.next.next.next.next = new Node(7);
        head1.next.next.next.next.next.next = head1.next.next.next; // 7->4

        // 0->9->8->2...
        head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next; // 8->2
        System.out.println(getIntersectNode(head1, head2).value);

        // 0->9->8->6->4->5->6..
        head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next.next.next.next.next; // 8->6
        System.out.println(getIntersectNode(head1, head2).value);

    }
}
