package review1;

/**
 * 最长回文子串
 * // TODO: 前面的某个其他题型中做过 dp[i][j]表示i~j是否回文
 */
public class LongestPalindromeSubstring {
    public String longestPalindrome(String s) {
        int n = s.length();
        if (n == 0) return "";

        boolean[][] dp = new boolean[n][n];
        int maxLen = 1;
        int start = 0;

        // 所有长度为1的子串都是回文
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }

        // 检查长度为2的子串
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
                start = i;
                maxLen = 2;
            }
        }

        // 检查长度大于2的子串
        for (int len = 3; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;  // 子串结束索引
                if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                    if (len > maxLen) {
                        start = i;
                        maxLen = len;
                    }
                }
            }
        }

        return s.substring(start, start + maxLen);
    }

}
