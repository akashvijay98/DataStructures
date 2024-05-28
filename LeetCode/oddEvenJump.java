class Solution {
    public int oddEvenJumps(int[] arr) {
        int n = arr.length;
        boolean[] oddJump = new boolean[n];
        boolean[] evenJump = new boolean[n];

        oddJump[n-1]=true;
        evenJump[n-1]=true;

        TreeMap<Integer,Integer> treeMap = new TreeMap<>();

        treeMap.put(arr[n-1],n-1);

        for(int i = n-2;i>=0;i--){
            //Odd Jump
            Integer oddNextIndex = treeMap.ceilingKey(arr[i]);
            if(oddNextIndex !=null){
                oddJump[i] = evenJump[treeMap.get(oddNextIndex)];
            }

            //Even Jump
            Integer evenNextIndex = treeMap.floorKey(arr[i]);
            if(evenNextIndex != null){
                evenJump[i] = oddJump[treeMap.get(evenNextIndex)];
            }

            treeMap.put(arr[i],i);
        }

        int count = 0;
        for(boolean canReach : oddJump){
            if(canReach){
                count++;
            }
        }
        return count;
    }
}
