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
    //  private Map<Character, List<Character>> phoneBuiler() {
    //     Map<Character, List<Character>> phone = new HashMap<>();
    //     phone.put('2', Arrays.asList('A', 'B', 'C'));
    //     phone.put('3', Arrays.asList('D', 'E', 'F'));
    //     phone.put('4', Arrays.asList('G', 'H', 'I'));
    //     phone.put('5', Arrays.asList('J', 'K', 'L'));
    //     phone.put('6', Arrays.asList('M', 'N', 'O'));
    //     phone.put('7', Arrays.asList('P', 'Q', 'R', 'S'));
    //     phone.put('8', Arrays.asList('T', 'U', 'V'));
    //     phone.put('9', Arrays.asList('W', 'X', 'Y', 'Z'));
    //     return phone;
    //  }
}
