package interview;

import source.ListNode;

/**
 * K 个一组翻转链表
 */
public class KReverseListNode {
    public static ListNode reverseKGroup(ListNode head, int k) {
        // 检查有没有k个
        if (head == null) {
            return null;
        }
        int count = 0;
        ListNode temp = head;
        while (temp != null && count < k) {
            temp = temp.next;
            count++;
        }
        // 不足k个 直接返回
        if (count < k) {
            return head;
        }
        // 有k个 翻转后返回翻转后的头节点 并递归接入下一个
        ListNode pre = null;
        ListNode cur = head;
        while (count > 0) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
            count--;
        }
        // head是尾节点 向尾节点接入下一个链表
        head.next = reverseKGroup(cur, k);
        return pre;
    }
}
