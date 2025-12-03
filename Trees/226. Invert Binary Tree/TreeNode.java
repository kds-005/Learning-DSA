import java.util.*;

// Definition for a binary tree node.
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
    private TreeNode[] swap(TreeNode left, TreeNode right) {
        TreeNode temp = left;
        left = right;
        right = temp;
        return new TreeNode[] {left, right};
    }

    private TreeNode dfs(TreeNode root) {
        if (root == null) return null;

        TreeNode[] temp = swap(root.left, root.right);
        root.left = temp[0];
        root.right = temp[1];

        dfs(root.left);
        dfs(root.right);
        return root;
    }
    public TreeNode invertTree(TreeNode root) {
        // N : no of nodes
        // Time Complexity: O(N)
        // Space Complexity: O(N) -> Stack Space
        // return dfs(root);


        // N : no of nodes
        // Time Complexity: O(N)
        // Space Complexity: O(N)
        // if (root == null) return root;
        // Deque<TreeNode> stack = new ArrayDeque<>();
        // stack.push(root);

        // while (!stack.isEmpty()) {
        //     TreeNode node = stack.pop();
    
        //     TreeNode[] temp = swap(node.left, node.right);
        //     node.left = temp[0]; node.right = temp[1];
            
        //     if (node.right != null) stack.push(node.right);
        //     if (node.left != null) stack.push(node.left);
        // }
        // return root;


        // N : no of nodes
        // Time Complexity: O(N)
        // Space Complexity: O(N)
        if (root == null) return root;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int n = q.size();
            for (int i = 0; i < n; i++) {
                TreeNode node = q.poll();
                
                TreeNode[] temp = swap(node.left, node.right);
                node.left = temp[0]; node.right = temp[1];

                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
            }
        }
        return root;
    }
}