class Solution {
    public int[][] imageSmoother(int[][] img) {
        int m = img.length;
        int n = img[0].length;
        // Create a new image of the same dimension as the input image.
        int[][] smoothImg = new int[m][n];

        for(int i=0; i<m;i++) {
            for(int j=0;j<n;j++) {
                int validCells = 0;
                int currSum =0;
                for(int x = i-1; x<=i+1;x++ ) {
                    for(int y = j-1; y<=j+1;y++) {
                        if(x>=0 && x<m && y>=0 && y<n){
                            validCells +=1;
                            currSum += img[x][y];
                        }
                    }
                }
                smoothImg[i][j] = currSum/validCells;
            }
        }
        return smoothImg;
    }
}
