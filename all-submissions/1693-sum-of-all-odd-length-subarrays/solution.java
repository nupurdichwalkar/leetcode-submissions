class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
        int subArrayLength = 1;
        int sum = 0;
        int[] prefixSum = new int[arr.length];
        prefixSum[0] = arr[0];
        for(int i=1; i<arr.length;i++) {
            prefixSum[i] = prefixSum[i-1] + arr[i];
        }
        while(subArrayLength <= arr.length) {
            for(int i=0, j=i+subArrayLength-1; i<arr.length && j<arr.length;i++,j++) {
                sum += prefixSum[j] - prefixSum[i] + arr[i];
            }
            subArrayLength +=2;
        }

        return sum;

    }
}
