class Solution {
    int cnt = 0;
    public int findTargetSumWays(int[] nums, int target) {
        dfs(nums, 0, target);
        return cnt;
    }
    private void dfs(int[] nums, int idx, int target) {
        if (idx == nums.length) {
            if (target == 0) {
                cnt++;
                return;
            }
            return;
        }
        dfs(nums, idx + 1, target + nums[idx]);
        dfs(nums, idx + 1, target - nums[idx]);

    }
}
