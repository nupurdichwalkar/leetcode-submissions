class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        if (k == nums.length) {
            return nums;
        }

        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int i=0; i< nums.length; i++) {
            frequencyMap.put(nums[i], frequencyMap.getOrDefault(nums[i], 0) +1);
        }

        PriorityQueue<Integer> heap = new PriorityQueue<>((n1, n2) -> frequencyMap.get(n1) - frequencyMap.get(n2));

        for(int key: frequencyMap.keySet()) {
            heap.add(key);
            if (heap.size() > k) heap.remove();
        }
        int[] topK = new int[k];
        for(int i=0; i<k;i++){
            topK[i] = heap.remove();
        }
        return topK;

    }
}
