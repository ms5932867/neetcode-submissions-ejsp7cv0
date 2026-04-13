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
    public int minMeetingRooms(List<Interval> intervals) {
        intervals.sort((i0, i1) -> Integer.compare(i0.start, i1.start));

        PriorityQueue<Integer> ends = new PriorityQueue<>();

        for (Interval i: intervals) {
            if (ends.isEmpty() || ends.peek() > i.start) {

                ends.offer(i.end);
            } else {
                ends.offer(Math.max(i.end, ends.poll()));
            }
        }
        return ends.size();

    }
}
