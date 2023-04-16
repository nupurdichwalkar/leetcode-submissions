class Solution {
    public boolean checkIfPangram(String sentence) {
        int[] arr = new int[26];
        for (int val: arr) {
            val = 0;
        }
        
        char[] charArray = sentence.toCharArray();
        for(char c: charArray) {
            arr[c-'a']++;
        }
        
        for(int val: arr) {
            if (val == 0) {
                return false;
            }
        }
        
        return true;
        
    }
}
