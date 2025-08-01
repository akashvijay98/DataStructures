class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        int m= nums1.length;
        int n=nums2.length;

        for(int i=0;i<m;i++){
            set.add(nums1[i]);
        }

        for(int j=0;j<n;j++){
            if(set.contains(nums2[j])){
                list.add(nums2[j]);
                set.remove(nums2[j]);
            }
        }
  
        int[] res = new int[list.size()];
         for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }

        return res;
    }
}
