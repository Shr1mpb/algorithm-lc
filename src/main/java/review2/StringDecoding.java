package review2;

import java.util.LinkedList;

/**
 *  字符串解码
 *  // 重温
 */
public class StringDecoding {
    public String decodeString(String s) {
        StringBuilder res = new StringBuilder();
        int multi = 0;
        LinkedList<Integer> stack_multi = new LinkedList<>();
        LinkedList<String> stack_res = new LinkedList<>();
        for (char c : s.toCharArray()) {
            if (c == '[') {
                stack_multi.push(multi);
                stack_res.push(res.toString());
                multi = 0;
                res = new StringBuilder();
            } else if (c == ']') {
                StringBuilder temp = new StringBuilder();
                int cur_multi = stack_multi.pop();
                for (int i = 0; i < cur_multi; i++) {
                    temp.append(res);
                }
                // 和上一层的结果拼接
                res = new StringBuilder(stack_res.pop() + temp.toString());
            }else if (c >= '0' && c <= '9') {
                multi = multi * 10 + Integer.parseInt(c + "");
            }else{
                res.append(c);
            }
        }
        return res.toString();
    }

}
