class Solution {

    public int minDistanceRecur(String word1, String word2, int word1index, int word2index, int[][] dp) {
        if(word1index == word1.length()) {
            return word2.length()-word2index;
        }
        if(word2index == word2.length()) {
            return word1.length() - word1index;
        }
        if (dp[word1index] [word2index] != 0){
            return dp[word1index][word2index];
        }
        if (word1.charAt(word1index) == word2.charAt(word2index)) {
            return minDistanceRecur(word1, word2, word1index+1, word2index+1, dp);
        }
        int insert = minDistanceRecur(word1, word2, word1index, word2index+1, dp);
        int delete = minDistanceRecur(word1, word2, word1index +1, word2index, dp);
        int replace = minDistanceRecur(word1, word2, word1index+1, word2index+1, dp);

        dp[word1index][word2index] = Math.min(insert, Math.min(delete, replace)) + 1;
        return dp[word1index][word2index];
    }

    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length()][word2.length()];
        return minDistanceRecur(word1, word2, 0, 0, dp);
    }
}
