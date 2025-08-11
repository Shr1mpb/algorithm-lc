import java.util.Deque;
import java.util.LinkedList;

/**
 * 最长有效括号
 * // TODO
 */
public class LongestValidParenthesis {
    /*
    保持栈底始终是最后一个没有被匹配的右括号的下标
    对于遇到的每个 ‘(’ ，我们将它的下标放入栈中
    对于遇到的每个 ‘)’ ，我们先弹出栈顶元素表示匹配了当前右括号：
    如果栈为空，说明当前的右括号为没有被匹配的右括号，我们将其下标放入栈中来更新我们之前提到的「最后一个没有被匹配的右括号的下标」
    如果栈不为空，当前右括号的下标减去栈顶元素即为「以该右括号为结尾的最长有效括号的长度」
     */
    public int longestValidParentheses(String s) {
        if (s.length() < 2) return 0;
        char[] charArray = s.toCharArray();
        Deque<Integer> left = new LinkedList<>();
        left.offer(-1);
        int ret = 0;
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == '(') {
                left.push(i);
            }else{
                left.pop();
                if (left.isEmpty()) {
                    left.push(i);
                }else{
                    ret = Math.max(ret, i - left.peek());
                }
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        LongestValidParenthesis l = new LongestValidParenthesis();
        System.out.println(l.longestValidParentheses(")))()"));
    }
}
