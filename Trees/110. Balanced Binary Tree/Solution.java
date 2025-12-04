import java.lang.Math;

//Definition for a binary tree node.
class TreeNode {
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

public class Solution {
    Boolean isBalance = true;
    private int dfs(TreeNode root) {
        if (root == null) return 0;

        int left = dfs(root.left);
        int right = dfs(root.right);

        if (Math.abs(left - right) > 1) isBalance = false;

        return 1 + Math.max(left, right);
    }
    public boolean isBalanced(TreeNode root) {
        // N : no of nodes in a tree
        // Time Complexity: O(N)
        // Space Complexity: O(N) -> Stack Space
        dfs(root);
        return isBalance;
    }
}