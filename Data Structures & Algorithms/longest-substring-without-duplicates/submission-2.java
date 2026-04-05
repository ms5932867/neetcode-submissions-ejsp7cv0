
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int l = 0;
        int r = 0;
        Map<Character, Integer> seenIdx = new HashMap<>();
        int res = 0;
        while (r < s.length()) {
            char c = s.charAt(r);
            if (seenIdx.containsKey(c)) {
                l = Math.max(seenIdx.get(c) + 1, l); // left 指针不能往回走!!!!  
            } 
            seenIdx.put(c, r);
            res = Math.max(res, r - l + 1);
            r++;
        }
        return res;
    }
}
