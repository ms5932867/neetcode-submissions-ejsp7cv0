class Solution {
    public int lastStoneWeight(int[] stones) {
        int max = 0;
        for (int s: stones) {
            max = Math.max(max, s);
        }
        int[] bucket = new int[max + 1];
        for (int s : stones) {
            bucket[s]++;
        }
        for (int i = bucket.length - 1; i >= 0; i--) {
            if (bucket[i] % 2 == 0) {
                bucket[i] = 0;
                continue;
            }           

            
            for (int j = i -1; j >= 0; j--) {
                if (bucket[j] >= 1) {
                    int next = Math.abs(i - j);
                    bucket[next]++;
                    bucket[j]--;
                    bucket[i] = 0;
                    break;
                }
            }

        }
        for (int i = 0; i < bucket.length; i++) {
            if (bucket[i] != 0) {
                return i;
            }
        }
        return 0;
    }
}
