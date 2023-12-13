class Solution {
    public String customSortString(String order, String s) {
        Map<Character, Integer> countMap = new HashMap<>();
        for(char c: s.toCharArray()) {
            countMap.put(c, countMap.getOrDefault(c, 0) + 1);
        }
        StringBuilder answer = new StringBuilder();
        for(char c: order.toCharArray()) {
            while(countMap.containsKey(c)) {
                if (countMap.get(c) == 0) {
                    countMap.remove(c);
                } else {
                    answer.append(c);
                    countMap.put(c, countMap.get(c)-1);
                }
            }
        }
        for(Map.Entry<Character, Integer> entry: countMap.entrySet()){
            char key = entry.getKey();
            int value = entry.getValue();
            while(value != 0) {
                answer.append(key);
                countMap.put(key, value--);
            }
        }
        return answer.toString();
    }
}
