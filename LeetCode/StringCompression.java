/*
    Approach:
        We will use two pointers.
        1. initially i and index both will point to 0
        2. lets take an input array [aabbccc]

        BEGIN INNER FOR LOOP
            
            3. we will first assign the currentCharacter - first character of the group of similar characters ---> characters[i]

                BEGIN INNER WHILE LOOP

                  a.  we'll keep incrementing i until its not equal to currentCharacter and also      increment  counter
                
                CLOSE WHILE LOOP
            
            4. we will add currentCharacter at i to the beginning (at index++).


            5. then we will check if counter is greater than 1.
            
                a. if yes, then we will convert counter to String first, then add each digit as a character to the char Array.

        CLOSE FOR LOOP 

        return index
*/

class Solution {
    public int compress(char[] chars) {
        int index =0;
        int i = 0;
        while(i<chars.length){
            char currentChar = chars[i];
            int count = 0;
            
            while(i<chars.length && chars[i]==currentChar){
                count++;
                i++;
            }
            chars[index++]=currentChar;
            
            if(count>1){
                String s = Integer.toString(count);

                for(char c : s.toCharArray()){
                    chars[index++]=c;
                }
            }

        }

        return index;
    }
}
