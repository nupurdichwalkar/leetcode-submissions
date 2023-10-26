class Solution {
    public int pivotIndex(int[] nums) {
        int index = 0;
        int leftSum = 0;
        int rightSum = 0; 
        for(int i = 1; i<nums.length; i++) {
            rightSum += nums[i];
        }
        while(index<nums.length && leftSum != rightSum){
            index++;
            leftSum += nums[index-1]; 
            if (index == nums.length) {
                rightSum = 0;
            } else {
                rightSum -= nums[index];
            }
            
        }
        return index == nums.length ? -1 : index;
        
    }
}
