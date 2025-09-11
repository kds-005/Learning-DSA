/**
 * Definition for a binary tree node.
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    private boolean dfs(TreeNode root, int target) {
        if (root == null) {
            return false;
        }

        if (dfs(root.left, target))
            root.left = null;
        if (dfs(root.right, target))
            root.right = null;

        return (root.left == null && root.right == null && root.val == target);
    }

    public TreeNode removeLeafNodes(TreeNode root, int target) {
        // Time Complexity: O(N)
        // Space Complexity: O(N)
        if (dfs(root, target))
            return null;
        return root;
    }
}