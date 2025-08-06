import java.util.LinkedList;

/**
 * 字符串解码
 * // TODO 2stack
 */
public class StringDecoding {
    public String decodeString(String s) {
        StringBuilder res = new StringBuilder();
        int multi = 0;
        LinkedList<Integer> stack_multi = new LinkedList<>();
        LinkedList<String> stack_res = new LinkedList<>();
        for (Character c : s.toCharArray()) {
            // 左括号 记录并重置重复次数、当前结果
            if (c == '[') {
                stack_multi.push(multi);
                stack_res.push(res.toString());
                multi = 0;
                res = new StringBuilder();
            }
            // 右括号 计算好当前括号 然后拼接之前的结果
            else if (c == ']') {
                StringBuilder tmp = new StringBuilder();
                int cur_multi = stack_multi.pop();
                for (int i = 0; i < cur_multi; i++) tmp.append(res);
                res = new StringBuilder(stack_res.pop() + tmp);
            }
            // 数字 计算当前的重复次数
            else if (c >= '0' && c <= '9') multi = multi * 10 + Integer.parseInt(c + "");
            else res.append(c);// 当前结果拼接
        }
        return res.toString();
    }
}
