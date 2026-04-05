class Solution {
    public boolean isAnagram(String s, String t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        } 
        char[] sSort = s.toCharArray();
        char[] tSort = t.toCharArray();
        Arrays.sort(sSort);
        Arrays.sort(tSort);
        //WRONG!!! return sSort.equals(tSort); //WRONG!!!
        return Arrays.equals(sSort, tSort);
    }
}
