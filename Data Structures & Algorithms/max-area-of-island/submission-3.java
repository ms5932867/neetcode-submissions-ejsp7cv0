class Solution {
    
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    int curArea = dfs(grid, i, j);
                    maxArea = Math.max(maxArea, curArea);
                }
            }
        }
        return maxArea;
    }
    int[] moveI = new int[]{1, -1, 0, 0};
    int[] moveJ = new int[]{0, 0, 1, -1};
    private int dfs(int[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] != 1) {
            return 0;
        }
        grid[i][j] = -1;
        int curArea = 1;
        for (int m = 0; m < 4; m++) {
            int[] next = new int[]{i + moveI[m], j + moveJ[m]};
            curArea += dfs(grid, next[0], next[1]);
        }
        // grid[i][j] = 1; Max Area of Island 不要还原 因为这题是数整座岛。这个格子已经属于当前岛，访问过就不能再访问。
        return curArea;
    }
}
