class Solution {
    public int longestConsecutive(int[] nums) {
        int answer = 0;
        if (nums.length == 0) return 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int num: nums) {
            queue.add(num);
        }
        int prevNum = queue.remove();
        int curr = 1;
        while(!queue.isEmpty()){
            int num = queue.remove();
            if (num == prevNum) {
                continue;
            }
            if (num - prevNum == 1) {
                curr++;
                answer = Math.max(answer, curr);
                prevNum = num;
            } else {
                curr = 1;
                prevNum = num;
            }
        }
        answer = Math.max(answer, curr);
        return answer;
        
    }
}
