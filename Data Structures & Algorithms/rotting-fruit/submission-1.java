class Solution {
    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return -1;
        }
        int r = grid.length;
        int c = grid[0].length;
        Queue<Pos> q = new LinkedList<>();
        int[] dx = new int[]{1, -1, 0, 0};
        int[] dy = new int[]{0, 0, 1, -1};
        int fresh = 0;
        int res = 0;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == 2) {
                    q.offer(new Pos(i, j));
                } else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }
        
        while (fresh > 0 && !q.isEmpty()) {
            for (int size = q.size(); size > 0; size--) {
                Pos cur = q.poll();
                for (int d = 0; d < 4; d++) {
                    Pos next = new Pos(cur.x + dx[d], cur.y + dy[d]);
                    if (isValid(next, r, c, grid)) {
                        fresh--;
                        grid[next.x][next.y] = 2;
                        q.offer(next);
                    }
                }
            }
            res++;
        }
       return fresh == 0 ? res : -1;
    }

    private boolean isValid(Pos p, int r, int c, int[][] grid) {
        if (p.x < 0 || p.y < 0 || p.x >= r || p.y >= c || grid[p.x][p.y] != 1) {
            return false;
        }
        return true;
    }

    private class Pos {
        int x;
        int y;
        Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }
}
