class Solution {
    List<List<String>> res = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        // boolean[][] used = new boolean[n][n];
        boolean[][] queen = new boolean[n][n];
        dfs(queen, n, 0);
        return res;
    }

    private void dfs(boolean[][] queen, int n, int i) {
        if (i == n) {
            List<String> cur = convert(queen);
            res.add(new ArrayList<>(cur));
            return;
        }
        //i is row and j is col
        for (int j = 0; j < n; j++) {
            if (isValid(queen, n, i, j)) {
                queen[i][j] = true;
                dfs(queen, n, i + 1);
                queen[i][j] = false;
            }
        }
    }
    private List<String> convert(boolean[][] queen) {
        List<String> cur = new ArrayList<>();
        for (int i = 0; i < queen.length; i++) {
            StringBuilder curRow = new StringBuilder();
            for (int j = 0; j < queen[0].length; j++) {
                if (queen[i][j]) {
                    curRow.append("Q");
                } else {
                    curRow.append(".");
                }
            }
            cur.add(curRow.toString());

        }
        return cur;
    }
    private boolean isValid(boolean[][] queen, int n, int i, int j) {
        // same row on the left
        for (int col = 0; col <= j; col++) {
            if (queen[i][col]) {
                return false;
            }
        }
        // same col on the left
        for (int row = 0; row <= i; row++) {
            if (queen[row][j]) {
                return false;
            }
        }
        // upper-left diagonal.
        for (int row = i, col = j; row >= 0 && col >= 0; row--, col--) {
            if (queen[row][col]) {
                return false;
            }
        }
        // upper-right diagonal.
        for (int row = i, col = j; row >= 0 && col < n; row--, col++) {
            if (queen[row][col]) {
                return false;
        }
}
        return true;
    }

}
