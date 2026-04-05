class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<Item> pq = new PriorityQueue<>((i1, i2) -> (i2.cnt - i1.cnt));
        Map<Integer, Integer> numCnt = new HashMap<>();
        for (int n: nums) {
            numCnt.putIfAbsent(n, 0);
            numCnt.put(n, numCnt.get(n) + 1);
        }
        for (int n: numCnt.keySet()) {
            pq.offer(new Item(n, numCnt.get(n)));
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = pq.poll().n;
        }
        return res;

    }
    class Item {
        int n;
        int cnt;
        Item(int n, int cnt) {
            this.n = n;
            this.cnt = cnt;
        }
    }
}
