// Definition for a binary tree node.
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    private boolean isSameTree(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) return true;
        if (root == null || subRoot == null || root.val != subRoot.val) return false;

        boolean left = isSameTree(root.left, subRoot.left);
        boolean right = isSameTree(root.right, subRoot.right);

        return left && right;
    }

    private boolean dfs(TreeNode root, TreeNode subRoot) {
        if (root == null) return false;
        if (subRoot == null) return true;
        if (isSameTree(root, subRoot)) return true;

        boolean left = dfs(root.left, subRoot);
        boolean right = dfs(root.right, subRoot);
        return left || right;
    }
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        // N : no of node in root, M : no of nodes in subRoot
        // Time Complexity: O(N * M)
        // Space Complexity: O(N + M)
        return dfs(root, subRoot);
    }
}