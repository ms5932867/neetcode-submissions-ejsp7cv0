class Solution {
    List<List<String>> res = new ArrayList<>();

    Set<Integer> usedCol = new HashSet<>();
    Set<Integer> leftDiagonal = new HashSet<>();   // row - col
    Set<Integer> rightDiagonal = new HashSet<>();  // row + col

    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        dfs(board, n, 0);
        return res;
    }

    private void dfs(char[][] board, int n, int row) {
        if (row == n) {
            res.add(convert(board));
            return;
        }

        for (int col = 0; col < n; col++) {
            int d1 = row - col;
            int d2 = row + col;

            if (usedCol.contains(col) 
                || leftDiagonal.contains(d1) 
                || rightDiagonal.contains(d2)) {
                continue;
            }

            board[row][col] = 'Q';
            usedCol.add(col);
            leftDiagonal.add(d1);
            rightDiagonal.add(d2);

            dfs(board, n, row + 1);

            board[row][col] = '.';
            usedCol.remove(col);
            leftDiagonal.remove(d1);
            rightDiagonal.remove(d2);
        }
    }

    private List<String> convert(char[][] board) {
        List<String> cur = new ArrayList<>();

        for (char[] row : board) {
            cur.add(new String(row));
        }

        return cur;
    }
}