class Solution {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l + 1 < r) {
            int m = (r - l) / 2 + l;
            if (nums[m] ==  target) {
                return m;
            }
           if (nums[l] < nums[m]) {
                if (target >= nums[l] && target < nums[m]) {
                    r = m;
                } else {
                    l = m;
                }
           } else {
                if (target > nums[m] && target <= nums[r]) {
                    l = m;
                } else {
                    r = m;
                }
           }
        } 
        if (nums[l] == target) {
            return l;
        }
        if (nums[r] == target) {
            return r;
        }
        return -1; 
    }
}
/*
根本原因

这题一定要先判断：
左半边是否有序
或右半边是否有序

因为 rotated array 的特点是：至少有一半是有序的。
只有先知道哪半边有序，才能判断 target 应该去哪边。
*/
/*
if (左边有序) {
    if (target 在左边有序区间内) {
        去左边
    } else {
        去右边
    }
} else {
    if (target 在右边有序区间内) {
        去右边
    } else {
        去左边
    }
}
*/
