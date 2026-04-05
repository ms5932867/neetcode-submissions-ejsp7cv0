class Solution {
    public boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            char ci = s.charAt(i);
            char cj = s.charAt(j);
            if (!Character.isLetterOrDigit(ci)) {
                i++;
                continue;
            }
            if (!Character.isLetterOrDigit(cj)) {
                j--;
                continue;
            }
            if (Character.toLowerCase(ci) == Character.toLowerCase(cj)) {
                i++;
                j--;
            } else {
                return false;
            }
        }
        return true;
    }
}
