class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>>  res = new ArrayList<>();
        Queue<int[]> q = new LinkedList<>();
        boolean[][] pac = new boolean[heights.length][heights[0].length];
        boolean[][] atl = new boolean[heights.length][heights[0].length];
        int[][] move = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        // add Pac start pos
        for (int i = 0; i < heights.length; i++) {
            q.offer(new int[]{i, 0});
            pac[i][0] = true;
        }
        for (int j = 1; j < heights[0].length; j++) {
            q.offer(new int[]{0, j});
            pac[0][j] = true;
        }
        bfs(heights, pac, q, move);
        // add Atlantic

        for (int i = 0; i < heights.length; i++) {
            q.offer(new int[]{i, heights[0].length - 1});
            atl[i][heights[0].length - 1] = true;
        }
        for (int j = 0; j < heights[0].length - 1; j++) {
            q.offer(new int[]{heights.length - 1, j});
            atl[heights.length - 1][j] = true;
        }
        bfs(heights, atl, q, move);
        for (int i = 0; i < heights.length; i++) {
            for (int j = 0; j < heights[0].length; j++) {
                if (pac[i][j] && atl[i][j]) {
                    res.add(Arrays.asList(i, j));
                }
            }
        }
        return res;
    }
    private void bfs(int[][] heights, boolean[][] used, Queue<int[]> q, int[][] move) {
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int m = 0; m < move.length; m++) {
                int[] next = new int[]{cur[0] + move[m][0], cur[1] + move[m][1]};
                if (isValid(heights, used, cur, next)) {
                    q.offer(next);
                    used[next[0]][next[1]] = true;
                }
            }
        }
    }
    private boolean isValid(int[][] heights, boolean[][] used, int[] cur, int[] next) {
        int r = next[0];
        int c = next[1];
        return r >= 0 && c >= 0
            && r < heights.length && c < heights[0].length
            && !used[r][c]
            && heights[r][c] >= heights[cur[0]][cur[1]];
    }
    
}