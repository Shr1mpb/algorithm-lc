/**
 * 打家劫舍
 * // TODO
 */
public class RobHouses {
    public int rob(int[] nums) {
        // dp[i]=max(dp[i−2]+nums[i],dp[i−1]) dp表示前n个房子最大价值
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int length = nums.length;
        if (length == 1) {
            return nums[0];
        }
        int[] dp = new int[length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[length - 1];
    }
}
