class Solution {
    private int n;
    private int[][]dp;
    public int minFallingPathSum(int[][] grid) {
        n=grid.length;
        //as it a square array;
        dp=new int[n][n];
        for(int[] r:dp)Arrays.fill(r,-1);
        
        int min=(int)1e9;
        
        for(int l=0;l<n;l++){
            min=Math.min(min,dfs(grid,0,l));
        }
        
        return min;
    }
    private int dfs(int[][] grid,int i,int j){
        
        
        if(i==n-1){
            
            return grid[i][j];
        }
        if(dp[i][j]!=-1)return dp[i][j];
       
        int min=(int)1e9;
        for(int k=0;k<n;k++){
            if(k==j){continue;}
            else{
                
                
                min=Math.min(min,grid[i][j]+dfs(grid,i+1,k));
            }
        }
        
        return dp[i][j]=min;
        
        
        
        
        
    }
    
    
    
}