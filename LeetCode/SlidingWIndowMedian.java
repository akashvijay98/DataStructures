class Solution {
    PriorityQueue<Double> upper = new PriorityQueue<>();
    PriorityQueue<Double> lower = new PriorityQueue<>((x,y)->Double.compare(y,x));

    public double[] medianSlidingWindow(int[] nums, int k) {
        
        double[] res = new double[nums.length-k+1];

        int left =0;
        int idx = 0;
   

        for(int i=0;i<nums.length;i++){
            insertToHeap((double)nums[i]);

            if(i-left+1==k){
                res[idx] = findMedian();
                idx++;
                
                removeFromHeap((double) nums[left]);
                left++;
            }
        }

        return res;
    }

    private void insertToHeap(double num){
        if(lower.isEmpty() || num<lower.peek() ){
            lower.add(num);
        }
        else {
            upper.add(num);
        }
        rebalance();
    }

    private void removeFromHeap(double num){
        if(lower.contains(num)){
            lower.remove(num);
        }
        else {
            upper.remove(num);
        }
        rebalance();
    }

    private void rebalance(){
        if(lower.size()> upper.size()+1){
            upper.add(lower.remove());
        }
        else if(upper.size()>lower.size()){
            lower.add(upper.remove());
        }
    }

    private double findMedian(){
        if(lower.size()>upper.size()){
            return lower.peek();
        }
        else{
            return (lower.peek()+upper.peek())/2.0;
        }
    }
}
