class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums == null || nums.length ==0) return 0;
        if(nums.length ==1) return 1;
        Set<Integer> set = new HashSet<>();
        int smallest = Integer.MAX_VALUE;
        int largest = Integer.MIN_VALUE;
        int answer = 1;
        for(int num: nums){
            smallest = Math.min(smallest, num);
            largest = Math.max(largest, num);
            set.add(num);
        }
        for(int num: set){
            if(!set.contains(num-1)){
                int currentNum = num;
                int currConsecutive = 0;
                while(set.contains(currentNum)){
                    currConsecutive++;
                    currentNum++;
                }
                answer = Math.max(answer, currConsecutive);
            }
        }
        return answer;
    }
}

