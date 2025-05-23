class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        
        HashMap<Character,Integer> map = new HashMap<>();

        for(int i=0;i<order.length();i++){
            map.put(order.charAt(i),i);
        }



        for(int i=0;i<words.length-1;i++){
            String w1 = words[i];
            String w2 = words[i+1];
           
            int minLen = Math.min(w1.length(),w2.length());
            for(int j=0;j<minLen;j++){
                char c1 = w1.charAt(j);
                char c2 = w2.charAt(j);

                if(c1!=c2){
                    if(map.get(c1)>map.get(c2)){
                        return false;
                    }
                    break;
                }

                if(j==minLen-1 && w1.length() > w2.length() ){
                    return false;
                }



            }
            
        }

        return true;
    }
}
