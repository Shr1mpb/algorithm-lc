package review1;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 删除链表的倒数第 N 个结点
 */
public class DeleteNthNodeFromBottomLL {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        Deque<ListNode> stack = new LinkedList<ListNode>();
        ListNode cur = dummy;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        for (int i = 0; i < n; ++i) {
            stack.pop();
        }
        ListNode prev = stack.peek();
        prev.next = prev.next.next;
        ListNode ans = dummy.next;
        return ans;
    }


    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);
        DeleteNthNodeFromBottomLL deleteNthNodeFromBottomLL = new DeleteNthNodeFromBottomLL();
        System.out.println(deleteNthNodeFromBottomLL.removeNthFromEnd(listNode, 2));

    }

    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
        ListNode(int x, ListNode ne) {
            val = x;
            next = ne;
        }
    }
}
