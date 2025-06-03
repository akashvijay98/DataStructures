/*
lets take example String s= "adcb"

    1. stack is empty: push a to stack ---> [a]

    2. stack is not empty, but stack top(a) - currentchar(d) is not= 1 or   25(z-a), hence push(d) --> [a,d]

    3. stack is not empty, stack top(d) - currentChar(c) = 1 so pop(d), and skip c -- dont push (c) --> [a]

    4. stack is not empty, stack top(a) - currentChar(b) = 1, so pop(a).


*/

class Solution {
    public String resultingString(String s) {
        Stack<Character> stack = new Stack<>();

        for(char c : s.toCharArray()){
            if(!stack.isEmpty()){
                char top = stack.peek();
                int diff= Math.abs(top-c);

                if(diff==1 || diff==25){
                    stack.pop();
                    continue; // you should not append c to stack if a pop() operation is performed.
                }
            }
            stack.push(c);
        }
        StringBuilder sb = new StringBuilder();
        for(char ch:stack){
            sb.append(ch);
        }
        return sb.toString();
    }
}
