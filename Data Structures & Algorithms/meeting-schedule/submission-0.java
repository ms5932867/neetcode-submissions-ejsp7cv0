/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
        PriorityQueue<Interval> pq = new PriorityQueue<>((i1, i2) -> Integer.compare(i1.start, i2.start));
        for (Interval i : intervals) {
            pq.offer(i);
        }
        int lastEnd = 0;
        while (!pq.isEmpty()) {
            Interval cur = pq.poll();
            if (cur.start < lastEnd) {
                return false;
            }
            lastEnd = Math.max(lastEnd, cur.end);
        }
        return true;

    }
}
