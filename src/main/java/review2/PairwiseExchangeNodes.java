package review2;

import source.ListNode;

/**
 * 两两交换链表中的节点
 */
public class PairwiseExchangeNodes {
    public ListNode swapPairs(ListNode head) {
        if (head != null && head.next != null) {
            ListNode next = head.next;
            head.next = swapPairs(next.next);
            next.next = head;
            return next;
        }
        return head;
    }
}
