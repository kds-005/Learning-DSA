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
    private int dfs(TreeNode root, int[] diameter) {
        if (root == null) return 0;

        int left = dfs(root.left, diameter);
        int right = dfs(root.right, diameter);
        diameter[0] = Math.max(diameter[0], (left + right));
        return 1 + Math.max(left, right);
    }
    public int diameterOfBinaryTree(TreeNode root) {
        // N : no of nodes in a tree
        // Time Complexity: O(N)
        // Space Complexity: O(N) -> Stack Space
        int[] diameter = new int[1];
        dfs(root, diameter);
        return diameter[0];
    }
}