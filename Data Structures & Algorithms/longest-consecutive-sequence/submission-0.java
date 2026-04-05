class Solution {
    public int longestConsecutive(int[] nums) {
      Set<Integer> numsSet = new HashSet<>();
      for (int n : nums) {
        numsSet.add(n);
      }
      int res = 0;
      for (int n: nums) {
        if (!numsSet.contains(n - 1)) {
            int start = n;
            while (numsSet.contains(n)) {
                n++;
            }
            res = Math.max(n -start, res);
        }
      }  
      return res;
    }
}
