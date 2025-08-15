package review2;

import java.util.HashMap;

/**
 * 和为 K 的子数组
 */
public class SumK {
    public int subarraySum(int[] nums, int k) {
        // 前缀和记忆
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0;
        int ans = 0;
        for (int num : nums) {
            sum += num;
            if (map.containsKey(sum - k)) {
                ans += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return ans;
    }
}
