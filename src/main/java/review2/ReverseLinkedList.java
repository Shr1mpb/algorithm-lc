package review2;

import source.ListNode;


/**
 * 反转链表
 */
public class ReverseLinkedList {
    // 遍历并一个一个向前接
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        var cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
