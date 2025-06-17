class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int[] prefixSum = new int[nums.length];
        prefixSum[0] = nums[0];
        for(int i=1; i< nums.length;i++) {
            prefixSum[i] = prefixSum[i-1] + nums[i];
        }
        int maxScore=0;
        Map<Integer, Integer> map = new HashMap<>();
        int left = 0;
        int right = 0;
        while(right < nums.length) {
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
            while(map.get(nums[right]) > 1){
                map.put(nums[left], map.get(nums[left]) -1);
                left++;
            }
            maxScore = Math.max(maxScore, prefixSum[right]-prefixSum[left] + nums[left]);
            right++;
        }
        return maxScore;
        
    }
}
