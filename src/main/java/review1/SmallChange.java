package review1;

import java.util.Arrays;

/**
 * 零钱兑换
 * // TODO
 */
public class SmallChange {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        int[] dp = new int[amount + 1];
        int max = amount + 1;
        Arrays.fill(dp, max);// 表示不可达
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {// 遍历硬币面额
                if (coin <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
