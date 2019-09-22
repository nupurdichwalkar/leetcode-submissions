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
    
    public boolean union(int a, int b){
        int groupA = find(a);
        int groupB = find(b);
        boolean cycle = false;
        if(groupA!=groupB){
            parent[groupA]=groupB;
            connectedComp--;
        }
        else{
            cycle = true;
        }
        return cycle;
    }
     public void setConnectedComp(int n){
        this.connectedComp = n;
    }
    public int getConnectedComp(){
        return this.connectedComp;
    }
}

class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(n==1)
            return true;
        if(edges.length==0||edges[0].length==0)
            return false;
        UnionFind comp = new UnionFind(n);
        comp.setConnectedComp(n);
        int r = edges.length;
        boolean isCycle = false;
        for(int i=0; i<r;i++){
            isCycle = comp.union(edges[i][0], edges[i][1]);
            if (isCycle)
                return false;
        }
        if(comp.getConnectedComp()==1)
            return true;
        return false;
    }
}
