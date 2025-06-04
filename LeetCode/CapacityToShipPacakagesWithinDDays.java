class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int totalWeight=0;
        int maxWeight = 0;

        for(int num : weights){
            totalWeight+=num;
            maxWeight = Math.max(maxWeight, num);
        }

        // the lowest capacity should atleast be able to load the heaviest item in the ship
        int lo = maxWeight;

        // the highest capacity is the total weight of goods in the ship
        int hi = totalWeight;

        int minCapacity = totalWeight;

        while(lo<=hi){
            int mid = (lo+hi)/2;

            int daysCount = countDays(weights, mid);

            if(daysCount<= days){
                hi = mid-1;
               
            }
            else{
                lo = mid+1;
            }
            
        }
        return  lo;


    }

    // calculate the number of days to ship all the load, where maximum capacity is capacity

    private int countDays(int[] weights, int capacity){
        int count = 1;
        int currentLoad=0;
        for(int weight: weights){
            
            if(currentLoad + weight > capacity){
                currentLoad=0;
                count++;

            }
            currentLoad += weight;

        }

        return count;
    }
}
