class Solution {
    public int maxWidthRamp(int[] nums) {
     Stack<Integer> stack = new Stack<>();

     int max= 0 ;

     for(int i=0;i<nums.length;i++){
        if(stack.isEmpty() || nums[i]<nums[stack.peek()]){
            stack.push(i);
        }
     }   

     for(int j=nums.length-1;j>=0;j--){
        while(!stack.isEmpty() && nums[j]>=nums[stack.peek()]){
            max = Math.max(max,j-stack.pop());
        }  
      }

      return max;

    }
}
