class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b)-> a[0]-b[0]);

        int start = intervals[0][0];
        int end = intervals[0][1];

        List<int[]> res = new ArrayList<>();

        for(int i=1;i<intervals.length;i++){
            int newStart = intervals[i][0];
            int newEnd = intervals[i][1];

            if(end>= newStart){
                end = Math.max(end,newEnd); 
            }
            else{
                res.add(new int[]{start, end});

                start= newStart;
                end= newEnd;   
            }
        }
           res.add(new int[]{start, end});

        return res.toArray(new int[res.size()][]);
    }
}
