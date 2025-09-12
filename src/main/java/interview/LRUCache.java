package interview;


import java.util.HashMap;

/**
 * 手写 LRU
 */
public class LRUCache {
    private static class Node {
        private int key;
        int val;
        Node next;
        Node prev;
        public Node(int key, int val) {
            this.val = val;
        }
    }

    private final int capacity;
    private final HashMap<Integer, Node> map;
    private final Node head;
    private final Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.head = new Node(-1, -1);
        this.tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        Node node = map.get(key);
        if (node == null) {
            return -1;
        }
        moveToTail(node);
        return node.val;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            // 已存在，更新value并移动到尾部
            Node node = map.get(key);
            node.val = value;
            moveToTail(node);
            return;
        }

        // 新建节点
        Node node = new Node(key, value);
        map.put(key, node);
        moveToTail(node);

        // 如果超过容量，驱逐头部节点
        if (map.size() > capacity) {
            Node toRemove = head.next;
            removeNode(toRemove);
            // 从map中移除对应的key
            map.remove(toRemove.key);
        }
    }

    private void moveToTail(Node node) {
        // 先断开节点原有连接（如果已存在）
        if (node.prev != null && node.next != null) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        // 连接到尾部
        node.prev = tail.prev;
        node.next = tail;
        tail.prev.next = node;
        tail.prev = node;
    }

    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.prev = null;
        node.next = null;
    }




}
