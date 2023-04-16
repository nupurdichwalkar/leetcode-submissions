class Solution {
    public int halveArray(int[] nums) {

        int count = 0;
        double sum = 0;
        double halfSum = 0;
        double currSum = 0;
        PriorityQueue<Double> heap = new PriorityQueue<>(Comparator.reverseOrder());
        for(int num: nums) {
            heap.add((double)num);
            sum += (double)num;
        }
        currSum = sum;
        halfSum = sum/2;
        while(currSum > halfSum) {
            double halfVal = heap.remove()/2;
            currSum -= halfVal;
            heap.add(halfVal);
            count++;
        }
        return count;
        
    }
}
