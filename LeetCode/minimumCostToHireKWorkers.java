class Solution {
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int n= quality.length;
        double totalCost = Double.MAX_VALUE;
        double currentTotalQuality = 0;

        List<Pair<Double,Integer>> wageToQualityRatio = new ArrayList<>();

        for(int i=0;i<n;i++){
            wageToQualityRatio.add(new Pair<>((double) wage[i]/quality[i],quality[i]));
        }
        Collections.sort(wageToQualityRatio, Comparator.comparingDouble(Pair::getKey));

        PriorityQueue<Integer> workers = new PriorityQueue<>(Collections.reverseOrder());

        for(int i =0;i<n;i++){
            workers.add(wageToQualityRatio.get(i).getValue());
            currentTotalQuality += wageToQualityRatio.get(i).getValue();

            if(workers.size()>k){
                currentTotalQuality -= workers.poll();
                
            }

            if(workers.size()==k){
                totalCost = Math.min(totalCost,currentTotalQuality* wageToQualityRatio.get(i).getKey());
            }

            
        }
        return totalCost;
    }
}
