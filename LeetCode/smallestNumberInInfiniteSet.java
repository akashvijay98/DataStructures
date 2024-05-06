class SmallestInfiniteSet {

    // initialize hashset and priority queue
    private PriorityQueue<Integer> pq = null;
    private HashSet<Integer> set = null;

    public SmallestInfiniteSet() {
        pq = new PriorityQueue<>(1000);
        set = new HashSet<>(1000);

        //add values from 1 - 1000 to the priority queue
        for(int i=1;i<=1000;i++){
            set.add(i);
            pq.add(i);
        }
    }

    // remove the smallest element from the queue
    public int popSmallest() {
        int x = pq.poll();
        set.remove(x);
        return x;
        
    }

  //add num to the priority queue (priority queue can contain duplicates so check if num is present in the set before adding to  pq ) 
    public void addBack(int num) {
        if(!set.contains(num)){
            set.add(num);
            pq.add(num);   
        }
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */
