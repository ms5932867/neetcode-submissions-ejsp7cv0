class Solution {
    
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        
        helper(0, nums, res, new ArrayList<>());
        
        return res;
    }
    private void helper(int idx, int[] nums, List<List<Integer>> res, List<Integer> curRes) {
        if (idx == nums.length) {
            res.add(new ArrayList<>(curRes));
            return;
        }
        helper(idx + 1, nums, res, curRes);
        curRes.add(nums[idx]);
        helper(idx + 1, nums, res, curRes);
        curRes.remove(curRes.size() - 1);

    }
}
