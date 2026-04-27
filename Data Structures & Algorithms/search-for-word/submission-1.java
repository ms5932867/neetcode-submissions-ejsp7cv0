class Solution {
    int[] moveI = new int[]{1, -1, 0, 0};
    int[] moveJ = new int[]{0, 0, 1, -1};
    public boolean exist(char[][] board, String word) {
        boolean[][] used = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (dfs(board, word, i, j, used, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    private boolean dfs(char[][] board, String word, int i, int j, boolean[][] used, int idx) {
        if (idx == word.length() ) {
            return true;
        }
        if (i >= board.length || i < 0 || j >= board[0].length || j < 0 || used[i][j]) {
            return false;
        }
        if (word.charAt(idx) != board[i][j]) {
            return false;
        }
        used[i][j] = true;
        for (int m = 0; m < 4; m++) {
            int[] next = new int[]{i + moveI[m], j + moveJ[m]};
            if (dfs(board, word, next[0], next[1], used, idx + 1)) {
                return true;
            }
        }
        used[i][j] = false;
        return false;
    }
}