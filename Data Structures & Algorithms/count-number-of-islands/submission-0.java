class Solution {
    public int numIslands(char[][] grid) {
        int cnt = 0;
        int[] dX = new int[]{1, -1, 0, 0};
        int[] dY = new int[]{0, 0, 1, -1};
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    cnt++;
                    q.offer(new int[]{i, j});
                    grid[i][j] = '2';
                    while (!q.isEmpty()) {
                        int[] cur = q.poll();
                        for (int d = 0; d < dX.length; d++) {
                            int[] next = new int[]{cur[0] + dX[d], cur[1] + dY[d]};
                            if(isValid(next, grid)) {
                                q.offer(next);
                                grid[next[0]][next[1]] = '2';
                            }
                        
                        }
                    }
                    
                }
            }
        }
        return cnt;
    }
    private boolean isValid(int[] next, char[][] grid) {
        if (next[0] < 0 || next[1] < 0 || next[0] >= grid.length || next[1] >= grid[0].length || 
        grid[next[0]][next[1]] != '1') {
            return false;
        }
        return true;
    }
}
