class Solution {
    public int bestClosingTime(String customers) {
        int curPenalty = 0;

        for(int i=0;i<customers.length();i++){
            char c = customers.charAt(i);
            if(c == 'y'){
                curPenalty++;
            }
           
        }

        int minPenalty= curPenalty;
        int earliestHour = 0;

           for(int i=0;i<customers.length();i++){
            char c = customers.charAt(i);
            if(c=='Y'){
                curPenalty--;
            }
            else{
                curPenalty++;
            }

            if(curPenalty<minPenalty){
                earliestHour = i+1;
                minPenalty = curPenalty;
            }
        }
        return earliestHour;
        
    }
}
