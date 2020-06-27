package Week03;

import Common.TreeNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LowestCommonAncestorOfABinaryTree {

    public static class Solution {

        private Map<TreeNode, TreeNode> map = new HashMap<>();

        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if (p == q) {
                return p;
            }
            if (p == root || q == root) {
                return root;
            }
            dfs(root);
            Set<TreeNode> set = new HashSet<>();
            while (p != null) {
                set.add(p);
                p = map.get(p);
            }
            while (q != null) {
                if (set.contains(q)) {
                    return q;
                }
                q = map.get(q);
            }
            return null;
        }

        private void dfs(TreeNode root) {
            if (root.left != null) {
                map.put(root.left, root);
                dfs(root.left);
            }
            if (root.right != null) {
                map.put(root.right, root);
                dfs(root.right);
            }
        }
    }

}
