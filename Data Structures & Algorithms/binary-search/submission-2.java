class Solution {
    public int search(int[] nums, int target) {
        return helper(nums, target, 0, nums.length - 1);
    }
    private int helper(int[] nums, int target, int l, int r) {
        if (r < l) {
            return -1;
        }
        int m = l + (r - l) / 2;

        if (target == nums[m]) {
            return m;
        } else if (target > nums[m]) {
            return helper(nums, target, m + 1, r);
        } else {
            return helper(nums, target, l, m - 1);
        }
    }
}
