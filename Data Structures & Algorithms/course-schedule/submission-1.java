class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, Integer> preCnt = new HashMap<>(); // course : count of pres
        Map<Integer, Set<Integer>> preCourse = new HashMap<>();// pre : the courses require this pre
        for (int i = 0; i < numCourses; i++) {
            preCnt.put(i, 0);
        }
        for (int[] pair : prerequisites) {
            preCnt.put(pair[0], preCnt.get(pair[0]) + 1);
            preCourse.putIfAbsent(pair[1], new HashSet<>());
            preCourse.get(pair[1]).add(pair[0]);
        }
        Queue<Integer> q = new LinkedList<>();
        for (int course : preCnt.keySet()) {
            if (preCnt.get(course) == 0) {
                q.offer(course);
            }
        }
        int taken = 0;
        while(!q.isEmpty()) {
            int pre = q.poll();
            taken++;
            if (taken == numCourses) {
                return true;
            }
            if (!preCourse.containsKey(pre)) {
                continue;
            }
            for (int course: preCourse.get(pre)) {
                preCnt.put(course, preCnt.get(course) - 1);
                if (preCnt.get(course) == 0) {
                    q.offer(course);
                }
            }

        }
        return taken == numCourses;

    }
}
