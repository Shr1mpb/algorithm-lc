package review1;

/**
 * 最长递增子序列
 */
public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int maxans = 1;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;// 最少长度也是1
            for (int j = 0; j < i; j++) {// 遍历前面的长度
                if (nums[i] > nums[j]) {// 当前位置的数大于前面序列中一个位置的数
                    dp[i] = Math.max(dp[i], dp[j] + 1);// 更新当前位置的长度
                }
            }
            maxans = Math.max(maxans, dp[i]);// 更新最大长度
        }
        return maxans;
    }
}
