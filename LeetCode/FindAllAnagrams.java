class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        HashMap<Character,Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        int start =0;
        int match=0;

        if(s.length()<p.length()){
            return new ArrayList<>();
        }

       
        for(char c : p.toCharArray()){
            map.put(c, map.getOrDefault(c,0)+1);
        }

        int windowSize = p.length();

        for(int i=0;i<windowSize;i++){
            char ch = s.charAt(i);

            if(map.containsKey(ch)){
                 map.put(ch, map.getOrDefault(ch,0)-1);
                 if(map.getOrDefault(ch,0)==0){
                    match++;
                 }
            }
        }
        if(match==map.size()){
            list.add(0);
        }

        for(int end=windowSize;end<s.length();end++){
            char startChar= s.charAt(start);
            char endChar = s.charAt(end);

            if(map.containsKey(startChar)){
                if(map.getOrDefault(startChar,0)==0){
                    match--;
                }
                 map.put(startChar, map.getOrDefault(startChar,0)+1);
                 
            }
            start++;

            if(map.containsKey(endChar)){
                map.put(endChar, map.getOrDefault(endChar,0)-1);
                if(map.getOrDefault(endChar,0)==0){
                    match++;
                }

            }
            if(match==map.size()){
                list.add(end-windowSize+1);
            }

        }
        return list;
    }
}
