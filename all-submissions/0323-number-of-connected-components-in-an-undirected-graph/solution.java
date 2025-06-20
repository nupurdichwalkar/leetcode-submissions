class Solution {
    Map<Integer, List<Integer>> graph = new HashMap<>();
    Set<Integer> seen = new HashSet<>();

    public int countComponents(int n, int[][] edges) {
        int answer = 0;
        // build graph
        for (int i = 0; i < edges.length; i++) {
            int x = edges[i][0];
            int y = edges[i][1];
            if (!graph.containsKey(x)) {
                graph.put(x, new ArrayList<>());
            }
            graph.get(x).add(y);
            if (!graph.containsKey(y)) {
                graph.put(y, new ArrayList<>());
            }
            graph.get(y).add(x);
        }
        for (int i = 0; i < n; i++) {
            if (!graph.containsKey(i)) {
                graph.put(i, new ArrayList<>());
            }
        }
        for (int i = 0; i < n; i++) {
            if (!seen.contains(i)) {
                answer++;
                dfs(i);
            }
        }
        return answer;
    }

    public void dfs(int source) {
        if (!graph.get(source).isEmpty()) {
            for (int neighbor : graph.get(source)) {
                if (!seen.contains(neighbor)) {
                    seen.add(neighbor);
                    dfs(neighbor);
                }
            }
        }
    }
}
