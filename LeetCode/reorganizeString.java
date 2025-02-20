class Solution {
    public String reorganizeString(String s) {
        Map<Character, Integer> map = new HashMap<>();

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->b[1]-a[1]);

        // use priority queue to track the frequency of each character in the string
        for(char c : s.toCharArray()){
            map.put(c, map.getOrDefault(c,0)+1);
        }


        // add the character sorted by its frequency in the priority queue 
        // also note that character is added as an integer, then itll be converted to character 
        for(Map.Entry<Character,Integer> entry: map.entrySet()){
            pq.add(new int[] {entry.getKey(), entry.getValue()});
        }

        // we'll use stringbuilder to add the reorganized string 
        StringBuilder sb = new StringBuilder();

        while(!pq.isEmpty()){
            int[] first = pq.poll();

            // we only add the first character if the string builder is empty or -
            // if the character is not the same as the adjacent character  (sb.charAt(sb.length()-1) != first[0])
            if(sb.isEmpty() || sb.charAt(sb.length()-1) != first[0]){
                sb.append((char)first[0]);
                first[1]--;
                
                if(first[1]>0){
                    pq.add(first);
                }

            }

            // if the adjacent characters are same: then we again check for any other character to replace
            // if we are not able to find a different character, then we return " "
            // if we find a different character in the priority queue, we append the character to string builder 
            // and we add back the first character to the priority queue
            else{
                if(pq.isEmpty()){
                    return "";
                }

                int[] second = pq.poll();
                sb.append((char)second[0]);

                second[1]--;
                if(second[1]>0){
                    pq.offer(second);
                }
       
                // push back the first element to be used later
                pq.offer(first);
            }

        }
        return sb.toString();


    }
}
