/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
class Solution {

    public int depthSumInverse(List<NestedInteger> nestedList) {
        int maxDepth = getMaxDepth(nestedList);
        return weightedSum(nestedList, 1, maxDepth);
    }

    public int getMaxDepth(List<NestedInteger> nestedList){
        int maxDepth = 1;
       for(NestedInteger nestedInteger: nestedList) {
        if(!nestedInteger.isInteger() && nestedInteger.getList().size() > 0) {
            maxDepth = Math.max(maxDepth, getMaxDepth(nestedInteger.getList())+1);
        }
       }

       return maxDepth;
    }

    public int weightedSum(List<NestedInteger> nestedList, int currDepth, int maxDepth) {
        int finalSum = 0;
        for(NestedInteger nestedInteger: nestedList) {
            if (nestedInteger.isInteger()) {
                finalSum += nestedInteger.getInteger() * (maxDepth - currDepth +1);
            } else {
                finalSum += weightedSum(nestedInteger.getList(), currDepth+1, maxDepth);      
            }
       }
       return finalSum;
    }
}
