class Solution {
    public String convert(String s, int numRows) {
        // cols per section = numRows-1
        // number of chars in each section = 2*numRows-2
        // sections = ceil(n/(2*numRows-2))
        // cols = sections * cols per section
        if(numRows == 1) return s;

        if(numRows >= s.length()) return s;

        //int colPerSection = numRows -1;
        int charsPerSection = 2*numRows - 2;
        int n = s.length();
        //int sections = (int)Math.ceil(n/ charsPerSection);
        //int cols= sections*colPerSection;

        StringBuilder sb = new StringBuilder();
        for(int currRow=0;currRow<numRows; currRow++){
            int index = currRow;
            while(index< n) {
                sb.append(s.charAt(index));
                
                if(currRow !=0 && currRow != numRows-1 ){
                    int charsInBetween = charsPerSection - 2*currRow;
                    int nextIndex = index+charsInBetween;
                    if(nextIndex<n) {
                        sb.append(s.charAt(nextIndex));
                     }
                }
                
                index +=charsPerSection;

            }
        }
        return sb.toString();
    }
}
