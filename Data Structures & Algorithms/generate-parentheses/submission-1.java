class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        StringBuilder cur = new StringBuilder();
        int dif = 0; // left - right dif
        dfs(n, cur, dif, res);
        return res;
    }
    private void dfs(int n, StringBuilder cur, int dif, List<String> res) {
        if (dif < 0 || cur.length() > 2 * n) {
            return;
        }
        if (cur.length() == 2 * n && dif == 0) {
            res.add(cur.toString());
            return;
        }
        if (dif >= 0) {
            cur.append('(');
            dfs(n, cur, dif + 1, res);
            cur.deleteCharAt(cur.length() - 1);
        }
        if (dif > 0) {
            cur.append(')');
            dfs(n, cur, dif - 1, res);
            cur.deleteCharAt(cur.length() - 1);
        }
    }
}
