class Solution {
    public List<String> fizzBuzz(int n) {
        ArrayList<String> str = new ArrayList<String>();
        for(int i=1; i <=n; i++)
        {
            if(i%3==0 && i%5!=0)
                str.add("Fizz");
            else if(i%5==0 && i%3!=0)
                str.add("Buzz");
            else if(i%5==0 && i%3==0)
                str.add("FizzBuzz");
            else
                str.add(Integer.toString(i));    
        }
        return str;
    }
}
