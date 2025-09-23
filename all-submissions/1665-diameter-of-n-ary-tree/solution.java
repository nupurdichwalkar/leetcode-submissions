/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    
    public Node() {
        children = new ArrayList<Node>();
    }
    
    public Node(int _val) {
        val = _val;
        children = new ArrayList<Node>();
    }
    
    public Node(int _val,ArrayList<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {

    int answer =0;

    public int diameter(Node root) {
        if(root == null) return 0;
        maxDepth(root);
        return answer;
    }

    public int maxDepth(Node node) {
        if(node.children.size() == 0) return 0;
        List<Node> children = node.children;
        int maxHeight1 = 0, maxHeight2 = 0;
        for(Node child: children) {
            int parentDepth = maxDepth(child) + 1;
            if(parentDepth > maxHeight1){
                maxHeight2 = maxHeight1;
                maxHeight1 = parentDepth;
            } else if (parentDepth > maxHeight2){
                maxHeight2 = parentDepth;
            } 
            int max = maxHeight1 + maxHeight2;
            answer = Math.max(answer, max);
        }
        return maxHeight1;
        
    }
}
