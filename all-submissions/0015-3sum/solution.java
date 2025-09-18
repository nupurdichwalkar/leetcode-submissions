public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0; i<nums.length-1;i++) {
            int j = i+1;
            int k = nums.length-1;
            while(j<k) {
                int tripletSum = nums[i] + nums[j] + nums[k];
                if (tripletSum == 0) {
                    answer.add(new ArrayList<>(Arrays.asList( nums[i],nums[j],nums[k])));
                    j++;
                    k--;
                    while(j<k && nums[j] == nums[j-1]) j++;
                    while(j<k && nums[k] == nums[k+1]) k--;
                } else {
                    if(tripletSum > 0){
                        k--;
                    } else {
                        j++;
                    }
                }
            }
            while (i + 1 < nums.length && nums[i + 1] == nums[i]) i++;
        }
        return answer;
        // Your code goes here
    }
}
