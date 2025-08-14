package review1;

import java.util.HashMap;

/**
 * 和为 K 的子数组
 */
public class SumK {
    // TODO
    public int subarraySum(int[] nums, int k) {
        int count = 0, pre = 0;
        // 前缀和为x的有y个
        HashMap<Integer, Integer> mp = new HashMap<>();
        mp.put(0, 1);
        // 前缀累加 之后判断前缀和 因为 前缀累加-前缀和 一定是子数组(连续) 以此相当于遍历了任意一段
        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];
            if (mp.containsKey(pre - k)) {
                count += mp.get(pre - k);
            }
            mp.put(pre, mp.getOrDefault(pre, 0) + 1);
        }
        return count;
    }

}
