class Solution {
    public void setZeroes(int[][] matrix) {
        int[] arri=new int[matrix.length];
        int[] arrj =new int[matrix[0].length];
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
               if(matrix[i][j]==0){
                   arri[i]=1;
                   arrj[j]=1;
               }
            }
        }
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
               if(arri[i]==1 || arrj[j]==1){
                   matrix[i][j]=0;
               }
            }
        }
        
    }
}