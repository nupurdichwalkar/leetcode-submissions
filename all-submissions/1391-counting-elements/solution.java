class Solution {
    public int countElements(int[] arr) {
        Set<Integer> mySet = new HashSet<>();
        for (int num: arr) {
            if (!mySet.contains(num)){
                mySet.add(num);
            }
        }
        int count = 0;
        for (int num: arr) {
            if(mySet.contains(num+1)){
                count++;
            }
        }
        return count;
    }
}
