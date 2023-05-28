class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num: arr) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

       Map<Integer, Integer> newCountMap = countMap.entrySet()
                  .stream()
                  .sorted((i1, i2)
                              -> i1.getValue().compareTo(
                                  i2.getValue()))
                  .collect(Collectors.toMap(
                      Map.Entry::getKey,
                      Map.Entry::getValue,
                      (e1, e2) -> e1, LinkedHashMap::new));
 
        // Collections.sort(countMap, (a,b) -> a.getValue().compareTo(b.getValue()));
        int totalCount = 0;
        for(Map.Entry<Integer, Integer> numEntry : newCountMap.entrySet()){
            int count = numEntry.getValue();
            totalCount += count;
            if (totalCount <= k) {
                countMap.remove(numEntry.getKey());
            } 
            else {
                break;
            }
        }
        return countMap.size();
        
    }
}
