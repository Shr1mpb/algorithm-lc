import java.util.*;

/**
 * 前 K 个高频元素
 */
public class TopKHighFrequencyElements {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {// 存储频率
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        // 给频率排序 倒序
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((o1, o2) -> o2.getValue() - o1.getValue());
        pq.addAll(map.entrySet());// 这里相当于全部都排序了 O (N log N)，按理说排序前K个就好 可以降到O (N log k)
        // 取出前k个并返回
        List<Integer> ret = new ArrayList<>();
        for (int i = 0; i < k && !pq.isEmpty(); i++) {
            ret.add(pq.poll().getKey());
        }
        return ret.stream().mapToInt(Integer::intValue).toArray();
    }
}
