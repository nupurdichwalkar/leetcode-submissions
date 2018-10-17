import java.io.*; 
import java.util.*; 
import java.util.HashMap; 
import java.util.Map;

class Solution {
    public int[] twoSum(int[] nums, int target) 
    {
        //ArrayList<Integer> output = new ArrayList<Integer>();
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++)
        {
            if(map.containsKey(target-nums[i]))
            {
               return new int[] {map.get(target-nums[i]),i};
            }
            map.put(nums[i],i);
        }  
  
        throw new IllegalArgumentException("No two sum solution");
    }
    
    
}
