class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        if(nums1.length==0||nums2.length==0)
            return new int[]{};
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> ans = new HashSet<>();
        for(int i : nums1)
        {
            set.add(i);
        }
        for(int j : nums2)
        {
            if(set.contains(j))
            {
                ans.add(j);
            }
        }
        int [] res = new int[ans.size()];
        int i = 0;
            for(Integer num : ans)
            {
                res[i++] = num;
            }
        return res;
    }
}
