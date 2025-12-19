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
    private int kthVal;
    private int kth;
    private void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.left);
        kth--;
        if (kth == 0) kthVal = root.val;
        dfs(root.right);
        return;
    }
    public int kthSmallest(TreeNode root, int k) {
        // N : no of node in root
        // Time Complexity: O(N)
        // Space Compleixty: O(N) -> Stack Space
        kth = k;
        dfs(root);
        return kthVal;
    }
}