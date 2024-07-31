class Solution {
    public int[] getOrder(int[][] tasks) {
        int time =0;
        int ansIndex = 0;
        int[] ans = new int[tasks.length];

        PriorityQueue<int[]>  pq = new PriorityQueue<int[]>((a, b) -> (a[1] != b[1] ? (a[1] - b[1]) : (a[2] - b[2])));

        int[][] sortedTasks = new int[tasks.length][3];
        
        for(int i=0;i<tasks.length;i++){
            sortedTasks[i][0] = tasks[i][0];
            sortedTasks[i][1] = tasks[i][1];
            sortedTasks[i][2] = i;
        }

        Arrays.sort(sortedTasks, (a,b)-> a[0]-b[0]);

        int taskIndex=0;

        while(taskIndex<tasks.length || !pq.isEmpty()){
            if(pq.isEmpty() && time<sortedTasks[taskIndex][0]){
                time = sortedTasks[taskIndex][0];
            }
            while(taskIndex<tasks.length && sortedTasks[taskIndex][0]<=time){
             pq.add(sortedTasks[taskIndex]);
             ++taskIndex;


            }
            int enqTime = pq.peek()[1];
            int index = pq.peek()[2];

            pq.remove();

            time+=enqTime;
            ans[ansIndex++]=index;
        }

        return ans;

    }
}
