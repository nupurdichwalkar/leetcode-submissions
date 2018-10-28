class Solution {
    public int hammingDistance(int x, int y) {
    int[] X = convertBinary(x);
    int[] Y = convertBinary(y);    
    int hammdist=0;
        for(int m=0;m<X.length;m++)
        {
            if(X[m]!=Y[m])
            {
                hammdist++;
            }
        }
        return hammdist;
    }
       public int[] convertBinary(int no) { 
   int temp[] = new int[32];
    int binary[];
     for(int i =0;i<=31;i++) {
    if (no > 0) {
        temp[i] = no % 2;
        no /= 2;
    }
         else
             temp[i]=0;
     }
    binary = new int[32];
    int k = 0;
    for (int j = 31; j >= 0; j--) {
        binary[k++] = temp[j];
    }

    return binary;
    }
}
