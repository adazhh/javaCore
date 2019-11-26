package algorithm.offerGuide;

public class O35FindFirstCommonNode {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) return null;
        int len1 = getLength(pHead1);
        int len2 = getLength(pHead2);
        int len = Math.abs(len1 - len2);
        while (len != 0) {
            if (len1 >= len2) {
                pHead1 = pHead1.next;
            } else {
                pHead2 = pHead2.next;
            }
            len--;
        }
        while (pHead1 != pHead2){
            pHead1 = pHead1.next;
            pHead2 = pHead2.next;
        }
        return pHead1;
    }

    private int getLength(ListNode node) {
        int length = 0;
        while (node != null) {
            length++;
            node = node.next;
        }
        return length;
    }

    private class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
