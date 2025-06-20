class Solution {
    Map<Integer, List<Integer>> graph = new HashMap<>();
    Set<Integer> seen = new HashSet<>();

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if (edges.length == 0) return true;
        // build a graph
        for (int i =0; i< edges.length;i++) {
            int x = edges[i][0]; int y = edges[i][1];
            if (!graph.containsKey(x)) {
                graph.put(x, new ArrayList<>());
            }
            graph.get(x).add(y);
            if(!graph.containsKey(y)) {
                graph.put(y, new ArrayList<>());
            }
            graph.get(y).add(x);
        }
        seen.add(source);
        return dfs(source, destination);
    }

    public boolean dfs(int source, int destination) {
        if(source == destination) {
            return true;
        }
        for (int neighbor: graph.get(source)){
            if(!seen.contains(neighbor)){
                seen.add(neighbor);
                if (dfs(neighbor, destination)) {
                    return true;
                }
            }
        }
        return false;
    }
}
