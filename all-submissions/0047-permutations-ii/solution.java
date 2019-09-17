class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i : nums){
            if(!map.containsKey(i)){
                map.put(i,1);
            } else{
                map.put(i,map.get(i)+1);
            }
        }
        permuteUnique(map, new ArrayList<>(), nums.length ,result);
        return result;
    }
    public void permuteUnique(HashMap<Integer,Integer> map, List<Integer> temp, int remaining, List<List<Integer>> result){
        if(remaining == 0)
                {
                result.add(new ArrayList<>(temp));
                }
        for(Integer i : map.keySet()){
            int count = map.get(i);
            if(count>0){
                map.put(i,count-1);
                temp.add(i);
                permuteUnique(map,temp,remaining-1,result);
                temp.remove(temp.size()-1);
                map.put(i,count);
            }
        }
    }
}
