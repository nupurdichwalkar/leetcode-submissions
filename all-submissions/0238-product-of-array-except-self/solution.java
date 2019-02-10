class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] output = new int[nums.length];
       int left=1; 
        int right =1;
        for(int i=0;i<nums.length;i++)
        {
            output[i] = 1 ;
        }
        for(int i=1;i<nums.length;i++)
        {
            left = left* nums[i-1];
            output[i] =  left;
        }
        for(int i=nums.length-2;i>=0;i--)
        {
            right = right * nums[i+1];
            output[i] *= right  ;
        }
        
        return output;
    }
}
