class Solution {
    int[][] dp;
    private  int bfs(int[][] grid,int r,int c,int sum){
        
        
        
        if(r==grid.length-1 && c==grid[0].length-1){
            return sum+grid[r][c];
        }
        if(r>grid.length ||c>grid[0].length){
            return (int)1e9;
        }
        // if(dp[r][c]!=-1){
        //     return dp[r][c];
        // }
            
        int left=(int)1e9;
        int right=(int)1e9;
        
            
        if(r+1<grid.length){
            left=bfs(grid,r+1,c,sum+grid[r][c]);
        }
        if(c+1<grid[0].length){
            right=bfs(grid,r,c+1,sum+grid[r][c]);
        }
        dp[r][c]=(int)Math.min(left,right);
        //System.out.println(dp[r][c]);
        return dp[r][c];
        
    }
    
    
    public int minPathSum(int[][] grid) {
        
        dp=new int[grid.length][grid[0].length];
        
        for(int[]r:dp)Arrays.fill(r,-1);
        //bfs(grid,0,0,0) this is recurisve solution which causes stackoverflow
        for(int i=0;i<grid.length;i++){
            
            for(int j=0;j<grid[0].length;j++){
                
                if(j==0 && i==0)dp[i][j]=grid[i][j];
                
                else if(i==0 &&j!=0)dp[i][j]=dp[i][j-1]+grid[i][j];
                
                else if(j==0 && i!=0)dp[i][j]=dp[i-1][j]+grid[i][j];
                
                else{
                    dp[i][j]=grid[i][j]+Math.min(dp[i][j-1],dp[i-1][j]);
                }
                
                
                
                
            }
            
            
            
        }
        
        System.out.println(Arrays.deepToString(dp));
        return dp[grid.length-1][grid[0].length-1];
        
    }
}