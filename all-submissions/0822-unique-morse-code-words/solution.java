class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String[] morse = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."}; 
    HashSet<String> UniqueCode = new HashSet<String>();
        for(String word : words)
        {
            StringBuilder code = new StringBuilder();
            for(char c : word.toCharArray())
                code.append(morse[c-'a']);   
            UniqueCode.add(code.toString());
        }
        return UniqueCode.size();
 }
}
