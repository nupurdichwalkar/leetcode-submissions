
class Solution {
    public String largestNumber(int[] nums) {
        String[] s = new String[nums.length];
        for( int k=0; k<nums.length; k++ )
        {
            s[k] = String.valueOf(nums[k]);
        }
        Comparator c = new Comparator<String>(){
        public int compare(String s1, String s2)
        {
            String str1 = s1 + s2;
            String str2 = s2 + s1;
            return str1.compareTo(str2);
        }
        };
        Arrays.sort(s, c);
        if(s[s.length-1].equals("0"))
            return "0";
        StringBuffer ans = new StringBuffer();
        
        for(int i = s.length-1; i>=0; i--)
        {
            ans.append(s[i]);
        }
        return ans.toString();
    }
}
