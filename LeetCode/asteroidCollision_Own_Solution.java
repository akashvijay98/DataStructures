class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> astStack = new Stack<>();
        List<Integer> items = new ArrayList<>();

        int topMostSign=1;
        int count = 0;
        int equalFlag=0;
        int diff = 0;


        for(int item : asteroids){
            
            while(astStack.size() !=0 && item<0 && astStack.peek()>0){
                diff = astStack.peek()-Math.abs(item);

                if(diff >0){
                    break;
                }
                else if(diff<0){
                    astStack.pop();
                }
                else if((diff==0 && item<0 && astStack.peek()>0)){
                System.out.println("item"+item);
                System.out.println("stakctop"+astStack.peek());

                    astStack.pop();
                    System.out.println("stak size"+astStack.size());

                    equalFlag = 1;
                    break;
                }   
                     

            }
            
            if((equalFlag == 0 && diff<0)  || astStack.size()==0 && equalFlag==0 || item>0 || (astStack.size()>0 && astStack.peek()<0 && item<0 && equalFlag==0 )){
                astStack.push(item);
               
            }
            if(equalFlag==1){
                equalFlag = 0;
            }
            
                   
     
        }
        int[] res = new int[astStack.size()];
          int i = astStack.size() - 1;
       
        while(!astStack.isEmpty()) {
            res[i--] = astStack.pop();
        }
        return res;
    }
       
}
