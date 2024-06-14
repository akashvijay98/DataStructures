/*
    take example: [A,A,A,B,B,B,C,C,C], n=3
    cycle =4
    
    so A will remain idle for next 3 cycles --> A, B, C, idle, A, B, C, idle, A, B, C 
*/

class Solution {
    public int leastInterval(char[] tasks, int n) {

        int time = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);

        Map<Character,Integer> freqMap = new HashMap<>();

        for(char ch:tasks){
            freqMap.put(ch, freqMap.getOrDefault(ch,0)+1);
        }

        // int[] freqArr = new int[26];
        // for(char ch:tasks){
        //     freqArr[ch-'A']++;
        // }

        for(Integer freq : freqMap.values()){
            pq.offer(freq);
        }

        while(!pq.isEmpty()){
            List<Integer> q = new ArrayList<>();

            int cycle = n+1;
            int taskCount=0;

            // cycle-->0: This part of the condition ensures that the inner loop runs for 
            //a maximum of n + 1 iterations.


            while(cycle-->0 && !pq.isEmpty()){
                
                int currentFreq = pq.poll();
                
                if(currentFreq>1){
                    q.add(currentFreq-1);
                }

                taskCount++;

            }
            for(int freq:q){
                pq.offer(freq);
            }

            // for example if input is AABC and n=2, then in the first iteration, A,B,C Tasks will get executed,
            // so time for first iteration will be n+1 = 3 and A will be remaining in the heap.
            // in the 2nd iteration, A will be executed, so time will be 1 only.
            if(pq.isEmpty()){
                time+=taskCount;             
            }
            else{
                time+=n+1;
            }
        }
        return time;
    }
}
