class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> magCountMap = new HashMap<>();
        for (char s: magazine.toCharArray()){
            magCountMap.put(s, magCountMap.getOrDefault(s, 0)+1);
        }
        for (char r : ransomNote.toCharArray()){
            if(!magCountMap.containsKey(r)){
                return false;
            }
            
            magCountMap.put(r, magCountMap.get(r)-1);
            if (magCountMap.get(r) == 0) {
                magCountMap.remove(r);
            }
        }
        return true;
        
    }
}
