class Solution {
    public int minimumCardPickup(int[] cards) {
        int minCardPick =  Integer.MAX_VALUE;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i=0; i<cards.length;i++) {
            if(!map.containsKey(cards[i])){
                map.put(cards[i], new ArrayList<>());
            }
            map.get(cards[i]).add(i);
        }
        for(int key: map.keySet()){
            List<Integer> arr = map.get(key);
            for(int i=0;i<arr.size()-1;i++) {
                int currMin = arr.get(i+1)- arr.get(i)+1;
                minCardPick = Math.min(minCardPick, currMin);
            }
        }
        if (minCardPick == Integer.MAX_VALUE) {
            return -1;
        }
        
        return minCardPick;
    }
}
