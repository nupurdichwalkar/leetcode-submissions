class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int firstRow = 0;
        int lastRow = matrix.length-1;
        while(firstRow <= lastRow) {
            int midRow = firstRow + (lastRow-firstRow) /2;
            if (matrix[midRow][0] == target) {
                return true;
            } else if (matrix[midRow][0] < target && matrix[midRow][matrix[0].length-1] >= target)  {
                System.out.println("Here");
               return binarySearch(matrix[midRow], target);
            } else if (matrix[midRow][0] < target) {
                firstRow = midRow + 1;
            } else if (matrix[midRow][0] > target) {
                lastRow = midRow - 1;
            }
        }
        return false;
    }

    private boolean binarySearch(int[] nums, int target) {
        System.out.println("binarySearch");
        if (nums.length == 0) return false;
        int left = 0;
        int right = nums.length-1;
        while(left <= right) {
            int mid = left + (right-left) /2;
            if (nums[mid] == target) {;
                return true;
            }
            if (nums[mid] > target) {
                right = mid-1;
            }
            if (nums[mid] < target) {
                left = mid+1;
            }
        }
        return false;
    }

}
