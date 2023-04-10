class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> countMap = new HashMap<> ();
        for (int i = 0; i<arr.length; i++){
            if (!countMap.containsKey(arr[i])){
                countMap.put(arr[i], 0);
            } else {
                countMap.put(arr[i], countMap.get(arr[i])+1);
            }
        }
        Set<Integer> uniqueCount = new HashSet<>();
        for (Integer count: countMap.values()){
            if (uniqueCount.contains(count)){
                return false;
            }
            uniqueCount.add(count);
        }
        return true;
    }
}
