class Solution {
    public int maxSumDistinctTriplet(int[] x, int[] y) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0;i<x.length;i++){
            // since array can have duplicate values, we are mapping x[i] with the largest y[i] value
            map.put(x[i], Math.max(map.getOrDefault(x[i],0),y[i]));

        }

        if(map.size()<3){
            return -1;
        }

        List<Integer> topYValues = new ArrayList<>(map.values());

        topYValues.sort((a,b)-> b-a);

        return topYValues.get(0) + topYValues.get(1) + topYValues.get(2);
    }
}
