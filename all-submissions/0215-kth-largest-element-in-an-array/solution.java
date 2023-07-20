class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());  
        int ans = 0;
        for (int num: nums) {
            queue.add(num);
        }
        while (k != 0){
            ans = queue.remove();
            k--;
        }
        return ans;
    }
}
