class Solution {
    public int trap(int[] height) {
        if(height== null || height.length == 0){
            return 0;
        }
        int totalamount = 0;
        int[] leftHighest = new int[height.length+1];
        leftHighest[0] = 0;
        for(int i = 0; i < height.length;i++){
            leftHighest[i+1] = Math.max(leftHighest[i],height[i]);
        }
        int[] rightHighest = new int[height.length+1];
        rightHighest[height.length-1] = 0;
        for(int i=height.length-1; i >=0 ;i--){
            rightHighest[i] = Math.max(rightHighest[i+1],height[i]);
        }
        for(int i = 0; i<height.length; i++){
            totalamount += Math.min(leftHighest[i],rightHighest[i]) > height[i] ? Math.min(leftHighest[i],rightHighest[i]) - height[i] : 0;
        }
        return totalamount;
    }
}
