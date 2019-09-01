package algorithm.offerGuide;

/**
 * 输入一个链表，输出该链表中倒数第k个结点。
 * 考点1：只遍历一次
 * 考点2：robust，预防空指针
 */
public class O14FindKthToTail {
    public static void main(String[] args) {

    }
    // **
    public ListNode findKthToTail(ListNode head, int k){
        ListNode p, q;
        p = q = head;
        int i = 0;
        for ( ; p!=null; i++){
            if (i >= k){
                q = q.next;
            }
            p = p.next;
        }
        return i < k ? null : q;
    }
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
