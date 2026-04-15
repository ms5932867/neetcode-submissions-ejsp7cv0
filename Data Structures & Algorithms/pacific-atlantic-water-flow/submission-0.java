class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>>  res = new ArrayList<>();
        Queue<int[]> q = new LinkedList<>();
        boolean[][] used = new boolean[heights.length][heights[0].length];
        boolean[][] pac = new boolean[heights.length][heights[0].length];
        int[][] move = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        // add Pac start pos
        for (int i = 0; i < heights.length; i++) {
            q.offer(new int[]{i, 0});
            used[i][0] = true;
            pac[i][0] = true;
        }
        for (int j = 1; j < heights[0].length; j++) {
            q.offer(new int[]{0, j});
            used[0][j] = true;
            pac[0][j] = true;
        }
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int m = 0; m < move.length; m++) {
                int[] next = new int[]{cur[0] + move[m][0], cur[1] + move[m][1]};
                if (isValid(heights, used, cur, next)) {
                    q.offer(next);
                    used[next[0]][next[1]] = true;
                    pac[next[0]][next[1]] = true;
                }
            }
        }
        // add Atlantic
        used = new boolean[heights.length][heights[0].length];
        for (int i = 0; i < heights.length; i++) {
            q.offer(new int[]{i, heights[0].length - 1});
            used[i][heights[0].length - 1] = true;
            if (pac[i][heights[0].length - 1]) {
                res.add(Arrays.asList(i, heights[0].length - 1));
            }
        }
        for (int j = 0; j < heights[0].length - 1; j++) {
            q.offer(new int[]{heights.length - 1, j});
            used[heights.length - 1][j] = true;
            if (pac[heights.length - 1][j]) {
                res.add(Arrays.asList(heights.length - 1, j));
            }
        }
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int m = 0; m < move.length; m++) {
                int[] next = new int[]{cur[0] + move[m][0], cur[1] + move[m][1]};
                if (isValid(heights, used, cur, next)) {
                    q.offer(next);
                    used[next[0]][next[1]] = true;
                    if (pac[next[0]][next[1]]) {
                        res.add(Arrays.asList(next[0], next[1]));
                    }
                }
            }
        }

        return res;
    }

    private boolean isValid(int[][] heights, boolean[][] used, int[] cur, int[] next) {
        int r = next[0];
        int c = next[1];
        if (r < 0 || c < 0 || r >= heights.length || c >= heights[0].length || used[r][c] || heights[cur[0]][cur[1]] > heights[r][c]) {
            return false;
        }
        return true;
    }
    
}