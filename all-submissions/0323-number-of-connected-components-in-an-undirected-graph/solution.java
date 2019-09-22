class UnionFind{
    private int[] parent;
    private int connectedComp;
    
    public UnionFind(int n){
        parent = new int[n];
        for(int i =0; i<n;i++){
            parent[i]=i;
        }
    }
    
    public int find(int x){
        if(parent[x]==x)
            return x;
       return parent[x] = find(parent[x]);
    }
    
    public void union(int a, int b){
        int groupA = find(a);
        int groupB = find(b);
        if(groupA!=groupB){
            parent[groupA]=groupB;
            connectedComp--;
        }
    }
    
    public void setConnectedComp(int n){
        this.connectedComp = n;
    }
    public int getConnectedComp(){
        return this.connectedComp;
    }
    
}

class Solution {
    public int countComponents(int n, int[][] edges) {
        if(n==0)
            return 0;
        if(edges.length==0||edges[0].length==0)
            return n;
        UnionFind comp = new UnionFind(n);
        int r = edges.length;
        comp.setConnectedComp(n);
        for(int i=0; i<r;i++){
            comp.union(edges[i][0], edges[i][1]);
        }
        return comp.getConnectedComp();
    }
}
