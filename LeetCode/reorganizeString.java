class Solution {
    public String reorganizeString(String s) {
        HashMap<Character,Integer> freqMap = new HashMap<>();

        Queue<int[]> pq = new PriorityQueue<>((a,b)->b[1]-a[1]);


        for(char c: s.toCharArray()){
            freqMap.put(c,freqMap.getOrDefault(c, 0)+1);
        } 

        for(Map.Entry<Character,Integer> entry : freqMap.entrySet()){
            pq.add(new int[] {entry.getKey(),entry.getValue()});
        }

        StringBuilder sb = new StringBuilder();

        while(!pq.isEmpty()){
            var first = pq.poll();

            if(sb.length()==0 || first[0] != sb.charAt(sb.length()-1)){
                sb.append((char) first[0]);

                if(--first[1] >0){
                    pq.offer(first);
                }
            }
            else{
                if(pq.isEmpty()){
                    return "";
                }
                
                var second = pq.poll();
                sb.append((char) second[0]);

                if(--second[1]>0 ){
                    pq.offer(second);
                }
                pq.offer(first);
            }
            
        }
        return sb.toString();
    }
}
