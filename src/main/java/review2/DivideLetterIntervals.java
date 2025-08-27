package review2;

import java.util.ArrayList;
import java.util.List;

/**
 * 划分字母区间
 * // TODO2: 记录最后索引位置 碰壁加上 与跳跃游戏II类似
 */
public class DivideLetterIntervals {
    /**
     * 尽可能多的片段
     */
    public List<Integer> partitionLabels(String s) {
        List<Integer> result = new ArrayList<>();
        if (s == null || s.isEmpty()) {
            return result;
        }else if (s.length() == 1) {
            result.add(1);
            return result;
        }
        int[] last = new int[26];
        int length = s.length();
        // 记录所有字母最后出现的位置
        for (int i = 0; i < length; i++) {
            last[s.charAt(i) - 'a'] = i;
        }
        int start = 0, end = 0;
        // 每次记录最后索引的位置 然后不断更新 到最后索引的位置时说明这个片段已经完毕 加入长度
        for (int i = 0; i < length; i++) {
            end = Math.max(end, last[s.charAt(i) - 'a']);
            if (i == end) {
                result.add(end - start + 1);
                start = end + 1;
            }
        }
        return result;
    }
}
