class Solution {
      PriorityQueue<Double> lower = new PriorityQueue<>((a,b)->Double.compare(b,a));
        PriorityQueue<Double> upper = new PriorityQueue<>();
    public double[] medianSlidingWindow(int[] nums, int k) {
        int left=0;
        int idx= 0;

          int n = nums.length;
        double[] result = new double[n - k + 1];
        
      
        for(int i=0;i<nums.length;i++){
            if(i-left+1>k){
                removeFromHeap((double)nums[left++]);
            }

            insert((double)nums[i]);

            if(i-left+1==k){
                result[idx++] = findMedian();
            }


        }

        return result;
    }

    private void insert(double num){
        if(lower.isEmpty() || num<=lower.peek()){
            lower.add(num);
        }
        else {
            upper.add(num);
        }

        balance();
    }


    public void balance(){
        if(lower.size()>upper.size()+1){
            upper.add(lower.poll());
        }
        else if(upper.size()>lower.size()){
            lower.add(upper.poll());
        }
    }

    private void removeFromHeap(double num){
        if(num<=lower.peek()){
            lower.remove(num);
        }
        else {
            upper.remove(num);
        }

        balance();
    }

    private double findMedian(){
        if(lower.size() == upper.size()){
            return ((double) upper.peek()+(double)lower.peek())/2.0;
        }
        else{
            return lower.peek();
        }
    }
}
