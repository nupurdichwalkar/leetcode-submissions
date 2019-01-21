import java.io.*;
class Solution {
    public int[] plusOne(int[] digits) {
      int carry = 0;
      int[] temp = new int[digits.length];
     for(int i = digits.length - 1 ; i>=0; i--)
     {
             if(i == digits.length -1)
                 temp[i] = digits[i] + 1;
            else
            {
                temp[i] = digits[i] + carry;
                carry = 0;
            }
         
         if( temp[i] > 9 )
         {
             carry = 1;
             temp[i] = 0;
         }
               
     }
        if(carry == 1)
        {
            int[] result = new int[ digits.length+1 ];
            result[0] = 1;
            for(int i = 1; i < result.length; i++)
                result[i] = temp[i-1];
            return result;
        }
        return temp;
    }
}
