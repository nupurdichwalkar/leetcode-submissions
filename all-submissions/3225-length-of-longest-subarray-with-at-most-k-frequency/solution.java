class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int maxSubArray = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int left = 0;
        int right = 0;
        while(right< nums.length) {
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
            while(map.get(nums[right]) > k) {
                map.put(nums[left], map.get(nums[left])-1);
                left++;
            }
            maxSubArray = Math.max(maxSubArray, right-left+1);
            right++;
        }
        return maxSubArray;
        
    }
}
