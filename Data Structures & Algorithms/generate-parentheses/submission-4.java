class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        StringBuilder cur = new StringBuilder();
        int dif = 0; // left - right dif
        dfs(n, cur, 0, 0, res);
        return res;
    }
    private void dfs(int n, StringBuilder cur, int left, int right, List<String> res) {
        if (left > n || cur.length() > 2 * n || left < right) {
            return;
        }
        if (cur.length() == 2 * n && left == right) {
            res.add(cur.toString());
            return;
        }
        
        cur.append('(');
        dfs(n, cur, left + 1, right, res);
        cur.deleteCharAt(cur.length() - 1);
        
        cur.append(')');
        dfs(n, cur, left, right + 1, res);
        cur.deleteCharAt(cur.length() - 1);
        
    }
}
