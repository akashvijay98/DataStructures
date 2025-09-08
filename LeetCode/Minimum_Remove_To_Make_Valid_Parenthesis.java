// solution 1
class Solution {
    public String minRemoveToMakeValid(String s) {
        StringBuilder sb = new StringBuilder(s);
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i< s.length();i++){
            char c = s.charAt(i);

            if(c=='('){
                stack.push(i);
            }
            else if(c==')'){
                if(!stack.isEmpty()){
                    stack.pop();
                }
                else{
                    sb.setCharAt(i,'*');
                }
            }
        }
        while(!stack.isEmpty()){
            int idx = stack.pop();
            sb.setCharAt(idx,'*');
        }

        return sb.toString().replaceAll("\\*","");
    }
}

// solution 2
class Solution {
    public String minRemoveToMakeValid(String s) {

        // copy String s to StringBuilder sb
        StringBuilder sb = new StringBuilder(s);

        // stack will store the index of opening brackets "(,{,["
        Stack<Integer> stack = new Stack<>();

        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);

            if(c == '('){
                stack.push(i);
            } 

            // first we will validate closing brackets
            // we will check if for every closing bracket "),},]" there is an opening bracket "(,{,["
            else if(c==')'){
                if(!stack.isEmpty()){
                    stack.pop();
                }
                else{
                    // we will set invalid brackets to '*'
                    sb.setCharAt(i,'*');
                }
            }
        }
        // next we will validate the opening brackets
        // if the stack is still not empty, that means we have opening brackets which have no closing brackets
        while(!stack.isEmpty()){
            
            int idx = stack.pop();

             // we will set invalid brackets to '*'
            sb.setCharAt(idx,'*');
        }

        return sb.toString().replaceAll("\\*","");
    }
}
