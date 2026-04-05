class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1 == null) {
            return true;
        }
        if (s2 == null || s2.length() < s1.length()) {
            return false;
        }
        int[] cntS1 = new int[26];
        int[] cntS2 = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            cntS1[s1.charAt(i) - 'a']++;
            cntS2[s2.charAt(i) - 'a']++;
        }
         
        for (int i = 0 ; i <= s2.length() - s1.length(); i++) {
            if (i > 0) {
                cntS2[s2.charAt(i - 1) - 'a']--;
                cntS2[s2.charAt( i + s1.length() - 1) - 'a']++;
            }
            if (Arrays.equals(cntS1, cntS2)) {
                return true;
            }
        }

        return false;

    }
}
