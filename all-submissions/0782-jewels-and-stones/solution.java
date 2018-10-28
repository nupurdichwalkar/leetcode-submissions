class Solution {
    public int numJewelsInStones(String J, String S) {
        HashSet<String> jewels = new HashSet<String>();
        int count = 0;
        String[] jewel = J.split("");
        for(int i = 0; i<jewel.length; i++)
        {
            jewels.add(jewel[i]);
        }
        String[] stone = S.split("");
        for(int j = 0;j<stone.length;j++)
        {
            if(jewels.contains(stone[j]))
            {
                count++;
            }
        }
        return count;
    }
}
