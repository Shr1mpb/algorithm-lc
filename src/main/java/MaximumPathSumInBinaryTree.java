/**
 * 二叉树中的最大路径和
 * // TODO
 */
public class MaximumPathSumInBinaryTree {
    private int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        pathSum(root);
        return max;
    }

    public int pathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int lMax = pathSum(root.left);
        int rMax = pathSum(root.right);
        // 向上返回的 要么左 要么右 要么只有根 要么不包含(0)
        int curMax = Math.max(Math.max(lMax + root.val, rMax + root.val), root.val);
        // 每个点计算最大值作比较 要么包含左 要么包含右 要么左右都包含 要么只有根
        max = Math.max(Math.max(lMax + rMax + root.val, curMax), max);
        return Math.max(curMax, 0);
    }

}
