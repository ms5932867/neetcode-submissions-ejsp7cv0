class Solution {
    public int characterReplacement(String s, int k) {
        int l = 0;
        int r = 0;
        int res = 0;
        int maxCnt = 0;
        int[] cnt = new int[26];
        while (l <= r && r < s.length()) {
            char cur = s.charAt(r);
            cnt[cur - 'A']++;
            maxCnt = Math.max(maxCnt, cnt[cur - 'A']);
            while ( r - l + 1 - maxCnt > k) {
                cnt[s.charAt(l) - 'A']--;
                l++;
            }
            res = Math.max(res, r - l + 1);
            r++;

        }
        return res;
    }
}
