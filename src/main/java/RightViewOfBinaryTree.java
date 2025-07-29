import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 二叉树的右视图
 * // TODO
 */
public class RightViewOfBinaryTree {
    // 层序遍历后找到最右边的元素
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            TreeNode node = null;
            for (int i = 0; i < size; i++) {
                node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            res.add(node.val);
        }
        return res;
    }
    // 递归
    // 先右 后左 记录层数
    private List<Integer> result = new ArrayList<>();
    public List<Integer> rightSideView0(TreeNode root) {
        rightSideViewHelper(root, 0);
        return result;
    }
    private void rightSideViewHelper(TreeNode root, int depth) {
        if (root == null) {
            return;
        }
        if (depth == result.size()) {
            result.add(root.val);
        }
        rightSideViewHelper(root.right, depth + 1);
        rightSideViewHelper(root.left, depth + 1);
    }
}
