class Solution {
    public int removeDuplicates(int[] nums) {
        int slowIndex = 0;
        int fastIndex = 1;
        if (nums.length <= 1) return nums.length;
        while(fastIndex < nums.length) {
            if(nums[fastIndex] == nums[slowIndex]){
                fastIndex++;
            }
            else {
                nums[++slowIndex] = nums[fastIndex];
            }
        }
        return slowIndex+1;
        
    }
}
