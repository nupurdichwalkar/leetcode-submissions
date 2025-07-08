class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num: arr) {
            map.put(num, map.getOrDefault(num,0) +1);
        }
        List<Integer> values = new ArrayList<>();
        for(int value: map.values()){
            values.add(value);
        }
        Collections.sort(values, Comparator.reverseOrder());

        while(k>0) {
            int val = values.get(values.size()-1);
            if ( val <=k ){
                values.remove(values.size()-1);
                k -= val;
            }
            else {
                break;
            }
        }
        return values.size();
        
    }
}
