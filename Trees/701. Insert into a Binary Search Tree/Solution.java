import java.util.*;

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
    private void dfs(TreeNode root, int val) {
        if (root == null) return;

        if (root.val < val && root.right == null) root.right = new TreeNode(val);
        else if (root.val > val && root.left == null) root.left = new TreeNode(val);
        else if (root.val < val) dfs(root.right, val);
        else if (root.val > val) dfs(root.left, val);
        return; 
    }
    public TreeNode insertIntoBST(TreeNode root, int val) {
        // N : no of node in the Tree
        // Time Complexity: O(N)
        // Space Complexity: O(N) -> Stack Space
        // if (root == null) return new TreeNode(val);
        // dfs(root, val);
        // return root;


        // N : no of node in the Tree
        // Time Complexity: O(N)
        // Space Complexity: O(N)
        if (root == null) return new TreeNode(val);
        
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.val < val && node.right == null) {
                node.right = new TreeNode(val);
                return root;
            } else if (node.val > val && node.left == null) {
                node.left = new TreeNode(val);
                return root;
            } else if (node.val < val) stack.push(node.right);
            else if (node.val > val) stack.push(node.left);
        }
        return root;
    }
}