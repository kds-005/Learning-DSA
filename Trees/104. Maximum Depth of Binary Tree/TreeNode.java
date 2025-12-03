import java.util.*;
import java.lang.Math;

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
    private int dfs(TreeNode root) {
        if (root == null) return 0;

        int left = dfs(root.left);
        int right = dfs(root.right);

        return Math.max(left, right) + 1;
    }

    public int maxDepth(TreeNode root) {
        // N : no of nodes in the tree
        // Time Complexity: O(N)
        // Space Complexity: O(N) -> Stack Space
        // return dfs(root);


        // N : no of nodes in the tree
        // Time Complexity: O(N)
        // Space Complexity: O(N)
        // if (root == null) return 0;

        // Deque<Pair<TreeNode, Integer>> stack = new ArrayDeque<>();
        // stack.push(new Pair<>(root, 1));
        
        // int depth = 0;
        // while (!stack.isEmpty()) {
        //     Pair<TreeNode, Integer> pair = stack.pop();
        //     depth = Math.max(depth, pair.getValue());
            
        //     if (pair.getKey().right != null) stack.push(new Pair<>(pair.getKey().right, pair.getValue() + 1));
        //     if (pair.getKey().left != null) stack.push(new Pair<>(pair.getKey().left, pair.getValue() + 1));
        // }
        // return depth;


        // N : no of nodes in the tree
        // Time Complexity: O(N)
        // Space Complexity: O(N)
        if (root == null) return 0;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        
        int depth = 0;
        while (!q.isEmpty()) {
            depth++;
            
            int n = q.size();
            for (int i = 0; i < n; i++) {
                TreeNode node = q.poll();
                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
            }
        }
        return depth;
    }
}