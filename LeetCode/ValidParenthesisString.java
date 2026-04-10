class Solution {
    public boolean checkValidString(String s) {
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> ashStack = new Stack<>();

        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);

            if(c=='('){
                stack.push(i);
            }
            else if(c=='*'){
                ashStack.push(i);
            }
            else{
                if(!stack.isEmpty()){
                    stack.pop();
                }
                else if(!ashStack.isEmpty()){
                    ashStack.pop();
                }
                else{
                    return false;
                }
            }
        }

        while(!stack.isEmpty()){
            if(ashStack.isEmpty() || ashStack.pop()<stack.pop()){
                return false;
            }
            
        }

        return true;
    }
}
