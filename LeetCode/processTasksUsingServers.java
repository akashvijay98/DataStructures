class Solution {
    public int[] assignTasks(int[] servers, int[] tasks) {
        Queue<int[]> free = new PriorityQueue<>((a,b)->a[1]==b[1]?(a[0]-b[0]):(a[1]-b[1]));
        Queue<int[]> busy = new PriorityQueue<>((a,b)->a[1]-b[1]);

        int[] ans = new int[tasks.length];

        for(int i=0;i<servers.length;i++){
            free.add(new int[]{i,servers[i]});
        }

        int currTime=0;
        int taskIndex=0;

        while(taskIndex<tasks.length){

            while(!busy.isEmpty() && busy.peek()[1]<=currTime){
                int id = busy.poll()[0];
                free.add(new int[] {id,servers[id]});
   
            }

            while(taskIndex<tasks.length && taskIndex<=currTime && !free.isEmpty() ){
                int id = free.poll()[0];
                busy.add(new int[]{id,currTime+tasks[taskIndex]});
                ans[taskIndex++]=id;
            }

            if(free.isEmpty()){
                currTime = busy.peek()[1];
            }
            else{
                currTime++;
            }
        }
        return ans;

    }
}
