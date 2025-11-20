class Solution {
    public int totalMoney(int n) {
        int numberofDays = 0;
        int total = 0;
        int curWeek = 1;
        int curVal = 1;
        for(int i=1;i<=n;i++){
            if(numberofDays == 0) {
                curVal = curWeek;
                total += curVal;
                curVal++;
                numberofDays++;
            } else{
                total+= curVal;
                curVal++;
                numberofDays++;
            }
            if(numberofDays == 7) {
                numberofDays = 0;
                curWeek++;
            }
        }
        return total;
    }
}
