class Solution {
    private int[] dp;
    private int dfs(int n){
        for(int i=3;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2]+dp[i-3];
        }
        return dp[n];
    }
    
    
    
    
    
    public int tribonacci(int n) {
        if(n==1  || n==2){
            return 1;
        }
        if(n==0)return 0;
        dp=new int[n+1];
        Arrays.fill(dp,-1);
        dp[0]=0;
        dp[1]=1;
        dp[2]=1;
        
        
        
        return dfs(n);
    }
}