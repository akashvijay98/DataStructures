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

/** Time complexity:

O((m+n)⋅log⁡n)O((m + n) \cdot \log n)O((m+n)⋅logn)

In each popSmallest() method call, in the worst case, we will need to remove a number from the hash set which will take O(1)O(1)O(1) time, and the top of the min-heap which will take O(log⁡n)O(\log n)O(logn) time. Thus, for mmm calls it will take O(m⋅log⁡n)O(m \cdot \log n)O(m⋅logn) time.

In each addBack(num) method call, we might push num in the hash set which will take O(1)O(1)O(1) time and min-heap which will take O(log⁡n)O(\log n)O(logn) time. Thus, for nnn calls it will take O(n⋅log⁡n)O(n \cdot \log n)O(n⋅logn) time.

Space complexity:

O(n)O(n)O(n)

In the worst case, we might add nnn elements in the hash set and the min-heap. Thus, it will take O(n)O(n)O(n) space.
*/
