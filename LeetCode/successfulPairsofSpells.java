class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int[] res = new int[spells.length];
        Arrays.sort(potions);
        for(int i=0;i<spells.length;i++){
            int l=0, r=potions.length-1;

            int index = potions.length; // index is equal to potions length because if none of the produce of spells[i]*potions[mid] >= success, then in the end potions.length-index should be equal to 0 thats why.

            while(l<=r){
                int mid = (l+r)/2;

                if((long)potions[mid]*spells[i]>=success){
                    r=mid-1;
                    index=mid;

                }
                else if((long)potions[mid]*spells[i]<success){
                    l=mid+1;
                }

            }
            res[i]=potions.length-index;
        }
        return res;
    }
}
