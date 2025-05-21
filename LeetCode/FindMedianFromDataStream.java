class MedianFinder {
    PriorityQueue<Integer> lower;
    PriorityQueue<Integer> upper;
    public MedianFinder() {
        lower = new PriorityQueue<>((a,b)-> b-a);
        upper = new PriorityQueue<>();

    }
    
    public void addNum(int num) {

        // if number lower than lower.top, we add number to lower
        if(lower.isEmpty() || num<=lower.peek()){
            lower.add(num);
        }        
        else{
            upper.add(num);
        }

        // lower can have +1 element more than upper
        // if upper size is more, then we need to rebalance the heaps.
        if(lower.size()>upper.size()+1){
            upper.add(lower.poll());
        }
        else if(upper.size()>lower.size()){
            lower.add(upper.poll());
        }
    }
    
    public double findMedian() {
        if(lower.size()==upper.size()){
            return (lower.peek()+upper.peek())/2.0;
        }
        else{
            return lower.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.
 +++++++++++++++++++++++++++++++addNum(num);
 * double param_2 = obj.findMedian();
 */
