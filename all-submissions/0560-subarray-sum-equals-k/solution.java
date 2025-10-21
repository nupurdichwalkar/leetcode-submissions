class Solution {
    public int subarraySum(int[] nums, int k) {
        int[] prefixSum = new int[nums.length+1];
        prefixSum[0] = 0;
        for(int i=1; i<= nums.length; i++) {
            prefixSum[i] = prefixSum[i-1] + nums[i-1];
        }
        int answer = 0;
        for(int i=0; i<nums.length;i++){ // subarraylengths
            for(int j=i+1; j<=nums.length;j++) {
                int currSum = prefixSum[j] - prefixSum[i];
                if (currSum == k) {
                    answer++;
                } 
            }
        }
        return answer;
    }
}
