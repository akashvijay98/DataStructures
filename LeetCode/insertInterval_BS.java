class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if(intervals.length==0){
            return new int[][] {newInterval};
        }

        int n = intervals.length;
        int target = newInterval[0];
        int left =0, right = n-1;

        while(left <= right){
            int mid = (left+right)/2;

            if(intervals[mid][0]< target){
                left = mid+1;
            }
            else{
                right = mid-1;
            }
        }

        List<int[]> result = new ArrayList<>();

        // add the intervals which are before the new interval
        for (int i = 0; i < left; i++) {
            result.add(intervals[i]);
        }

        // add the new interval
         result.add(newInterval);

         //add the remaining intervals
        for (int i = left; i < n; i++) {
            result.add(intervals[i]);
        }

        // now iterate from the beginning of the result list and merge intervals if they are overlapping


        List<int[]> merged = new ArrayList<>();
        for(int[] interval : result){
            if(merged.isEmpty() || merged.get(merged.size()-1)[1]<interval[0]){
                merged.add(interval);
            }
            else{
                merged.get(merged.size()-1)[1]= Math.max(merged.get(merged.size()-1)[1], interval[1]);
            }
        }

        return merged.toArray(new int[0][]);


    }
}
