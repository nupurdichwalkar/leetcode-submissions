class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);
        long totalMass = mass;
        for (int asteroid: asteroids) {
            if (asteroid <= totalMass) {
                totalMass += asteroid;
            } 
            else {
                return false;
            }
        }
        return true;
    }
}
