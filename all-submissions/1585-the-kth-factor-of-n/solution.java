class Solution {
    public int kthFactor(int n, int k) {
        int x = (int)Math.sqrt(n);
        List<Integer> factorList = new ArrayList<>();
        for(int i=1; i<=x;i++) {
            if (n%i == 0) {
                if(n/i != i){
                    factorList.add(i);
                } 
                factorList.add(n/i);
            }
        }
        
        Collections.sort(factorList);
        return factorList.size() >= k ? factorList.get(k-1) : -1;
        
    }
}
