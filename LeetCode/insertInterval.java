class Solution {

    /*
        Step 1: isert all meetings which occur before the start of newInterval[0] into the result list

        Step 2: insert all overlapping intervals --> intervals[i][0] <= newInterval[1] , all intervals whose start is before end of the new Interval

        Step 3: insert the remaining intervals.
    */

    public int[][] insert(int[][] intervals, int[] newInterval) {
    
        int i=0;
        int n = intervals.length;

        List<int[]> res = new ArrayList<>();

        while(i<n && intervals[i][1]<newInterval[0]){
            res.add(intervals[i]);
            i++;
        }

        int start = newInterval[0];
        int end = newInterval[1];

        while(i<n && intervals[i][0]<=end){
            
            // you need to take min(start, intervals[i]), start may always not be the least.
            // we need to take min of start and intervals[i][0] because 
            // if you take e.g. [[3,5],[6,7]] and newInterval: [4,8], you have to take min(3,4).
            

            start = Math.min(start,intervals[i][0]);
            end = Math.max(end, intervals[i][1]);
            i++;
        }

        res.add(new int[] {start,end});

        while(i<n){
            res.add(intervals[i]);
            i++;
        }

        return res.toArray(new int[res.size()][2]);
    
    }
}
