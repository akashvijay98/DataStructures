class Solution {
    public boolean backspaceCompare(String s, String t) {
        int end1= s.length()-1;
        int end2= t.length()-1;
        while(end1>=0 || end2>=0){
            int idx1 = returnIndex(s,end1);
            int idx2 = returnIndex(t,end2);

        if(idx1<0 && idx2<0){
            return true;
        }
        else if(idx1<0 || idx2<0){
                return false;
            }
            else if(s.charAt(idx1) != t.charAt(idx2)){
                return false;
            }
            
            end1 = idx1-1;
            end2 = idx2-1;
        }
       

        return true;
    }

    public int returnIndex(String str,int end ){
            int count = 0;
            while(end>=0){
                if(str.charAt(end) == '#'){
                    count++;
                }
                else if(str.charAt(end )!= '#' && count>0){
                    count--;
                }
                else{
                    break;
                }
                end--;
            }
            return end;

        }
}
