class NumArray {
    
    int[] prefixSum;
    int[] nums;


    public NumArray(int[] nums) {
        this.nums = nums;
        this.prefixSum = new int[nums.length];
        this.prefixSum[0] = nums[0];
        for(int i=1; i< nums.length; i++) {
            this.prefixSum[i] = this.prefixSum[i-1] + nums[i];
        }
    }
    
    public int sumRange(int left, int right) {
        
        return this.prefixSum[right] - this.prefixSum[left] + this.nums[left];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */
