class Solution {
    Map<Integer, List<Integer>> graph = new HashMap<>();
    Set<Integer> seen = new HashSet<>();
    int componentCount = 0;

    public int countComponents(int n, int[][] edges) {
        //build a graph
        for(int[] edge:edges) {
            int x = edge[0];
            int y = edge[1];
            if (!graph.containsKey(x)){
                graph.put(x, new ArrayList<>());
            }
            if (!graph.containsKey(y)){
                graph.put(y, new ArrayList<>());
            }
            graph.get(x).add(y);
            graph.get(y).add(x);
        }

        for(int i = 0; i<n ;i++) {
            if(!seen.contains(i)){
                componentCount++;
                dfs(i);
            }  
        }
        return componentCount;
    }

    private void dfs(int node){
        if(graph.containsKey(node)){
            for(int neighbor: graph.get(node)) {
                if (!seen.contains(neighbor)){
                    seen.add(neighbor);
                    dfs(neighbor);
                }
            }
        }
    }
}
