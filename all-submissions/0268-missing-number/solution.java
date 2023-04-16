class Solution {
    public int missingNumber(int[] nums) {
        // Set<Integer> mySet = new HashSet<>();
        // for (int num: nums) {
        //     mySet.add(num);
        // }
        // for (int i = 0; i<= nums.length; i++) {
        //     if (!mySet.contains(i)) {
        //         return i;
        //     }
        // }
        // return -1;
        int length = nums.length;
        int total = (int)(length*(length+1))/2;
        int arrSum = 0;
        for (int num: nums) {
            arrSum += num;
        }
        return total-arrSum;
        
        
    }
}
