class UnionFind{
    private int[] parent;
    private int circleCount;
    
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
            circleCount--;
        }
    }
    
    public void setCircleCount(int n){
        this.circleCount = n;
    }
    public int getCircleCount(){
        return this.circleCount;
    }
    
}


class Solution {
    public int findCircleNum(int[][] M) {
        if(M==null ||M.length==0 ||M[0].length == 0)
            return 0;
        int n = M.length;
        UnionFind friends = new UnionFind(n);
        friends.setCircleCount(n);
        for(int i=0;i<n;i++){
                    for(int j=0;j<n;j++){
                        if(M[i][j]==1&&i!=j)
                            friends.union(i,j);
                    }
        }
        return friends.getCircleCount();
    }
}
