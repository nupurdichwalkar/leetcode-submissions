class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        char[] wordArr = word.toCharArray();
        char[] abbrArr = abbr.toCharArray();

        int i = 0;
        int j =0;
        while(i<wordArr.length && j<abbrArr.length) {
            if(wordArr[i] == abbrArr[j]) {
                i++;
                j++;
                continue;
            }
            if(!Character.isDigit(abbrArr[j])) return false;
            StringBuilder number = new StringBuilder();
            while(j<abbrArr.length && Character.isDigit(abbrArr[j])){
                number.append(abbrArr[j]);
                j++;
            }
            if(number.charAt(0) == '0') return false;
            int num = Integer.parseInt(number.toString());
            i=i+num;
        }
        if(i==wordArr.length && j==abbrArr.length) return true;
        return false;
    }
}
