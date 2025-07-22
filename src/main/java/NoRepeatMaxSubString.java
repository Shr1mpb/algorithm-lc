import java.util.HashMap;
import java.util.HashSet;

/**
 * 无重复字符的最长子串
 */
public class NoRepeatMaxSubString {
    // 滑动窗口
    // TODO
    public int lengthOfLongestSubstring(String s) {
        // 使用 HashMap 记录字符及其最新出现的索引
        HashMap<Character, Integer> map = new HashMap<>();
        char[] charArray = s.toCharArray();
        int left = 0;  // 滑动窗口左边界
        int right = 0; // 滑动窗口右边界
        int maxLength = 0; // 记录最大子串长度

        while (right < charArray.length) {
            char currentChar = charArray[right];

            // 如果当前字符已存在于窗口中，更新左边界
            if (map.containsKey(currentChar)) {
                // 避免左边界回退
                left = Math.max(left, map.get(currentChar) + 1);
            }

            // 更新当前字符的最新索引
            map.put(currentChar, right);

            // 计算当前窗口大小并更新最大值
            maxLength = Math.max(maxLength, right - left + 1);

            // 右边界右移
            right++;
        }

        return maxLength;
    }
}
