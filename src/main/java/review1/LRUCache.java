package review1;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache extends LinkedHashMap<Integer,Integer> {
    /*
    当 LinkedHashMap 的构造参数 accessOrder=true 时，它会维护一个访问顺序链表​：

    最新访问的条目会被移动到链表末尾
    最久未访问的条目会留在链表头部
    因此：
        最老的条目 = 链表头部的条目（最近最少使用的条目）
        最新的条目 = 链表尾部的条目（最近访问的条目）
     */
    private int capacity;
    public LRUCache(int capacity) {
        super(capacity, 0.75f, true);// accessOrder为false时按插入顺序迭代 为true时最近按照访问顺序升序迭代(最近访问的在后面)
        this.capacity = capacity;
    }
    public int get(int key) {
        return super.getOrDefault(key, -1);
    }
    public void put(int key, int value) {
        super.put(key, value);
    }

    // 这里重写是控制 何时removeEldestEntry
    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }
}
