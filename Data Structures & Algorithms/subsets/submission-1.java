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
        // 不加这个数
        helper(idx + 1, nums, res, curRes);
        // 加这个数
        curRes.add(nums[idx]);
        helper(idx + 1, nums, res, curRes);
        curRes.remove(curRes.size() - 1);
    }
}
