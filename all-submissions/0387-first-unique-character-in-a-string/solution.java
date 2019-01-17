class Solution {
    public int firstUniqChar(String s) {
      int [] charCount = new int[26];

    for(int i=0; i < s.length(); i++){
        char c = s.charAt(i);
        charCount[c - 'a'] = charCount[c - 'a'] + 1;
    }
    
    for(int i=0; i< s.length(); i++){
        char c = s.charAt(i);
        if(charCount[c - 'a'] == 1){
            return i;

        }
    }
    
    return -1;
    
}
}
