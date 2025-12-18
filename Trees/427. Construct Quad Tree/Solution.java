// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    
    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
}


class Solution {
    private Boolean isSame(int n, int r, int c, int[][] grid) {
        for (int i = 0; i < n; i++) 
            for (int j = 0; j < n; j++) 
                if (grid[r][c] != grid[r + i][c + j]) return false;
        return true;
    }

    private Node dfs(int n, int r, int c, int[][] grid) {
        if (isSame(n, r, c, grid)) return new Node(grid[r][c] == 1, true);

        n /= 2;
        Node topLeft = dfs(n, r, c, grid);
        Node topRight = dfs(n, r, c + n, grid);
        Node bottomLeft = dfs(n, r + n, c, grid);
        Node bottomRight = dfs(n, r + n, c + n, grid);
        
        return new Node(false, false, topLeft, topRight, bottomLeft, bottomRight);
    }

    public Node construct(int[][] grid) {
        // N : no of rows and columns
        // Time Complexity: O(N * N * logN)
        // Space Complexity: O(logN)
        int n = grid.length;
        return dfs(n, 0, 0, grid);
    }
}