class FoodRatings {

    public class Pair
    {
        String foodName;
    
        int foodRating;
        public Pair( int ratings, String foodName)
        {
            this.foodName = foodName;
            this.foodRating = ratings;
        }
    }
    
    Map<String,Integer> foodRatingMap ;
    Map<String,String> foodCuisineMap ;

    //Food: (foodRating, foodName)
    Map<String, PriorityQueue<Pair>> cuisineFoodMap;

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        foodRatingMap = new HashMap<>();
        foodCuisineMap = new HashMap<>();
        cuisineFoodMap = new HashMap<>();

        for(int i=0;i<foods.length;i++){
            foodRatingMap.put(foods[i],ratings[i]);
            foodCuisineMap.put(foods[i],cuisines[i]);

            // insert into the queue
            if (!cuisineFoodMap.containsKey(cuisines[i])) {
                cuisineFoodMap.put(cuisines[i], new PriorityQueue<>((a, b) -> b.foodRating == a.foodRating ? a.foodName.compareTo(b.foodName) : b.foodRating - a.foodRating));
            }
            cuisineFoodMap.get(cuisines[i]).add(new Pair(ratings[i], foods[i]));
        }

    }
    
    public void changeRating(String food, int newRating) {
        foodRatingMap.put(food, newRating);

        String cuisineName= foodCuisineMap.get(food);
        cuisineFoodMap.get(cuisineName).add(new Pair(newRating,food));
    }
    
    public String highestRated(String cuisine) {
        Pair highestRated = cuisineFoodMap.get(cuisine).peek();

        while(foodRatingMap.get(highestRated.foodName) != highestRated.foodRating){
            cuisineFoodMap.get(cuisine).poll();

            highestRated = cuisineFoodMap.get(cuisine).peek();
        }
        return highestRated.foodName;
    }
}

