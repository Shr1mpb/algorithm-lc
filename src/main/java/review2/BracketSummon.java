package review2;

import java.util.ArrayList;
import java.util.List;

/**
 * 括号生成
 * // TODO2 重温
 */
public class BracketSummon {
    List<String> result = new ArrayList<String>();
    public List<String> generateParenthesis(int n) {
        StringBuilder sb = new StringBuilder();
        dfs(0, 0, n, sb);
        return result;
    }

    private void dfs(int open, int close, int n, StringBuilder sb) {
        if (sb.length() == n << 1) {
            result.add(sb.toString());
            return;
        }
        if (open < n) {
            sb.append('(');
            dfs(open + 1, close, n, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (close < open) {
            sb.append(')');
            dfs(open, close + 1, n, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
