class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> answer = new ArrayList<>();
        int length = graph.length;
        List<Integer> curr = new ArrayList<>();
        curr.addLast(0);
        backtrack(0, graph, length, answer, curr);
        return answer;
    }

    public void backtrack(int currNode, int[][] graph, int length, List<List<Integer>> answer, List<Integer> curr) {
        if (currNode == length -1) {
            answer.add(new ArrayList<Integer>(curr));
            return;
        }
        for(int neighbor: graph[currNode]) {
            curr.addLast(neighbor);
            backtrack(neighbor, graph, length, answer,curr);
            curr.removeLast();
        }
    }
}
