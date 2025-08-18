package review2;

import review1.TreeNode;

/**
 * 二叉树中的最大路径和
 */
public class MaximumPathSumInBinaryTree {
    int ans = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return ans;
    }
    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        ans = Math.max(ans, root.val + Math.max(left, 0) + Math.max(right, 0));
        // 向上返回最大的路径和 要么带左 要么带右 这里不处理返回负数的情况 因为返回负数上层会处理
        return root.val + Math.max(Math.max(left, right), 0);
    }

}
