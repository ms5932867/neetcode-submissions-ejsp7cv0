class Solution {
    public int missingNumber(int[] nums) {
        int sum = 0;
        int n = nums.length;
        int targetSum = (n + 1) * n / 2;
        for (int num : nums) {
            sum += num;
        }
        return targetSum - sum;
    }
}
