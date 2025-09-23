/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity(int n) {

        Map<Integer, List<Integer>> relationMapKnown = new HashMap<>();
        Map<Integer, List<Integer>> relationMapKnows = new HashMap<>();
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                if(i !=j && knows(i,j)){
                    if(!relationMapKnown.containsKey(j)) {
                        relationMapKnown.put(j, new ArrayList<>());
                    }
                    relationMapKnown.get(j).add(i);

                    if(!relationMapKnows.containsKey(i)) {
                        relationMapKnows.put(i, new ArrayList<>());
                    }
                    relationMapKnows.get(i).add(j);
                }
            }
        }
        int isCelebrity = -1;

        for(int i=0; i<n;i++) {
            if (!relationMapKnows.containsKey(i)) {
                isCelebrity = i;
            }
        }

        if(relationMapKnown.containsKey(isCelebrity) && relationMapKnown.get(isCelebrity).size() == n-1) {
                return isCelebrity;
        }
        
        return -1;
    }
}
