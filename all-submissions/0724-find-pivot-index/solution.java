class Solution {
    public int pivotIndex(int[] nums) {
        int leftSum=0;
        int rightSum =0;
        for(int i =0; i<nums.length; i++)
        {
        leftSum = leftsum(i,nums);
        rightSum = rightsum(i,nums);
        
        if(leftSum == rightSum)
            return i;
        }
        return -1;
    }
    
    public int leftsum(int i,int[]nums)
    {
        int  sum =0;
        for(int k = i-1; k>=0; k--)
        {
            sum += nums[k];
        }
        return sum;
    }
    
    public int rightsum(int i,int[]nums)
    {
        int  sum =0;
        for(int k = i+1; k<nums.length; k++)
        {
            sum += nums[k];
        }
        return sum;
    }
}
