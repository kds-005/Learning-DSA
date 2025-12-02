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
    private void dfs(TreeNode root, List<Integer> inorder) {
        if (root == null) return;

        dfs(root.left, inorder);
        inorder.add(root.val);
        dfs(root.right, inorder);
        return;
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        // N : no of nodes in tree
        // Time Complexity: O(N)
        // Space Complexity: O(N)
        // List<Integer> inorder = new ArrayList<>();
        // dfs(root, inorder);
        // return inorder;


        // N : no of nodes in tree
        // Time Complexity: O(N)
        // Space Complexity: O(N) -> with Output Array
        List<Integer> inorder = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            inorder.add(root.val);
            root = root.right;
        }
        return inorder;
    }
}