package review2;

import java.util.HashSet;

/**
 * 无重复字符的最长子串
 * 右边只进 控制左边
 */
public class NoRepeatMaxSubString {
    // 滑动窗口
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) return 0;
        int n = s.length();
        HashSet<Character> set = new HashSet<>();
        int left = 0, right = 0;
        int ans = 0;
        for (; right < n; right++) {
            if (set.contains(s.charAt(right))) {
                // 包含：更新最大值 并缩小左边界
                ans = Math.max(ans, right - left);
                while (s.charAt(left) != s.charAt(right)) {
                    set.remove(s.charAt(left));
                    left++;
                }
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
        }
        return Math.max(ans, right - left);
    }

    public static void main(String[] args) {
        NoRepeatMaxSubString n = new NoRepeatMaxSubString();
        System.out.println(n.lengthOfLongestSubstring("abcabcbb"));
    }
}
