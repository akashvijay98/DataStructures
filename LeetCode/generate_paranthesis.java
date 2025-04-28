class Solution {
    List<String> result;
    public List<String> generateParenthesis(int n) {
        result = new ArrayList<>();
        backtrack(0,0,n,new StringBuilder());
        return result;
    }

    public void backtrack(int openN, int closedN,int n, StringBuilder stack){
        
        if(openN==n && closedN == n){
            result.add(stack.toString());
            return;
        }
        
        if(openN<n){
            stack.append('(');
            backtrack(openN+1,closedN,n,stack);
            stack.deleteCharAt(stack.length() - 1);
        }

        if(closedN<openN){
            stack.append(')');
            backtrack(openN,closedN+1,n,stack);
            stack.deleteCharAt(stack.length() - 1);;
        }


    }
}
