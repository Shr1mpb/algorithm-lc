package review2;

import java.util.Arrays;

/**
 * 最长递增子序列
 * // TODO2: 重温
 */
public class LongestIncreasingSubsequence {
    /**
     * 动态规划：dp代表以这个位置结尾的最长递增子序列的长度
     */
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        // 最小长度为1
        Arrays.fill(dp, 1);
        int maxAns = 1;
        // 遍历后面的位置 每次更新一个位置的最长子序列长度
        for (int i = 1; i < nums.length; i++) {
            // 最小长度为10
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxAns = Math.max(maxAns, dp[i]);
        }
        return maxAns;
    }
}
