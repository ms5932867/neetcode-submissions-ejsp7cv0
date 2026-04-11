class Solution {
    public int minCostClimbingStairs(int[] cost) {

        int dp0 = 0;
        int dp1 = 0;
        int res = 0;
        for (int i = 2; i< cost.length + 1; i++) {

            res = Math.min(dp1 + cost[i - 1], dp0+ + cost[i - 2]);
            dp0 = dp1;
            dp1 = res;
        }
        return res;
    }
    //dp[n] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + + cost[i - 2]);
}
