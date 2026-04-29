class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        dfs(nums, used, new ArrayList<>(), res);
        return res;
    }
    private void dfs(int[] nums, boolean[] used, List<Integer> curRes, List<List<Integer>> res) {
        if (curRes.size() == nums.length) {
            res.add(new ArrayList<>(curRes));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            curRes.add(nums[i]);
            used[i] = true;
            dfs(nums, used, curRes, res);
            used[i] = false;
            curRes.remove(curRes.size() - 1);
        }
    }
}
