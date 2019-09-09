class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i =0; i<order.length();i++){
            map.put(order.charAt(i),i);
        }
        String word1,word2;
        int size;
        if(words.length == 1)
            return true;
        for(int j = 0; j<words.length-1;j++)
        {
            if(map.get(words[j].charAt(0)) < map.get(words[j+1].charAt(0)))
                continue;      
            if(map.get(words[j].charAt(0))>map.get(words[j+1].charAt(0)))
                return false;
            word1 = words[j];
            word2 = words[j+1];
            size = word1.length();
            if(size > word2.length())
            {
                 if(map.get(word1.charAt(0)) == map.get(word2.charAt(0)))
                    return false;
                size = word2.length();
            }
            for(int k = 1; k < size; k++)
            {
              if(map.get(word1.charAt(k)) > map.get(word2.charAt(k)))
                 return false;
            }
          }
        return true;
    }
}
