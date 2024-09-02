class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        int count =0;
        for(String w:words){
            if(isSubsequence(s,w)){
                count++;
            }
        }
        return count;
    }

    public boolean isSubsequence(String s, String t){
        int p = 0;
        int q = 0;
        while(p<s.length()){
            if(s.charAt(p)==t.charAt(q)){
                q++;
                if(q==t.length()){
                    return true;
                }
            }
            p++;            
        }
        return false;

    }
}
