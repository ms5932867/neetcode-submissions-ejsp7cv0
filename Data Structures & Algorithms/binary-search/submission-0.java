class Solution {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l + 1 < r) {
            int m = l + (r - l) / 2;
            if (target == nums[m]) {
                return m;
            } else if (target > nums[m]) {
                l = m;
            } else {
                r = m;
            }
        }
        if (target == nums[l]) {
            return l;
        }
        if (target == nums[r]) {
            return r;
        }
        return -1;
    }
}
