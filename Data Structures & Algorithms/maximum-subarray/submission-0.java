class Solution {
    public int maxSubArray(int[] nums) {
        int minSum = 0;
        int sum = 0;
        int res = Integer.MIN_VALUE;
        for (int n : nums) {
            
            sum += n;
            res = Math.max(res, sum - minSum);
            minSum = Math.min(sum, minSum);
        }
        return res;
    }
}
