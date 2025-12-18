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
    private int dfs(TreeNode root, int val) {
        if (root == null) return 0;

        int goodNode = 0;
        if (root.val >= val) goodNode = 1;

        int left = dfs(root.left, Math.max(root.val, val));
        int right = dfs(root.right, Math.max(root.val, val));

        return (goodNode + left + right);
    }
    public int goodNodes(TreeNode root) {
        // N : no of nodes in root
        // Time Complexity: O(N)
        // Space Complexity: O(N) -> Stack Space
        return dfs(root, root.val - 1);
    }
}