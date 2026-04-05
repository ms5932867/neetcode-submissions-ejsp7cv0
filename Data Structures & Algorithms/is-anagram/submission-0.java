class Solution {
    public boolean isAnagram(String s, String t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }
        int[] cntS = new int[26];
        for (char c: s.toCharArray()) {
            cntS[c -'a']++;
        }
        for (char c: t.toCharArray()) {
            cntS[c - 'a']--;
        }
        for (int c : cntS) {
            if (c != 0) {
                return false;
            }
        }
        return true;
    }
}
