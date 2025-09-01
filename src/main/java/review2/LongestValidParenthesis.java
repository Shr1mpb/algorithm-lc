package review2;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 最长有效括号
 * // TODO2: 重温 -1与右括号垫底 右括号进来弹出左括号 空加入 非空更新答案
 */
public class LongestValidParenthesis {
    public int longestValidParentheses(String s) {
        if (s.length() < 2) {
            return 0;
        }
        // 栈：放入左括号 遇到右括号就弹出栈中元素 长度为当前索引 - 弹出的括号的索引
        char[] charArray = s.toCharArray();
        int ans = 0;
        Deque<Integer> stack = new LinkedList<>();
        stack.push(-1);
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == '(') {
                stack.push(i);
            }else {
                // 保持栈底始终有一个右括号
                // 遇到右括号 直接弹出一个数 如果弹空了 说明最后一个右括号被弹出 加入
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                }else {
                    ans = Math.max(ans, i - stack.peek());
                }
            }
        }
        return ans;
    }
}
