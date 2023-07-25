class Solution {
    public int largestAltitude(int[] gain) {
        int len = gain.length+1;
        int[] altitudes = new int[len];
        altitudes[0] = 0;
        int max = 0;
        for(int i= 1; i<len; i++) {
            altitudes[i] = altitudes[i-1] + gain[i-1];
            max = Math.max(altitudes[i], max);
        }
        return max;
    }
}
