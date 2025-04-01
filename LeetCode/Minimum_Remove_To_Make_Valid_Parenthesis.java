class Solution {

    /*
        first add the '(' indexes to the stack

        if there charAt(i) equals ')':  
            if stack is not empty : we pop the index of the latest '(' to balance
            else if stack is empty, we mark the index of ')' in the indexToRemove set
             
        we finish the loop and check if the stack is still holding some indexes (unbalanced brackets)
            if yes, then we mark all indexes by added them to the indexToRemove set

        lastly we iterate the indexes of the string and if any of the indexes are marked, we just skip them, or else we append the character at index to the StringBuilder sb.

        finaly convert sb to string and return the result
    
    */

    public String minRemoveToMakeValid(String s) {
        Set<Integer> indexesToRemove = new HashSet<>();
        StringBuilder sb = new StringBuilder();

        Stack<Integer> stack = new Stack<>();

        int n = s.length();
        for(int i=0;i<n;i++){
            char c = s.charAt(i);

            if(c == '('){
                stack.push(i);
            }
            else if(c==')'){
                if(!stack.isEmpty()){
                    stack.pop();
                }
                else{
                    indexesToRemove.add(i);
                }
            }
        }

        while(!stack.isEmpty()){
            indexesToRemove.add(stack.pop());
        }

        for(int i=0;i<n;i++){
            if(indexesToRemove.contains(i)){
                //skip the indexes which needs to be remvoed
                continue;
            }
            sb.append(s.charAt(i));
        }

        return sb.toString();
    }
}
