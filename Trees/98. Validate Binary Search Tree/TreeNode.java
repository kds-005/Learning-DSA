import java.util.*;

//Definition for a binary tree node.
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
    // private long prev = Long.MIN_VALUE;
    // private Boolean dfs(TreeNode root) {
    //     if (root == null) return true;

    //     if (!dfs(root.left)) return false;
        
    //     if (prev >= root.val) return false;
    //     prev = root.val;

    //     if (!dfs(root.right)) return false;
    //     return true;
    // }

    private Boolean dfs(TreeNode root, long low, long high) {
        if (root == null) return true;

        if (!(low < root.val && root.val < high)) return false;

        Boolean left = dfs(root.left, low, root.val);
        Boolean right = dfs(root.right, root.val, high);
        return left && right;
    }

    public boolean isValidBST(TreeNode root) {
        // N : no of nodes in root
        // Time Complexity: O(N)
        // Space Complexity: O(N) -> Stack Space
        // return dfs(root);


        // N : no of nodes in root
        // Time Complexity: O(N)
        // Space Complexity: O(N) -> Stack Space
        return dfs(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
}