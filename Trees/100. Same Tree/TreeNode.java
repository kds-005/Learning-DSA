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
    private boolean dfs(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        else if (q == null || p == null) return false;

        if (p.val != q.val) return false;

        boolean left = dfs(p.left, q.left);
        boolean right = dfs(p.right, q.right);
        return left && right;
    }
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // N : no of nodes in the tree
        // Time Complexity: O(N)
        // Space Complexity: O(N) -> Stack Space
        // return dfs(p, q);
        

        // N : no of nodes in the tree
        // Time Complexity: O(N)
        // Space Complexity: O(N) -> Stack Space
        // if (p == null && q == null) return true;
        // else if (p == null || q == null) return false;

        // Stack<TreeNode> stackP = new Stack<>();
        // Stack<TreeNode> stackQ = new Stack<>();
        // stackP.push(p); stackQ.push(q);

        // while(!stackP.isEmpty() && !stackQ.isEmpty()) {
        //     TreeNode nodeP = stackP.pop();
        //     TreeNode nodeQ = stackQ.pop();
            
        //     if (nodeP == null && nodeQ == null) continue;
        //     if (nodeP == null || nodeQ == null || nodeP.val != nodeQ.val) return false;

        //     System.out.println(nodeP.val);
        //     stackP.push(nodeP.left);
        //     stackP.push(nodeP.right);
        //     stackQ.push(nodeQ.left);
        //     stackQ.push(nodeQ.right);
        // }
        // return true;

        
        // N : no of nodes in the tree
        // Time Complexity: O(N)
        // Space Complexity: O(N)
        if (p == null && q == null) return true;
        else if (p == null || q == null) return false;

        Queue<TreeNode> queueP = new LinkedList<>(List.of(p));
        Queue<TreeNode> queueQ = new LinkedList<>(List.of(q));
        while (!queueP.isEmpty() && !queueQ.isEmpty()) {
            TreeNode nodeP = queueP.poll();
            TreeNode nodeQ = queueQ.poll();
            if (nodeP == null && nodeQ == null) continue;
            if (nodeP == null || nodeQ == null || (nodeP.val != nodeQ.val)) return false;

            queueP.offer(nodeP.left);
            queueP.offer(nodeP.right);
            queueQ.offer(nodeQ.left);
            queueQ.offer(nodeQ.right);
        }
        return true;
    }
}