class Solution {
    public int minStoneSum(int[] piles, int k) {
        
        PriorityQueue<Integer> pilesQueue = new PriorityQueue<>(Comparator.reverseOrder());
        for(int pile: piles) {
            pilesQueue.add(pile);
        }
        int operationsCount = 0;
        for(int i=0; i<k;i++) {
            if(operationsCount == k) {
                break;
            }
            operationsCount++;
            int pile = pilesQueue.remove();
            int newPile = (int)Math.ceil((double)pile/2);
            pilesQueue.add(newPile);
        }
        int answer = 0;
        for(int pile: pilesQueue) {
            answer += pile;
        }
        return answer;
    }
}
