package review1;

import java.util.*;

/**
 * 滑动窗口最大值
 * 优先队列 O(n log n)
 * 单调队列 O(n) 用单调队列存储索引 淘汰策略 //TODO
 * PriorityQueue 的 remove() 是 O(n)，导致整体 O(nk)，超时。 插入log n 删除 n 查询 1
 * TreeMap 的 remove() 是 O(log k)，整体 O(n log k)，可以通过。插入log n 删除 log n 查询 1
 * 单调队列 的 remove() 是 O(1)（均摊），整体 O(n)，最优解。
 */
public class MaximumSlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new LinkedList<Integer>();
        // 第一个滑窗处理
        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                deque.pollLast();
            }
            deque.offerLast(i);
        }
        int[] res = new int[nums.length - k + 1];
        res[0] = nums[deque.peekFirst()];
        // 开始从第二个滑窗处理
        for (int i = k; i < nums.length; i++) {
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                deque.pollLast();
            }
            deque.offerLast(i);
            // 去除队列中索引不在范围内的
            while (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }
            // 记录滑动窗口最大值
            res[i - k + 1] = nums[deque.peekFirst()];
        }
        return res;
    }

    public int[] maxSlidingWindowPriorityQueue(int[] nums, int k) {
        int max = Integer.MIN_VALUE;
        if (k == nums.length) {
            for (int i = 0; i < nums.length; i++) {
                max = Math.max(max, nums[i]);
            }
            return new int[]{max};
        }
        int[] res = new int[nums.length - k + 1];
        int l = 0, r = l + k - 1;
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int i = 0; i < r; i++) {
            pq.offer(nums[i]);
        }
        List<Integer> list = new ArrayList<>();
        while (r < nums.length) {
            pq.offer(nums[r]);
            list.add(pq.peek());
            pq.remove(nums[l]);
            l++;
            r++;
        }
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public int[] maxSlidingWindowTreeMap(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return new int[0];
        }

        // 特殊情况：k 等于数组长度，直接返回全局最大值
        if (k == nums.length) {
            int max = Integer.MIN_VALUE;
            for (int num : nums) {
                max = Math.max(max, num);
            }
            return new int[]{max};
        }

        // 使用 TreeMap 记录数字及其出现次数（降序排序）
        TreeMap<Integer, Integer> treeMap = new TreeMap<>(Collections.reverseOrder());
        int[] res = new int[nums.length - k + 1];
        int left = 0; // 窗口左边界

        // 初始化第一个窗口 [0, k-1]
        for (int i = 0; i < k; i++) {
            treeMap.put(nums[i], treeMap.getOrDefault(nums[i], 0) + 1);
        }
        res[0] = treeMap.firstKey(); // 第一个窗口的最大值

        // 滑动窗口：右边界从 k 开始
        for (int right = k; right < nums.length; right++) {
            // 添加右边界元素
            treeMap.put(nums[right], treeMap.getOrDefault(nums[right], 0) + 1);

            // 移除左边界元素
            int leftNum = nums[left];
            treeMap.put(leftNum, treeMap.get(leftNum) - 1);
            if (treeMap.get(leftNum) == 0) {
                treeMap.remove(leftNum); // 如果计数归零，移除该键
            }
            left++;

            // 记录当前窗口的最大值
            res[left] = treeMap.firstKey();
        }

        return res;
    }

    public static void main(String[] args) {
        MaximumSlidingWindow window = new MaximumSlidingWindow();
        System.out.println(Arrays.toString(window.maxSlidingWindowTreeMap(new int[]{1, -1}, 1)));
    }
}
