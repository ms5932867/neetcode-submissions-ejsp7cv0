class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int l = 0;
        int r = 0;
        Map<Character, List<Integer>> seenIdx = new HashMap<>();
        int res = 0;
        while (r < s.length()) {
            char c = s.charAt(r);
            if (!seenIdx.containsKey(c)) {
                seenIdx.put(c, new ArrayList<>());
            } else {
                List<Integer> idx = seenIdx.get(c);
                l = Math.max(idx.get(idx.size() - 1) + 1, l);
            }
            seenIdx.get(c).add(r);
            res = Math.max(res, r - l + 1);
            r++;
        }
        return res;
    }
}
