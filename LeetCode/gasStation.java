class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {


        /* 
        
        The approach is that the totalGas should be greater than or equal to totalCost 
        
        if we sum them up seperately then we need to store them in seperate variables. that is why we store the difference between gas[i]and cost[i]

        
        
        
        */



        int answer = 0, totalGain = 0, currentGain = 0;

        for(int i=0;i<gas.length;i++){
            totalGain+= gas[i]-cost[i];
            currentGain += gas[i]-cost[i];

            if(currentGain<0){
                answer = i+1;
                currentGain = 0;
            }
        }
        if(totalGain>=0){
            return answer;

        }
        else
        return -1;
    }
}
