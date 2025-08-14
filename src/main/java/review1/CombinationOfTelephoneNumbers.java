package review1;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 电话号码的字母组合
 */
public class CombinationOfTelephoneNumbers {
    static final Map<Character, String> map = Map.of(
            '2', "abc", '3', "def", '4', "ghi", '5', "jkl",
            '6', "mno", '7', "pqrs", '8', "tuv", '9', "wxyz"
    );
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.isEmpty()) {
            return new ArrayList<>();
        }
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        char[] input = digits.toCharArray();
        backtracking(res, sb, input, 0);
        return res;
    }
    // index , index = i+1
    private void backtracking(List<String> res, StringBuilder sb, char[] input, int index) {
        if (input.length == sb.length()) {
            res.add(sb.toString());
            return;
        }

        for (int i = index; i < input.length; i++) {
            // 拿到当前输入 并拿到当前输入对应的字符串 开始回溯:递归到下一个输入
            char c = input[i];
            String s = map.get(c);
            char[] charArray = s.toCharArray();
            for (int j = 0; j < charArray.length; j++) {
                sb.append(charArray[j]);
                backtracking(res, sb, input, i + 1);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}
