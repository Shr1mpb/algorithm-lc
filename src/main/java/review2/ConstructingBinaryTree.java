package review2;

import review1.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 从前序与中序遍历序列构造二叉树
 * // TODO2 重温递归出口
 */
public class ConstructingBinaryTree {
    /**
     * 存储中序遍历的 节点 - 索引
     */
    Map<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // 记录中序遍历的节点-索引
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        // 开始build 之后返回
        return build(0, preorder.length - 1, 0, inorder.length - 1, preorder, inorder);

    }

    public TreeNode build(int preStart, int preEnd, int inStart, int inEnd, int[] preorder, int[] inorder) {
        if (preStart > preEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        int rootIndex = map.get(preorder[preStart]);
        int leftCount = rootIndex - inStart;
        int rightCount = inEnd - rootIndex;
        // [preStart+1 , preStart + leftCount] 即前面的元素之后前序遍历使用的范围
        root.left = build(preStart + 1, preStart + leftCount, inStart, rootIndex - 1, preorder, inorder);
        // [preStart+leftCount+1 , preStart+leftCount + rightCount] 即后面的元素之后前序遍历使用的范围
        root.right = build(preStart + leftCount + 1, preEnd, rootIndex + 1, inEnd, preorder, inorder);
        return root;
    }
}
