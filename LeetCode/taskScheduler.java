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
