class Solution {

    public void dfs(Map<Integer, List<Integer>> graph, int city, boolean[] seen){
        for(int neighbor: graph.get(city)){
            if(!seen[neighbor]) {
                seen[neighbor] = true;
                dfs(graph, neighbor, seen);
            }
        }
    }

    public int findCircleNum(int[][] isConnected) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int i=0; i<isConnected.length; i++) {
            for(int j=0; j<isConnected[0].length; j++){
                if(i!=j && isConnected[i][j] == 1){
                    graph.putIfAbsent(i, new ArrayList<>());
                    graph.putIfAbsent(j, new ArrayList<>());
                    graph.get(i).add(j);
                    graph.get(j).add(i);
                }
            }
        }
        int provinces =0;
        boolean[] seen = new boolean[isConnected.length];

        for(int i=0;i<isConnected.length; i++) {
            if(!seen[i]){
                provinces++;
                seen[i] = true;
                if(graph.containsKey(i)){
                    dfs(graph, i, seen);
                }
            }
        }
        return provinces;
    }
}
