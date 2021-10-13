class Solution {
    int[][] dp;
    private int dfs(int i,int j){
        
        if(i>=j){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int ans=(int)1e9;
        
        for(int k=i;k<=j;k++){
            int a1=0;
            int a2=k+dfs(i,k-1);
            int a3=k+dfs(k+1,j);
            ans=Math.min(ans,Math.max(a1,Math.max(a2,a3)));
            
            
            
        }
        
        return dp[i][j]=ans;
        
        
    }
    
    
    
    
    public int getMoneyAmount(int n) {
        dp=new int[n+1][n+1];
        for(int[] r:dp)Arrays.fill(r,-1);
        
        return dfs(0,n);
    }
}