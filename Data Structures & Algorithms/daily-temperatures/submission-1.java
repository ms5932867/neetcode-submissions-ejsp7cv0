class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        Stack<Integer> stk = new Stack<>(); //decreased temperature index
        for (int i = 0; i < temperatures.length; i++) {
            while (!stk.isEmpty() && temperatures[i] > temperatures[stk.peek()]) {
                int lastIdx = stk.pop();
                res[lastIdx] = i - lastIdx;      
            }
            stk.push(i);
        }
        return res;
    }
}
