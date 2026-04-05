class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        helper(0, nums, res, new ArrayList<>());
        return res;
    }
    private void helper(int start, int[] nums, List<List<Integer>> res, List<Integer> curRes) {
        res.add(new ArrayList<>(curRes));
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            curRes.add(nums[i]);
            helper(i + 1, nums, res, curRes);
            curRes.remove(curRes.size() - 1);
        }
    }
}
