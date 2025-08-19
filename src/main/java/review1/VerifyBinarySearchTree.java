package review1;

/**
 * 验证二叉搜索树
 */
public class VerifyBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        return verify(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean verify(TreeNode root, Long lower, Long upper) {
        if (root == null) return true;
        if (root.val <= lower || root.val >= upper) return false;
        return verify(root.left, lower, Integer.valueOf(root.val).longValue()) && verify(root.right,Integer.valueOf(root.val).longValue(), upper);
    }
}
