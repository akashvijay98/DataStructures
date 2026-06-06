//645. Set Mismatch
public int[] findErrorNums(int[] nums) {
        int[] res = new int[2];
        for(int i=0;i<nums.length;i++){

            int idx = Math.abs(nums[i])-1;

            if(nums[idx]<0){
                res[0]=idx+1;
            }
            else{
                nums[idx]=-nums[idx];
            }
            
        }

        for(int i=0;i<nums.length;i++){
            if(nums[i]>0){
                res[1]=i+1;
            }
        }

        return res;
    }
