class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] mincost = new int[cost.length+1];
        mincost[0] = cost[0];
        mincost[1] = cost[1];
        for(int i = 2; i < mincost.length; i++)
        {
            int price = (i==cost.length) ? 0 : cost[i];
            mincost[i] = Math.min(mincost[i-1] + price, mincost[i-2] + price);
        }
        return mincost[cost.length];
    }
}
