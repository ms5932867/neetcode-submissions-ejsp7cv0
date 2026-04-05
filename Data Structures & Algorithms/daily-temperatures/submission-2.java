class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] dp = new int[temperatures.length];
        dp[temperatures.length - 1] = 0;
        for (int i = temperatures.length - 2; i>= 0; i--) {
            int j = i + 1;
            while (true) {
                if (temperatures[i] < temperatures[j]) {
                    dp[i] = j - i;
                    break;
                }
                else if (dp[j] == 0) {
                    dp[i] = 0;
                    break;
                } else {
                    j += dp[j];
                }
            }
        }
        return dp;
    }
}
