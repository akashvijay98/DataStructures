class Solution {
    public int minAddToMakeValid(String s) {
        int open=0;
        int add = 0;

        for(int i=0;i<s.length();i++){
            char c= s.charAt(i);

            if(c=='('){
                open++;
            }
            else if(c=='('){
                if(open>0){
                    open--;
                }
                else{
                    add++;
                }
            }
        }
        return open+add;
    }
}
