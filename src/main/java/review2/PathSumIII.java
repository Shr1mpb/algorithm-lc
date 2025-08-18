package review2;

import review1.TreeNode;

import java.util.HashMap;

/**
 * 路径总和 III
 */
public class PathSumIII {
    /**
     * 存储 和 - 个数 的 前缀和个数键值对
     */
    HashMap<Long, Integer> map = new HashMap<>();
    int ans = 0;
    public int pathSum(TreeNode root, int targetSum) {
        map.put(0L, 1);
        dfs(root, 0, targetSum);
        return ans;
    }

    private void dfs(TreeNode root, long sum, int targetSum) {
        if (root == null) {
            return;
        }
        sum += root.val;
        ans += map.getOrDefault(sum - targetSum, 0);
        map.put(sum, map.getOrDefault(sum, 0) + 1);
        dfs(root.left, sum, targetSum);
        dfs(root.right, sum, targetSum);
        // 回溯，恢复前缀和计数
        map.put(sum, map.get(sum) - 1);
    }
}
