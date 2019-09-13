class Solution {
    public int search(int[] nums, int target) {
        if(nums.length==0||nums==null)
            return -1;
        return binarySearch(nums,0,nums.length-1,target);
    } 
    public int binarySearch(int[] nums, int low, int high, int target){
        if(low>high)
            return -1;
        int mid = (low+high)/2;
        if(nums[mid]==target)
            return mid;
        if(nums[mid]<=nums[low] && nums[mid]<=nums[high])
        {
            if(target>nums[mid]&& target<=nums[high]){
                return binarySearch(nums,mid+1,high,target);
            }
            else{
                return binarySearch(nums,low,mid-1,target);
            }
        }
        else if(nums[mid]>=nums[low] && nums[mid]>=nums[high]){
            if(target<nums[mid] && target>=nums[low]){
                return binarySearch(nums,low,mid-1,target);
            }
            else{
                return binarySearch(nums,mid+1,high,target);
            }
        }
        else{
            if(target<nums[mid])
                return binarySearch(nums,low,mid-1,target);
            else
                return binarySearch(nums,mid+1,high,target);
        }
    }
}
