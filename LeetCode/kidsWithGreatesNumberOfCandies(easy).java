class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> result = new ArrayList<>();
        int max = 0;
        for(int candy : candies){
            max = Math.max(max,candy);


        }

        for(int i=0;i<candies.length;i++){
            if(candies[i]+extraCandies>=max){
                result.add(true);
            }
            else{
                result.add(false);
            }
        }
        return result;
    }
}
