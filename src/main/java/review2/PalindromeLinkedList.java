package review2;

import source.ListNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 回文链表
 */
public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        // 最简单 双向队列后再弹出 分奇偶  也可用快慢指针后 翻转链表 然后进行比较
        Deque<ListNode> deque = new LinkedList<ListNode>();
        while (head != null) {
            deque.offer(head);
            head = head.next;
        }
        // 偶数
        if (deque.size() % 2 == 0) {
            while (!deque.isEmpty()) {
                if (deque.removeFirst().val != deque.removeLast().val) {
                    return false;
                }
            }
        }else{
            // 奇数
            while (deque.size() > 1) {
                if (deque.removeFirst().val != deque.removeLast().val) {
                    return false;
                }
            }
        }
        return true;
    }
}
