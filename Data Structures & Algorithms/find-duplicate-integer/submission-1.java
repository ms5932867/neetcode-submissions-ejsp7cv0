class Solution {
    public int findDuplicate(int[] nums) {
        for (int n : nums) {
            n = Math.abs(n);
            if (nums[n - 1] < 0) {
                return n;
            } else {
                nums[n - 1] *= (-1);
            }
        }
        return -1;
    }
}
