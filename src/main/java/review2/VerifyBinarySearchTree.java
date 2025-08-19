package review2;

import review1.TreeNode;

/**
 * 验证二叉搜索树
 */
public class VerifyBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        return validateBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean validateBST(TreeNode root, long min, long max) {
        if (root == null) {
            return true;
        }
        if (root.val <= min || root.val >= max) {
            return false;
        }
        return validateBST(root.left, min, root.val) && validateBST(root.right, root.val, max);
    }

    public static void main(String[] args) {
        VerifyBinarySearchTree tree = new VerifyBinarySearchTree();
        TreeNode root = new TreeNode(2147483647);
        System.out.println(tree.isValidBST(root));
    }


}
