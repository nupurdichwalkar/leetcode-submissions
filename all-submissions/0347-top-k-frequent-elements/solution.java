import java.util.*;
class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> a = new ArrayList<Integer>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0;i<nums.length;i++)
        {
            map.put(nums[i],0);
        }
        for(int i = 0;i<nums.length;i++)
        {
            map.put(nums[i],map.get(nums[i]) + 1);
        }
        for(int j = 0; j<k;j++)
        {
        int max =(Collections.max(map.values()));
        a.add(getKey(map, max));
        map.remove(getKey(map, max));
        }
        return a;
    }
    public static <K, V> K getKey(Map<K, V> map, V value) {
		for (K key : map.keySet()) {
			if (value.equals(map.get(key))) {
				return key;
			}
		}
		return null;
    }
}
