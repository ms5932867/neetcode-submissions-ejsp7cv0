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
/*
第0层：决定 2 用几次
第1层：决定 3 用几次
第2层：决定 6 用几次
root: [] sum=0, i=0, 处理数字2
├── 2用0次 -> [] sum=0, i=1, 处理数字3
│   ├── 3用0次 -> [] sum=0, i=2, 处理数字6
│   │   ├── 6用0次 -> [] sum=0, i=3 结束
│   │   └── 6用1次 -> [6] sum=6, i=3 结束
│   ├── 3用1次 -> [3] sum=3, i=2, 处理数字6
│   │   └── 6用0次 -> [3] sum=3, i=3 结束
│   └── 3用2次 -> [3,3] sum=6, i=2, 处理数字6
│       └── 6用0次 -> [3,3] sum=6, i=3 结束
├── 2用1次 -> [2] sum=2, i=1, 处理数字3
│   ├── 3用0次 -> [2] sum=2, i=2, 处理数字6
│   │   └── 6用0次 -> [2] sum=2, i=3 结束
│   ├── 3用1次 -> [2,3] sum=5, i=2, 处理数字6
│   │   └── 6用0次 -> [2,3] sum=5, i=3 结束
│   └── 3用2次 -> [2,3,3] sum=8 超了
├── 2用2次 -> [2,2] sum=4, i=1, 处理数字3
│   ├── 3用0次 -> [2,2] sum=4, i=2, 处理数字6
│   │   └── 6用0次 -> [2,2] sum=4, i=3 结束
│   └── 3用1次 -> [2,2,3] sum=7 ✅
└── 2用3次 -> [2,2,2] sum=6, i=1, 处理数字3
    ├── 3用0次 -> [2,2,2] sum=6, i=2, 处理数字6
    │   └── 6用0次 -> [2,2,2] sum=6, i=3 结束
    └── 3用1次 -> [2,2,2,3] sum=9 超了

*/
