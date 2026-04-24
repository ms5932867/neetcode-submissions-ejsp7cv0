class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1) {
            return false;
        }
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] e : edges) {
            graph.putIfAbsent(e[0], new ArrayList<>());
            graph.get(e[0]).add(e[1]);
            graph.putIfAbsent(e[1], new ArrayList<>());
            graph.get(e[1]).add(e[0]);
        }

        Set<Integer> seen = new HashSet<>();
        seen.add(0);
        dfs(graph, seen, 0);
        return seen.size() == n;
    }
    private void dfs(Map<Integer, List<Integer>> graph, Set<Integer> seen, int i) {
        if (!graph.containsKey(i)) {
            return;
        }
        for (int next : graph.get(i)) {
            if (seen.contains(next)) {
                continue;
            }
            seen.add(next);
            dfs(graph, seen, next);
        }
        
    }
}
