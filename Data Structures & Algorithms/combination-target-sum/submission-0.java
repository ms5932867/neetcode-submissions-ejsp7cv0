class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] nums, int target) {
       
       Arrays.sort(nums);
       dfs(nums, target, 0, 0,  new ArrayList<>());
       return res;
    }
    private void dfs(int[] nums, int target, int i, int curSum, List<Integer> curRes) {
        if (curSum == target) {
            res.add(new ArrayList<>(curRes));
            return;
        }
        if (i == nums.length || curSum > target) {
            return;
        }

        int maxCnt = (target - curSum) / nums[i];
        for (int cnt = 0; cnt <= maxCnt; cnt++) {
            for (int curCnt = 0; curCnt < cnt; curCnt++) {
                curRes.add(nums[i]);
            }

            dfs(nums, target, i + 1, curSum + nums[i] * cnt, curRes);
            for (int curCnt = 0; curCnt < cnt; curCnt++) {
                curRes.remove(curRes.size() - 1);
            }
        }
        
    }
}
