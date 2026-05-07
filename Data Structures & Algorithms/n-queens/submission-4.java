class Solution {
    List<List<String>> res = new ArrayList<>();
    Set<Integer> usedCol = new HashSet<>();
    Set<Integer> leftDiagonal = new HashSet<>();
    Set<Integer> rightDiagonal = new HashSet<>();
    public List<List<String>> solveNQueens(int n) {
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
            if (!usedCol.contains(j) && !leftDiagonal.contains(i - j) && !rightDiagonal.contains(i + j)) {
                queen[i][j] = true;
                usedCol.add(j);
                leftDiagonal.add(i - j);
                rightDiagonal.add(i + j);
                dfs(queen, n, i + 1);
                queen[i][j] = false;
                usedCol.remove(j);
                leftDiagonal.remove(i - j);
                rightDiagonal.remove(i + j);
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
}
