class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int maxLen = 0;

        int n=s.length();

        for(int i=0;i<n;i++){
            char c = s.charAt(i);

            if(c == '('){
                stack.push(i);
            }
            else if(c==')'){
                stack.pop();
                if(stack.isEmpty()){
                    stack.push(i);
                }
                else{
                    int curLength = i-stack.peek();
                    maxLen = Math.max(curLength, maxLen);
                }
            }
        }
        return maxLen;
    }
}
