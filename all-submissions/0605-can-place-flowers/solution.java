class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if(flowerbed == null) return false;
        if(flowerbed.length == 0 && n >= 1) return false;
        if(flowerbed.length == 1) {
            if(flowerbed[0] == 1 && n>=1) return false;
            if(flowerbed[0] == 1 && n==0) return true;
            if(flowerbed[0] == 0 && n<=1) return true;
            return false;
        }
        if(n == 0) return true;
        int count = 0;
        for(int i=0; i<flowerbed.length; i++) {
            if(i>0 && i<flowerbed.length-1) {
                if(flowerbed[i] == 0 && flowerbed[i-1] == 0 && flowerbed[i+1] == 0) {
                    count++;
                    flowerbed[i] = 1;
                }
                
            } else {
                if(i==0 && flowerbed[i] == 0 && flowerbed[i+1] == 0) {
                    count++;
                    flowerbed[i] = 1;
                }
                if(i==flowerbed.length-1 && flowerbed[i] == 0 && flowerbed[i-1] == 0) {
                    count++;
                    flowerbed[i] = 1;
                }
            }
        }
        if (count >= n) return true;
        return false;

    }
}
