class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> previous = new ArrayList<Integer>();
        List<Integer> ans = new ArrayList<>();
        if(rowIndex == 0)
        {
            ans.add(1);
            return ans;
        }
        if(rowIndex == 1)
        {
            ans.add(1);
            ans.add(1);
            return ans;
        }
        for(int i=0;i<=rowIndex;i++){
            List<Integer> temp = new ArrayList<Integer>();
            if(i==0)
                temp.add(1);
            else if(i==1){
                temp.add(1);
                temp.add(1);
            }
            else{
                temp.add(1);
                for(int j=0;j<previous.size()-1;j++){
                    temp.add(previous.get(j)+previous.get(j+1));
                }
                temp.add(1);
            }
            previous = temp;
            ans = temp;
        }
        return ans;
    }
}
