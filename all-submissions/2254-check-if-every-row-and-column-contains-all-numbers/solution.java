class Solution {
    public boolean checkValid(int[][] matrix) {
        int n = matrix.length;
        
        for(int i =0;i<n;i++) {
            Set<Integer> numberSet = new HashSet<>();
            for(int j=0; j<n; j++) {
                if(matrix[i][j] >n || matrix[i][j] < 1) {
                    return false;
                } 
                numberSet.add(matrix[i][j]);
            }
            if(numberSet.size() != n){
                return false;
            }
        }


        for(int i =0;i<n;i++) {
            Set<Integer> numberSet = new HashSet<>();
            for(int j=0; j<n; j++) {
                if(matrix[j][i] >n || matrix[j][i] < 1) {
                    return false;
                } 
                numberSet.add(matrix[j][i]);
            }
            if(numberSet.size() != n){
                return false;
            }
        }

        return true;
    }
}
