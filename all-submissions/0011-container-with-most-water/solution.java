class Solution {
    public int maxArea(int[] height) {
        int currArea = -1;
        int maxArea = currArea;
        int i = 0;
        int j = height.length-1;

        while (i < j) {
            currArea = (j-i) * Math.min(height[i], height[j]);
            maxArea = Math.max(maxArea, currArea);
            if (height[i] < height[j]) {
                i++;
            }
            else {
                j--;
            }
        }
        return maxArea;

        // for(int i=0; i<height.length-1; i++){
        //     for (int j = i+1 ; j<height.length; j++) {
        //         currArea = (j-i) * Math.min(height[i], height[j]);
        //         if (currArea > maxArea) {
        //             maxArea = currArea;
        //         }
        //     }
        // }
        // return maxArea;
        
    }
}
