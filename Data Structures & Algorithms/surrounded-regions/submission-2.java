class Solution {
    public void solve(char[][] board) {
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (i == 0 || j == 0 || i == board.length - 1 || j == board[0].length - 1) {
                    if (board[i][j] == 'O') {
                        q.offer(new int[]{i, j});
                        board[i][j] = '#';
                    }
                }
            }
        }
        int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            for (int d = 0; d < dir.length; d++) {
                int[] next = new int[]{cur[0] + dir[d][0], cur[1] + dir[d][1]};
                if (isValid(board, next)) {
                    board[next[0]][next[1]] = '#';
                    q.offer(new int[]{next[0], next[1]});
                }
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == '#') {
                    board[i][j] = 'O';
                }
            }
        }

    }
    private boolean isValid(char[][] board, int[] next) {
        int r = next[0];
        int c = next[1];
        if (r >= 0 && c >= 0 && r < board.length  && c < board[0].length && board[r][c] == 'O') {
            return true;
        }
        return false;
    }
}
