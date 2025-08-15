package review2;

import review1.TreeNode;

/**
 * 二叉树的最近公共祖先
 * // TODO2: 需要再次复习
 */
public class NearestCommonAncestorOfBinaryTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 是自己就向上返回
        if (root == null || root == p || root == q) {
            return root;
        }
        // dfs 分别搜索左右 都不为空就是根节点 向上返回
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            return root;
        }
        // 有一个为空 就是另一个节点
        return left != null ? left : right;
    }
}
