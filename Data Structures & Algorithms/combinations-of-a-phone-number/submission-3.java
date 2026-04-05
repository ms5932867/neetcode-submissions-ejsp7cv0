class Solution {
    public List<String> letterCombinations(String digits) {
        Map<Character, List<Character>> phone = phoneBuiler();

        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return res;
        }
        dfs(digits, phone, 0, new StringBuilder(), res);
        return res;
    }
    private void dfs(String digits, Map<Character, List<Character>> phone, int i,
     StringBuilder cur, List<String> res) {
        if (i == digits.length()) {
            res.add(cur.toString().toLowerCase());
            return;
        }
        
        List<Character> letters = phone.get(digits.charAt(i));
        for (char l : letters) {
            cur.append(l);
            dfs(digits, phone, i + 1, cur, res);
            cur.deleteCharAt(cur.length() - 1);
        }
     }
     private Map<Character, List<Character>> phoneBuiler() {
        Map<Character, List<Character>> phone = new HashMap<>();
        phone.put('2', Arrays.asList('A', 'B', 'C'));
        phone.put('3', Arrays.asList('D', 'E', 'F'));
        phone.put('4', Arrays.asList('G', 'H', 'I'));
        phone.put('5', Arrays.asList('J', 'K', 'L'));
        phone.put('6', Arrays.asList('M', 'N', 'O'));
        phone.put('7', Arrays.asList('P', 'Q', 'R', 'S'));
        phone.put('8', Arrays.asList('T', 'U', 'V'));
        phone.put('9', Arrays.asList('W', 'X', 'Y', 'Z'));
        return phone;
     }
}
