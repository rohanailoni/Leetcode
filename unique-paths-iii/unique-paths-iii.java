
class Solution {
    int[][] grid;
    int m,n;
    int obs;
    int ans;
    int[][] direction={{1,0},{0,1},{0,-1},{-1,0}};
    private boolean check(){
        int s=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==100){
                    s++;
                }
            }
        }   
        //System.out.println(s);
        if(s==m*n-obs-1){
            return true;
        }return false;
    }
    private void dfs(int i,int j){
        if(grid[i][j]==2){
            //System.out.println(Arrays.deepToString(grid)+"in a position");
            if(check()){
                ans++;
            }   
            
            return;
        }
        int x,y;
        //System.out.println(Arrays.deepToString(grid));
        for(int[]k:direction){
            x=i+k[0];
            y=j+k[1];
            //System.out.println(x+" "+y+" "+m+" "+n);
            if(x<0 || y<0 || x>=m || y>=n){
                continue;
            }
            
            if(grid[x][y]==0 || grid[x][y]==2){
                
                grid[i][j]=100;
                dfs(x,y);
                grid[i][j]=0;
            }
            
        }
        return;
        
        
        
    }
    public int uniquePathsIII(int[][] grid) {
        this.ans=0;
        this.grid=grid;
        m=grid.length;
        n=grid[0].length;
        int[] start=new int[2];
        int[] end=new int[2];
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    start[0]=i;
                    start[1]=j;
                }else if(grid[i][j]==2){
                    end[0]=i;
                    end[1]=j;
                }else if(grid[i][j]==-1){
                    this.obs++;
                }
            }
        }
        dfs(start[0],start[1]);
        return ans;
    }
}

