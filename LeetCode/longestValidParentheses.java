class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        String result = "";
        int mx =0;
        stack.push(-1);     
        for(int i=0;i<s.length();i++){

            char c= s.charAt(i);
            if (c =='(' ){
                stack.push(i);
            }
            else if(c == ')'){
                stack.pop();
                if(stack.isEmpty()){
                    stack.push(i);
                }
                else{
                    System.out.println("i=="+i);
                    System.out.println("diff =="+(i-stack.peek()));
                    mx = Math.max(mx, i-stack.peek());
                }

            }
           
        }
        return mx;
    }
}
