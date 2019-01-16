class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> check = new HashSet<Integer>();
        for(int element : nums)
        {
            if(!check.add(element))
                return true;
                check.add(element);
        }
        return false;
    }
}
