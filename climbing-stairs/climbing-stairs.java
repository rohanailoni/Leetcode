class Solution {
    int n;
    int[] dp;
    private int dfs(int value){
        
        if(value==n){
            
            return 1;
        }
        if(value>n){
            return 0;
        }
        if(dp[value]!=-1){
            return dp[value];
        }
        
        
        
        int l=dfs(value+1);
        int r=dfs(value+2);
        
        return dp[value]=l+r;
        
        
    }
    
    
    public int climbStairs(int n) {
        this.n=n;
        dp=new int[n];
        Arrays.fill(dp,-1);
        int ans=dfs(0);
        return ans;
        
    }
}