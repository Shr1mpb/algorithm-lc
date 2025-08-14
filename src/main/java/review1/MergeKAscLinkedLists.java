package review1;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 合并K个升序链表
 */
public class MergeKAscLinkedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists==null||lists.length==0)
        {
            return null;
        }
        // 都放到PQ里面 然后一个一个接
        PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
        for (ListNode l : lists){
            while(l != null){
                pq.offer(l);
                l = l.next;
            }
        }
        ListNode head = pq.poll();
        ListNode cur = head;
        while (cur != null) {
            cur.next = pq.poll();
            cur = cur.next;
        }
        return head;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

}
