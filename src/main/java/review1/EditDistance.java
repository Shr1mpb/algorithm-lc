package review1;

/**
 * 编辑距离
 * // TODO 1 <= 0~i->0~j最少步数
 */
public class EditDistance {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        // 有一个字符串为空串
        if (n * m == 0) {
            return n + m;
        }
        // dp【i】【j】代表 word1的0~i字串变为word2的0~j子串需要的最少步数
        int[][] dp = new int[m+1][n+1];
        // 边界初始化
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i <= m; i++) {
            char ch1 = word1.charAt(i - 1);
            for (int j = 1; j <= n; j++) {
                char ch2 = word2.charAt(j - 1);
                if (ch1 == ch2) {// 如果相等 那么不需要额外的操作，直接等于上阶的次数
                    dp[i][j] = dp[i - 1][j - 1];
                }else{// 如果不相等 需要判断哪个最短 对word1    任意替换   第 i 个位置插   删除word1 的第 i 个字符
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i][j - 1]), dp[i - 1][j]) + 1;
                }
            }
        }
        return dp[m][n];
    }
}
