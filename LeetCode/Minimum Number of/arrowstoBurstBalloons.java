class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points,(a,b)-> Integer.compare(a[0],b[0]));

        int arrow = 1;

        int prevEnd = points[0][1];  

        for(int i=1;i<points.length;i++){
            if(points[i][0]<=prevEnd){
                prevEnd = Math.min(prevEnd,points[i][1]);
            }
            else{
                arrow+=1;
                prevEnd =  points[i][1];
            }
        }
        return arrow;

        }
}
