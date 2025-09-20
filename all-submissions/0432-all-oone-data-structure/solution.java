class AllOne {

    Map<String, Integer> frequencyMap;
    PriorityQueue<Pair<String, Integer>> minHeap;
    PriorityQueue<Pair<String, Integer>> maxHeap;

    public AllOne() {
        frequencyMap = new HashMap<>();
        minHeap = new PriorityQueue<>((a,b) -> a.getValue() - b.getValue());
        maxHeap = new PriorityQueue<>((a,b) -> b.getValue() - a.getValue());
        
    }
    
    public void inc(String key) {
        frequencyMap.put(key, frequencyMap.getOrDefault(key, 0)+1);
        minHeap.add(new Pair(key, frequencyMap.get(key)));
        maxHeap.add(new Pair(key, frequencyMap.get(key)));
    }
    
    public void dec(String key) {
        frequencyMap.put(key, frequencyMap.get(key)-1);
        if(frequencyMap.get(key) == 0){
            frequencyMap.remove(key);
        } else {
            minHeap.add(new Pair(key, frequencyMap.get(key)));
            maxHeap.add(new Pair(key, frequencyMap.get(key)));
        }
    }
    
    public String getMaxKey() {
        while(!maxHeap.isEmpty()){
            Pair<String, Integer> pair = maxHeap.peek();
            if(pair.getValue() == frequencyMap.get(pair.getKey())) {
                return pair.getKey();
            } else {
                maxHeap.poll();
            }
        }
        return "";
        
    }
    
    public String getMinKey() {
        while(!minHeap.isEmpty()){
            Pair<String, Integer> pair = minHeap.peek();
            if(pair.getValue() == frequencyMap.get(pair.getKey())) {
                return pair.getKey();
            } else {
                minHeap.poll();
            }
        }
        return "";
        
    }
}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */
