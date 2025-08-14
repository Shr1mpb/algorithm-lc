package review2;

import review1.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的右视图
 */
public class RightViewOfBinaryTree {
    // 递归：先右 后左 记录层数
    List<Integer> ans = new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
        dfs(root, 0);
        return ans;
    }

    private void dfs(TreeNode root, int level) {
        if (root == null) return;
        if (level == ans.size()) ans.add(root.val);
        dfs(root.right, level + 1);
        dfs(root.left, level + 1);
    }
}
