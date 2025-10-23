class Solution {
    
    public List<String> findRepeatedDnaSequences(String s) {
        Map<String, Integer> repeatedSeqMap = new HashMap<>();
        for(int i=0;i<s.length()-9;i++) {
            String subStr = s.substring(i, i+10);
            repeatedSeqMap.put(subStr, repeatedSeqMap.getOrDefault(subStr, 0)+1);
        }
        List<String> answer = new ArrayList<>();
        for(String key: repeatedSeqMap.keySet()) {
            if(repeatedSeqMap.get(key) > 1) {
                answer.add(key);
            }
        }
        return answer;
    }
}
