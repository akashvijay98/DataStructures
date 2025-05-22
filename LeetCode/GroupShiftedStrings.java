class Solution {
     HashMap<String, ArrayList<String>> map = new HashMap<>();
    public List<List<String>> groupStrings(String[] strings) {
       

        for(String word:strings){
            String key = computeDist(word);

            map.computeIfAbsent(key, k-> new ArrayList<>()).add(word);
        }

        return new ArrayList<>(map.values());
    }

    private String
     computeDist(String str){
          
          StringBuilder sb = new StringBuilder();

        for(int i=1;i<str.length();i++){
            int dist = str.charAt(i)-str.charAt(i-1);


            if(dist<1){
                dist = dist+26; // for rotated Strings az, z-a = -1, ba = b-a = -1, -1+26 =25
            }
            sb.append(dist).append("->");

            
        }

        return sb.toString();
    }
}
