class Solution {
    public String largestNumber(int[] nums) {
        String[] numStrings = new String[nums.length];
        String str="";

        for(int i=0;i<nums.length;i++){
            numStrings[i] = String.valueOf(nums[i]);

        }

        Arrays.sort(numStrings, (n1,n2)->{
            String order1= n1+n2;
            String order2= n2+n1;
            return order2.compareTo(order1);
        });

        if(numStrings[0].equals("0")){
            return "0";

        }

        StringBuilder sb = new StringBuilder();
        for(String numString : numStrings){
            str+=numString;
        }

        return str;

    }
}
