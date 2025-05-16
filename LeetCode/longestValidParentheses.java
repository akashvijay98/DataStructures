class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        /*  eg: inputString:   "([])"

        ``` for loop begin 
        
                 c = '('          stack = [ ')' ]
                 c = '['          stack  = [ ']', ')' ]
                 c = ']',         stack.pop = ']' matching
                 c = ')',         stack.pop = ')' matching

        ``` end of for loop
             
             stack is empty
             
        */
        for(char c : s.toCharArray()){
            if(c=='{') stack.push('}');
            else if(c=='[') stack.push(']');
            else if(c=='(') stack.push(')');

            else if(stack.isEmpty() || stack.pop()!=c) return false;

            
        }

        return stack.isEmpty();
    }
}
