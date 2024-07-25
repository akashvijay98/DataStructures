class Solution {
    public int numRescueBoats(int[] people, int limit) {

        Arrays.sort(people);

        int result = 0;

        int left=0; 
        int right = people.length-1;

        while(left<=right){
            int sum = people[left]+people[right];
            
            if(sum>limit){
                right-=1;
            }
            else{
                right-=1;
                left+=1;
            }
            
            result +=1;


        }
        return result;
        
    }
}
