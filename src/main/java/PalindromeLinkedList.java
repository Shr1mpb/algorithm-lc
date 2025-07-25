/**
 * 回文链表
 *  // TODO
 */
public class PalindromeLinkedList {
    // 得到中间 反转后方 开始遍历 比较
    public boolean isPalindrome(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        // 从slow开始 是后半段
        ListNode reversedHead = reverse(slow);
        while(reversedHead != null){
            if(head.val != reversedHead.val) return false;
            head = head.next;
            reversedHead = reversedHead.next;
        }
        return true;
    }

    private ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
