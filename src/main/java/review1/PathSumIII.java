package review1;

import java.util.HashMap;
import java.util.Map;

/**
 * 路径总和 III
 * // TODO
 */
public class PathSumIII {
    Map<Long,Integer> map = new HashMap<>();
    public int pathSum(TreeNode root, long targetSum) {
        if(root == null) return 0;
        map.put(0L, 1);// 0的路径有一条
        int sum = 0,ret = 0;
        return seek(root, sum, targetSum);
    }

    private int seek(TreeNode root, long sum, long targetSum) {
        if (root == null) return 0;
        sum += root.val;
        // 查看前缀是否有满足
        int ret = map.getOrDefault(sum - targetSum, 0);
        // 添加进入前缀
        map.put(sum, map.getOrDefault(sum, 0) + 1);
        // 递归左右子
        ret += seek(root.left, sum, targetSum);
        ret += seek(root.right, sum, targetSum);
        // 回溯当前sum 避免影响其他分支
        map.put(sum, map.get(sum) - 1);
        return ret;
    }
}
