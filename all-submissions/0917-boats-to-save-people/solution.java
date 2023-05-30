class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int ans = 0;
        int l = 0;
        int r = people.length-1;
        System.out.println(l + " " + r);
        while (l <= r) {
            int totalWeight = people[l] + people[r];
            if (totalWeight <= limit) {
                l++;
            }
            r--;
            ans++;
        }
        return ans;

        
    }
}
