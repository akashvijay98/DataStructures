class Solution {
    public int fib(int n) {
        int[] result = new int[n+1];
        if(n<=1){
            return n;
        }

        result[0]=0;
        result[1]=1;

        for(int i=2;i<=n;i++){
            result[i]= result[i-1]+ result[i-2];

        }
        return result[n];
    }
}
