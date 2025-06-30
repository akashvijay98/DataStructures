class Solution{
    
    public int minMeetingRooms(int[][] intervals){

        // min headp --> will return the earliest meeting ending time 
        PriorityQueue<Integer> pq = new PriorityQueue();

        // sort the array in ascending order of the start time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        // add only the end time of the intervals to the priority queue
        pq.add(intervals[0][1]);

        for(int i=1;i<intervals.length;i++){
            
            // check if the current intervals start time is after the earliest ending time in the heap (no overlap)
            // if there is an overlap, then an extra meeting room will be required
            if(intervals[i][0]>pq.peek()){
                
                // we will remove the earliest end time if there is no overlap with current interval
                pq.poll();
            }
            // we will add the current interval's end time 
            pq.add(intervals[i][1]);
        }

        return pq.size();
    }
}
