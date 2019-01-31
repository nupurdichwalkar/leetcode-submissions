class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int p1=0, p2 =0;
        while(p1<nums1.length && p2< nums2.length)
        {
            int v1 = nums1[p1];
            int v2 = nums2[p2];
            if(v1<v2)
            {
                p1++;
            }
            else if(v1>v2)
            {
                p2++;
            }
            else
            {
                result.add(v1);
                p1++;
                p2++;
            }
        }
        int[] res = new int[result.size()];
        for(int i = 0; i < res.length; i++) {
            res[i] = result.get(i);
        }
        return res;
        
    }
}
