class Solution {
    List<String> result = new ArrayList<>();
    String digits;
    long target;

   
    public List<String> addOperators(String num, int target) {
        if(num.length() == 0){
            return new ArrayList<String>();
        }

        this.target = target;
        this.digits = num;
        this.result = new ArrayList<String>();

        backtrack(0,0,0,0, new ArrayList<String>());
        
        return result;
    }

    private void backtrack(int index, long prevOp, long curOp, long value, ArrayList<String> ops){

        String nums = this.digits;
       
        if(index == nums.length()){
            if(value==this.target && curOp == 0){
                StringBuilder sb = new StringBuilder();

                ops.subList(1,ops.size()).forEach(v -> sb.append(v));

                this.result.add(sb.toString());
            }
            return;
        }

        // no op
        curOp = curOp * 10 + Character.getNumericValue(nums.charAt(index));
        
        String cur_val_rep = Long.toString(curOp);
        int length = nums.length();


        if(curOp >0){
            backtrack(index+1,prevOp, curOp, value, ops);

        }

        ops.add("+");
        ops.add(cur_val_rep);

        backtrack(index+1, curOp, 0, value+curOp, ops);

        ops.remove(ops.size()-1);
        ops.remove(ops.size()-1);

        if(ops.size()>0){
            ops.add("-");
            ops.add(cur_val_rep);

            backtrack(index+1, -curOp, 0, value-curOp,ops);
 
            ops.remove(ops.size()-1);
            ops.remove(ops.size()-1);

            ops.add("*");
            ops.add(cur_val_rep);

            backtrack(index+1, curOp*prevOp, 0 , value-prevOp + (curOp*prevOp), ops);

            ops.remove(ops.size()-1);
            ops.remove(ops.size()-1);

        }

    }


}
