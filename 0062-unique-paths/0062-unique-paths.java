class Solution {
    private int m,n;
    int[][] dp;
    private int dfs(int i,int j){
        if(i>=m || j>=n){
            return 0;
        }
        
        if(i==m-1 && j==n-1){
            return 1;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        
        int left=dfs(i,j+1);
        int down=dfs(i+1,j);
        
        
        return dp[i][j]=left+down;
        
        
        
    }
    
    
    
    public int uniquePaths(int m, int n) {
        dp=new int[m][n];
        for(int[]r:dp){Arrays.fill(r,-1);}
        
        
        this.m=m;
        this.n=n;
        return dfs(0,0);
        
        
    }
}