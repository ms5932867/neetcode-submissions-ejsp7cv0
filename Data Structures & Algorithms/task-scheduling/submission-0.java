class Solution {
    public int leastInterval(char[] tasks, int n) {
        // PriorityQueue<Integer> pq = new PriorityQueue<>((i1, i2) -> Integer.compare(i2, i1));
        int[] freq = new int[26];
        int maxFreq = 0;
        int sum = tasks.length;
        for (char t:  tasks) {
            freq[t - 'A']++;
            maxFreq = Math.max(maxFreq, freq[t - 'A']);
        }
        int maxCnt = 0;
        for (int f : freq) {
            if (f == maxFreq) {
                maxCnt++;
            }
        }
        
        return Math.max((maxFreq - 1) * (n + 1) + maxCnt, sum);
    }
}
