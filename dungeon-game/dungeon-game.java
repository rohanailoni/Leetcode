class Solution {
    
    public int calculateMinimumHP(int[][] arr) {
        //top bottom approch 
    int[][] dp=new int[arr.length][arr[0].length];
        for(int[]r:dp)Arrays.fill(r,-1);
        //bottom down approach;
//         for(int i=0;i<arr.length;i++){
            
//             for(int j=0;j<arr[0].length;j++){
                
                
//                 if(i==0 && j==0){
                    
//                     dp[i][j]=arr[i][j]>0?1:Math.abs(arr[i][j])+1;
//                 }
//                 else if(i==0 && j!=0){
//                     dp[i][j]=dp[i][j-1]-arr[i][j];
//                 }else if(i!=0 && j==0){
//                     dp[i][j]=dp[i-1][j]-arr[i][j];
//                 }else{
//                     dp[i][j]=Math.min(dp[i-1][j],dp[i][j-1])-arr[i][j];
//                 }
//                 if(dp[i][j]<=0){
//                     dp[i][j]=1;
//                 }
//             }
//         }
//         //System.out.println(Arrays.deepToString(dp));
//         int n=dp[arr.length-1][arr[0].length-1];
//         if(n!=1){
//             return dp[arr.length-1][arr[0].length-1]+1;
//         }
//         return 1;
        return bfs(arr,dp,0,0);
    
    }
    
    private int bfs(int[][] arr,int[][] dp,int i,int j){
        if(i>=arr.length || j>=arr[0].length){
            return (int)1e9;
        }
        if(i==arr.length-1 && j==arr[0].length-1){
            return dp[i][j]=arr[i][j]>0?1:1+Math.abs(arr[i][j]);
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        
        
        int right=bfs(arr,dp,i,j+1);
        int left=bfs(arr,dp,i+1,j);
        int min1=Math.min(left,right)-arr[i][j];
        return dp[i][j]=min1>0?min1:1;
    }
}