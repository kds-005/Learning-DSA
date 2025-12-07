import java.util.*;

//Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}


public class Solution {
    private TreeNode dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        
        if (root.val < p.val && root.val < q.val) {
            return dfs(root.right, p, q);
        } else if (root.val > p.val && root.val > q.val) {
            return dfs(root.left, p, q);
        } else {
            return root;
        }
    }
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // N : no of nodes in the Tree
        // Time Complexity: O(N)
        // Space Complexity: O(N) -> Stack Space
        // return dfs(root, p, q);


        // N : no of nodes in the Tree
        // Time Complexity: O(N)
        // Space Complexity: O(N)
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.val < p.val && node.val < q.val) {
                stack.push(node.right);
            } else if (node.val > p.val && node.val > q.val) {
                stack.push(node.left);
            } else {
                return node;
            }
        }
        return null;
    }
}