class Solution {

    boolean[] seen;
    Map<Integer, List<Integer>> graph = new HashMap<>();

    public int findCircleNum(int[][] isConnected) {
        int rowLen = isConnected.length;
        int colLen = isConnected[0].length;
        // build the graph
        for(int i = 0; i< rowLen; i++) {
            for(int j = 0; j < colLen; j++) {
                if (isConnected[i][j] == 1) {
                    if (!graph.containsKey(i)) {
                        graph.put(i , new ArrayList<>());
                    }
                    if(!graph.containsKey(j)) {
                        graph.put(j , new ArrayList<>());
                    }
                    graph.get(i).add(j);
                    graph.get(j).add(i);
                }
            }
        }
        seen = new boolean[rowLen];
        int answer = 0;
        for(int i = 0; i< graph.size(); i++) {
            if (!seen[i]) {
                answer++;
                seen[i] = true;
                dfs(i);
            }
        }
        return answer;
    }


    public void dfs(int node) {
        for( int neighbor: graph.get(node)){
            if (!seen[neighbor]){
                seen[neighbor] = true;
                dfs(neighbor);
            }
        }
    }
}
