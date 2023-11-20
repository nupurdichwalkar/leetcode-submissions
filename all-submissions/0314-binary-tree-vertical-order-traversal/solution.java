/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> answer = new ArrayList<>();
        if (root == null) { return answer;}
        Map<Integer, ArrayList<Integer>> columnMap = new HashMap<>();
        Queue<Pair<TreeNode, Integer>> treeQueue = new LinkedList<>();
        int column = 0;
        treeQueue.add(new Pair(root, column));

        while(!treeQueue.isEmpty()) {
            Pair<TreeNode, Integer> currPair = treeQueue.poll();
            TreeNode node = currPair.getKey();
            column = currPair.getValue();
            if (node != null) {
                if(!columnMap.containsKey(column)) {
                    columnMap.put(column, new ArrayList<>());
                }
                columnMap.get(column).add(node.val);
            } 
            if (node.left != null) {
                treeQueue.add(new Pair(node.left, column-1));
            }
            if (node.right != null) {
                treeQueue.add(new Pair(node.right, column+1));
            }
        }

        List<Integer> sortedKeys = new ArrayList<Integer>(columnMap.keySet());
        Collections.sort(sortedKeys);
        for(int key: sortedKeys) {
            answer.add(columnMap.get(key));
        }
        return answer;
    }
}
