class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList();
        int l=0,r=0,sum=0;
        Arrays.sort(nums);
        for(int i=0; i<nums.length-1;i++){
            l=i+1;
            r= nums.length-1;
            while(l<r){
                sum = nums[i]+nums[l]+nums[r];
                if(sum==0){
                 result.add(Arrays.asList(nums[i],nums[l],nums[r]));     
                 l++;
                 r--;
                 while(l<r && nums[l]==nums[l-1]) l++;
                 while(l<r && nums[r]==nums[r+1]) r--;
                }
                else if(sum<0){
                    l++;
                }
                else
                    r--;
            }            
            while (i + 1 < nums.length && nums[i + 1] == nums[i]) 
            i++;
        }
        
        
        return result;
    }
}
