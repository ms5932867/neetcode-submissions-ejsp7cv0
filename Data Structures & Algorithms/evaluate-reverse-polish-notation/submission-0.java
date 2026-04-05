class Solution {
    public int evalRPN(String[] tokens) {
        Set<String> ops = new HashSet<>(Arrays.asList("+", "-", "*", "/"));
        Stack<Integer> stk = new Stack<>();
        for (String s: tokens) {
            if (!ops.contains(s)) {
                stk.push(Integer.valueOf(s));
            } else {
                int last1 = stk.pop();
                int last2 = stk.pop();
                if (s.equals("+")) {
                    stk.push(last2 + last1);
                } else if (s.equals("-")) {
                    stk.push(last2 - last1);
                } else if (s.equals("*")) {
                    stk.push(last2 * last1);
                } else {
                    stk.push(last2 / last1);
                }
            }
        } 
        int res = 0;
        while(!stk.isEmpty()) {
            res += stk.pop();
        }
        return res;
    }
}
