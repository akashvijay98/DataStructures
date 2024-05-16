/* 
we start a while loop to iterate through every character in the character array
we Initialize  variable groupLength to 1 to count the number of consecutive occurrences of the current character.
inner while loop 
  While the next character in the array is the same as the current character, increment groupLength to count consecutive occurrences.

then we convert the count from int to string and add them to the character array.
  if the count is double digit, do'nt worry about the statement chars[res]=c; because if count is double digit, then we have more than 10 spaces of that particular character"


*/
class Solution {
    public int compress(char[] chars) {
        String s="";
        int res=0;
        int i=0;

        while(i<chars.length){
            int count = 1;

            while(i+count< chars.length && chars[i+count]==chars[i])
                count++;
                

            chars[res] = chars[i];
            res++;
            if(count>1){
                System.out.println("char at i="+chars[i]);
                for(char c: Integer.toString(count).toCharArray()){
                    chars[res]=c;
                    res++;
                }

            }
            i+=count;
        }   
         return res;

       
        
    }
}
