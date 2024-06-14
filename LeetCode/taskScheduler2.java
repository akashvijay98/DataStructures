class Solution {
    public long taskSchedulerII(int[] tasks, int space) {
        long day=0;

        Map<Integer, Long> map = new HashMap<>();;

        for( int task : tasks){
            day+=1;

            */
                Let us  consider an input task array[1,1] and space = 3.
                on day 1 task at idx 0 will be executed.
                so the task of same time can only be executed on the 4th day.

                on day 2 we check if the task can be executed or not, so we find which is greater,
                day 2 or the day the task got last executed + space + 1. (max(2, 1+3+1))
                
            */

            if(map.containsKey(task)){
                day = Math.max(day, map.get(task)+space+1);
                map.put(task, day);
            }

            else{
                map.put(task, day);
            }
        

        }
        return day;
    }
}
