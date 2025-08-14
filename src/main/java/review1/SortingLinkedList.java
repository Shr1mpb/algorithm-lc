package review1;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 排序链表
 */
public class SortingLinkedList {
    public ListNode sortList(ListNode head) {
        // 使用PriorityQueue 复杂度n log n
        PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
        while (head != null) {
            queue.add(head);
            head = head.next;
        }
        ListNode dummy = new ListNode(0);
        ListNode prev = dummy;
        while (!queue.isEmpty()) {
            ListNode node = queue.poll();
            prev.next = node;
            prev = prev.next;
        }
        prev.next = null;
        return dummy.next;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
