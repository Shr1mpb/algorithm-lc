package review2;

import review1.TreeNode;

/**
 * 二叉树的直径
 */
public class BiameterOfBinaryTree {
    int ans;
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        dfs(root);
        return ans - 1;// 长度 -1
    }
    public int dfs(TreeNode root) {
        if (root == null) return 0;
        int left = dfs(root.left);
        int right = dfs(root.right);
        int temp = left + right + 1; // 最长的路径一定是带着当前的根的 + 1
        if (ans < temp) {
            ans = temp;
        }
        return Math.max(left, right) + 1;// 向上返回的时候，只能返回一边的
    }
}
