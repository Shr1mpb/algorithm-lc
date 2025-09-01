package review2;

/**
 * 编辑距离
 */
public class EditDistance {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        // 有一个空串
        if (m * n == 0) {
            return Math.abs(m - n);
        }
        // dp表示把word1的0开始i个 到word2的0开始j个 所需要的编辑次数
        int[][] dp = new int[m + 1][n + 1];
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
                // 此位置相同 等于上一次变换
                if (ch1 == ch2) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    // 此位置不同 需要进行变换(替换、新增、删除)
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                }
            }
        }
        return dp[m][n];
    }
}
