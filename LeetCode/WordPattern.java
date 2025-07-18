class Solution {
    public boolean wordPattern(String pattern, String s) {
        HashMap<Character,String> map = new HashMap<>();
        HashMap <String, Character> map_word = new HashMap();
        String[] words = s.split(" ");

        if (pattern.length() != words.length) {
            return false;
        }

        for(int i=0;i<pattern.length();i++){
            char c= pattern.charAt(i);

            if(!map.containsKey(c) && !map_word.containsKey(words[i])){
                map.put(c, words[i]);
                map_word.put(words[i],c);
            }
            else {
                if(!words[i].equals(map.get(c)) || !map_word.get(words[i]).equals(c)){
                    return false;
                    
                }
            }
        }

        return true;
    }
}
