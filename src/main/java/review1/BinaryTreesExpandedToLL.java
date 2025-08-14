package review1;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树展开为链表
 */
public class BinaryTreesExpandedToLL {
    Queue<TreeNode> q = new LinkedList<TreeNode>();
    public void flatten(TreeNode root) {
        inorder(root);
        // 遍历队列 设置指针
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            node.right = q.peek();
            node.left = null;
        }
    }
    private void inorder(TreeNode root) {
        if (root == null) return;
        q.offer(root);
        inorder(root.left);
        inorder(root.right);
    }
}
