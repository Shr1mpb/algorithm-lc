package review1;

/**
 * 分割等和子集
 * // TODO 转换01背包
 */
public class SplitEqualSumSubset {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            sum += num;
            max = Math.max(max, num);
        }
        int target = sum / 2;
        if (sum % 2 != 0 || max > target) return false;
        int[][] dp = new int[nums.length + 1][target + 1];// 前i个物品在容量为j时的最大价值
        for (int i = 1; i <= nums.length; i++) {
            for (int j = 1; j <= target; j++) {
                // 够不够放当前物品
                if (j < nums[i - 1]) {
                    dp[i][j] = dp[i - 1][j];// 不够放 不选
                } else {// 够放 max
                    dp[i][j] = Math.max(dp[i - 1][j - nums[i-1]] + nums[i-1], dp[i - 1][j]);
                }
            }
        }
        for (int i = 1; i <= nums.length; i++) {
            if (dp[i][target] == target) return true;
        }
        return false;
    }
}
