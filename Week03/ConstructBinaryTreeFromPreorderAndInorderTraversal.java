package Week03;

import Common.TreeNode;

import java.util.HashMap;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

    public static class Solution {

        private final HashMap<Integer, Integer> map = new HashMap<>();

        public TreeNode buildTree(int[] preorder, int[] inorder) {
            for (int i = 0; i < inorder.length; i++) {
                map.put(inorder[i], i);
            }
            return recursion(preorder, inorder, 0, preorder.length - 1, 0);
        }

        private TreeNode recursion(int[] preorder, int[] inorder, int preorderLeft, int preorderRight, int inorderLeft) {
            if (preorderLeft > preorderRight) {
                return null;
            }
            int preorderRoot = preorderLeft;
            int inorderRoot = map.get(preorder[preorderRoot]);
            TreeNode root = new TreeNode(preorder[preorderRoot]);
            int sizeLeftSubtree = inorderRoot - inorderLeft;
            root.left = recursion(preorder, inorder, preorderLeft + 1, preorderLeft + sizeLeftSubtree, inorderLeft);
            root.right = recursion(preorder, inorder, preorderLeft + sizeLeftSubtree + 1, preorderRight, inorderRoot + 1);
            return root;
        }
    }

}
