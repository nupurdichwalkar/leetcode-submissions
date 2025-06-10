class Solution {
    public int[] getAverages(int[] nums, int k) {
        if(k==0) return nums;
        long[] prefixSums = new long[nums.length];
        int[] answer = new int[nums.length];
        Arrays.fill(answer, -1);
        int width = k*2+1;
        if(nums.length < width) {
            return answer;
        }
        prefixSums[0] = nums[0];
        for(int i = 1; i<nums.length; i++) {
            prefixSums[i] = prefixSums[i-1] + nums[i];
        }
        
        for(int i = k; i< nums.length-k;++i) {
            answer[i] = (int)((prefixSums[i+k] - prefixSums[i-k] + nums[i-k])/width); 
        }
        return answer;
        
    }
}
