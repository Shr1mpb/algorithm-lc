package review2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 分割回文串
 * // TODO2:重温
 */
public class SplitPalindromeString {
    /**
     * 以长度为单位做动态规划
     */
    boolean[][] dp;
    public String[][] partition(String s) {
        if (s.length() == 1) {
            return new String[][]{{s}};
        }
        List<List<String>> res = new ArrayList<>();
        int n = s.length();
        dp = new boolean[n][n];
        // 单个字符是回文串
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }
        // 双字符 看看是否是回文串
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
            }
        }
        // 三、更多字符的回文数据
        for (int len = 3; len <= s.length(); len++) {
            for (int i = 0; i < n - len + 1; i++) {
                if (s.charAt(i) == s.charAt(i + len - 1) && dp[i + 1][i + len - 2]) {
                    dp[i][i + len - 1] = true;
                }
            }
        }
        List<String> cur = new ArrayList<>();
        // 开始返回所有的可能结果
        backtracking(s, cur, 0, res);
        String[][] array = new String[res.size()][];
        for (int i = 0; i < res.size(); i++) {
            array[i] = res.get(i).toArray(new String[0]);
        }
        return array;
    }

    private void backtracking(String s, List<String> cur,int start,List<List<String>> res) {
        if (start == s.length()) {
            res.add(new ArrayList<>(cur));
            return;
        }
        for (int i = start; i < s.length(); i++) {
            if (dp[start][i]) {
                cur.add(s.substring(start, i + 1));
                backtracking(s, cur, i + 1, res);
                cur.remove(cur.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        SplitPalindromeString sp = new SplitPalindromeString();
        String[][] efes = sp.partition("efe");
        System.out.println(Arrays.deepToString(efes));
    }
}
