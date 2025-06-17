class Solution {
    public String frequencySort(String s) {
        int maxFreq = 0;
        Map<Character, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for(char c: s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
            maxFreq = Math.max(maxFreq, map.get(c));
        }
        while(maxFreq>0){
            for(char key: map.keySet()) {
                if(map.get(key) == maxFreq){
                    for(int i=1;i<=maxFreq; i++){
                        sb.append(key);
                    }
                }
            }
            maxFreq--;
        }
        return sb.toString();
    }
}
