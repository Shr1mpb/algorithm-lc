import java.util.HashSet;

/**
 * 相交链表
 */
public class IntersectingLinkedList {
    // 哈希表法
    public ListNode getIntersectionNode0(ListNode headA, ListNode headB) {
        HashSet<ListNode> set = new HashSet<>();
        while (headA != null) {
            set.add(headA);
            headA = headA.next;
        }
        while (headB != null) {
            if (set.contains(headB)) {
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }
    // 优化后 带有数学方法的方法
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = 0, lenB = 0;
        ListNode curA = headA;
        while (curA != null) {
            lenA++;
            curA = curA.next;
        }
        ListNode curB = headB;
        while (curB != null) {
            lenB++;
            curB = curB.next;
        }
        ListNode shortList;
        ListNode longList;
        if (lenA > lenB) {
            shortList = headB;
            longList = headA;
        }else{
            shortList = headA;
            longList = headB;
        }
        int c = Math.abs(lenA - lenB);
        // 长链走c
        while (c > 0) {
            longList = longList.next;
            c--;
        }
        // 一起走 看看有无相交
        while (longList != null) {
            if (longList == shortList) {
                return longList;
            }
            longList = longList.next;
            shortList = shortList.next;
        }
        return null;
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
