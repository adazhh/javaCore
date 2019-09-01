package algorithm.offerGuide;

/**
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 */
public class O16MergeList {
    public ListNode merge(ListNode list1, ListNode list2){
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        ListNode mergeHead = null;
        while (list1!=null && list2!=null){
            
        }
        return null;
    }
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
