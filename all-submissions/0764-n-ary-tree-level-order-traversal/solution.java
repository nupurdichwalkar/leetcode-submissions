/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ans = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        if(root!=null)
        {
            q.offer(root);
        }
        Node cur;
        while(!q.isEmpty())
        {
            int size = q.size();
            List<Integer> temp = new LinkedList<>();
            for(int i = 0; i<size; i++)
            {
                cur = q.poll();
                temp.add(cur.val);
                for(Node child : cur.children)
                {
                    q.offer(child);
                }
            }
            ans.add(temp);
        }
        return ans;
    }
}
