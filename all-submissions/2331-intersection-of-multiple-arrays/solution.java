class Solution {
    public List<Integer> intersection(int[][] nums) {
        List<Integer> answer = new ArrayList<>();
        int count = nums.length;
        Map<Integer, Integer> myMap = new HashMap<>();
        for (int[] eachArr: nums) {
            for (int num: eachArr) {
                myMap.put(num, myMap.getOrDefault(num, 0) + 1);
            }
        }
        for (Map.Entry<Integer, Integer> entry: myMap.entrySet()) {
            int num = entry.getKey();
            if (myMap.get(num) == count){
                answer.add(num);
            }
        }
        if (answer != null) Collections.sort(answer);
        return answer;
        
    }
}
