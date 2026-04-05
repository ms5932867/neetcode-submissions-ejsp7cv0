class Solution {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int maxProfit = Integer.MIN_VALUE;
        for (int p :prices) {
            maxProfit = Math.max(maxProfit, p - min);
            min = Math.min(min, p);
        }
        return maxProfit < 0 ? 0: maxProfit;
    }
}
