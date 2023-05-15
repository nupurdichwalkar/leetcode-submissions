class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        Map<Integer, Integer> lostMap = new HashMap<>();
        for (int[] match: matches){
            lostMap.put(match[0], lostMap.getOrDefault(match[0],0));
            lostMap.put(match[1], lostMap.getOrDefault(match[1],0) + 1);   
        }
        List<Integer> zeroLoses = new ArrayList<>();
        List<Integer> oneLoss = new ArrayList<>();
        for (Map.Entry<Integer, Integer> player: lostMap.entrySet()) {
            int key = player.getKey();
            int value = player.getValue();
            if (value == 0) {
                zeroLoses.add(key);
            }
            if(value == 1) {
                oneLoss.add(key);
            }
        }
        Collections.sort(zeroLoses);
        Collections.sort(oneLoss);
        return new ArrayList<List<Integer>>() {
            {
                add(zeroLoses);
                add(oneLoss);
            }
        };
        
    }
}
