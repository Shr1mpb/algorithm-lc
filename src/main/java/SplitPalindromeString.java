import java.util.ArrayList;
import java.util.List;

/**
 * 分割回文串
 * // TODO 动态规划部分注意
 */
public class SplitPalindromeString {
    boolean[][] f;
    String s;
    public List<List<String>> partition(String s) {
        int n = s.length();
        List<List<String>> res = new ArrayList<>();
        // 动态规划设置回文情况
        f = new boolean[n][n];
        // 初始化动态规划数组
        for (int i = 0; i < n; i++) {
            f[i][i] = true;
        }
        this.s = s;
        // 初始化两个字符情况
        for (int i = 0; i < n - 1; i++) {
            f[i][i + 1] = s.charAt(i) == s.charAt(i + 1);
        }
        // 动态规划剩余字符的情况
        for (int i = 3; i <= n; i++) {// 长度
            for (int j = 0; j + i - 1 < n; j++) {
                int cur = j + i - 1;
                f[j][cur] = s.charAt(j) == s.charAt(cur) && f[j + 1][cur - 1];
            }
        }
        List<String> cur = new ArrayList<>(n);
        // 开始回溯 查询所有可能的回文串情况
        dfs(res, cur, 0, s.length());
        return res;
    }

    private void dfs(List<List<String>> res, List<String> cur, int start, int n) {
        if (n == start) {
            res.add(new ArrayList<>(cur));
            return;
        }
        for (int i = start; i < n; i++) {
            if (f[start][i]) {
                cur.add(s.substring(start, i + 1));
                dfs(res, cur, i + 1, n);
                cur.remove(cur.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        SplitPalindromeString sp = new SplitPalindromeString();
        System.out.println(sp.partition("efe"));
    }
}
