class Solution {
    public int lastStoneWeight(int[] stones) {
        int[] cnt = new int[1001];

        for (int s : stones) {
            cnt[s]++;
        }

        for (int w = 1000; w > 0; w--) {
            if (cnt[w] % 2 == 0) {
                continue;
            }

            int j = w - 1;
            while (j > 0 && cnt[j] == 0) {
                j--;
            }

            if (j == 0) {
                return w;
            }

            cnt[j]--;
            cnt[w - j]++;
        }

        return 0;
    }
}