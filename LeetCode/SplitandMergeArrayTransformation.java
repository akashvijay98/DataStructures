class Solution {
    public int minSplitMerge(int[] nums1, int[] nums2) {

        Queue<List<Integer>> q = new LinkedList<>();
        Set<List<Integer>> set = new HashSet<>();

        int n =nums1.length;

        List<Integer> n1 = new ArrayList<>();
        List<Integer> n2= new ArrayList<>();
        for(int num:nums1) n1.add(num);
        for(int num:nums2) n2.add(num);

        if(n1.equals(n2)) return 0;

        q.add(n1);
        set.add(n1);

        int count = 0;

        while(!q.isEmpty()){
            int level = q.size();


            for(int l = 0;l<level;l++){

                 List<Integer> currentState = q.poll();
                for(int L=0;L<nums1.length;L++){
                       
                        for(int R=L;R<nums1.length;R++){
                                List<Integer> subListToMove = new ArrayList<>(currentState.subList(L,R+1));

                                List<Integer> left  = new ArrayList<>(currentState.subList(0,L));

                                List<Integer> right = new ArrayList<>(currentState.subList(R+1,n));

                                List<Integer> newList = new ArrayList<>(left);

                                newList.addAll(right);

                                for(int idx = 0;idx<=newList.size();idx++){
                                    if(idx==L) continue;

                                    List<Integer> finalList = new ArrayList<>(newList);

                                    finalList.addAll(idx, subListToMove);

                                    if(finalList.equals(n2)){
                                        return count+1;
                                    }

                                    if(!set.contains(finalList)){
                                        set.add(finalList);
                                        q.offer(finalList);
                                    }
                                }



                                
                        }
                    }
                }
                count++;

            }
            
        return -1;
        }
        
               
    

        
}
