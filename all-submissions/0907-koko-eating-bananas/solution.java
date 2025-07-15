class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int minSpeed = 1;
        int maxSpeed = Integer.MIN_VALUE;
        for (int pile : piles) {
            maxSpeed = Math.max(maxSpeed, pile);
        }
        while(minSpeed<maxSpeed) {
            int midSpeed = (minSpeed+maxSpeed)/2;
            int hoursSpent = 0;
            for(int pile: piles) {
                hoursSpent += Math.ceil((double) pile/midSpeed);
            }
            if(hoursSpent > h){
                minSpeed = midSpeed +1;
            } 
            else {
                maxSpeed = midSpeed;
            }
        }
        return minSpeed;
    }
}
