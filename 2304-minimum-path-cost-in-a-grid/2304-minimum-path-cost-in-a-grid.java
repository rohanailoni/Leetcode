class Solution {
    int[][] grid;
    int[][] movecost;
    int n;
    int m;
    int[] dp;
    public int minPathCost(int[][] grid, int[][] moveCost) {
        this.grid=grid;
        this.n=grid.length;
        this.m=grid[0].length;
        this.movecost=moveCost;
        dp=new int[this.m*this.n];
        Arrays.fill(dp,-1);
        int min=Integer.MAX_VALUE;
        for(int i=0;i<m;i++){
            //int ff=dfs(0,i,movecost[grid[0][i]][i]);
            int ff=dfs(0,i,0);
            min=Math.min(min,ff);
            
                //System.out.println(ff);
            
        }
        //System.out.println(Arrays.toString(dp));
        return min;
    }
    public int dfs(int i,int j,int pathcost){
        if(i==n-1){
            return grid[i][j]+pathcost;
        }
        if(dp[grid[i][j]]!=-1){
            return pathcost+grid[i][j]+dp[grid[i][j]];
        }
        
        int min=Integer.MAX_VALUE;
        for(int k=0;k<m;k++){
            min=Math.min(min,dfs(i+1,k,movecost[grid[i][j]][k]));
        }
        //System.out.println(i+" "+j+" "+pathcost+" "+min);
        dp[grid[i][j]]=min;
        min=grid[i][j]+pathcost+min;
        
        return min;
    }
}