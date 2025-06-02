class Solution {
    
    public List<String> fullJustify(String[] words, int maxWidth) {
        int i=0;

        List<String> result = new ArrayList<>();
        
        while(i<words.length){
            int len = words[i].length();

            int j= i+1;

            //we check if words[i] +1 +words[j] + 1+ words[j+1] ...... are within maxWidth
            while(j<words.length && len+1+words[j].length()<=maxWidth){
                len+=1+words[j].length();
                j++;
            }

        
        // since the while loop breaks onyl when j exceeds max width we exclude j. ---> j-i
        // in any other problem, if you want to include word[j] also, then do j-i+1
        int numWords = j-i; 

        int totalChars = 0;

        // count the total number of characters in the range i to j
        for(int k=i;k<j;k++){
            totalChars+=words[k].length();

        }
        //we get the empty space when we suvbtract characters from maxwidth
        int totalSpaces = maxWidth-totalChars;
        
        StringBuilder sb = new StringBuilder();

        // this is the case when the we are having the last word or the last line
        if(j==words.length || numWords ==1){
            for(int k=i;k<j;k++){
                sb.append(words[k]);

                if(k<j-1){
                    sb.append(" ");
                }
            }

            while(sb.length()<maxWidth){
                sb.append(" ");
            }
        }

        else{
            // this is to distribute space equally
            // if the spaces are not even, then the left most word will have the most spaces
            int spacesBetween = totalSpaces/(numWords-1);
            int extraSpaces = totalSpaces%(numWords-1);

            for(int k=i;k<j;k++){
                sb.append(words[k]);

                // see if the word at index k is not the last word, we dont apply space after the last word
                if(k<j-1){
                    int spacesToApply = spacesBetween + (extraSpaces> 0 ? 1 : 0);
                    // the words in the left can have extra spaces if the spaces cannot be distributed equally -- left justified

                    // as we move to the right, extraSpace will become 0.
                    extraSpaces--;

                    for(int s=0; s <spacesToApply; s++){
                        sb.append(" ");
                    }
                }
            }
        }

        result.add(sb.toString());
        i=j;
        }
      return result;
    }
  
}
