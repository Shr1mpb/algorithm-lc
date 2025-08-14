package review1;

/**
 * 最长公共子序列
 * // TODO dp[i][j] 表示 text1 [0:i] 和 text2 [0:j] 的最长公共子序列的长度 左上 + 左右上方 1 <=
 */
public class TheLongestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        int m=text1.length(),n=text2.length();
        int[][] dp=new int[m+1][n+1];
        for(int i=1;i<=m;i++)
            for(int j=1;j<=n;j++){
                if(text1.charAt(i-1)==text2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+1;
                }else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        return dp[m][n];
    }
}
