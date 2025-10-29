class Solution {
    public int minCostII(int[][] costs) {
        if(costs.length == 0) return 0;
        int minCost = Integer.MAX_VALUE;
        for(int i=1; i<costs.length;i++){
            for(int j =0; j<costs[0].length; j++){
                int currMinCost = Integer.MAX_VALUE;
                for(int prevColor = 0; prevColor <costs[0].length; prevColor++) {
                    if(j == prevColor) continue;
                    currMinCost = Math.min(currMinCost, costs[i-1][prevColor]);
                }
                costs[i][j] += currMinCost;
            }
        }

        // Find the minimum in the last row.
        int min = Integer.MAX_VALUE;
        for (int c : costs[costs.length- 1]) {
            min = Math.min(min, c);
        }
        return min;

    }
}
