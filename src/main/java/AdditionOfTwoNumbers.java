/**
 * 两数相加
 */
public class AdditionOfTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 逆序存储 直接开始是个位 相加即可
        ListNode pre = new ListNode(-1);
        ListNode cur = pre;
        int carry = 0;// 进位信息
        while (l1 != null || l2 != null) {
            int sum = carry;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            if(sum >= 10){
                carry = sum / 10;
                sum %= 10;
            }else{
                carry = 0;
            }
            cur.next = new ListNode(sum);
            cur = cur.next;
        }
        if(carry != 0){
            cur.next = new ListNode(carry);
        }
        return pre.next;
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
