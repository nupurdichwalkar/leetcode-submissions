class WordDistance {

    Map<String, List<Integer>> wordMap = new HashMap<>();

    public WordDistance(String[] wordsDict) {
        for(int i=0; i< wordsDict.length; i++) {
            String s = wordsDict[i];
            if(!wordMap.containsKey(s)) {
                wordMap.put(s, new ArrayList<>());
            }
            wordMap.get(s).add(i);
        }
    }
    
    public int shortest(String word1, String word2) {
        List<Integer> word1List = wordMap.get(word1);
        List<Integer> word2List = wordMap.get(word2);
        int shortestDistance = Integer.MAX_VALUE;
        for(int i=0; i<word1List.size(); i++) {
            for (int j=0;j<word2List.size(); j++) {
                int currDistance = Math.abs(word1List.get(i) - word2List.get(j));
                shortestDistance = Math.min(shortestDistance, currDistance);
            }
        }
        return shortestDistance;
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(wordsDict);
 * int param_1 = obj.shortest(word1,word2);
 */
