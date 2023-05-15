class Solution {
    public int countElements(int[] arr) {
        Set<Integer> mySet = new HashSet<>();
        for (int num: arr) {
            mySet.add(num);
        }
        int answer = 0;
        for(int num: arr) {
            if (mySet.contains(num+1)) {
                answer++;
            }
        }
        return answer;
        
    }
}
