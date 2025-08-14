package review1;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 单词拆分
 * // TODO
 */
public class WordSplitting {
    public boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        Set<String> set = new HashSet<>(wordDict);
        boolean[] dp = new boolean[len+1];
        dp[0] = true;
        for(int i = 1; i <= len; i++) {
            // 对每个位置 从前遍历
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
