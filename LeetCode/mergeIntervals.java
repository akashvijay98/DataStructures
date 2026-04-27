class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> list =  new ArrayList<>();

        int i;

        Arrays.sort(intervals, (a,b)-> Integer.compare(a[0], b[0]));

        int start = intervals[0][0];
        int end = intervals[0][1];

        for(i=1; i<intervals.length;i++){
            if(intervals[i][0]>end){
                int[] arr = new int[]{start, end};
                list.add(arr);

                start = intervals[i][0];
                end = intervals[i][1];
            }

            else{
                end = Math.max(end, intervals[i][1]);
            }
        }

       
        list.add(new int[]{start,end});
        
        return list.toArray(new int[list.size()][]);
    }
}
