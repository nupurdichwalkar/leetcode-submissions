class Solution {
    public int maxProduct(int[] nums) {
        int result = nums[0];
        int product = 1;

        // Left to right
        for (int i = 0; i < nums.length; i++) {
            product *= nums[i];
            result = Math.max(result, product);
            if (product == 0) product = 1; // reset on zero
        }

        product = 1;
        // Right to left
        for (int i = nums.length - 1; i >= 0; i--) {
            product *= nums[i];
            result = Math.max(result, product);
            if (product == 0) product = 1;
        }

        return result;
    }
}
