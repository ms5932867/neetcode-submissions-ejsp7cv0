class Solution {
    public int jump(int[] nums) {
       int[] jumps = new int[nums.length];
       Arrays.fill(jumps, Integer.MAX_VALUE);
       jumps[0] = 0;
       for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j <= Math.min(i + nums[i] , nums.length - 1) ; j++) {
                jumps[j] = Math.min(jumps[j], jumps[i] + 1);
            }
       }  
       return jumps[jumps.length - 1];
    }
}
/*
if i + nums[i] >= nums.length - 1,  
*/