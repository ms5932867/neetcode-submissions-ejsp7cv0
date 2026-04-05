class Solution {
    List<String> res = new ArrayList<>();
    String[] phone = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "qprs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return res;
        }
        dfs(digits, 0, new StringBuilder());
        return res;
    }
    private void dfs(String digits, int i, StringBuilder cur) {
        if (i == digits.length()) {
            res.add(cur.toString());
            return;
        }
        for (char l : phone[digits.charAt(i) -'0'].toCharArray()) {
            cur.append(l);
            dfs(digits, i + 1, cur);
            cur.deleteCharAt(cur.length() - 1);
        }
     }
}
