class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int mayPlace = 0;
        if(flowerbed.length == 1 && flowerbed[0] == 0 && n <= 1) {
            return true;
        }
        if(flowerbed.length == 1 && flowerbed[0] == 1) {
            if(n==0) return true;
            return false;
        }
        for (int i=0; i<flowerbed.length; i++) {
            if (flowerbed[i] == 0) {
                if (i == 0 && flowerbed[i+1] == 0) {
                    mayPlace++;
                    flowerbed[i] = 1;
                } else {
                    if (i== flowerbed.length-1 && flowerbed[i-1] == 0){
                        flowerbed[i] = 1;
                        mayPlace++;
                    } else 
                    if(i!= flowerbed.length-1 && i!=0 && flowerbed[i+1] == 0 && flowerbed[i-1] == 0){
                        flowerbed[i] = 1;
                        mayPlace++;
                    }
                }
            }
        }

        if(mayPlace >= n) {
            return true;
        }
        return false;
    }
}
