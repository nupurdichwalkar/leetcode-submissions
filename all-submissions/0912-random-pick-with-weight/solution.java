class Solution {

    private int sum = 0;
    private int[] prefixSums;

    public Solution(int[] w) {
        this.prefixSums = new int[w.length];
        this.prefixSums[0] = w[0];

        for (int i = 1; i < w.length; ++i) {
            this.prefixSums[i] = this.prefixSums[i-1] + w[i];
        }
        this.sum = prefixSums[w.length -1];
    }
    
    public int pickIndex() {
        double target = this.sum * Math.random();
        for(int i=0; i<this.prefixSums.length; i++) {
            if(target < this.prefixSums[i]) {
                return i;
            }
        }
        return this.prefixSums.length-1;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
