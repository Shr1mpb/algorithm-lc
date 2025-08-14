package review1;

/**
 * 二叉树的最近公共祖先
 * // TODO
 */
public class NearestCommonAncestorOfBinaryTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 向下寻找p/q 之后向上拼接
        if(root == null || root == p || root == q) return root;
        TreeNode l = lowestCommonAncestor(root.left , p , q);
        TreeNode r = lowestCommonAncestor(root.right , p , q);
        return l == null ? r : (r == null ? l : root);
    }
}
