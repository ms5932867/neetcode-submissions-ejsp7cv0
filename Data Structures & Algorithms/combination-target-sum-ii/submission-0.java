class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        boolean[] used = new boolean[candidates.length];
        List<List<Integer>> res = new ArrayList<>();
        dfs(candidates, target, used, 0, res, new ArrayList<>());
        return res;
    }
    private void dfs(int[] candidates, int remain,boolean[] used, int idx, List<List<Integer>> res, List<Integer> curRes) {
        if (remain == 0) {
            res.add(new ArrayList<>(curRes));
            return;
        }
        if (idx == candidates.length || remain < 0) {
            return;
        }
        dfs(candidates, remain, used, idx + 1, res, curRes);
        if (idx == 0 || candidates[idx] != candidates[idx - 1] || used[idx - 1]) {
            curRes.add(candidates[idx]);
            used[idx] = true;
            dfs(candidates, remain - candidates[idx], used, idx + 1, res, curRes);
            curRes.remove(curRes.size() - 1);
            used[idx] = false;
        } 
    }
}
