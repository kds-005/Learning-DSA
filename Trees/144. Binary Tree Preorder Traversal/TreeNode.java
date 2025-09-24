import java.util.*;

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
        this.right = right;
    }
}

class Solution {
    private void dfs(TreeNode root, List<Integer> preOrder) {
        if (root == null)
            return;
        preOrder.add(root.val);
        dfs(root.left, preOrder);
        dfs(root.right, preOrder);
        return;
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        // N : Total no of Nodes
        // Time Complexity: O(N)
        // Space Complexity: O(2N)
        // List<Integer> preOrder = new ArrayList<>();
        // dfs(root, preOrder);
        // return preOrder;

        // N : Total no of Nodes
        // Time Complexity: O(N)
        // Space Complexity: O(N)
        List<Integer> preOrder = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()) {
            TreeNode node = stack.pop();
            if (node == null)
                continue;
            preOrder.add(node.val);
            stack.push(node.right);
            stack.push(node.left);
        }
        return preOrder;
    }
}