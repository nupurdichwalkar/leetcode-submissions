class Solution {
    public int twoEggDrop(int n) {
        int incr = 0;
        int minCount = 0;
        while(n>0){
            minCount++;
            incr++;
            n=n-incr;
        }
        return minCount;
    }
}
