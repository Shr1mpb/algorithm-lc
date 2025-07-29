import java.util.ArrayList;
import java.util.List;

/**
 * 二叉搜索树中第 K 小的元素
 */
public class TheKSmallestElementInBinarySearchTree {
    // 即中序遍历中第k个元素
    public int kthSmallest(TreeNode root, int k) {
        List<TreeNode> list = new ArrayList<TreeNode>();
        inorder(root, list);
        return list.get(k - 1).val;
    }
    private void inorder(TreeNode root, List<TreeNode> list) {
        if (root == null) return;
        inorder(root.left, list);
        list.add(root);
        inorder(root.right, list);
    }
}
