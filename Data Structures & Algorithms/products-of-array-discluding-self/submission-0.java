class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        int[] res = new int[nums.length];
        for (int i = 0; i < left.length; i++) {
            if (i == 0) {
                left[i] = 1;
            } else {
                left[i] = nums[i - 1] * left[i - 1];
            }
            
        }
        for (int j = right.length - 1; j>= 0; j--) {
            if (j == right.length - 1) {
                right[j] = 1;
            } else {
                right[j] = nums[j + 1] * right[j + 1];
                
            }
            res[j] = left[j] * right[j];
        }
        
        return res;
    }
}  
