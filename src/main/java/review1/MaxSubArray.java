package review1;

/**
 * 最大子数组和
 * 前缀思想 能拿到每段数组的和 然后维护最大
 */
public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        int pre = 0;
        int preMin = 0;
        int maxSum = Integer.MIN_VALUE;
        for (int num : nums) {
            // 先更新前缀最小值 再更新前缀
            preMin = Math.min(pre, preMin);
            pre += num;
            maxSum = Math.max(maxSum, pre - preMin);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        MaxSubArray maxSubArray = new MaxSubArray();
        maxSubArray.maxSubArray(new int[]{-1,-2});
    }
}
