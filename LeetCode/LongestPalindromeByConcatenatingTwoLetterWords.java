class Solution {
    /*
        as mentioned in the description, each word only contains 2 characters.

        Approach: 
        eg. input = case 1: ["ty","yt","gg"]
                    case 2: ["ty","yt","gg","gg"]

        1. We are going to check if the reverse of string is present in the Map.
            a. if yes, that means these two words will form a palindrome.
                we add 4 to the currentCount. currentCount+=4

                eg: "yt", "gg"
            
            b. if not, then we just add the current word to the map.
                eg: ty
        2. we need to check for any word like ("gg", "ll") which has same characters so that we can add them to the middle
            e.g. "gg" from case 1



       Special Case: if there are two words with all characters the same: 
        e.g. "gg","gg" from case 2. 
            they

    */
    public int longestPalindrome(String[] words) {
        HashMap<String,Integer> map = new HashMap<>();

        boolean isMiddle = false;

        int count = 0;

        for(String word:words){
            
          
            String rev = new StringBuilder(word).reverse().toString();
           
            if(map.getOrDefault(rev,0)>0){
                count+=4;

                map.put(rev, map.getOrDefault(rev,0)-1);

               
            }

            else{
                map.put(word, map.getOrDefault(word,0)+1);            

            }

        }


        for(String key: map.keySet()){
             if(key.charAt(0)==key.charAt(1) && map.get(key)>0){
                isMiddle=true;
                break;
             }
            
        }

        if(isMiddle){
            count+=2;
        }

        return count ;
        
    }
}
