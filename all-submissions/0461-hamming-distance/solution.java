class Solution {
    public int hammingDistance(int x, int y) {
        
        int w = x^y;
        return Integer.bitCount(w);
    }
}
