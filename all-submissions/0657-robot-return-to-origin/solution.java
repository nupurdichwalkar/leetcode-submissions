class Solution {
    public boolean judgeCircle(String moves) {
        String[] move = moves.split("");
        boolean check = false;
        int countL =0, countR=0; 
        int countU= 0; 
        int countD=0;
        for(String dir : move)
        {
            if(dir.equals("L"))
                countL++;
            if(dir.equals("R"))
                countR++;
            if(dir.equals("U"))
                countU++;
            if(dir.equals("D"))
                countD++;
        }
        if(countL==countR&&countU==countD)
            check = true;
        return check;
    }
}
