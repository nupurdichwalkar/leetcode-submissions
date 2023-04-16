class Solution {
    public int minStoneSum(int[] piles, int k) {
        int totalSum = 0;
        PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i=0; i<piles.length; i++) {
            totalSum += piles[i];
            heap.add(piles[i]);
        }
        while(k>0) {
            int num = heap.remove();
            int floorVal = (int) num/2;
            int newNum = num-floorVal;
            heap.add(newNum);
            totalSum -= floorVal;
            k--;
        }
        return totalSum;
        
    }
}
