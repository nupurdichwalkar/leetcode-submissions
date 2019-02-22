class Solution {
    public int[][] kClosest(int[][] points, int K) {
        int[] temp = new int[points.length];
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        int[][] ans = new int[K][2];
        for(int i = 0; i< points.length; i++)
        {
            int dist = points[i][0]*points[i][0] + points[i][1]*points[i][1];
            map.put(dist,i);
            temp[i] = dist;
        }
        Arrays.sort(temp);
        for(int j = 0; j<K; j++)
        {
            ans[j][0] = points[map.get(temp[j])][0];
            ans[j][1] = points[map.get(temp[j])][1];
        }
        return ans; 
    }
}
