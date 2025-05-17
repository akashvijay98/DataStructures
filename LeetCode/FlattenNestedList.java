/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {

    // the nestedList can either contain Integers like 1,2,3 or list of integers like[1,2,4]

    // we recursively add Integer elements to the result arrayList

    List<Integer> result = new ArrayList<>();
    int idx=0;

    public NestedIterator(List<NestedInteger> nestedList) {
        flatten(nestedList);
    }

    private void flatten(List<NestedInteger> nestedList){
        for(NestedInteger listItem : nestedList){
            if(listItem.isInteger()){
                result.add(listItem.getInteger());
            }
            else{
                flatten(listItem.getList());
            }
        }
    }

    @Override
    public Integer next() {
        return result.get(idx++);
    }

    @Override
    public boolean hasNext() {
        return idx<result.size();
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
