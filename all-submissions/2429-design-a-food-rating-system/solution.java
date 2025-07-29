class Food implements Comparable<Food>{
    String name;
    int rating;
    public Food(int rating, String name) {
        this.rating = rating;
        this.name = name;
    }
    // Implement the compareTo method for comparison
    @Override
    public int compareTo(Food other) {
        // If food ratings are the same, sort based on their names (lexicographically smaller name food will be on top)
        if (rating == other.rating) {
            return name.compareTo(other.name);
        }
        // Sort based on food rating (bigger rating food will be on top)
        return -1 * Integer.compare(rating, other.rating);
    }
}

   


class FoodRatings {

    Map<String, Integer> foodRatingMap = new HashMap<>();
    Map<String, String> foodCuisineMap = new HashMap<>();

    Map<String, PriorityQueue<Food>> cuisineFoodRatingMap = new HashMap<>();

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        int len = foods.length;
        for(int i=0; i<len; i++) {
            foodRatingMap.putIfAbsent(foods[i], ratings[i]);
            foodCuisineMap.put(foods[i], cuisines[i]);
            cuisineFoodRatingMap.computeIfAbsent(cuisines[i], k -> new PriorityQueue<>()).add(new Food(ratings[i], foods[i]));
        }
        
    }
    
    public void changeRating(String food, int newRating) {

        foodRatingMap.put(food, newRating);
        String cuisine = foodCuisineMap.get(food);
        cuisineFoodRatingMap.get(cuisine).add(new Food(newRating, food));
        
    }
    
    public String highestRated(String cuisine) {
        Food highestRatedFood = cuisineFoodRatingMap.get(cuisine).peek();

        while(foodRatingMap.get(highestRatedFood.name) != highestRatedFood.rating) {
            cuisineFoodRatingMap.get(cuisine).poll();
            highestRatedFood = cuisineFoodRatingMap.get(cuisine).peek();
        }

        return highestRatedFood.name;
        
    }
}

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */
