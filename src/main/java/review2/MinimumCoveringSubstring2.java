package review2;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 最小覆盖子串 优化写法
 */
public class MinimumCoveringSubstring2 {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }
        // 首先创建一个哈希表 t中存在的让哈希表++ s中存在的--
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) - 1);
        }
        // 遍历哈希表 查看>0的元素的个数 就是没有覆盖的个数 记录下来
        AtomicInteger atomicDiff = new AtomicInteger(0);
        map.forEach((character, integer) -> {
            if (integer > 0) {
                atomicDiff.getAndIncrement();
            }
        });
        int diff = atomicDiff.intValue();
        // 如果diff == 0 说明已经覆盖 返回
        if (diff == 0) {
            return s.substring(0, t.length());
        }
        // 如果diff没有==0 说明没有覆盖 移动滑窗
        int left = 0;
        int right = left + t.length();
        int[] ans = new int[2];
        ans[1] = s.length();
        while (right < s.length()) {
            // 滑窗右边界右移 map中对应位置--
            map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0) - 1);
            // 又覆盖到了一个元素 diff--
            if (map.get(s.charAt(right)) == 0) {
                diff--;
            }
            if (diff != 0) {
                right++;
                continue;
            }
            // 全部覆盖 开始缩小左边界
            while (diff == 0) {
                // 出滑窗 + 1
                map.put(s.charAt(left), map.get(s.charAt(left)) + 1);
                if (map.get(s.charAt(left)) > 0) {
                    // >0 说明有未覆盖的出现
                    diff++;
                }
                left++;
            }
            // 记录当前答案的长度 l和r都是包含边界的
            int l = left - 1;
            int r = right;
            if (r - l < ans[1] - ans[0]) {
                ans[0] = l;
                ans[1] = r;
            }
            right++;
        }
        return (ans[1] == (s.length())) ?  "" : s.substring(ans[0], ans[1] + 1);
    }

}
