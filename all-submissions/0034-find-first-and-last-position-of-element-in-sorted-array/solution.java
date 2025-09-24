class Solution {
    public int[] searchRange(int[] nums, int target) {
        int left =0;
        int right=nums.length-1;
        int startIndex = -1;
        int endIndex=-1;
        if(nums.length == 1) {
            if (target == nums[0]) {
                return new int[]{0,0};
            }
        }

        while(left<=right) {
            int mid = (left+right)/2;
            if(nums[mid] < target) {
                left = mid+1;
            } 
            else if(nums[mid] > target) {
                right = mid-1;
            } else if(nums[mid] == target) {
                int tempMid = mid;
                startIndex = mid;
                endIndex = mid;
                while(mid>=left){
                    if(nums[mid] == target) {
                        startIndex = mid;
                        mid--;
                    }
                    else{
                        break;
                    }
                }
                mid = tempMid;
                while(mid<=right){
                    if(nums[mid] == target) {
                        endIndex = mid;
                        mid++;
                    }
                    else{
                        break;
                    }
                }
                break;
            }
        }
        return new int[]{startIndex, endIndex};

        
    }
}
