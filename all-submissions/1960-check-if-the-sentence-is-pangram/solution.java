class Solution {
    public boolean checkIfPangram(String sentence) {
        int[] charArr = new int[26];
        for (int i=0; i<sentence.length(); i++) {
            char c = sentence.charAt(i);
            int index = c - 'a';
            charArr[index]++;
        }
        for (int num: charArr){
            if(num ==0) {
                return false;
            }
        }
        return true;
        
    }
}
