class Solution {
    public int characterReplacement(String s, int k) {
        int[] cnt = new int[26];
        int l = 0;
        int maxCnt = 0;
        int res = 0;

        for (int r = 0; r < s.length(); r++) {
            cnt[s.charAt(r) - 'A']++;
            maxCnt = Math.max(maxCnt, cnt[s.charAt(r) - 'A']);

            while (r - l + 1 - maxCnt > k) {
                cnt[s.charAt(l) - 'A']--;
                l++;
            }

            res = Math.max(res, r - l + 1);
        }

        return res;
    }
}