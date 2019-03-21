class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int count = 0;
        if (time.length<2) 
            return count;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < time.length; i++) 
        {          
            int rem = time[i]%60;
            count += map.getOrDefault((60-rem)%60 , 0);
            map.put(rem, map.getOrDefault(rem, 0) + 1);
        }
        return count;
    }
}
