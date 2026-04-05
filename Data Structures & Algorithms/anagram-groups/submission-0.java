class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> sortedAndGroup = new HashMap<>();
        for (String s: strs) {
            String sortS = sortStr(s);
            sortedAndGroup.putIfAbsent(sortS, new ArrayList<>());
            sortedAndGroup.get(sortS).add(s);
        }
        List<List<String>> res = new ArrayList<>();
        for (String sortS : sortedAndGroup.keySet()) {
            res.add(sortedAndGroup.get(sortS));
        }
        return res;
    }

    private String sortStr (String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        StringBuilder sb = new StringBuilder();
        for (char c: chars) {
            sb.append(c);
        }
        return sb.toString();
    }
}
