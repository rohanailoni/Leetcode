// class Solution {
//     int[]dir;
//     int[][] grid;
//     int m;
//     int n;
//     int k;
//     int ans;
//     boolean[][] visited;
//     public int numberOfPaths(int[][] grid, int k) {
//         // this.dir={ {1,0},{-1,0},{0,1},{0,-1}};
//         dir=new int[5];
//         dir[0]=0;
//         dir[1]=1;
//         dir[2]=0;
//         dir[3]=-1;
//         dir[4]=0;
        
//         this.grid=grid;
//         m=grid.length;
//         n=grid[0].length;
//         visited=new boolean[m][n];
//         this.k=k;
//         ans=0;
//         dfs(0,0,0);
//         return ans;
    
    
//     }
//     public void dfs(int i,int j,int sum){
        
//         if(i>m-1 && j>n-1){
//             return;
//         }
//         if(i==m-1 && j==n-1){
//             System.out.println(sum);
//             sum+=grid[i][j];
//             if(sum%k==0){
//                 ans+=1;
//             }
//             return;
//         }
//         visited[i][j]=true;
//         for(int k=0;k<4;k++){
//             int x=i+dir[k];
//             int y=j+dir[k+1];
//             //System.out.println(x+" "+y);
//             if(x>=0 && y>=0 && x<m && y<n && visited[x][y]==false){
//                 dfs(x,y,sum+grid[i][j]);
//             }
//         }
//         visited[i][j]=false;
//         return;
        
        
        
//     }
// }
class Solution {
    public int numberOfPaths(int[][] grid, int k) {
        int m=grid.length, n=grid[0].length, MOD=1000000007;
		
		// dp[i][j][X] stores the number of paths to (i, j) that has a sum mod k equals to X;
        int[][][] dp = new int[m][n][k];
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(i==0&&j==0) {
                    dp[i][j][grid[i][j]%k] = 1;
                } else {
                    if(i>0) {
                        for(int x=0;x<k;x++)
                            dp[i][j][(x+grid[i][j]%k)%k] = (dp[i][j][(x+grid[i][j]%k)%k]%MOD + dp[i-1][j][x]%MOD)%MOD;
                    }
                    if(j>0) {
                        for(int x=0;x<k;x++)
                            dp[i][j][(x+grid[i][j]%k)%k] = (dp[i][j][(x+grid[i][j]%k)%k]%MOD + dp[i][j-1][x]%MOD)%MOD;
                    }
                }
            }
        }
        return dp[m-1][n-1][0]%MOD;
    }
}