package review2;

import source.ListNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 删除链表的倒数第 N 个结点
 * // TODO2: 双指针找到倒数第n个
 */
public class DeleteNthNodeFromBottomLL {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head.next == null && n == 1) {
            return null;
        }
        ListNode dummy = new ListNode(-1, head);
        Deque<ListNode> q = new LinkedList<ListNode>();
        q.push(dummy);
        while(head != null) {
            q.push(head);
            head = head.next;
        }
        // 倒数第n个 弹出
        ListNode remove = null;
        while (n-- != 0) {
            remove = q.poll();
        }
        ListNode prev = q.poll();
        prev.next = remove.next;
        return dummy.next;
    }

    public ListNode removeNthFromEnd0(ListNode head, int n) {
        ListNode sb = new ListNode(-1, head);
        ListNode p1 = sb;
        ListNode p2 = sb;
        for (int i = 0; i < n + 1; i++) {
            // p2向后走n+1次 让p2比p1超前n+1个节点
            p2 = p2.next;
        }
        // p2走到末尾 p1即是要移除的节点的前一个节点
        while (p2 != null) {
            p2 = p2.next;
            p1 = p1.next;
        }
        p1.next = p1.next.next;
        return sb.next;
    }
}
