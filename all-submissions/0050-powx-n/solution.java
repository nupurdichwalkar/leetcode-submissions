class Solution {

    Map<Long, Double> powerMap = new HashMap<>(); 
    double value; 

    public double myPow(double x, int n) {

        return binaryExp( x, (long) n);
    }

    private double binaryExp(double x, long n) {
        if (n == 0) return 1;
        if(powerMap.containsKey(n)) {
            return powerMap.get(n);
        }
        if (n < 0) 
          value = 1.0 / binaryExp(x, -n);
        else if (n % 2 == 1) {
            value =  x * binaryExp(x * x, (n - 1) / 2);
        }
        // Otherwise we calculate result by performing Binary Exponentiation on 'n'.
        else {
            value = binaryExp(x * x, n / 2);
        }
        powerMap.put(n, value);
        return value;
    }
}
