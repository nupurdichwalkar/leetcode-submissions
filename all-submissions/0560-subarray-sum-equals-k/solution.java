class Solution {
    public int subarraySum(int[] nums, int k) {
        if (nums==null||nums.length==0)
            return 0;
        int left = 0;
        int right = 0;
        int count=0;
        while(left<nums.length)
        {
            int sum = 0;
            while(right<nums.length)
            {
                sum+=nums[right];
                right++;
            if(sum==k){
                count++;
              }
            }
                left++;
                right=left;
        }
        return count;
    }
}
