class Solution {
    Map<Integer, List<Integer>> graph = new HashMap<>();
    Set<Integer> seen = new HashSet<>();
    
    
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        for (int i = 0; i< n; i++){
            graph.put(i, new ArrayList<>());
        }
        
        for (int[] edge: edges){
            int x = edge[0];
            int y = edge[1];
            graph.get(x).add(y);
            graph.get(y).add(x);
        }
        
        seen.add(source);
        dfs(source);
        if (seen.contains(destination)) {
            return true;
        }
        return false;
    }
    
    private void dfs(int node) {
        for(int neighbor: graph.get(node)) {
            if(!seen.contains(neighbor)) { 
                seen.add(neighbor);
                dfs(neighbor);
            }
        }
    }
}
