class Solution {
    class orange{
        int x;
        int y;
        int time;
        orange(int x,int y,int time){
            this.x=x;
            this.y=y;
            this.time=time;
        }
    }
    Queue<orange>q;
    
    int max=-(int)1e9;
    private boolean check(int[][] grid){
        int k=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==0){
                    k++;
                }
            }
        }
        if(k==grid.length*grid[0].length){
            return true;
        }
        return false;
    }
    public int orangesRotting(int[][] grid) {
        int[][] dir={{0,1},{1,0},{-1,0},{0,-1}};
        q=new LinkedList<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==2){
                    q.add(new orange(i,j,0));
                    grid[i][j]=0;
                }
            }
        }
        while(!q.isEmpty()){
            orange or=q.poll();
            for(int i=0;i<4;i++){
                int x=or.x+dir[i][0];
                int y=or.y+dir[i][1];
                if(x>=0 && y>=0 && x<grid.length && y<grid[0].length){
                    if(grid[x][y]==1){
                        System.out.println(or.time+1+" "+x+" "+y);
                        q.add(new orange(x,y,or.time+1));
                        grid[x][y]=0;
                        
                        max=Math.max(max,or.time+1);
                    }
                }
            }
        }
        System.out.println(Arrays.deepToString(grid));
        if(check(grid)){
            return max==-(int)1e9?0:max;
        }
        return -1;
        
    }
}