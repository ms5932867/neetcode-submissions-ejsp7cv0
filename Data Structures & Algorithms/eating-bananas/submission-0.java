class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1;
        int r = 0;
        for (int p: piles) {
            r = Math.max(r, p);
        }
        while (l <= r) {
            int m = l + (r - l) / 2;
            int hour = getHours(piles, m);
            if (hour > h) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return l;
        
    }
    private int getHours(int[] piles, int m) {
       int hour = 0;
       for (int p : piles) {
        hour += p / m;
        if (p % m != 0) {
            hour++; 
        } 
       } 
       return hour;
    }
}
