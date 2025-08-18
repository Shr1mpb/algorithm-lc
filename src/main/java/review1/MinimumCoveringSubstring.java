package review1;

import java.util.HashSet;
import java.util.Set;

/**
 * 最小覆盖子串
 * 数组存储频率
 */
public class MinimumCoveringSubstring {
    public String minWindow(String s, String t) {
        // tt存储目标串的字符出现情况
        int[] tt = new int[128];
        for (int i = 0; i < t.length(); i++) {
            tt[t.charAt(i)]++;
        }
        // 判断解是否存在
        int[] temp = new int[128];
        for (int i = 0; i < s.length(); i++) {
            temp[s.charAt(i)]++;
        }
        if (!isOk(temp,tt)) {
            return "";
        }
        // 存储最优解的左右索引
        int[] ans = new int[]{0, s.length() - 1};
        // 滑动窗口逻辑
        int[] ss = new int[128];
        int l = 0, r = l + t.length() - 1;
        // 初始化第一个窗口left ~ （right -1）的字符
        for (int i = 0; i < r; i++) {
            ss[s.charAt(i)]++;
        }
        Set<Character> set = new HashSet<>();
        char[] charArray = t.toCharArray();
        for (char c : charArray) {
            set.add(c);
        }
        while (r < s.length()) {
            // 滑动添加新的元素
            ss[s.charAt(r)]++;
            // 如果当前状态ok 看看能不能缩小滑窗
            if(isOk(ss,tt)) {
                while (!set.contains(s.charAt(l))){// 不是必要的元素 当然可以直接滑动
                    l++;
                }
                // 是必要的元素 看看滑动后还能不能覆盖
                while (ss[s.charAt(l)] - 1 >= tt[s.charAt(l)]) {// 可以覆盖 缩小
                    ss[s.charAt(l)]--;
                    l++;
                }
                // 缩小操作完成 查看当前的滑窗长度 如果比最优要小 就记录
                if (r-l < ans[1] - ans[0]) {
                    ans[0] = l;
                    ans[1] = r;
                }
                r++; // 滑窗右端继续右移
            }else{// 当前状态不ok 继续添加新的元素
                r++;
            }

        }
        return s.substring(ans[0], ans[1] + 1);

    }

    private boolean isOk(int[] temp, int[] tt) {
        for (int i = 'A'; i <= 'Z'; i++) {
            if (temp[i] < tt[i]) {
                return false;
            }
        }
        for (int i = 'a'; i <= 'z'; i++) {
            if (temp[i] < tt[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
    }
}
