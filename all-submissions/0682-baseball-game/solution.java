class Solution {
    public int calPoints(String[] ops) {
        Stack<Integer> valid = new Stack<>();
        int sum =0;
        for(int i =0; i<ops.length; i++)
        {
            if(ops[i].equals("C"))
            {
                int remove = valid.pop();
                sum = sum - remove;
            }
            else if(ops[i].equals("D"))
            {
                int toDouble = valid.pop();
                sum = sum + 2*toDouble;
                valid.push(toDouble);
                valid.push(2*toDouble);
                
            }
            else if(ops[i].equals("+"))
            {
                int no1 = valid.pop();
                int no2 = valid.pop();
                int plus = no1+no2;
                sum = sum+plus;
                valid.push(no2);
                valid.push(no1);
                valid.push(plus);
            }
            else
            {
                valid.push(Integer.parseInt(ops[i]));
                sum += Integer.parseInt(ops[i]); 
            }
        }
        return sum;
    }
}
