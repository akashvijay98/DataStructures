class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Stack<Integer> stack = new Stack<>();
        boolean[] res = new boolean[rooms.size()];

        stack.push(0);
        res[0]=true;
        while(!stack.isEmpty()){

            int node = stack.pop();
            for(Integer item : rooms.get(node) ){
                if(!res[item]){
                    res[item] = true;
                    stack.push(item);
                }
               
            }


        }

        for(boolean val : res){
            if(val==false){
                return false;
            }
        }
        return true;
    }
}
