package review2;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 单词拆分
 * // TODO2: 重温
 */
public class WordSplitting {
    public boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        Set<String> set = new HashSet<>(wordDict);
        boolean[] dp = new boolean[len + 1];
        dp[0] = true;
        // 每次确定dp[i]能否拼接的到
        for(int i = 1; i <= len; i++) {
            for(int j = 0; j < i; j++) {
                if(dp[j] && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[len];
    }
}
