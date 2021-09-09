class Solution {
    int[] dp;
    private int rec(int n){
        if(n==0 ){
            return 0;
        }
        else if(n==1){
            return 1;
        }
        if(dp[n]!=-1){
            return dp[n];
        }
        return dp[n]=rec(n-1)+rec(n-2);
        
    }
    
    public int fib(int n) {
        dp=new int[n+1];
        Arrays.fill(dp,-1);
        
        return rec(n);
        
    }
}