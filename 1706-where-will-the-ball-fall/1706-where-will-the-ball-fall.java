class Solution {
    public int[] findBall(int[][] grid) {
        int result[] = new int[grid[0].length];
        for(int i=0; i< result.length; i++){
            result[i] = placeball(0,i,grid);
        }

        return result;
    }
    
    public int placeball(int i, int j, int[][] grid){
        while(i< grid.length){
            if(grid[i][j] == 1 && j+1 < grid[0].length && grid[i][j+1] == 1){
                i = i + 1;
                j = j + 1;
            }else if(grid[i][j] == -1 && j-1 >= 0 && grid[i][j-1] == -1){
                i = i + 1;
                j = j - 1;
            }else{
                return -1;
            }
        }
        return j;
    }
}