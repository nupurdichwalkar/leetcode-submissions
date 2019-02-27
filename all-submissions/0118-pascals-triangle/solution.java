class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();
        
        for(int i = 0; i<numRows; i++)
        {
            List<Integer> temp = new ArrayList<>();
            for(int j = 0; j<=i; j++)
            {
                if(i==j||j==0)
                    temp.add(1);
                else
                {
                   int a = triangle.get(i-1).get(j-1) + triangle.get(i-1).get(j);
                   temp.add(a);
                }
            }
            triangle.add(temp);
        }
        return triangle;
    }
}
