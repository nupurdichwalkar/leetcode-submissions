/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    Map<Integer, List<Integer>> graph;
    Set<Integer> visited;
    List<Integer> answer;

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        graph = new HashMap<>();
        buildGraph(root, null);
        answer = new ArrayList<>();
        visited = new HashSet<>();
        visited.add(target.val);
        dfs(target.val, 0, k);
        return answer;
    }

    public void dfs (int cur, int distance, int k) {
        if(distance == k) {
            answer.add(cur);
            return;
        }
        for(int neighbor: graph.getOrDefault(cur, new ArrayList<>())) {
            if(!visited.contains(neighbor)){
                visited.add(neighbor);
                dfs(neighbor, distance+1, k);
            }
        }
    }
    public void buildGraph(TreeNode cur, TreeNode parent){
        if (cur != null && parent != null) {
            if (graph.containsKey(cur.val)){
                List<Integer> curList = graph.get(cur.val);
                curList.add(parent.val);
                graph.put(cur.val, curList);
            } else {
                List<Integer> curList = new ArrayList<>();
                curList.add(parent.val);
                graph.put(cur.val, curList);
            }
            if (graph.containsKey(parent.val)){
                List<Integer> parentList = graph.get(parent.val);
                parentList.add(cur.val);
                graph.put(parent.val, parentList);
            } else {
                List<Integer> parentList = new ArrayList<>();
                parentList.add(cur.val);
                graph.put(parent.val, parentList);
            }
        }
        if (cur.left != null) {
            buildGraph(cur.left, cur);
        }
        if (cur.right != null) {
            buildGraph(cur.right, cur);
        }
    }
}
