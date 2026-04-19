class Solution {
    public boolean isHappy(int n) {
        Set<Integer> seen = new HashSet<>();
        while (n != 1) {
            if (seen.contains(n)) {
                return false;
            }
            seen.add(n);
            n = helper(n);
        }
        return true;
    }
    private int helper(int n) {
        int res = 0;
        while (n > 0) {
            res += (int)Math.pow((n % 10), 2);
            n = n /10;
        }
        return res;
    }
}
