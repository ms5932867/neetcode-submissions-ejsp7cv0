class Solution {
    public boolean canJump(int[] nums) {
        boolean[] dp = new boolean[nums.length];
        dp[0] = true;
        for (int i = 0; i < nums.length; i++) {
            if (!dp[i]) {
                continue;
            }
            for (int step = 1; step <= nums[i] && step + i < dp.length; step++) {
                dp[i + step] = true;
            }
        }
        return dp[dp.length - 1]; 
    }
}
