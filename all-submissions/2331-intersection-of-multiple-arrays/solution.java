class Solution {
    public List<Integer> intersection(int[][] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<nums.length;i++){
            for (int j = 0; j< nums[i].length; j++){
                map.put(nums[i][j], map.getOrDefault(nums[i][j], 0) +1);
            }
        }
        int count = nums.length;
        for (int key : map.keySet()){
            if (count == map.get(key)){
                list.add(key);
            }
        }
        Collections.sort(list);
        return list;
    }
}
