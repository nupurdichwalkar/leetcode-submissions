class Solution {
    public boolean judgeCircle(String moves) {
        int row = 0;
        int col = 0;
        char[] movesChar = moves.toCharArray();
        for (char c: movesChar) {
            switch(c){
                case 'U':
                    row--;
                    break;
                case 'D':
                    row++;
                    break;
                case 'L':
                    col--;
                    break;
                case 'R':
                    col++;
                    break;
            }
        }
        if (row == 0 && col == 0) {
            return true;
        }
        return false;
        
    }
}
