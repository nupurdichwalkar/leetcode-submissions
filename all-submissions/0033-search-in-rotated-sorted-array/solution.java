class Solution {
    public int search(int[] nums, int target) {

       int left =0;
       int right = nums.length -1;
       while(left <= right) {
        int mid = left + (right-left)/2;
        if (nums[mid] > nums[nums.length-1]){
            left = mid+1;
        } else {
            right = mid-1;
        }
       }
       int answer = binarySearch(nums, target, 0, left-1);
       return answer == -1 ? binarySearch(nums, target, left, nums.length-1) : answer;
    }

    public int binarySearch(int[] nums, int target, int left, int right) {
        while(left <= right) {
            int mid = left + (right-left)/2;
            if(nums[mid] == target) {
                return mid;
            }
            if(nums[mid] > target) {
                right = mid-1;
            } else {
                left = mid +1;
            }
        }
        return -1;
    }

}
