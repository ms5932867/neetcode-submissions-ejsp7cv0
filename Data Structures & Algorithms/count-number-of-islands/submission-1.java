class Solution {
    int cnt = 0;
    public int numIslands(char[][] grid) {

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    grid[i][j] = '2';
                    dfs(grid, i, j);
                    cnt++;
                }
            }
        }
        return cnt;
    }
    private void dfs(char[][] grid, int i, int j) {
        if (isValid(grid, i + 1 , j)) { 
            grid[i + 1][j] = '2';
            dfs(grid, i + 1, j);   
        }
        if (isValid(grid, i - 1 , j)) { 
            grid[i - 1][j] = '2';
            dfs(grid, i - 1, j);   
        }
        if (isValid(grid, i, j + 1 )) { 
            grid[i][j + 1 ] = '2';
            dfs(grid, i, j + 1 );   
        }
        if (isValid(grid, i, j - 1 )) { 
            grid[i][j - 1 ] = '2';
            dfs(grid, i, j - 1 );   
        }
           
        
    }
    private boolean isValid(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || 
        grid[i][j] != '1') {
            return false;
        }
        return true;
    }
}
