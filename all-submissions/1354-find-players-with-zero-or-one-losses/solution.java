class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        List<List<Integer>> answer = new ArrayList<>();
        List<Integer> answer0 = new ArrayList<>();
        List<Integer> answer1 = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<matches.length; i++) {
            map.put(matches[i][1], map.getOrDefault(matches[i][1], 0) + 1);
            map.put(matches[i][0], map.getOrDefault(matches[i][0],0));
        }
        for (Map.Entry<Integer, Integer> entry: map.entrySet()){
            if (entry.getValue() == 0) {
                answer0.add(entry.getKey());
            }
            if (entry.getValue() == 1) {
                answer1.add(entry.getKey());
            }
        }
        Collections.sort(answer0);
        Collections.sort(answer1);
        answer.add(answer0);
        answer.add(answer1);
        return answer;
    }
}
