package review1;

import java.util.ArrayList;
import java.util.List;

/**
 * 括号生成
 * // TODO open、close
 */
public class BracketSummon {
    // 括号生成  双回溯 决策顺序：算法总是先尝试添加左括号（如果允许），再尝试添加右括号（如果允许）。
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backtracking(res, new StringBuilder(), 0, 0, n);
        return res;
    }
    private void backtracking(List<String> res, StringBuilder sb, int open, int close, int max) {
        if (sb.length() == max * 2) {// 够了 加入结果
            res.add(sb.toString());
            return;
        }
        if (open < max) {
            sb.append('(');
            backtracking(res, sb, open + 1, close, max);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (close < open) {
            sb.append(')');
            backtracking(res, sb, open, close + 1, max);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
