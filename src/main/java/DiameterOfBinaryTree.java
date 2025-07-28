/**
 * 二叉树的直径
 * // TODO
 */
public class DiameterOfBinaryTree {
    int ans;
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        ans = 1;
        depth(root);
        return ans - 1;
    }
    public int depth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int L = depth(node.left);
        int R = depth(node.right);
        ans = Math.max(ans, L+R+1);// 更新ans
        return Math.max(L, R) + 1;
    }
}
