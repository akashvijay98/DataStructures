class Solution {
    public int[] assignTasks(int[] servers, int[] tasks) {
        PriorityQueue<int[]> available = new PriorityQueue<>((a,b)->
        {
            if(a[0]-b[0] !=0){
                return a[0]-b[0];
            }
            else{
                return a[1]-b[1];
            }

        }
        );

         PriorityQueue<int[]> unavailable = new PriorityQueue<>((a,b)->a[0]-b[0]); 
        
        int[] ans = new int[tasks.length];

        List<int[]> list = new ArrayList<>();


        // initially all the servers are available
        // add server to the minHeap in the following way --> index 0 = weight, index 1 = index of the server in the servers array
        for(int i=0;i<servers.length;i++){
            available.add(new int[] {servers[i],i});
        }


        int time=0;

        // go through each task        
        for(int i=0;i<tasks.length;i++){
            time = Math.max(time,i);

            // if all servers are busy, then skip the time to the first server which will become free in the unavailable heap 
            if(available.isEmpty()){
                time=unavailable.peek()[0];
            }

            // as long as there are servers in the unavailable array whose completion time is less than or equal to current time
            //  pop these servers and add them to the available servers heap 
             while(!unavailable.isEmpty() && time>=unavailable.peek()[0]){
                int[] element = unavailable.poll();
                available.add(new int[]{element[1], element[2]});
             }


            // now assign the server to the task, and add the assigned server to the unavailable heap --> index 0 = completion time(time+task[i]), server weight, server   index
            int[] row =  available.poll();
            ans[i]= row[1];
            unavailable.add(new int[] {time+tasks[i],row[0],row[1]});
        }


        
            
        
        return ans;

    }
}
