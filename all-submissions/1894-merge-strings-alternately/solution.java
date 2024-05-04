class Solution {
    public String mergeAlternately(String word1, String word2) {
        if (word1 == null) {
            return word2;
        }
        if (word2 == null) {
            return word1;
        }


        int pointer1 = 0;
        int pointer2 = 0;
        
        StringBuilder result = new StringBuilder();

        while ( pointer1 < word1.length() && pointer2 < word2.length() ) {
            result.append(word1.charAt(pointer1));
            pointer1++;
            result.append(word2.charAt(pointer2));
            pointer2++;
        }

        if(!(pointer1<word1.length())) {
            while(pointer2<word2.length()){
                result.append(word2.charAt(pointer2));
                pointer2++;
            }
        } else {
            while(pointer1<word1.length()){
                result.append(word1.charAt(pointer1));
                pointer1++;
            }
        }

        return result.toString();

    }
}
