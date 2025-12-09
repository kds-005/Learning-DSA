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
    public TreeNode deleteNode(TreeNode root, int key) {
        // N : no of node in the Tree
        // Time Complexity: O(N)
        // Space Complexity: O(N) -> Stack Space
        if (root == null) return root;

        if (root.val > key) root.left = deleteNode(root.left, key);
        else if (root.val < key) root.right = deleteNode(root.right, key);
        else {
            if (root.left == null) return root.right;
            else if (root.right == null) return root.left;
            else {
                TreeNode curr = root.right;
                while (curr.left != null) curr = curr.left;
                root.val = curr.val;
                root.right = deleteNode(root.right, root.val);
            }
        }
        return root;
    }
}