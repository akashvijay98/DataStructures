class Solution {
    public List<String> topKFrequent(String[] words, int k) {

        List<String> result = new ArrayList<>();

        Map<String,Integer> freqMap = new HashMap<>();

        PriorityQueue<Map.Entry<String,Integer>> pq = new PriorityQueue<>(
            (a,b)-> {
                if(a.getValue().equals(b.getValue())){
                    return a.getKey().compareTo(b.getKey());
                }
                else{
                    return b.getValue()-a.getValue();
                }
            }
        );

        for(String str : words){
            freqMap.put(str, freqMap.getOrDefault(str,0)+1);
        }

        for(Map.Entry<String,Integer> entry: freqMap.entrySet()){
            pq.offer(entry);
        }

        for(int i =0;i<k;i++){
            result.add(pq.poll().getKey());
        }
        return result;

    }

}
