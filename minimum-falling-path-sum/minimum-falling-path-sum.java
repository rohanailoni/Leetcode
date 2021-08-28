class Solution {
    int[][]dp;
    public int minFallingPathSum(int[][] matrix) {
        dp=new int[matrix.length][matrix[0].length];
        int min=(int)1e9;
        for(int[]r:dp)Arrays.fill(r,-1);
        for(int i=0;i<matrix.length;i++){
            
            min=Math.min(min,dfs(matrix,0,i));
            
            
        }
        
        
        
        
        return min;
    }
    
    //taking i and j it is a location for element in the matrix;
    private int dfs(int[][] matrix,int i,int j){
        
        if(i>=matrix.length || j>=matrix[0].length || j<0){
            return (int)1e9;
        }
        
        
        
        if(i==matrix.length-1){
            return matrix[i][j];
        }
        
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        
        
        
        int dial=matrix[i][j]+dfs(matrix,i+1,j-1);
        int diar=matrix[i][j]+dfs(matrix,i+1,j+1);
        int down=matrix[i][j]+dfs(matrix,i+1,j);
        
        
        int n=Math.min(Math.min(dial,diar),down);
        
        dp[i][j]=n;
        
        return n;
        
        
        
        
        
    }
    
    
    
}