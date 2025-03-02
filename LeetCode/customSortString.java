class Solution {
    public String customSortString(String order, String s) {
        Map<Character,Integer> map = new HashMap<>();

        // count the frequency of each character in String s
        for(char c : s.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }

        StringBuilder sb = new StringBuilder();

        // iterate through order, and check the frequency of the order character occuring in String s
        // keep decrementing freq after appending the character to stringbuilder until count is 0
        for(int i=0;i<order.length();i++){
            char ch = order.charAt(i);

            int count = map.getOrDefault(ch,0);
            while(count>0){
                sb.append(ch);
                count--;
            }
            map.remove(ch);

        }

        //append the remaining characters in the frequency map
        for(char key : map.keySet()){
            int count = map.get(key);
            while(count>0){
                sb.append(key);
                count--;
            }
        

        }
        return sb.toString();


    }
}
