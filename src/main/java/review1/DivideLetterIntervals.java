package review1;

import java.util.ArrayList;
import java.util.List;

/**
 * 划分字母区间
 * // TODO 记录最后出现的字母的下标 尽可能多的包含片段
 */
public class DivideLetterIntervals {
    public List<Integer> partitionLabels(String s) {
        int[] last = new int[26];
        int length = s.length();
        // 记录所有字母最后出现的下标
        for (int i = 0; i < length; i++) {
            last[s.charAt(i) - 'a'] = i;
        }
        List<Integer> partition = new ArrayList<Integer>();
        int start = 0, end = 0;
        // 每次记录最后索引的位置 然后不断更新 到最后索引的位置时说明这个片段已经完毕 加入长度
        for (int i = 0; i < length; i++) {
            end = Math.max(end, last[s.charAt(i) - 'a']);
            if (i == end) {
                partition.add(end - start + 1);
                start = end + 1;
            }
        }
        return partition;
    }
}
