class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Map<String, List<String>> map = new HashMap<>();

        int result = 1;


        for(String word:wordList){
            for(int i=0;i<word.length();i++){
                String pattern = word.substring(0,i)+"*"+word.substring(i+1);
               
                if (!map.containsKey(pattern)) {
                    map.put(pattern, new ArrayList<>());  
                }
                map.get(pattern).add(word);
                
            }

        }

        Set<String> visited = new HashSet<>();

        Queue<String> q = new LinkedList<>();

        q.add(beginWord);
        visited.add(beginWord);

        while(!q.isEmpty()){
            int size=  q.size();
            
            for(int i=0;i<size;i++){
                String currentWord = q.poll();

                if(currentWord.equals(endWord)){
                    return result;
                }

                for(int j=0;j<currentWord.length();j++){
                    String pattern = currentWord.substring(0,j) +"*" + currentWord.substring(j+1);

                    for(String neighbor : map.getOrDefault(pattern, new ArrayList<>())){
                        if(!visited.contains(neighbor)){
                            visited.add(neighbor);
                            q.add(neighbor);
                        }
                    }

                }

            }
            result++;
        }

        return 0;
        
    }
    
}
