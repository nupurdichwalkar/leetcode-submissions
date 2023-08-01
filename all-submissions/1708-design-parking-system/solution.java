class ParkingSystem {

    Map<Integer, Integer> parkingSpots = new HashMap<>();

    public ParkingSystem(int big, int medium, int small) {
        this.parkingSpots.put(1, big);
        this.parkingSpots.put(2, medium);
        this.parkingSpots.put(3, small);
        
    }
    
    public boolean addCar(int carType) {
        if (carType != 1 && carType != 2 && carType != 3) {
            return false;
        }
        int parkingSpotTypeCount = this.parkingSpots.get(carType);
        if(parkingSpotTypeCount > 0) {
            this.parkingSpots.put(carType, --parkingSpotTypeCount);
            return true;
        }
        return false;
        
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */
