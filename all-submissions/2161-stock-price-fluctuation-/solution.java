class StockPrice {

  Map<Integer, Integer> timePriceMap;
    int latestTimestamp;
    PriorityQueue<Pair<Integer, Integer>> maxPriceQueue;
    PriorityQueue<Pair<Integer, Integer>> minPriceQueue;

    public StockPrice(){
        this.timePriceMap = new HashMap<>();
        latestTimestamp = 0;
        maxPriceQueue = new PriorityQueue<>((a,b) -> b.getKey() - a.getKey());
        minPriceQueue = new PriorityQueue<>(Comparator.comparing(Pair::getKey));

    }
    void update(int timestamp, int price){
        timePriceMap.put(timestamp, price);
        latestTimestamp = Math.max(latestTimestamp, timestamp);
        maxPriceQueue.add(new Pair<>(price, timestamp));
        minPriceQueue.add(new Pair<>(price, timestamp));
    }


    int current(){
        return timePriceMap.get(latestTimestamp);
    }

    int maximum(){
        Pair<Integer, Integer> maxValPair = maxPriceQueue.peek();
        int maxVal = maxValPair.getKey();
        int mapPriceVal = timePriceMap.get(maxValPair.getValue());
        while(!maxPriceQueue.isEmpty() && maxVal != mapPriceVal){
            maxPriceQueue.poll();
            maxValPair =  maxPriceQueue.peek();
            maxVal = maxValPair.getKey();
            mapPriceVal = timePriceMap.get(maxValPair.getValue());
        }
        return maxVal;
    }

    int minimum(){
        Pair<Integer, Integer> minValPair = minPriceQueue.peek();
        int minVal = minValPair.getKey();
        int mapPriceVal = timePriceMap.get(minValPair.getValue());
        while(!minPriceQueue.isEmpty() && minVal != mapPriceVal){
            minPriceQueue.poll();
            minValPair =  minPriceQueue.peek();
            minVal = minValPair.getKey();
            mapPriceVal = timePriceMap.get(minValPair.getValue());
        }
        return minVal;
    }


}

/**
 * Your StockPrice object will be instantiated and called as such:
 * StockPrice obj = new StockPrice();
 * obj.update(timestamp,price);
 * int param_2 = obj.current();
 * int param_3 = obj.maximum();
 * int param_4 = obj.minimum();
 */
