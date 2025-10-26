class Solution {

    public boolean bfs(int i,  Map<Integer, Set<Integer>> graph, int[] options) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(i);
        options[i] = 0;
        while(!queue.isEmpty()) {
            Integer node = queue.poll();
            if(!graph.containsKey(node)){
                continue;
            }
            for(int neighbor: graph.get(node)){
                if(options[neighbor] == options[node]){
                    return false;
                } 
                if(options[neighbor] == -1){
                    options[neighbor] = 1-options[node];
                    queue.add(neighbor);
                }
            }
        }
        return true;
    }

    public boolean possibleBipartition(int n, int[][] dislikes) {
        //create graph
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for(int[] dislike: dislikes) {
            int first = dislike[0];
            int second = dislike[1];
            if(!graph.containsKey(first)) {
                graph.put(first, new HashSet<>());
            }
            graph.get(first).add(second);
            if(!graph.containsKey(second)){
                 graph.put(second, new HashSet<>());
            }
            graph.get(second).add(first);
        }
        int[] options = new int[n+1]; // 0 or 1 ==> 2 groups
        Arrays.fill(options, -1);
        for(int i=1;i<=n; i++) {
            if(options[i] == -1) {
                if(!bfs(i, graph, options)){
                    return false;
                }
            }
        }
        return true;
    }
}
