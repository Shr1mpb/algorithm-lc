package review1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 找到字符串中所有字母异位词
 */
public class AlphabeticWords {
    public List<Integer> findAnagrams(String s, String p) {
        // 滑动窗口 以p长度为窗口进行滑动 记录左边的索引
        char[] charArray = p.toCharArray();
        Arrays.sort(charArray);
        String tar = new String(charArray);
        int len = p.length();
        List<Integer> ans = new ArrayList<Integer>();
        int l = 0;
        while (l + len <= s.length()) {
            String str = s.substring(l, l + len);
            char[] charArray1 = str.toCharArray();
            Arrays.sort(charArray1);
            String cur = new String(charArray1);
            if (cur.equals(tar)){
                ans.add(l);
            }
            l++;
        }
        return ans;
    }

    // 优化方法 用数组存储并判断
    public List<Integer> findAnagrams0(String s, String p) {
        int sLen = s.length(), pLen = p.length();

        if (sLen < pLen) {
            return new ArrayList<Integer>();
        }

        List<Integer> ans = new ArrayList<Integer>();
        int[] sCount = new int[26];
        int[] pCount = new int[26];
        for (int i = 0; i < pLen; ++i) {
            ++sCount[s.charAt(i) - 'a'];
            ++pCount[p.charAt(i) - 'a'];
        }

        if (Arrays.equals(sCount, pCount)) {
            ans.add(0);
        }

        for (int i = 0; i < sLen - pLen; ++i) {
            --sCount[s.charAt(i) - 'a'];
            ++sCount[s.charAt(i + pLen) - 'a'];

            if (Arrays.equals(sCount, pCount)) {
                ans.add(i + 1);
            }
        }

        return ans;
    }
}
