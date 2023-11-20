class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        int currPtr = 0;
        int currCount = 0;
        for(int i = 0; i< abbr.length(); i++) {
            
            if(Character.isDigit(abbr.charAt(i))) {
                if(currCount == 0 && abbr.charAt(i) == '0') return false;
                    currCount = currCount*10 + Character.getNumericValue(abbr.charAt(i));
            }
            else {
                currPtr += currCount;
                if (currPtr< word.length() && abbr.charAt(i) != word.charAt(currPtr)) {
                    return false;
                }
                currPtr++;
                currCount=0;
            }
        }
        
        if (currPtr + currCount == word.length()) return true;
        return false;
    }
}
