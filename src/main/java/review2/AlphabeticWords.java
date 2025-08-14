package review2;

import java.util.*;

/**
 * 找到字符串中所有字母异位词
 */
public class AlphabeticWords {
    public List<Integer> findAnagrams(String s, String p) {
        int slen = s.length();
        int plen = p.length();
        if (slen < plen) {
            return Collections.emptyList();
        }
        // 定长滑窗 使用数组来计算
        List<Integer> result = new ArrayList<Integer>();
        int[] pints = new int[26];
        int[] sints = new int[26];
        // 初始化p数组
        for (int i = 0; i < plen; i++) {
            pints[p.charAt(i) - 'a']++;
        }
        // 初始化第一个滑窗
        for (int i = 0; i < plen; i++) {
            sints[s.charAt(i) - 'a']++;
        }
        if (Arrays.equals(pints, sints)) {
            result.add(0);
        }
        // 开始滑动 记录右边界(包含)
        for (int right = plen; right < slen; right++) {
            int pre = right - plen;
            int left = pre + 1;
            sints[s.charAt(right) - 'a']++;
            sints[s.charAt(pre) - 'a']--;
            if (Arrays.equals(sints, pints)) {
                result.add(left);
            }
        }
        return result;
    }
}
