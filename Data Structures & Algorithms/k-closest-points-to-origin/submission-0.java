class Solution {
    public int[][] kClosest(int[][] points, int k) {
       PriorityQueue<int[]> maxHeap = new PriorityQueue<>((p0, p1) -> Double.compare(getDist(p1), getDist(p0)));
       int[][] res = new int[k][2];
       for (int[] p : points) {
            maxHeap.offer(p);
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }
        for (int i = 0; i < k; i++) {
            res[i] = maxHeap.poll();
        }
        return res;
    }
    private double getDist(int[] p) {
        return Math.pow(p[0], 2) + Math.pow(p[1], 2);
    }
}
