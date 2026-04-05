class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> rightToLeft = new HashMap<>(){{
        put( ')', '(');
        put( ']', '[');
        put( '}', '{');
        }};
        Set<Character> left = new HashSet();
        left.addAll(Arrays.asList('(', '[','{'));
        Stack<Character> stk = new Stack<>();
        for (char c: s.toCharArray()) {
            if (left.contains(c)) {
                stk.push(c);
            } else {
                if (stk.isEmpty()) {
                    return false;
                } else {
                    char last = stk.pop();
                    if (last != rightToLeft.get(c)) {
                        return false;
                    }
                }
            }
        }
        return stk.isEmpty();
    
        
    }
}
