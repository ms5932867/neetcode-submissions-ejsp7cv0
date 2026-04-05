class Solution {
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        if (nums[l] < nums[r]) {
            return nums[l];
        }
        while (l + 1 < r) {
            int m = (r - l) / 2 + l;
            if (nums[l] < nums[m] && nums[r] < nums[m]) {
                l = m;
            } else {
                r = m;
            }
        }
        return Math.min(nums[l], nums[r]);
    }
}
