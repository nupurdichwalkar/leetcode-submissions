class Solution {
    public int minDeletionSize(String[] A) {
        int count = 0;
        for(int i =0; i< A[0].length(); i++)
        {
           boolean result = isproper(A,i);
            
            if(result==false)
                count++;
        }
     return count;
        
    }
    public boolean isproper(String[] A, int i)
    {
        for(int j=0 ; j < A.length-1; j++)
            {
                
               if(A[j].charAt(i)>A[j+1].charAt(i))
                   return false;
               
            }
        return true;
    }
}
