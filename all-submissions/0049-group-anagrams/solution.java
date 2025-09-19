class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> stringMap = new HashMap<>();
        for(String str: strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String newString = new String(charArray);
            if(!stringMap.containsKey(newString)) {
                stringMap.put(newString, new ArrayList<>());
            }
            stringMap.get(newString).add(str);
        }

        List<List<String>> answer = new ArrayList<>();
        for(String key: stringMap.keySet()) {
            answer.add(stringMap.get(key));
        }

        return answer;
    }
}
