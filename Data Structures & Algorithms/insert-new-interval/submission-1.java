class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        int i = 0;
        int n = intervals.length;
        while (i < n && intervals[i][1] < newInterval[0]) {
            res.add(intervals[i]);
            i++;
        }
        res.add(newInterval);
        while (i < n &&  res.get(res.size() - 1)[1] >= intervals[i][0]) {
            int[] last = res.get(res.size() - 1);
            res.remove(res.size() - 1);
            res.add(new int[]{Math.min(last[0], intervals[i][0]), Math.max(last[1], intervals[i][1])});
            i++;
        }
        while (i < n) {
            res.add(intervals[i]);
            i++;
        }
        return res.toArray(new int[res.size()][]);
    }
}
