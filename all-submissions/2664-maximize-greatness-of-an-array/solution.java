class Solution {
    public int maximizeGreatness(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        int left = 0;
        for(int right=0; right<nums.length; right++) {
            if(nums[right] == nums[left]) {
                continue;
            } else {
                count++;
                left++;
            }
        }
        return count;
    }
}
