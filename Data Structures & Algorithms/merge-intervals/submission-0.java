class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));
        Stack<int[]> stk = new Stack<>();
        for (int[] i: intervals) {
            if (stk.isEmpty() || stk.peek()[1] < i[0]) {
                stk.push(i);
            } else {
                int[] last = stk.pop();
                stk.push(new int[]{Math.min(last[0], i[0]), Math.max(last[1], i[1])});
            }
        }
        int[][] res = new int[stk.size()][2];
        for (int i = 0; i < res.length; i++) {
            res[i] = stk.pop();
        }
        return res;
    }
}
