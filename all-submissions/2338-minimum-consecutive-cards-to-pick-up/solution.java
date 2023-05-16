class Solution {
    public int minimumCardPickup(int[] cards) {
        Map<Integer, List<Integer>> cardMap = new HashMap<>();
        int minCount = Integer.MAX_VALUE;
        for (int i=0; i < cards.length; i++) {
            if (cardMap.containsKey(cards[i])) {
                List<Integer> cardMapList = cardMap.get(cards[i]);
                cardMapList.add(i);
                cardMap.put(cards[i], cardMapList);
            } else {
                int index = i;
                List<Integer> cardMapList = new ArrayList<Integer>(){
                    {
                        add(index);
                    }
                };
                cardMap.put(cards[i], cardMapList);
            }
        }
        for (Map.Entry<Integer, List<Integer>> cardEntry: cardMap.entrySet()) {
            List<Integer> cardIndexList = cardEntry.getValue();
            if (cardIndexList.size() >= 2) {
                for (int i = 0; i<cardIndexList.size()-1;i++) {
                    int diff = cardIndexList.get(i+1) - cardIndexList.get(i) + 1;
                    minCount = Math.min(minCount, diff);
                }
            }
        }
        return minCount == Integer.MAX_VALUE ? -1 : minCount;
    }
}
