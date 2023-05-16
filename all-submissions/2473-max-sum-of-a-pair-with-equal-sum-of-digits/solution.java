class Solution {
    public int maximumSum(int[] nums) {
        
        Map<Integer, Integer> numsMap = new HashMap<>();
        int maxSum = -1;
        for (int num: nums) {
            int sumOfDigits = calculateDigitSum(num);
            if (numsMap.containsKey(sumOfDigits)) {
                maxSum = Math.max(maxSum, numsMap.get(sumOfDigits) + num);
            }
            numsMap.put(sumOfDigits, Math.max(numsMap.getOrDefault(sumOfDigits, 0), num));
        }
        return maxSum;
    }

    private int calculateDigitSum(int num) {
        int sum = 0;
        while(num>0) {
            sum += num%10;
            num = num/10;

        }
        return sum;
    }
}
