class Solution {

    private int getPeak(int[] nums, int l, int r) {
        if (l == r) return l;
        int mid = (l+r)/2;
        if (nums[mid] > nums[mid+1]) {
            return getPeak(nums, l, mid);
        } 
        return getPeak(nums, mid+1, r);
    }

    public int findPeakElement(int[] nums) {
        int l = 0;
        int r = nums.length-1;
        if (nums.length == 0) return -1;
        if (nums.length == 1) return 0;
        return getPeak(nums, l, r);
    }
}
