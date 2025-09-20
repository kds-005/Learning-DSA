/**
 * Definition for a binary tree node.
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        his.right = right;
    }
}

class Solution {
    private boolean dfs(TreeNode root, int summ, int targetSum) {
        if (root == null)
            return false;
        if (root.left == null && root.right == null && summ + root.val == targetSum)
            return true;

        boolean left = dfs(root.left, summ + root.val, targetSum);
        boolean right = dfs(root.right, summ + root.val, targetSum);

        return (left || right);
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        return dfs(root, 0, targetSum);
    }
}