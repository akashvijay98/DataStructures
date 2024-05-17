class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for(int i=0;i<tokens.length;i++){
            if(tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals("*") || tokens[i].equals("/")){
                stack.add(calc(stack.pop(),stack.pop(),tokens[i]));
            }
            else{
                stack.add(Integer.parseInt(tokens[i]));
            }
            
        }
        return stack.pop();
    }

    public int calc(int arg1, int arg2,String operator){
        if(operator.equals("+")) return arg1+arg2;
        else if(operator.equals("-")) return arg2-arg1;
        else if(operator.equals("*")) return arg1*arg2;
        else  return arg2/arg1;

    }
    
}
