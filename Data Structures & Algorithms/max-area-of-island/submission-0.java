class Solution {
    
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    int[] curArea = new int[]{0};
                    dfs(grid, i, j, curArea);
                    maxArea = Math.max(maxArea, curArea[0]);
                }
            }
        }
        return maxArea;
    }
    int[] moveI = new int[]{1, -1, 0, 0};
    int[] moveJ = new int[]{0, 0, 1, -1};
    private void dfs(int[][] grid, int i, int j, int[] curArea) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] != 1) {
            return;
        }
        grid[i][j] = -1;
        curArea[0]++;
        for (int m = 0; m < 4; m++) {
            int[] next = new int[]{i + moveI[m], j + moveJ[m]};
            dfs(grid, next[0], next[1], curArea);
        }
    }
}
