package source;


public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int x) {
        val = x;
        next = null;
    }
    public ListNode(int x, ListNode ne) {
        val = x;
        next = ne;
    }
}
