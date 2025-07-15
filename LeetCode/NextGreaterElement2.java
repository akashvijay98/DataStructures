class Solution {

    // always the next immediately greater element to i'th element will be on top of the stack
    // we start from right to left
    // suppose arr = [6,8,10], then when i = 0, stack will be [8,10]
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack = new Stack<>();

        int n= nums.length;
        int[] res = new int[n];

        for(int i=2*n-1;i>=0;i--){
            while(!stack.isEmpty() && nums[stack.peek()]<=nums[i%n]){
                stack.pop();
            }
            
            if(stack.isEmpty()){
                res[i%n]=-1;
            }
            else{
                res[i%n]= nums[stack.peek()];
            }

            stack.push(i%n);
        }

        return res;
    }
}
