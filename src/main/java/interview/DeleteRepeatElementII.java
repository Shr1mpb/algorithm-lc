package interview;

import source.ListNode;

/**
 * 删除排序链表中的重复元素 II
 */
public class DeleteRepeatElementII {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;
        // 两个元素起算 如有两个元素重复 则要去除重复元素
        while (prev.next != null && prev.next.next != null) {
            // 元素重复 让prev.next 指向下一个不重复的地方 继续下一轮循环
            if (prev.next.val == prev.next.next.val) {
                int x = prev.next.val;
                while(prev.next != null && prev.next.val == x) {
                    prev.next = prev.next.next;
                }
            }else{
                // 元素不重复 直接让prev等于下一个元素 作为现有链表的尾部节点
                prev = prev.next;
            }
        }

        return dummy.next;

    }
}
