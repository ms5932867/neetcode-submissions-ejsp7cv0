class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        StringBuilder cur = new StringBuilder();
        dfs(n, cur, 0, 0, res);
        return res;
    }
    private void dfs(int n, StringBuilder cur, int left, int right, List<String> res) {
        if (cur.length() == 2 * n && left == right) {
            res.add(cur.toString());
            return;
        }
        if (left < n) {
            cur.append('(');   
            dfs(n, cur, left + 1, right, res);
            cur.deleteCharAt(cur.length() - 1);
        }

        
        if (left > right) {
            cur.append(')');
            dfs(n, cur, left, right + 1, res);
            cur.deleteCharAt(cur.length() - 1);
        }

        
    }
}
