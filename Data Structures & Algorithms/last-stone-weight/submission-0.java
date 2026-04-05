class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int s: stones) {
            pq.offer(s);
        }
        while (pq.size() > 1) {
            int n1 = pq.poll();
            int n2 = pq.poll();
            if (n1 != n2) {
                pq.offer(Math.abs(n1 - n2));
            }
        }
        return pq.isEmpty() ? 0 : pq.poll();
    }
}
