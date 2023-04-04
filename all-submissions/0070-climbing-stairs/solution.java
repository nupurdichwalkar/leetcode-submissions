class Solution {
    public int climbStairs(int n) {
        int[] map = new int[n+1];
        Arrays.fill(map, -1);
        return climb_Stairs (n, map);
    }

    public int climb_Stairs(int n, int[] map){
        if(n < 0) {
            return 0;
        }
        else if (n == 0) {
            return 1;
        } else if (map[n] > -1) {
            return map[n];
        } else {
            map[n] =  climb_Stairs(n-1, map) + climb_Stairs(n-2, map);
            return map[n];
        }
    }
}
