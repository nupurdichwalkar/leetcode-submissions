class Solution {

    Map<Integer, List<Integer>> graph = new HashMap<>();

    public int countComponents(int n, int[][] edges) {

        //build the graph
        for(int[] edge: edges){
            int x = edge[0];
            int y = edge[1];
            if(!graph.containsKey(x)) {
                graph.put(x, new ArrayList<>());
            }
            if(!graph.containsKey(y)) {
                graph.put(y, new ArrayList<>());
            }
            graph.get(x).add(y);
            graph.get(y).add(x);
        }

        //DFS
        int count = 0;
        boolean[] seen = new boolean[n];
        for(int i=0;i<n;i++){
            if(!graph.containsKey(i)) {
                count++;
                seen[i] = true;
            } else
            if(!seen[i]){
                count++;
                seen[i] = true;
                dfs(i, seen);
            }
        }
        return count;
    }

    public void dfs(int index, boolean[] seen) {
        List<Integer> neighbors = graph.get(index);
        for(int neighbor: neighbors) {
            if(!seen[neighbor]) {
                seen[neighbor] = true;
                dfs(neighbor, seen);
            }
        }
    }
}
