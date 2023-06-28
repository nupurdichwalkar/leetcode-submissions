class Solution {
    public boolean checkIfPangram(String sentence) {
        Set<Character> set = new HashSet<>();
        for (char c: sentence.toCharArray()){
            if(!set.contains(c)) {
                set.add(c);
            }
        }
        if(set.size() == 26) {
            return true;
        }
        return false;
        // int[] charArr = new int[26];
        // for (int i=0; i<sentence.length(); i++) {
        //     char c = sentence.charAt(i);
        //     int index = c - 'a';
        //     charArr[index]++;
        // }
        // for (int num: charArr){
        //     if(num ==0) {
        //         return false;
        //     }
        // }
        // return true;
        
    }
}
