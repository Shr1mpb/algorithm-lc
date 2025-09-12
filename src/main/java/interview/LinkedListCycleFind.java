package interview;

import source.ListNode;

/**
 * 环形链表 II
 */
public class LinkedListCycleFind {
    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        boolean moved = false;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                moved = true;
                break;
            }
        }
        if (moved) {
            slow = head;
            while (slow != fast) {
                slow = slow.next;
                fast = fast.next;
            }
            return slow;
        }else{
            return null;
        }
    }
}
