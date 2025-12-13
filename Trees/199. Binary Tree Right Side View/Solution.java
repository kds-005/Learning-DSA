
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
    private void dfs(TreeNode root, int level, List<Integer> rightView) {
        if (root == null) return;

        if (level == rightView.size()) rightView.add(root.val);
        dfs(root.right, level + 1, rightView);
        dfs(root.left, level + 1, rightView);

        return;
    }
    public List<Integer> rightSideView(TreeNode root) {
        // N : no of nodes in root
        // Time Complexity: O(N)
        // Space Complexity: O(N) -> Stack Space
        // List<Integer> rightView = new ArrayList<>();
        // dfs(root, 0, rightView);
        // return rightView;

        // N : no of nodes in root
        // Time Complexity: O(N)
        // Space Complexity: O(N)
        if (root == null) return new ArrayList<>();

        List<Integer> rightView = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                TreeNode node = queue.poll();
                if (i == n - 1) rightView.add(node.val);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
        }
        return rightView;
    }
}