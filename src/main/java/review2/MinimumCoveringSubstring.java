package review2;

import java.util.HashSet;
import java.util.Set;

/**
 * 最小覆盖子串
 * // TODO2: 重温
 */
public class MinimumCoveringSubstring {
    public String minWindow(String s, String t) {
        int[] sints = new int[128];
        int[] tints = new int[128];
        for (int i = 0; i < s.length(); i++) {
            sints[s.charAt(i)]++;
        }
        for (int i = 0; i < t.length(); i++) {
            tints[t.charAt(i)]++;
        }
        // 检查字符数是否足够 不足够返回空串
        if (!isCovered(sints, tints)) {
            return "";
        }

        // 滑动窗口逻辑
        Set<Character> set = new HashSet<>();
        for (char tChar : t.toCharArray()) {
            set.add(tChar);
        }
        int left = 0, right = left + t.length() - 1;
        // 初始化第一个滑窗
        int[] ss = new int[128];
        for (int i = left; i <= right; i++) {
            ss[s.charAt(i)]++;
        }
        // 记录最小滑窗的左右距离
        int[] ans = new int[]{0, s.length() - 1};
        // 如果第一个已覆盖 直接返回
        if (isCovered(ss, tints)) {
            return s.substring(left, right + 1);
        }
        // 开始滑动 [left,right]
        right++;
        while (right < s.length()) {
            // 滑动添加新的元素
            ss[s.charAt(right)]++;
            // 如果覆盖了 看看能不能缩小
            if (isCovered(ss, tints)) {
                // 看看滑动后还能不能覆盖
                // 可以覆盖 缩小
                while (ss[s.charAt(left)] - 1 >= tints[s.charAt(left)]) {
                    ss[s.charAt(left)]--;
                    left++;
                }
                // 更新滑窗最小值
                if (right - left < ans[1] - ans[0]) {
                    ans[0] = left;
                    ans[1] = right;
                }
                // 继续滑动
                right++;
            }else{
                // 还没覆盖 继续滑动
                right++;
            }
        }
        return s.substring(ans[0], ans[1] + 1);
    }

    private boolean isCovered(int[] sints, int[] tints) {
        for (int i = 0; i < sints.length; i++) {
            if (sints[i] < tints[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        MinimumCoveringSubstring mcs = new MinimumCoveringSubstring();
        System.out.println(mcs.minWindow("abc", "bc"));
    }
}
