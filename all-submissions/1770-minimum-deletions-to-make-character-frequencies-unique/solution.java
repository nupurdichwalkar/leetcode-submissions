class Solution {
    public int minDeletions(String s) {
        int deleteCount = 0;
        Map<Character, Integer> map = new HashMap<>();
        Set<Integer> seen = new HashSet<>();
        for (char c: s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (Map.Entry<Character, Integer> entry: map.entrySet()){
            int value = entry.getValue();
            while (seen.contains(value)) {
                value--;
                deleteCount++;
                if(value == 0) {
                    break;
                }
            }
            if (value!=0) {
                seen.add(value);
            }
        }
        return deleteCount;
    }
}
