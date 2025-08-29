package review2;

/**
 * 乘积最大子数组
 * // TODO2: 重温 维护最大、最小值
 */
public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        int len = nums.length;
        int[] max = new int[len];
        int[] min = new int[len];
        for (int i = 0; i < len; i++) {
            max[i] = nums[i];
            min[i] = nums[i];
        }
        for (int i = 1; i < len; i++) {
            max[i] = Math.max(max[i - 1] * nums[i], Math.max(min[i - 1] * nums[i], nums[i]));
            min[i] = Math.min(min[i - 1] * nums[i], Math.min(max[i - 1] * nums[i], nums[i]));
        }
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            ans = Math.max(ans, max[i]);
        }
        return ans;
    }
}
