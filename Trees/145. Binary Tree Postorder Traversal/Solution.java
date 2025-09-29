import java.util.*;

/**
 * Definition for a binary tree node.
 **/
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
    private void dfs(TreeNode root, List<Integer> postOrder) {
        if (root == null)
            return;
        dfs(root.left, postOrder);
        dfs(root.right, postOrder);
        postOrder.add(root.val);
        return;
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        // N : no of Nodes
        // Time Complexity: O(2N)
        // Space Complexity: O(2N)
        // List<Integer> postOrder = new ArrayList<>();
        // Stack<TreeNode> stack = new Stack<>();
        // stack.push(root);
        // while (!stack.empty()){
        // TreeNode node = stack.pop();
        // if (node == null) continue;
        // postOrder.add(node.val);
        // stack.push(node.left);
        // stack.push(node.right);
        // }
        // return postOrder.reversed();

        // N : no of Nodes
        // Time Complexity: O(N)
        // Space Complexity: O(2N)
        List<Integer> postOrder = new ArrayList<>();
        dfs(root, postOrder);
        return postOrder;
    }
}