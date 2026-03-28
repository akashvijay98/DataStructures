// maintain the stack in increasing order
// if a number is greater than the top of the stack, pop the element, map it with the number(next greater element) and then push this number to the stack
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        HashMap<Integer,Integer> map = new HashMap<>();

        int[] res = new int[nums1.length];
        int idx=0;
        
        for(int num:nums2){
            if(!stack.isEmpty()){
                while(!stack.isEmpty() && num>stack.peek()){
                    int n = stack.pop();
                    map.put(n, num);
                }
               
            }
            stack.push(num);
        }

        for(int element : nums1){
            if(map.containsKey(element)){
                res[idx++] = map.get(element);
            }
            else{
                res[idx++] = -1;
            }
        }
        
        return res;
    }
}
