class Solution {
    public int countElements(int[] arr) {
        int answer = 0;
        Set<Integer> set = new HashSet<>();
        for (int i=0; i< arr.length; i++) {
            set.add(arr[i]);
        }
        for(int i=0; i<arr.length; i++) {
            if (set.contains(arr[i] +1)) {
                answer++;
            }
        }
        return answer;
        
    }
}
