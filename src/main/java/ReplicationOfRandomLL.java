import java.util.HashMap;

/**
 * 随机链表的复制
 */
public class ReplicationOfRandomLL {
    // 映射表 复制
    public Node copyRandomList(Node head) {
        if (head == null){
            return null;
        }
        HashMap<Node, Node> map = new HashMap<>();// 原节点 -> 新节点
        Node cur = head;
        // 复制所有节点
        while (cur != null){
            map.put(cur, new Node(cur.val));
            cur = cur.next;
        }
        // 设置所有节点的next和random属性
        Node curr = head;
        while (curr != null){
            Node temp = map.get(curr);
            temp.next = map.get(curr.next);
            temp.random = map.get(curr.random);
            curr = curr.next;
        }
        return map.get(head);
    }

    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}



