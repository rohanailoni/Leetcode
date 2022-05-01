class Solution {
    char [][] grid;
    public int numIslands(char[][] grid) {
        this.grid=grid;
        int count=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1'){
                    dfs(i,j);
                    count++;
                }
            }
        }
        return count;
    }
    private void dfs(int i,int j){
        if(i<0 || j<0 || i>grid.length-1 ||j>grid[0].length-1 || grid[i][j] != '1')return;
        
        grid[i][j]='0';
        dfs(i+1,j);
        dfs(i,j+1);
        dfs(i-1,j);
        dfs(i,j-1);
        return;
    }
}