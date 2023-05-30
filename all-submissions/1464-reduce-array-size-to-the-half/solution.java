class Solution {
    public int minSetSize(int[] arr) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num: arr) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        List<Integer> countList = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry: countMap.entrySet()) {
            int val = entry.getValue();
            countList.add(val);
        }
        int l = arr.length;
        Collections.sort(countList, Collections.reverseOrder());
        int answer = 0;
        int sum = arr.length/2;
        int currSum = 0;
        for (int count: countList) {
            currSum += count;
            answer++;
            if(currSum >= sum) {
                break;
            }
        }
        return answer;
        
    }
}
