class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        int finalMinRadius = Integer.MIN_VALUE;
        for(int i =0; i<houses.length; i++) {
            int minRadius = Integer.MAX_VALUE;
            for(int j = 0; j< heaters.length; j++) {
                minRadius = Math.min(minRadius, Math.abs(heaters[j] - houses[i]));
            }
            finalMinRadius = Math.max(finalMinRadius, minRadius);
        }
        return finalMinRadius;
        
    }
}
