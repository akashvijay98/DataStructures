class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int p1=0, p2=0;

        List<int[]> res= new ArrayList<>();

        while(p1<firstList.length && p2<secondList.length){
            int start1 = firstList[p1][0];
            int end1 = firstList[p1][1];

            int start2 = secondList[p2][0];
            int end2= secondList[p2][1];

            if(end2<start1){
                p2++;
            }
            else if(end1<start2){
                p1++;
            }

            else{
                res.add(new int[]{Math.max(start1,start2), Math.min(end1,end2)});
                if(end1>end2){
                    p2++;
                }
                else{
                    p1++;
                }
            }
        }   

        return res.toArray(new int[res.size()][]);
    }
}
