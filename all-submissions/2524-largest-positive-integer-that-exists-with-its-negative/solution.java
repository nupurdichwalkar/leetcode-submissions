class Solution {
    public int findMaxK(int[] nums) {
        int currNegativeMin = 0;
        int maxK = -1;
        Set<Integer> mySet = new HashSet<>();
        for(int num : nums) {
            mySet.add(num);
        }
        for(int num : nums) {
            if (num < 0) {
                if (num < currNegativeMin) {
                    if (mySet.contains(num*-1)) {
                        currNegativeMin = num;
                        maxK = num*-1;
                    }
                }
            } 
        }
        return maxK;
        
    }
}
